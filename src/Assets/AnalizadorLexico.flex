/* Sección de declaraciones de JFlex */
%%
%public
%class AnalizadorLexico
%{
 
 /* Código personalizado */
 
 // Se agregó una propiedad para verificar si existen tokens pendientes
 private boolean _existenTokens = false;
 
 public boolean existenTokens(){
 return this._existenTokens;
 }
 
%}
 
 /* Al utilizar esta instrucción, se le indica a JFlex que devuelva objetos del tipo TokenPersonalizado */
%type TokenPersonalizado
 
%init{
 /* Código que se ejecutará en el constructor de la clase */
%init}
 
%eof{
 
 /* Código a ejecutar al finalizar el análisis, en este caso cambiaremos el valor de una variable bandera */
 this._existenTokens = false;
 
%eof}
 
/* Inicio de Expresiones regulares */
 
 Letra = [A-Za-z]
 Digito5 = [0-5]
 Digito6 = [6-9]

 SaltoDeLinea = \n|\r|\r\n
 
 Cedula2 = {Digito5} | {Digito6}
 Cedula = {Cedula2}{Cedula2}{Cedula2}{Cedula2}{Cedula2}+
 
 Punto = "."
 Espacio = " "

 tabulador = \t|\r|\r\t

 Alfanumerico2 = {Letra} | {Digito5} | {Digito6}
 Alfanumerico = {Letra} {Alfanumerico2}*
 
 Alfanumerico_esp1 = {Espacio}* {Alfanumerico}* {Espacio}*
 Alfanumerico_esp = {Alfanumerico_esp1}*

 Dominio2 = "com"|"net"|"edu"|"co"
 Dominio3 = {Punto} {Dominio2}
 Dominio = {Dominio3}+ 

 Correo = {Alfanumerico} {Arroba} {Alfanumerico} {Dominio}
 Digito = {Digito5} | {Digito6}
 Numero = {Digito}+

 Arroba = "@"

 Nombre_Apellido = {Letra} {Letra}*
 Nota = {Digito5} {Punto} {Digito5} | {Digito5} {Punto} {Digito6}

 NombreCompuesto = {Nombre_Apellido} {Espacio} {Nombre_Apellido} | {Nombre_Apellido} 

COMENTARIO = {SaltoDeLinea}* "#" .*? | {SaltoDeLinea}* "/*" (.*? {SaltoDeLinea}*)* "*/"
ALGORITMO = "ALGORITMO"
TERMINA = "."
ENTONCES = "entonces"
O = "||"
Y = "&&"
IGUAL = "=="
DIFERENTE = "!="
MAYOR = ">"
MENOR = "<"
MAY_IGUAL = ">="
MEN_IGUAL = "<="
SUMA = "+"
MENOS = "-"
MULT = "*"
DIV = "/"
MOD = "%"
POTENCIA = "^"
NO = "!"
DEF = "def"
RETORNAR = "retornar"
INT = "entero"
FLOAT = "decimal"
STRING = "cadena"
BOOL = "booleano"
MATRIZ = "matriz"
VECTOR = "vector"
PCOMA = ";"
ASIGNAR = "="
PAREN_AP = "("
PAREN_CI = ")"
LLAVEIZ = "{"
LLAVEDE = "}"
ANGIZ = "["
ANGDE = "]"
COMA = ","
DOSPUNTOS = ":"
VERDADERO = "verdadero"
FALSO = "falso"
NULO = "nulo"
SI = "si"
SI_NO = "si_no"
MIENTRAS = "mientras"
SELECCIONAR = "seleccionar"
CASO = "caso"
ROMPER = "romper"
HACER = "hacer"
PARA = "para"
DEFECTO = "defecto"
IDENTIFICADOR = {Alfanumerico}
ENTERO = {Numero}+
exp = "eE"
masme = "+-"
REAL = {Numero}* '.' {Digito}* | {Numero}* '.' {Digito}* {exp} {masme}? {Digito}+
i = "i"
COMPLEJO = {ENTERO} {SUMA} {ENTERO} {i} | {ENTERO} {SUMA} {REAL} {i} | {REAL} {SUMA} {REAL} {i} | {REAL} {SUMA} {ENTERO} {i} | {ENTERO} {MENOS} {ENTERO} {i} | {ENTERO} {MENOS} {REAL} {i} | {REAL} {MENOS} {REAL} {i} | {REAL} {MENOS} {ENTERO} {i} 
ESPACIO = " "
COMILLAS_D = \"
//CADENA = {COMILLAS_D} .*? {COMILLAS_D};
CADENA = \"([^\\\"]|\\.)*\"
//OTRO = .



 //Expresiones regulares para tokens
 
/* Finaliza expresiones regulares */
 
%%
/* Finaliza la sección de declaraciones de JFlex */
 
/* Inicia sección de reglas */
 
// Cada regla está formada por una {expresión} espacio {código}

