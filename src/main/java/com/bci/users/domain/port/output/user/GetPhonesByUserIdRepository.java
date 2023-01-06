package com.bci.users.domain.port.output.user;

import com.bci.users.infraestructure.repository.entity.PhonesEntity;
import java.util.List;
import java.util.UUID;

public interface GetPhonesByUserIdRepository {

    List<PhonesEntity> findAllByUserId(UUID id);

}
