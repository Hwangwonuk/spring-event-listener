/*
 * Created by Wonuk Hwang on 2023/03/29
 * As part of Bigin
 *
 * Copyright (C) Bigin (https://bigin.io/main) - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by infra Team <wonuk_hwang@bigin.io>, 2023/03/29
 */
package com.example.eventlistener.dto;

import com.example.eventlistener.dto.request.WalletRefundRequest;
import com.example.eventlistener.model.ServiceType;
import java.math.BigDecimal;
import lombok.Getter;

/**
 * create on 2023/03/29. create by IntelliJ IDEA.
 *
 * <p> 환불 요청 DTO </p>
 * <p> {@link com.example.eventlistener.dto.request.WalletRefundRequest} 관련 클래스 </p> *
 *
 * @author wonukHwang
 * @version 1.0
 * @see
 * @since (ex : 5 + 5)
 */
@Getter
public class WalletRefundDto {

  /**
   * 회사 아이디.
   */
  private Long companyId;

  /**
   * Service ID.
   */
  private Long serviceId;

  /**
   * 서비스 종류.
   */
  private ServiceType serviceType;

  /**
   * 환불 금액.
   */
  private BigDecimal refundAmount;

  /**
   * 설명.
   */
  private String description;

  /**
   * 연관된 WalletLogId
   */
  private Long refundWalletLogId;

  private WalletRefundDto(
      Long companyId,
      Long serviceId,
      ServiceType serviceType,
      BigDecimal refundAmount,
      String description,
      Long refundWalletLogId
  ) {
    this.companyId = companyId;
    this.serviceType = serviceType;
    this.refundAmount = refundAmount;
    this.description = description;
    this.refundWalletLogId = refundWalletLogId;
  }

  public static WalletRefundDto from(WalletRefundRequest request) {
    return new WalletRefundDto(
      request.getCompanyId(),
      request.getServiceId(),
      request.getServiceType(),
      request.getRefundAmount(),
      request.getDescription(),
      request.getRefundWalletLogId()
    );
  }

}