{COMENTARIO} {
	TokenPersonalizado t = new TokenPersonalizado(yytext(), "COMENTARIO");
	this._existenTokens = true;
 	return t;
}
{ALGORITMO} {
	TokenPersonalizado t = new TokenPersonalizado(yytext(), "ALGORITMO");
	this._existenTokens = true;
 	return t;
}
{TERMINA} {
	TokenPersonalizado t = new TokenPersonalizado(yytext(), "TERMINA");
	this._existenTokens = true;
 	return t;
}
{ENTONCES} {
	TokenPersonalizado t = new TokenPersonalizado(yytext(), "ENTONCES");
	this._existenTokens = true;
 	return t;
}
{O} {
	TokenPersonalizado t = new TokenPersonalizado(yytext(), "O");
	this._existenTokens = true;
 	return t;
}
{Y} {
	TokenPersonalizado t = new TokenPersonalizado(yytext(), "Y");
	this._existenTokens = true;
 	return t;
}
{IGUAL} {
	TokenPersonalizado t = new TokenPersonalizado(yytext(), "IGUAL");
	this._existenTokens = true;
 	return t;
}
{DIFERENTE} {
	TokenPersonalizado t = new TokenPersonalizado(yytext(), "DIFERENTE");
	this._existenTokens = true;
 	return t;
}
{MAYOR} {
	TokenPersonalizado t = new TokenPersonalizado(yytext(), "MAYOR");
	this._existenTokens = true;
 	return t;
}
{MENOR} {
	TokenPersonalizado t = new TokenPersonalizado(yytext(), "MENOR");
	this._existenTokens = true;
 	return t;
}
{MAY_IGUAL} {
	TokenPersonalizado t = new TokenPersonalizado(yytext(), "MAY_IGUAL");
	this._existenTokens = true;
 	return t;
}
{MEN_IGUAL} {
	TokenPersonalizado t = new TokenPersonalizado(yytext(), "MEN_IGUAL");
	this._existenTokens = true;
 	return t;
}
{SUMA} {
	TokenPersonalizado t = new TokenPersonalizado(yytext(), "SUMA");
	this._existenTokens = true;
 	return t;
}
{MENOS} {
	TokenPersonalizado t = new TokenPersonalizado(yytext(), "MENOS");
	this._existenTokens = true;
 	return t;
}
{MULT} {
	TokenPersonalizado t = new TokenPersonalizado(yytext(), "MULT");
	this._existenTokens = true;
 	return t;
}
{DIV} {
	TokenPersonalizado t = new TokenPersonalizado(yytext(), "DIV");
	this._existenTokens = true;
 	return t;
}
{MOD} {
	TokenPersonalizado t = new TokenPersonalizado(yytext(), "MOD");
	this._existenTokens = true;
 	return t;
}
{POTENCIA} {
	TokenPersonalizado t = new TokenPersonalizado(yytext(), "POTENCIA");
	this._existenTokens = true;
 	return t;
}
{NO} {
	TokenPersonalizado t = new TokenPersonalizado(yytext(), "NO");
	this._existenTokens = true;
 	return t;
}
{DEF} {
	TokenPersonalizado t = new TokenPersonalizado(yytext(), "DEF");
	this._existenTokens = true;
 	return t;
}
{RETORNAR} {
	TokenPersonalizado t = new TokenPersonalizado(yytext(), "RETORNAR");
	this._existenTokens = true;
 	return t;
}
{INT} {
	TokenPersonalizado t = new TokenPersonalizado(yytext(), "INT");
	this._existenTokens = true;
 	return t;
}
{FLOAT} {
	TokenPersonalizado t = new TokenPersonalizado(yytext(), "FLOAT");
	this._existenTokens = true;
 	return t;
}
{STRING} {
	TokenPersonalizado t = new TokenPersonalizado(yytext(), "STRING");
	this._existenTokens = true;
 	return t;
}
{BOOL} {
	TokenPersonalizado t = new TokenPersonalizado(yytext(), "BOOL");
	this._existenTokens = true;
 	return t;
}
{MATRIZ} {
	TokenPersonalizado t = new TokenPersonalizado(yytext(), "MATRIZ");
	this._existenTokens = true;
 	return t;
}
{VECTOR} {
	TokenPersonalizado t = new TokenPersonalizado(yytext(), "VECTOR");
	this._existenTokens = true;
 	return t;
}
{PCOMA} {
	TokenPersonalizado t = new TokenPersonalizado(yytext(), "PCOMA");
	this._existenTokens = true;
 	return t;
}
{ASIGNAR} {
	TokenPersonalizado t = new TokenPersonalizado(yytext(), "ASIGNAR");
	this._existenTokens = true;
 	return t;
}
{PAREN_AP} {
	TokenPersonalizado t = new TokenPersonalizado(yytext(), "PAREN_AP");
	this._existenTokens = true;
 	return t;
}
{PAREN_CI} {
	TokenPersonalizado t = new TokenPersonalizado(yytext(), "PAREN_CI");
	this._existenTokens = true;
 	return t;
}
{LLAVEIZ} {
	TokenPersonalizado t = new TokenPersonalizado(yytext(), "LLAVEIZ");
	this._existenTokens = true;
 	return t;
}
{LLAVEDE} {
	TokenPersonalizado t = new TokenPersonalizado(yytext(), "LLAVEDE");
	this._existenTokens = true;
 	return t;
}
{ANGIZ} {
	TokenPersonalizado t = new TokenPersonalizado(yytext(), "ANGIZ");
	this._existenTokens = true;
 	return t;
}
{ANGDE} {
	TokenPersonalizado t = new TokenPersonalizado(yytext(), "ANGDE");
	this._existenTokens = true;
 	return t;
}
{COMA} {
	TokenPersonalizado t = new TokenPersonalizado(yytext(), "COMA");
	this._existenTokens = true;
 	return t;
}
{DOSPUNTOS} {
	TokenPersonalizado t = new TokenPersonalizado(yytext(), "DOSPUNTOS");
	this._existenTokens = true;
 	return t;
}
{VERDADERO} {
	TokenPersonalizado t = new TokenPersonalizado(yytext(), "VERDADERO");
	this._existenTokens = true;
 	return t;
}
{FALSO} {
	TokenPersonalizado t = new TokenPersonalizado(yytext(), "FALSO");
	this._existenTokens = true;
 	return t;
}
{NULO} {
	TokenPersonalizado t = new TokenPersonalizado(yytext(), "NULO");
	this._existenTokens = true;
 	return t;
}
{SI} {
	TokenPersonalizado t = new TokenPersonalizado(yytext(), "SI");
	this._existenTokens = true;
 	return t;
}

