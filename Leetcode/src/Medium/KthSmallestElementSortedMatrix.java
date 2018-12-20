package Medium;

import java.util.PriorityQueue;

public class KthSmallestElementSortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        if (matrix.length == 0) return -1;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int size = ((matrix.length * matrix[0].length) - k)+1;
        for (int i=0;i<matrix.length;i++) {
            for (int j=0;j<matrix[0].length; j++) {
                queue.offer(matrix[i][j]);
                if (queue.size() > size) {
                    queue.poll();
                }
            }
        }

        return queue.peek();
    }

    public static void main(String[] args) {
        KthSmallestElementSortedMatrix s = new KthSmallestElementSortedMatrix();
        int[][] matrix = {{1,  5,  9},
                {10, 11, 13},
                {12, 13, 15}};
        int k = 7;
        System.out.println(s.kthSmallest(matrix,k));
    }
}
