import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeFunc {

	public static void StoreEmployee(String Username, String Password, Employee NewEmployee) {
		int id = NewEmployee.getEmployeeID();
		String FirstName = NewEmployee.getFirstName();
		String LastName = NewEmployee.getLastName();
		String DOB = NewEmployee.getDateOfBirth();
		String PhoneNum = NewEmployee.getPhoneNum();
		String EmType = NewEmployee.getEmploymentType();
		double HourlyWage = NewEmployee.getHoulyWage();
		double AnnuallyWage = NewEmployee.getAnnuallyWage();
		String Title = NewEmployee.getTitle();
		int Supervisor = NewEmployee.getSuperviosr();

		String StoreEmployeeSQL = "INSERT INTO EmployeeTable " + "VALUES (" + id + "," + "'" + FirstName + "' ," + "'"
				+ LastName + "' ," + "'" + DOB + "' ," + "'" + PhoneNum + "' ," + "'" + EmType + "' ," + HourlyWage
				+ "," + AnnuallyWage + "," + "'" + Title + "' ," + "'" + Supervisor + "'" + ")";
		EmployeeDBfunc.ExcuteUpdateQuery(Username, Password, StoreEmployeeSQL);
		System.out.println("successfully stored employee info to database");
	
	}

	public static Employee GetEmployeeByID(String Username, String Password, int id) {
		// Select a empoyee by ID
		String selectbyIDsql = "SELECT * FROM EmployeeTable WHERE EmployeeID = " + id;
		ResultSet result = EmployeeDBfunc.ExcuteQuery(Username, Password, selectbyIDsql);

		try {
			int EmployeeID = result.getInt("EmployeeID");
			String FirstName = result.getString("FirstName");
			String LastName = result.getString("LastName");
			String DOB = result.getString("DateOfBirth");
			String PhoneNum = result.getString("PhoneNum");
			String EmploymentType = result.getString("EmploymentType");
			double HourlyWage = result.getDouble("HourlyWage");
			double AnnuallyWage = result.getDouble("AnnuallyWage");
			String Title = result.getString("Title");
			int SupervisorID = result.getInt("SupervisorID");
			double Wage = 0;
			if (HourlyWage != 0) {
				Wage = HourlyWage;
			} else {
				Wage = AnnuallyWage;
			}

			Employee ThisEmployee = new Employee(EmployeeID, FirstName, LastName, DOB, PhoneNum, EmploymentType, Wage,
					Title, SupervisorID);

			result.close();
			return ThisEmployee;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void DeleteEmployeeByID(String Username, String Password, int id) {

		String deletebyIDsql = "DELETE FROM EmployeeTable " + "WHERE id = " + id;
		EmployeeDBfunc.ExcuteUpdateQuery(Username, Password, deletebyIDsql);
		System.out.println("successfully deleted Employee "+id);
	}

	/** cannot update employee id**/
	public static <E> void UpdateEmployee(String Username, String Password, int id, String Attr, E UpdatedValue) {
		String SqlSyntax = "";
		if (Attr.equals("HourlyWage") || Attr.equals("AnnuallyWage") || Attr.equals("supervisorID")) {
			SqlSyntax = "UPDATE EmployeeTable " + "SET " + Attr + "=" + UpdatedValue + "WHERE id =" + id;
		} else {
			SqlSyntax = "UPDATE EmployeeTable " + "SET '" + Attr + "' = " + UpdatedValue + "WHERE id =" + id;
		}
		EmployeeDBfunc.ExcuteUpdateQuery(Username, Password, SqlSyntax);
		System.out.println("Updated employee "+id+"'s information in database");
	}

}
