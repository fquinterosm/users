package com.bci.users.infraestructure.controller.mapper;

import com.bci.users.api.model.ApiCustomValidation;
import com.bci.users.api.model.ApiCustomValidationsResponse;
import com.bci.users.api.model.ApiPhones;
import com.bci.users.api.model.ApiUserResponse;
import com.bci.users.api.model.ApiUsersResponse;
import com.bci.users.domain.model.CustomValidation;
import com.bci.users.domain.model.Phones;
import com.bci.users.domain.model.UserOutput;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class MapperToResponse implements IMapperToResponse{

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

    @Override
    public ApiUserResponse mapperUser(UserOutput userOutput) {

        ApiUserResponse apiUserResponse = new ApiUserResponse();
        apiUserResponse.setId(userOutput.getId());
        apiUserResponse.setName(userOutput.getName());
        apiUserResponse.setEmail(userOutput.getEmail());
        apiUserResponse.setPassword(userOutput.getPassword());
        apiUserResponse.setPhones(phonesMapper(userOutput.getPhones()));
        apiUserResponse.setCreated(sdf.format(userOutput.getCreated()));
        apiUserResponse.setModified(sdf.format(userOutput.getModified()));
        apiUserResponse.setLastLogin(sdf.format(userOutput.getLastLogin()));
        apiUserResponse.setToken(userOutput.getToken());
        apiUserResponse.setIsactive(userOutput.getIsActive());

        return apiUserResponse;
    }

    @Override
    public ApiUsersResponse mapperUserList(List<UserOutput> userOutputList) {

        ApiUsersResponse apiUsersResponse = new ApiUsersResponse();
        List<ApiUserResponse> apiUserResponseList = new ArrayList<>();
        for (UserOutput userOutput: userOutputList) {
            apiUserResponseList.add(mapperUser(userOutput));
        }
        apiUsersResponse.setUsers(apiUserResponseList);

        return apiUsersResponse;
    }

    @Override
    public ApiCustomValidation mapperCustomValidation(CustomValidation customValidation) {
        ApiCustomValidation apiCustomValidation = new ApiCustomValidation();
        apiCustomValidation.setName(customValidation.getName());
        apiCustomValidation.setPattern(customValidation.getPattern());
        apiCustomValidation.setMessage(customValidation.getMessage());

        return apiCustomValidation;
    }

    @Override
    public ApiCustomValidationsResponse mapperCustomValidationList(List<CustomValidation> customValidationList) {
        ApiCustomValidationsResponse apiCustomValidationsResponse = new ApiCustomValidationsResponse();
        List<ApiCustomValidation> customValidations = new ArrayList<>();
        for (CustomValidation customValidation : customValidationList) {
            customValidations.add(mapperCustomValidation(customValidation));
        }
        apiCustomValidationsResponse.setCustomValidations(customValidations);
        return apiCustomValidationsResponse;
    }

    private List<ApiPhones> phonesMapper(List<Phones> phonesList) {

        List<ApiPhones> apiPhonesList = new ArrayList<>();
        ApiPhones apiPhones;

        for (Phones phone: phonesList) {
            apiPhones = new ApiPhones();
            apiPhones.setNumber(phone.getNumber());
            apiPhones.setCitycode(phone.getCityCode());
            apiPhones.setContrycode(phone.getCountryCode());
            apiPhonesList.add(apiPhones);
        }

        return apiPhonesList;

    }
}
