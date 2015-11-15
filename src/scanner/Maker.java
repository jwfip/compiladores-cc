/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scanner;

import java.io.File;

/**
 *
 * @author Joao
 */
public class Maker {

    public static void makeLexer(String path) {
        File file = new File(path);
        jflex.Main.generate(file);
    }
    
    public static void main(String[] args) {
        String path = "C:/Users/Joao/Documents/NetBeansProjects/compiladores-cc/src/scanner/lexer.flex";
        makeLexer(path);
    } 
    
}
