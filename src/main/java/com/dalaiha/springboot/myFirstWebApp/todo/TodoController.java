package com.dalaiha.springboot.myFirstWebApp.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model){
        List<Todo>todos=todoService.findByUsername("didi");
        model.addAttribute("todos",todos);
        return "listTodos";
    }

    @RequestMapping(value="add-todo", method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap model)
    {String username = (String)model.get("name");
        Todo todo= new Todo(0, username, "", LocalDate.now().plusYears(1),false);
        model.put("todo",todo);
        return "todo";
    }

    @RequestMapping(value="delete-todo", method = RequestMethod.GET)
    public String deleteTodo(@RequestParam int id)
    {
        todoService.deleteTodo(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value="add-todo", method = RequestMethod.POST)
    public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result){
        if(result.hasErrors()){
            return "todo";
        }
        String username=(String) model.get("name");
        todoService.addTodo(username,todo.getDescription(), todo.getTargetDate(),false);
        return "redirect:list-todos";
    }


    //@RequestMapping(value="update-todo", method = RequestMethod.GET)
    @GetMapping("update-todo")
    public String updateTodoPage(ModelMap model,@RequestParam int id)
    {
        Todo todo=todoService.findById(id);
        model.addAttribute("todo",todo);
        return "updateTodo";
    }

   // @RequestMapping(value="update-todo", method = RequestMethod.POST)
    @PostMapping("update-todo")
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result){
        if(result.hasErrors()){
            return "update-todo";
        }
        todoService.updateTodo(todo);
        return "redirect:list-todos";
    }
}
