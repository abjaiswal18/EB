package Modified;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DeptQueryHelper {
	List<Dept> departmentList;
	Map<String, String> deptIdToDeptName;
	Map<String, String> deptIdToRegionId;
	
	public DeptQueryHelper(List<Dept> departmentList){
		this.departmentList = departmentList;
		
		deptIdToDeptName = new HashMap<>();
		deptIdToRegionId = new HashMap<>();
		for(Dept i: departmentList){
			deptIdToDeptName.put(i.getDeptId(),i.getDeptName());
			deptIdToRegionId.put(i.getDeptId(), i.getRegionId());
			
		}
	}
	
	public String getDeptNameById(String dId){
		return deptIdToDeptName.get(dId);
	}
	
	public String getRegionIdById(String dId){
		return deptIdToRegionId.get(dId);
	}
	
	public List<String> getAllDepartmentId(){
		return departmentList.stream().map(Dept::getDeptId).collect(Collectors.toList());
	}

}
