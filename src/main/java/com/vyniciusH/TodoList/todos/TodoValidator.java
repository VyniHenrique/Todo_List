package com.vyniciusH.TodoList.todos;

import org.springframework.stereotype.Component;

@Component
public class TodoValidator {

    private TodoRepository todoRepository;

    public TodoValidator(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    private boolean existsTodoOfThisDescription (String descricao){
        return todoRepository.existsByDescricao(descricao);
    }


    public void validar(TodoEntity todo){
        if (existsTodoOfThisDescription(todo.getDescription())){
            throw new IllegalArgumentException("Já existe um todo com essa descrição");
        }
    }



}
