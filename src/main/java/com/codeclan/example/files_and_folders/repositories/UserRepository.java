package com.codeclan.example.files_and_folders.repositories;

import com.codeclan.example.files_and_folders.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
