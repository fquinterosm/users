package com.bci.users.infraestructure.controller;

import com.bci.users.api.UserApi;
import com.bci.users.api.model.ApiUserRequest;
import com.bci.users.api.model.ApiUserResponse;
import com.bci.users.domain.model.UserOutput;
import com.bci.users.domain.port.input.user.DeleteUserByIdRepositoryUseCase;
import com.bci.users.domain.port.input.user.GetUserByIdRepositoryUseCase;
import com.bci.users.domain.port.input.user.SaveUserRepositoryUseCase;
import com.bci.users.infraestructure.controller.mapper.IMapperToModel;
import com.bci.users.infraestructure.controller.mapper.IMapperToResponse;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserApi {

    private final SaveUserRepositoryUseCase saveUserRepositoryUseCase;
    private final IMapperToResponse mapperToResponse;
    private final IMapperToModel mapperToModel;
    private final GetUserByIdRepositoryUseCase getUserByIdUseCase;

    private final DeleteUserByIdRepositoryUseCase deleteUserByIdUseCase;

    public UserController(SaveUserRepositoryUseCase saveUserRepositoryUseCase, IMapperToResponse mapperToResponse, IMapperToModel mapperToModel, GetUserByIdRepositoryUseCase getUserByIdUseCase, DeleteUserByIdRepositoryUseCase deleteUserByIdUseCase) {
        this.saveUserRepositoryUseCase = saveUserRepositoryUseCase;
        this.mapperToResponse = mapperToResponse;
        this.mapperToModel = mapperToModel;
        this.getUserByIdUseCase = getUserByIdUseCase;
        this.deleteUserByIdUseCase = deleteUserByIdUseCase;
    }


    @Override
    public ResponseEntity<ApiUserResponse> getUserById(UUID id) {
        return ResponseEntity.ok(mapperToResponse.mapperUser(getUserByIdUseCase.execute(id)));
    }

    @Override
    public ResponseEntity<ApiUserResponse> postUser(ApiUserRequest user) {
        UserOutput userOutput = saveUserRepositoryUseCase.save(mapperToModel.mapForm(user));
        ApiUserResponse apiUserResponse = mapperToResponse.mapperUser(userOutput);
        System.out.println("apiUserResponse POST = " + apiUserResponse);
        return new ResponseEntity<ApiUserResponse>(apiUserResponse, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ApiUserResponse> deleteUserById(UUID id) {
        return ResponseEntity.ok(mapperToResponse.mapperUser(deleteUserByIdUseCase.execute(id)));
    }

}
