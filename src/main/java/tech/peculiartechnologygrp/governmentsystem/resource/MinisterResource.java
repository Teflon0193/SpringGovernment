package tech.peculiartechnologygrp.governmentsystem.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.peculiartechnologygrp.governmentsystem.model.Minister;
import tech.peculiartechnologygrp.governmentsystem.service.MinisterService;

import java.util.List;

@RestController
@RequestMapping("/government")
public class MinisterResource {
    private final MinisterService ministerService;

    public MinisterResource(MinisterService ministerService) {
        this.ministerService = ministerService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Minister>> getAllMinisters () {
        List<Minister> ministers = ministerService.findAllMinisters();
        return new ResponseEntity<>(ministers, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Minister> getMinisterById (@PathVariable("id") Long id) {
        Minister minister = ministerService.findMinisterById(id);
        return new ResponseEntity<>(minister, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Minister> addMinister(@RequestBody Minister minister) {
        Minister newMinister = ministerService.addMinister(minister);
        return new ResponseEntity<>(newMinister, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Minister> updateMinister(@RequestBody Minister minister) {
        Minister updateMinister = ministerService.updateMinister(minister);
        return new ResponseEntity<>(updateMinister, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMinister(@PathVariable("id") Long id) {
        ministerService.deleteMinister(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
