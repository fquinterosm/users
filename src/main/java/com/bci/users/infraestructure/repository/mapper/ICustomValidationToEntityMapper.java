package com.bci.users.infraestructure.repository.mapper;

import com.bci.users.domain.model.CustomValidation;
import com.bci.users.infraestructure.repository.entity.CustomValidationEntity;

public interface ICustomValidationToEntityMapper {

    CustomValidationEntity mapForm(CustomValidation customValidation);
}
