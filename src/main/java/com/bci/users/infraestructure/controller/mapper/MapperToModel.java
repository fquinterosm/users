package com.bci.users.infraestructure.controller.mapper;

import com.bci.users.api.model.ApiCustomValidation;
import com.bci.users.api.model.ApiPhones;
import com.bci.users.api.model.ApiUserLogin;
import com.bci.users.api.model.ApiUserRequest;
import com.bci.users.domain.model.CustomValidation;
import com.bci.users.domain.model.Phones;
import com.bci.users.domain.model.UserInput;
import com.bci.users.domain.model.UserLogin;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class MapperToModel implements IMapperToModel{

    @Override
    public UserInput mapForm(ApiUserRequest apiUserRequest) {
        UserInput userInput = new UserInput();
        userInput.setName(apiUserRequest.getName());
        userInput.setEmail(apiUserRequest.getEmail());
        userInput.setPassword(apiUserRequest.getPassword());
        userInput.setPhones(phonesMapper(apiUserRequest.getPhones()));
        return userInput;
    }

    @Override
    public UserLogin mapForm(ApiUserLogin apiUserLogin) {
        UserLogin userLogin = new UserLogin();
        userLogin.setEmail(apiUserLogin.getEmail());
        userLogin.setPassword(apiUserLogin.getPassword());
        return userLogin;
    }

    @Override
    public CustomValidation mapperCustomValidation(ApiCustomValidation apiCustomValidation) {
        CustomValidation customValidation = new CustomValidation();

        customValidation.setName(apiCustomValidation.getName());
        customValidation.setPattern(apiCustomValidation.getPattern());
        customValidation.setMessage(apiCustomValidation.getMessage());

        return customValidation;
    }

    private List<Phones> phonesMapper(List<ApiPhones> apiPhonesList) {

        List<Phones> phonesList = new ArrayList<>();
        Phones phone;

        for (ApiPhones apiPhone: apiPhonesList) {
            phone = new Phones();
            phone.setNumber(apiPhone.getNumber());
            phone.setCityCode(apiPhone.getCitycode());
            phone.setCountryCode(apiPhone.getContrycode());
            phonesList.add(phone);
        }

        return phonesList;

    }

}
