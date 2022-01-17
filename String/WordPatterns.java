package String;

import java.util.HashMap;
import java.util.Scanner;

public class WordPatterns {
  public static boolean wordPattern(String pattern, String s) {
    String[] words = s.split(" ");
    if (pattern.length() != words.length) {
      return false;
    }

    HashMap<Character, String> chToStringMap = new HashMap<>();
    HashMap<String, Character> stringToChMap = new HashMap<>();
    for (int i = 0; i < words.length; i++) {
      char ch = pattern.charAt(i);
      String word = words[i];

      if (chToStringMap.containsKey(ch) || stringToChMap.containsKey(word)) {
        if (!chToStringMap.getOrDefault(ch, "").equals(word) 
            || stringToChMap.getOrDefault(word, '#') != ch) {
            return false;
        }
      } else {
        chToStringMap.put(ch, word);
        stringToChMap.put(word, ch);
      }
    }

    return true;
  }
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String pattern = sc.next();
    sc.nextLine();
    String s = sc.nextLine();
    System.out.println(wordPattern(pattern, s));
    sc.close();
  }
}
