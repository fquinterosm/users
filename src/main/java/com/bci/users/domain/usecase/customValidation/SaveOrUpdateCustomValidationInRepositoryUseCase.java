package com.bci.users.domain.usecase.customValidation;

import com.bci.users.domain.model.CustomValidation;
import com.bci.users.domain.port.input.customValidation.SaveOrUpdateCustomValidationRepositoryUseCase;
import com.bci.users.domain.port.output.customValidation.SaveOrUpdateCustomValidationRepository;

public class SaveOrUpdateCustomValidationInRepositoryUseCase implements SaveOrUpdateCustomValidationRepositoryUseCase {

  private final SaveOrUpdateCustomValidationRepository repository;

  public SaveOrUpdateCustomValidationInRepositoryUseCase(
      SaveOrUpdateCustomValidationRepository repository) {
    this.repository = repository;
  }

  @Override
  public CustomValidation saveOrUpdate(CustomValidation customValidation) {
    return repository.saveOrUpdate(customValidation);
  }
}
