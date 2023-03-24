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

import com.example.eventlistener.model.ProcessType;
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
 * create on 2023/03/25. create by IntelliJ IDEA.
 *
 * <p> 환불 Request </p>
 * <p> {@link com.example.eventlistener.model.Wallet} </p> *
 *
 * @author wonukHwang
 * @version 1.0
 * @see
 * @since (ex : 5 + 5)
 */
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class RefundRequest {

  /**
   * 회사 아이디.
   */
  @NotBlank(message = "A \"company_id\" field is missing or its value is blank.")
  private String companyId;

  /**
   * 서비스 종류.
   */
  @NotNull(message = "A \"service_type\" field is missing.")
  private ServiceType serviceType;

  /**
   * 환불 금액.
   */
  @Min(value = 0, message = "A value of \"refund_amount\" field must be over than 0.")
  private BigDecimal refundAmount;

  /**
   * 설명.
   */
  @Size(max = 100, message = "A \"description\" field length is over than 100.")
  private String description;

  /**
   * 연관된 WalletLogId
   */
  @Min(value = 0, message = "A value of \"refund_wallet_log_id\" field is not valid value.")
  private Long refundWalletLogId;

}
