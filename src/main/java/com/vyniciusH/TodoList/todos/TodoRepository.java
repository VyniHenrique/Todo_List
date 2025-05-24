package com.vyniciusH.TodoList.todos;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoEntity, Integer> {

}
