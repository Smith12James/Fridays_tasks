import java.sql.*;
import java.util.ArrayList;

public class Driver {
	
//	static String taskArr[] = new String[5];
	static String insertArr[] = new String[5];
	static String taskName = "";

	public static void main(String[] args) {
		
		numToDo();

	}
	
	/*
	 * count how many tasks there are with a status of "to Do"
	 */
	
	public static int numToDo() {

		String count = "";
		
		try {
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/FRIDAYS_TASKS", "root", "james");
			
			Statement statem = conn.createStatement();
			
			ResultSet result = statem.executeQuery("SELECT COUNT(TASK_ID) AS RESULT FROM TASKS WHERE TASK_STATUS = 'TO DO';");
			
			while (result.next()) {
				
				count = (result.getString("RESULT"));
				
				
//				System.out.println(count);
				
			}
			
			
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return Integer.parseInt(count);
		
	}
	
	/*
	 * count how many tasks there are with a status of "In Progress"
	 */
	
	public static int numInProg() {
		
		String count = "";
		
		try {
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/FRIDAYS_TASKS", "root", "james");
			
			Statement statem = conn.createStatement();
			
			ResultSet result = statem.executeQuery("SELECT COUNT(TASK_ID) AS RESULT FROM TASKS WHERE TASK_STATUS = 'IN PROGRESS';");
			
			while (result.next()) {
				
				count = (result.getString("RESULT"));
				
				
//				System.out.println(count);
				
			}
			
			
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return Integer.parseInt(count);
		
	}
	
	/*
	 * count how many tasks there are with a status of "Done"
	 */
	
	public static int numDone() {
		
		String count = "";
		
		try {
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/FRIDAYS_TASKS", "root", "james");
			
			Statement statem = conn.createStatement();
			
			ResultSet result = statem.executeQuery("SELECT COUNT(TASK_ID) AS RESULT FROM TASKS WHERE TASK_STATUS = 'DONE';");
			
			while (result.next()) {
				
				count = (result.getString("RESULT"));
				
				
//				System.out.println(count);
				
			}
			
			
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return Integer.parseInt(count);
		
	}
	
	/*
	 * Select tasks that have a status of in progress for use of cards to show the tasks and their data
	 * In the future I would like to create one class to be reused instead of 3 different classes
	 */
	
	public static ArrayList<String> readInProg() {
		
		ArrayList<String> taskArr = new ArrayList<String>();
		
		try {
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/FRIDAYS_TASKS", "root", "james");
			
			Statement statem = conn.createStatement();
			
			ResultSet result = statem.executeQuery("SELECT * FROM TASKS WHERE TASK_STATUS = 'IN PROGRESS';");
			
			while (result.next()) {
				
				taskArr.add(result.getString("TASK_NAME")); // taskArr 0
				taskArr.add(result.getString("TASK_STATUS")); // taskArr 1
				taskArr.add(result.getString("TASK_DESC")); // taskArr 2
				taskArr.add(result.getString("TASK_PRIO")); // taskArr 3
				taskArr.add(result.getString("DATE_START")); // taskArr 4
				taskArr.add(result.getString("DATE_END")); // taskArr 5
				
//				taskName = taskArr.get(0);
				
//				System.out.println(taskArr.get(0));
				
				
				
//				System.out.println(result.getString("TASK_NAME") + " " + result.getString("TASK_STATUS") + " " + result.getString("TASK_DESC") + " " + result.getString("TASK_PRIO") + " " + result.getString("DATE_START"));
				
			}
			
			
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
			
		}

		return taskArr;
		
	}
	
	/*
	 * select tasks with the status of "done" for use of cards
	 */
	
	public static ArrayList<String> readDone() {
		
		ArrayList<String> taskArr = new ArrayList<String>();
		
		try {
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/FRIDAYS_TASKS", "root", "james");
			
			Statement statem = conn.createStatement();
			
			ResultSet result = statem.executeQuery("SELECT * FROM TASKS WHERE TASK_STATUS = 'DONE';");
			
			while (result.next()) {
				
				taskArr.add(result.getString("TASK_NAME")); // taskArr 0
				taskArr.add(result.getString("TASK_STATUS")); // taskArr 1
				taskArr.add(result.getString("TASK_DESC")); // taskArr 2
				taskArr.add(result.getString("TASK_PRIO")); // taskArr 3
				taskArr.add(result.getString("DATE_START")); // taskArr 4
				taskArr.add(result.getString("DATE_END")); // taskArr 5
				
//				taskName = taskArr.get(0);
				
//				System.out.println(taskArr.get(0));
				
				
				
//				System.out.println(result.getString("TASK_NAME") + " " + result.getString("TASK_STATUS") + " " + result.getString("TASK_DESC") + " " + result.getString("TASK_PRIO") + " " + result.getString("DATE_START"));
				
			}
			
			
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
			
		}

		return taskArr;
		
	}
	
	/*
	 * Select tasks with a status of "to do" for use of cards
	 */
	
	public static ArrayList<String> readDB() {
		
		ArrayList<String> taskArr = new ArrayList<String>();
		
		try {
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/FRIDAYS_TASKS", "root", "james");
			
			Statement statem = conn.createStatement();
			
			ResultSet result = statem.executeQuery("SELECT * FROM TASKS WHERE TASK_STATUS = 'TO DO';");
			
			while (result.next()) {
				
				taskArr.add(result.getString("TASK_NAME")); // taskArr 0
				taskArr.add(result.getString("TASK_STATUS")); // taskArr 1
				taskArr.add(result.getString("TASK_DESC")); // taskArr 2
				taskArr.add(result.getString("TASK_PRIO")); // taskArr 3
				taskArr.add(result.getString("DATE_START")); // taskArr 4
				taskArr.add(result.getString("DATE_END")); // taskArr 5
				
//				taskName = taskArr.get(0);
				
//				System.out.println(taskArr.get(0));
				
				
				
//				System.out.println(result.getString("TASK_NAME") + " " + result.getString("TASK_STATUS") + " " + result.getString("TASK_DESC") + " " + result.getString("TASK_PRIO") + " " + result.getString("DATE_START"));
				
			}
			
			
		}
		
		/*
		 * https://www.youtube.com/watch?v=2i4t-SL1VsU 
		 * 
		 * link where I got the code for java database connection
		 */
		
		catch (Exception e) {
			
			e.printStackTrace();
			
		}

		return taskArr;
		
	}
	
	/*
	 * this class is used to write to the data base, in the future I would like to implement something so that the program
	 * will use the current date when you switch task from "to do" to "in progress"
	 */
	
	public static String[] writeDB(String tName, String tStatus, String tDesc, String tPrio, String endDate) {
		
		try {
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/FRIDAYS_TASKS", "root", "james");
			
			Statement statem = conn.createStatement();
			
			String insert = (
					"INSERT INTO TASKS (TASK_NAME, TASK_STATUS, TASK_DESC, TASK_PRIO, DATE_END) VALUES ("+ "'" +
					tName + "','" + tStatus + "','" + tDesc + "','" + tPrio + "','" + endDate +
					"');"
			);
			
			statem.executeUpdate(insert);
			
			
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return insertArr;
		
	}


}
