public class TestAnagram {
    public static void main(String[] args) {
        // Test preProcess
        System.out.println("Testing preProcess:");
        System.out.println("'" + Anagram.preProcess("William Shakespeare") + "'");
        System.out.println("'" + Anagram.preProcess("I am a weakish speller") + "'");
        
        // Test specific anagrams
        System.out.println("\nTesting isAnagram:");
        System.out.println("silent, listen: " + Anagram.isAnagram("silent","listen"));
        System.out.println("William Shakespeare, I am a weakish speller: " + 
            Anagram.isAnagram("William Shakespeare","I am a weakish speller"));
        System.out.println("Madam Curie, Radium came: " + 
            Anagram.isAnagram("Madam Curie","Radium came"));
        System.out.println("Tom Marvolo Riddle, I am Lord Voldemort: " + 
            Anagram.isAnagram("Tom Marvolo Riddle","I am Lord Voldemort"));
    }
}
