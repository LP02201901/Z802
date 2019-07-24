grammar comp;

@parser::header{
    import java.util.Map;
    import java.util.HashMap;
}

@parser::members{
    Map<String, Object> symbolTable = new HashMap<String,Object>();
    String assembler = "";
    String subf = "1";
    int dirvar=32768;
    int ifcount = 1;
    int whilecount = 1;
}
program: PROGRAMA ID LLAVE_ABRE sentencia* LLAVE_CIERRA;

sentencia: var_decl|vec_decl|var_asign_n|var_asign_v|suma|resta|multiplicacion|division|ifelse|ciclofor|ciclowhile;

expresion returns [String value]: NUMERO{$value = $NUMERO.text;} | ID  { $value = "(" + $ID.text + subf + ")" ;};

ciclofor: FOR PAR_ABRE expresion
            {
                String temp1 = $expresion.value;
                assembler += "\n loop_init:";
                assembler += "\n LD H, "+temp1;
            }
            SEMICOLON expresion
            {
                assembler += "\n loop_cond:";
                String temp2 = $expresion.value;
                assembler += "\n LD A, "+temp2;
                assembler += "\n CP H";
                assembler += "\n JP Z, loop_end";
            }
            SEMICOLON  expresion
            {
                String temp3 = $expresion.value;
            }
            PAR_CIERRA LLAVE_ABRE
            {
                assembler += "\n loop_body:";
            }
            sentencia*
            {
               assembler += "\n loop_next:";
               assembler += "\n INC H";
               assembler += "\n JP loop_cond";
            }
            LLAVE_CIERRA
            {
               assembler += "\n loop_end:";
            };



ifelse: IF  {
                int actual = ifcount;
                ifcount = ifcount+1;
                assembler += "\n If"+actual+":";
            }
            PAR_ABRE sentbooleana[actual] PAR_CIERRA
            {
                assembler += "\n Then"+actual+":";
            }
            LLAVE_ABRE
            sentencia*
            LLAVE_CIERRA
            {
                assembler += "\n jp Endif"+actual;
            }
            ELSE
            {
                assembler += "\n Else"+actual+":";
            }
            LLAVE_ABRE
            sentencia*
            LLAVE_CIERRA
            {
                assembler += "\n Endif"+actual+":";
            }
            ;

sentbooleana [int actual]:
                expresion {String temp1 = $expresion.value;} MAYORQ expresion {String temp2 = $expresion.value;}
              {
                assembler += "\n LD A,"+temp1;
                assembler += "\n LD B,A";
                assembler += "\n LD A,"+temp2;
                assembler += "\n SUB B";
                assembler += "\n JP NC, Else"+actual;
              }|
                expresion {String temp1 = $expresion.value;} MENORQ expresion {String temp2 = $expresion.value;}
              {
                assembler += "\n LD A,"+temp2;
                assembler += "\n LD B,A";
                assembler += "\n LD A,"+temp1;
                assembler += "\n SUB B";
                assembler += "\n JP NC, Else"+actual;
              }|
                expresion {String temp1 = $expresion.value;} MENORI expresion {String temp2 = $expresion.value;}
              {
                assembler += "\n LD A,"+temp1;
                assembler += "\n LD B,A";
                assembler += "\n LD A,"+temp2;
                assembler += "\n SUB B";
                assembler += "\n JP C, Else"+actual;
              }|
                expresion {String temp1 = $expresion.value;} MAYORI expresion {String temp2 = $expresion.value;}
              {
                assembler += "\n LD A,"+temp2;
                assembler += "\n LD B,A";
                assembler += "\n LD A,"+temp1;
                assembler += "\n SUB B";
                assembler += "\n JP C, Else"+actual;
              }|
                expresion {String temp1 = $expresion.value;} EQUIVA expresion {String temp2 = $expresion.value;}
              {
                assembler += "\n LD A,"+temp2;
                assembler += "\n LD B,A";
                assembler += "\n LD A,"+temp1;
                assembler += "\n SUB B";
                assembler += "\n JP NZ, Else"+actual;
              }|
                expresion {String temp1 = $expresion.value;} NOEQUIVA expresion {String temp2 = $expresion.value;}
              {
                assembler += "\n LD A,"+temp2;
                assembler += "\n LD B,A";
                assembler += "\n LD A,"+temp1;
                assembler += "\n SUB B";
                assembler += "\n JP Z, Else"+actual;
              }
              ;
