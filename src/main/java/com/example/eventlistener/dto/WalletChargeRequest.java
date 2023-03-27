/*
 * Created by Wonuk Hwang on 2023/03/22
 * As part of Bigin
 *
 * Copyright (C) Bigin (https://bigin.io/main) - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by infra Team <wonuk_hwang@bigin.io>, 2023/03/22
 */
package com.example.eventlistener.dto;

import com.example.eventlistener.model.CreditType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * create on 2023/03/22. create by IntelliJ IDEA.
 *
 * <p> </p>
 * <p> {@link } and {@link } </p> *
 *
 * @author wonukHwang
 * @version 1.0
 * @see
 * @since (ex : 5 + 5)
 */
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class WalletChargeRequest {

  @NotNull(message = "A \"company_id\" is not allowed null.")
  private String companyId;

  @NotNull(message = "A \"credit_type\" is not allowed null.")
  private CreditType creditType;

  @NotNull(message = "A \"amount\" is not allowed null.")
  @Min(value = 0, message = "A value of \"amount\" field must be over than 0.")
  private BigDecimal amount;

  @Size(max = 100, message = "A \"description\" field length is over than 100.")
  private String description;

  public WalletChargeRequest(
      String companyId,
      CreditType creditType,
      BigDecimal amount,
      String description
  ) {
    this.companyId = companyId;
    this.creditType = creditType;
    this.amount = amount;
    this.description = description;
  }
}
