package com.bci.users.domain.port.output.user;

import com.bci.users.domain.model.UserOutput;

public interface GetUserByEmailAndPasswordRepository {

    UserOutput execute(String email, String password);

}
