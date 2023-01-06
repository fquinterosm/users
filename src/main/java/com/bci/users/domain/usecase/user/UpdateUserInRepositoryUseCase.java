package com.bci.users.domain.usecase.user;

import com.bci.users.domain.model.UserOutput;
import com.bci.users.domain.port.input.user.UpdateUserRepositoryUseCase;
import com.bci.users.domain.port.output.user.UpdateUserRepository;

public class UpdateUserInRepositoryUseCase implements UpdateUserRepositoryUseCase {

    private final UpdateUserRepository updateUserRepository;

    public UpdateUserInRepositoryUseCase(UpdateUserRepository updateUserRepository) {
        this.updateUserRepository = updateUserRepository;
    }


    @Override
    public UserOutput update(UserOutput userOutput) {
        return this.updateUserRepository.update(userOutput);
    }
}
