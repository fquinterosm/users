package com.bci.users.infraestructure.repository.implementation.user;

import com.bci.users.domain.model.UserOutput;
import com.bci.users.domain.port.output.user.UpdateUserRepository;
import com.bci.users.infraestructure.repository.entity.UserEntity;
import com.bci.users.infraestructure.repository.jpa.UserEntityRepository;
import com.bci.users.infraestructure.repository.mapper.IEntityToUserModelMapper;
import com.bci.users.infraestructure.repository.mapper.IUserModelToEntityMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UpdateUserRepositoryImpl implements UpdateUserRepository {

    private final UserEntityRepository repository;
    private final IUserModelToEntityMapper mapperToEntity;
    private final IEntityToUserModelMapper mapperToDomain;

    public UpdateUserRepositoryImpl(UserEntityRepository repository,
                                    IUserModelToEntityMapper mapperToEntity,
                                    IEntityToUserModelMapper mapperToDomain) {
        this.repository = repository;
        this.mapperToEntity = mapperToEntity;
        this.mapperToDomain = mapperToDomain;
    }

    @Override
    public UserOutput update(UserOutput userOutput) {
        UserEntity entity = this.mapperToEntity.mapForm(userOutput);
        return this.mapperToDomain.mapForm(this.repository.save(entity));
    }
}
