package com.example.test.Repository;

import com.example.test.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ClientRepo extends JpaRepository<Client , Long> {


    Optional<Client> findByEmail(String email);

    Boolean  existsByEmail (String email);
}
