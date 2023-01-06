package com.bci.users.infraestructure.repository.mapper;

import com.bci.users.domain.model.CustomValidation;
import com.bci.users.infraestructure.repository.entity.CustomValidationEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class EntityToCustomValidationModelMapper implements IEntityToCustomValidationModelMapper {

    @Override
    public CustomValidation mapForm(CustomValidationEntity customValidationEntity) {
        CustomValidation customValidation = new CustomValidation();
        customValidation.setName(customValidationEntity.getName());
        customValidation.setPattern(customValidationEntity.getPattern());
        customValidation.setMessage(customValidationEntity.getMessage());
        return customValidation;
    }

    @Override
    public List<CustomValidation> mapFormList(List<CustomValidationEntity> customValidationEntityList) {
        List<CustomValidation> customValidationList = new ArrayList<>();

        for (CustomValidationEntity customValidationEntity: customValidationEntityList) {
            customValidationList.add(mapForm(customValidationEntity));
        }
        return customValidationList;
    }
}
