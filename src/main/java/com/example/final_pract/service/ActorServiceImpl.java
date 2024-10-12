package com.example.final_pract.service;

import com.example.final_pract.entity.ActorEntity;
import com.example.final_pract.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {

    @Autowired
    private ActorRepository actorRepository;

    @Override
    public List<ActorEntity> getAllActors() {
        return actorRepository.findAll();
    }

    @Override
    public ActorEntity getActorById(Long id) {
        return actorRepository.findById(id).orElse(null);
    }

    @Override
    public ActorEntity createActor(ActorEntity actor) {
        return actorRepository.save(actor);
    }

    @Override
    public ActorEntity updateActor(Long id, ActorEntity actor) {
        actor.setId(id);
        return actorRepository.save(actor);
    }

    @Override
    public void deleteActor(Long id) {
        actorRepository.deleteById(id);
    }
}
