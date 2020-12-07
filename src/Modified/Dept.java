package Modified;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
	
	public static void read(String csvFile){
		
		List<Dept> deptList = new ArrayList<Dept>();
		
		try{
			File file = new File(csvFile);
			Scanner inputStream = new Scanner(file);
			
			while(inputStream.hasNext()){
				String data = inputStream.nextLine();
				String department[] = data.split(",");
				deptList.add(new Dept(department[0].trim(),department[1].trim(),department[2].trim()));

			}
			
			for(Dept i : deptList){
				System.out.print(i.getDeptId()+" "+i.getDeptName()+" "+i.getRegionId());
				System.out.println();
			}
			inputStream.close();		
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}
	

	public static void main(String[] args) {
		
		String fileName = "./Resources/dept.csv";
		read(fileName);

	}

}
