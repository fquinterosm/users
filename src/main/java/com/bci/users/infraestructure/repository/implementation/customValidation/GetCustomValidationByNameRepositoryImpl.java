package com.bci.users.infraestructure.repository.implementation.customValidation;

import com.bci.users.domain.model.CustomValidation;
import com.bci.users.domain.port.output.customValidation.GetCustomValidationByNameRepository;
import com.bci.users.infraestructure.repository.entity.CustomValidationEntity;
import com.bci.users.infraestructure.repository.jpa.CustomValidationEntityRepository;
import com.bci.users.infraestructure.repository.mapper.IEntityToCustomValidationModelMapper;
import org.springframework.stereotype.Repository;

@Repository
public class GetCustomValidationByNameRepositoryImpl implements GetCustomValidationByNameRepository {

    private final CustomValidationEntityRepository repository;
    private final IEntityToCustomValidationModelMapper mapperToDomain;

    public GetCustomValidationByNameRepositoryImpl(
        CustomValidationEntityRepository repository,
        IEntityToCustomValidationModelMapper mapperToDomain) {
        this.repository = repository;
        this.mapperToDomain = mapperToDomain;
    }



    @Override
    public CustomValidation execute(String name) {
        CustomValidationEntity customValidationEntity = repository.findById(name)
            .orElseGet(() -> new CustomValidationEntity());
        return mapperToDomain.mapForm(customValidationEntity);
    }
}
