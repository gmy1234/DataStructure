package day03;

import java.util.ArrayList;
import java.util.HashMap;

public class longestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {

        String s = "pwwkew";
        System.out.println(getMaxLength(s));

    }

    public static int getMaxLength(String s){

          // 后指针移动的次数
        int result = 0;
        ArrayList<Character> temp = new ArrayList<>();

        char[] data = s.toCharArray();


        for ( int front = 0; front < data.length ; front++) {
            char f = data[front];
            temp.add(f);
            for ( int rear = front + 1 ; rear < data.length ; rear++) {

                char r = data[rear];
                // 如果有重复的元素
                if ( r != f  && !temp.contains(r) ) {
                    temp.add(r);
                    result = Math.max(result, temp.size());

                } else {
                    result = Math.max(result, temp.size());
                    temp.clear();
                    // 跳出循环
                    break;
                }
            }

        }
        return result;
    }


    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;

        HashMap<Character, Integer> map = new HashMap<>();
        // 最长子串长度
        int max = 0;
        // 滑动窗口左下标，i相当于滑动窗口右下标
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            //charAt() 方法用于返回指定索引处的字符。索引范围为从 0 到 length() - 1。
            if(map.containsKey(s.charAt(i))){

                //map.get():返回字符所对应的索引，当发现重复元素时，窗口左指针右移
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            //map.get('a')=0,因为map中只有第一个a的下标，然后更新left指针到原来left的的下一位

            //再更新map中a映射的下标
            map.put(s.charAt(i) ,i);
            //比较两个参数的大小
            max = Math.max(max,i-left+1);
        }
        return max;

    }
}
