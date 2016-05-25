import java.io.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonFunc {
	public static void WriteJSON(Employee employee) {

		Gson gson = new Gson();
		String json = gson.toJson(employee);

		try {
			// write converted json data to a file named "EmployeeJson.json"
			FileWriter writer = new FileWriter("EmployeeJson.json", true);
			writer.write(json);
			writer.write("\n");
			writer.close();
			System.out.println("Wrote the employee info to JSON file");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void ReadFromJSON(String Username, String Password, String filepath) {
		Gson gson = new Gson();
		String thisLine = null;
		try {

			System.out.println("Reading JSON from a file...");
			BufferedReader br = new BufferedReader(new FileReader(filepath));
			int count = 0;
			while ((thisLine = br.readLine()) != null) {
				// convert the json string back to employee object
				Employee employeeObj = gson.fromJson(thisLine, Employee.class);
				
				EmployeeFunc.StoreEmployee(Username, Password, employeeObj);
				count++;
			}
			System.out.println("Successfully wrote "+count+" employee(s) into database");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
