package Hard;

public class TrappingRainWater {

    public int trap(int[] height) {
        int left=0,right= height.length-1;
        int  area=0, temp = 0;
        while (left<right) {
            if (height[left] < height[right]) {
                temp = Math.max(height[left], temp);
                area += temp-height[left];
                left++;
            } else {
                temp = Math.max(height[right], temp);
                area += temp-height[right];
                right--;
            }
        }

        return area;

    }

    public static void main(String[] args) {
        TrappingRainWater r  =  new TrappingRainWater();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(r.trap(height));
    }
}
