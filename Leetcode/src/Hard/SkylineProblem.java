package Hard;

import java.lang.reflect.Array;
import java.util.*;

public class SkylineProblem {

    public class BuildingPoint implements Comparable<BuildingPoint>{
        int x;
        int height;
        boolean isStart;

        //first compare by x.
        //If they are same then use this logic
        //if two starts are compared then higher height building should be picked first
        //if two ends are compared then lower height building should be picked first
        //if one start and end is compared then start should appear before end

        @Override
        public int compareTo(BuildingPoint o) {
            if (this.x != o.x) return this.x - o.x;
            else {
                return (this.isStart ? -this.height:this.height) - (o.isStart ? - o.height : o.height);
            }
        }
    }

    public List<int[]> getSkyline(int[][] buildings) {
      BuildingPoint[] buildingPoints = new BuildingPoint[buildings.length*2];
      int index=0;
      for (int[] building: buildings) {
          buildingPoints[index] = new BuildingPoint();
          buildingPoints[index].x = building[0];
          buildingPoints[index].isStart = true;
          buildingPoints[index].height = building[2];

          buildingPoints[index+1] = new BuildingPoint();
          buildingPoints[index+1].x = building[1];
          buildingPoints[index+1].isStart = false;
          buildingPoints[index+1].height = building[2];

          index+=2;
      }

      Arrays.sort(buildingPoints);

      int maxHeight=0, curHeight=0;
      TreeMap<Integer, Integer> queue = new TreeMap<>();
      queue.put(0,1);

      List<int[]> result = new ArrayList<>();
      for (BuildingPoint buildingPoint: buildingPoints) {
          if (buildingPoint.isStart) {
              queue.put(buildingPoint.height, queue.getOrDefault(buildingPoint.height, 0)+1);
          } else {
              if (queue.get(buildingPoint.height) > 1) {
                  queue.put(buildingPoint.height, queue.get(buildingPoint.height)-1);
              } else {
                  queue.remove(buildingPoint.height);
              }
          }
          curHeight = queue.lastKey();
          if (maxHeight != curHeight) {
              maxHeight = curHeight;
              result.add(new int[]{buildingPoint.x, curHeight});
          }
      }

        return result;
    }

    public static void main(String[] args) {
        SkylineProblem s = new SkylineProblem();
        int[][] buildings = {{1,3,4},{3,4,4},{2,6,2},{8,11,4}, {7,9,3},{10,11,2}};//{{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        List<int[]> result = s.getSkyline(buildings);
        for (int[] res : result) {
            System.out.println(Arrays.toString(res));
        }

        /**[1, 4]
         [4, 2]
         [6, 0]
         [7, 3]
         [8, 4]
         [11, 0]*/
    }
}
