package Encrypter;

public class CesarEncrypter implements IEncrypter  {
    private String letters = "ABCDEFGHIJKLMNÑOPQRSTUVXYZ";
    private int key = 3;


    @Override
    public String encrypt(String textToEncrypt) {
        String textEncrypted = "";
        textToEncrypt = textToEncrypt.toUpperCase();

        char caracter;

        for(int i = 0; i < textToEncrypt.length(); i++){
            caracter = textToEncrypt.charAt(i);

            int pos = letters.indexOf(caracter);

            if (pos == -1){
                textEncrypted += caracter;
            }else{
                textEncrypted += letters.charAt((pos+key)% letters.length());
            }
        }

        return textEncrypted;
    }

    @Override
    public String decrypt(String textToDecrypt) {
        String textDecrypted = "";
        textToDecrypt = textToDecrypt.toUpperCase();

        char caracter;

        for(int i = 0; i < textToDecrypt.length(); i++){
            caracter = textToDecrypt.charAt(i);

            int pos = letters.indexOf(caracter);

            if (pos == -1){
                textDecrypted += caracter;
            }else{
                if(pos-3 < 0){
                    textDecrypted += letters.charAt(letters.length() + (pos-key) % letters.length());
                }else{
                    textDecrypted += letters.charAt((pos-key)% letters.length());
                }

            }
        }

        return textDecrypted;
    }
}
