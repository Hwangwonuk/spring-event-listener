/*
 * Created by Wonuk Hwang on 2023/03/21
 * As part of Bigin
 *
 * Copyright (C) Bigin (https://bigin.io/main) - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by infra Team <wonuk_hwang@bigin.io>, 2023/03/21
 */
package com.example.eventlistener.dto;

import com.example.eventlistener.model.Wallet;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * create on 2023/03/21. create by IntelliJ IDEA.
 *
 * <p> Wallet Response </p>
 * <p> {@link com.example.eventlistener.model.Wallet} </p> *
 *
 * @author wonukHwang
 * @version 1.0
 * @see
 * @since (ex : 5 + 5)
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class WalletResponse {

  /**
   * wallet Id.
   */
  @NotNull
  private Long id;

  /**
   * company Id.
   */
  @NotNull
  private String companyId;

  /**
   * cash.
   */
  @NotNull
  private BigDecimal cash;
  /**
   * point.
   */
  @NotNull
  private BigDecimal point;

  public WalletResponse(Wallet entity) {
    applyDto(entity);
  }

  public void applyDto(Wallet entity) {
    this.id = entity.getId();
    this.companyId = entity.getCompanyId();
    this.cash = entity.getCash();
    this.point = entity.getPoint();
  }

}
