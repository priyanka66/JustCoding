package Medium;

public class FindPeakElement {

    private int findPeakElement(int[] nums) {
        int start=0, end = nums.length-1;
        while (start < end) {
            int mid = (start+end)/2;
            if (nums[mid] > nums[mid+1])  end = mid;
            else start = mid+1;
        }

        return start;
    }



    public static void main(String[] args) {
        FindPeakElement p = new FindPeakElement();
        int[] nums = {2,1};
        System.out.println(p.findPeakElement(nums));
    }
}
