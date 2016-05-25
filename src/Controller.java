
public class Controller {

	// Database user name and password go in here
	static final String Username = "user";
	static final String Password = "password";

	public static void main(String[] args) {
		
		// First create a DB called CompanyDB if not exits
		EmployeeDBfunc.CreateDB(Username, Password);

		// Create Employee Table
		String createtable = "CREATE TABLE [IF NOT EXISTS] EmployeeTable " + "(EmployeeID INTEGER not NULL, "
				+ " FirstName VARCHAR(255), " + " LastName VARCHAR(255), " + " DateOfBirth CHAR(10), "
				+ " PhoneNum CHAR(10), " + " EmploymentType VARCHAR(255), " + " HourlyWage DECIMAL(15,2), "
				+ " AnnuallyWage DECIMAL(15,2), " + " Title VARCHAR(255) " + " SupervisorID INTEGER "
				+ " PRIMARY KEY ( EmployeeID ))";
		EmployeeDBfunc.ExcuteUpdateQuery(Username, Password, createtable);

		
		//create a new employee profile and store it in the database
		Employee newemployee = new Employee(101,"first","last","11-11-1991","1234567890","Intern",20.50
				,"Engineer", 001);
		EmployeeFunc.StoreEmployee(Username, Password, newemployee);
		
		Employee newemployee2 = new Employee(102,"first2","last2","11-11-1991","1234567891","Intern",20.50
				,"Engineer", 001);
		
		//Write the newemployee to a JSON file called EmployeeJson.json
		JsonFunc.WriteJSON(newemployee2);
		
		//read every row of the employeejson file and store all employees in that file
		//to our database
		JsonFunc.ReadFromJSON(Username, Password, "EmployeeJson.json");
		
		//retrive the information of employee with id 101 from the database
		int id = 101;
		Employee employee101 = EmployeeFunc.GetEmployeeByID(Username, Password, id);
		System.out.println("employee101's full name is: "+ employee101.getFullName());
		
		//update the phone number for employee with id 101
		EmployeeFunc.UpdateEmployee(Username, Password, 101, "PhoneNum", "0987654321");
		
		//delete employee with id 101 from our database
		EmployeeFunc.DeleteEmployeeByID(Username, Password, 101);
		
		
		
	}

}
