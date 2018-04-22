import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Solution {
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> chars = new HashSet<>();
        if (s == null)
            return -1;
        if(s.length()==0)
            return 0;
        int result = 0;
        int i = 0;
        int k=0;
        while(k<s.length()) {
            //如果包含当前char字符，则本次统计结束，字串长度为set的size，重新开始新一轮统计
            if (chars.contains(s.charAt(k))) {
                i = chars.size();
                if (i>result) {
                    result = i;
                }
                for(int m=k-i;s.charAt(m)!=s.charAt(k);m++) //从重复元素下一位开始重新统计
                    chars.remove(s.charAt(m));
            } else
                chars.add(s.charAt(k));
            k++;
        }
        //下面这几行很重要，可能一次通过并没有进入到上循环的第一个判断
        i = chars.size();
        if (i>result)
            result = i;
        return result;
    }
    public static void main(String args[]){
        int result=lengthOfLongestSubstring("abcabcbb");
        System.out.println(result);
    }
}
