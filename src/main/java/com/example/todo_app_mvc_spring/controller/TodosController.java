package com.example.todo_app_mvc_spring.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo_app_mvc_spring.dto.TodosDto;
import com.example.todo_app_mvc_spring.service.TodosService;

@RestController
@RequestMapping("/api")
public class TodosController {
    private final TodosService todosService;

    public TodosController(TodosService todosService){
        this.todosService = todosService;
    }
    

    @GetMapping("/todos")
    public List<TodosDto> getAllTodos() {
        return todosService.getAllTodos();
    }

    // La methode post pour creer un todo
    @PostMapping("/todos")
    public ResponseEntity<TodosDto> createTodo(@RequestBody TodosDto todo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(todosService.createTodo(todo));
    }
    
    @GetMapping("/todos/{id}")
    public ResponseEntity<TodosDto> getTodoById(@PathVariable Integer id) {
        return todosService.getTodoById(id)
                .map( ResponseEntity::ok ) // 200 OK
                .orElse(ResponseEntity.notFound().build()); // 404 Not Found
    }

    // La methode pour supprimer un todo
    @DeleteMapping("/todos/delete/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Integer id) {
        try{
            todosService.deleteTodo(id);
            return ResponseEntity.noContent().build(); // 204 No Content
        }catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
        
    }
}
