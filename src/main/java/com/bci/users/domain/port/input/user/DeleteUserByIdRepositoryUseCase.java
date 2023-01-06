package com.bci.users.domain.port.input.user;

import com.bci.users.domain.model.UserOutput;
import java.util.UUID;


public interface DeleteUserByIdRepositoryUseCase {

    UserOutput execute(UUID id);
}
