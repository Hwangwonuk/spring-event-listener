/*
 * Created by Wonuk Hwang on 2023/04/08
 * As part of Bigin
 *
 * Copyright (C) Bigin (https://bigin.io/main) - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by infra Team <wonuk_hwang@bigin.io>, 2023/04/08
 */
package com.example.eventlistener.dto.response;

import com.example.eventlistener.dto.WalletLogDto;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

/**
 * create on 2023/04/08. create by IntelliJ IDEA.
 *
 * <p> wallet_log Response 객체 </p>
 * <p> {@link com.example.eventlistener.model.WalletLog} </p> *
 *
 * @author wonukHwang
 * @version 1.0
 * @see
 * @since (ex : 5 + 5)
 */
@Getter
@Builder
public class WalletLogResponse {

  private List<WalletLogDto> walletLogList;

  private Long total;

  private boolean more;

  public WalletLogResponse(List<WalletLogDto> walletLogList, Long total, boolean more) {
    this.walletLogList = walletLogList;
    this.total = total;
    this.more = more;
  }

}
