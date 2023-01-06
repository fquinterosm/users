package com.bci.users.infraestructure.repository.implementation.user;

import static com.bci.users.infraestructure.util.GlobalConstants.USER_NOT_FOUND;

import com.bci.users.domain.model.UserOutput;
import com.bci.users.domain.port.output.user.DeleteUserByIdRepository;
import com.bci.users.infraestructure.exception.RepositoryException;
import com.bci.users.infraestructure.repository.entity.UserEntity;
import com.bci.users.infraestructure.repository.jpa.UserEntityRepository;
import com.bci.users.infraestructure.repository.mapper.IEntityToUserModelMapper;
import java.util.Date;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
public class DeleteUserByIdRepositoryImpl implements DeleteUserByIdRepository {

    private final UserEntityRepository repository;
    private final IEntityToUserModelMapper mapperToDomain;

    public DeleteUserByIdRepositoryImpl(UserEntityRepository repository, IEntityToUserModelMapper mapperToDomain) {
        this.repository = repository;
        this.mapperToDomain = mapperToDomain;
    }


    @Override
    public UserOutput execute(UUID id) {
        UserEntity userEntity = repository.findById(id)
                .orElseThrow(() -> new RepositoryException(USER_NOT_FOUND));
        userEntity.setIsActive(Boolean.FALSE);
        userEntity.setModified(new Date());
        UserEntity userEntityDeleted = repository.save(userEntity);
        return mapperToDomain.mapForm(userEntityDeleted);
    }
}
