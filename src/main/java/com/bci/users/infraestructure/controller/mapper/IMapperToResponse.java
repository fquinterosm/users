package com.bci.users.infraestructure.controller.mapper;

import com.bci.users.api.model.ApiCustomValidation;
import com.bci.users.api.model.ApiCustomValidationsResponse;
import com.bci.users.api.model.ApiUserResponse;
import com.bci.users.api.model.ApiUsersResponse;
import com.bci.users.domain.model.CustomValidation;
import com.bci.users.domain.model.UserOutput;
import java.util.List;

public interface IMapperToResponse {

    ApiUserResponse mapperUser(UserOutput userOutput);
    ApiUsersResponse mapperUserList(List<UserOutput> userOutput);

    ApiCustomValidation mapperCustomValidation(CustomValidation customValidation);
    ApiCustomValidationsResponse mapperCustomValidationList(List<CustomValidation> customValidationList);
}
