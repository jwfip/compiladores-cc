package exemplo_dois;
/* Exemplo do manual do JFlex */
import java_cup.runtime.*;
import exemplo_dois.Token;

/**
* Esta classe eh um exemplo simples de lexer.
*/
%%

%class Lexer
%unicode
%cup
%line
%column

%{
StringBuffer string = new StringBuffer();

private Symbol symbol (int type) {
    return new Symbol (type, yyline, yycolumn);
}

private Symbol symbol (int type, Object value) {
    return new Symbol (type, yyline, yycolumn, value);
}
%}


LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
WhiteSpace = {LineTerminator} | [ \t\f]

/* Comentarios */

Comment = {TraditionalComment} | {EndOfLineComment} | {DocumentationComment}

TraditionalComment      = "/*" [^*] ~"*/" | "/*" "*"+ "/"
EndOfLineComment        = "//" {InputCharacter}* {LineTerminator}?
DocumentationComment    = "/**" {CommentContent} "*"+ "/"
CommentContent          = ( [^*] | \*+ [^/*] )*

Identifier = [:jletter:] [:jletterdigit:]*

DecIntegerLiteral = 0 | [1-9][0-9]*

%state STRING

%%

/* Palavras-chave */
<YYINITIAL> "abstract"          { return symbol(sym.ABSTRACT); }
<YYINITIAL> "boolean"           { return symbol(sym.BOOLEAN); }
<YYINITIAL> "break"             { return symbol(sym.BREAK); }

<YYINITIAL> {
  /* Identificadores */
  {Identifier}                  { return symbol(sym.IDENTIFIER); }

  /* Literais */
  {DecIntegerLiteral}           { return symbol(sym.INTEGER_LITERAL); }
  \"                            { string.setlength(0); yybegin(STRING); }

  /* Operadores */
  "="                           { return symbol(sym.EQ); }
  "=="                          { return symbol(sym.EQEQ); }
  "+"                           { return symbol(sym.PLUS); }

  /* Comentarios */
  {Comment}                     { /* ignore */ }

  /* Espaco em branco */
  {WhiteSpace}                  { /* ignore */ }
}

<STRING> {
  \"                            { yybegin(YYINITIAL); return symbol(sym.STRING_LITERAL, string.toString()); }
  [^\n\r\"\\]+                  { string.append(yytext()); }
  \\t                           { string.append('\t'); }
  \\n                           { string.append('\n'); }

  \\r                           { string.append('\r'); }
  \\\"                          { string.append('\"'); }
  \\                            { string.append('\\'); }

}

/* Erros */
[^]                             { throw new Error("Caractere ilegal <"+ yytext()+">"); }