package wordFrequency;

import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * 利用Java8函数式实现词频统计
 * 要求：读入一个文本文件，确定所有单词（虚词除外）的使用频率从高到低排序并打印排序后的结果
 * (这里只提供函数式的思路和算法，不再做具体的Test)
 * 
 * @author lidawei
 */

public class WordFrequency {
	
	//建立一个虚词的集合（含有部分冠词和连接词）
	private Set<String> NON_WORDS = new HashSet<String>() {{
        add("the");
        add("and");
        add("of");
        add("to");
        add("a");
        add("an");
        add("i");
        add("it");
        add("in");
        add("or");
        add("is");
        add("d");
        add("s");
        add("as");
        add("so");
        add("but");
        add("be");
    }};
    
    //正则表达式匹配，将匹配结果放到一个List里并返回
    private List<String> regexToList(String words, String regex) {
        List wordList = new ArrayList<>();
        Matcher m = Pattern.compile(regex).matcher(words);
        while (m.find())
        	wordList.add(m.group());
        return wordList;
    }

    //将单词和对应的词频放到一个Map里并返回
    public Map wordFreq(String words) {
        TreeMap<String, Integer> wordMap = new TreeMap<>();
        regexToList(words, "\\w+").stream()	//将正则匹配的结果转换为stream
                .map(w -> w.toLowerCase())	//将所有单词都转换为小写
                .filter(w -> !NON_WORDS.contains(w)) //过滤虚词
                .forEach(w -> wordMap.put(w, wordMap.getOrDefault(w, 0) + 1));	//统计词频
        return wordMap;
    }
}