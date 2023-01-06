package com.bci.users.domain.usecase.customValidation;

import com.bci.users.domain.model.CustomValidation;
import com.bci.users.domain.port.input.customValidation.GetAllCustomValidationRepositoryUseCase;
import com.bci.users.domain.port.output.customValidation.GetAllCustomValidationRepository;
import java.util.List;

public class GetAllCustomValidationInRepositoryUseCase implements GetAllCustomValidationRepositoryUseCase {


  private final GetAllCustomValidationRepository repository;

  public GetAllCustomValidationInRepositoryUseCase(
      GetAllCustomValidationRepository repository) {
    this.repository = repository;
  }

  @Override
  public List<CustomValidation> execute() {
    return repository.execute();
  }
}
