package com.bci.users.domain.usecase.user;

import com.bci.users.domain.model.UserOutput;
import com.bci.users.domain.port.input.user.GetAllUserSortByNameRepositoryUseCase;
import com.bci.users.domain.port.output.user.GetAllUserSortByNameRepository;
import java.util.List;

public class GetAllUsersSortByNameUseCase implements GetAllUserSortByNameRepositoryUseCase {

    private final GetAllUserSortByNameRepository getAllUserSortByNameRepository;

    public GetAllUsersSortByNameUseCase(GetAllUserSortByNameRepository getAllUserSortByNameRepository) {
        this.getAllUserSortByNameRepository = getAllUserSortByNameRepository;
    }


    @Override
    public List<UserOutput> execute() {
        return this.getAllUserSortByNameRepository.findAllByOrderByNameAsc();
    }
}
