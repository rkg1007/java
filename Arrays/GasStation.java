package Arrays;

import java.util.Scanner;

public class GasStation {
  public static int canCompleteCircuit(int[] gas, int[] costs) {
    int start = 0, end = 0, currGas = 0, canComplete = -2;
    while (canComplete == -2) {
      currGas += gas[end];
      if (currGas >= costs[end]) {
        currGas -= costs[end];
        end = (end + 1) % gas.length;
        if (start == end) {
          canComplete = start;
        }
      } else {
        end = (end + 1) % gas.length;
        if (end <= start) {
          canComplete = -1;
        } else {
          start = end;
          currGas = 0;
        }
      }
    }
    return canComplete;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] gas = new int[n];
    for (int i = 0; i < n; i++) {
      gas[i] = sc.nextInt();
    }
    int[] costs = new int[n];
    for (int i = 0; i < n; i++) {
      costs[i] = sc.nextInt();
    }
    System.out.println(canCompleteCircuit(gas, costs));
    sc.close();
  }
}
