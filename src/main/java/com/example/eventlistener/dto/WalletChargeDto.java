/*
 * Created by Wonuk Hwang on 2023/03/27
 * As part of Bigin
 *
 * Copyright (C) Bigin (https://bigin.io/main) - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by infra Team <wonuk_hwang@bigin.io>, 2023/03/27
 */
package com.example.eventlistener.dto;

import com.example.eventlistener.model.CreditType;
import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * create on 2023/03/27. create by IntelliJ IDEA.
 *
 * <p> WalletCharge DTO </p>
 * <p> {@link WalletChargeRequest}의 Unit Test 및 Service단의 사용성을 위해 DTO 분리 </p> *
 *
 * @author wonukHwang
 * @version 1.0
 * @see
 * @since (ex : 5 + 5)
 */
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WalletChargeDto {

  /**
   * 회사 ID.
   */
  private String companyId;

  /**
   * Point Or Cash,
   */
  private CreditType creditType;

  /**
   * 충전 금액.
   */
  private BigDecimal amount;

  /**
   * 설명.
   */
  private String description;

  private WalletChargeDto(
      @NonNull String companyId,
      @NonNull CreditType creditType,
      @NonNull BigDecimal amount,
      String description
  ) {
    this.companyId = companyId;
    this.creditType = creditType;
    this.amount = amount;
    this.description = description;
  }

  public static WalletChargeDto from(WalletChargeRequest request) {
    return new WalletChargeDto(
        request.getCompanyId(),
        request.getCreditType(),
        request.getAmount(),
        request.getDescription()
    );
  }
}
