package Modified;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Query {
	
	//function to print employee list (with name, dept, region) sorted by emp name, asc and desc
	public static void firstQuery(List<Dept> departmentList, List<Emp> employeeList, List<Region> regionList){
		
		Map<String, String> regions = new HashMap<>();
		for(Region i : regionList){
			regions.put(i.getRegionId(), i.getRegionName());
		}

		Map<String , String> departmentId_name = new HashMap<>();
		for(Dept i:departmentList){
			departmentId_name.put(i.getDeptId(), i.getDeptName());
		}

		Map<String , String> departmentId_region = new HashMap<>();
		for(Dept i:departmentList){
			departmentId_region.put(i.getDeptId(), i.getRegionId());
		}

		Map<String , String> employeeName_dId = new HashMap<>();
		for(Emp i:employeeList){
			employeeName_dId.put(i.getEmpName(), i.getDeptId());
		}
		
		List<String> empName = new ArrayList<>();
		for(Emp i:employeeList){
			empName.add(i.getEmpName());
		}
		
		Collections.sort(empName);
		System.out.println("Employee List in ascending order");
		System.out.println();
		
		for(String name:empName){
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
	public static void secondQuery(List<Dept> departmentList, List<Emp> employeeList, List<Region> regionList){
			
		Map<String, Long> employeePerDepartment = new HashMap<>();
		
		//Employee Count in each department
		System.out.println();
		System.out.println("Employee Count in each department");
		System.out.println();
		
		for(Dept i: departmentList){
			
			String dId = i.getDeptId();
			String deptName = i.getDeptName();
			long count = employeeList.stream().filter(o -> o.getDeptId().contentEquals(dId)).count();
			employeePerDepartment.put(dId, count);
			
			if(!dId.equals("Dept Id")){
				System.out.println(deptName+" "+count);
			}
		}
		
		//dept which has no employee
		System.out.println();
		System.out.println("Dept which has no Employees");
		System.out.println();
		
		for(String dId: employeePerDepartment.keySet()){
			if(employeePerDepartment.get(dId) == 0)
				System.out.println("Id: "+dId);
		}
		
		//Employee Count in each region
		System.out.println();
		System.out.println("Employee count in each region");
		System.out.println();

		for(Region i : regionList){
			
			List<Dept> departmentInCurrentRegion = departmentList.stream().filter(department -> department.getRegionId().contentEquals(i.getRegionId())).collect(Collectors.toList());
			
			long count = departmentInCurrentRegion.stream().mapToLong(o -> employeePerDepartment.get(o.getDeptId())).sum();
			
			if(!i.getRegionName().equals("RegionName")){
				System.out.println(i.getRegionName()+" "+ count);
			}
		}
	}

	
	public static void main(String agr[]){
		
		List<Dept> departmentList = new ArrayList<Dept>();
		List<Emp> employeeList = new ArrayList<Emp>();
		List<Region> regionList = new ArrayList<Region>();
		
		String deptFileName = "./Resources/dept.csv";
		departmentList.addAll(Dept.read(deptFileName));
		
		String empFileName = "./Resources/emp.csv";
		employeeList.addAll(Emp.read(empFileName));
		
		String regionFileName = "./Resources/region.csv";
		regionList.addAll(Region.read(regionFileName));
		
//		for(Region i:regionList){
//			System.out.print(i.getRegionId()+" "+i.getRegionName());
//		System.out.println();
//		}
		
		
		firstQuery(departmentList,employeeList,regionList);
		secondQuery(departmentList,employeeList,regionList);
	}

}
