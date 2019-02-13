package companies;

import java.util.ArrayList;
import java.util.List;

public class RoverControl {


    public int roverMove(int matrixSize, List<String> cmds) {
        int[] cur = {0,0};
        int result = 0;
        for (int i=0;i<cmds.size(); i++) {
            String cmd = cmds.get(i);
            switch (cmd) {
                case "RIGHT" :
                    if (cur[1] + 1 < matrixSize) {
                        cur[1] = cur[1] + 1;
                    }
                    break;
                case "LEFT" :
                    if (cur[1] - 1 >= 0) {
                        cur[1] = cur[1]-1;
                    }
                    break;
                case "UP" :
                    if (cur[0] - 1 >= 0) {
                        cur[0] = cur[0] - 1;
                    }
                    break;
                case"DOWN" :
                    if (cur[0] + 1 > matrixSize) {
                        cur[0] = cur[0]+1;
                    }
                    break;
            }
        }
        result = (cur[0] * matrixSize) + cur[1];
        return result;
    }

    public static void main(String[] args) {

        RoverControl r = new RoverControl();

        int matrixSize = 4;
        List<String> cmds = new ArrayList<>();
        cmds.add("UP");
//        cmds.add("UP");
        cmds.add("DOWN");
        cmds.add("RIGHT");
        cmds.add("RIGHT");
        cmds.add("LEFT");
        cmds.add("UP");
        System.out.println(r.roverMove(matrixSize, cmds));
    }
}
