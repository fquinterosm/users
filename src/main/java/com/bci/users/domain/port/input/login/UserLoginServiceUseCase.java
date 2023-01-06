package com.bci.users.domain.port.input.login;

import com.bci.users.domain.model.UserLogin;
import com.bci.users.domain.model.UserOutput;

public interface UserLoginServiceUseCase {

    UserOutput execute(UserLogin user);


}
