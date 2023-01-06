package com.bci.users.infraestructure.controller;

import com.bci.users.api.UsersApi;
import com.bci.users.api.model.ApiUsersResponse;
import com.bci.users.domain.port.input.user.GetAllUserSortByNameRepositoryUseCase;
import com.bci.users.infraestructure.controller.mapper.IMapperToResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController implements UsersApi {


    private final GetAllUserSortByNameRepositoryUseCase getAllUserSortByNameRepositoryUseCase;
    private final IMapperToResponse mapperToResponse;

    public UsersController(GetAllUserSortByNameRepositoryUseCase getAllUserSortByNameRepositoryUseCase, IMapperToResponse mapperToResponse) {
        this.getAllUserSortByNameRepositoryUseCase = getAllUserSortByNameRepositoryUseCase;
        this.mapperToResponse = mapperToResponse;
    }

    @Override
    public ResponseEntity<ApiUsersResponse> getUsers() {
        return ResponseEntity.ok(mapperToResponse.mapperUserList(getAllUserSortByNameRepositoryUseCase.execute()));
    }
}
