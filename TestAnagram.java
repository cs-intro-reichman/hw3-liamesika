public class TestAnagram {
    public static void main(String[] args) {
        testIsAnagram();
        testPreProcess();
        testRandomAnagram();
    }

    private static void testIsAnagram() {
        System.out.println("Testing isAnagram method:");

        // Test 1: basic anagram
        boolean test1 = Anagram.isAnagram("silent", "listen") == true;
        System.out.println("Test 1 (basic anagram): " + (test1 ? "PASS" : "FAIL"));

        // Test 2: different lengths
        boolean test2 = Anagram.isAnagram("hello", "worlds") == false;
        System.out.println("Test 2 (different lengths): " + (test2 ? "PASS" : "FAIL"));

        // Test 4: empty strings
        boolean test4 = Anagram.isAnagram("", "") == true;
        System.out.println("Test 4 (empty strings): " + (test4 ? "PASS" : "FAIL"));

        // Test 5: complex anagram
        boolean test5 = Anagram.isAnagram("William Shakespeare", "I am a weakish speller") == true;
        System.out.println("Test 5 (complex anagram): " + (test5 ? "PASS" : "FAIL"));

        // Test 6: case sensitivity
        boolean test6 = Anagram.isAnagram("Listen", "Silent") == true;
        System.out.println("Test 6 (case sensitivity): " + (test6 ? "PASS" : "FAIL"));
    }

    private static void testPreProcess() {
        System.out.println("\nTesting preProcess method:");

        // Test 1: simple lowercase
        boolean test1 = Anagram.preProcess("hello").equals("hello");
        System.out.println("Test 1 (simple lowercase): " + (test1 ? "PASS" : "FAIL"));

        // Test 2: remove spaces
        boolean test2 = Anagram.preProcess("hello world").equals("helloworld");
        System.out.println("Test 2 (remove spaces): " + (test2 ? "PASS" : "FAIL"));

        // Test 3: case conversion
        boolean test3 = Anagram.preProcess("HeLLo").equals("hello");
        System.out.println("Test 3 (case conversion): " + (test3 ? "PASS" : "FAIL"));

        // Test 4: empty string
        boolean test4 = Anagram.preProcess("").equals("");
        System.out.println("Test 4 (empty string): " + (test4 ? "PASS" : "FAIL"));
    }

    private static void testRandomAnagram() {
        System.out.println("\nTesting randomAnagram method:");

        // Test 1: is anagram
        String original = "hello";
        String random = Anagram.randomAnagram(original);
        boolean test1 = Anagram.isAnagram(original, random);
        System.out.println("Test 1 (is anagram): " + (test1 ? "PASS" : "FAIL"));

        // Test 2: same length
        boolean test2 = random.length() == original.length();
        System.out.println("Test 2 (same length): " + (test2 ? "PASS" : "FAIL"));

        // Test 3: randomness (run multiple times and check if we get different results)
        String random2 = Anagram.randomAnagram(original);
        String random3 = Anagram.randomAnagram(original);
        String random4 = Anagram.randomAnagram(original);
        boolean test3 = !(random.equals(random2) && random2.equals(random3) && random3.equals(random4));
        System.out.println("Test 3 (randomness): " + (test3 ? "PASS" : "FAIL"));
    }
}
