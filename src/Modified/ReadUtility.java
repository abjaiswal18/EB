package Modified;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadUtility {
	
	private File file;
	private Scanner inputStream;
	
	public ReadUtility(File file, Scanner inputStream) {
		this.file = file;
		this.inputStream = inputStream;
	}

	//function to read dept csv file
	public static List<Dept> initializeDeptList(String csvFile){
		List<Dept> deptList = new ArrayList<Dept>();
		try{
			File file = new File(csvFile);
            Scanner inputStream = new Scanner(file);

            while(inputStream.hasNext()){
                String data = inputStream.nextLine();
                String[] department = data.split(",");
                deptList.add(new Dept(department[0].trim(),department[1].trim(),department[2].trim()));

            }
            inputStream.close();
		}catch(FileNotFoundException e){
            e.printStackTrace();
        }

        return deptList;
	}
	
	//function to read Emp csv file
	public static List<Emp> initializeEmpList(String csvFile){

        List<Emp> empList = new ArrayList<Emp>();

        try{
            File file = new File(csvFile);
            Scanner inputStream = new Scanner(file);

            while(inputStream.hasNext()){
                String data = inputStream.nextLine();
                String employee[] = data.split(",");
                empList.add(new Emp(employee[0].trim(),employee[1].trim(),employee[2].trim()));

            }

            inputStream.close();

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        return empList;
    }

	//function to read Region csv file
    public static List<Region> initializeRegionList(String csvFile){

        ArrayList<Region> regionList = new ArrayList<Region>();

        try{
            File file = new File(csvFile);
            Scanner inputStream = new Scanner(file);

            while(inputStream.hasNext()){
                String data = inputStream.nextLine();
                String region[] = data.split(",");
                regionList.add(new Region(region[0].trim(),region[1].trim()));;

            }

            inputStream.close();

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        return regionList;
    }

}
