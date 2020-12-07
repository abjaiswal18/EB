package Modified;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmpQueryHelper {
	
	List<Emp> employeeList;
	Map<String, String > empIdToName;
	Map<String, String> empIdToDeptId;
	
	public EmpQueryHelper(List<Emp> employeeList){
		
		empIdToName = new HashMap<>();
		this.employeeList = employeeList;
		for(Emp i:employeeList){
			empIdToName.put(i.getEmpId(), i.getEmpName());
		}
	}
	
	public long getEmployeeCount(String dId){
		return employeeList.stream().filter(o -> dId.contentEquals(o.getDeptId())).count();
	}
	
//	public List<String> getAllEmployeeId(){
//		return employeeList.stream().map(arg0)
//	}
	
	public String getEmployeeNameById(String id){
		return empIdToName.get(id);
	}
}
