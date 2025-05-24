package com.vyniciusH.TodoList.todos;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private TodoRepository repository;

    public TodoService(TodoRepository todoRepository){
        this.repository = todoRepository;
    }

    public TodoEntity salvar(TodoEntity NewTodo){
        return repository.save(NewTodo);
    }
}
