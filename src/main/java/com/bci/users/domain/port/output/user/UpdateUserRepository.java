package com.bci.users.domain.port.output.user;

import com.bci.users.domain.model.UserOutput;

public interface UpdateUserRepository {

    UserOutput update(UserOutput userOutput);

}
