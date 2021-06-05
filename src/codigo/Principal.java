/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author NETO
 */
public class Principal {
    public static void main(String[] args) throws Exception {
        String ruta1 = "C://Users//NETO//Documents//NetBeansProjects//AnalizadorProyecto_Compi/src//codigo//Lexer.flex";
        String ruta2 = "C://Users//NETO//Documents//NetBeansProjects//AnalizadorProyecto_Compi/src//codigo//LexerCup.flex";
        String[] rutaS = {"-parser", "Sintax", "C://Users//NETO//Documents//NetBeansProjects//AnalizadorProyecto_Compi/src//codigo//Sintax.cup"};
        generar(ruta1, ruta2, rutaS);
    }
    
    public static void generar(String ruta1, String ruta2, String[] rutaS) throws IOException, Exception{
        File archivo;
        archivo = new File(ruta1);
        jflex.Main.generate(archivo);
        archivo = new File(ruta2);
        jflex.Main.generate(archivo);
        java_cup.Main.main(rutaS);
        
        Path rutaSym = Paths.get("C://Users//NETO//Documents//NetBeansProjects//AnalizadorProyecto_Compi/src//codigo//sym.java");
        if(Files.exists(rutaSym)){
            Files.delete(rutaSym);
        }
        
        Files.move(Paths.get("C://Users//NETO//Documents//NetBeansProjects//AnalizadorProyecto_Compi/sym.java"),
                Paths.get("C://Users//NETO//Documents//NetBeansProjects//AnalizadorProyecto_Compi/src//codigo//sym.java")
        );
        
        Path rutaSin = Paths.get("C://Users//NETO//Documents//NetBeansProjects//AnalizadorProyecto_Compi/src//codigo//Sintax.java");
        if(Files.exists(rutaSin)){
            Files.delete(rutaSin);
        }
        Files.move(Paths.get("C://Users//NETO//Documents//NetBeansProjects//AnalizadorProyecto_Compi/Sintax.java"),
                Paths.get("C://Users//NETO//Documents//NetBeansProjects//AnalizadorProyecto_Compi/src//codigo//Sintax.java")
        ); 
    }
    
    
}
