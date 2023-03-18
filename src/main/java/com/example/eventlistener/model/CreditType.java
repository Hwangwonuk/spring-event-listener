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

/**
 * create on 2023/03/19. create by IntelliJ IDEA.
 *
 * <p> 현금, 포인트를 구분하는 enum </p>
 * <p> {@link Wallet} and {@link WalletLog} </p> *
 *
 * @author wonukHwang
 * @version 1.0
 * @see
 * @since (ex : 5 + 5)
 */
public enum CreditType {

  /**
   * 포인트
   */
  POINT,

  /**
   * 현금
   */
  CASH
}
