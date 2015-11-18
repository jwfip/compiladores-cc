package scanner;
import java_cup.runtime.Symbol;
import parser.sym;


%%

%class Lexer
%public
//%type Token // alterar para symbol
%cup
%line
%column

%{
  
  private StringBuilder str = new StringBuilder();

%}

%state STR

alpha = [a-zA-Z]
dig = [0-9]
var = {alpha} ({alpha} | {dig})*
int = {dig}+
float = {dig}+ "." {dig}* | {dig}* "." {dig}+


%%

<YYINITIAL> {
if                  { return new Symbol(parser.sym.IF); }
{var}                { return new Symbol(parser.sym.VAR, yytext()); }
{int}               { return new Symbol(parser.sym.INT, new Integer(yytext())); }
//{float}             { return new Symbol(parser.sym.FLOAT, new Double(yytext())); }
\"                  { str.setLength(0);
                      yybegin(STR);
                    }
[ \t\n\r]+          { /* do nothing */ }
<<EOF>>             { return new Symbol(parser.sym.EOF); }
}

<STR> \"            { yybegin(YYINITIAL);
                      return new Symbol(parser.sym.STR, str.toString());
                    }
<STR> \\t           { str.append('\t'); }
<STR> \\n           { str.append('\n'); }
<STR> \\\"          { str.append('"'); }
<STR> \\\\          { str.append('\\'); }
<STR> [^\n\r\\]+    { str.append(yytext()); }
<STR> <<EOF>>       { yybegin(YYINITIAL);
                      System.err.println("error: unclosed string literal");
                    }

.                   { System.err.printf("error: unexpected char |%s|\n", yytext()); }