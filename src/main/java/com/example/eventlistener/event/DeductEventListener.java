/*
 * Created by Wonuk Hwang on 2023/04/03
 * As part of Bigin
 *
 * Copyright (C) Bigin (https://bigin.io/main) - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by infra Team <wonuk_hwang@bigin.io>, 2023/04/03
 */
package com.example.eventlistener.event;

import com.example.eventlistener.application.WalletService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * create on 2023/04/03. create by IntelliJ IDEA.
 *
 * <p> </p>
 * <p> {@link } and {@link } </p> *
 *
 * @author wonukHwang
 * @version 1.0
 * @see
 * @since (ex : 5 + 5)
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class DeductEventListener implements ApplicationListener<DeductEvent> {

  private final WalletService walletService;

  /**
   * @Async 비동기 처리
   * Event 가 publish 되었을 때 실행될 로직
   * @param event the event to respond to
   */
  @Async("asyncExecutor")
  @Override
  public void onApplicationEvent(DeductEvent event) {
    walletService.deduct(event.getWalletDeductDto());
  }

}
