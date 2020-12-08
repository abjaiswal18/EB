package Modified;

import java.util.List;

public class Query {
	
	public static void main(String agr[]){
		
		List<Dept> departmentList; 
		List<Emp> employeeList;
		List<Region> regionList;
		
		String deptFileName = "./Resources/dept.csv";
		departmentList = ReadUtility.initializeDeptList(deptFileName);
		
		String empFileName = "./Resources/emp.csv";
		employeeList = ReadUtility.initializeEmpList(empFileName);
		
		String regionFileName = "./Resources/region.csv";
		regionList = ReadUtility.initializeRegionList(regionFileName);
		
		DeptQueryHelper deptQueryHelper = new DeptQueryHelper(departmentList);
		EmpQueryHelper empQueryHelper = new EmpQueryHelper(employeeList);
		RegionQueryHelper regionQueryHelper = new RegionQueryHelper(regionList);
		
		QueryExecutor queryExecutor = new QueryExecutor(deptQueryHelper, empQueryHelper, regionQueryHelper);
		queryExecutor.executeQuery1();
		queryExecutor.executeQuery2();
	}

}
