package com.example.final_pract.service;

import com.example.final_pract.entity.ActorEntity;
import java.util.List;

public interface ActorService {
    List<ActorEntity> getAllActors();
    ActorEntity getActorById(Long id);
    ActorEntity createActor(ActorEntity actor);
    ActorEntity updateActor(Long id, ActorEntity actor);
    void deleteActor(Long id);
}
