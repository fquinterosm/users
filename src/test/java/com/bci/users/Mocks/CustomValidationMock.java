package com.bci.users.Mocks;

import com.bci.users.domain.model.CustomValidation;
import com.bci.users.infraestructure.repository.entity.CustomValidationEntity;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;

public class CustomValidationMock {


  public static List<CustomValidation> build_custom_validation_list() {
    String jsonFile = "customValidationList.json";
    return TestUtil.buildObjectFromFile(jsonFile, new TypeReference<List<CustomValidation>>() {
    });
  }

  public static List<CustomValidationEntity> build_custom_validation_entity_list() {
    String jsonFile = "customValidationList.json";
    return TestUtil.buildObjectFromFile(jsonFile, new TypeReference<List<CustomValidationEntity>>() {
    });
  }

  public static CustomValidation build_custom_validation_ok() {
    String jsonFile = "customValidationOk.json";
    return TestUtil.buildObjectFromFile(jsonFile, new TypeReference<CustomValidation>() {
    });
  }

  public static CustomValidationEntity build_custom_validation_entity_ok() {
    String jsonFile = "customValidationOk.json";
    return TestUtil.buildObjectFromFile(jsonFile, new TypeReference<CustomValidationEntity>() {
    });
  }




}
