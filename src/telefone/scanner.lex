package telefone;
import telefone.Token.*;

%%

%class Lexer
%type Token


digito      =   [0-9]
ddi         =   ("+"55)

telefone    =   ({ddi}({digito}{2})(9)?({digito}{4})("-")?({digito}{4}))


%%

{telefone}    { return(TELEFONE); }



