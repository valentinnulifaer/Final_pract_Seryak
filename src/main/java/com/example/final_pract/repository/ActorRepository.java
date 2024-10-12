package com.example.final_pract.repository;

import com.example.final_pract.entity.ActorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<ActorEntity, Long> {

}
