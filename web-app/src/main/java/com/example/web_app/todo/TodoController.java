package com.example.web_app.todo;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

//@Controller
@SessionAttributes("name")
public class TodoController {
    private TodoService todoService;

    public TodoController(TodoService todoService) {
        super();
        this.todoService = todoService;
    }

    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model){
        String username = getLoginUsername();
        List<Todo> todos = todoService.findByUsername(username);
        model.addAttribute("todos",todos);
        return "listTodos";
    }

    private String getLoginUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    @RequestMapping(value="add-todo", method= RequestMethod.GET)
    public String showTodoPage(ModelMap model){
        String username = (String) model.get("name");
        Todo todo = new Todo(0,username,"", LocalDate.now().plusYears(1),false);
        model.put("todo",todo);
        return "todo";
    }

    @RequestMapping(value="add-todo", method= RequestMethod.POST)
    public String addTodoPage(ModelMap model,@Valid Todo todo, BindingResult result){
        if(result.hasErrors()){
            return "todo";
        }
        String username = (String) model.get("name");
        todoService.addTodos(username,todo.getDescription(), LocalDate.now().plusYears(1));
        return "redirect:list-todos";
    }
    @RequestMapping(value="delete-todo")
    public String deleteTodo(@RequestParam int id){
        todoService.deleteById(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value="update-todo",  method=RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id,ModelMap model){
        Todo todo = todoService.findById(id);
        model.addAttribute("todo",todo);
        return "todo";
    }
    @RequestMapping(value="update-todo", method= RequestMethod.POST)
    public String updateTodoPage(ModelMap model,@Valid Todo todo, BindingResult result){
        if(result.hasErrors()){
            return "todo";
        }
        todoService.updateTodo(todo);
        return "redirect:list-todos";
    }
}
