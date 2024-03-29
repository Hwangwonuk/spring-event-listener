/*
 * Created by Wonuk Hwang on 2023/03/21
 * As part of Bigin
 *
 * Copyright (C) Bigin (https://bigin.io/main) - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by infra Team <wonuk_hwang@bigin.io>, 2023/03/21
 */
package com.example.eventlistener.api.v1;

import com.example.eventlistener.application.WalletService;
import com.example.eventlistener.dto.WalletChargeDto;
import com.example.eventlistener.dto.WalletCreationDto;
import com.example.eventlistener.dto.WalletDeductDto;
import com.example.eventlistener.dto.WalletRefundDto;
import com.example.eventlistener.dto.response.WalletResponse;
import com.example.eventlistener.dto.request.WalletChargeRequest;
import com.example.eventlistener.dto.request.WalletCreationRequest;
import com.example.eventlistener.dto.request.WalletDeductRequest;
import com.example.eventlistener.dto.request.WalletRefundRequest;
import com.example.eventlistener.event.DeductEvent;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create on 2023/03/21. create by IntelliJ IDEA.
 *
 * <p> Api related with wallet </p>
 * <p> {@link com.example.eventlistener.application.WalletService}</p> *
 *
 * @author wonukHwang
 * @version 1.0
 * @see
 * @since (ex : 5 + 5)
 */
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("v1/wallet")
public class WalletApi {

  private final WalletService walletService;
  private final ApplicationEventPublisher applicationEventPublisher;

  /**
   * <p> Call when user create new project. </p>
   * <p> Maybe marketing credit is always 0 now, but when policy will be changed it might be
   * needed.</p>
   *
   * @param request wallet essential data to create wallet.
   * @return ResponseCommonEntity with saved Wallet info.
   * @see WalletCreationRequest
   */
  @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
  public WalletResponse create(@Valid @RequestBody WalletCreationRequest request) {
    final WalletResponse walletResponse = walletService.create(WalletCreationDto.from(request));
    log.info("created wallet : {}", walletResponse);

    return walletResponse;
  }

  /**
   * company ID로 wallet을 조회
   * @param companyId 회사 ID
   * @return WalletResponse;
   */
  @GetMapping("/{companyId}")
  public WalletResponse getWallet(@PathVariable Long companyId) {
    log.info("wallet companyId : {}", companyId);
    final WalletResponse walletResponse = walletService.findWalletByCompanyIdOrElseThrow(companyId);
    return walletResponse;
  }

  /**
   * charge point(credit).
   *
   * @param chargeRequest
   * @return
   */
  @PostMapping("/charge")
  public WalletResponse charge(@Valid @RequestBody WalletChargeRequest chargeRequest) {
    log.info("chargeRequest : {}", chargeRequest);
    final WalletResponse walletResponse = walletService.charge(WalletChargeDto.from(chargeRequest));
    return walletResponse;
  }

  /**
   * 환불 하다.
   * @param refundRequest
   * @return
   */
  @PostMapping("/refund")
  public WalletResponse refund(@Valid @RequestBody WalletRefundRequest refundRequest) {
    log.info("refund data : {}", refundRequest);
    final WalletResponse walletResponse = walletService.refund(WalletRefundDto.from(refundRequest));
    return walletResponse;
  }

  /**
   * 차감 하다.
   *
   * @param request
   */
  @PostMapping("/deduct")
  public void deduct(@Valid @RequestBody WalletDeductRequest request) {
    log.info("deductDto data : {}", request);
    // deductDto -> DeductEvent converting
    DeductEvent deductEvent = new DeductEvent(this, WalletDeductDto.from(request));
    // Event -> publisher -> listener
    // publish 까지는 동기식으로 동작
    applicationEventPublisher.publishEvent(deductEvent);
  }

}
