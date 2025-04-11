package com.example.web_app.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();
    private static int todoCount = 0;

    static {
        todos.add(new Todo(++todoCount,"kavi","Java", LocalDate.now().plusYears(2),false));
        todos.add(new Todo(++todoCount,"kavi","AWS", LocalDate.now().plusYears(1),false));
        todos.add(new Todo(++todoCount,"kavi","Mysql", LocalDate.now().plusYears(1),false));
    }

    public List<Todo> findByUsername(String username){
        Predicate<? super Todo> predicate =
                todo -> todo.getUsername().equalsIgnoreCase(username);
        List<Todo> todo = todos.stream().filter(predicate).toList();
        return todo;
    }

    public String addTodos(String username, String description, LocalDate date){
        Todo todo= new Todo(++todoCount,username, description,date,false);
        try{
            todos.add(todo);
        }catch(Exception e){
            return "Error" + e.getMessage();
        }

        return "Successfully added new TO-DO";
    }

    public void deleteById(int id){
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }

    public void updateById(int id, String description){
        Todo todo = todos.get(id);
        todo.setDescription(description);
    }

    public Todo findById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        Todo todo = todos.stream().filter(predicate).findFirst().get();
        return todo;
    }

    public void updateTodo(Todo todo) {
        deleteById(todo.getId());
        todos.add(todo);
    }
}
