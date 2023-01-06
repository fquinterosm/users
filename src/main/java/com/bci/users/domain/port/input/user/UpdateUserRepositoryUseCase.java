package com.bci.users.domain.port.input.user;

import com.bci.users.domain.model.UserOutput;


public interface UpdateUserRepositoryUseCase {
    UserOutput update(UserOutput userOutput);
}
