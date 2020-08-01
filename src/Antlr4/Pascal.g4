/**
* PASCAL.g4
**/
// PARSER
grammar Pascal ;

@lexer::header {
package Antlr4;
}
@parser::header {
package Antlr4;
import Acoes.Acoes;

import java.lang.reflect.InvocationTargetException;
}


@parser::members {
Acoes acoes = new Acoes();
public Acoes getAcoes() {
    return acoes;
}

public static void call(Object object, String acao) {
    try {
        object.getClass().getDeclaredMethod(acao).invoke(object);
    } catch (NoSuchMethodException e) {
    } catch (IllegalAccessException e) {
    } catch (IllegalArgumentException e) {
    } catch (InvocationTargetException e) {;
    }
}
}
programa : PROGRAM ID {call(acoes, "A01");} ';' corpo '.' {call(acoes, "A45");} ;
corpo : declara? rotina* {call(acoes, "A44");} bloco {call(acoes, "A46");} ;
bloco : BEGIN sentenca* END ;
declara : VAR dvar+ ;
dvar : variaveis ':' tipo {call(acoes, "A02");} ';' ;
tipo : INTEGER ;
variaveis : variaveis ',' ID {call(acoes, "A03");}
 | ID {call(acoes, "A03");}
;
rotina : procedimento
 | funcao
 ;
procedimento : PROCEDURE ID {call(acoes, "A04");} parametros? {call(acoes, "A48");} ';' corpo {call(acoes, "A56");} ';' ;
funcao : FUNCTION ID {call(acoes, "A05");} parametros? {call(acoes, "A48");} ':' tipo {call(acoes, "A47");} ';' corpo {call(acoes, "A56");} ';' ;
parametros : '(' lista_parametros+ ')' ;
lista_parametros : lista_id ':' tipo {call(acoes, "A06");}
 | lista_id ':' tipo {call(acoes, "A06");} ';' lista_parametros
 ;
lista_id : lista_id ',' ID {call(acoes, "A07");}
 | ID {call(acoes, "A07");}
 ;
var_read : var_read ',' ID {call(acoes, "A08");}
 | ID {call(acoes, "A08");}
;
exp_write : exp_write ',' STRING {call(acoes, "A59");}
 | STRING {call(acoes, "A59");}
 | exp_write ',' ID {call(acoes, "A09");}
| ID {call(acoes, "A09");}
;
sentenca : comando ';' ;
comando : READ '(' var_read ')'
 | WRITE '(' exp_write ')'
| WRITELN '(' exp_write ')' {call(acoes, "A61");}
| FOR ID {call(acoes, "A57");} ':=' expressao {call(acoes, "A11");} TO expressao {call(acoes, "A12");} DO bloco {call(acoes, "A13");}
| REPEAT {call(acoes, "A14");} sentenca UNTIL expressao_logica {call(acoes, "A15");}
| WHILE {call(acoes, "A16");} expressao_logica {call(acoes, "A17");} DO bloco {call(acoes, "A18");}
| IF expressao_logica {call(acoes, "A19");} THEN bloco {call(acoes, "A20");} pfalsa? {call(acoes, "A21");}
| ID {call(acoes, "A49");} ':=' expressao {call(acoes, "A22");}
| ID {call(acoes, "A50");} argumentos? {call(acoes, "A23");}
 ;
argumentos : '(' (expressao (',' expressao)*)? ')' ;
pfalsa : ELSE {call(acoes, "A25");} bloco ;
expressao_logica : expressao_logica OR termo_logico {call(acoes, "A26");}
 | termo_logico
;
termo_logico : termo_logico AND fator_logico {call(acoes, "A27");}
 | fator_logico
;
fator_logico : relacional
 | '(' expressao_logica ')'
| NOT fator_logico {call(acoes, "A28");}
| TRUE {call(acoes, "A29");}
| FALSE {call(acoes, "A30");}
;
relacional : expressao '=' expressao {call(acoes, "A31");}
 | expressao '>' expressao {call(acoes, "A32");}
| expressao '>=' expressao {call(acoes, "A33");}
| expressao '<' expressao {call(acoes, "A34");}
| expressao '<=' expressao {call(acoes, "A35");}
| expressao '<>' expressao {call(acoes, "A36");}
;
expressao : expressao '+' termo {call(acoes, "A37");}
 | expressao '-' termo {call(acoes, "A38");}
| termo
;
termo : termo '*' fator {call(acoes, "A39");}
 | termo '/' fator {call(acoes, "A40");}
 | fator
 ;
fator : ID {call(acoes, "A55");}
 | ID {call(acoes, "A60");} argumentos {call(acoes, "A42");}
| INT {call(acoes, "A41");}
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