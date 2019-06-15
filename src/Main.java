import singleton.SingletonEnum;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public int FirstNotRepeatingChar(String str) {
        Map<Character,Integer> map =new HashMap();
        for(int i=0;i<str.length();i++){
            if(map.containsKey(str.charAt(i))){
                int num = map.get(str.charAt(i));
                num++;
                map.put(str.charAt(i),num);
            }else{
                map.put(str.charAt(i),1);
            }
        }

        for(int i=0;i<str.length();i++){
            if(map.get(str.charAt(i))==1){
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Map<Character,Integer> map =new HashMap();
    }
}
