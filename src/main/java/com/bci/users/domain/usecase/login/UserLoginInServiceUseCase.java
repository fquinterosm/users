package com.bci.users.domain.usecase.login;

import com.bci.users.domain.model.UserLogin;
import com.bci.users.domain.model.UserOutput;
import com.bci.users.domain.port.input.login.UserLoginServiceUseCase;
import com.bci.users.domain.port.output.customValidation.CustomValidationService;
import com.bci.users.domain.port.output.user.GetJWTToken;
import com.bci.users.domain.port.output.user.GetUserByEmailAndPasswordRepository;
import com.bci.users.domain.port.output.user.UpdateUserRepository;
import java.util.Date;

public class UserLoginInServiceUseCase implements UserLoginServiceUseCase {

    private final GetJWTToken getJWTToken;
    private final GetUserByEmailAndPasswordRepository getUserByEmailAndPasswordRepository;
    private final UpdateUserRepository updateUserRepository;
    private final CustomValidationService customValidationService;

    public UserLoginInServiceUseCase(GetJWTToken getJWTToken,
                                     GetUserByEmailAndPasswordRepository getUserByEmailAndPasswordRepository,
                                     UpdateUserRepository updateUserRepository,
                                     CustomValidationService customValidationService) {
        this.getJWTToken = getJWTToken;
        this.getUserByEmailAndPasswordRepository = getUserByEmailAndPasswordRepository;
        this.updateUserRepository = updateUserRepository;
        this.customValidationService = customValidationService;
    }

    @Override
    public UserOutput execute(UserLogin userLogin) {
        customValidationService.validatePattern("email", userLogin.getEmail());
        UserOutput userOutput = getUserByEmailAndPasswordRepository.execute(userLogin.getEmail(), userLogin.getPassword());
        String token = getJWTToken.execute(userLogin.getEmail());
        userOutput.setToken(token);
        userOutput.setLastLogin(new Date());
        System.out.println("userOutput = " + userOutput);
        UserOutput userOutputUpdated = updateUserRepository.update(userOutput);
        return userOutputUpdated;
    }

}
