package EdubriteQuestion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class emp {

	//function to read the file
	public static ArrayList read(String csvFile){
		ArrayList<ArrayList<String> > empList = new ArrayList<ArrayList<String> >();
		
		File file = new File(csvFile);
		try{
			Scanner inputStream = new Scanner(file);
			while(inputStream.hasNext()){
				String data = inputStream.nextLine();
				String employee[] = data.split(",");
				ArrayList<String> empRow = new ArrayList<String>();
				for(String i:employee){
					
					empRow.add(i);
//                  System.out.print(i+" ");
              }
				empList.add(empRow);
//				System.out.println();
			}
//			System.out.println(empList);
			inputStream.close();
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		return empList;
	}

	public static void main(String[] args) {
		
		String fileName = "./Resources/emp.csv";
		read(fileName);
	}
}
