/*
 * Created by Wonuk Hwang on 2023/03/07
 * As part of Bigin
 *
 * Copyright (C) Bigin (https://bigin.io/main) - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by infra Team <wonuk_hwang@bigin.io>, 2023/03/07
 */
package com.example.eventlistener.model;

import static jakarta.persistence.FetchType.LAZY;

import com.example.eventlistener.dto.WalletChargeDto;
import com.example.eventlistener.dto.WalletRefundDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * create on 2023/03/07. create by IntelliJ IDEA.
 *
 * <p> 회사별로 부여되는 현금, 포인트 </p>
 * <p> {@link WalletLog} and {@link } </p> *
 *
 * @author wonukHwang
 * @version 1.0
 * @see
 * @since (ex : 5 + 5)
 */
@Entity
@Getter
@Table(name = "wallet")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Wallet {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "company", nullable = false)
  private Long companyId;

  @Column(name = "point", nullable = false, precision = 14, scale = 2)
  @Digits(integer = 12, fraction = 2)
  private BigDecimal point;

  @Column(name = "cash", nullable = false)
  private BigDecimal cash;

  // ============== child ==============
  /**
   * relation records
   */
  @OneToMany(mappedBy = "wallet", fetch = LAZY, cascade = CascadeType.ALL)
  @ToString.Exclude
  private List<WalletLog> walletLogs = new ArrayList<>();
  // ============== child ==============

  /**
   * static {@code Wallet} constructor.
   *
   * @param companyId 회사 아이디
   * @param creditType 현금 or 포인트
   * @param amount 포인트
   * @return {@code Wallet} instance.
   */
  public static Wallet create(
      @NonNull Long companyId,
      @NonNull CreditType creditType,
      @NonNull BigDecimal amount) {
    Wallet wallet = new Wallet();
    wallet.companyId = companyId;
    if (creditType.equals(CreditType.CASH)) {
      wallet.cash = amount;
    } else {
      wallet.point = amount;
    }

    return wallet;
  }

  /**
   * 해당 CreditType 에 맞게 금액을 충전한다.
   *
   * @param walletChargeDto
   */
  public void charge(@NonNull WalletChargeDto walletChargeDto) {
    CreditType creditType = walletChargeDto.getCreditType();
    BigDecimal charge = walletChargeDto.getAmount();

    BigDecimal balance = getBalance(creditType);
    setBalance(creditType, balance.add(charge));

    if (charge.compareTo(BigDecimal.ZERO) > 0) {
      walletLogs.add(
          WalletLog.builder()
              .wallet(this)
              .processType(ProcessType.CHARGE)
              .creditType(creditType)
              .amount(charge)
              .description(walletChargeDto.getDescription())
              .build()
      );
    }
  }

  /**
   * 해당 CreditType, ProcessType 에 맞게 환불한다
   *
   * @param walletLogForRefund
   * @param walletRefundDto
   */
  public void refund(WalletLog walletLogForRefund, WalletRefundDto walletRefundDto) {
    final CreditType creditType = walletLogForRefund.getCreditType();
    final BigDecimal refundCredit = walletRefundDto.getRefundAmount();

    BigDecimal balance = getBalance(creditType);
    setBalance(creditType, balance.add(refundCredit));

    WalletLog walletLog = WalletLog.builder()
        .wallet(this)
        .processType(ProcessType.REFUND)
        .creditType(creditType)
        .amount(refundCredit)
        .description(walletRefundDto.getDescription())
        .refundWalletLogId(walletRefundDto.getRefundWalletLogId())
        .build();

    walletLog.appendRefundLog(walletRefundDto.getServiceId(), walletRefundDto.getServiceType());

    walletLogs.add(walletLog);
  }

  public void deduct(
      @NonNull Long serviceId,
      @NonNull ServiceType serviceType,
      @NonNull BigDecimal charge,
      BigDecimal unitPrice,
      String description
  ) {
    deduct(serviceType, charge);

    // add log.
    WalletLog walletLog =
        WalletLog.builder()
            .wallet(this)
            .processType(ProcessType.USED)
            .creditType(serviceType.getCreditType())
            .amount(charge)
            .description(description)
            .build();

    walletLog.appendUsedLog(
        serviceId,
        serviceType,
        unitPrice
    );

    walletLogs.add(walletLog);
  }

  /**
   * deduct balance.
   *
   * @param serviceType {@code ServiceType}
   * @param charge used point or cash.
   */
  private void deduct(
      @NonNull ServiceType serviceType,
      @NonNull BigDecimal charge
  ) {
    final CreditType creditType = serviceType.getCreditType();

    BigDecimal balance = getBalance(creditType);
    setBalance(creditType, balance.subtract(charge));

  }

  /**
   * 입력받은 credit type의 잔액을 조회한다.
   * @param creditType {@link CreditType}
   * @return 잔액.
   */
  private BigDecimal getBalance(CreditType creditType) {
    if (creditType == CreditType.POINT) {
      return this.point;
    } else {
      return this.cash;
    }
  }

  /**
   * credit type의 잔액을 변경한다.
   * @param creditType {@link CreditType}
   * @param balance creditType의 잔액
   */
  private void setBalance(CreditType creditType, BigDecimal balance) {
    if(balance.compareTo(BigDecimal.ZERO) < 0) {
      //TODO: throw 처리 필요.
    }

    if (creditType == CreditType.POINT) {
      this.point = balance;
    } else {
      this.cash = balance;
    }

  }

}
