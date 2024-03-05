package taskManager;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
	
	private List<PersonalTask> tasks;
	
	public TaskManager() {
		this.tasks = new ArrayList<PersonalTask>();
	}
	
	
	public void createTask(String title, String description, String expDate, String priority) {
		PersonalTask newTask = new PersonalTask(title, description, expDate, priority);
		tasks.add(newTask);	
	}
	
	public List<PersonalTask> getTasks() {
		return this.tasks;
	}
	
	public PersonalTask getTask(String taskTitle) {
		for (PersonalTask task: this.tasks) {
			if (task.getTitle().equals(taskTitle)) {
				return task;
			}
		} return null;
	}
	
	
	public void deleteTask(String taskTitle) {
		PersonalTask task = getTask(taskTitle);
		this.tasks.remove(task);
	}

	
	public void editTask(String taskTitle, String newTitle, String newDescription, String newExpDate, String newPriority) {
	    for (PersonalTask task : tasks) {
	        if (task.getTitle().equals(taskTitle)) {
	            task.setTitle(newTitle);
	            task.setDesc(newDescription);
	            task.setExpDate(newExpDate);
	            task.setPriority(newPriority);
	        }
	    }
	}
	
	public String detailTask(String taskTitle) {
		String s = "Here's the details of task: " + taskTitle + "\n";
		PersonalTask task = getTask(taskTitle);
		
		s += "Description: " + task.getDesc() + "\n";
		s += "Expiration date: " + task.getExpDate() + "\n";
		s += "Priority: " + task.getPriority();
		
		return s;
	}
	
	public String listTasks() {
		String s = "There's a list of your tasks: " + "\n";
		for (int i = 0; i < this.tasks.size(); i++) {
			s += (i+1) + " - " + this.tasks.get(i).getTitle() + "\n";
		}
		
		return s.strip();
	}
	
}
		
	
