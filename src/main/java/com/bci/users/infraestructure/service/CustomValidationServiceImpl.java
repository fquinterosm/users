package com.bci.users.infraestructure.service;

import com.bci.users.domain.model.CustomValidation;
import com.bci.users.domain.port.output.customValidation.CustomValidationService;
import com.bci.users.domain.port.output.customValidation.GetCustomValidationByNameRepository;
import com.bci.users.infraestructure.exception.ValidationException;
import java.util.regex.Pattern;
import org.springframework.stereotype.Component;

@Component
public class CustomValidationServiceImpl implements CustomValidationService {

  private final GetCustomValidationByNameRepository repository;

  public CustomValidationServiceImpl(GetCustomValidationByNameRepository repository) {
    this.repository = repository;
  }


  @Override
  public void validatePattern(String name, String value) {
    CustomValidation customValidation =  repository.execute(name);
    System.out.println("customValidation = " + customValidation);
    if(customValidation.getPattern() != null){
      if(!patternMatches(value, customValidation.getPattern())){
        throw new ValidationException(customValidation.getMessage());
      }
    }
  }

  private static boolean patternMatches(String value, String regexPattern) {
    return Pattern.compile(regexPattern)
        .matcher(value)
        .matches();
  }


}
