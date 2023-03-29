/*
 * Created by Wonuk Hwang on 2023/03/29
 * As part of Bigin
 *
 * Copyright (C) Bigin (https://bigin.io/main) - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by infra Team <wonuk_hwang@bigin.io>, 2023/03/29
 */
package com.example.eventlistener.dao;

import com.example.eventlistener.model.WalletLog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * create on 2023/03/29. create by IntelliJ IDEA.
 *
 * <p> Wallet Log JPA Repository </p>
 * <p> {@link com.example.eventlistener.model.WalletLog} </p> *
 *
 * @author wonukHwang
 * @version 1.0
 * @see
 * @since (ex : 5 + 5)
 */
public interface WalletLogRepository extends JpaRepository<WalletLog, Long> {

  default WalletLog findByIdOrElseThrow(Long refundWalletLogId) {
    return findById(refundWalletLogId)
        .orElseThrow(
            () -> new RuntimeException("Wallet log is not found by " + refundWalletLogId));
  }

}
