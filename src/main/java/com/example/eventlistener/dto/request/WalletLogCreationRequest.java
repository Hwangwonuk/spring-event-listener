/*
 * Created by Wonuk Hwang on 2023/04/12
 * As part of Bigin
 *
 * Copyright (C) Bigin (https://bigin.io/main) - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by infra Team <wonuk_hwang@bigin.io>, 2023/04/12
 */
package com.example.eventlistener.dto.request;

import com.example.eventlistener.model.CreditType;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * create on 2023/04/12. create by IntelliJ IDEA.
 *
 * <p> WalletLog 생성 Request 객체 </p>
 * <p> {@link com.example.eventlistener.model.WalletLog} </p> *
 *
 * @author wonukHwang
 * @version 1.0
 * @see
 * @since (ex : 5 + 5)
 */
@Getter
@NoArgsConstructor
public class WalletLogCreationRequest {

  /* 회사 아이디. */
  @Min(value = 0, message = "A value of \"company_id\" field is not valid value.")
  @NotNull(message = "A \"company_id\" is not allowed null.")
  @JsonProperty("company_id")
  private Long companyId;

  /* 포인트 or 현금 */
  @NotNull(message = "A \"credit_type\" is not allowed null.")
  @JsonProperty("credit_type")
  private CreditType creditType;

  /* 금액 */
  @NotNull(message = "A \"credit_type\" is not allowed null.")
  @JsonProperty("amount")
  private BigDecimal amount;

  @Size(max = 100, message = "A \"description\" field length is over than 100.")
  @JsonProperty("description")
  private String description;


}
