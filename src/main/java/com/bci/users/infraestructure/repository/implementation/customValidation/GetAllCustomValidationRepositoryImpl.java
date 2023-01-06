package com.bci.users.infraestructure.repository.implementation.customValidation;

import com.bci.users.domain.model.CustomValidation;
import com.bci.users.domain.port.output.customValidation.GetAllCustomValidationRepository;
import com.bci.users.domain.port.output.user.GetPhonesByUserIdRepository;
import com.bci.users.infraestructure.repository.jpa.CustomValidationEntityRepository;
import com.bci.users.infraestructure.repository.mapper.IEntityToCustomValidationModelMapper;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class GetAllCustomValidationRepositoryImpl implements GetAllCustomValidationRepository {

    private final CustomValidationEntityRepository repository;
    private final IEntityToCustomValidationModelMapper mapperToDomain;

    public GetAllCustomValidationRepositoryImpl(CustomValidationEntityRepository repository,
                                                IEntityToCustomValidationModelMapper mapperToDomain, GetPhonesByUserIdRepository getPhonesByUserIdRepository) {
        this.repository = repository;
        this.mapperToDomain = mapperToDomain;
    }



    @Override
    public List<CustomValidation> execute() {
        return this.mapperToDomain.mapFormList(this.repository.findAll());
    }
}
