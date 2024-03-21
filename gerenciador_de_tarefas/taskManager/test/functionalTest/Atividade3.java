import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import taskManager.PersonalTask;
import taskManager.TaskManager;

public class Atividade3 {
	
	TaskManager taskManager;
	
	@BeforeEach
	void setup() {
		taskManager = new TaskManager();
	}
	

	@Test
	void CriarTaskOk() {
		PersonalTask task1 = new PersonalTask("random title", "empty desc", "01-01-2024", "Low");
		
		taskManager.createTask(task1.getTitle(), task1.getDesc(), task1.getExpDate(), task1.getPriority());
		PersonalTask equalTaskT1 = new PersonalTask(task1.getTitle(), task1.getDesc(), task1.getExpDate(), task1.getPriority());
		
		assertTrue(taskManager.getTasks().contains(equalTaskT1));
	}
	
	@Test
	void CriarTaskRepetida() {
		PersonalTask task1 = new PersonalTask("random title", "empty desc", "01-01-2024", "Low");
		PersonalTask task2 = new PersonalTask("random title", "-", "-", "-");
		
		taskManager.createTask(task1.getTitle(), task1.getDesc(), task1.getExpDate(), task1.getPriority());
		taskManager.createTask(task2.getTitle(), task2.getDesc(), task2.getExpDate(), task2.getPriority());
		
		PersonalTask equalTaskT1 = new PersonalTask(task1.getTitle(), task1.getDesc(), task1.getExpDate(), task1.getPriority());
		PersonalTask equalTaskT2 = new PersonalTask(task2.getTitle(), task2.getDesc(), task2.getExpDate(), task2.getPriority());
		
		assertTrue(taskManager.getTasks().contains(equalTaskT1));
		assertFalse(taskManager.getTasks().contains(equalTaskT2));
	}
	
	@Test
	void CriarTaskNull() {
		PersonalTask task1 = new PersonalTask("random title", null, "01-01-2024", "Low");
		
		taskManager.createTask(task1.getTitle(), task1.getDesc(), task1.getExpDate(), task1.getPriority());
		throw new NullPointerException("Null field");
	}
	
	@Test
	void CriarTaskTipoInvalido() {
		PersonalTask task1 = new PersonalTask("random title", "empty desc", "01-01-2024", "1");
		
		taskManager.createTask(task1.getTitle(), task1.getDesc(), task1.getExpDate(), "1");
		
		throw new IllegalArgumentException("Invalid type on field(s)");
	}
	
	@Test
	void deleteTaskExistente() {
		PersonalTask task1 = new PersonalTask("random title", "empty desc", "01-01-2024", "1");
		taskManager.createTask(task1.getTitle(), task1.getDesc(),task1.getExpDate(), task1.getPriority());
		
		assertTrue(taskManager.getTasks().size() == 1);
		taskManager.deleteTask("random title");
		assertTrue(taskManager.getTasks().size() == 0);
	}
	
	@Test
	void deleteTaskNaoExistente() {
		PersonalTask task1 = new PersonalTask("random title", "empty desc", "01-01-2024", "1");
		taskManager.createTask(task1.getTitle(), task1.getDesc(),task1.getExpDate(), task1.getPriority());
		
		assertTrue(taskManager.getTasks().size() == 1);
		taskManager.deleteTask(" ");
		assertTrue(taskManager.getTasks().size() == 1);
	}
	
	@Test 
	void detalharTaskExistente() {
		PersonalTask task2 = new PersonalTask("random title 2", "xd", "06-06-2024", "Low");
		taskManager.createTask(task2.getTitle(), task2.getDesc(), task2.getExpDate(), task2.getPriority());
		
		assertEquals("Here's the details of task: " + task2.getTitle() + "\n"
				+ "Description: " + task2.getDesc() + "\n"
				+ "Expiration date: " + task2.getExpDate() + "\n"
				+ "Priority: " + task2.getPriority(), taskManager.detailTask("random title 2"));
		
	}
	
	@Test 
	void detalharTaskNaoExistente() {
		PersonalTask task2 = new PersonalTask("random title 2", "xd", "06-06-2024", "Low");
		taskManager.createTask(task2.getTitle(), task2.getDesc(), task2.getExpDate(), task2.getPriority());
		
		assertEquals("Task not found", taskManager.detailTask(""));
		
	}
	
	@Test
	void editarTaskExistente() {
		PersonalTask task1 = new PersonalTask("random title", "empty desc", "01-01-2024", "Low");
		taskManager.createTask(task1.getTitle(), task1.getDesc(), task1.getExpDate(), task1.getPriority());
		assertTrue(task1.getPriority().equals("Low"));
		taskManager.editTask("random title", "new random title", "empty desc", "no exp date", "Medium");
		
		PersonalTask editedTask = taskManager.getTask("new random title");
		assertNotNull(editedTask);
		
		assertTrue(editedTask.getPriority().equals("Medium"));
		assertTrue(editedTask.getTitle().equals("new random title"));
	}
	
	@Test
	void editarTaskNaoExistente() {
		PersonalTask task1 = new PersonalTask("random title", "empty desc", "01-01-2024", "Low");
		taskManager.createTask(task1.getTitle(), task1.getDesc(), task1.getExpDate(), task1.getPriority());
		assertTrue(task1.getPriority().equals("Low"));
		taskManager.editTask("inexistent title", "random title", "empty desc", "no exp date", "Medium");
		
		PersonalTask editedTask = taskManager.getTask("random title");
		assertNull(editedTask);
	
	}
}
