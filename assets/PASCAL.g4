/**
* PASCAL.g4
**/
// PARSER
grammar PASCAL ;
programa : PROGRAM ID {A01} ';' corpo '.' {A45} ;
corpo : declara? rotina* {A44} bloco {A46} ;
bloco : BEGIN sentenca* END ;
declara : VAR dvar+ ;
dvar : variaveis ':' tipo {A02} ';' ;
tipo : INTEGER ;
variaveis : variaveis ',' ID {A03}
 | ID {A03}
;
rotina : procedimento
 | funcao
 ;
procedimento : PROCEDURE ID {A04} parametros? {A48} ';' corpo {A56} ';' ;
funcao : FUNCTION ID {A05} parametros? {A48} ':' tipo {A47} ';' corpo {A56} ';' ;
parametros : '(' lista_parametros+ ')' ;
lista_parametros : lista_id ':' tipo {A06}
 | lista_id ':' tipo {A06} ';' lista_parametros
 ;
lista_id : lista_id ',' ID {A07}
 | ID {A07}
 ;
var_read : var_read ',' ID {A08}
 | ID {A08}
;
exp_write : exp_write ',' STRING {A59}
 | STRING {A59}
 | exp_write ',' ID {A09}
| ID {A09}
;
sentenca : comando ';' ;
comando : READ '(' var_read ')'
 | WRITE '(' exp_write ')'
| WRITELN '(' exp_write ')' {A61}
| FOR ID {A57} ':=' expressao {A11} TO expressao {A12} DO bloco {A13}
| REPEAT {A14} sentenca UNTIL expressao_logica {A15}
| WHILE {A16} expressao_logica {A17} DO bloco {A18}
| IF expressao_logica {A19} THEN bloco {A20} pfalsa? {A21}
| ID {A49} ':=' expressao {A22}
| ID {A50} argumentos? {A23}
 ;
argumentos : '(' (expressao (',' expressao)*)? ')' ;
pfalsa : ELSE {A25} bloco ;
expressao_logica : expressao_logica OR termo_logico {A26}
 | termo_logico
;
termo_logico : termo_logico AND fator_logico {A27}
 | fator_logico
;
fator_logico : relacional
 | '(' expressao_logica ')'
| NOT fator_logico {A28}
| TRUE {A29}
| FALSE {A30}
;
relacional : expressao '=' expressao {A31}
 | expressao '>' expressao {A32}
| expressao '>=' expressao {A33}
| expressao '<' expressao {A34}
| expressao '<=' expressao {A35}
| expressao '<>' expressao {A36}
;
expressao : expressao '+' termo {A37}
 | expressao '-' termo {A38}
| termo
;
termo : termo '*' fator {A39}
 | termo '/' fator {A40}
 | fator
 ;
fator : ID {A55}
 | ID {A60} argumentos {A42}
| INT {A41}
| '(' expressao ')'
 ;
// LEXER
PROGRAM : 'program' ;
BEGIN : 'begin' ;
END : 'end' ;
VAR : 'var' ;
INTEGER : 'integer' ;
PROCEDURE : 'procedure' ;
FUNCTION : 'function' ;
READ : 'read' ;
WRITE : 'write' ;
WRITELN : 'writeln' ;
FOR : 'for' ;
TO : 'to' ;
DO : 'do' ;
REPEAT : 'repeat' ;
UNTIL : 'until' ;
WHILE : 'while' ;
IF : 'if' ;
THEN : 'then' ;
ELSE : 'else' ;
NOT : 'not' ;
TRUE : 'true' ;
FALSE : 'false' ;
AND : 'and' ;
OR : 'or' ;
EQ : '=' ;
GT : '>' ;
GE : '>=' ;
LT : '<' ;
LE : '<=' ;
NE : '<>' ;
MUL : '*' ; // Operador de multiplicação
DIV : '/' ; // Operador de divisão
ADD : '+' ; // Operador de divisão
SUB : '-' ; // Operador de subtração
ID : [a-zA-Z] ([a-zA-Z] | [0-9])* ; // Identificador
INT : [0-9]+ ; // Números inteiros
STRING : '\'' .*? '\'' ; // String
WS : [ \t\r\n]+ -> skip ; // Consome brancos
COMMENT : '{' .*? '}' -> skip; // Comentários em várias linhas
LCOMMENT : '//' .*? '\r'? '\n' -> skip ; // Comentário no final de uma linha
