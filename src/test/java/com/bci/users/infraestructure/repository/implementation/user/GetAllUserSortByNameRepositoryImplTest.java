package com.bci.users.infraestructure.repository.implementation.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.bci.users.Mocks.UserMock;
import com.bci.users.domain.model.UserOutput;
import com.bci.users.infraestructure.repository.entity.UserEntity;
import com.bci.users.infraestructure.repository.jpa.UserEntityRepository;
import com.bci.users.infraestructure.repository.mapper.IEntityToUserModelMapper;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GetAllUserSortByNameRepositoryImplTest {

  private GetAllUserSortByNameRepositoryImpl repoImpl;

  @Mock
  private UserEntityRepository repository;
  @Mock
  private IEntityToUserModelMapper mapperToDomain;

  @BeforeEach
  public void setUp() {
    repoImpl = new GetAllUserSortByNameRepositoryImpl(repository, mapperToDomain);
  }


  @Test
  void should_return_user_output_list() {

    final String[] namesExpected = getDataExpected();

    //GIVEN
    List<UserOutput> userOutputList = UserMock.build_user_output_ok_list();
    List<UserEntity> userEntityList = UserMock.build_user_entity_ok_list();
    when(repository.findAllByOrderByNameAsc()).thenReturn(userEntityList);
    when(mapperToDomain.mapFormList(userEntityList)).thenReturn(userOutputList);

    //WHEN
    List<UserOutput> userOutputResponseList = repoImpl.findAllByOrderByNameAsc();

    //THEN

    Iterator<UserOutput> it = userOutputResponseList.iterator();

    int index = 0;
    while (it.hasNext()) {
      assertEquals(namesExpected[index], it.next().getName());
      index++;
    }


  }


  private String[] getDataExpected() {
    return new String[] {
        "Francisco Quinteros",
        "Juan Rodriguez"
    };
  }


}