/*
 * Created by Wonuk Hwang on 2023/03/20
 * As part of Bigin
 *
 * Copyright (C) Bigin (https://bigin.io/main) - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by infra Team <wonuk_hwang@bigin.io>, 2023/03/20
 */
package com.example.eventlistener.common;

import com.example.eventlistener.model.ServiceType;
import jakarta.persistence.AttributeConverter;

/**
 * create on 2023/03/20. create by IntelliJ IDEA.
 *
 * <p> ServiceType Converter </p>
 * <p> {@link ServiceType} 관련 클래스 </p> *
 *
 * @author wonukHwang
 * @version 1.0
 * @see
 * @since (ex : 5 + 5)
 */
public class ServiceTypeConverter implements AttributeConverter<ServiceType, String> {

  /**
   * attribute
   * @param serviceType  the entity attribute value to be converted
   * @return serviceType.getCode();
   */
  @Override
  public String convertToDatabaseColumn(ServiceType serviceType) {
    return serviceType.getCode();
  }

  /**
   * dbData
   * @param dbData  the data from the database column to be converted
   * @return ServiceType.from();
   */
  @Override
  public ServiceType convertToEntityAttribute(String dbData) {
    if (dbData == null) {
      return null;
    }
    return ServiceType.from(dbData);
  }
}
