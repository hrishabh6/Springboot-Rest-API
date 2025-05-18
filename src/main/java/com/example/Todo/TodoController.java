package com.example.Todo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {
    private final List<Todo> todos;

    public TodoController(){
        todos = new ArrayList<>();
        todos.add(new Todo(1, false, "Learn springboot", 69));
        todos.add(new Todo(2, false, "Learn Hibernate", 8008));
    }

    @GetMapping
    public List<Todo> getTodos(){
        return todos;
    }

    @PostMapping("/post")
    public ResponseEntity<String> setTodos(@RequestBody Todo todo){
        todos.add(todo);
        return ResponseEntity.status(HttpStatus.CREATED).body("Todo created successfully");
    }

    @GetMapping("/get/{todoId}")
    public ResponseEntity<?> getTodoById(@PathVariable int todoId) {
        for (Todo todo : todos) {
            if (todo.getId() == todoId) {
                return ResponseEntity.ok(todo);
            }
        }

        ErrorResponse error = new ErrorResponse("Todo with ID " + todoId + " not found", 404);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }


}
