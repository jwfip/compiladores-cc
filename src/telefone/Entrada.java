/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telefone;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Scanner;

/**
 *
 * @author Joao
 */
public class Entrada {
    
    public static void main(String [] args) throws FileNotFoundException {
        Reader reader = new FileReader("C:/Users/Joao/Documents/NetBeansProjects/Compiladores/src/telefone/file.txt");
        Lexer lexer = new Lexer(reader);
        System.out.println(lexer.yystate());
    }
    
}
