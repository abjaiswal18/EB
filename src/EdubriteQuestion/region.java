package EdubriteQuestion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;

public class region {
	
	//function to read the file
	public static ArrayList read(String csvFile){
		ArrayList<ArrayList<String> > regionList = new ArrayList<ArrayList<String> >();
		
		File file = new File(csvFile);
		try{
			Scanner inputStream = new Scanner(file);
			while(inputStream.hasNext()){
				String data = inputStream.nextLine();
				String region[] = data.split(",");
				ArrayList<String> regionRow = new ArrayList<String>();
				for(String i: region){
					
					regionRow.add(i);

              }
				regionList.add(regionRow);

			}
//			System.out.println(regionList);
			
			inputStream.close();
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		return regionList;
	}

	public static void main(String[] args) {
		
		String fileName = "./Resources/region.csv";
		read(fileName);
		

	}

}
