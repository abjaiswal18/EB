package Modified;

public class Query4ResultBean {
	
	private String regionName;
	private long count;
	
	public Query4ResultBean(String regionName, long count) {
		this.regionName = regionName;
		this.count = count;
	}

	public String getRegionName() {
		return regionName;
	}

	public long getCount() {
		return count;
	}

}
