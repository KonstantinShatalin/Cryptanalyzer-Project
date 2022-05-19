import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;


public class BruteForce {
    static Path pathResult = Path.of("C:\\Users\\Константин\\Desktop\\Work\\result.txt");

    public int find(String messageBrut, String resultBrut, int start) {
        for (int i = start; i < messageBrut.length(); i++) {
            if (resultBrut.charAt(0)==messageBrut.charAt(i)
                    && messageBrut.length()>=(i+resultBrut.length())
                    && messageBrut.substring(i, i+resultBrut.length()).equals(resultBrut)) return i;
        }
        try (FileWriter writer = new FileWriter(String.valueOf(pathResult))) {
            writer.write(resultBrut);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }






}
