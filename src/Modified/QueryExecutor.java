package Modified;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class QueryExecutor {
	
	DeptQueryHelper deptQueryHelper;
	EmpQueryHelper empQueryHelper;
	RegionQueryHelper regionQueryHelper;
	
	public QueryExecutor(DeptQueryHelper deptQueryHelper, EmpQueryHelper empQueryHelper,
			RegionQueryHelper regionQueryHelper) {
		this.deptQueryHelper = deptQueryHelper;
		this.empQueryHelper = empQueryHelper;
		this.regionQueryHelper = regionQueryHelper;
	}
	
	//function to print employee list (with name, dept, region) sorted by emp name, asc and desc
	public void executeQuery1(){
		
		List<String> allEmployeeId = empQueryHelper.getAllEmployeeId();
		
		List<Query1ResultBean> result = new ArrayList<>();
		
		for(String i: allEmployeeId){
			
			String empName = empQueryHelper.getEmployeeNameById(i);
			String dId = empQueryHelper.getDeptIdById(i);
			String deptName = deptQueryHelper.getDeptNameById(dId);
			String regionId = deptQueryHelper.getRegionIdById(dId);
			String region = regionQueryHelper.getRegionNameById(regionId);
			result.add(new Query1ResultBean(empName,deptName,region));
			
		}
		
		for(Query1ResultBean i:result){
			System.out.println(i.getEmpName()+" "+i.getDeptName()+" "+i.getRegionName());
		}
	}		
//		Collections.sort(empName);
//		System.out.println("Employee List in ascending order");
//		System.out.println();
//		
//		for(String name:empName){
//			String dId = employeeName_dId.get(name);
//			String deptName = departmentId_name.get(dId);
//			String regionId = departmentId_region.get(dId);
//			String region = regions.get(regionId);
//			System.out.println(name + " " + deptName + " " + region);
//		}
		
//		System.out.println();
//		System.out.println("Employee List in descending order");
//		System.out.println();
//		System.out.println("EmpName"+" "+"DeptName"+" "+"RegionName");
//		Collections.sort(empName,Collections.reverseOrder());
//		
//		for (String name : empName) {
//			if(!name.equals("Emp Name")){
//				String dId = employeeName_dId.get(name);
//				String deptName = departmentId_name.get(dId);
//				String regionId = departmentId_region.get(dId);
//				String region = regions.get(regionId);
//				System.out.println(name + " " + deptName + " " + region);
//			}
//		}
//	
//	}
	
	public void executeQuery2(){

		//Employee Count in each department
		System.out.println();
		System.out.println("Employee Count in each department");
		System.out.println();
		
		List<String> allDepartmentId = deptQueryHelper.getAllDepartmentId();
		List<Query2ResultBean> result1 = new ArrayList<>();
		
		for(String i:allDepartmentId){
			result1.add(new Query2ResultBean(deptQueryHelper.getDeptNameById(i),empQueryHelper.getEmployeeCount(i)));
		}
		for(Query2ResultBean i:result1){
			System.out.println(i.getDeptName()+" "+i.getCount());
		}
				
		//dept which has no employee
		System.out.println();
		System.out.println("Dept which has no Employees");
		System.out.println();
		
		List<Query3ResultBean> result2 = new ArrayList<>();
		for(Query2ResultBean i: result1){
			if(i.getCount() == 0){
				result2.add(new Query3ResultBean(i.getDeptName()));
			}
		}
		
		for(Query3ResultBean i: result2){
			System.out.println(i.getDeptName());
		}
		
		
		//Employee Count in each region
		System.out.println();
		System.out.println("Employee count in each region");
		System.out.println();
		
		List<Query4ResultBean> result3 = new ArrayList<>();
		List<Dept> departmentInCurrentregion = new ArrayList<>();
		List<String> allRegionId = regionQueryHelper.getAllRegionById();
		
		for(String i : allRegionId){
			departmentInCurrentregion.addAll(deptQueryHelper.getDepartmentIdByRegionId(i));
			long count = departmentInCurrentregion.stream().mapToLong(o -> empQueryHelper.getEmployeeCount(o.getDeptId())).count();
			result3.add(new Query4ResultBean(regionQueryHelper.getRegionNameById(i),count));
			departmentInCurrentregion.clear();
		}
		for(Query4ResultBean i: result3){
			if(!i.getRegionName().equals("RegionName"));
			System.out.println(i.getRegionName()+" "+i.getCount());
		}
		
	}

}
