public class KeywordsDetector {
    public static void main(String[] args) {
        String[] sentences = {
                "Our product will transform the market",
                "Programming is both painful and engaging",
                "This has nothing to do with machine learning",
                "We need to leverage our core competencies",
                "Let's talk about data and algorithms",
                "Chatbots are great but must be used carefully",
                "This blockchain-based solution will disrupt the industry",
                "The team showed great Synergy in the last project",
                "Use simple words without hype and fluff",
                "Our new technology presents a significant paradigm shift",
                "Effective presentations must be clear, concise, and humble"
        };

        // Some keywords that typically signal bullshit contents in business
        // presentations
        String[] keywords = { "synergy", "disrupt", "leverage", "Paradigm", "transform" };

        // Call the function to detect and print sentences containing keywords
        detectAndPrint(sentences, keywords);
    }

    // Function to check if a word is in a sentence
    public static boolean wordInSentence(String sentence, String word) {
        // Convert both sentence and word to lowercase to make the comparison
        // case-insensitive
        sentence = sentence.toLowerCase();
        word = word.toLowerCase();

        // Search for the word in the sentence
        for (int i = 0; i < sentence.length() - word.length() + 1; i++) {
            int j;
            // Compare each character in the word to the characters in the sentence
            for (j = 0; j < word.length(); j++) {
                if (sentence.charAt(i + j) != word.charAt(j)) {
                    break;
                }
            }
            // If all characters match, return true
            if (j == word.length()) {
                return true;
            }
        }

        return false; // Return false if the word was not found
    }

    // Iterates through all the sentences. If a sentence contains one or more of the
    // keywords, prints it.
    public static void detectAndPrint(String[] sentences, String[] keywords) {
        for (int i = 0; i < sentences.length; i++) {
            boolean found = false; // Flag to track if any keyword is found in the sentence
            // Loop through all keywords
            for (int j = 0; j < keywords.length; j++) {
                // If a keyword is found in the sentence, mark it as found and break out of the
                // loop
                if (wordInSentence(sentences[i], keywords[j])) {
                    found = true;
                    break;
                }
            }
            // If at least one keyword was found, print the sentence
            if (found) {
                System.out.println(sentences[i]);
            }
        }
    }
}
