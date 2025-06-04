package com.FinanceManagerAPI.FinanceManagerAPI.Repositories;

import com.FinanceManagerAPI.FinanceManagerAPI.Entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, String> {

@Query(value = "select * from users where email = :email and password = :password;",nativeQuery = true)
    UserEntity validateuser(String email, String password);
}
