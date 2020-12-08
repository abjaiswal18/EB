package Modified;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RegionQueryHelper {
	
	private List<Region> regionList;
	
	private Map<String, String> regionIdToName;
	
	public RegionQueryHelper(List<Region> regionList){
		this.regionList = regionList;
		regionIdToName = new HashMap<>();
		for(Region i:regionList){
			regionIdToName.put(i.getRegionId(), i.getRegionName());
		}
	}
	
	public String getRegionNameById(String regionId){
		return regionIdToName.get(regionId);
	}
	
	public List<String> getAllRegionById(){
		return regionList.stream().map(Region::getRegionId).collect(Collectors.toList());
	}

}
