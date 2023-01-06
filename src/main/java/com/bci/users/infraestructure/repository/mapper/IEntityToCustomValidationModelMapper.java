package com.bci.users.infraestructure.repository.mapper;


import com.bci.users.domain.model.CustomValidation;
import com.bci.users.infraestructure.repository.entity.CustomValidationEntity;
import java.util.List;

public interface IEntityToCustomValidationModelMapper {

    CustomValidation mapForm(CustomValidationEntity customValidationEntity);
    List<CustomValidation> mapFormList(List<CustomValidationEntity> customValidationEntity);
}
