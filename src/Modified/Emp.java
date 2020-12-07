package Modified;

public class Emp {
	
	private String empId;
	private String empName;
	private String deptId;
	
	public Emp(String empId, String empName, String deptId) {
		this.empId = empId;
		this.empName = empName;
		this.deptId = deptId;
	}

	public String getEmpId(){
		return this.empId;
	}
	
	public String getEmpName(){
		return this.empName;
	}
	
	public String getDeptId(){
		return this.deptId;
	}

}
