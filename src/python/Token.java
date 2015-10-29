/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package python;

import java.util.Formatter;

/**
 *
 * @author Joao
 */
public class Token {
    // BOOL, COND, REPT, OPRD, ID, EXCP;
    
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
