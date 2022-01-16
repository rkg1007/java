package Arrays;

import java.util.Scanner;

public class SortColor {
  public static void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  public static void sortColors(int[] nums) {
    int left = 0, right = nums.length - 1, i = 0;
    while (i <= right) {
      if (nums[i] == 0) {
        swap(nums, left++, i);
      } else if (nums[i] == 2) {
        swap(nums, i, right--);
      } else {
        i++;
      }
      i = Math.max(i, left);
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] nums = new int[n];
    for (int i = 0; i < n; i++) {
      nums[i] = sc.nextInt();
    }
    sortColors(nums);
    for (int num : nums) {
      System.out.print(num + " ");
    }
    sc.close();
  }
}
