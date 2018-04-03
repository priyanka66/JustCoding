public class MissingNumbers {

    public int missingNumber(int[] nums) {
        int sumN = (nums.length * (nums.length+1))/2;
        for(int num:nums){
            sumN -= num;
        }
        return sumN;
    }
    public static void main(String[] args) {
        MissingNumbers v1 = new MissingNumbers();
        int nums[] = {3,0,1};
        System.out.println(v1.missingNumber(nums));
    }
}
