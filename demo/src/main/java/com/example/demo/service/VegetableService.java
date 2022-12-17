package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Vegetable;
import com.example.demo.repository.VegetableRepository;

@Service
public class VegetableService {

    @Autowired
    private VegetableRepository vegetableRepository;

    // 空の場合はcontrollerでstatuscode決める際にやってやればいい(sutatuscodeを決めるのだからそのためのロジックがあるのは自然)
    // TODO: ここではinternalserverエラーのような具体的でないエラーをThrowするだけでよさそう
    public List<Vegetable> getAll(String name) {
        return null;
    }

    public Vegetable getById(long id) {
        return null;
    }

    public Vegetable create(Vegetable vegetable) {
        return null;
    }

    // idのデータあるかチェックする(Optionalに入れる)、ない場合はnull入れてcontrollerでNotFoundExcetionで、それ以外ならThrow投げる
    public Vegetable update(long id, Vegetable vegetable) {
        return null;
    }

    public void deleteAll(long id) {

    }
}
