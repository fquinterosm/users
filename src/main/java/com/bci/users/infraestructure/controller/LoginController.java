package com.bci.users.infraestructure.controller;


import com.bci.users.api.LoginApi;
import com.bci.users.api.model.ApiUserLogin;
import com.bci.users.api.model.ApiUserResponse;
import com.bci.users.domain.port.input.login.UserLoginServiceUseCase;
import com.bci.users.infraestructure.controller.mapper.IMapperToModel;
import com.bci.users.infraestructure.controller.mapper.IMapperToResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController implements LoginApi {

    private final UserLoginServiceUseCase userLoginServiceUseCase;
    private final IMapperToResponse mapperToResponse;
    private final IMapperToModel mapperToModel;

    public LoginController(UserLoginServiceUseCase userLoginServiceUseCase, IMapperToResponse mapperToResponse, IMapperToModel mapperToModel) {
        this.userLoginServiceUseCase = userLoginServiceUseCase;
        this.mapperToResponse = mapperToResponse;
        this.mapperToModel = mapperToModel;
    }

    @Override
    public ResponseEntity<ApiUserResponse> userLogin(ApiUserLogin login) {
        return ResponseEntity.ok(mapperToResponse.mapperUser(userLoginServiceUseCase.execute(mapperToModel.mapForm(login))));
    }

}
