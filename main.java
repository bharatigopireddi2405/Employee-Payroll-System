import java.util.ArrayList;

abstract class Employee{
	private String name;
	private int id;
	public Employee(String name, int id) {
		this.name=name;
		this.id=id;
		
	}
	public String getName() {
		return name;
		
	}
	public int getId() {
		return id;
	}
	
	public abstract double calculateSalary();
	@Override
	public String toString() {
		return "Employee[name="+name+", id="+id+",salary="+calculateSalary()+"]";
	}
}

class FullTimeEmployee extends Employee{
	private double monthlySalary;
	
	public FullTimeEmployee(String name,int id, double monthlySalary) {
		super(name,id);
		this.monthlySalary= monthlySalary;
	}
	@Override
	public double calculateSalary() {
		return monthlySalary;
	}
}



class PartTimeEmployee extends Employee{
	
	private int hoursWorked;
	
	private double hourlyRate;
	
	public PartTimeEmployee(String name,int id,int hoursWorked,double hourlyRate) {
	
	super(name,id);
	this.hoursWorked= hoursWorked;
	this.hourlyRate = hourlyRate;
	}		

	@Override
	public double calculateSalary() {
		
		return hoursWorked * hourlyRate;
		}
	}
	

	class PayrollSystem{
		private ArrayList<Employee> employeeList;
		
		public PayrollSystem(){
			employeeList = new ArrayList<>();
		}
		
		public void addEmployee(Employee employee) {
			employeeList.add(employee);
		}
		
		public void removeEmployee(int id) {
			Employee employeeToRemove = null;
			for(Employee employee : employeeList) {
				if(employee.getId()==id) {
					employeeToRemove = employee;
					break;
				}
				
			}
			if(employeeToRemove !=null) {
				employeeList.remove(employeeToRemove);
			}
			
		}
		public void displayEmployee() {
			for(Employee employee: employeeList) {
				System.out.println(employee);
			}
		}
		
		
	}
	
	
	
public class main {
	
	public static void main(String[] args) {
		PayrollSystem payrollSystem =new PayrollSystem();
		FullTimeEmployee emp1=new FullTimeEmployee("vikas",1, 7000);
		PartTimeEmployee emp2=new PartTimeEmployee("Alexander",2 , 40,0);
		FullTimeEmployee emp3=new FullTimeEmployee("megha",3,10000);
		PartTimeEmployee emp4=new PartTimeEmployee("Varad",4, 80,0);

		payrollSystem.addEmployee(emp1);
		payrollSystem.addEmployee(emp2);
		payrollSystem.addEmployee(emp3);
		payrollSystem.addEmployee(emp4);
				
		System.out.println("Initial Employee Details: ");
		payrollSystem.displayEmployee();
		System.out.println("Removing Employee");
		payrollSystem.removeEmployee(2);
		System.out.println("Remaining Employee Details: ");
		payrollSystem.displayEmployee();
		
	}

}
