package String;

import java.util.Scanner;

public class DecreasingOrderString {
  static void merge(char[] sChars, int l, int m, int r) {
    char[] dummySChars = new char[r - l + 1];
    int i = l, j = m + 1, k = 0;
    while (i <= m && j <= r) {
      if (sChars[i] >= sChars[j]) {
        dummySChars[k++] = sChars[i++];
      } else {
        dummySChars[k++] = sChars[j++];
      }
    }
    while (i <= m) {
      dummySChars[k++] = sChars[i++];
    }
    while (j <= r) {
      dummySChars[k++] = sChars[j++];
    }
    for (k = 0; k < r - l + 1; k++) {
      sChars[l + k] = dummySChars[k];
    }
  }

  static void mergeSort(char[] sChars, int l, int r) {
    if (l >= r) {
      return;
    }
    int m = l + (r - l) / 2;
    mergeSort(sChars, l, m);
    mergeSort(sChars, m + 1, r);
    merge(sChars, l, m, r);
  }

  static String mergeSort(String s) {
    char[] sChars = s.toCharArray();
    mergeSort(sChars, 0, sChars.length - 1);
    return new String(sChars);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tc = sc.nextInt();
    while (tc-- > 0) {
      String s = sc.next();
      System.out.println(mergeSort(s));
    }
    sc.close();
  }
}
