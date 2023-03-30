/*
 * Created by Wonuk Hwang on 2023/03/30
 * As part of Bigin
 *
 * Copyright (C) Bigin (https://bigin.io/main) - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by infra Team <wonuk_hwang@bigin.io>, 2023/03/30
 */
package com.example.eventlistener.dto;

import com.example.eventlistener.dto.request.WalletDeductRequest;
import com.example.eventlistener.model.ServiceType;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.NonNull;

/**
 * create on 2023/03/30. create by IntelliJ IDEA.
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
public class WalletDeductDto {

  /**
   * 회사 아이디.
   */
  private Long companyId;

  /**
   * 서비스 아이디.
   */
  private Long serviceId;

  /**
   * 서비스 타입
   */
  private ServiceType serviceType;

  /**
   * 차감할 요금.
   */
  private BigDecimal charge;

  /**
   * 설명.
   */
  private String description;

  /**
   * 건당 요금.
   */
  private BigDecimal unitPrice;

  public WalletDeductDto(
      Long companyId,
      Long serviceId,
      ServiceType serviceType,
      BigDecimal charge,
      String description,
      BigDecimal unitPrice
  ) {
    this.companyId = companyId;
    this.serviceId = serviceId;
    this.serviceType = serviceType;
    this.charge = charge;
    this.description = description;
    this.unitPrice = unitPrice;
  }

  public static WalletDeductDto from(WalletDeductRequest request) {
    return new WalletDeductDto(
        request.getCompanyId(),
        request.getServiceId(),
        request.getServiceType(),
        request.getCharge(),
        request.getDescription(),
        request.getUnitPrice()
    );
  }

}
