package com.bci.users.infraestructure.repository.jpa;

import com.bci.users.infraestructure.repository.entity.UserEntity;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntityRepository extends JpaRepository<UserEntity, UUID> {
    List<UserEntity> findAllByOrderByNameAsc();
    Optional<UserEntity> findOneByEmailAndPassword(String email, String password);
    boolean existsByEmail(String email);
}
