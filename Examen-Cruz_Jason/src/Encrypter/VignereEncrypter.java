package Encrypter;

public class VignereEncrypter implements IEncrypter {

    private String letters = "ABCDEFGHIJKLMNÑOPQRSTUVXYZ";
    private String key = "CENFO";

    @Override
    public String encrypt(String textToEncrypt) {
        String textEncrypted = "";
        char[] claveEquals = new char[textToEncrypt.length()];
        char[] Msj = textToEncrypt.toUpperCase().toCharArray();
        int cont = 0;
        for (int i = 0; i < textToEncrypt.length(); i++) {

            if (textToEncrypt.charAt(i) == ' ') {
                i++;
            }
            claveEquals[i] = key.charAt(cont);
            cont++;
            if (cont == key.length()) {
                cont = 0;
            }
        }//
        int x = 0, y = 0, z;
        for (int i = 0; i < textToEncrypt.length(); i++) {
            if (textToEncrypt.charAt(i) == ' ') {
                textEncrypted += " ";
                i++;
            }
            for (int j = 0; j < letters.length(); j++) {
                if (Msj[i] == letters.charAt(j)) {
                    x = j;

                }
                if (claveEquals[i] == letters.charAt(j)) {
                    y = j;

                }


            }
            z = (x + y) % 27;
            textEncrypted += letters.charAt(z);

        }

        return textEncrypted;
    }

    @Override
    public String decrypt(String textToDecrypt) {
        String textDecrypted = "";

        char[] claveEquals = new char[textToDecrypt.length()];
        char[] Msg = textToDecrypt.toUpperCase().toCharArray();
        int cont = 0;
        for (int i = 0; i < textToDecrypt.length(); i++) {

            if (textToDecrypt.charAt(i) == ' ') {
                i++;
            }
            claveEquals[i] = key.charAt(cont);
            cont++;
            if (cont == key.length()) {
                cont = 0;
            }
        }
        cont = 0;
        int x = 0, y = 0, z, t;
        for (int i = 0; i < textToDecrypt.length(); i++) {
            if (textToDecrypt.charAt(i) == ' ') {
                textDecrypted += " ";
                i++;
            }
            for (int j = 0; j < letters.length(); j++) {
                if (Msg[i] == letters.charAt(j)) {
                    x = j;

                }
                if (claveEquals[i] == letters.charAt(j)) {
                    y = j;

                }


            }
            z = (y - x);

            if (z <= 0) {
                if (z == 0) {
                    textDecrypted += "A";
                } else {
                    for (int j = 1; j <= letters.length(); j++) {
                        cont++;
                        if (cont == (z * -1)) {
                            textDecrypted += letters.charAt(j);
                            break;
                        }
                    }
                }

            } else {
                for (int k = 26; k >= 0; k--) {
                    cont++;
                    if (cont == z) {
                        textDecrypted += letters.charAt(k);
                        break;
                    }
                }
            }

            cont = 0;

        }

        return textDecrypted;
    }
}
