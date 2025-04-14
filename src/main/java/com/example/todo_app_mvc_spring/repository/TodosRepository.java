package com.example.todo_app_mvc_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.todo_app_mvc_spring.model.Todos;

@Repository
public interface TodosRepository extends JpaRepository<Todos, Integer> {
    
}
