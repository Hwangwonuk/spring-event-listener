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

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * create on 2023/03/19. create by IntelliJ IDEA.
 *
 * <p> </p>
 * <p> {@link } and {@link } </p> *
 *
 * @author wonukHwang
 * @version 1.0
 * @see
 * @since (ex : 5 + 5)
 */

@Entity
@Getter
@ToString
@Table(name = "wallet_log")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class WalletLog {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "process_type", length = 20, nullable = false)
  @Enumerated(EnumType.STRING)
  private ProcessType processType;

  @Column(name = "credit_type", length = 20, nullable = false)
  @Enumerated(EnumType.STRING)
  private CreditType creditType;

  @Column(name = "point", precision = 14, scale = 2, nullable = false)
  private BigDecimal point;

  @Column(name = "description", length = 100)
  private String description;

  // ============== parent ==============
  /**
   * wallet relation
   */
  @ManyToOne(fetch = LAZY)
  @JoinColumn(name = "wallet_id", nullable = false)
  @ToString.Exclude
  private Wallet wallet;
  // ============== parent ==============
}
