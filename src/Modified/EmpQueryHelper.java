package Modified;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmpQueryHelper {
	
	List<Emp> employeeList;
	Map<String, String > empIdToName;
	Map<String, String> empIdToDeptId;
	
	public EmpQueryHelper(List<Emp> employeeList){
		
		empIdToName = new HashMap<>();
		empIdToDeptId = new HashMap<>();
		this.employeeList = employeeList;
		for(Emp i:employeeList){
			empIdToName.put(i.getEmpId(), i.getEmpName());
			empIdToDeptId.put(i.getEmpId(), i.getDeptId());
		}
	}
	
	public long getEmployeeCount(String dId){
		return employeeList.stream().filter(o -> dId.contentEquals(o.getDeptId())).count();
	}
	
	public List<String> getAllEmployeeId(){
		return employeeList.stream().map(Emp::getEmpId).collect(Collectors.toList());
	}
	
	public String getEmployeeNameById(String id){
		return empIdToName.get(id);
	}

	public String getDeptIdById(String dId) {
		return empIdToDeptId.get(dId);
	}
}
