package Modified;

public class Query2ResultBean {

	private String deptName;
	private long count;
	
	public Query2ResultBean(String deptName, long l) {
		this.deptName = deptName;
		this.count = l;
	}

	public String getDeptName() {
		return deptName;
	}

	public long getCount() {
		return count;
	}
		
	
	
}
