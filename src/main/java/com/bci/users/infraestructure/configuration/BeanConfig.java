package com.bci.users.infraestructure.configuration;


import com.bci.users.domain.port.input.customValidation.GetAllCustomValidationRepositoryUseCase;
import com.bci.users.domain.port.input.customValidation.SaveOrUpdateCustomValidationRepositoryUseCase;
import com.bci.users.domain.port.input.login.UserLoginServiceUseCase;
import com.bci.users.domain.port.input.user.DeleteUserByIdRepositoryUseCase;
import com.bci.users.domain.port.input.user.GetUserByIdRepositoryUseCase;
import com.bci.users.domain.port.input.user.SaveUserRepositoryUseCase;
import com.bci.users.domain.usecase.customValidation.GetAllCustomValidationInRepositoryUseCase;
import com.bci.users.domain.usecase.customValidation.SaveOrUpdateCustomValidationInRepositoryUseCase;
import com.bci.users.domain.usecase.login.UserLoginInServiceUseCase;
import com.bci.users.domain.usecase.user.DeleteUserByIdInRepositoryUseCase;
import com.bci.users.domain.usecase.user.GetAllUsersSortByNameUseCase;
import com.bci.users.domain.usecase.user.GetUserByIdInRepositoryUseCase;
import com.bci.users.domain.usecase.user.SaveUserInRepositoryUseCase;
import com.bci.users.infraestructure.repository.implementation.customValidation.GetAllCustomValidationRepositoryImpl;
import com.bci.users.infraestructure.repository.implementation.customValidation.SaveOrUpdateCustomValidationRepositoryImpl;
import com.bci.users.infraestructure.repository.implementation.user.DeleteUserByIdRepositoryImpl;
import com.bci.users.infraestructure.repository.implementation.user.GetAllUserSortByNameRepositoryImpl;
import com.bci.users.infraestructure.repository.implementation.user.GetUserByEmailAndPasswordRepositoryImpl;
import com.bci.users.infraestructure.repository.implementation.user.GetUserByIdRepositoryImpl;
import com.bci.users.infraestructure.repository.implementation.user.SaveUserRepositoryImpl;
import com.bci.users.infraestructure.repository.implementation.user.UpdateUserRepositoryImpl;
import com.bci.users.infraestructure.service.CustomValidationServiceImpl;
import com.bci.users.infraestructure.service.JwtServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public GetUserByIdRepositoryUseCase getUserByIdRepositoryUseCase(GetUserByIdRepositoryImpl repository) {
        return new GetUserByIdInRepositoryUseCase(repository);
    }

    @Bean
    public DeleteUserByIdRepositoryUseCase deleteUserByIdRepositoryUseCase(DeleteUserByIdRepositoryImpl repository) {
        return new DeleteUserByIdInRepositoryUseCase(repository);
    }

    @Bean
    public SaveUserRepositoryUseCase saveUserRepositoryUseCase(SaveUserRepositoryImpl repository, CustomValidationServiceImpl customValidationService, JwtServiceImpl jwt) {
        return new SaveUserInRepositoryUseCase(repository, customValidationService, jwt);
    }

    @Bean
    public GetAllUsersSortByNameUseCase getAllUsersSortByNameUseCase(GetAllUserSortByNameRepositoryImpl repository) {
        return new GetAllUsersSortByNameUseCase(repository);
    }

    @Bean
    public UserLoginServiceUseCase userLoginServiceUseCase(JwtServiceImpl jwt, GetUserByEmailAndPasswordRepositoryImpl repository, UpdateUserRepositoryImpl updateUserRepositoryImpl, CustomValidationServiceImpl customValidationServiceImpl) {
        return new UserLoginInServiceUseCase(jwt, repository, updateUserRepositoryImpl, customValidationServiceImpl);
    }

    @Bean
    public GetAllCustomValidationRepositoryUseCase getAllCustomValidationRepositoryUseCase(
        GetAllCustomValidationRepositoryImpl repository) {
        return new GetAllCustomValidationInRepositoryUseCase(repository);
    }

    @Bean
    public SaveOrUpdateCustomValidationRepositoryUseCase saveOrUpdateCustomValidationRepositoryUseCase(
        SaveOrUpdateCustomValidationRepositoryImpl repository) {
        return new SaveOrUpdateCustomValidationInRepositoryUseCase(repository);
    }

}
