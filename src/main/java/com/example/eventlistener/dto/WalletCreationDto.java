/*
 * Created by Wonuk Hwang on 2023/03/25
 * As part of Bigin
 *
 * Copyright (C) Bigin (https://bigin.io/main) - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by infra Team <wonuk_hwang@bigin.io>, 2023/03/25
 */
package com.example.eventlistener.dto;

import com.example.eventlistener.dto.request.WalletCreationRequest;
import com.example.eventlistener.model.CreditType;
import com.example.eventlistener.model.Wallet;
import java.math.BigDecimal;

/**
 * create on 2023/03/25. create by IntelliJ IDEA.
 *
 * <p> Wallet Create Request DTO </p>
 * <p>  Request는 service layer까지 넘어가지 않아야 한다.
 * Unit Test의 용이성, service라 함은 api뿐만 아니라 batch, scheduler등
 * 여러군데에서 공통적으로 사용하기 위함 </p>
 * <p> {@link WalletCreationRequest} and {@link com.example.eventlistener.model.Wallet} </p> *
 *
 * @author wonukHwang
 * @version 1.0
 * @see
 * @since (ex : 5 + 5)
 */
public class WalletCreationDto {

  /**
   * company id of wallet owner.
   */
  private final Long companyId;

  /**
   * point or cash
   */
  private CreditType creditType;

  /**
   * cash that you want to charge.
   */
  private BigDecimal amount;

  private WalletCreationDto(
      Long companyId,
      CreditType creditType,
      BigDecimal amount
  ) {
    this.companyId = companyId;
    this.creditType = creditType;
    this.amount = amount;
  }

  public static WalletCreationDto from(WalletCreationRequest request) {
    return new WalletCreationDto(
        request.getCompanyId(),
        request.getCreditType(),
        request.getAmount()
    );
  }

  public Wallet toEntity() {
    return Wallet.create(
        this.companyId,
        this.creditType,
        this.amount
    );
  }

}
