package EdubriteQuestion;
import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Query {
	
	//function to print employee list (with name, dept, region) sorted by emp name, asc and desc
	
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
		System.out.println("Employee List in ascending order");
		System.out.println();
		
		for (String name : empName) {
			String dId = employeeName_dId.get(name);
			String deptName = departmentId_name.get(dId);
			String regionId = departmentId_region.get(dId);
			String region = regions.get(regionId);
			System.out.println(name + " " + deptName + " " + region);
		}
		
		System.out.println();
		System.out.println("Employee List in descending order");
		System.out.println();
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

	//function to print Emp count in each department and print which dept has no employees
	
	public static void secondQuery(List<ArrayList<String>> departmentList, List<ArrayList<String>> employeeList,List<ArrayList<String>> regionList){
		
		Map<String, Long> employeePerDepartment = new HashMap<>();
		
		System.out.println();
		System.out.println("Employee Count in each department");
		System.out.println();
		String noEmployee=" ";
		for(ArrayList<String> i:departmentList){
			
			String dId = i.get(0);
			String deptName = i.get(1);
			long count  = employeeList.stream().filter(o -> o.get(2).contentEquals(dId)).count();
			employeePerDepartment.put(dId, count);
			
			if(!dId.equals("Dept Id")){
				System.out.println(deptName+" "+count);
			}
			if(count == 0){
				noEmployee = deptName;
			}
		}
		
		System.out.println();
		System.out.println("Dept which has no Employees");
		System.out.println();
		for(String dId : employeePerDepartment.keySet()) {
			if(employeePerDepartment.get(dId) == 0)
				System.out.println("Id: "+dId+" Dept Name: "+noEmployee);
		}
		
		System.out.println();
		System.out.println("Employee count in each region");
		System.out.println();
		
		for(ArrayList<String> region:regionList){
			
			List<List<String>> departmentInCurrentRegion = departmentList.stream().filter(department -> department.get(2).contentEquals(region.get(0))).collect(Collectors.toList());

			long count = departmentInCurrentRegion.stream().mapToLong(o -> employeePerDepartment.get(o.get(0))).sum();
			
			if(!region.get(1).equals("RegionName")){
				System.out.println(region.get(1)+" "+ count);
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
		secondQuery(departmentList,employeeList,regionList);
		
		
		
		
	}
	 
	
	

}
