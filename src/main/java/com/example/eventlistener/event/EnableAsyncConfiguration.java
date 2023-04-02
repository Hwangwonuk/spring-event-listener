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

import java.util.concurrent.Executor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * create on 2023/04/02. create by IntelliJ IDEA.
 *
 * <p> EnableAsync Configuration </p>
 * <p> {@link } </p> *
 *
 * @author wonukHwang
 * @version 1.0
 * @see
 * @since (ex : 5 + 5)
 */

@Configuration
@EnableAsync
public class EnableAsyncConfiguration {

  /**
   * @EnableAsync = method에서 비동기 기능을 사용가능하게 활성화 하는 어노테이션
   * setCorePoolSize = 기본 실행 대기하는 Tread의 수
   * setMaxPoolSize = 동시 동작하는 최대 Thread 수
   * setQueueCapacity = MaxPoolSize 초과 요청에서 Thread 생성 요청시,
   * 해당 요청을 Queue에 저장하는데 이때 최대 수용 가능한 Queue의 수,
   * Queue에 저장되어 있다가 Thread 자리가 생기면 하나씩 빠져나가 동작
   * ThreadNamePrefix = 생성되는 Thread 접두사 지정
   *
   * 우선 default와 같은 설정으로 테스트한다.
   *
   * @return
   */
  @Bean(name = "asyncExecutor")
  public Executor asyncExecutor()
  {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(1);
    executor.setMaxPoolSize(1);
    executor.setQueueCapacity(Integer.MAX_VALUE);
    executor.setThreadNamePrefix("AsyncThread-");
    executor.initialize();
    return executor;
  }
}
