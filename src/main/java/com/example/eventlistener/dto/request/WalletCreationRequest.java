/*
 * Created by Wonuk Hwang on 2023/03/21
 * As part of Bigin
 *
 * Copyright (C) Bigin (https://bigin.io/main) - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by infra Team <wonuk_hwang@bigin.io>, 2023/03/21
 */
package com.example.eventlistener.dto.request;

import com.example.eventlistener.model.CreditType;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * create on 2023/03/21. create by IntelliJ IDEA.
 *
 * <p> Wallet Created Request </p>
 * <p> {@link com.example.eventlistener.model.Wallet} </p> *
 *
 * @author wonukHwang
 * @version 1.0
 * @see
 * @since (ex : 5 + 5)
 */
@Getter
@ToString
@NoArgsConstructor
public class WalletCreationRequest {

  /**
   * company id of wallet owner.
   */
  @NotBlank(message = "A \"company_id\" field is missing or its value is blank.")
  @JsonProperty("company_id")
  private Long companyId;

  /**
   * point or cash
   */
  @NotNull(message = "A \"credit_type\" is not allowed null.")
  @JsonProperty("credit_type")
  private CreditType creditType;

  /**
   * cash that you want to charge.
   */
  @NotNull
  @Digits(integer = 18, fraction = 2, message = "the point of cash field can not over 999,999,999 billion")
  @JsonProperty("cash")
  private BigDecimal amount;

}
