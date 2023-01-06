package com.bci.users.infraestructure.repository.implementation.user;

import com.bci.users.domain.model.UserOutput;
import com.bci.users.domain.port.output.user.GetAllUserSortByNameRepository;
import com.bci.users.infraestructure.repository.jpa.UserEntityRepository;
import com.bci.users.infraestructure.repository.mapper.IEntityToUserModelMapper;
import java.util.List;
import org.springframework.stereotype.Repository;
@Repository
public class GetAllUserSortByNameRepositoryImpl implements GetAllUserSortByNameRepository {

    private final UserEntityRepository repository;
    private final IEntityToUserModelMapper mapperToDomain;

    public GetAllUserSortByNameRepositoryImpl(UserEntityRepository repository,
                                              IEntityToUserModelMapper mapperToDomain) {
        this.repository = repository;
        this.mapperToDomain = mapperToDomain;
    }


    @Override
    public List<UserOutput> findAllByOrderByNameAsc() {
        return this.mapperToDomain.mapFormList(this.repository.findAllByOrderByNameAsc());
    }
}
