package com.codeclan.example.files_and_folders.repositories;

import com.codeclan.example.files_and_folders.models.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {
}
