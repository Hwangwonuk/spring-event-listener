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

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * create on 2023/03/19. create by IntelliJ IDEA.
 *
 * <p> 서비스 종류를 나타내는 Enum </p>
 * <p> {@link } and {@link } </p> *
 *
 * @author wonukHwang
 * @version 1.0
 * @see
 * @since (ex : 5 + 5)
 */
@RequiredArgsConstructor
@Getter
public enum ServiceType {

  CASH_SERVICE1("C1", CreditType.CASH),
  CASH_SERVICE2("C2", CreditType.CASH),
  POINT_SERVICE1("P1", CreditType.POINT),
  POINT_SERVICE2("P2", CreditType.POINT),
  POINT_SERVICE3("P3", CreditType.POINT);

  private final String code;
  private final CreditType creditType;

  public static ServiceType from(String code) {

    for (ServiceType i : ServiceType.values()) {
      if (i.code.equalsIgnoreCase(code)) {
        return i;
      }
    }

    throw new IllegalArgumentException("ServiceType : Your code is not valid.>>>>" + code);
  }
}
