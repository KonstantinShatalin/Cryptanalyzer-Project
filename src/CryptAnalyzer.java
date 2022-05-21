import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class CryptAnalyzer{
    static Path pathEncryption = Path.of("C:\\Users\\Константин\\Desktop\\Work\\text.txt"); //путь в котором находиться кодовое слово, которое мы ищем для brute force
    static Path pathDecrypt = Path.of("C:\\Users\\Константин\\Desktop\\Work\\textNew.txt"); //путь к файлу с шифром в котором ищем слово для brute force
    static Path pathResult = Path.of("C:\\Users\\Константин\\Desktop\\Work\\result.txt");   // путь к файлу с результатом метода brute force


    public static void main(String[] args) {
        Scanner scanChoseMethod = new Scanner(System.in);
        int keyEncryptDecrypt;
        System.out.println("Введите, пожалуйста название метода которым хотите воспользоватся \"brute\", \"encrypt\" или \"decrypt\"");
        String choiceMethod = scanChoseMethod.nextLine();
        if (choiceMethod.equals(UserChoice.BRUTEFORCE.getChoice())) {
            List<String> listPassResult;
            List<String> listPassNewMessage;
            try {
                listPassResult = Files.readAllLines(pathEncryption);
                listPassNewMessage = Files.readAllLines(pathDecrypt);
            } catch (IOException e) {
                System.out.println(e.getMessage());
                return;
            }

                for (String messageBrute : listPassNewMessage) {
                    for (String patternBrute : listPassResult) {
                        int position = -1;
                        while ((position = BruteForce.find(messageBrute, patternBrute, position + 1)) != -1)
                            System.out.println(position);
                        System.out.println(patternBrute);
                    }
                }

        } else if (choiceMethod.equals(UserChoice.ENCRYPTION.getChoice())) {
            System.out.println("Пожалуйста, введите ключь для зашифровки данных!");
            keyEncryptDecrypt = scanChoseMethod.nextInt();
            List<String> listPass;
            try {
                listPass = Files.readAllLines(pathEncryption);
            } catch (IOException e) {
                System.out.println(e.getMessage());
                return;
            }
            if (keyEncryptDecrypt > 0) {
                for (String messageEncrypted : listPass) {
                    Encryption.encryption(keyEncryptDecrypt, messageEncrypted);
                }
            }
        } else if (choiceMethod.equals(UserChoice.DECRYPT.getChoice())) {
            System.out.println("Пожалуйста, Введите правильный ключь, для расшифровки данных!");
            keyEncryptDecrypt = scanChoseMethod.nextInt();
            List<String> listPassNew;
            try {
                listPassNew = Files.readAllLines(pathDecrypt);
            } catch (IOException e) {
                System.out.println(e.getMessage());
                return;
            }
            if (keyEncryptDecrypt > 0) {
                for (String messageDecryption : listPassNew) {
                    Decryption.decrypt(keyEncryptDecrypt, messageDecryption);
                }
            }
        } else {
                System.out.println("Введенный вами ключь не соответствует! Повторите попытку снова!");
            }
    }
}
