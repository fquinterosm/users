package com.bci.users.domain.port.output.login;

import com.bci.users.domain.model.UserLogin;

public interface UserLoginService {

    UserLogin execute(UserLogin user);
}
