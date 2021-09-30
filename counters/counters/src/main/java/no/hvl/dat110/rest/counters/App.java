package no.hvl.dat110.rest.counters;

import com.google.gson.Gson;

import static spark.Spark.*;

/**
 * Hello world!
 *
 */
public class App {
	
	static Todolist todolist;
	
	public static void main(String[] args) {

		if (args.length > 0) {
			port(Integer.parseInt(args[0]));
		} else {
			port(8080);
		}

		todolist = new Todolist();
		
		after((req, res) -> {
  		  res.type("application/json");
  		});
		
        get("/todolist", (req, res) -> todolist.toJson());

		post("/todolist", (req, res) -> {
			Gson gson = new Gson();
			Todo todo = gson.fromJson(req.body(), Todo.class);
			todolist.addTodo(todo);
			return todo.toJson();
		});

		// Need an id so that we know which item to update
        put("/todolist", (req,res) -> {
			Gson gson = new Gson();
			Todo todo = gson.fromJson(req.body(), Todo.class);
			todolist.updateTodo(todo);
            return todo.toJson();
        });

		delete("/todolist", (req, res) -> {
			Gson gson = new Gson();
			Todo todo = gson.fromJson(req.body(), Todo.class);
			todolist.deleteTodo(todo.getId());
			return todolist.toJson();
		});
    }
    
}
