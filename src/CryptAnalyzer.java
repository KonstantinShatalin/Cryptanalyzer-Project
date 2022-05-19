import javafx.application.Application;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class CryptAnalyzer extends Application {
    static Path pathEncryption = Path.of("C:\\Users\\Константин\\Desktop\\Work\\text.txt"); //путь в котором находиться кодовое слово, которое мы ищем для brute force
    static Path pathDecrypt = Path.of("C:\\Users\\Константин\\Desktop\\Work\\textNew.txt"); //путь к файлу с шифром в котором ищем слово для brute force

    public static void main(String[] args) {
        BruteForce bruteForce = new BruteForce();
        Scanner scanChoseMethod = new Scanner(System.in);
        System.out.println("Введите, пожалуйста название метода которым хотите воспользоватся \"brut\" или \"other\"");
        String chose = scanChoseMethod.nextLine();


        if (chose.equalsIgnoreCase("brute")) {

            List<String> listPassResult = null;
            List<String> listPassNewMessage = null;
            try {
                listPassResult = Files.readAllLines(pathEncryption);
                listPassNewMessage = Files.readAllLines(pathDecrypt);
            } catch (IOException e) {
                e.printStackTrace();
            }
            assert listPassNewMessage != null;
            for (String messageBrute : listPassNewMessage) {
                for (String resultBrute : listPassResult) {
                    int position = -1;
                    while ((position = bruteForce.find(messageBrute, resultBrute, position + 1)) != -1)

                        System.out.println(position);
                    System.out.println(resultBrute);

                }
            }
        } else if (chose.equalsIgnoreCase("other")) {


            Scanner scanner = new Scanner(System.in);
            System.out.println("Пожалуйста, введите ключь для зашифровки данных!");
            int key = scanner.nextInt();

            List<String> listPass = null;
            List<String> listPassNew = null;
            try {
                listPass = Files.readAllLines(pathEncryption);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (key > 0) {
                assert listPass != null;
                for (String message : listPass) {
                    encryption(key, message);
                }
            }

            System.out.println("Пожалуйста, Введите правильный ключь, для расшифровки данных!");
            try {
                listPassNew = Files.readAllLines(pathDecrypt);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (key == scanner.nextInt()) {
                assert listPassNew != null;
                for (String message : listPassNew) {
                    decrypt(key, message);
                }
            } else {
                System.out.println("Введенный вами ключь не соответствует! Повторите попытку снова!");
            }
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
            try (FileWriter writer = new FileWriter(String.valueOf(pathDecrypt))) {
                writer.write(string);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(message + " После шифрования: " + string);

    }

    private static void decrypt(int key, String message) {
        int k = Integer.parseInt("-" + key);
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
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
            string.append(c);
        }
        System.out.println(message + " После расшифровки: " + string);
    }

    @Override
    public void start(Stage stage) throws Exception {

    }
}
