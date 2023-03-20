/*
 * Created by Wonuk Hwang on 2023/03/21
 * As part of Bigin
 *
 * Copyright (C) Bigin (https://bigin.io/main) - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by infra Team <wonuk_hwang@bigin.io>, 2023/03/21
 */
package com.example.eventlistener.dao;

import com.example.eventlistener.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * create on 2023/03/21. create by IntelliJ IDEA.
 *
 * <p> Wallet Repository </p>
 * <p> {@link com.example.eventlistener.model.Wallet} </p> *
 *
 * @author wonukHwang
 * @version 1.0
 * @see
 * @since (ex : 5 + 5)
 */
public interface WalletRepository extends JpaRepository<Wallet, Long> {

}
