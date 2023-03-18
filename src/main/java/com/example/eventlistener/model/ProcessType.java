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
 * <p> Wallet Log 타입을 구분하는 enum </p>
 * <p> {@link WalletLog} 관련 클래스 </p> *
 *
 * @author wonukHwang
 * @version 1.0
 * @see Wallet
 * @since (ex : 5 + 5)
 */
public enum ProcessType {

  /**
   * 사용
   */
  USED,

  /**
   * 충전
   */
  CHARGE,

  /**
   * 환불
   */
  REFUND
}
