package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Vegetable;

@RestController
@CrossOrigin()
@RequestMapping("/vegetables")
public class VegetableController {

    @GetMapping("/list")
    public ResponseEntity<List<Vegetable>> getAll(@RequestParam(required = false) String name) {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vegetable> getById(long id) {
        return null;
    }

    @PostMapping("/")
    public ResponseEntity<Vegetable> create(Vegetable vegetable) {
        return null;
    }

    @PutMapping("/")
    public ResponseEntity<Vegetable> update(long id, Vegetable vegetable) {
        return null;
    }

    @DeleteMapping("/")
    public ResponseEntity<HttpStatus> deleteAll() {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable long id) {
        return null;
    }
}
