/*
 * Created by Wonuk Hwang on 2023/04/12
 * As part of Bigin
 *
 * Copyright (C) Bigin (https://bigin.io/main) - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by infra Team <wonuk_hwang@bigin.io>, 2023/04/12
 */
package com.example.eventlistener.dto.request;

import lombok.Getter;

/**
 * create on 2023/04/12. create by IntelliJ IDEA.
 *
 * <p> WalletLog 생성 Request 객체 </p>
 * <p> {@link com.example.eventlistener.model.WalletLog} </p> *
 *
 * @author wonukHwang
 * @version 1.0
 * @see
 * @since (ex : 5 + 5)
 */
@Getter
public class WalletLogCreationRequest {

  private Long companyId;
}
