package taskManager;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskManagerTest {
	
	TaskManager taskManager = new TaskManager();
	List<Task> tasks = new ArrayList<Task>();
	Task task1;
	
	@BeforeEach
	void setup() {
		//will be used for instantiate some objects before tests
	}
	
	@Test
	void createTask() {
		taskManager.createTask(task1.getTitle(), task1.getDesc(), task1.getExpDate(), task1.getPriority());
		assertTrue(taskManager.getTasks.contains(task1));
	}
	
	@Test
	void deleteTask() {
		taskManager.tasks.add(task1);
		assertTrue(taskManager.tasks.contains(task1));
		
		taskManager.deleteTask("random title");
		assertFalse(taskMaanger.tasks.contains(task1));
	}
	
	@Test
	void editTaskPriority() {
		taskManager.tasks.add(task1);
		assertTrue(task1.getPriority().equals("Low"));
		taskManager.editTask("random title", "priority", "Medium");
		
		assertTrue(task1.getPriority().equals("Medium"));
	}

}
