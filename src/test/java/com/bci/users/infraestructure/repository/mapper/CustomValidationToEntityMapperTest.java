package com.bci.users.infraestructure.repository.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.bci.users.Mocks.CustomValidationMock;
import com.bci.users.domain.model.CustomValidation;
import com.bci.users.infraestructure.repository.entity.CustomValidationEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomValidationToEntityMapperTest {


  private CustomValidationToEntityMapper mapper;

  @BeforeEach
  void setUp() {
    this.mapper = new CustomValidationToEntityMapper();
  }



  @Test
  void should_validate_mapper_model_to_entity() {

    //GIVEN
    CustomValidation customValidation = CustomValidationMock.build_custom_validation_ok();

    //WHEN
    CustomValidationEntity actual = mapper.mapForm(customValidation);

    //THEN
    assertEquals(customValidation.getName(), actual.getName());
    assertEquals(customValidation.getPattern(), actual.getPattern());
    assertEquals(customValidation.getMessage(), actual.getMessage());

  }


}