package Modified;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
		
	public static List<Region> read(String csvFile){
		
		ArrayList<Region> regionList = new ArrayList<Region>();
		
		try{
			File file = new File(csvFile);
			Scanner inputStream = new Scanner(file);
			
			while(inputStream.hasNext()){
				String data = inputStream.nextLine();
				String region[] = data.split(",");
				regionList.add(new Region(region[0].trim(),region[1].trim()));;
			
			}
			
//			for(Region i:regionList){
//				System.out.print(i.getRegionId()+" "+i.getRegionName());
			//System.out.println();
//			}
			
			inputStream.close();
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		return regionList;
	}
	
	public static void main(String agr[]){
		String fileName = "./Resources/region.csv";
		read(fileName);
	}
}
