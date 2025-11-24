package com.dalaiha.springboot.myFirstWebApp.todo;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoControllerJpa {


    private TodoRepository todoRepository;

    public TodoControllerJpa(TodoRepository todoRepository) {

        this.todoRepository= todoRepository;
    }

    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model){
        String username = getLoggedInUsername(model);
        List<Todo>todos=todoRepository.findByUsername(username);
        model.addAttribute("todos",todos);
        return "listTodos";
    }

    private static String getLoggedInUsername(ModelMap model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    @RequestMapping(value="add-todo", method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap model)
    {
        String username = getLoggedInUsername(model);
        Todo todo= new Todo(0, username, "", LocalDate.now().plusYears(1),false);
        model.put("todo",todo);
        return "todo";
    }

    @RequestMapping(value="delete-todo", method = RequestMethod.GET)
    public String deleteTodo(@RequestParam int id)
    {
        todoRepository.deleteById(id);
        //todoService.deleteTodo(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value="add-todo", method = RequestMethod.POST)
    public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result){
        if(result.hasErrors()){
            return "todo";
        }
        String username = getLoggedInUsername(model);
        todo.setUsername(username);
        todoRepository.save(todo);
        //todoService.addTodo(username,todo.getDescription(), todo.getTargetDate(), todo.isDone());
        return "redirect:list-todos";
    }


    //@RequestMapping(value="update-todo", method = RequestMethod.GET)
    @GetMapping("update-todo")
    public String updateTodoPage(ModelMap model,@RequestParam int id)
    {
        Todo todo=  todoRepository.findById(id).get();
       // Todo todo=todoService.findById(id);
        model.addAttribute("todo",todo);
        return "updateTodo";
    }

   // @RequestMapping(value="update-todo", method = RequestMethod.POST)
    @PostMapping("update-todo")
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result){
        if(result.hasErrors()){
            return "update-todo";
        }
        todoRepository.save(todo);
       // todoService.updateTodo(todo);
        return "redirect:list-todos";
    }
}
