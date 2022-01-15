package Arrays;

import java.util.Scanner;

public class MajorityElement {
  public static int majorityElement(int[] nums) {
    int res = nums[0], freq = 1;
    for (int i = 1; i < nums.length; i++) {
      if (freq == 0 || res == nums[i]) {
        res = nums[i];
        freq++;
      } else {
        freq--;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] nums = new int[n];
    for (int i = 0; i < n; i++) {
      nums[i] = sc.nextInt();
    }
    System.out.println(majorityElement(nums));
    sc.close();
  }
}
