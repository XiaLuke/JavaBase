package cn.xf;

public class _2490 {
    public static boolean isCircularSentence(String sentence) {
        if(sentence == null){
            return false;
        }
        String[] strs = sentence.split(" ");
        if(strs.length == 1){
            return strs[0].substring(0,1).equals(strs[0].substring(strs[0].length()-1));
        }
        if(!strs[strs.length-1].substring((strs[strs.length-1]).length()).equals(strs[0].substring(0,1))){
            return false;
        }
        String first = strs[0];
        for(int i = 1;i<strs.length;i++){
            String item = strs[i];
            String itemFirst = item.substring(0,1);
            String firstLast = first.substring(first.length()-1);
            if(!itemFirst.equals(firstLast)){
                return false;
            }
            first = item;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isCircularSentence("Leetcode eisc cool"));
    }
}
