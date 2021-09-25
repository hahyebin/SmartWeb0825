package java2;

import java.util.HashMap;
import java.util.Map;

abstract class PairMap{
	protected String[] keyArray;
	protected String[] valueArray;
	abstract String get(String key);
	abstract void put(String key, String value);
	abstract String delete(String key);
	abstract int length();
}

class Dictionary extends PairMap{
	 int count = 0;
	
	
	public Dictionary(int num){
		 keyArray = new String[num];
		 valueArray = new String[num];
	}
	
	
	@Override
	String get(String key) {
	   for(int i =0; i<count; i++) {
		   if(keyArray[i].equals(key))
			   return valueArray[i];
	   }
	   return null;
	}
	
	
	
	@Override
	void put(String key, String value) {
	   int i =0;                            //int가 밖에 선언되었다는 점을 확인하기!!!
	   for(i=0; i<count; i++) {
		   if(keyArray[i].equals(key))
			   break;
	   }
	    if(i==count) {
		   if(i<keyArray.length) {
			   keyArray[i] = key;
			   valueArray[i] = value;
			   count ++;
		     }
	  } else {
		keyArray[i] = key;
	    valueArray[i] = value;
		  }
	  }
	
	
	
	
	@Override
	String delete(String key) {
		int i =0;
		   for( i =0; i<count; i++) {
			   if(keyArray[i].equals(key))
				   break;
			   }
		   
		   if(i==count) 
			   return null;
			   
			   String value = valueArray[i];
			   
			   int last = count -1;
			   for(int j=i; j<last; j++) {
				   keyArray[j] = keyArray[j+1];
				   valueArray[j] = valueArray[j+1];
			   }
			   count--;
			   return value;
		   }
	@Override
	int length() {
	  return count;
	}
}

public class ex3 {
	public static void main(String[] args) {
		Dictionary dic = new Dictionary(10);
		dic.put("tom", "자바");
		dic.put("alice", "파이썬");
		dic.put("james", "C++");
		System.out.println("tom의 값은 " +dic.get("tom"));
		System.out.println("maria의 값은 " +dic.get("maria"));  //null
		dic.delete("tom");
		System.out.println("tom의 값은 " + dic.get("tom"));
		
	}
	
}
