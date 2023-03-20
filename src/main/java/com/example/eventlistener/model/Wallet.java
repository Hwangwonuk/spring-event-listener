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
  private String companyId;

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
   * @param cash 현금
   * @param point 포인트
   * @return {@code Wallet} instance.
   */
  public static Wallet create(
      @NonNull String companyId,
      @NonNull BigDecimal cash,
      @NonNull BigDecimal point) {
    Wallet wallet = new Wallet();
    wallet.companyId = companyId;
    wallet.cash = cash;
    wallet.point = point;

    return wallet;
  }
}
