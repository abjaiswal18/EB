package Modified;

import java.util.List;

public class Query {
	
	public static void main(String agr[]){
		
		List<Dept> departmentList; 
		List<Emp> employeeList;
		List<Region> regionList;
		
		
		String deptFileName = "./Resources/dept.csv";
		ReadUtility deptList = new ReadUtility(deptFileName);
		departmentList = deptList.initializeDeptList();
		
		String empFileName = "./Resources/emp.csv";
		ReadUtility empList = new ReadUtility(empFileName);
		employeeList = empList.initializeEmpList();
		
		String regionFileName = "./Resources/region.csv";
		ReadUtility regList = new ReadUtility(regionFileName);
		regionList = regList.initializeRegionList();
		
		DeptQueryHelper deptQueryHelper = new DeptQueryHelper(departmentList);
		EmpQueryHelper empQueryHelper = new EmpQueryHelper(employeeList);
		RegionQueryHelper regionQueryHelper = new RegionQueryHelper(regionList);
		
		QueryExecutor queryExecutor = new QueryExecutor(deptQueryHelper, empQueryHelper, regionQueryHelper);
		queryExecutor.executeQuery1();
		queryExecutor.executeQuery2();
		queryExecutor.executeQuery4();
	}

}
