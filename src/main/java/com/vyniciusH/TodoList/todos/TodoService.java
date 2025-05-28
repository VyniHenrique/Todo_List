package com.vyniciusH.TodoList.todos;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private TodoRepository repository;
    private TodoValidator todoValidator;
    private MailSender mailSender;

    public TodoService(TodoRepository repository, TodoValidator todoValidator, MailSender mailSender) {
        this.repository = repository;
        this.todoValidator = todoValidator;
        this.mailSender = mailSender;
    }

    public TodoEntity salvar(TodoEntity NewTodo){
        return repository.save(NewTodo);
    }

    public void atualizarStatus(TodoEntity entity){
        repository.save(entity);
        String status = entity.getConcluido() == Boolean.TRUE ? "Concluido" : "Não concluido";
        mailSender.enviar("Todo " + entity.getDescription() + " foi atualizado para: " + status);
    }

    public TodoEntity buscarPorId (Integer id){
        return repository.findById(id).orElse(null);
    }


}
