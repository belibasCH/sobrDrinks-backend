package com.example.sobrdrinks.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

import javax.swing.text.html.Option;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByRfId(String rfId);

    void deleteByRfId(String rfId);
}
