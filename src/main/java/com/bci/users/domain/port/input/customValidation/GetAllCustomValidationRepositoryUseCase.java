package com.bci.users.domain.port.input.customValidation;

import com.bci.users.domain.model.CustomValidation;
import java.util.List;

public interface GetAllCustomValidationRepositoryUseCase {

    List<CustomValidation> execute();
}
