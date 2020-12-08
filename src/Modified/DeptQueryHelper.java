package Modified;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DeptQueryHelper {
	private List<Dept> departmentList;
	private Map<String, String> deptIdToDeptName;
	private Map<String, String> deptIdToRegionId;
	
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
	
	public List<Dept> getDepartmentIdByRegionId(String rId){
		return departmentList.stream().filter(department -> rId.contentEquals(department.getRegionId())).collect(Collectors.toList());
	}

}
