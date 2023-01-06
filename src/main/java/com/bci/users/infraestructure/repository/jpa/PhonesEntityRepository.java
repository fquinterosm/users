package com.bci.users.infraestructure.repository.jpa;

import com.bci.users.infraestructure.repository.entity.PhonesEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhonesEntityRepository extends JpaRepository<PhonesEntity, UUID> {
    List<PhonesEntity> findAllByUserId(UUID id);
}
