import java.nio.file.Path;
import java.util.Scanner;

public class CryptAnalyzer{
    static Path pathEncryption = Path.of("C:\\Users\\Константин\\Desktop\\Work\\text.txt"); //путь в котором находиться кодовое слово, которое мы ищем для brute force
    static Path pathDecrypt = Path.of("C:\\Users\\Константин\\Desktop\\Work\\textNew.txt"); //путь к файлу с шифром в котором ищем слово для brute force
    static Path pathResult = Path.of("C:\\Users\\Константин\\Desktop\\Work\\result.txt");   // путь к файлу с результатом метода brute force
    static Scanner scanChoseMethod = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Введите, пожалуйста название метода которым хотите воспользоватся \"brute\", \"encrypt\" или \"decrypt\"");
        String choiceMethod = scanChoseMethod.nextLine();
        if (choiceMethod.equals(UserChoice.BRUTEFORCE.getChoice())) {
            BruteForce.initializeBrutForce();

        } else if (choiceMethod.equals(UserChoice.ENCRYPTION.getChoice())) {
           Encryption.initializeEncryption();

        } else if (choiceMethod.equals(UserChoice.DECRYPT.getChoice())) {
            Decryption.initializeDecryption();
        } else {
                System.out.println("Введите кооректный метод, который Вам предлагает система!");
            }
    }

}
