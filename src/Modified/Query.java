package Modified;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Query {
	
	public static void firstQuery(List<Dept> departmentList, List<Emp> employeeList, List<Region> Region){
		
	}
	
	public static void secondQuery(List<Dept> departmentList, List<Emp> employeeList, List<Region> Region){
			
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
