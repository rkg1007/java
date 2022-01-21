package BinarySearch;

import java.util.Scanner;

public class KokoEatingBananas {
  public static int minEatingHours(int[] piles, int speed) {
    int hours = 0;
    for (int bananas : piles) {
      hours += bananas / speed;
      hours += (bananas % speed == 0) ? 0 : 1;
    }
    return hours;
  }

  public static int minEatingSpeed(int[] piles, int h) {
    int low = 1, high = 1;
    for (int bananas : piles) {
      high = Math.max(high, bananas);
    }
    int ans = 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (minEatingHours(piles, mid) <= h) {
        ans = mid;
        high = mid - 1;
      } else {
        low = mid + 1;  
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int h = sc.nextInt();
    int[] piles = new int[n];
    for (int i = 0; i < n; i++) {
      piles[i] = sc.nextInt();
    }
    System.out.println(minEatingSpeed(piles, h));
    sc.close();
  }
}
