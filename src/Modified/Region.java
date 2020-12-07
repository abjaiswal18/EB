package Modified;

public class Region {
	
	private String regionId;
	private String regionName;
	
	public Region(String regionId, String regionName) {
		this.regionId = regionId;
		this.regionName = regionName;
	}

	public String getRegionId(){
		return this.regionId;
	}
	
	public String getRegionName(){
		return this.regionName;
	}
		
}
