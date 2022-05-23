import java.io.FileWriter;
import java.io.IOException;

public class Encryption {
    int key;
    String decodedMessage;

    public Encryption(int key, String decodedMessage) {
        this.key = key;
        this.decodedMessage = decodedMessage;
    }

    public static void encryption(int key, String decodedMessage) {
        StringBuilder stringEncryption = new StringBuilder();
        for (int i = 0; i < decodedMessage.length(); i++) {
            char c = decodedMessage.charAt(i);
            if (c >= 'а' && c <= 'я') {
                c += key % 33;
                if (c < 'а')
                    c += 33;
                if (c > 'я')
                    c -= 32;
            } else if (c >= 'А' && c <= 'Я') {
                c += key % 33;
                if (c < 'А')
                    c += 33;
                if (c > 'Я')
                    c -= 33;
            }
            stringEncryption.append(c);
            try (FileWriter writer = new FileWriter(String.valueOf(CryptAnalyzer.pathDecrypt))) {
                writer.write(String.valueOf(stringEncryption));
            } catch (IOException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
        System.out.println(decodedMessage + " После шифрования: " + stringEncryption);
    }
}
