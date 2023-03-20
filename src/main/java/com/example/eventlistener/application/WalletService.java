/*
 * Created by Wonuk Hwang on 2023/03/21
 * As part of Bigin
 *
 * Copyright (C) Bigin (https://bigin.io/main) - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by infra Team <wonuk_hwang@bigin.io>, 2023/03/21
 */
package com.example.eventlistener.application;

import com.example.eventlistener.dao.WalletRepository;
import com.example.eventlistener.dto.WalletCreationRequest;
import com.example.eventlistener.dto.WalletResponse;
import com.example.eventlistener.model.Wallet;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * create on 2023/03/21. create by IntelliJ IDEA.
 *
 * <p> Wallet Service </p>
 * <p> {@link com.example.eventlistener.api.v1.WalletApi}
 * and {@link com.example.eventlistener.model.Wallet}
 * and {@link com.example.eventlistener.model.WalletLog}
 * and {@link com.example.eventlistener.model.WalletUsedLog}
 * </p> *
 *
 * @author wonukHwang
 * @version 1.0
 * @see
 * @since (ex : 5 + 5)
 */

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class WalletService {

  private final WalletRepository walletRepository;

  /**
   * <p> create wallet.</p>
   *
   * @param request wallet essential data to create wallet.
   * @return saved Wallet info.
   */
  @Transactional
  public WalletResponse create(@NonNull WalletCreationRequest request) {
    Wallet savedWallet = walletRepository.save(request.toEntity());
    return new WalletResponse(savedWallet);
  }

}
