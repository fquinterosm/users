package com.bci.users.infraestructure.repository.mapper;


import com.bci.users.domain.model.UserInput;
import com.bci.users.domain.model.UserOutput;
import com.bci.users.infraestructure.repository.entity.UserEntity;

public interface IUserModelToEntityMapper {

    UserEntity mapForm(UserInput userInput);
    UserEntity mapForm(UserOutput userOutput);
}
