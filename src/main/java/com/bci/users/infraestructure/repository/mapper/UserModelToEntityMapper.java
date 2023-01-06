package com.bci.users.infraestructure.repository.mapper;

import com.bci.users.domain.model.Phones;
import com.bci.users.domain.model.UserInput;
import com.bci.users.domain.model.UserOutput;
import com.bci.users.infraestructure.repository.entity.PhonesEntity;
import com.bci.users.infraestructure.repository.entity.UserEntity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Component;
@Component
public class UserModelToEntityMapper implements IUserModelToEntityMapper {

    @Override
    public UserEntity mapForm(UserInput userInput) {

        UserEntity userEntity = new UserEntity();
        Date date = new Date();
        userEntity.setName(userInput.getName());
        userEntity.setEmail(userInput.getEmail());
        userEntity.setPassword(userInput.getPassword());
        userEntity.setCreated(date);
        userEntity.setModified(date);
        userEntity.setLastLogin(date);
        userEntity.setToken(userInput.getToken());
        userEntity.setIsActive(Boolean.TRUE);
        userEntity.setPhones(phonesMapper(userInput.getPhones(), userEntity));
        
        return userEntity;
    }

    @Override
    public UserEntity mapForm(UserOutput userOutput) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userOutput.getId());
        userEntity.setName(userOutput.getName());
        userEntity.setEmail(userOutput.getEmail());
        userEntity.setPassword(userOutput.getPassword());
        userEntity.setCreated(userOutput.getCreated());
        userEntity.setModified(userOutput.getModified());
        userEntity.setLastLogin(userOutput.getLastLogin());
        userEntity.setToken(userOutput.getToken());
        userEntity.setIsActive(userOutput.getIsActive());
        userEntity.setPhones(phonesMapper(userOutput.getPhones(), userEntity));

        return userEntity;
    }

    private List<PhonesEntity> phonesMapper(List<Phones> phonesList, UserEntity userEntity) {

        List<PhonesEntity> phonesEntityList = new ArrayList<>();
        PhonesEntity phoneEntity;

        for (Phones phone: phonesList) {
            phoneEntity = new PhonesEntity();
            phoneEntity.setId(phone.getId());
            phoneEntity.setNumber(phone.getNumber());
            phoneEntity.setCityCode(phone.getCityCode());
            phoneEntity.setCountryCode(phone.getCountryCode());
            phonesEntityList.add(phoneEntity);
        }
        return phonesEntityList;
    }
}
