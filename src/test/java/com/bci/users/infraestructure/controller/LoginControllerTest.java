package com.bci.users.infraestructure.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.bci.users.Mocks.UserMock;
import com.bci.users.api.model.ApiUserLogin;
import com.bci.users.api.model.ApiUserResponse;
import com.bci.users.domain.model.UserLogin;
import com.bci.users.domain.model.UserOutput;
import com.bci.users.domain.port.input.login.UserLoginServiceUseCase;
import com.bci.users.infraestructure.controller.mapper.IMapperToModel;
import com.bci.users.infraestructure.controller.mapper.IMapperToResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
class LoginControllerTest {

  private LoginController loginController;

  @Mock
  private UserLoginServiceUseCase userLoginServiceUseCase;
  @Mock
  private IMapperToResponse mapperToResponse;
  @Mock
  private IMapperToModel mapperToModel;


  @BeforeEach
  public void setUp() {
    loginController = new LoginController(userLoginServiceUseCase, mapperToResponse, mapperToModel);
  }

  @Test
  void should_return_api_user_and_status_200() {
    int expectedStatusCode = 200;
    final ApiUserResponse apiUserResponseExpected = UserMock.build_api_user_response_ok();

    //GIVEN
    String email = "juan@rodriguez.org";
    String token = "token";
    UserLogin userLogin = UserMock.build_user_login_ok();
    ApiUserLogin apiUserLogin = UserMock.build_api_user_login_ok();
    UserOutput userOutput = UserMock.build_user_output_ok();

    //WHEN
    when(mapperToModel.mapForm(apiUserLogin)).thenReturn(userLogin);
    when(userLoginServiceUseCase.execute(userLogin)).thenReturn(userOutput);
    when(mapperToResponse.mapperUser(userOutput)).thenReturn(apiUserResponseExpected);

    ResponseEntity<ApiUserResponse> responseEntity = loginController.userLogin(apiUserLogin);


    //WHEN
    assertEquals(expectedStatusCode, responseEntity.getStatusCodeValue());
    assertEquals(apiUserResponseExpected.getName(), responseEntity.getBody().getName());

  }


}