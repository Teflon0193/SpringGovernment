package tech.peculiartechnologygrp.governmentsystem.service;

import org.springframework.stereotype.Service;
import tech.peculiartechnologygrp.governmentsystem.exception.UserNotFoundException;
import tech.peculiartechnologygrp.governmentsystem.model.Minister;
import tech.peculiartechnologygrp.governmentsystem.repository.MinisterRepo;


import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Transactional
@Service
public class MinisterService {
    private final MinisterRepo ministerRepo;

    public MinisterService(MinisterRepo ministerRepo) {

        this.ministerRepo = ministerRepo;
    }

    public Minister addMinister(Minister minister) {
        minister.setMinisterCode(UUID.randomUUID().toString());
        return ministerRepo.save(minister);
    }

    public List<Minister> findAllMinisters() {

        return ministerRepo.findAll();
    }

    public Minister updateMinister(Minister minister) {

        return ministerRepo.save(minister);
    }

    public Minister findMinisterById(Long id) {
        return ministerRepo.findMinisterById(id).
                orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteMinister(Long id){

        ministerRepo.deleteMinisterById(id);
    }
}
