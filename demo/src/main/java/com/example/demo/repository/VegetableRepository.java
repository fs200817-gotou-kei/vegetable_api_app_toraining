package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Vegetable;

@Repository
public interface VegetableRepository extends JpaRepository<Vegetable, Long> {

    // TODO: JPAの仕組み知りたい
    // TODO: interfaceなのになんでここで定義した奴使用できるの？
    List<Vegetable> findByColor(String color);

    List<Vegetable> findByNameContaining(String name);

}
