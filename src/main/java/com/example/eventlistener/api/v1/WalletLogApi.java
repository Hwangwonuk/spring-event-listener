/*
 * Created by Wonuk Hwang on 2023/04/08
 * As part of Bigin
 *
 * Copyright (C) Bigin (https://bigin.io/main) - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by infra Team <wonuk_hwang@bigin.io>, 2023/04/08
 */
package com.example.eventlistener.api.v1;

import com.example.eventlistener.application.WalletLogService;
import com.example.eventlistener.dto.request.WalletLogCreationRequest;
import com.example.eventlistener.dto.WalletLogCreationDto;
import com.example.eventlistener.dto.response.WalletLogResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * create on 2023/04/08. create by IntelliJ IDEA.
 *
 * <p> Api related with wallet_log and wallet_used_log </p>
 * <p> {@link com.example.eventlistener.model.WalletLog} and {@link com.example.eventlistener.model.WalletUsedLog} </p> *
 *
 * @author wonukHwang
 * @version 1.0
 * @see
 * @since (ex : 5 + 5)
 */

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/wallet_log")
public class WalletLogApi {

  private final WalletLogService walletLogService;

  /**
   * find WalletLog by companyId
   * @param companyId 회사 아이디.
   * @param limit
   * @param offset
   * @return
   */
  @GetMapping("/{companyId}")
  public WalletLogResponse findWalletLogByCompanyIdWithPaging(
      @PathVariable Long companyId,
      @RequestParam @Min(value = 1, message = "\"limit\" must be greater than or equal to 1.") Long limit,
      @RequestParam @Min(value = 0, message = "\"offset\" must be greater than or equal to 0.") Long offset
  ) {
    WalletLogResponse walletLogResponse =
        walletLogService.findWalletLogByCompanyId(companyId, limit, offset);
    
    return walletLogResponse;
  }

  /**
   * WalletLog를 생성한다.
   * @param
   * @return
   */
  @PostMapping
  public void createWalletLog(@Valid @RequestBody WalletLogCreationRequest request) {
    WalletLogCreationDto dto = WalletLogCreationDto.from(request);
    walletLogService.createWalletLog(
        dto.getCompanyId(),
        dto.getServiceId(),
        dto.getServiceType(),
        dto.getProcessType(),
        dto.getCreditType(),
        dto.getAmount(),
        dto.getUnitPrice(),
        dto.getDescription()
    );

    //TODO : response code, message
  }

}
