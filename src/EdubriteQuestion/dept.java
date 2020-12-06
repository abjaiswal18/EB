package EdubriteQuestion;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class dept {

	//function to read the file 
	public static void read(String csvFile){
		ArrayList<ArrayList<String> > deptList = new ArrayList<ArrayList<String> >();
		File file = new File(csvFile);
		try{
			Scanner inputStream = new Scanner(file);
			while(inputStream.hasNext()){
				String data = inputStream.nextLine();
				String department[] = data.split(",");
				ArrayList<String> deptRow = new ArrayList<String>();
				for(String i:department){
					deptRow.add(i);
//                  System.out.print(i+" ");
              }
				deptList.add(deptRow);
//				System.out.println();
			}
			System.out.println(deptList);
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
