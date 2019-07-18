/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emuladorprocesadorz80;

//import View.Arquitectura;
//import View.Codigo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrey
 */
public class main {

    static String RutaOrigen = "C:\\Users\\Andrey\\Desktop\\Z80\\src\\Assets\\Codigo.z80";

    public static void main(String[] args) {

        //View.Codigo homeView = new View.Codigo();
        //homeView.ejem();
        
        String archSintactico="C:\\Users\\Andrey\\Desktop\\Z80\\src\\Assets\\AnalizadorSintactico.cup";
        String[] asintactico = {"-parser", "AnalizadorSintactico", archSintactico};
        try {
            java_cup.Main.main(asintactico);
        } catch (Exception ex) {
            System.out.println("ERROR A SINTACTICO");
        }
        System.out.println("Generado!");
        /*
        
        
        try {
            BufferedReader buffer = new BufferedReader(new FileReader(RutaOrigen));
            AnalizadorLexico analizadorJFlex = new AnalizadorLexico(buffer);

            while (true) {
                TokenPersonalizado token = analizadorJFlex.yylex();

                if (!analizadorJFlex.existenTokens()) {
                    break;
                }

                System.out.println(token.toString());
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
*/
    }

}
