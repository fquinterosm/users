package com.bci.users.infraestructure.repository.mapper;

import com.bci.users.domain.model.UserOutput;
import com.bci.users.infraestructure.repository.entity.UserEntity;
import java.util.List;

public interface IEntityToUserModelMapper {

    UserOutput mapForm(UserEntity userEntity);
    List<UserOutput> mapFormList(List<UserEntity> userEntity);
}
