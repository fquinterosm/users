package com.bci.users.infraestructure.repository.implementation.user;

import com.bci.users.domain.port.output.user.GetPhonesByUserIdRepository;
import com.bci.users.infraestructure.repository.entity.PhonesEntity;
import com.bci.users.infraestructure.repository.jpa.PhonesEntityRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
public class GetPhonesByUserIdRepositoryImpl implements GetPhonesByUserIdRepository {

    private final PhonesEntityRepository repository;

    public GetPhonesByUserIdRepositoryImpl(PhonesEntityRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PhonesEntity> findAllByUserId(UUID id) {
        return null;
    }
}
