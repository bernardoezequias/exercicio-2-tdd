package taskManager;

import java.util.Objects;

public class PersonalTask implements Task {
	
	private String title;
	private String description;
	private String expDate;
	private String priority;
	
	public PersonalTask(String title, String description, String expDate, String priority) {
		this.title = title;
		this.description = description;
		this.expDate = expDate;
		this.priority = priority;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return this.description;
	}

	public void setDesc(String desc) {
		this.description = desc;
	}

	public String getExpDate() {
		return this.expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public String getPriority() {
		return this.priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}
	
	@Override
	public boolean equals(Object o) { 
		  if (this == o) return true;
		    if (o == null || getClass() != o.getClass()) return false;
		    PersonalTask that = (PersonalTask) o;
		    
		    return Objects.equals(title, that.title);
	}
	
	@Override
	public int hashCode() {
	    return Objects.hash(title, description, expDate, priority);
	}
	
	@Override
	public String toString() {
		return "Title: " + this.title + "\n"
				+ "Description: " + this.description + "\n"
				+ "Expiration date: " + this.expDate + "\n"
				+ "Priority: " + this.priority;
	}
	

}
