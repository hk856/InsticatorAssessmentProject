
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Employee extends Person {
	private int EmployeeID;
	private String EmploymentType;
	private double HourlyWage;
	private double AnnuallyWage;
	private String Title;
	private int SupervisorID;

	/**
	 * Construct a basic profile of an employee input date in mm-dd-yyyy format
	 **/
	public Employee(int id, String FirstName, String LastName, String DateOfBirth, String PhoneNum,
			String EmploymentType, double Wage, String Title, int SupervisorID) {
		super(FirstName, LastName, DateOfBirth, PhoneNum);

		setEmployeeID(id);
		setEmploymentType(EmploymentType);
		setWage(Wage);
		setTitle(Title);
		setSupervisor(SupervisorID);
	}

	public void setEmployeeID(int id) {
		this.EmployeeID = id;
	}

	public int getEmployeeID() {
		return this.EmployeeID;
	}

	public void setSupervisor(int SupervisorID) {
		this.SupervisorID = SupervisorID;
	}

	public int getSuperviosr() {
		return this.SupervisorID;
	}

	public void setTitle(String Title) {
		this.Title = Title;
	}

	public String getTitle() {
		return this.Title;
	}

	public void setWage(double Wage) {
		if (Wage > 10000) {
			this.AnnuallyWage = Wage;
			this.HourlyWage = 0;
		} else {
			this.HourlyWage = Wage;
			this.AnnuallyWage = 0;
		}
	}

	public double getHoulyWage() {
		return this.HourlyWage;
	}

	public double getAnnuallyWage() {
		return this.AnnuallyWage;
	}

	public void setEmploymentType(String EmploymentType) {
		this.EmploymentType = EmploymentType;
	}

	public String getEmploymentType() {
		return this.EmploymentType;
	}

	public int getAge() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("mm-dd-yyyy");
		Date date1;
		long diff = 0;
		try {
			date1 = dateFormat.parse(this.getDateOfBirth());

			Date date2 = new Date();
			diff = date2.getTime() - date1.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
}
