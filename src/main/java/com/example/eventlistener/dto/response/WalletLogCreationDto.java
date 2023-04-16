/*
 * Created by Wonuk Hwang on 2023/04/16
 * As part of Bigin
 *
 * Copyright (C) Bigin (https://bigin.io/main) - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by infra Team <wonuk_hwang@bigin.io>, 2023/04/16
 */
package com.example.eventlistener.dto.response;

import com.example.eventlistener.dto.request.WalletLogCreationRequest;
import com.example.eventlistener.model.CreditType;
import java.math.BigDecimal;
import lombok.Getter;

/**
 * create on 2023/04/16. create by IntelliJ IDEA.
 *
 * <p> WalletLog 생성 DTO </p>
 * <p> {@link com.example.eventlistener.model.WalletLog} and
 * {@link com.example.eventlistener.dto.request.WalletLogCreationRequest} </p> *
 *
 * @author wonukHwang
 * @version 1.0
 * @see
 * @since (ex : 5 + 5)
 */

@Getter
public class WalletLogCreationDto {

  /* 회사 아이디. */
  private final Long companyId;

  /* 포인트 or 현금 */
  private final CreditType creditType;

  /* 금액 */
  private final BigDecimal amount;

  /* 설명 */
  private final String description;

  private WalletLogCreationDto(Long companyId, CreditType creditType, BigDecimal amount,
      String description) {
    this.companyId = companyId;
    this.creditType = creditType;
    this.amount = amount;
    this.description = description;
  }

  public static WalletLogCreationDto from(WalletLogCreationRequest request) {
    return new WalletLogCreationDto(
        request.getCompanyId(),
        request.getCreditType(),
        request.getAmount(),
        request.getDescription()
    );
  }

}
