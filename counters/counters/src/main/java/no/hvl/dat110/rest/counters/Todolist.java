package no.hvl.dat110.rest.counters;

import com.google.gson.Gson;

import java.util.ArrayList;

public class Todolist {
    private ArrayList<Todo> todolist;

    public Todolist() {
        this.todolist = new ArrayList<>();
    }

    public void addTodo(Todo todo) {
        todolist.add(todo);
    }

    public Todo getTodo(String id) {
        for (Todo todo : todolist) {
            if (todo.getId().equals(id)) {
                return todo;
            }
        }
        return null;
    }

    public void deleteTodo(String id) {
        for (Todo todo : todolist) {
            if (todo.getId().equals(id)) {
                todolist.remove(todo);
                break;
            }
        }
    }

    public void updateTodo(Todo todo) {
        deleteTodo(todo.getId());
        addTodo(todo);
    }

    String toJson () {
        Gson gson = new Gson();
        String jsonInString = gson.toJson(this);
        return jsonInString;
    }


}
