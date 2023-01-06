package com.bci.users.infraestructure.repository.implementation.user;

import static com.bci.users.infraestructure.util.GlobalConstants.ERROR_LOGIN;

import com.bci.users.domain.model.UserOutput;
import com.bci.users.domain.port.output.user.GetUserByEmailAndPasswordRepository;
import com.bci.users.infraestructure.exception.RepositoryException;
import com.bci.users.infraestructure.repository.entity.UserEntity;
import com.bci.users.infraestructure.repository.jpa.UserEntityRepository;
import com.bci.users.infraestructure.repository.mapper.IEntityToUserModelMapper;
import org.springframework.stereotype.Repository;

@Repository
public class GetUserByEmailAndPasswordRepositoryImpl implements GetUserByEmailAndPasswordRepository {

    private final UserEntityRepository repository;
    private final IEntityToUserModelMapper mapperToDomain;

    public GetUserByEmailAndPasswordRepositoryImpl(UserEntityRepository repository, IEntityToUserModelMapper mapperToDomain) {
        this.repository = repository;
        this.mapperToDomain = mapperToDomain;
    }


    @Override
    public UserOutput execute(String email, String password) {
        UserEntity userEntity = repository.findOneByEmailAndPassword(email, password)
                .orElseThrow(() -> new RepositoryException(ERROR_LOGIN));
        return mapperToDomain.mapForm(userEntity);
    }
}
