import java.io.FileWriter;
import java.io.IOException;

public class BruteForce {
    String messageEncryption;
    String patternSearch;
    int startPositions;

    public BruteForce(String messageEncryption, String patternSearch, int startPositions) {
        this.messageEncryption = messageEncryption;
        this.patternSearch = patternSearch;
        this.startPositions = startPositions;
    }

    public static int find(String messageEncryption, String patternSearch, int startPositions) {
        for (int i = startPositions; i < messageEncryption.length(); i++) {
            if (patternSearch.charAt(0) == messageEncryption.charAt(i)
                    && messageEncryption.length() >= (i + patternSearch.length())
                    && messageEncryption.startsWith(patternSearch, i)) return i;
        }
        try (FileWriter writer = new FileWriter(String.valueOf(CryptAnalyzer.pathResult))) {
            writer.write(patternSearch);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }
}
