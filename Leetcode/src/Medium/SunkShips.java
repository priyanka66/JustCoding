//package Medium;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class SuckShips {
//
//    private String solution(int N, String S, String T) {
//        int[][] matrix = new int[N][N];
//        String[] ship1 = S.split(" ");
//        String[] ship2 = T.split(" ");
////        List<Integer> result = new ArrayList<>();
////        List<List<Integer>> output =  new ArrayList<>();
//        String result = "";
//        System.out.println(ship1);
//        System.out.println(ship2);
//        for (int i=0; i<ship1.length; i++) {
//            char[] val = ship1[i].toCharArray();
//            int x = val[0] -'0' - 1;
//            int y = val[1] - 'A';
//            matrix[x][y] = 1;
//            System.out.println(matrix[x][y]);
//
//        }
//        for (int i=0; i<ship2.length; i++) {
//            char[] val = ship2[i].toCharArray();
//            int x = val[0]-'0' - 1;
//            int y = val[1] - 'A';
//            matrix[x][y] = -1;
//        }
//
//        int index = -1;
//        int  res = 0;
//        for (int i=0;i<matrix.length;i++) {
//            for (int j=0;j<matrix[0].length;j++) {
//                if (matrix[i][j] == -1) {
//                    int count = getRec(i,j,matrix);
//                }
//            }
//        }
//        return result;
//    }
//
//    int getRec(int i, int j, int[][] matrix) {
//        int count = -1;
//        boolean rFlag = false;
//        for (int m=i;m<matrix.length;m++) {
//            for (int n=j;j<matrix.length; n++) {
//                if (matrix[i][j] == -1) {
//                    count ++;
//                }
//                else {
//                    rFlag=
//                    break;
//                }
//            }
//        }
//    }
//    void findRect(int i, int j, int[][] matrix, List<List<Integer>> output, int index) {
//        int x = matrix.length-1;
//        int y = matrix[0].length-1;
//        int colFlag = 0;
//        int rowFlag = 0;
//        int m=0, n=0;
//        for (m=i; m<=x; m++) {
//            if (matrix[m][j] == 1) {
//                rowFlag = 1;
//                break;
//            }
//
//            if (matrix[m][j] == 0) {
//                continue;
//            }
//
//            for (n=j;i<=y;n++) {
//                if (matrix[m][n] == 1) {
//                    rowFlag = 1;
//                    break;
//                }
//                matrix[m][n] = 0;
//            }
//        }
//
//        if (rowFlag == 1){
//            List<Integer> temp = new ArrayList<>();
//            temp.add(m-1);
//            output.add(index,temp);
//        } else {
//            List<Integer> temp = new ArrayList();
//            temp.add(m);
//            output.add(index,temp);
//        }
//
//        if (colFlag == 1){
//            List<Integer> temp = new ArrayList<Integer>();
//            temp.add(n-1);
//            output.add(index,temp);
//        } else {
//            List<Integer> temp = new ArrayList<Integer>();
//            temp.add(n);
//            output.add(index,temp);
//        }
//
//
//    }
//    public static void main(String[] args) {
//        SuckShips s = new SuckShips();
//        int N=4;
//        String S = "1B 2C 2D 4D";
//        String T = "2B 2D 3D 4D 4A";
//        System.out.println(s.solution(N, S, T));
//    }
//}
