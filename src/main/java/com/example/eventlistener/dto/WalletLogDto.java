/*
 * Created by Wonuk Hwang on 2023/04/09
 * As part of Bigin
 *
 * Copyright (C) Bigin (https://bigin.io/main) - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by infra Team <wonuk_hwang@bigin.io>, 2023/04/09
 */
package com.example.eventlistener.dto;

import com.example.eventlistener.model.CreditType;
import com.example.eventlistener.model.WalletLog;
import java.math.BigDecimal;

/**
 * create on 2023/04/09. create by IntelliJ IDEA.
 *
 * <p> WalletLog Dto class </p>
 * <p> {@link com.example.eventlistener.dto.response.WalletLogResponse} and {@link com.example.eventlistener.model.WalletLog} </p> *
 *
 * @author wonukHwang
 * @version 1.0
 * @see
 * @since (ex : 5 + 5)
 */

public class WalletLogDto {

  /**
   * wallet_log id.
   */
  private final Long id;

  /**
   * company id.
   */
  private final Long companyId;

  /**
   * CreditType CASH or POINT.
   */
  private final CreditType creditType;

  /**
   * 금액.
   */
  private final BigDecimal credit;

  /**
   * 로그에 대한 설명.
   */
  private final String description;

  private WalletLogDto(
      Long id,
      Long companyId,
      CreditType creditType,
      BigDecimal credit,
      String description
  ) {
    this.id = id;
    this.companyId = companyId;
    this.creditType = creditType;
    this.credit = credit;
    this.description = description;
  }

  public static WalletLogDto of(WalletLog walletLog, Long companyId) {
    return new WalletLogDto(
        walletLog.getId(),
        companyId,
        walletLog.getCreditType(),
        walletLog.getAmount(),
        walletLog.getDescription()
    );
  }

}
