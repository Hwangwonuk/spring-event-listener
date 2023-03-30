/*
 * Created by Wonuk Hwang on 2023/03/21
 * As part of Bigin
 *
 * Copyright (C) Bigin (https://bigin.io/main) - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by infra Team <wonuk_hwang@bigin.io>, 2023/03/21
 */
package com.example.eventlistener.application;

import com.example.eventlistener.dao.WalletLogRepository;
import com.example.eventlistener.dao.WalletRepository;
import com.example.eventlistener.dto.WalletChargeDto;
import com.example.eventlistener.dto.WalletCreationDto;
import com.example.eventlistener.dto.WalletDeductDto;
import com.example.eventlistener.dto.WalletRefundDto;
import com.example.eventlistener.dto.WalletResponse;
import com.example.eventlistener.model.ProcessType;
import com.example.eventlistener.model.Wallet;
import com.example.eventlistener.model.WalletLog;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * create on 2023/03/21. create by IntelliJ IDEA.
 *
 * <p> Wallet Service </p>
 * <p> {@link com.example.eventlistener.api.v1.WalletApi}
 * and {@link com.example.eventlistener.model.Wallet} and
 * {@link com.example.eventlistener.model.WalletLog} and
 * {@link com.example.eventlistener.model.WalletUsedLog}
 * </p> *
 *
 * @author wonukHwang
 * @version 1.0
 * @see
 * @since (ex : 5 + 5)
 */

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class WalletService {

  private final WalletRepository walletRepository;
  private final WalletLogRepository walletLogRepository;

  /**
   * <p> create wallet.</p>
   *
   * @param walletCreationDto wallet essential data to create wallet.
   * @return saved Wallet info.
   */
  @Transactional
  public WalletResponse create(@NonNull WalletCreationDto walletCreationDto) {
    Wallet savedWallet = walletRepository.save(walletCreationDto.toEntity());
    return new WalletResponse(savedWallet);
  }

  /**
   * 회사 ID로 wallet을 조회
   *
   * @param companyId 회사 ID
   * @return WalletResponse
   */
  public WalletResponse findWalletByCompanyIdOrElseThrow(Long companyId) {
    Wallet wallet = walletRepository.findWalletByCompanyIdOrElseThrow(companyId);
    return new WalletResponse(wallet);
  }

  /**
   * charge credit. - cash - point
   *
   * @param walletChargeDto {@link WalletChargeDto}
   */
  @Transactional
  public WalletResponse charge(@NonNull WalletChargeDto walletChargeDto) {
    Wallet wallet = walletRepository.findWalletByCompanyIdOrElseThrow(
        walletChargeDto.getCompanyId());
    wallet.charge(walletChargeDto);

    return new WalletResponse(wallet);
  }

  /**
   * refund by walletLogId
   *
   * @param refundDto
   */
  @Transactional
  public WalletResponse refund(WalletRefundDto refundDto) {
    final Long companyId = refundDto.getCompanyId();
    final Long refundWalletLogId = refundDto.getRefundWalletLogId();

    final Wallet wallet = walletRepository.findWalletByCompanyIdOrElseThrow(companyId);

    final WalletLog walletLog = walletLogRepository.findByIdOrElseThrow(refundWalletLogId);

    wallet.refund(walletLog, refundDto);

    return null;
  }

  /**
   * deduct credit by one. it just call {@link WalletService#deduct(List)}
   *
   * @param walletDeductDto
   * @see WalletService#deduct(com.example.eventlistener.dto.WalletDeductDto)
   */
  @Transactional
  public void deduct(@NonNull WalletDeductDto walletDeductDto) {
    deduct(List.of(walletDeductDto));
  }

  /**
   * deduct credit by many. if there is same key(date(yyyymmdd), wallet id, service type, process
   * type), it will be merged.
   *
   * @param deductDtos array of deduct info.
   * @see WalletDeductDto
   */
  @Transactional
  public void deduct(@NonNull List<WalletDeductDto> deductDtos) {
    deductDtos.forEach(
        dto -> {
          final Wallet wallet = walletRepository.findWalletByCompanyIdOrElseThrow(
              dto.getCompanyId());

//          wallet.deduct();
        }
    );
  }

}
