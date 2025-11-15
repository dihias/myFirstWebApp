package com.dalaiha.springboot.myFirstWebApp.todo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private static List<Todo> todos= new ArrayList();
static{
    todos.add(new Todo(1,"didi","learn AWS",
            LocalDate.now().plusYears(1),false));

    todos.add(new Todo(2,"dididou","learn AWS now",
            LocalDate.now().plusMonths(8),false));

    todos.add(new Todo(3,"didida","learn AWS hey",
            LocalDate.now().plusWeeks(6),false));
}
public List<Todo> findByUsername(String username){
    return todos;
}
}
