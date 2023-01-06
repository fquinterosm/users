package com.bci.users.domain.usecase.user;

import com.bci.users.domain.model.UserInput;
import com.bci.users.domain.model.UserOutput;
import com.bci.users.domain.port.input.user.SaveUserRepositoryUseCase;
import com.bci.users.domain.port.output.customValidation.CustomValidationService;
import com.bci.users.domain.port.output.user.GetJWTToken;
import com.bci.users.domain.port.output.user.SaveUserRepository;

public class SaveUserInRepositoryUseCase implements SaveUserRepositoryUseCase {

    private final SaveUserRepository saveUserRepository;
    private final CustomValidationService customValidationService;
    private final GetJWTToken getJWTToken;

    public SaveUserInRepositoryUseCase(SaveUserRepository saveUserRepository,
                                       CustomValidationService customValidationService,
                                       GetJWTToken getJWTToken) {
        this.saveUserRepository = saveUserRepository;
        this.customValidationService = customValidationService;
        this.getJWTToken = getJWTToken;
    }

    @Override
    public UserOutput save(UserInput userInput) {
        customValidationService.validatePattern("email", userInput.getEmail());
        customValidationService.validatePattern("password", userInput.getPassword());
        String token = getJWTToken.execute(userInput.getEmail());
        userInput.setToken(token);
        return this.saveUserRepository.save(userInput);
    }
}
