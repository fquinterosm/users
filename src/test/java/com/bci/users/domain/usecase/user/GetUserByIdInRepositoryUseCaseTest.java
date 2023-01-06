package com.bci.users.domain.usecase.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.bci.users.Mocks.UserMock;
import com.bci.users.domain.model.UserOutput;
import com.bci.users.domain.port.output.user.GetUserByIdRepository;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GetUserByIdInRepositoryUseCaseTest {


  private GetUserByIdInRepositoryUseCase useCase;

  @Mock
  private GetUserByIdRepository repository;


  @BeforeEach
  public void setUp() {
    useCase = new GetUserByIdInRepositoryUseCase(repository);
  }

  @Test
  void should_return_user_output() {

    final UserOutput userOutputExpected = UserMock.build_user_output_ok();
    final UUID uuid = UUID.fromString("e4bd14ec-5fd5-4b70-a418-ce27eb2f1cac");
    //GIVEN

    //WHEN
    when(repository.execute(uuid)).thenReturn(userOutputExpected);
    UserOutput userOutputResponse = repository.execute(uuid);

    //THEN
    assertEquals(userOutputExpected.getId(), userOutputResponse.getId());

  }



}