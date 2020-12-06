package EdubriteQuestion;
import java.util.*;
import java.io.*;
public class Query {
	
	//function to Print employee list (with name, dept, region) sorted by emp name, asc and desc
	
	public static void firstQuery(List<ArrayList<String>> departmentList, List<ArrayList<String>> employeeList, List<ArrayList<String>> regionList){
		
		Map<String, String> regions = new HashMap<>();
		for(ArrayList<String> i : regionList){
			regions.put(i.get(0), i.get(1));
		}

		Map<String , String> departmentId_name = new HashMap<>();
		for(ArrayList<String> i:departmentList){
			departmentId_name.put(i.get(0), i.get(1));
		}

		Map<String , String> departmentId_region = new HashMap<>();
		for(ArrayList<String> i:departmentList){
			departmentId_region.put(i.get(0), i.get(2));
		}

		Map<String , String> employeeName_dId = new HashMap<>();
		for(ArrayList<String> i:employeeList){
			employeeName_dId.put(i.get(1), i.get(2));
		}
		
		List<String> empName = new ArrayList<>();
		
		for(ArrayList<String> i:employeeList){
			empName.add(i.get(1));
		}
		
		Collections.sort(empName);
		System.out.println("In ascending order");
		
		for (String name : empName) {
			String dId = employeeName_dId.get(name);
			String deptName = departmentId_name.get(dId);
			String regionId = departmentId_region.get(dId);
			String region = regions.get(regionId);
			System.out.println(name + " " + deptName + " " + region);
		}
		
		System.out.println("In descending order");
		System.out.println("EmpName"+" "+"DeptName"+" "+"RegionName");
		Collections.sort(empName,Collections.reverseOrder());
		for (String name : empName) {
			if(!name.equals("Emp Name")){
				String dId = employeeName_dId.get(name);
				String deptName = departmentId_name.get(dId);
				String regionId = departmentId_region.get(dId);
				String region = regions.get(regionId);
				System.out.println(name + " " + deptName + " " + region);
			}
		}
	}

	
	
	
	
	public static void main(String agr[]){
		
		List<ArrayList<String>> departmentList = new ArrayList<ArrayList<String>>();
		List<ArrayList<String>> employeeList = new ArrayList<ArrayList<String>>();
		List<ArrayList<String>> regionList = new ArrayList<ArrayList<String>>();
		String deptFileName = "./Resources/dept.csv";
		departmentList.addAll(dept.read(deptFileName));
		String empFileName = "./Resources/emp.csv";
		employeeList.addAll(emp.read(empFileName));
		String regionFileName = "./Resources/region.csv";
		regionList.addAll(region.read(regionFileName));
		
		firstQuery(departmentList,employeeList,regionList);
		
		
		
		
	}
	 
	
	

}
