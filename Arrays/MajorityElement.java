package Arrays;

import java.util.Scanner;

public class MajorityElement {
  public static int majorityElement(int[] nums) {
    int candidate = nums[0], count = 1;
    for (int i = 1; i < nums.length; i++) {
      candidate = (count == 0) ? nums[i] : candidate;
      count += (candidate == nums[i]) ? 1 : -1;
    }
    return candidate;
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
