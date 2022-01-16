package Arrays;

import java.util.Scanner;

public class MaximiseDistanceToClosestPerson {
  public static int maxDistToClosest(int[] seats) {
    int n = seats.length;

    int[] left = new int[n];
    for (int i = 0; i < n; i++) {
      if (seats[i] == 1) {
        left[i] = 0;
      } else {
        left[i] = (i == 0) ? n - 1 : left[i - 1] + 1;
      }
    }
    
    int ans = 0, right = n - 1;
    for (int i = n - 1; i >= 0; i--) {
      if (seats[i] == 1) {
        right = 0;
      } else {
        ans = Math.max(ans, Math.min(left[i], ++right));
      }
    }
   
    return ans;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] seats = new int[n];
    for (int i = 0; i < n; i++) {
      seats[i] = sc.nextInt();
    }
    System.out.println(maxDistToClosest(seats));
    sc.close();
  }
}
