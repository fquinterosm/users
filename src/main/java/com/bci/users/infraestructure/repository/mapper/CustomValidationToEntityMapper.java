package com.bci.users.infraestructure.repository.mapper;

import com.bci.users.domain.model.CustomValidation;
import com.bci.users.infraestructure.repository.entity.CustomValidationEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomValidationToEntityMapper implements ICustomValidationToEntityMapper{



    @Override
    public CustomValidationEntity mapForm(CustomValidation customValidation) {
        CustomValidationEntity customValidationEntity = new CustomValidationEntity();
        customValidationEntity.setName(customValidation.getName());
        customValidationEntity.setPattern(customValidation.getPattern());
        customValidationEntity.setMessage(customValidation.getMessage());
        return customValidationEntity;
    }
}
