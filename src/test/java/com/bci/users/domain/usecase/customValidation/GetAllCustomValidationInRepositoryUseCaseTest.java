package com.bci.users.domain.usecase.customValidation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.bci.users.Mocks.CustomValidationMock;
import com.bci.users.domain.model.CustomValidation;
import com.bci.users.domain.port.output.customValidation.GetAllCustomValidationRepository;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GetAllCustomValidationInRepositoryUseCaseTest {


  private GetAllCustomValidationInRepositoryUseCase useCase;

  @Mock
  private GetAllCustomValidationRepository repository;


  @BeforeEach
  public void setUp() {
    useCase = new GetAllCustomValidationInRepositoryUseCase(repository);
  }


  @Test
  void should_return_customValidation_list() {

    final String[] namesExpected = getDataExpected();
    //GIVEN
    List<CustomValidation> customValidationList = CustomValidationMock.build_custom_validation_list();
    when(repository.execute()).thenReturn(customValidationList);

    //WHEN
    Iterator<CustomValidation> it = useCase.execute().iterator();

    //THEN
    int index = 0;
    while (it.hasNext()) {
      assertEquals(namesExpected[index], it.next().getName());
      index++;
    }


  }


  private String[] getDataExpected() {
    return new String[] {
        "email",
        "password"
    };
  }

}