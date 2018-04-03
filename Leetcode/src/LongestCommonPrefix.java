public class LongestCommonPrefix {
    public static void main(String[] args){
        String[] temp = {"leet","leetcode","lee"};
        String s = temp[0];
        for(int i=1; i<temp.length;i++){
            while(temp[i].indexOf(s)!=0){
                s = s.substring(0,s.length()-1);
                if(s.isEmpty()){
                    System.out.println("");
                }
            }
        }
        System.out.println(s);
    }
}
