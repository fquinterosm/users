package com.bci.users.domain.port.input.user;

import com.bci.users.domain.model.UserOutput;
import java.util.List;

public interface GetAllUserSortByNameRepositoryUseCase {
    List<UserOutput> execute();
}
