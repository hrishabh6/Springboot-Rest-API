package com.example.Todo;

import org.springframework.stereotype.Service;

@Service("fakeTodoService")
public class FakeTodoService implements TodoService{

    @Override
    public String doSomething() {
        return "Do something";
    }
}
