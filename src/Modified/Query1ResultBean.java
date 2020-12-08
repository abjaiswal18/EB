package Modified;

public class Query1ResultBean {
	
	private String empName;
	private String deptName;
	private String regionName;
	
	public Query1ResultBean(String empName, String deptName, String regionName) {
		this.empName = empName;
		this.deptName = deptName;
		this.regionName = regionName;
	}

	public String getEmpName() {
		return empName;
	}

	public String getDeptName() {
		return deptName;
	}

	public String getRegionName() {
		return regionName;
	}
	
}
