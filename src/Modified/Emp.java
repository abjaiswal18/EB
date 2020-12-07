package Modified;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Emp {
	
	private String empId;
	private String empName;
	private String deptId;
	
	public Emp(String empId, String empName, String deptId) {
		this.empId = empId;
		this.empName = empName;
		this.deptId = deptId;
	}

	public String getEmpId(){
		return this.empId;
	}
	
	public String getEmpName(){
		return this.empName;
	}
	
	public String getDeptId(){
		return this.deptId;
	}
	
	public static void read(String csvFile){
		
		List<Emp> empList = new ArrayList<Emp>();
		
		try{
			File file = new File(csvFile);
			Scanner inputStream = new Scanner(file);
			
			while(inputStream.hasNext()){
				String data = inputStream.nextLine();
				String employee[] = data.split(",");
				empList.add(new Emp(employee[0].trim(),employee[1].trim(),employee[2].trim()));

			}
			
			for(Emp i:empList){
				System.out.println(i.getEmpId()+" "+i.getEmpName()+" "+i.getDeptId());
				System.out.println();
			}

			inputStream.close();
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
		
		String fileName = "./Resources/emp.csv";
		read(fileName);
	}

}
