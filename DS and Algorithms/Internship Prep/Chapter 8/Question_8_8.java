package chap8;
import java.util.*;

public class Question_8_8 {
	ArrayList<String> printPerm(String s)
	{
		ArrayList<String> result=new ArrayList<>();
		HashMap<Character, Integer> map=buildFreq(s);
		printPerm(map, "", s.length(), result);
		/*for(int i=0;i<result.size();i++)
		{
			System.out.println(result.get(i));
		}*/
		return result;
	}
	HashMap<Character, Integer> buildFreq(String s)
	{
		HashMap<Character, Integer> map=new HashMap<>();
		char ch[]=s.toCharArray();
		for(int i=0;i<ch.length;i++)
		{
			if(map.containsKey(ch[i])==false)
			{
				map.put(ch[i], 0);
			}
			map.put(ch[i], map.get(ch[i])+1);
		}
		return map;
	}
	void printPerm(HashMap<Character, Integer> map, String prefix, int remaining, ArrayList<String> result)
	{
		if(remaining==0)
		{
			result.add(prefix);
			return;
		}
		
		for(Character c:map.keySet())
		{
			int count=map.get(c);
			if(count>0)
			{
				map.put(c, count-1);
				printPerm(map, prefix+c, remaining-1, result);
				map.put(c, count);
			}
		}
	}
	public static void main(String[] args) {
		Question_8_8 obj=new Question_8_8();
		System.out.println(obj.printPerm("aab"));
		//obj.printPerm("aab");
	}
}
