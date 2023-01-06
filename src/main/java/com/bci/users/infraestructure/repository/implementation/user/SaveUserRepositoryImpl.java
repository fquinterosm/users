package com.bci.users.infraestructure.repository.implementation.user;

import static com.bci.users.infraestructure.util.GlobalConstants.ERROR_EMAIL_EXIST;

import com.bci.users.domain.model.UserInput;
import com.bci.users.domain.model.UserOutput;
import com.bci.users.domain.port.output.user.SaveUserRepository;
import com.bci.users.infraestructure.exception.RepositoryException;
import com.bci.users.infraestructure.repository.entity.UserEntity;
import com.bci.users.infraestructure.repository.jpa.UserEntityRepository;
import com.bci.users.infraestructure.repository.mapper.IEntityToUserModelMapper;
import com.bci.users.infraestructure.repository.mapper.IUserModelToEntityMapper;
import org.springframework.stereotype.Repository;

@Repository
public class SaveUserRepositoryImpl implements SaveUserRepository {

    private final UserEntityRepository repository;
    private final IUserModelToEntityMapper mapperToEntity;
    private final IEntityToUserModelMapper mapperToDomain;

    public SaveUserRepositoryImpl(UserEntityRepository repository,
                                        IUserModelToEntityMapper mapperToEntity,
                                        IEntityToUserModelMapper mapperToDomain) {
        this.repository = repository;
        this.mapperToEntity = mapperToEntity;
        this.mapperToDomain = mapperToDomain;
    }

    @Override
    public UserOutput save(UserInput userInput) {
        if(!repository.existsByEmail(userInput.getEmail())){
            UserEntity entity = this.mapperToEntity.mapForm(userInput);
            return this.mapperToDomain.mapForm(this.repository.save(entity));
        }else{
            throw new RepositoryException(ERROR_EMAIL_EXIST);
        }

    }

}
