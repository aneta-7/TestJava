package max;

import java.util.List;

public class MaxImpl implements Max {

	public Integer max(List<Integer> list){
		
		Integer max = list.get(0);
		for(Integer a : list) {
			if (max < a)
				max = a;
		}
		return max;
	}

}
