package com.bci.users.domain.port.output.user;

import com.bci.users.domain.model.UserOutput;
import java.util.List;

public interface GetAllUserSortByNameRepository {

    List<UserOutput> findAllByOrderByNameAsc();

}
