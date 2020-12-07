package Modified;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Query {
	
	public static void firstQuery(List<Dept> departmentList, List<Emp> employeeList, List<Region> regionList){
		
	}
	
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
