import acm.program.ConsoleProgram;

public class Employees extends ConsoleProgram {

	public void run(){
		
		Employee ceo = new Employee("Ebenezer Scrooge", 161803399);
		Employee partner = new Employee("Jacob Marley", 271828182);
		Employee clerk = new Employee("Bob Cratchit", 314159265);
		
		ceo.setJob("CEO");
		partner.setJob("Former Partner");
		clerk.setJob("Clerk");
		
		ceo.setActive(true);
		partner.setActive(false);
		clerk.setActive(true);
		
		ceo.setSalary(1000);
		partner.setSalary(0);
		clerk.setSalary(25);
		
		int clerkSalary = clerk.getSalary();
		
		clerk.setSalary(clerkSalary * 2);
		
	}
	
}
