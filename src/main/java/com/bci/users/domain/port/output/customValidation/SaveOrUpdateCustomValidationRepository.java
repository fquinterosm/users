package com.bci.users.domain.port.output.customValidation;

import com.bci.users.domain.model.CustomValidation;

public interface SaveOrUpdateCustomValidationRepository {

    CustomValidation saveOrUpdate(CustomValidation customValidation);

}
