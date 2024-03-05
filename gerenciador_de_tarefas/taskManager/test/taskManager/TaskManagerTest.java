package taskManager;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskManagerTest {
	
	TaskManager taskManager;
	PersonalTask task1;
	
	@BeforeEach
	void setup() {
		task1 = new PersonalTask("random title", "empty desc", "no expiration date", "Low");
		taskManager = new TaskManager();
	}
	
	@Test
	void createTask() {
		taskManager.createTask(task1.getTitle(), task1.getDesc(), task1.getExpDate(), task1.getPriority());
		PersonalTask equalTaskT1 = new PersonalTask(task1.getTitle(), task1.getDesc(), task1.getExpDate(), task1.getPriority());
		
		assertTrue(taskManager.getTasks().contains(equalTaskT1));
	}
	
	@Test
	void deleteTask() {
		PersonalTask equalTaskT1 = new PersonalTask(task1.getTitle(), task1.getDesc(), task1.getExpDate(), task1.getPriority());
		taskManager.createTask(task1.getTitle(), task1.getDesc(),task1.getExpDate(), task1.getPriority());
		assertTrue(taskManager.getTasks().contains(equalTaskT1));
		

		taskManager.deleteTask("random title");
		assertFalse(taskManager.getTasks().contains(equalTaskT1));
	}

	
	@Test
	void editTaskPriority() {
		taskManager.createTask(task1.getTitle(), task1.getDesc(), task1.getExpDate(), task1.getPriority());
		assertTrue(task1.getPriority().equals("Low"));
		taskManager.editTask("random title", "random title", "empty desc", "no exp date", "Medium");
		
		PersonalTask editedTask = taskManager.getTask("random title");
		assertNotNull(editedTask);
		
		assertTrue(editedTask.getPriority().equals("Medium"));
	}
	
	@Test
	void listTasks() {
		PersonalTask task2 = new PersonalTask("random title 2", "xd", "06-06-2024", "Low");
		PersonalTask task3 = new PersonalTask("random title 3", "idk", "03-02-2026", "Medium");
		PersonalTask task4 = new PersonalTask("random title 4", "no idea", "03-04-2024", "High");
		PersonalTask task5 = new PersonalTask("random title 5", "?", "no expiration date", "Low");
		
		taskManager.createTask(task2.getTitle(), task2.getDesc(), task2.getExpDate(), task2.getPriority());
		taskManager.createTask(task3.getTitle(), task2.getDesc(), task2.getExpDate(), task2.getPriority());
		taskManager.createTask(task4.getTitle(), task2.getDesc(), task2.getExpDate(), task2.getPriority());
		taskManager.createTask(task5.getTitle(), task2.getDesc(), task2.getExpDate(), task2.getPriority());
		
		assertEquals("There's a list of your tasks: " + "\n"
		+ "1 - random title 2" + "\n" 
		+ "2 - random title 3" + "\n" 
		+ "3 - random title 4" + "\n" 
		+ "4 - random title 5", taskManager.listTasks());
		
	}
	
	@Test 
	void getTask() {
		PersonalTask task2 = new PersonalTask("random title 2", "xd", "06-06-2024", "Low");
		taskManager.createTask(task2.getTitle(), task2.getDesc(), task2.getExpDate(), task2.getPriority());
		
		assertEquals("Here's the details of task: " + task2.getTitle() + "\n"
				+ "Description: " + task2.getDesc() + "\n"
				+ "Expiration date: " + task2.getExpDate() + "\n"
				+ "Priority: " + task2.getPriority(), taskManager.detailTask("random title 2"));
		
	}

}
