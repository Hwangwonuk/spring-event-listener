/*
 * Created by Wonuk Hwang on 2023/04/19
 * As part of Bigin
 *
 * Copyright (C) Bigin (https://bigin.io/main) - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by infra Team <wonuk_hwang@bigin.io>, 2023/04/19
 */
package com.example.eventlistener.dto;

import com.example.eventlistener.dto.request.WalletLogModifyRequest;
import com.example.eventlistener.model.CreditType;
import com.example.eventlistener.model.ProcessType;
import jakarta.annotation.Nonnull;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.NonNull;

/**
 * create on 2023/04/19. create by IntelliJ IDEA.
 *
 * <p> WalletLog Modify DTO </p>
 * <p> {@link com.example.eventlistener.dto.request.WalletLogModifyRequest} </p> *
 *
 * @author wonukHwang
 * @version 1.0
 * @see
 * @since (ex : 5 + 5)
 */
@Getter
public class WalletLogModifyDto {

  private Long companyId;

  private Long walletLogId;

  private ProcessType processType;

  private CreditType creditType;

  private BigDecimal amount;

  private String description;

  private WalletLogModifyDto(
      @NonNull Long companyId,
      @Nonnull Long walletLogId,
      ProcessType processType,
      CreditType creditType,
      BigDecimal amount,
      String description
  ) {
    this.companyId = companyId;
    this.walletLogId = walletLogId;
    this.processType = processType;
    this.creditType = creditType;
    this.amount = amount;
    this.description = description;
  }

  public static WalletLogModifyDto from(WalletLogModifyRequest request) {
    return new WalletLogModifyDto(
        request.getCompanyId(),
        request.getWalletLogId(),
        request.getProcessType(),
        request.getCreditType(),
        request.getAmount(),
        request.getDescription()
    );
  }

}
