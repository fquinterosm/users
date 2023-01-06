package com.bci.users.domain.usecase.user;

import com.bci.users.domain.model.UserOutput;
import com.bci.users.domain.port.input.user.DeleteUserByIdRepositoryUseCase;
import com.bci.users.domain.port.output.user.DeleteUserByIdRepository;
import java.util.UUID;

public class DeleteUserByIdInRepositoryUseCase implements DeleteUserByIdRepositoryUseCase {

    private final DeleteUserByIdRepository deleteUserByIdRepository;

    public DeleteUserByIdInRepositoryUseCase(DeleteUserByIdRepository deleteUserByIdRepository) {
        this.deleteUserByIdRepository = deleteUserByIdRepository;
    }


    @Override
    public UserOutput execute(UUID id) {
        return deleteUserByIdRepository.execute(id);
    }
}
