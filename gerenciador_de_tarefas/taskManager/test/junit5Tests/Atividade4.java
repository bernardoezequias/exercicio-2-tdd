package junit5Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import taskManager.PersonalTask;
import taskManager.TaskManager;

public class Atividade4 {
	
	TaskManager taskManager;
	
	@BeforeEach
	void setup() {
		taskManager = new TaskManager();
	}
	
	@AfterEach
	void afterSetup() {
		taskManager = new TaskManager(); //A ideia é "limpar" o objeto taskManager a cada execução.
	}
	

	@Test
	@Tag("Create")
	void CriarTaskOk() {
		PersonalTask task1 = new PersonalTask("random title", "empty desc", "01-01-2024", "Low");
		
		taskManager.createTask(task1.getTitle(), task1.getDesc(), task1.getExpDate(), task1.getPriority());
		PersonalTask equalTaskT1 = new PersonalTask(task1.getTitle(), task1.getDesc(), task1.getExpDate(), task1.getPriority());
		
		assertTrue(taskManager.getTasks().contains(equalTaskT1));
	}
	
	@Test
	@Tag("Create")
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
	@Tag("Create")
	void CriarTaskNull() {
		PersonalTask task1 = new PersonalTask("random title", null, "01-01-2024", "Low");
		
		taskManager.createTask(task1.getTitle(), task1.getDesc(), task1.getExpDate(), task1.getPriority());
		throw new NullPointerException("Null field");
	}
	
	@Test
	@Tag("Create")
	void CriarTaskTipoInvalido() {
		PersonalTask task1 = new PersonalTask("random title", "empty desc", "01-01-2024", "1");
		
		taskManager.createTask(task1.getTitle(), task1.getDesc(), task1.getExpDate(), "1");
		
		throw new IllegalArgumentException("Invalid type on field(s)");
	}
	
	@Test
	@Tag("Delete")
	void deleteTaskExistente() {
		PersonalTask task1 = new PersonalTask("random title", "empty desc", "01-01-2024", "1");
		taskManager.createTask(task1.getTitle(), task1.getDesc(),task1.getExpDate(), task1.getPriority());
		
		assertTrue(taskManager.getTasks().size() == 1);
		taskManager.deleteTask("random title");
		assertTrue(taskManager.getTasks().size() == 0);
	}
	
	@Test
	@Tag("Delete")
	void deleteTaskNaoExistente() {
		PersonalTask task1 = new PersonalTask("random title", "empty desc", "01-01-2024", "1");
		taskManager.createTask(task1.getTitle(), task1.getDesc(),task1.getExpDate(), task1.getPriority());
		
		assertTrue(taskManager.getTasks().size() == 1);
		taskManager.deleteTask(" ");
		assertTrue(taskManager.getTasks().size() == 1);
	}
	
	@Test 
	@Tag("Get")
	void detalharTaskExistente() {
		PersonalTask task2 = new PersonalTask("random title 2", "xd", "06-06-2024", "Low");
		taskManager.createTask(task2.getTitle(), task2.getDesc(), task2.getExpDate(), task2.getPriority());
		
		assertEquals("Here's the details of task: " + task2.getTitle() + "\n"
				+ "Description: " + task2.getDesc() + "\n"
				+ "Expiration date: " + task2.getExpDate() + "\n"
				+ "Priority: " + task2.getPriority(), taskManager.detailTask("random title 2"));
		
	}
	
	@Test 
	@Tag("Get")
	void detalharTaskNaoExistente() {
		PersonalTask task2 = new PersonalTask("random title 2", "xd", "06-06-2024", "Low");
		taskManager.createTask(task2.getTitle(), task2.getDesc(), task2.getExpDate(), task2.getPriority());
		
		assertEquals("Task not found", taskManager.detailTask(""));
		
	}
	
	@Test
	@Tag("Get")
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
	@Tag("Edit")
	void editarTaskNaoExistente() {
		PersonalTask task1 = new PersonalTask("random title", "empty desc", "01-01-2024", "Low");
		taskManager.createTask(task1.getTitle(), task1.getDesc(), task1.getExpDate(), task1.getPriority());
		assertTrue(task1.getPriority().equals("Low"));
		taskManager.editTask("inexistent title", "random title", "empty desc", "no exp date", "Medium");
		
		PersonalTask editedTask = taskManager.getTask("random title");
		assertNull(editedTask);
	
	}
	
	@Test
	@Tag("List")
	void listarTasksVazio() {
		assertEquals(taskManager.listTasks(), "There's a list of your tasks:");
	}
	
	@Test
	@Tag("List")
	void listarTasks() {	
		PersonalTask task1 = new PersonalTask("random title", "empty desc", "01-01-2024", "Low");
		taskManager.createTask(task1.getTitle(), task1.getDesc(), task1.getExpDate(), task1.getPriority());
		
		assertEquals(taskManager.listTasks(), "There's a list of your tasks: " + "\n" + "1 - random title");
		
		PersonalTask task2 = new PersonalTask("new random title", "no desc", "01-01-2025", "Medium");
		taskManager.createTask(task2.getTitle(), task2.getDesc(), task2.getExpDate(), task2.getPriority());
		
		assertEquals(taskManager.listTasks(), "There's a list of your tasks: " + "\n" + "1 - random title"
		+ "\n" + "2 - new random title");
		
	}
}
