/*
 * Created by Wonuk Hwang on 2023/03/19
 * As part of Bigin
 *
 * Copyright (C) Bigin (https://bigin.io/main) - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by infra Team <wonuk_hwang@bigin.io>, 2023/03/19
 */
package com.example.eventlistener.model;

import static jakarta.persistence.FetchType.LAZY;

import com.example.eventlistener.common.ServiceTypeConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * create on 2023/03/19. create by IntelliJ IDEA.
 *
 * <p> Wallet 차감 내역만을 추적하기 위한 Entity </p>
 * <p> {@link WalletLog} and {@link ServiceType} </p> *
 *
 * @author wonukHwang
 * @version 1.0
 * @see
 * @since (ex : 5 + 5)
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
@Entity
@Table(name = "wallet_used_log")
public class WalletUsedLog {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "service_id", nullable = false)
  private Long serviceId;

  @Column(name = "service_type", length = 20, nullable = false)
  @Convert(converter = ServiceTypeConverter.class)
  private ServiceType serviceType;

  @Column(name = "unit_price", precision = 14, scale = 2)
  private BigDecimal unitPrice;

  // ============== parent ==============
  @OneToOne(fetch = LAZY)
  @JoinColumn(name = "wallet_log_id", nullable = false)
  @ToString.Exclude
  private WalletLog walletLog;
  // ============== parent ==============

  WalletUsedLog(
      WalletLog walletLog,
      Long serviceId,
      ServiceType serviceType
  ) {
    this.walletLog = walletLog;
    this.serviceId = serviceId;
    this.serviceType = serviceType;
  }

  WalletUsedLog(
      WalletLog walletLog,
      Long serviceId,
      ServiceType serviceType,
      BigDecimal unitPrice
  ) {
    this.walletLog = walletLog;
    this.serviceId = serviceId;
    this.serviceType = serviceType;
    this.unitPrice = unitPrice;
  }

}
