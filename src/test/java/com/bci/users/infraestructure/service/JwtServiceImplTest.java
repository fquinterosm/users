package com.bci.users.infraestructure.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class JwtServiceImplTest {


  private JwtServiceImpl service;


  @BeforeEach
  public void setUp() {
    service = new JwtServiceImpl();
  }

  @ParameterizedTest
  @NullAndEmptySource
  void should_return_null_when_send_email_null_or_empty(String email) {

    //GIVEN
    // ParameterizedTest

    //WHEN
    String response = service.execute(email);

    //THEN
    assertNull(response);

  }

  @Test
  void should_return_jwt_when_send_email() {

    final String expectedContains = "Bearer";
    //GIVEN
    final String email = "fco@fco.cl";

    //WHEN
    String response = service.execute(email);

    //THEN
    assertNotNull(response);
    assertTrue(response.contains(expectedContains));

  }

}