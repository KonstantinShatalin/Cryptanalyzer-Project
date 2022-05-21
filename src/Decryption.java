public class Decryption {

    public static void decrypt(int key, String encryptionMessage) {
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
}
