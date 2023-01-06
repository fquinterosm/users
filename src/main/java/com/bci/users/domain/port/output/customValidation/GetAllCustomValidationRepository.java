package com.bci.users.domain.port.output.customValidation;

import com.bci.users.domain.model.CustomValidation;
import java.util.List;

public interface GetAllCustomValidationRepository {

    List<CustomValidation> execute();
}