sentboolenanawhile [int actual]:
                expresion {String temp1 = $expresion.value;} MAYORQ expresion {String temp2 = $expresion.value;}
              {
                assembler += "\n LD A,"+temp1;
                assembler += "\n LD B,A";
                assembler += "\n LD A,"+temp2;
                assembler += "\n SUB B";
                assembler += "\n JP NC, EndWhile"+actual;
              }|
                expresion {String temp1 = $expresion.value;} MENORQ expresion {String temp2 = $expresion.value;}
              {
                assembler += "\n LD A,"+temp2;
                assembler += "\n LD B,A";
                assembler += "\n LD A,"+temp1;
                assembler += "\n SUB B";
                assembler += "\n JP NC, EndWhile"+actual;
              }|
                expresion {String temp1 = $expresion.value;} MENORI expresion {String temp2 = $expresion.value;}
              {
                assembler += "\n LD A,"+temp1;
                assembler += "\n LD B,A";
                assembler += "\n LD A,"+temp2;
                assembler += "\n SUB B";
                assembler += "\n JP C, EndWhile"+actual;
              }|
                expresion {String temp1 = $expresion.value;} MAYORI expresion {String temp2 = $expresion.value;}
              {
                assembler += "\n LD A,"+temp2;
                assembler += "\n LD B,A";
                assembler += "\n LD A,"+temp1;
                assembler += "\n SUB B";
                assembler += "\n JP C, EndWhile"+actual;
              }|
                expresion {String temp1 = $expresion.value;} EQUIVA expresion {String temp2 = $expresion.value;}
              {
                assembler += "\n LD A,"+temp2;
                assembler += "\n LD B,A";
                assembler += "\n LD A,"+temp1;
                assembler += "\n SUB B";
                assembler += "\n JP NZ, EndWhile"+actual;
              }|
                expresion {String temp1 = $expresion.value;} NOEQUIVA expresion {String temp2 = $expresion.value;}
              {
                assembler += "\n LD A,"+temp2;
                assembler += "\n LD B,A";
                assembler += "\n LD A,"+temp1;
                assembler += "\n SUB B";
                assembler += "\n JP Z, EndWhile"+actual;
              }
              ;
ciclowhile: WHILE
            {
                int actual = whilecount;
                whilecount = whilecount+1;
                assembler += "\n While"+actual+":";
            }
            PAR_ABRE sentboolenanawhile[actual] PAR_CIERRA
            LLAVE_ABRE sentencia* LLAVE_CIERRA
            {
                assembler += "\n JP While"+actual;
                assembler += "\n EndWhile"+actual+":";
            };
var_decl: VAR ID SEMICOLON
        {
            String varname = $ID.text + subf;
            symbolTable.put(varname,dirvar);
            assembler += "\n ;declaracion de variable ";
            assembler += "\n "+varname+": equ "+ dirvar;
            dirvar = dirvar + 2;
        };

vec_decl: VEC ID NUMERO SEMICOLON
        {
            int tamano = Integer.parseInt($NUMERO.text);
            assembler += "\n ;declaracion de vector ";
            for(int i = 1; i<=tamano ; i++){
                String varname = $ID.text + "_" + i + subf;
                symbolTable.put(varname,dirvar);
                assembler += "\n "+varname+": equ "+ dirvar;
                dirvar = dirvar + 2;
            }
        };

var_asign_n: ID ASIGNAR NUMERO SEMICOLON
        {
            String varname = $ID.text + subf;
            assembler += "\n ;asignar valor a variable";
            assembler += "\n LD " + "A" + "," + $NUMERO.text;
            assembler += "\n LD " + "(" + varname+ ")" + ",A";
        };

