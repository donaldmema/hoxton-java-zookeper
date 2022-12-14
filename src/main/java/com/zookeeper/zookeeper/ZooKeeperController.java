package com.zookeeper.zookeeper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZooKeeperController {

    @Autowired
    ZooAnimalRepository zooAnimalRepository;

    @GetMapping("/animals")
    public List<ZooAnimal> getZooAnimals() {
        return zooAnimalRepository.findAll();
    }

    @PostMapping("/animals")
    public ZooAnimal createAnimal(@RequestBody ZooAnimal animal) {
        ZooAnimal newAnimal = zooAnimalRepository.save(animal);
        return newAnimal;
    }

    @PatchMapping("/animals/{id}")
    public ZooAnimal updateAnimal(@RequestBody ZooAnimal animal, @PathVariable int id) {
        ZooAnimal updatedAnimal = zooAnimalRepository.save(animal);
        return updatedAnimal;
    }

    @DeleteMapping("/animals/{id}")
    public String deleteAnimal(@PathVariable int id) {
        zooAnimalRepository.deleteById(id);
        return ("Deleted animal with id: " + id);
    }

    @GetMapping("/animals/{id}")
    public ZooAnimal getZooAnimalById(int id) {
        ZooAnimal animal = zooAnimalRepository.findById(id).get();
        return animal;
    }
}

interface ZooAnimalRepository extends JpaRepository<ZooAnimal, Integer> {
}