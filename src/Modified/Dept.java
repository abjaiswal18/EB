package Modified;

public class Dept {
	
	private String deptId;
	private String deptName;
	private String regionId;
	
	public Dept(String deptId, String deptName, String regionId){
		this.deptId = deptId;
		this.deptName = deptName;
		this.regionId = regionId;
	}
	
	public String getDeptId(){
		return this.deptId;
	}
	
	public String getDeptName(){
		return this.deptName;
	}
	
	public String getRegionId(){
		return this.regionId;
	}

}
