package com.bci.users.domain.usecase.user;

import com.bci.users.domain.model.UserOutput;
import com.bci.users.domain.port.input.user.GetUserByIdRepositoryUseCase;
import com.bci.users.domain.port.output.user.GetUserByIdRepository;
import java.util.UUID;

public class GetUserByIdInRepositoryUseCase implements GetUserByIdRepositoryUseCase {

    private final GetUserByIdRepository getUserByIdRepository;

    public GetUserByIdInRepositoryUseCase(GetUserByIdRepository getUserByIdRepository) {
        this.getUserByIdRepository = getUserByIdRepository;
    }

    @Override
    public UserOutput execute(UUID id) {
        return getUserByIdRepository.execute(id);
    }
}
