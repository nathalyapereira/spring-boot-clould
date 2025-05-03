package me.dio.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.dio.domain.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long>{
    
}
