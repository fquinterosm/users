package com.bci.users.domain.port.output.user;

import com.bci.users.domain.model.UserInput;
import com.bci.users.domain.model.UserOutput;

public interface SaveUserRepository {

    UserOutput save(UserInput userInput);

}
