package com.dalaiha.springboot.myFirstWebApp.todo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {
    private static List<Todo> todos= new ArrayList();
    public static int todosCount = 4;
static{
    todos.add(new Todo(1,"didi","learn Spring boot fast",
            LocalDate.now().plusYears(1),false));

    todos.add(new Todo(2,"momo","make a great meal for didi",
            LocalDate.now().plusMonths(8),false));
    todos.add(new Todo(4,"momo","teach didi to cook fish and chips",
            LocalDate.now(),false));

    todos.add(new Todo(3,"didi","learn AWS hey",
            LocalDate.now().plusWeeks(6),false));
}
    public void addTodo( String username,String description, LocalDate targetDate, boolean done){
        Todo todo= new Todo(++todosCount,username,description,targetDate,done);
        todos.add(todo);
    }

    public Todo findById(int id){
    return todos.stream()
            .filter(todo -> id == todo.getId())
            .findFirst()
            .orElse(null);
    }

    public void updateTodo(Todo todo){
        Todo todo1= findById(todo.getId());
        todo1.setUsername(todo.getUsername());
        todo1.setDescription(todo.getDescription());
        todo1.setTargetDate(todo.getTargetDate());
        todo1.setDone(todo.isDone());
    }

    public void deleteTodo(int id){
        //this is a " lambda expressions"
        Predicate<? super Todo> predicate=todo -> todo.getId() == id;
        this.todos.removeIf(predicate);
    }
public List<Todo> findByUsername(String username){
    Predicate<? super Todo> predicate=
            todo -> todo.getUsername().equalsIgnoreCase(username);
    return todos.stream().filter(predicate).toList();
}
}
