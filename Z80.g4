
/* ------------------- Seccion de la gramatica ------------------------ */
   
/* La gramatica de nuestro analizador.*/
   
    //Símbolo inicial
    algoritmo : ALGORITMO IDENTIFICADOR (PAREN_AP lista_ids PAREN_CI)? DOSPUNTOS bloque TERMINA;


    //Lista de identificadores
    lista_ids : IDENTIFICADOR (COMA lista_ids)?;

    //Ecuaciones
    ecuaciones : variable op_comp expresion_mat | expresion_log | variable op_comp variable; 

    //Expresiones matematicas
    expresion_mat : PAREN_AP expresion_mat PAREN_CI | expresion_mat op_arit expresion_mat
                    | PAREN_AP MENOS PAREN_AP expresion_mat PAREN_CI PAREN_CI | ENTERO | REAL;

    //Expresiones logicas
    expresion_log : PAREN_AP expresion_log PAREN_CI | expresion_log op_log expresion_log
                    | PAREN_AP NO PAREN_AP expresion_log PAREN_CI PAREN_CI | IDENTIFICADOR;

    //Definición de variable
    variable : IDENTIFICADOR (conjunto)?;

    //Operadores de comparación
    op_comp : IGUAL | DIFERENTE | MAYOR | MENOR | MAY_IGUAL | MEN_IGUAL;

    //Operadores aritmeticos
    op_arit : SUMA | MENOS | MULT | DIV | MOD | POTENCIA;

    //Operadores logicos
    op_log : O | Y;

    //Definición de conjunto
    conjunto : LLAVEIZ params LLAVEDE;

    //Parametros
    params : param (COMA params)?;

    //Parametro
    param : expresion_mat | expresion_log;
    
    //Lista de parámetros
    lista_parsv : PAREN_AP params PAREN_CI;
    
    //Identificador de tipo de retorno
    tipo : INT | FLOAT | STRING | BOOL | MATRIZ | VECTOR;

    //Bloque
    bloque : LLAVEIZ LLAVEDE | LLAVEIZ sec_proposiciones LLAVEDE;

    
    //Conjunto de posibles sentencias
    proposicion : RETORNAR expresion_mat PCOMA | RETORNAR expresion_log PCOMA | fun_senten | proc_senten | si_senten
                | seleccionar_senten | mientras_senten | para_senten | hacer_mientras_senten | asignacion PCOMA
                | IDENTIFICADOR lista_parsv PCOMA | LLAVEIZ sec_proposiciones LLAVEDE | OTRO;

    //Modo de asignación
    asignacion : IDENTIFICADOR ASIGNAR expresion_mat | IDENTIFICADOR ASIGNAR expresion_log
                | IDENTIFICADOR ASIGNAR conjunto;

    //Expresión a evaluar y bloque de sentencias a ejecutar
    bloque_condicional : ecuaciones ENTONCES bloque;

    //Seleccion si no si
    si_no_si_senten : SI_NO SI bloque_condicional (si_no_senten)?;
    
    //Selección IF
    si_senten : SI bloque_condicional (si_no_si_senten)?;
    
    
    //Iteración WHILE
    mientras_senten : MIENTRAS bloque_condicional;

    //Iteración DO WHILE
    hacer_mientras_senten : HACER bloque MIENTRAS ecuaciones;

    //Selección SWITCH
    seleccionar_senten : SELECCIONAR IDENTIFICADOR LLAVEIZ casos LLAVEDE;

    //Bloque de casos del SWITCH
    casos : CASO ecuaciones DOSPUNTOS sec_proposiciones (ROMPER PCOMA)? casos | DEFECTO DOSPUNTOS sec_proposiciones;

    //Coma y asignación
    com_asig : COMA asignacion (com_asig)?;

    //Iteración FOR
    para_senten : PARA asignacion (com_asig)? PCOMA ecuaciones PCOMA asignacion (com_asig)? bloque
                | PARA PAREN_AP asignacion (com_asig)? PCOMA ecuaciones PCOMA asignacion (com_asig)?;

    //Función
    fun_senten : DEF tipo IDENTIFICADOR PAREN_AP lista_ids PAREN_CI bloque;

    //Procedimiento
    proc_senten : DEF IDENTIFICADOR PAREN_AP lista_ids PAREN_CI bloque;

    //Sentencias de función
    funcion : LLAVEIZ sec_proposiciones PCOMA LLAVEDE;

    //Secuenciación
    sec_proposiciones : proposicion (sec_proposiciones)?;

    //Expresiones regulares para tokens
    COMENTARIO : ('#' ~[\r\n]*  | '/*' .*? '*/') -> skip;
    ALGORITMO : 'ALGORITMO';
    TERMINA : '.';
    ENTONCES : 'entonces';
    O : '||';
    Y : '&&';
    IGUAL : '==';
    DIFERENTE : '!=';
    MAYOR : '>';
    MENOR : '<';
    MAY_IGUAL : '>=';
    MEN_IGUAL : '<=';
    SUMA : '+';
    MENOS : '-';
    MULT : '*';
    DIV : '/';
    MOD : '%';
    POTENCIA : '^';
    NO : '!';
    DEF : 'def';
    RETORNAR : 'retornar';
    INT : 'entero';
    FLOAT : 'decimal';
    STRING : 'cadena';
    BOOL : 'booleano';
    MATRIZ : 'matriz';
    VECTOR : 'vector';
    PCOMA : ';';
    ASIGNAR : '=';
    PAREN_AP : '(';
    PAREN_CI : ')';
    LLAVEIZ : '{';
    LLAVEDE : '}';
    ANGIZ : '[';
    ANGDE : ']';
    COMA : ',';
    DOSPUNTOS : ':';
    VERDADERO : 'verdadero';
    FALSO : 'falso';
    NULO : 'nulo';
    SI : 'si';
    SI_eje 'si_no';
    MIENTRAS : 'mientras';
    SELECCIONAR : 'seleccionar';
    CASO: 'caso';
    ROMPER: 'romper';
    HACER: 'hacer';
    PARA : 'para';
    DEFECTO : 'defecto';
    IDENTIFICADOR : [a-zA-Z_] [a-zA-Z_0-9]*;
    ENTERO : [0-9]+;
    REAL : [0-9]* '.' [0-9]* ([eE] [+-]? [0-9]+)?;
    COMPLEJO : (ENTERO|REAL) [+|-] (ENTERO|REAL)? 'i';
    CADENA : '"' (~["\r\n] | '""')* '"';
    ESPACIO : [ \t\r\n] -> skip;
    OTRO : .;