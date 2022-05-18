import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;


public class BruteForce {
    static Path pathEncryption = Path.of("C:\\Users\\Константин\\Desktop\\Work\\text.txt");

    public int find(String messageBrut, String resultBrut, int start) {
        for (int i = start; i < messageBrut.length(); i++) {
            if (resultBrut.charAt(0)==messageBrut.charAt(i)
                    && messageBrut.length()>=(i+resultBrut.length())
                    && messageBrut.startsWith(resultBrut, i)) return i;
        }
        try (FileWriter writer = new FileWriter(String.valueOf(pathEncryption))) {
            writer.write(resultBrut);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }






}
