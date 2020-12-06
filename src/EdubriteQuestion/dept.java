package EdubriteQuestion;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class dept {

	//function to read the file 
	public static ArrayList read(String csvFile){
		ArrayList<ArrayList<String> > deptList = new ArrayList<ArrayList<String> >();
		File file = new File(csvFile);
		try{
			Scanner inputStream = new Scanner(file);
			
			while(inputStream.hasNext()){
				String data = inputStream.nextLine();
				String department[] = data.split(",");
				
				ArrayList<String> deptRow = new ArrayList<String>();
				for(String i:department){
					
					deptRow.add(i.trim());

              }
				deptList.add(deptRow);

			}
			inputStream.close();		
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		return deptList;
	}

	public static void main(String[] args) {
		
		String fileName = "./Resources/dept.csv";
		read(fileName);       
	}

}
