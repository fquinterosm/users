package com.bci.users.Mocks;

import com.bci.users.api.model.ApiUserLogin;
import com.bci.users.api.model.ApiUserResponse;
import com.bci.users.domain.model.UserInput;
import com.bci.users.domain.model.UserLogin;
import com.bci.users.domain.model.UserOutput;
import com.bci.users.infraestructure.repository.entity.UserEntity;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;

public class UserMock {


  public static UserOutput build_user_output_ok() {
    String jsonFile = "UserOutPutOk.json";
    return TestUtil.buildObjectFromFile(jsonFile, new TypeReference<UserOutput>() {
    });
  }

  public static UserInput build_user_input_ok() {
    String jsonFile = "UserInputOk.json";
    return TestUtil.buildObjectFromFile(jsonFile, new TypeReference<UserInput>() {
    });
  }

  public static UserLogin build_user_login_ok() {
    String jsonFile = "UserLoginOk.json";
    return TestUtil.buildObjectFromFile(jsonFile, new TypeReference<UserLogin>() {
    });
  }

  public static ApiUserLogin build_api_user_login_ok() {
    String jsonFile = "ApiUserLoginOk.json";
    return TestUtil.buildObjectFromFile(jsonFile, new TypeReference<ApiUserLogin>() {
    });
  }

  public static ApiUserResponse build_api_user_response_ok() {
    String jsonFile = "ApiUserResponseOk.json";
    return TestUtil.buildObjectFromFile(jsonFile, new TypeReference<ApiUserResponse>() {
    });
  }

  public static List<UserOutput> build_user_output_ok_list() {
    String jsonFile = "UserOutPutOkList.json";
    return TestUtil.buildObjectFromFile(jsonFile, new TypeReference<List<UserOutput>>() {
    });
  }

  public static List<UserEntity> build_user_entity_ok_list() {
    String jsonFile = "UserEntityOkList.json";
    return TestUtil.buildObjectFromFile(jsonFile, new TypeReference<List<UserEntity>>() {
    });
  }

}
