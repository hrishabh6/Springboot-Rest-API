package com.example.Todo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {
    private final List<Todo> todos;

    private TodoService todoService1;
    private TodoService todoService2;

    public TodoController(
            @Qualifier("newTodoService") TodoService todoService1,
            @Qualifier("fakeTodoService") TodoService todoService2
    ){
        this.todoService1 = todoService1;
        this.todoService2 = todoService2;
        todos = new ArrayList<>();
        todos.add(new Todo(1, false, "Learn springboot", 69));
        todos.add(new Todo(2, false, "Learn Hibernate", 8008));
    }

    @GetMapping
    public List<Todo> getTodos(@RequestParam(required = false) Boolean isCompleted){
        List<Todo> answer = new ArrayList<>();
        if (isCompleted){
            System.out.println("The query param is " + isCompleted);
            for (Todo currentTodo : todos) {
                if (currentTodo.isCompleted()) {
                    answer.add(currentTodo);
                }
            }
            return answer;
        }
        return todos;
    }

    @PostMapping("/post")
    public ResponseEntity<String> setTodos(@RequestBody Todo todo){
        todos.add(todo);
        return ResponseEntity.status(HttpStatus.CREATED).body("Todo created successfully and here is faketodoservice " +
                todoService2.doSomething());
    }

    @GetMapping("/get/{todoId}")
    public ResponseEntity<?> getTodoById(@PathVariable int todoId) {
        for (Todo todo : todos) {
            if (todo.getId() == todoId) {
                System.out.println("Here is newtodoservice " + todoService1.doSomething());
                return ResponseEntity.ok(todo);
            }
        }

        ErrorResponse error = new ErrorResponse("Todo with ID " + todoId + " not found", 404);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }


}
