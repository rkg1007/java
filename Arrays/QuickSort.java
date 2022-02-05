package Arrays;

import java.util.Scanner;

public class QuickSort {
  static void swap(int[] arr, int left, int right) {
    int temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
  }

  static void quickSort(int[] arr, int low, int high) {
    if (low >= high) {
      return;
    }
    int left = low, mid = low, right = high;
    int pivot = arr[low + (high - low) / 2];
    while (mid <= right) {
      if (arr[mid] < pivot) {
        swap(arr, left++, mid++);
      } else if (arr[mid] == pivot) {
        mid++;
      } else {
        swap(arr, mid, right--);
      }
    }
    quickSort(arr, low, --left);
    quickSort(arr, ++right, high);
  }

  public static void quickSort(int[] arr) {
    quickSort(arr, 0, arr.length - 1);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    quickSort(arr);
    for (int num : arr) {
      System.out.print(num + " ");
    }
    sc.close();
  }
}

