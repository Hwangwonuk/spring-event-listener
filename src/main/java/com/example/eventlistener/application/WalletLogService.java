/*
 * Created by Wonuk Hwang on 2023/04/09
 * As part of Bigin
 *
 * Copyright (C) Bigin (https://bigin.io/main) - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by infra Team <wonuk_hwang@bigin.io>, 2023/04/09
 */
package com.example.eventlistener.application;

import com.example.eventlistener.dao.WalletLogRepository;
import com.example.eventlistener.dao.WalletRepository;
import com.example.eventlistener.dto.WalletLogCreationDto;
import com.example.eventlistener.dto.WalletLogDto;
import com.example.eventlistener.dto.response.WalletLogResponse;
import com.example.eventlistener.model.CreditType;
import com.example.eventlistener.model.ProcessType;
import com.example.eventlistener.model.Wallet;
import com.example.eventlistener.model.WalletLog;
import java.math.BigDecimal;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * create on 2023/04/09. create by IntelliJ IDEA.
 *
 * <p> WalletLog service layer </p>
 * <p> {@link com.example.eventlistener.api.v1.WalletLogApi} and {@link com.example.eventlistener.model.WalletLog} </p> *
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
public class WalletLogService {

  private final WalletRepository walletRepository;

  private final WalletLogRepository walletLogRepository;

  /**
   * find all wallet_log by companyId
   *
   * @param companyId applicationId
   * @param limit         limit
   * @param offset        offset
   * @return WalletLogResponse responose
   */
  public WalletLogResponse findWalletLogByCompanyId(
      Long companyId,
      Long limit,
      Long offset
  ) {

    final Wallet wallet =
        walletRepository.findWalletByCompanyIdOrElseThrow(companyId);

    final List<WalletLogDto> walletLogDtoList =
        walletLogRepository.findAllWalletLogByWallet(wallet, limit, offset)
            .stream()
            .map(walletLog -> WalletLogDto.of(walletLog, companyId))
            .toList();

    final Long total = Long.valueOf(walletLogDtoList.size());

    boolean more = walletLogDtoList.size() >= limit.intValue();

    return WalletLogResponse.builder()
        .walletLogList(walletLogDtoList)
        .total(total)
        .more(more)
        .build();
  }

  /**
   * log 를 저장한다.
   * @param dto {@link WalletLogCreationDto}
   */
  @Transactional
  public void createWalletLog(WalletLogCreationDto dto) {


    final Wallet wallet =
        walletRepository.findWalletByCompanyIdOrElseThrow(dto.getCompanyId());

    // add log.
    WalletLog walletLog =
        WalletLog.builder()
            .wallet(wallet)
            .processType(dto.getProcessType())
            .creditType(dto.getCreditType())
            .amount(dto.getAmount())
            .description(dto.getDescription())
            .build();

    if (dto.getServiceId() != null && dto.getProcessType().equals(ProcessType.USED)) {
      walletLog.appendUsedLog(
          dto.getServiceId(),
          dto.getServiceType(),
          dto.getUnitPrice()
      );
    }

    walletLogRepository.save(walletLog);
  }

  /**
   * wallet log 를 수정한다.
   * @param companyId 회사 아이디.
   * @param walletLogId 로그 아이디.
   * @param processType 사용 | 충전 | 환불
   * @param creditType 현금 | 포인트
   * @param amount 금액
   * @param description 설명
   */
  @Transactional
  public void modifyWalletLog(
      Long companyId,
      Long walletLogId,
      ProcessType processType,
      CreditType creditType,
      BigDecimal amount,
      String description
  ) {

    final Wallet wallet = walletRepository.findWalletByCompanyIdOrElseThrow(companyId);

    WalletLog walletLog = wallet.getWalletLogs()
        .stream()
        .filter(wl -> wl.getId().equals(walletLogId))
        .findAny()
        .get();

    walletLog.modifyWalletLog(processType, creditType, amount, description);
  }

}
