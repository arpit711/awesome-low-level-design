package org.example;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TodoService {
    private final List<Todo> todos = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong();

    public List<Todo> getAllTodos() {
        return todos;
    }

    public Todo getTodoById(Long id) {
        return todos.stream()
                .filter(todo -> todo.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Todo createTodo(Todo todo) {
        todo.setId(idCounter.incrementAndGet());
        todos.add(todo);
        return todo;
    }

    public List<Todo> createBulkTodos(List<Todo> newTodos) {
        List<Todo> createdTodos = new ArrayList<>();
        for (Todo todo : newTodos) {
            todo.setId(idCounter.incrementAndGet());
            todos.add(todo);
            createdTodos.add(todo);
        }
        return createdTodos;
    }

    public Todo updateTodo(Long id, Todo todo) {
        for (int i = 0; i < todos.size(); i++) {
            if (todos.get(i).getId().equals(id)) {
                todo.setId(id);
                todos.set(i, todo);
                return todo;
            }
        }
        return null;
    }

    public boolean deleteTodo(Long id) {
        return todos.removeIf(todo -> todo.getId().equals(id));
    }
} 