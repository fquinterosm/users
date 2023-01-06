package com.bci.users.infraestructure.controller.mapper;

import com.bci.users.api.model.ApiCustomValidation;
import com.bci.users.api.model.ApiUserLogin;
import com.bci.users.api.model.ApiUserRequest;
import com.bci.users.domain.model.CustomValidation;
import com.bci.users.domain.model.UserInput;
import com.bci.users.domain.model.UserLogin;

public interface IMapperToModel {

    UserInput mapForm(ApiUserRequest apiUserRequest);
    UserLogin mapForm(ApiUserLogin apiUserLogin);
    CustomValidation mapperCustomValidation(ApiCustomValidation apiCustomValidation);
}
