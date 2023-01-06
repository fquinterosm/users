package com.bci.users.infraestructure.repository.implementation.customValidation;

import com.bci.users.domain.model.CustomValidation;
import com.bci.users.domain.port.output.customValidation.SaveOrUpdateCustomValidationRepository;
import com.bci.users.infraestructure.repository.jpa.CustomValidationEntityRepository;
import com.bci.users.infraestructure.repository.mapper.ICustomValidationToEntityMapper;
import com.bci.users.infraestructure.repository.mapper.IEntityToCustomValidationModelMapper;
import org.springframework.stereotype.Repository;

@Repository
public class SaveOrUpdateCustomValidationRepositoryImpl implements SaveOrUpdateCustomValidationRepository {

    private final CustomValidationEntityRepository repository;
    private final ICustomValidationToEntityMapper mapperToEntity;
    private final IEntityToCustomValidationModelMapper mapperToDomain;

    public SaveOrUpdateCustomValidationRepositoryImpl(CustomValidationEntityRepository repository,
                                                      ICustomValidationToEntityMapper mapperToEntity,
                                                      IEntityToCustomValidationModelMapper mapperToDomain) {
        this.repository = repository;
        this.mapperToEntity = mapperToEntity;
        this.mapperToDomain = mapperToDomain;
    }


    @Override
    public CustomValidation saveOrUpdate(CustomValidation customValidation) {
        return this.mapperToDomain.mapForm(this.repository.save(this.mapperToEntity.mapForm(customValidation)));
    }
}
