package nameTransformation;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 利用Java8实现名字转换问题
 * 要求：用一个列表存放好多名字，其中有一些是单个字符，现在需要去除单个字符，
 * 		然后把剩余内容放在一个以逗号分隔的字符串内，并将每个名字的首字母大写。
 * 
 * @author lidawei
 */

public class NameTransformation {
	
	//首字母大写
	private String capitalizesFirst(String s){
		return s.substring(0,1).toUpperCase() + s.substring(1,s.length());
	}
	
	//业务处理（转换名字）
	public String transNames(List<String> nameList){
		if(nameList == null)
			return "";
		return nameList
				.stream()
				.filter(name -> name.length()>1)
				.map(name -> capitalizesFirst(name))
				.collect(Collectors.joining(","));
	}
}