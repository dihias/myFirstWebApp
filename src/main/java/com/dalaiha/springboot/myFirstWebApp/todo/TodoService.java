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
    public static int todosCount = 3;
static{
    todos.add(new Todo(1,"didi","learn AWS",
            LocalDate.now().plusYears(1),false));

    todos.add(new Todo(2,"dididou","learn AWS now",
            LocalDate.now().plusMonths(8),false));

    todos.add(new Todo(3,"didida","learn AWS hey",
            LocalDate.now().plusWeeks(6),false));
}
    public void addTodo( String username,String description, LocalDate targetDate, boolean done){
        Todo todo= new Todo(++todosCount,username,description,targetDate,done);
        todos.add(todo);
    }

    public Todo findById(int id){
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }

    public void updateTodo(int id,String username,String description,boolean done){
        Todo todo= findById(id);
        todo.setUsername(username);
        todo.setDescription(description);
        todo.setDone(done);
    }

    public void deleteTodo(int id){
        //this is a " lambda expressions"
        Predicate<? super Todo> predicate=todo -> todo.getId() == id;
        this.todos.removeIf(predicate);
    }
public List<Todo> findByUsername(String username){
    return todos;
}
}