{SI_NO} {
	TokenPersonalizado t = new TokenPersonalizado(yytext(), "SI_NO");
	this._existenTokens = true;
 	return t;
}
{MIENTRAS} {
	TokenPersonalizado t = new TokenPersonalizado(yytext(), "MIENTRAS");
	this._existenTokens = true;
 	return t;
}
{SELECCIONAR} {
	TokenPersonalizado t = new TokenPersonalizado(yytext(), "SELECCIONAR");
	this._existenTokens = true;
 	return t;
}
{CASO} {
	TokenPersonalizado t = new TokenPersonalizado(yytext(), "CASO");
	this._existenTokens = true;
 	return t;
}
{ROMPER} {
	TokenPersonalizado t = new TokenPersonalizado(yytext(), "ROMPER");
	this._existenTokens = true;
 	return t;
}
{HACER} {
	TokenPersonalizado t = new TokenPersonalizado(yytext(), "HACER");
	this._existenTokens = true;
 	return t;
}
{PARA} {
	TokenPersonalizado t = new TokenPersonalizado(yytext(), "PARA");
	this._existenTokens = true;
 	return t;
}
{DEFECTO} {
	TokenPersonalizado t = new TokenPersonalizado(yytext(), "DEFECTO");
	this._existenTokens = true;
 	return t;
}
{IDENTIFICADOR} {
	TokenPersonalizado t = new TokenPersonalizado(yytext(), "IDENTIFICADOR");
	this._existenTokens = true;
 	return t;
}
{ENTERO} {
	TokenPersonalizado t = new TokenPersonalizado(yytext(), "ENTERO");
	this._existenTokens = true;
 	return t;
}
{exp} {
	TokenPersonalizado t = new TokenPersonalizado(yytext(), "exp");
	this._existenTokens = true;
 	return t;
}
{masme} {
	TokenPersonalizado t = new TokenPersonalizado(yytext(), "masme");
	this._existenTokens = true;
 	return t;
}
{REAL} {
	TokenPersonalizado t = new TokenPersonalizado(yytext(), "REAL");
	this._existenTokens = true;
 	return t;
}
{i} {
	TokenPersonalizado t = new TokenPersonalizado(yytext(), "i");
	this._existenTokens = true;
 	return t;
}
{COMPLEJO} {
	TokenPersonalizado t = new TokenPersonalizado(yytext(), "COMPLEJO");
	this._existenTokens = true;
 	return t;
}

/*{OTRO} {
	TokenPersonalizado t = new TokenPersonalizado(yytext(), "OTRO");
	this._existenTokens = true;
 	return t;
}*/
{ESPACIO} {
	//IGNORAR
}

{SaltoDeLinea} {
 TokenPersonalizado t = new TokenPersonalizado("Enter", "NUEVA_LINEA");
 this._existenTokens = true;
 return t;
}
{CADENA} {
	TokenPersonalizado t = new TokenPersonalizado(yytext(), "CADENA");
	this._existenTokens = true;
 	return t;
}
{tabulador} {
TokenPersonalizado t = new TokenPersonalizado(yytext(), "NUEVA_LINEA");
 this._existenTokens = true;
 return t;
}
