package chap10;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Question_10_2 {
	String sortChars(String s)
	{
		char c[]=s.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}
	void groupAnagrams(String[] array)
	{
		HashMap<String, LinkedList<String>> map=new HashMap<>();
		for(int i=0;i<array.length;i++)
		{
			String temp=array[i];
			String key=sortChars(temp);
			if(map.containsKey(key))
			{
				map.get(key).add(temp);
			}
			else
			{
				LinkedList<String> list=new LinkedList<>();
				list.add(temp);
				map.put(key, list);
			}
		}
		for(Map.Entry<String, LinkedList<String>> entry: map.entrySet())
		{
			//System.out.println(entry.getKey()+":"+entry.getValue());
			System.out.println(entry.getValue());
		}
	}
	public static void main(String[] args) {
		Question_10_2 obj=new Question_10_2();
		String[] a= {"a","ab","cab","ba","bac","abc"};
		obj.groupAnagrams(a);
	}
}
