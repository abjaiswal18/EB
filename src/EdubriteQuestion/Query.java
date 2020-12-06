package EdubriteQuestion;
import java.util.*;
import java.io.*;
public class Query {
	
	
//	public static void firstQuery(){
//		
////		for(int i=0;i<employeeList.size();i++){
////			String name = employeeList.get(1);
////			String dId = employeeList.get(2);
////			if(departmentList.contains(.contains(dId))){
////				
////			}
////		}
//	}
	
	
	
	public static void main(String agr[]){
		
		ArrayList<ArrayList<String>> departmentList = new ArrayList<ArrayList<String>>();
		ArrayList<ArrayList<String>> employeeList = new ArrayList<ArrayList<String>>();
		ArrayList<ArrayList<String>> regionList = new ArrayList<ArrayList<String>>();
		String deptFileName = "./Resources/dept.csv";
		departmentList.addAll(dept.read(deptFileName));
		String empFileName = "./Resources/emp.csv";
		employeeList.addAll(emp.read(empFileName));
		String regionFileName = "./Resources/region.csv";
		regionList.addAll(region.read(regionFileName));
		
		System.out.println(departmentList);
		System.out.println(employeeList);
		System.out.println(regionList);
//		System.out.println(departmentList.contains(contains("d1")));
		
		for(ArrayList<String> i:departmentList){
			String dId = i.get(0);
			long p =  employeeList.stream().filter(o -> o.get(2) == dId).count();
			System.out.println(p);
		}
		
		
		
	}
	 
	
	

}
