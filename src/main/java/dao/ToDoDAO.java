package dao;

import java.util.List;

import bean.Register;
import bean.Task;

public interface ToDoDAO {
	public int register(Register reg);
	public int login(String email, String pass);
	public boolean addTask(Task task, int regid);
	public List<Task> findAllTasksByRegid(int regid);
	public boolean markTaskCompleted(int taskid, int regid);
	public String findFname(int regid);
}
