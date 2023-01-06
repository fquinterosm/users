package com.bci.users.domain.port.output.customValidation;

import com.bci.users.domain.model.CustomValidation;

public interface GetCustomValidationByNameRepository {

  CustomValidation execute(String name);

}
