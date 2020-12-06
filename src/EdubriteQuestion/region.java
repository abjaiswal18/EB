package EdubriteQuestion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class region {
	
	//function to read the file
	public static void read(String csvFile){
		File file = new File(csvFile);
		try{
			Scanner inputStream = new Scanner(file);
			while(inputStream.hasNext()){
				String data = inputStream.nextLine();
				String department[] = data.split(",");
				for(String i:department){
                  System.out.print(i+" ");
              }
				System.out.println();
			}
			inputStream.close();
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		String fileName = "./Resources/region.csv";
		read(fileName);
		

	}

}
