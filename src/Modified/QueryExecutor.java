package Modified;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QueryExecutor {
	
	private DeptQueryHelper deptQueryHelper;
	private EmpQueryHelper empQueryHelper;
	private RegionQueryHelper regionQueryHelper;
	
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
		
		Collections.sort(result, new SortByNameAsc());
		
		System.out.println("Employee List in ascending order");
		System.out.println();
		
		for(Query1ResultBean i:result){
			System.out.println(i.getEmpName()+" "+i.getDeptName()+" "+i.getRegionName());
		}
		
		Collections.sort(result,new SortByNameDesc());
		
		System.out.println();
		System.out.println("Employee List in descending order");
		System.out.println();
		System.out.println("EmpName"+" "+"DeptName"+" "+"RegionName");
		
		for(Query1ResultBean i:result){
			if(!i.getEmpName().equals("Emp Name"))
			System.out.println(i.getEmpName()+" "+i.getDeptName()+" "+i.getRegionName());
		}
	}		

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
		
		System.out.println("DeptName"+" "+"EmpCount");
		
		for(Query2ResultBean i:result1){
			if(!i.getDeptName().equals("Dept Name"))
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
	}
	
	//Employee Count in each region
	public void executeQuery4(){
			
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
		
		System.out.println("RegionName "+"EmpCount");
		
		for(Query4ResultBean i: result3){
			if(!i.getRegionName().equals("RegionName"))
			System.out.println(i.getRegionName()+" "+i.getCount());
		}
		
	}

}
