package com.bci.users.domain.port.input.customValidation;

import com.bci.users.domain.model.CustomValidation;


public interface SaveOrUpdateCustomValidationRepositoryUseCase {
    CustomValidation saveOrUpdate(CustomValidation customValidation);
}
