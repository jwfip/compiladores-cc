/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo_dois;

import java.io.File;

public class Main {
    public static void criarLexer(String path) {
        File file = new File(path);
        jflex.Main.generate(file);
    }
    
    public static void main(String[] args) {
        String path = "C:/Users/Joao/Documents/NetBeansProjects/Compiladores/src/exemplo_dois/scanner.lex";
        criarLexer(path);
    } 
    
}
