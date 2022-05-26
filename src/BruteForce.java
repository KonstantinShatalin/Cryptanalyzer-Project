import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

 class BruteForce {
     private BruteForce() {
     }
     private static int find(String messageEncryption, String patternSearch, int startPositions) {
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
    public static void initializeBrutForce (){
        List<String> listPassResult;
        List<String> listPassNewMessage;
        try {
            listPassResult = Files.readAllLines(CryptAnalyzer.pathEncryption);
            listPassNewMessage = Files.readAllLines(CryptAnalyzer.pathDecrypt);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return;
        }

        for (String messageBrute : listPassNewMessage) {
            for (String patternBrute : listPassResult) {
                int position = -1;
                while ((position = find(messageBrute, patternBrute, position + 1)) != -1)
                    System.out.println(position);
                System.out.println(patternBrute);
            }
        }
    }
}
