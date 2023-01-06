package com.bci.users.domain.usecase.login;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.bci.users.Mocks.UserMock;
import com.bci.users.domain.model.UserLogin;
import com.bci.users.domain.model.UserOutput;
import com.bci.users.domain.port.output.customValidation.CustomValidationService;
import com.bci.users.domain.port.output.user.GetUserByEmailAndPasswordRepository;
import com.bci.users.domain.port.output.user.UpdateUserRepository;
import com.bci.users.infraestructure.service.JwtServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserLoginInServiceUseCaseTest {

  private UserLoginInServiceUseCase useCase;

  @Mock
  private JwtServiceImpl getJWTToken;
  @Mock
  private GetUserByEmailAndPasswordRepository getUserByEmailAndPasswordRepository;
  @Mock
  private UpdateUserRepository updateUserRepository;
  @Mock
  private CustomValidationService customValidationService;


  @BeforeEach
  public void setUp() {
    useCase = new UserLoginInServiceUseCase(getJWTToken, getUserByEmailAndPasswordRepository, updateUserRepository,
        customValidationService);
  }


  @Test
  void should_return_user_output_list() {

    final UserOutput userOutputExpected = UserMock.build_user_output_ok();
    String email = "admin@admin.com";
    String token = "token";

    //GIVEN
    UserLogin userLogin = UserMock.build_user_login_ok();

    doNothing().when(customValidationService).validatePattern(anyString(), anyString());
    when(getJWTToken.execute(email)).thenReturn("token");
    when(getUserByEmailAndPasswordRepository.execute(userLogin.getEmail(), userLogin.getPassword())).thenReturn(userOutputExpected);
    when(updateUserRepository.update(userOutputExpected)).thenReturn(userOutputExpected);
    when(useCase.execute(userLogin)).thenReturn(userOutputExpected);

    //WHEN
    UserOutput userOutputResponse = useCase.execute(userLogin);

    //THEN

    assertEquals(userOutputResponse.getName(), userOutputExpected.getName());

  }

}