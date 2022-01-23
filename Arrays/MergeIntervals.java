package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MergeIntervals {
  public static int[][] merge(int[][] intervals) {
    int[][] res = new int[intervals.length][2];
    Arrays.sort(intervals,(o1, o2) -> {
      return o1[0] - o2[0];
    });

    int start = intervals[0][0], end = intervals[0][1], currPos = 0;
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][0] <= end) {
        start = Math.min(start, intervals[i][0]);
        end = Math.max(end, intervals[i][1]);
      } else {
        res[currPos][0] = start;
        res[currPos++][1] = end;
        start = intervals[i][0];
        end = intervals[i][1];
      }
    }
    res[currPos][0] = start;
    res[currPos++][1] = end; 
    return Arrays.copyOfRange(res, 0, currPos);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[][] intervals = new int[n][2];
    for (int i = 0; i < n; i++) {
      intervals[i][0] = sc.nextInt();
      intervals[i][1] = sc.nextInt();
    }
    int[][] mergedIntervals = merge(intervals);
    for (int[] interval : mergedIntervals) {
      System.out.println(interval[0] + " " + interval[1]);
    }
    sc.close();
  }
}
