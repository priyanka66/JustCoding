package Hard;

import java.util.Stack;

public class LargestRectangleHistogram {
    public int largestRectangleArea(int[] heights) {
        int area = 0, maxArea = 0, top=-1, i=0;
        Stack<Integer> st = new Stack<>();
        for (i=0;i<heights.length;)  {
            if (st.isEmpty() || heights[st.peek()] <= heights[i]) {
                st.push(i++);
            } else {
                top = st.pop();
                if (st.isEmpty()) {
                    area = heights[top] * i;
                } else {
                    area = heights[top] * (i-st.peek()-1);
                }
                maxArea = Math.max(area, maxArea);
            }
        }

        while (!st.isEmpty()) {
            top = st.pop();
            if (st.isEmpty()) {
                area = heights[top] * i;
            } else {
                area = heights[top] * (i-st.peek()-1);
            }
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};//{2,1,2};
        LargestRectangleHistogram h = new LargestRectangleHistogram();
        System.out.println(h.largestRectangleArea(heights));
    }
}
