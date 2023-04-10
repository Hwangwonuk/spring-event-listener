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

import com.example.eventlistener.model.Wallet;
import com.example.eventlistener.model.WalletLog;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

  @Query(nativeQuery = true, value = "select * from wallet_log wl where wallet_id = :wallet order by created_at desc limit :limit offset :offset")
  List<WalletLog> findAllWalletLogByWallet(
      @Param("wallet") Wallet wallet,
      @Param("limit") Long limit,
      @Param("offset") Long offset
  );

}
