package com.bci.users.domain.port.input.user;

import com.bci.users.domain.model.UserInput;
import com.bci.users.domain.model.UserOutput;


public interface SaveUserRepositoryUseCase {
    UserOutput save(UserInput userInput);
}
