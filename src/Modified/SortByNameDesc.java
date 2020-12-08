package Modified;

import java.util.Comparator;

public class SortByNameDesc implements Comparator<Query1ResultBean>{

	@Override
	public int compare(Query1ResultBean o1, Query1ResultBean o2) {
		
		return (o2.getEmpName()).compareTo(o1.getEmpName());
	}
	
	
}
