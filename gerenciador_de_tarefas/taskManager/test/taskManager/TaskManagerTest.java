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
		assertTrue(taskManager.tasks.contains(equalTaskT1));
		
		System.out.println(taskManager.tasks.get(0).toString());

		taskManager.deleteTask("random title");
		assertFalse(taskManager.tasks.contains(equalTaskT1));
	}

	
	@Test
	void editTaskPriority() {
		taskManager.tasks.add(task1);
		assertTrue(task1.getPriority().equals("Low"));
		taskManager.editTask("random title", "random title", "empty desc", "no exp date", "Medium");
		
		PersonalTask editedTask = taskManager.getTask("random title");
		assertNotNull(editedTask);
		
		assertTrue(editedTask.getPriority().equals("Medium"));
	}

}
