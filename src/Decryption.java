import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class Decryption implements Initialize {

    private void decrypt(int key, String encryptionMessage) {
        int k = Integer.parseInt("-" + key);
        StringBuilder decodedString = new StringBuilder();
        for (int i = 0; i < encryptionMessage.length(); i++) {
            char c = encryptionMessage.charAt(i);
            if (c >= 'а' && c <= 'я') {
                c += k % 33;
                if (c < 'а')
                    c += 33;
                if (c > 'я')
                    c -= 33;
            } else if (c >= 'А' && c <= 'Я') {
                c += k % 33;
                if (c < 'А')
                    c += 33;
                if (c > 'Я')
                    c -= 33;
            }
            decodedString.append(c);
        }
        System.out.println(encryptionMessage + " После расшифровки: " + decodedString);
    }

    @Override
    public void initialize() {
        System.out.println("Пожалуйста, Введите правильный ключь, для расшифровки данных!");
        int keyDecrypt = CryptAnalyzer.scanChoseMethod.nextInt();
        List<String> listPassNew;
        try {
            listPassNew = Files.readAllLines(CryptAnalyzer.pathDecrypt);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return;
        }
        if (keyDecrypt > 0) {
            for (String messageDecryption : listPassNew) {
                decrypt(keyDecrypt, messageDecryption);
            }
        }else{
            System.out.println("Введенный вами ключь не соответствует! Повторите попытку снова!");
        }
    }
}
