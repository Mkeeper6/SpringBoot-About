package com.mkeeper.repository;

import com.mkeeper.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUserName(String userName);

    User findByUserNameAndPhone(String name, String phone);

    @Query("from t_user u where u.userName=:name")
    User findUser(@Param("name") String name);

}
