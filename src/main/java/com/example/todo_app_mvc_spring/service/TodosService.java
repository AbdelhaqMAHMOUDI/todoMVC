package com.example.todo_app_mvc_spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.todo_app_mvc_spring.repository.TodosRepository;

import com.example.todo_app_mvc_spring.dto.*;
import com.example.todo_app_mvc_spring.model.Todos;;

@Service
public class TodosService {

    private final TodosRepository repositoryTodosRepository;

    public TodosService(TodosRepository repositoryTodosRepository) {
        this.repositoryTodosRepository = repositoryTodosRepository;
    }

    public List<TodosDto> getAllTodos() {
        return repositoryTodosRepository.findAll().stream()
                 .map(this::toDto) // Mapping: Entity -> DTO
                 .toList();
    }


    // get todo by id
    public Optional<TodosDto> getTodoById(Integer id){
        return repositoryTodosRepository.findById(id)
                .map( this::toDto ); // Mapping: Entity -> DTO
    }
    // create a new todo
    public TodosDto createTodo(TodosDto todo) {
        Todos todos = toEntity(todo); // Mapping: DTO -> Entity
        Todos savedTodo = repositoryTodosRepository.save(todos);
        return toDto(savedTodo); // Mapping: Entity -> DTO
        
    }
        // Mapping: Entity -> DTO
        private TodosDto toDto(Todos todo) {
            return new TodosDto(
                    todo.getId(),
                    todo.getTitle(),
                    todo.isCompleted(),
                    todo.getPriority()
            );
        }


        // Mapping: DTO -> Entity
        private Todos toEntity(TodosDto todo) {
            Todos todos= new Todos();
            todos.setId(todo.getId());
            todos.setTitle(todo.getTitle());       
            todos.setCompleted(todo.isCompleted());
            todos.setPriority(todo.getPriority());
            return todos; 
        }
}
