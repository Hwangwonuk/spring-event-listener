/*
 * Created by Wonuk Hwang on 2023/03/30
 * As part of Bigin
 *
 * Copyright (C) Bigin (https://bigin.io/main) - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by infra Team <wonuk_hwang@bigin.io>, 2023/03/30
 */
package com.example.eventlistener.dto.request;

import com.example.eventlistener.model.ServiceType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * create on 2023/03/30. create by IntelliJ IDEA.
 *
 * <p> Wallet Deduct Request </p>
 * <p> {@link com.example.eventlistener.model.Wallet}
 * and {@link com.example.eventlistener.model.WalletLog}
 * {@link com.example.eventlistener.model.WalletUsedLog}
 * </p> *
 *
 * @author wonukHwang
 * @version 1.0
 * @see
 * @since (ex : 5 + 5)
 */

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class WalletDeductRequest {

  /**
   * 회사 아이디.
   */
  @NotBlank(message = "A \"company_id\" field is missing or its value is blank.")
  private Long companyId;

  /**
   * 서비스 아이디.
   */
  @NotNull(message = "A \"service_id\" is not allowed null.")
  private Long serviceId;

  /**
   * 서비스 타입
   */
  @NotNull(message = "A \"service_type\" is not allowed null.")
  private ServiceType serviceType;

  /**
   * 차감할 요금.
   */
  @Min(value = 0, message = "A value of \"charge\" field must be over than 0.")
  private BigDecimal charge;

  /**
   * 설명.
   */
  @Size(max = 100, message = "A \"description\" field length is over than 100.")
  private String description;

  /**
   * 건당 요금.
   */
  private BigDecimal unitPrice;

}
