package com.FinanceManagerAPI.FinanceManagerAPI.Repositories;

import com.FinanceManagerAPI.FinanceManagerAPI.Entities.*;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, String> {

//@Query(value = "select * from users where email = :email and password = :password;",nativeQuery = true)
//    UserEntity validateuser(String email, String password);

    UserEntity findByEmail(String email);


    @Query(value = "SELECT * FROM public.insert_user(:firstname, :lastname, :email, :password, :phone_number);", nativeQuery = true)
    List<Object[]> insertUser(
            @Param("firstname") String firstname,
            @Param("lastname") String lastname,
            @Param("email") String email,
            @Param("password") String password,
            @Param("phone_number") String phoneNumber
    );

}

