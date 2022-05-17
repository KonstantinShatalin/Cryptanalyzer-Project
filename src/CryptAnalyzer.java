import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class CryptAnalyzer {
    static Path path = Path.of("C:\\Users\\Константин\\Desktop\\Work\\text.txt");
    static Path pathNew = Path.of("C:\\Users\\Константин\\Desktop\\Work\\textNew.txt");

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Пожалуйста, введите ключь для зашифровки данных!");
        int key = scanner.nextInt();

        List<String> listPass = null;
        List<String> listPassNew = null;
        try {
            listPass = Files.readAllLines(path);
            listPassNew = Files.readAllLines(pathNew);
        }catch (IOException e){
            e.printStackTrace();
        }

        if (key > 0) {
            assert listPass != null;
            for (String message : listPass) {
                encryption(key, message);
            }
        }
        System.out.println("Пожалуйста, Введите правильный ключь, для расшифровки данных!");
        if (key == scanner.nextInt()){
        assert listPassNew != null;
        for (String message : listPassNew) {
            decrypt(key, message);
        }

        }else {
            System.out.println("Введенный вами ключь не соответствует! Повторите попытку снова!");
        }





        }

    private static void encryption(int key, String message) {
        String string = "";
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (c >= 'а' && c <= 'я') {
                c += key % 33;
                if (c < 'а')
                    c += 33;
                if (c > 'я')
                    c -= 33;
            } else if (c >= 'А' && c <= 'Я') {
                c += key % 33;
                if (c < 'А')
                    c += 33;
                if (c > 'Я')
                    c -= 33;
            }
            string += c;
            try (FileWriter writer = new FileWriter(String.valueOf(pathNew))) {
                writer.write(string);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(message + " После шифрования: " + string);

    }

        private static void decrypt(int key,String message) {
        int k = Integer.parseInt("-" + key);
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (c >= 'а' && c <= 'я')
            {
                c += k % 33;
                if (c < 'а')
                    c += 33;
                if (c > 'я')
                    c -= 33;
            } else if (c >= 'А' && c <= 'Я')
            {
                c += k % 33;
                if (c < 'А')
                    c += 33;
                if (c > 'Я')
                    c -= 33;
            }
            string.append(c);
        }
        System.out.println(message + " После расшифровки: " + string);
    }




}
