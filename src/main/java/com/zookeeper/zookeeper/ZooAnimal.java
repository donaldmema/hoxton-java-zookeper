package com.zookeeper.zookeeper;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "zoo_animals")
public class ZooAnimal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String name;
    String species;
    String origin;
    Boolean isHungry;

    public ZooAnimal() {
    }
}
