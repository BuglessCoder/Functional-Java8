package nameTransformation;

import java.util.Arrays;
import java.util.List;

public class TestNameTrans {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		List<String> names = Arrays.asList("jack", "david", "Allen", "s", "tom", "k", "l", 
				"bob", "fei", "oliver", "sara", "cisco", "w", "jay");
		
		String newNames = new NameTransformation().transNames(names);
		System.out.println(newNames);

	}
}
