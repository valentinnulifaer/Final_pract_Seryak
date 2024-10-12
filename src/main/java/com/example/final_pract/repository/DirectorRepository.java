package com.example.final_pract.repository;

import com.example.final_pract.entity.DirectorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository<DirectorEntity, Long> {

}