var_asign_v: ID{String temp1 = $ID.text + subf;} ASIGNAR ID{String temp2 = $ID.text + subf;}  SEMICOLON
        {
            assembler += "\n ;asignar variable a otra variable";
            assembler += "\n LD " + "A" + "," +"("+ temp2 + ")";
            assembler += "\n LD " + "(" + temp1 + ")" + ",A";
        };

suma: ID ASIGNAR PAR_ABRE expresion {String temp1 = $expresion.value;} SUMA expresion{ String temp2 = $expresion.value;} PAR_CIERRA SEMICOLON
        {
            assembler += "\n ;sumar "+temp1+"+"+temp2;
            assembler += "\n LD A," + temp2;
            assembler += "\n LD B,A";
            assembler += "\n LD A," + temp1;
            assembler += "\n ADD A,B";
            assembler += "\n LD " + "(" + $ID.text + subf + ")" + ",A";
        };

resta: ID ASIGNAR PAR_ABRE expresion {String temp1 = $expresion.value;} RESTA expresion{ String temp2 = $expresion.value;} PAR_CIERRA SEMICOLON
        {
            assembler += "\n ;restar "+temp1+"-"+temp2;
            assembler += "\n LD A," + temp2;
            assembler += "\n LD B,A";
            assembler += "\n LD A," + temp1;
            assembler += "\n SUB B";
            assembler += "\n LD " + "(" + $ID.text + subf + ")" + ",A";
        };

multiplicacion: ID ASIGNAR PAR_ABRE  expresion {String temp1 = $expresion.value;} MULT expresion{ String temp2 = $expresion.value;} PAR_CIERRA SEMICOLON
        {
            assembler += "\n ;multiplicar "+temp1+"*"+temp2;
            assembler += "\n LD A," + temp2;
            assembler += "\n LD C,A";
            assembler += "\n LD A," + temp1;
            assembler += "\n LD B,A";
            assembler += "\n LD A,0";
            assembler += "\n ADD A,C";
            assembler += "\n DJNZ $-1";
            assembler += "\n LD " + "(" + $ID.text + subf + ")" + ",A";
        };

division: ID ASIGNAR PAR_ABRE  expresion {String temp1 = $expresion.value;} DIVI expresion{ String temp2 = $expresion.value;} PAR_CIERRA SEMICOLON
        {
            assembler += "\n ;dividir "+temp1+"/"+temp2;
            assembler += "\n LD A," + temp1;
            assembler += "\n LD C,A";
            assembler += "\n LD A," + temp2;
            assembler += "\n LD D,A";
            assembler += "\n LD B,8";
            assembler += "\n XOR A";
            assembler += "\n SLA C";
            assembler += "\n RLA";
            assembler += "\n CP D";
            assembler += "\n JR C,$+4";
            assembler += "\n INC C";
            assembler += "\n SUB D";
            assembler += "\n DJNZ $-8";
            assembler += "\n LD E,A";
            assembler += "\n LD A,C";
            assembler += "\n LD " + "(" + $ID.text + subf + ")" + ",A";
        };


PROGRAMA: 'programa';
VAR: 'var';
VEC: 'vec';
SUMA: '+';
RESTA: '-';
MULT: '*';
DIVI: '/';
AND: '&&';
OR: '||';
NOT: '!';

IF: 'if';
ELSE: 'else';
FOR: 'for';
WHILE: 'while';

MAYORI: '>=';
MAYORQ: '>';
MENORI: '<=';
MENORQ: '<';
EQUIVA: '==';
NOEQUIVA: '!=';

ASIGNAR:'=';
LLAVE_ABRE: '{';
LLAVE_CIERRA: '}';

PAR_ABRE: '(';
PAR_CIERRA: ')';

SEMICOLON: ';';

ID: [a-zA-Z_][a-zA-Z0-9_]*;
NUMERO: [0-9]+;

ESPACIOS: [ \t\n\r]+ -> skip;