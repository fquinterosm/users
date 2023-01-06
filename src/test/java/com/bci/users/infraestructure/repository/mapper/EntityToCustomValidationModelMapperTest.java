package com.bci.users.infraestructure.repository.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.bci.users.Mocks.CustomValidationMock;
import com.bci.users.domain.model.CustomValidation;
import com.bci.users.infraestructure.repository.entity.CustomValidationEntity;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EntityToCustomValidationModelMapperTest {

  private EntityToCustomValidationModelMapper mapper;

  @BeforeEach
  void setUp() {
    this.mapper = new EntityToCustomValidationModelMapper();
  }



  @Test
  void should_validate_mapper_entity_to_model() {

    //GIVEN
    CustomValidationEntity customValidationEntity = CustomValidationMock.build_custom_validation_entity_ok();

    //WHEN
    CustomValidation actual = mapper.mapForm(customValidationEntity);

    //THEN
    assertEquals(customValidationEntity.getName(), actual.getName());
    assertEquals(customValidationEntity.getPattern(), actual.getPattern());
    assertEquals(customValidationEntity.getMessage(), actual.getMessage());

  }


  @Test
  void should_validate_mapper_entity_to_model_list() {

    //GIVEN
    List<CustomValidationEntity> customValidationEntity = CustomValidationMock.build_custom_validation_entity_list();

    //WHEN
    List<CustomValidation> actualList = mapper.mapFormList(customValidationEntity);


    //THEN
    int i = 0;
    for (CustomValidation customValidation: actualList) {
      assertEquals(customValidation.getName(), customValidationEntity.get(i).getName());
      assertEquals(customValidation.getPattern(), customValidationEntity.get(i).getPattern());
      assertEquals(customValidation.getMessage(), customValidationEntity.get(i).getMessage());
      i++;
    }

  }


}