package com.bci.users.infraestructure.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.bci.users.Mocks.CustomValidationMock;
import com.bci.users.domain.port.output.customValidation.GetCustomValidationByNameRepository;
import com.bci.users.infraestructure.exception.ValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CustomValidationServiceImplTest {

  private CustomValidationServiceImpl service;

  @Mock
  private GetCustomValidationByNameRepository repository;


  @BeforeEach
  public void setUp() {
    service = new CustomValidationServiceImpl(repository);
  }


  @ParameterizedTest
  @CsvSource(value = {"email:fco@hotmail.com", "email:juan@rodriguez.org", "email:admin@admin.com"}, delimiter = ':')
  //@Test
  void should_return_true_when_send_a_valid_email(String name, String value) {
    final int numberOfInvocationsExpected = 1;
    //GIVEN
      //ParameterizedTest
    //WHEN
    when(repository.execute(name)).thenReturn(CustomValidationMock.build_custom_validation_ok());
    service.validatePattern(name, value);

    //THEN
    verify(repository,times(numberOfInvocationsExpected)).execute(name);
  }


  @ParameterizedTest
  @CsvSource(value = {"email:fco", "email:juan@", "email:@admin.com"}, delimiter = ':')
  void should_return_false_when_send_a_invalid_email(String name, String value) {

    final int numberOfInvocationsExpected = 1;
    //GIVEN
    //ParameterizedTest

    //WHEN
    when(repository.execute(name)).thenReturn(CustomValidationMock.build_custom_validation_ok());

    Exception thrown = assertThrows(ValidationException.class,
        () -> service.validatePattern(name, value));

    //THEN
    verify(repository,times(numberOfInvocationsExpected)).execute(name);

  }




}