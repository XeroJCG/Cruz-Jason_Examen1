package Gestor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Encrypter.IEncrypter;

public class Gestor {
    private IEncrypter encrypter;


    @Autowired
    public void setEncrypter(IEncrypter encrypter){
        this.encrypter = encrypter;
    }

    public String encrypt(String text){
        return encrypter.encrypt(text);
    }

    public String decrypt(String text){
        return encrypter.decrypt(text);
    }
}
