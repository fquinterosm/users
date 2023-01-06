package com.bci.users.infraestructure.repository.jpa;

import com.bci.users.infraestructure.repository.entity.CustomValidationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomValidationEntityRepository extends JpaRepository<CustomValidationEntity, String> {

}
