import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class Encryption implements Initialize,WriterDate{

    private void encryption(int key, String decodedMessage) {
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
            setWriter(stringEncryption);
        }
        System.out.println(decodedMessage + " После шифрования: " + stringEncryption);
    }

    @Override
    public void setWriter(StringBuilder stringEncryption) {
        try (FileWriter writer = new FileWriter(String.valueOf(CryptAnalyzer.pathDecrypt))) {
            writer.write(String.valueOf(stringEncryption));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }




    @Override
    public void initialize() {
        System.out.println("Пожалуйста, введите ключь для зашифровки данных!");
        int keyEncrypt = CryptAnalyzer.scanChoseMethod.nextInt();
        List<String> listPass;
        try {
            listPass = Files.readAllLines(CryptAnalyzer.pathEncryption);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return;
        }
        if (keyEncrypt > 0) {
            for (String messageEncrypted : listPass) {
                encryption(keyEncrypt, messageEncrypted);
            }
        }else {
            System.out.println("Введенный вами ключь не соответствует! Повторите попытку снова!");
        }

    }
}
