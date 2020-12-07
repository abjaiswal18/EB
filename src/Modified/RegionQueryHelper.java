package Modified;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegionQueryHelper {
	
	private final Map<String, String> regionIdToName;
	
	public RegionQueryHelper(List<Region> regionList){
		regionIdToName = new HashMap<>();
		for(Region i:regionList){
			regionIdToName.put(i.getRegionId(), i.getRegionName());
		}
	}
	
	public String getRegionNameById(String regionId){
		return regionIdToName.get(regionId);
	}

}
