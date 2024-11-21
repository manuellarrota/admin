package com.manuellarrota.admin.repositories;

import com.manuellarrota.admin.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByMail(String email);
    List<User> findByMailContaining(String keyWord);
}
