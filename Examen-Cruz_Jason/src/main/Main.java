package main;

import Encrypter.IEncrypter;
import Gestor.Gestor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    static ApplicationContext context = new ClassPathXmlApplicationContext("file:META-INF/beans.xml");
    static BeanFactory factory = context;
    static Gestor objGestor = (Gestor) factory.getBean("Gestor");

    public static void main(String[] args) throws IOException {


        boolean noSalir;
        int opcion;

        do {
            mostrarMenu();
            opcion = leerOpcion();
            noSalir = ejecutarAccion(opcion);

        } while (noSalir);

        out.println("Gracias por usar la App");
    }

    public static void mostrarMenu() {
        out.println("1.    Encriptar");
        out.println("2.    Desencriptar");
        out.println("0.    Salir");
        out.println("");
    }


    public static int leerOpcion() throws IOException {
        int opcion;
        out.println("Seleccione su opción:\n");
        opcion = Integer.parseInt(in.readLine());
        out.println();
        return opcion;

    }// FIN LEER OPCION

    //Ejecuta la accion
    public static boolean ejecutarAccion(int opcion) throws IOException {
        boolean noSalir = true;
        boolean define;

        switch (opcion) {

            case 1:
                encrypter();
                break;

            case 2:
                decrypter();
                break;

            case 0:
                noSalir = false;
                break;
            default:
                out.println("¡OPCIÓN INVÁLIDA!" + "\n"
                        + "Por favor inténtelo nuevamente");
                out.println();
                break;
        }

        return noSalir;

    }

    public static void encrypter() throws IOException {
        out.println("Digite el texto a encriptar");
        String text = "";
        String response = "";
        text = in.readLine();
        response = objGestor.encrypt(text);
        out.println(response);
    }

    public static void decrypter() throws IOException {
        out.println("Digite el texto a desencr");
        String text = "";
        String response = "";
        text = in.readLine();
        response = objGestor.decrypt(text);
        out.println(response);
    }
}
