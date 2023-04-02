/*
 * Created by Wonuk Hwang on 2023/04/02
 * As part of Bigin
 *
 * Copyright (C) Bigin (https://bigin.io/main) - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by infra Team <wonuk_hwang@bigin.io>, 2023/04/02
 */
package com.example.eventlistener.event;

import com.example.eventlistener.dto.WalletDeductDto;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * create on 2023/04/02. create by IntelliJ IDEA.
 *
 * <p> DeductReques를 Event로 만들기 위한 객체 </p>
 * <p> {@link com.example.eventlistener.dto.WalletDeductDto} and
 * {@link org.springframework.context.ApplicationEvent} </p> *
 *
 * @author wonukHwang
 * @version 1.0
 * @see
 * @since (ex : 5 + 5)
 */
@Getter
public class DeductEvent extends ApplicationEvent {

  private final WalletDeductDto walletDeductDto;

  public DeductEvent(Object source, WalletDeductDto walletDeductDto) {
    super(source);
    this.walletDeductDto = walletDeductDto;
  }
}
