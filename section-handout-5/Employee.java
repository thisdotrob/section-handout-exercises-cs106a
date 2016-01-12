
public class Employee {
	
	public Employee(String string, int number) {
		idNum = number;
		name = string;
	}
	
	public void setJob(String string) {
		jobTitle = string;
	}
	
	public String getJob() {
		return jobTitle;
	}
	
	public void setActive(Boolean bool) {
		if(bool){
			status = "Active";
		}
		else {
			status = "Inactive";
		}
	}
	
	public String getStatus(){
		return status;
	}
	
	public void setSalary(int number) {
		salary = number;
	}
	
	public int getSalary(){
		return salary;
	}
	
	private int idNum;
	private String name;
	private String jobTitle;
	private String status;
	private int salary;
}
