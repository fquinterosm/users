package com.bci.users.domain.usecase.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.bci.users.Mocks.UserMock;
import com.bci.users.domain.model.UserInput;
import com.bci.users.domain.model.UserOutput;
import com.bci.users.domain.port.output.customValidation.CustomValidationService;
import com.bci.users.domain.port.output.user.GetJWTToken;
import com.bci.users.domain.port.output.user.SaveUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SaveUserInRepositoryUseCaseTest {

  private SaveUserInRepositoryUseCase useCase;

  @Mock
  private SaveUserRepository saveUserRepository;
  @Mock
  private CustomValidationService customValidationService;
  @Mock
  private GetJWTToken getJWTToken;


  @BeforeEach
  public void setUp() {
    useCase = new SaveUserInRepositoryUseCase(saveUserRepository, customValidationService, getJWTToken);
  }

  @Test
  void should_return_user_output_saved() {

    final UserOutput userOutputExpected = UserMock.build_user_output_ok();

    //GIVEN
    UserInput userInput = UserMock.build_user_input_ok();

    //WHEN
    doNothing().when(customValidationService).validatePattern(anyString(), anyString());
    when(getJWTToken.execute("juan@rodriguez.org")).thenReturn("token");
    when(saveUserRepository.save(userInput)).thenReturn(userOutputExpected);

    UserOutput userOutputResponse = useCase.save(userInput);

    //THEN
    assertEquals(userOutputExpected.getName(), userOutputResponse.getName());

  }

}