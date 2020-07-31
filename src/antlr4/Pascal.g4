/**
* PASCAL.g4
**/
// PARSER
grammar Pascal ;

@lexer::header {
package antlr4;

}
@parser::header{
package antlr4;

import Acoes;
import Model.Token;
    
}

@parser::members {
    Acoes acoes = new Acoes(new Token);
}
programa : PROGRAM ID {acoes.A01();} ';' corpo '.' {acoes.A45();} ;
corpo : declara? rotina* {acoes.A44();} bloco {acoes.A46();} ;
bloco : BEGIN sentenca* END ;
declara : VAR dvar+ ;
dvar : variaveis ':' tipo {acoes.A02();} ';' ;
tipo : INTEGER ;
variaveis : variaveis ',' ID {acoes.A03();}
 | ID {acoes.A03();}
;
rotina : procedimento
 | funcao
 ;
procedimento : PROCEDURE ID {acoes.A04();} parametros? {acoes.A48();} ';' corpo {acoes.A56();} ';' ;
funcao : FUNCTION ID {acoes.A05();} parametros? {acoes.A48();} ':' tipo {acoes.A47();} ';' corpo {acoes.A56();} ';' ;
parametros : '(' lista_parametros+ ')' ;
lista_parametros : lista_id ':' tipo {acoes.A06();}
 | lista_id ':' tipo {acoes.A06();} ';' lista_parametros
 ;
lista_id : lista_id ',' ID {acoes.A07();}
 | ID {acoes.A07();}
 ;
var_read : var_read ',' ID {acoes.A08();}
 | ID {acoes.A08();}
;
exp_write : exp_write ',' STRING {acoes.A59();}
 | STRING {acoes.A59();}
 | exp_write ',' ID {acoes.A09();}
| ID {acoes.A09();}
;
sentenca : comando ';' ;
comando : READ '(' var_read ')'
 | WRITE '(' exp_write ')'
| WRITELN '(' exp_write ')' {acoes.A61();}
| FOR ID {acoes.A57();} ':=' expressao {acoes.A11();} TO expressao {acoes.A12();} DO bloco {acoes.A13();}
| REPEAT {acoes.A14();} sentenca UNTIL expressao_logica {acoes.A15();}
| WHILE {acoes.A16();} expressao_logica {acoes.A17();} DO bloco {acoes.A18();}
| IF expressao_logica {acoes.A19();} THEN bloco {acoes.A20();} pfalsa? {acoes.A21();}
| ID {acoes.A49();} ':=' expressao {acoes.A22();}
| ID {acoes.A50();} argumentos? {acoes.A23();}
 ;
argumentos : '(' (expressao (',' expressao)*)? ')' ;
pfalsa : ELSE {acoes.A25();} bloco ;
expressao_logica : expressao_logica OR termo_logico {acoes.A26();}
 | termo_logico
;
termo_logico : termo_logico AND fator_logico {acoes.A27();}
 | fator_logico
;
fator_logico : relacional
 | '(' expressao_logica ')'
| NOT fator_logico {acoes.A28();}
| TRUE {acoes.A29();}
| FALSE {acoes.A30();}
;
relacional : expressao '=' expressao {acoes.A31();}
 | expressao '>' expressao {acoes.A32();}
| expressao '>=' expressao {acoes.A33();}
| expressao '<' expressao {acoes.A34();}
| expressao '<=' expressao {acoes.A35();}
| expressao '<>' expressao {acoes.A36();}
;
expressao : expressao '+' termo {acoes.A37();}
 | expressao '-' termo {acoes.A38();}
| termo
;
termo : termo '*' fator {acoes.A39();}
 | termo '/' fator {acoes.A40();}
 | fator
 ;
fator : ID {acoes.A55();}
 | ID {acoes.A60();} argumentos {acoes.A42();}
| INT {acoes.A41();}
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