package Medium;

public class ContainerWithMostWater {

    private int maxArea(int[] height) {
        if (height.length == 0) return 0;
        int start=0, end=height.length-1, area=0;
        System.out.println(end);

        while (start<end){
            if (height[start] < height[end]) {
                area = Math.max(area, height[start] * (end-start));
                start++;
            }
            else {
                area = Math.max(area, height[end] * (end-start));
                end--;
            }

        }

        return area;
    }
    public static void main(String[] args) {
        ContainerWithMostWater c = new ContainerWithMostWater();
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(c.maxArea(height));

    }
}
