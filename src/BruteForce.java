import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

 class BruteForce implements Initialize {

     private int find(String messageEncryption, String patternSearch, int startPositions) {
        for (int i = startPositions; i < messageEncryption.length(); i++) {
            if (patternSearch.charAt(0) == messageEncryption.charAt(i)
                    && messageEncryption.length() >= (i + patternSearch.length())
                    && messageEncryption.startsWith(patternSearch, i)) return i;
        }
        return -1;
    }

     @Override
     public void initialize() {
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
