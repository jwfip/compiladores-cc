/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scanner;

import java.util.Formatter;

/**
 *
 * @author Joao
 */
public class Token {
    // BOOL, COND, REPT, OPRD, ID, EXCP;
    
    /*
    public enum T {
        
        int { public String toString() { return "tipo da variável -inteiro-"; } },
        float { public String toString() { return "tipo da variável -flutuante-"; } },
        string { public String toString() { return "tipo da variável -string-"; } },
        True { public String toString() { return "booleano"; } },
        False { public String toString() { return "booleano"; } },
        and { public String toString() { return "e"; } },
        assert { public String toString() { return "forçar um tipo para a variável"; } },
        break { public String toString() { return "parar"; } },
        class { public String toString() { return "definição da classe"; } },
        continue { public String toString() { return "continuar"; } },
        def { public String toString() { return "definição de função"; } },
        del { public String toString() { return "exclusão de objeto"; } },
        elif { public String toString() { return "não-se"; } },
        else { public String toString() { return "senão"; } },
        except { public String toString() { return "exceção"; } },
        exec { public String toString() { return "executar função"; } },
        finally { public String toString() { return "finalizar função"; } },
        for { public String toString() { return "definição de laço -para-"; } },
        from { public String toString() { return "importar uma variável dentro de um módulo"; } },
        global { public String toString() { return "definição de variável global"; } },
        if { public String toString() { return "definição de laço -se-"; } },
        in { public String toString() { return "em"; } },
        is { public String toString() { return "e"; } },
        lambda { public String toString() { return "funções recursivas"; } },
        not { public String toString() { return "não"; } },
        or { public String toString() { return "ou"; } },
        pass { public String toString() { return "passar para outra função sem executá-la"; } }, 
        print { public String toString() { return "imprimir na tela"; } },
        raise { public String toString() { return "laço -try-"; } },
        return { public String toString() { return "retornar objeto"; } },
        try { public String toString() { return "definição de laço -tente-"; } },
        while { public String toString() { return "definição de laço enquanto"; } },
        EOF { public String toString() { return "EOF"; } }
    }
    */
    
    public enum T {
        IF { public String toString() { return "IF"; } },
        ID { public String toString() { return "ID"; } },
        INT { public String toString() { return "INT"; } },
        FLOAT { public String toString() { return "FLOAT"; } },
        STR { public String toString() { return "STR"; } },
        EOF { public String toString() { return "EOF"; } }
    }
    
    public T type;
    public Object val;
    public int line;
    public int col;
    
    public Token (T type, int line, int col) {
        this.type = type;
        this.line = line;
        this.col = col;
    }
    
    public Token(T type, Object val, int line, int col) {
        this.type = type;
        this.val = val;
        this.line = line;
        this.col = col;
    }
    
    public String toString() {
        Formatter out = new Formatter();
        out.format("(%4d,%4d) %s", line, col, type);
        if (val != null) {
            out.format(" [%s]", val);
        }
        return out.toString();
    }
}
