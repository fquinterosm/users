package com.bci.users.domain.port.output.user;

import com.bci.users.domain.model.UserOutput;
import java.util.UUID;

public interface DeleteUserByIdRepository {
    UserOutput execute(UUID id);
}
