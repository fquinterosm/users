package com.bci.users.infraestructure.repository.mapper;

import com.bci.users.domain.model.Phones;
import com.bci.users.domain.model.UserOutput;
import com.bci.users.infraestructure.repository.entity.PhonesEntity;
import com.bci.users.infraestructure.repository.entity.UserEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
@Component
public class EntityToUserModelMapper implements IEntityToUserModelMapper {


    @Override
    public UserOutput mapForm(UserEntity userEntity) {
        UserOutput userOutput = new UserOutput();

        userOutput.setId(userEntity.getId());
        userOutput.setName(userEntity.getName());
        userOutput.setEmail(userEntity.getEmail());
        userOutput.setPassword(userEntity.getPassword());
        userOutput.setPhones(phonesMapper(userEntity.getPhones()));
        userOutput.setCreated(userEntity.getCreated());
        userOutput.setModified(userEntity.getModified());
        userOutput.setLastLogin(userEntity.getLastLogin());
        userOutput.setToken(userEntity.getToken());
        userOutput.setIsActive(userEntity.getIsActive());

        return userOutput;
    }

    @Override
    public List<UserOutput> mapFormList(List<UserEntity> userEntityList) {
        List<UserOutput> userOutputList = new ArrayList<>();

        for (UserEntity userEntity : userEntityList) {
            userOutputList.add(mapForm(userEntity));
        }

        return userOutputList;
    }


    private List<Phones> phonesMapper(List<PhonesEntity> phonesEntityList) {

        List<Phones> phonesList = new ArrayList<>();
        Phones phone;

        for (PhonesEntity phoneEntity: phonesEntityList) {
            phone = new Phones();
            phone.setId(phoneEntity.getId());
            phone.setNumber(phoneEntity.getNumber());
            phone.setCityCode(phoneEntity.getCityCode());
            phone.setCountryCode(phoneEntity.getCountryCode());
            phonesList.add(phone);
        }

        return phonesList;

    }

}
