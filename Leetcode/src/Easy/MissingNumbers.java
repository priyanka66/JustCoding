package Easy;

public class MissingNumbers {

    public int missingNumber(int[] nums) {
        int n = nums.length;
        double sum = (n * (n+1))/2;
        for (int num:nums) {
            sum-=num;
        }
        return (int)sum;
    }
    public static void main(String[] args) {
        MissingNumbers v1 = new MissingNumbers();
        int nums[] = {9,6,4,2,3,5,7,0,1};
        System.out.println(v1.missingNumber(nums));
    }
}
