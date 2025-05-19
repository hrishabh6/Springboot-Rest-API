package com.example.Todo;

import org.springframework.stereotype.Service;

@Service("newTodoService")
public class NewTodoService implements TodoService{

    @Override
    public String doSomething() {
        return "Do something more exiciting";
    }
}
