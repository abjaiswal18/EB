package Modified;

import java.util.Comparator;

public class SortByNameAsc implements Comparator<Query1ResultBean> {

	@Override
	public int compare(Query1ResultBean a, Query1ResultBean b) {
		
		return (a.getEmpName()).compareTo(b.getEmpName());
	}

}
