package String;

import java.util.Scanner;

public class FakePassword {
  static boolean passwordObtained(String originalPassword, String fakePassword) {
    int j = 2;
    for (int i = 0; i < originalPassword.length(); i++) {
      j = j % fakePassword.length();
      if (originalPassword.charAt(i) != fakePassword.charAt(j)) {
        return false;
      }
      j += 1;
    }
    return true;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tc = sc.nextInt();
    while (tc-- > 0) {
      String originalPassword = sc.next();
      String fakePassword = sc.next();
      String ans = "No";
      if (passwordObtained(originalPassword, fakePassword)) {
        ans = "Yes";
      }
      System.out.println(ans);
    }
    sc.close();
  }
}
