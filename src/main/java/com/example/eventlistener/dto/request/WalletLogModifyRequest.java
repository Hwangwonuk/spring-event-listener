/*
 * Created by Wonuk Hwang on 2023/04/19
 * As part of Bigin
 *
 * Copyright (C) Bigin (https://bigin.io/main) - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by infra Team <wonuk_hwang@bigin.io>, 2023/04/19
 */
package com.example.eventlistener.dto.request;

import com.example.eventlistener.model.CreditType;
import com.example.eventlistener.model.ProcessType;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import lombok.Getter;

/**
 * create on 2023/04/19. create by IntelliJ IDEA.
 *
 * <p> WalletLog Modify Request </p>
 * <p> {@link } and {@link } </p> *
 *
 * @author wonukHwang
 * @version 1.0
 * @see
 * @since (ex : 5 + 5)
 */
@Getter
public class WalletLogModifyRequest {

  @NotNull(message = "A \"wallet_log_id\" is not allowed null.")
  @JsonProperty("wallet_log_id")
  private Long walletLogId;

  @JsonProperty("process_type")
  private ProcessType processType;

  @JsonProperty("credit_type")
  private CreditType creditType;

  @JsonProperty("amount")
  private BigDecimal amount;

  @JsonProperty("description")
  private String description;

}
