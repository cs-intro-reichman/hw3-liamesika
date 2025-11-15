public class Anagram {

    public static void main(String args[]) {
        System.out.println(isAnagram("silent","listen")); 
        System.out.println(isAnagram("William Shakespeare","I am a weakish speller"));
        System.out.println(isAnagram("Madam Curie","Radium came"));
        System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort"));

        System.out.println(preProcess("What? No way!!!"));
        
        System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
        
        String str = "1234567";
        Boolean pass = true;
        for (int i = 0; i < 10; i++) {
            String random = randomAnagram(str);
            System.out.println(random);
            pass = pass && isAnagram(str, random);
            if (!pass) break;
        }
        System.out.println(pass ? "test passed" : "test Failed");
    }

    public static boolean isAnagram(String s1, String s2) {
        s1 = preProcess(s1);
        s2 = preProcess(s2);

        if (s1.length() != s2.length()) return false;

        boolean[] used = new boolean[s2.length()];

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            boolean found = false;

            for (int j = 0; j < s2.length(); j++) {
                if (!used[j] && s2.charAt(j) == c) {
                    used[j] = true;
                    found = true;
                    break;
                }
            }

            if (!found) return false;
        }

        return true;
    }

    public static String preProcess(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isLetter(c)) {
                result += Character.toLowerCase(c);
            }
        }
        return result;
    }

    public static String randomAnagram(String str) {
        String result = "";
        String temp = str;

        while (temp.length() > 0) {
            int idx = (int)(Math.random() * temp.length());
            result += temp.charAt(idx);
            temp = temp.substring(0, idx) + temp.substring(idx + 1);
        }

        return result;
    }
}
