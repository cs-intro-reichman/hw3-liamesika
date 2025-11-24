/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		testIsAnagram();
		testPreProcess();
		testRandomAnagram();
	}

	private static void testIsAnagram() {
		System.out.println("Testing isAnagram method:");

		boolean test1 = isAnagram("silent", "listen") == true;
		System.out.println("Test 1 (basic anagram): " + (test1 ? "PASS" : "FAIL"));

		boolean test2 = isAnagram("hello", "worlds") == false;
		System.out.println("Test 2 (different lengths): " + (test2 ? "PASS" : "FAIL"));

		boolean test4 = isAnagram("", "") == true;
		System.out.println("Test 4 (empty strings): " + (test4 ? "PASS" : "FAIL"));

		boolean test5 = isAnagram("William Shakespeare", "I am a weakish speller") == true;
		System.out.println("Test 5 (complex anagram): " + (test5 ? "PASS" : "FAIL"));

		boolean test6 = isAnagram("Listen", "Silent") == true;
		System.out.println("Test 6 (case sensitivity): " + (test6 ? "PASS" : "FAIL"));
	}

	private static void testPreProcess() {
		System.out.println("\nTesting preProcess method:");

		boolean test1 = preProcess("hello").equals("hello");
		System.out.println("Test 1 (simple lowercase): " + (test1 ? "PASS" : "FAIL"));

		boolean test2 = preProcess("hello world").equals("helloworld");
		System.out.println("Test 2 (remove spaces): " + (test2 ? "PASS" : "FAIL"));

		boolean test3 = preProcess("HeLLo").equals("hello");
		System.out.println("Test 3 (case conversion): " + (test3 ? "PASS" : "FAIL"));

		boolean test4 = preProcess("").equals("");
		System.out.println("Test 4 (empty string): " + (test4 ? "PASS" : "FAIL"));
	}

	private static void testRandomAnagram() {
		System.out.println("\nTesting randomAnagram method:");

		String original = "hello";
		String random = randomAnagram(original);
		boolean test1 = isAnagram(original, random);
		System.out.println("Test 1 (is anagram): " + (test1 ? "PASS" : "FAIL"));

		boolean test2 = random.length() == original.length();
		System.out.println("Test 2 (same length): " + (test2 ? "PASS" : "FAIL"));

		String random2 = randomAnagram(original);
		String random3 = randomAnagram(original);
		String random4 = randomAnagram(original);
		boolean test3 = !(random.equals(random2) && random2.equals(random3) && random3.equals(random4));
		System.out.println("Test 3 (randomness): " + (test3 ? "PASS" : "FAIL"));
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String s1 = preProcess(str1);
		String s2 = preProcess(str2);

		if (s1.length() != s2.length()) {
			return false;
		}

		for (int i = 0; i < s1.length(); i++) {
			char c = s1.charAt(i);
			boolean found = false;
			String temp = "";

			for (int j = 0; j < s2.length(); j++) {
				if (s2.charAt(j) == c && !found) {
					found = true;
				} else {
					temp = temp + s2.charAt(j);
				}
			}

			if (!found) {
				return false;
			}
			s2 = temp;
		}

		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
				if (c >= 'A' && c <= 'Z') {
					c = (char) (c + 32);
				}
				result = result + c;
			}
		}
		return result;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order.
	public static String randomAnagram(String str) {
		String result = "";
		String remaining = str;

		while (remaining.length() > 0) {
			int randomIndex = (int) (Math.random() * remaining.length());
			result = result + remaining.charAt(randomIndex);

			String temp = "";
			for (int i = 0; i < remaining.length(); i++) {
				if (i != randomIndex) {
					temp = temp + remaining.charAt(i);
				}
			}
			remaining = temp;
		}

		return result;
	}
}