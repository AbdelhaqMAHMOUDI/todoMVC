package com.example.todo_app_mvc_spring.dto;

public record TodosDto(
    Integer id,
    String title,
    boolean completed,
    int priority
) {

    // getters et setters
    public Integer getId() {
        return id;
    }  

    public String getTitle() {
        return title;
    }
    public boolean isCompleted() {
        return completed;
    }
    public int getPriority() {
        return priority;
    }
    
}
