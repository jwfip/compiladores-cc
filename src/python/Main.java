/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package python;

import java.io.File;

/**
 *
 * @author Joao
 */
public class Main {
    
    public static void criarLexer(String path) {
        File file = new File(path);
        jflex.Main.generate(file);
    }
    
    public static void main(String[] args) {
        String path = "C:/Users/Joao/Documents/NetBeansProjects/Compiladores/src/python/scanner.lex";
        criarLexer(path);
    } 
}
