import java.nio.file.Path;
import java.util.Scanner;

public class CryptAnalyzer{
    static Path pathEncryption = Path.of("C:\\Users\\Константин\\Desktop\\Work\\text.txt"); //путь в котором находиться кодовое слово, которое мы ищем для brute force
    static Path pathDecrypt = Path.of("C:\\Users\\Константин\\Desktop\\Work\\textNew.txt"); //путь к файлу с шифром в котором ищем слово для brute force
    static Scanner scanChoseMethod = new Scanner(System.in);

    public static void main(String[] args) {
        Initialize initializeEncryption = new Encryption();
        Initialize initializeBrutForce = new BruteForce();
        Initialize initializeDecryption = new Decryption();

        System.out.println("Введите, пожалуйста название метода которым хотите воспользоватся \"brute\", \"encrypt\" или \"decrypt\"");
        String choiceMethod = scanChoseMethod.nextLine();
        if (choiceMethod.equals(UserChoice.BRUTEFORCE.getChoice())) {
            initializeBrutForce.initialize();

        } else if (choiceMethod.equals(UserChoice.ENCRYPTION.getChoice())) {
           initializeEncryption.initialize();

        } else if (choiceMethod.equals(UserChoice.DECRYPT.getChoice())) {
            initializeDecryption.initialize();
        } else {
                System.out.println("Введите кооректный метод, который Вам предлагает система!");
            }
    }

}
