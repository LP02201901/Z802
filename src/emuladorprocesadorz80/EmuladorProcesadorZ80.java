package emuladorprocesadorz80;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

public class EmuladorProcesadorZ80 {
    // Registros de propisito general de 8 bits
    public static char [] regB = new char[8], regC = new char[8], regD = new char[8],
            regE = new char[8], regH = new char[8], regL = new char[8];
    // Registros alternativos de propisito general de 8 bits
    public static char [] regBo = new char[8], regCo = new char[8], regDo = new char[8], 
            regEo = new char[8], regHo = new char[8], regLo = new char[8];
    // Registro acumulador y de banderas de 8 bits
    public static char [] regA = new char[8], regF = new char[8];
    // Registro acumulador y de banderas alternativos de 8 bits
    public static char [] regAo = new char[8], regFo = new char[8];
    //// Registros de proposito especial
    // registro del refresh "R" y el registro de interrupciones "I"
    public static char [] I = new char[8], R = new char[8];
    //// Registro temporal
    public static char [] DataBus = new char[8];
    // Resgistros: El contador de programa (PC), El Apuntador del Stack (SP), Registros de Índice IX e IY.
    // Registros de 16 bits
    public static char [] IX = new char[16], IY = new char[16];
    public static int PC= 0, SP = 65535;
    //// Memoria
    public static String [] Memoria = new String [65536];
    public static ArrayList<String> memo1 = new ArrayList<>();
    public static ArrayList<Integer> pos1 = new ArrayList<>();
    //// puertos I/O
    public static String [] IO  = new String [256];
    public static char [] direcciones = new char [16];
    
    public static String buffer = "";
    
    public static final String especiales = "#3E,#06,#0E,#16,#1E,#26,#2E,#DD,7E,#"
            + "DD,46,#DD,4E,#DD,56,#DD,5E,#DD,66,#DD,6E,#FD,7E,#FD,46,#FD,4E,#"
            + "FD,56,#FD,5E,#FD,66,#FD,6E,#DD,77,#DD,70,#DD,71,#DD,72,#DD,73,#"
            + "DD,74,#DD,75,#FD,77,#FD,70,#FD,71,#FD,72,#FD,73,#FD,74,#FD,75,#"
            + "36,#DD,36,#FD,36,#3A,#32,#01,#11,#21,#31,#DD,21,#FD,21,#2A,#"
            + "ED,4B,#ED,5B,#ED,7B,#DD,2A,#FD,2A,#22,#ED,43,#ED,53,#ED,73,#"
            + "DD,22,#FD,22,C6,#DD,86,#FD,86,#CE,#DD,8E,#FD,8E,#D6,#DD,96,#"
            + "FD,96,#DE,#DD,9E,#FD,9E,#CA,#C2,#DA,#D2,#EA,#E2,#FA,#F2,#C3,#"
            + "28,#20,#38,#30,#18,#10,#CC,#C4,#DC,#D4,#EC,#E4,#FC,#F4,#CD,#"
            + "E6,#DD,A6,#FD,A6,#EE,#DD,AE,#FD,AE,#F6,#DD,B6,#FD,B6,#"
            + "FE,#DD,BE,#FD,BE,#DD,34,#FD,34,#DD,35,#FD,35,#";
    
    public static Hashtable<String,String> contenedorInstrucciones=new Hashtable<String,String>();
    public static Hashtable<String,String> InstruccionesCompilador=new Hashtable<String,String>();
    public static Hashtable<String,String> etiquetas =new Hashtable<String,String>();
    
    public static int direccionInicial=0;
    public static int auxDireccion = 0;//direccionInicial;

    public static void initEmul(){
        
    regB = new char[8];
    regC = new char[8];
    regD = new char[8];
    regE = new char[8];
    regH = new char[8];
    regL = new char[8];
    regBo = new char[8];
    regCo = new char[8];
    regDo = new char[8];
    regEo = new char[8];
    regHo = new char[8];
    regLo = new char[8];
    regA = new char[8];
    regF = new char[8];
    regAo = new char[8];
    regFo = new char[8];
    I = new char[8];
    R = new char[8];
    DataBus = new char[8];
    IX = new char[16];
    IY = new char[16];
    PC= 0;
    SP = 65535;
    Memoria = new String [65536];
    memo1 = new ArrayList<>();
    pos1 = new ArrayList<>();
    IO  = new String [256];
    direcciones = new char [16];
    
    String buffer = "";
    
    contenedorInstrucciones=new Hashtable<String,String>();
    InstruccionesCompilador=new Hashtable<String,String>();
    etiquetas =new Hashtable<String,String>();
    
    direccionInicial=0;
    auxDireccion = 0;
    }
    
    
    public ArrayList<String> getMemo1() {
        return memo1;
    }

    public ArrayList<Integer> getPos1() {
        return pos1;
    } 
    
    public String getConversorBINtoHEXA(String objetivo) {
        return conversorBINtoHEXA(objetivo);
    }
    
    public String getRegB() {
        return toCadenaBinaria(Arrays.toString(regB));
    }

    public String getRegC() {
        return toCadenaBinaria(Arrays.toString(regC));
    }

    public String getRegD() {
        return toCadenaBinaria(Arrays.toString(regD));
    }

    public String getRegE() {
        return toCadenaBinaria(Arrays.toString(regE));
    }

    public String getRegH() {
        return toCadenaBinaria(Arrays.toString(regH));
    }

    public String getRegL() {
        return toCadenaBinaria(Arrays.toString(regL));
    }
    
    public String getRegBo() {
        return toCadenaBinaria(Arrays.toString(regBo));
    }

    public String getRegCo() {
        return toCadenaBinaria(Arrays.toString(regCo));
    }

    public String getRegDo() {
        return toCadenaBinaria(Arrays.toString(regDo));
    }

    public String getRegEo() {
        return toCadenaBinaria(Arrays.toString(regEo));
    }

    public String getRegHo() {
        return toCadenaBinaria(Arrays.toString(regHo));
    }

    public String getRegLo() {
        return toCadenaBinaria(Arrays.toString(regLo));
    }

    public String getRegA() {
        return toCadenaBinaria(Arrays.toString(regA));
    }

    public char[] getRegF() {
        return regF;
    }

    public String getRegAo() {
        return toCadenaBinaria(Arrays.toString(regAo));
    }

    public char[] getRegFo() {
        return regFo;
    }
    
    public char[] getDirecciones() {
        return direcciones;
    }

    public String getI() {
        return toCadenaBinaria(Arrays.toString(I));
    }

    public String getR() {
        return toCadenaBinaria(Arrays.toString(R));
    }
    
    public String getBuffer() {
        return buffer;
    }

    public char[] getDataBus() {
        return DataBus;
    }

    public String getIX() {
        return toCadenaBinaria(Arrays.toString(IX));
    }

    public String getIY() {
        return toCadenaBinaria(Arrays.toString(IY));
    }

    public int getPC() {
        return PC;
    }

    public int getSP() {
        return SP;
    }

    public String[] getMemoria() {//important
        String[] contenido = Memoria;//Arrays.toString(Memoria);
        return contenido;
    }
    
    public String getIO() {
        String contenido2 = Arrays.toString(IO);
        return contenido2;
    }    
    
    public void almacenar() throws IOException{//change
        instruccionesCompilador();
        //// lee el codigo a ejecutar de un archivo txt y almacenarlo en memoria
        String input;
        FileReader f = new FileReader("archivo.txt");
        BufferedReader b1 = new BufferedReader(f);
        //isntruccionFuente();
        String []prueba;
        String auxIn [];
        String auxEtiquetas [];
        input = b1.readLine();
        do {            
            //System.out.println(input);
            // revisar si tiene etiquetas
            auxEtiquetas = input.split("#");
            if (!auxEtiquetas[0].isEmpty()) {
                etiquetas.put(auxEtiquetas[0],""+auxDireccion);
            }
        } while ((input = b1.readLine())!=null);
        b1.close();
        
        FileReader f2 = new FileReader("archivo.txt");
        BufferedReader b2 = new BufferedReader(f2);
        //isntruccionFuente();
        input = b2.readLine();
        int lineCout =0;
        do {            
            //System.out.println(input);
            // revisar si tiene etiquetas
            auxEtiquetas = input.split("#");
            etiquetas.put(Integer.toHexString(auxDireccion)+"&",""+lineCout);
            lineCout++;
            if (!auxEtiquetas[0].isEmpty()) {
                etiquetas.replace(auxEtiquetas[0],""+auxDireccion);
            }
            input = auxEtiquetas[1];
            //el el cargador Linker revisa si encuentra alguna etiqueta y la reemplaza por el valor de la drieccion alto o bajo
            auxIn = isntruccionFuente(input);
            prueba = auxIn[0].split(",");
            switch (prueba.length) {
                case 1:
                    cargar1byte(auxIn[0].split(","));
                    break;
                case 2:
                    cargar2bytes(auxIn[0].split(","), auxIn[1]);
                    break;
                case 3:
                    cargar3bytes(auxIn[0].split(","), auxIn[1]);
                    break;
                case 4:
                    cargar4bytes(auxIn[0].split(","), auxIn[1]);
                    break;
            }
        } while ((input = b2.readLine())!=null);
        b2.close();
        File ft = new File("achivoReLoc.txt"); 
        ft.createNewFile(); 
        FileWriter flwriter = new FileWriter(ft);
        int i=direccionInicial;
        input = Memoria[i];
        do {            
            flwriter.write(input+" "); 
            i++;
        } while ((input = Memoria[i])!=null);
        flwriter.close();
        File fEtit = new File("achivoEtiquetas.txt"); 
        fEtit.createNewFile(); 
        FileWriter flEtitWriter = new FileWriter(fEtit);
        Enumeration e = etiquetas.keys();
        Object clave;
        Object valor;
        while( e.hasMoreElements() ){
            clave = e.nextElement();
            valor = etiquetas.get( clave );
            flEtitWriter.write(clave+" "+valor+"\n"); 
        }
        flEtitWriter.close();
        conjuntoInstrucciones();
        PC = direccionInicial;
    }
    
    public void linker(int partida) throws IOException{//change
        etiquetas.clear();
        String et;
        FileReader fEt = new FileReader("achivoEtiquetas.txt");
        BufferedReader bEt = new BufferedReader(fEt);
        String auxEt [];
        while ((et = bEt.readLine())!=null) {
            auxEt = et.split(" ");
            etiquetas.put(auxEt[0],auxEt[1]);
        } 
        bEt.close();
        //changes
        
        //changes end
        for (int i = 0; i < Memoria.length; i++) {
            Memoria[i]="00000000";
        }
        
        String input;
        FileReader f = new FileReader("achivoReLoc.txt");
        BufferedReader b = new BufferedReader(f);
        input = b.readLine();
        int posicion;
        String [] auxIn = input.split(" ");
        for (int i = 0; i < auxIn.length; i++) {
            if (etiquetas.containsKey(auxIn[i].replace("&low", "")) || etiquetas.containsKey(auxIn[i].replace("&high", ""))) {
                auxIn[i] = etiquetas.get(auxIn[i].replace("&low", ""));
                posicion = Integer.parseInt(auxIn[i]) ;
                auxIn[i] = conversorINTtoHEXA(partida+posicion) ;
                Memoria[partida+i]= toCadenaBinaria(Arrays.toString(conversorHEXAtoBIN(auxIn[i].substring(2))));
                Memoria[partida+i+1]= toCadenaBinaria(Arrays.toString(conversorHEXAtoBIN(auxIn[i].substring(0,2)))); 
                i++;
            }else{
                Memoria[partida+i]= auxIn[i];
            }
        }
        b.close();
        
        File ft = new File("achivoBin.txt"); 
        ft.createNewFile(); 
        FileWriter flwriter = new FileWriter(ft);
        for (int i = 0; i < Memoria.length; i++) {
            input = Memoria[i];
            flwriter.write(input+" "); 
        }
        flwriter.close();
        
        conjuntoInstrucciones();
        cargar(partida);        
    }
    
    
    public void cargar(int start) throws IOException{
        //// lee el codigo a ejecutar de un archivo txt y almacenarlo en memoria
        String input;
        FileReader f = new FileReader("achivoBin.txt");
        BufferedReader b = new BufferedReader(f);
        input = b.readLine();
        String [] auxIn = input.split(" ");
        pos1.add(start);
        ArrayList<String> auxarr = new ArrayList<>();
        for (int i = start; i < auxIn.length; i++) {
            Memoria[i]= auxIn[i];
            if(!auxIn[i].equals("01110110")){
                auxarr.add(auxIn[i]);
            }else{
                auxarr.add(auxIn[i]);
                memo1 = auxarr;
                pos1.add(i+1);
            }
        }
        b.close();
        
        conjuntoInstrucciones();
        PC = start;
    }
    
    public void incializarRegistros(){
        
        for (int i = 0; i < IO.length; i++) {
            IO[i]="00000000";
        }
        //// inicializa en cero el registro de las banderas
        regF = "00000000".toCharArray();
        regFo = "00000000".toCharArray();
        //// inicializa en cero el registro 
        regA = "00000000".toCharArray();
        regB = "00000000".toCharArray();
        regC = "00000000".toCharArray();
        regD = "00000000".toCharArray();
        regE = "00000000".toCharArray();
        regH = "00000000".toCharArray();
        regL = "00000000".toCharArray();
        regAo = "00000000".toCharArray();
        regBo = "00000000".toCharArray();
        regCo = "00000000".toCharArray();
        regDo = "00000000".toCharArray();
        regEo = "00000000".toCharArray();
        regHo = "00000000".toCharArray();
        regLo = "00000000".toCharArray();
        IX = "0000000000000000".toCharArray();
        IY = "0000000000000000".toCharArray();
        direcciones = "0000000000000000".toCharArray();
    }
    
    public String nucleo() {
        
        String auxIn [];
        auxIn = armarIntruccion(PC)[0].split(" ");
        switch (auxIn.length) {
            case 1:
                Z80(auxIn[0],"");
                break;
            case 2:
                Z80(auxIn[0],auxIn[1]);
                break;
            case 3:
                Z80(auxIn[1],auxIn[2]);
                break;
            default:
                break;
        }
        // revisar bandera tres
        if (regF[3]=='1') {
            return null;
        }
        return auxIn[0];
        
               
    }
    
    public static void cargar1byte(String []opcode){
        Memoria[auxDireccion]= toCadenaBinaria(Arrays.toString(conversorHEXAtoBIN(opcode[0])));
        auxDireccion++;
    }
    
    public static void cargar2bytes(String []opcode, String operando){
        Memoria[auxDireccion]= toCadenaBinaria(Arrays.toString(conversorHEXAtoBIN(opcode[0])));
        auxDireccion++;
        if ("n".equals(opcode[1])||"d".equals(opcode[1])) {
            Memoria[auxDireccion]= toCadenaBinaria(Arrays.toString(conversorHEXAtoBIN(operando)));
            auxDireccion++;
        }else{
            Memoria[auxDireccion]= toCadenaBinaria(Arrays.toString(conversorHEXAtoBIN(opcode[1])));
            auxDireccion++;
        }
    }
    
    public static void cargar3bytes(String []opcode, String operando){
        Memoria[auxDireccion]= toCadenaBinaria(Arrays.toString(conversorHEXAtoBIN(opcode[0])));
        auxDireccion++;
        if ("n".equals(opcode[1])) {
            // revisar si es una etiqueta el operando
            //System.out.println(operando);
            if (etiquetas.containsKey(operando)) {
                Memoria[auxDireccion]= operando+"&low";
                auxDireccion++;
                Memoria[auxDireccion]= operando+"&high";
                auxDireccion++;

            } else{
                Memoria[auxDireccion]= toCadenaBinaria(Arrays.toString(conversorHEXAtoBIN(operando.substring(2))));
                auxDireccion++;
                Memoria[auxDireccion]= toCadenaBinaria(Arrays.toString(conversorHEXAtoBIN(operando.substring(0,2))));
                auxDireccion++;        
            }
        }else{
            Memoria[auxDireccion]= toCadenaBinaria(Arrays.toString(conversorHEXAtoBIN(opcode[1])));
            auxDireccion++;
            if ("n".equals(opcode[2])||"d".equals(opcode[2])) {
                Memoria[auxDireccion]= toCadenaBinaria(Arrays.toString(conversorHEXAtoBIN(operando)));
                auxDireccion++;
            }else{
                Memoria[auxDireccion]= toCadenaBinaria(Arrays.toString(conversorHEXAtoBIN(opcode[2])));
                auxDireccion++;
            }
        }
        
    }
    
    public static void cargar4bytes(String []opcode, String operando){
        Memoria[auxDireccion]= toCadenaBinaria(Arrays.toString(conversorHEXAtoBIN(opcode[0])));
        auxDireccion++;
        Memoria[auxDireccion]= toCadenaBinaria(Arrays.toString(conversorHEXAtoBIN(opcode[1])));
        auxDireccion++;
        
        if ("n".equals(opcode[2])||"d".equals(opcode[2])) {
            Memoria[auxDireccion]= toCadenaBinaria(Arrays.toString(conversorHEXAtoBIN(operando.substring(2))));
            auxDireccion++;
            if ("n".equals(opcode[3])) {
                Memoria[auxDireccion]= toCadenaBinaria(Arrays.toString(conversorHEXAtoBIN(operando.substring(0,2))));
                auxDireccion++;
            }else{
                Memoria[auxDireccion]= toCadenaBinaria(Arrays.toString(conversorHEXAtoBIN(opcode[3])));
                auxDireccion++;
            }
        }else{
            Memoria[auxDireccion]= toCadenaBinaria(Arrays.toString(conversorHEXAtoBIN(opcode[2])));
            auxDireccion++;
            if ("n".equals(opcode[3])||"d".equals(opcode[3])) {
                Memoria[auxDireccion]= toCadenaBinaria(Arrays.toString(conversorHEXAtoBIN(operando)));
                auxDireccion++;
            }else{
                Memoria[auxDireccion]= toCadenaBinaria(Arrays.toString(conversorHEXAtoBIN(opcode[3])));
                auxDireccion++;
            }
        }
    }
    
    public static void Z80(String opcode, String operandosFuente){
        String operandos[]= operandosFuente.split(",");
        switch(opcode){
            case "LD":{
                LDop(operandos);
                break;
            }
            case "PUSH":{
                switch(operandos[0]){
                    case "BC":{
                        // 
                        SP = SP -1;
                        Memoria[SP]= toCadenaBinaria(Arrays.toString(regB));
                        SP = SP -1;
                        Memoria[SP]= toCadenaBinaria(Arrays.toString(regC));
                        PC++;
                        break;
                    }
                    case "DE":{
                        // 
                        SP = SP -1;
                        Memoria[SP]= toCadenaBinaria(Arrays.toString(regD));
                        SP = SP -1;
                        Memoria[SP]= toCadenaBinaria(Arrays.toString(regE));
                        PC++;
                        break;
                    }
                    case "HL":{
                        // 
                        SP = SP -1;
                        Memoria[SP]= toCadenaBinaria(Arrays.toString(regH));
                        SP = SP -1;
                        Memoria[SP]= toCadenaBinaria(Arrays.toString(regL));
                        PC++;
                        break;
                    }
                    case "AF":{
                        // 
                        SP = SP -1;
                        Memoria[SP]= toCadenaBinaria(Arrays.toString(regA));
                        SP = SP -1;
                        Memoria[SP]= toCadenaBinaria(Arrays.toString(regF));
                        PC++;
                        break;
                    }
                    case "IX":{
                        // 
                        String SPaux = toCadenaBinaria(Arrays.toString(IX));
                        SP = SP -1;
                        Memoria[SP]= SPaux.substring(0,8);
                        SP = SP -1;
                        Memoria[SP]= SPaux.substring(8);
                        PC= PC +2;
                        break;
                    }
                    case "IY":{
                        // 
                        String SPaux = toCadenaBinaria(Arrays.toString(IY));
                        SP = SP -1;
                        Memoria[SP]= SPaux.substring(0,8);
                        SP = SP -1;
                        Memoria[SP]= SPaux.substring(8);
                        PC= PC +2;
                        break;
                    }
                }
                break;
            }
            case "POP":{
                switch(operandos[0]){
                    case "BC":{
                        // 
                        regC = toCadenaBinaria(Memoria[SP]).toCharArray();
                        SP = SP +1;
                        regB = toCadenaBinaria(Memoria[SP]).toCharArray();
                        SP = SP +1;
                        PC++;
                        break;
                    }
                    case "DE":{
                        // 
                        regE = toCadenaBinaria(Memoria[SP]).toCharArray();
                        SP = SP +1;
                        regD = toCadenaBinaria(Memoria[SP]).toCharArray();
                        SP = SP +1;
                        PC++;
                        break;
                    }
                    case "HL":{
                        // 
                        regL = toCadenaBinaria(Memoria[SP]).toCharArray();
                        SP = SP +1;
                        regH = toCadenaBinaria(Memoria[SP]).toCharArray();
                        SP = SP +1;
                        PC++;
                        break;
                    }
                    case "AF":{
                        // 
                        regF = toCadenaBinaria(Memoria[SP]).toCharArray();
                        SP = SP +1;
                        regA = toCadenaBinaria(Memoria[SP]).toCharArray();
                        SP = SP +1;
                        PC++;
                        break;
                    }
                    case "IX":{
                        // 
                        String SPaux = Memoria[SP];
                        SP = SP +1;
                        SPaux = Memoria[SP]+SPaux;
                        SP = SP +1;
                        IX = toCadenaBinaria(SPaux).toCharArray();
                        PC= PC +2;
                        break;
                    }
                    case "IY":{
                        // 
                        String SPaux = Memoria[SP];
                        SP = SP +1;
                        SPaux = Memoria[SP]+SPaux;
                        SP = SP +1;
                        IY = toCadenaBinaria(SPaux).toCharArray();
                        PC= PC +2;
                        break;
                    }
                }
                break;
            }
            case "ADD":{
                // como en las operaciones de suma de 8 bits el primer operando siempre
                // es el acumulador, entonces solo analizamos el segundo operador para 
                // direccionar la operacion el el switch case (simulacion de una suma implicita)
                
                switch(operandos[1]){
                    case "A":{
                        //
                        regA = sumarBinyBin(regA, regA,'0');
                        PC++;
                        break;
                    }
                    case "B":{
                        //
                        regA = sumarBinyBin(regA, regB,'0');
                        PC++;
                        break;
                    }
                    case "C":{
                        //
                        regA = sumarBinyBin(regA, regC,'0');
                        PC++;
                        break;
                    }
                    case "D":{
                        //
                        regA = sumarBinyBin(regA, regD,'0');
                        PC++;
                        break;
                    }
                    case "E":{
                        //
                        regA = sumarBinyBin(regA, regE,'0');
                        PC++;
                        break;
                    }
                    case "H":{
                        //
                        regA = sumarBinyBin(regA, regH,'0');
                        PC++;
                        break;
                    }
                    case "L":{
                        //
                        regA = sumarBinyBin(regA, regL,'0');
                        PC++;
                        break;
                    }
                    case "n":{
                        //
                        regA = sumarBinyBin(regA, toCadenaBinaria(Memoria[PC+1]).toCharArray(),'0');
                        PC = PC +2;
                        break;
                    }
                    case "(HL)":{
                        //
                        regA = sumarBinyBin(regA, toCadenaBinaria(Memoria[Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16)]).toCharArray(),'0');
                        PC++;
                        break;
                    }
                    case "(IX+d)":{
                        //
                        int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IX))),16);
                        int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                        if (auxiliar>127) {
                            auxiliar = auxiliar - 256;
                        }
                        dirInderecta = dirInderecta + auxiliar;
                        regA = sumarBinyBin(regA, toCadenaBinaria(Memoria[dirInderecta]).toCharArray(),'0');
                        PC= PC+3;
                        break;
                    }
                    case "(IY+d)":{
                        //
                        int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IY))),16);
                        int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                        if (auxiliar>127) {
                            auxiliar = auxiliar - 256;
                        }
                        dirInderecta = dirInderecta + auxiliar;
                        regA = sumarBinyBin(regA, toCadenaBinaria(Memoria[dirInderecta]).toCharArray(),'0');
                        PC= PC+3;
                        break;
                    }
                }
                break;
            }
            case "ADC":{
                // como en las operaciones de suma de 8 bits el primer operando siempre
                // es el acumulador, entonces solo analizamos el segundo operador para 
                // direccionar la operacion el el switch case (simulacion de una suma implicita)
                switch(operandos[1]){
                    case "A":{
                        //
                        regA = sumarBinyBin(regA, regA,regF[0]);
                        PC++;
                        break;
                    }
                    case "B":{
                        //
                        regA = sumarBinyBin(regA, regB,regF[0]);
                        PC++;
                        break;
                    }
                    case "C":{
                        //
                        regA = sumarBinyBin(regA, regC,regF[0]);
                        PC++;
                        break;
                    }
                    case "D":{
                        //
                        regA = sumarBinyBin(regA, regD,regF[0]);
                        PC++;
                        break;
                    }
                    case "E":{
                        //
                        regA = sumarBinyBin(regA, regE,regF[0]);
                        PC++;
                        break;
                    }
                    case "H":{
                        //
                        regA = sumarBinyBin(regA, regH,regF[0]);
                        PC++;
                        break;
                    }
                    case "L":{
                        //
                        regA = sumarBinyBin(regA, regL,regF[0]);
                        PC++;
                        break;
                    }
                    case "n":{
                        //
                        regA = sumarBinyBin(regA, toCadenaBinaria(Memoria[PC+1]).toCharArray(),regF[0]);
                        PC = PC +2;
                        break;
                    }
                    case "(HL)":{
                        //
                        regA = sumarBinyBin(regA, toCadenaBinaria(Memoria[Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16)]).toCharArray(),regF[0]);
                        PC++;
                        break;
                    }
                    case "(IX+d)":{
                        //
                        int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IX))),16);
                        int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                        if (auxiliar>127) {
                            auxiliar = auxiliar - 256;
                        }
                        dirInderecta = dirInderecta + auxiliar;
                        regA = sumarBinyBin(regA, toCadenaBinaria(Memoria[dirInderecta]).toCharArray(),regF[0]);
                        PC= PC+3;
                        break;
                    }
                    case "(IY+d)":{
                        //
                        int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IY))),16);
                        int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                        if (auxiliar>127) {
                            auxiliar = auxiliar - 256;
                        }
                        dirInderecta = dirInderecta + auxiliar;
                        regA = sumarBinyBin(regA, toCadenaBinaria(Memoria[dirInderecta]).toCharArray(),regF[0]);
                        PC= PC+3;
                        break;
                    }
                }
                break;
            }
            case "SUB":{
                switch(operandos[0]){
                    case "A":{
                        //
                        regA = restarBinyBin(regA, regA,'0');
                        PC++;
                        break;
                    }
                    case "B":{
                        //
                        regA = restarBinyBin(regA, regB,'0');
                        PC++;
                        break;
                    }
                    case "C":{
                        //
                        regA = restarBinyBin(regA, regC,'0');
                        PC++;
                        break;
                    }
                    case "D":{
                        //
                        regA = restarBinyBin(regA, regD,'0');
                        PC++;
                        break;
                    }
                    case "E":{
                        //
                        regA = restarBinyBin(regA, regE,'0');
                        PC++;
                        break;
                    }
                    case "H":{
                        //
                        regA = restarBinyBin(regA, regH,'0');
                        PC++;
                        break;
                    }
                    case "L":{
                        //
                        regA = restarBinyBin(regA, regL,'0');
                        PC++;
                        break;
                    }
                    case "n":{
                        //
                        regA = restarBinyBin(regA, toCadenaBinaria(Memoria[PC+1]).toCharArray(),'0');
                        PC = PC +2;
                        break;
                    }
                    case "(HL)":{
                        //
                        regA = restarBinyBin(regA, toCadenaBinaria(Memoria[Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16)]).toCharArray(),'0');
                        PC++;
                        break;
                    }
                    case "(IX+d)":{
                        //
                        int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IX))),16);
                        int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                        if (auxiliar>127) {
                            auxiliar = auxiliar - 256;
                        }
                        dirInderecta = dirInderecta + auxiliar;
                        regA = restarBinyBin(regA, toCadenaBinaria(Memoria[dirInderecta]).toCharArray(),'0');
                        PC= PC+3;
                        break;
                    }
                    case "(IY+d)":{
                        //
                        int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IY))),16);
                        int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                        if (auxiliar>127) {
                            auxiliar = auxiliar - 256;
                        }
                        dirInderecta = dirInderecta + auxiliar;
                        regA = restarBinyBin(regA, toCadenaBinaria(Memoria[dirInderecta]).toCharArray(),'0');
                        PC= PC+3;
                        break;
                    }
                }
                break;
            }
            case "SBC":{
                switch(operandos[1]){
                    case "A":{
                        //
                        regA = restarBinyBin(regA, regA,regF[0]);
                        PC++;
                        break;
                    }
                    case "B":{
                        //
                        regA = restarBinyBin(regA, regB,regF[0]);
                        PC++;
                        break;
                    }
                    case "C":{
                        //
                        regA = restarBinyBin(regA, regC,regF[0]);
                        PC++;
                        break;
                    }
                    case "D":{
                        //
                        regA = restarBinyBin(regA, regD,regF[0]);
                        PC++;
                        break;
                    }
                    case "E":{
                        //
                        regA = restarBinyBin(regA, regE,regF[0]);
                        PC++;
                        break;
                    }
                    case "H":{
                        //
                        regA = restarBinyBin(regA, regH,regF[0]);
                        PC++;
                        break;
                    }
                    case "L":{
                        //
                        regA = restarBinyBin(regA, regL,regF[0]);
                        PC++;
                        break;
                    }
                    case "n":{
                        //
                        regA = restarBinyBin(regA, toCadenaBinaria(Memoria[PC+1]).toCharArray(),regF[0]);
                        PC = PC +2;
                        break;
                    }
                    case "(HL)":{
                        //
                        regA = restarBinyBin(regA, toCadenaBinaria(Memoria[Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16)]).toCharArray(),regF[0]);
                        PC++;
                        break;
                    }
                    case "(IX+d)":{
                        //
                        int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IX))),16);
                        int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                        if (auxiliar>127) {
                            auxiliar = auxiliar - 256;
                        }
                        dirInderecta = dirInderecta + auxiliar;
                        regA = restarBinyBin(regA, toCadenaBinaria(Memoria[dirInderecta]).toCharArray(),regF[0]);
                        PC= PC+3;
                        break;
                    }
                    case "(IY+d)":{
                        //
                        int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IY))),16);
                        int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                        if (auxiliar>127) {
                            auxiliar = auxiliar - 256;
                        }
                        dirInderecta = dirInderecta + auxiliar;
                        regA = restarBinyBin(regA, toCadenaBinaria(Memoria[dirInderecta]).toCharArray(),regF[0]);
                        PC= PC+3;
                        break;
                    }
                }
                break;
            }
            case "INC":{
                // como en las operaciones de suma de 8 bits el primer operando siempre
                // es el acumulador, entonces solo analizamos el segundo operador para 
                // direccionar la operacion el el switch case (simulacion de una suma implicita)
                switch(operandos[0]){
                    case "A":{
                        //
                        regA = incrementar8bits(regA);
                        PC++;
                        break;
                    }
                    case "B":{
                        //
                        regB = incrementar8bits(regB);
                        PC++;
                        break;
                    }
                    case "C":{
                        //
                        regC = incrementar8bits(regC);
                        PC++;
                        break;
                    }
                    case "D":{
                        //
                        regD = incrementar8bits(regD);
                        PC++;
                        break;
                    }
                    case "E":{
                        //
                        regE = incrementar8bits(regE);
                        PC++;
                        break;
                    }
                    case "H":{
                        //
                        regH = incrementar8bits(regH);
                        PC++;
                        break;
                    }
                    case "L":{
                        //
                        regL = incrementar8bits(regL);
                        PC++;
                        break;
                    }
                    case "(HL)":{
                        //
                        int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16);
                        Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(incrementar8bits(toCadenaBinaria(Memoria[dirInderecta]).toCharArray())));
                        PC++;
                        break;
                    }
                    case "(IX+d)":{
                        //
                        int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IX))),16);
                        int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                        if (auxiliar>127) {
                            auxiliar = auxiliar - 256;
                        }
                        dirInderecta = dirInderecta + auxiliar;
                        Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(incrementar8bits(toCadenaBinaria(Memoria[dirInderecta]).toCharArray())));
                        PC= PC+3;
                        break;
                    }
                    case "(IY+d)":{
                        //
                        int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IY))),16);
                        int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                        if (auxiliar>127) {
                            auxiliar = auxiliar - 256;
                        }
                        dirInderecta = dirInderecta + auxiliar;
                        Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(incrementar8bits(toCadenaBinaria(Memoria[dirInderecta]).toCharArray())));
                        PC= PC+3;
                        break;
                    }
                }
                break;
            }
            case "DEC":{
                // como en las operaciones de suma de 8 bits el primer operando siempre
                // es el acumulador, entonces solo analizamos el segundo operador para 
                // direccionar la operacion el el switch case (simulacion de una suma implicita)
                switch(operandos[0]){
                    case "A":{
                        //
                        regA = decrementar8bits(regA);
                        PC++;
                        break;
                    }
                    case "B":{
                        //
                        regB = decrementar8bits(regB);
                        PC++;
                        break;
                    }
                    case "C":{
                        //
                        regC = decrementar8bits(regC);
                        PC++;
                        break;
                    }
                    case "D":{
                        //
                        regD = decrementar8bits(regD);
                        PC++;
                        break;
                    }
                    case "E":{
                        //
                        regE = decrementar8bits(regE);
                        PC++;
                        break;
                    }
                    case "H":{
                        //
                        regH = decrementar8bits(regH);
                        PC++;
                        break;
                    }
                    case "L":{
                        //
                        regL = decrementar8bits(regL);
                        PC++;
                        break;
                    }
                    case "(HL)":{
                        //
                        int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16);
                        Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(decrementar8bits(toCadenaBinaria(Memoria[dirInderecta]).toCharArray())));
                        PC++;
                        break;
                    }
                    case "(IX+d)":{
                        //
                        int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IX))),16);
                        int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                        if (auxiliar>127) {
                            auxiliar = auxiliar - 256;
                        }
                        dirInderecta = dirInderecta + auxiliar;
                        Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(decrementar8bits(toCadenaBinaria(Memoria[dirInderecta]).toCharArray())));
                        PC= PC+3;
                        break;
                    }
                    case "(IY+d)":{
                        //
                        int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IY))),16);
                        int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                        if (auxiliar>127) {
                            auxiliar = auxiliar - 256;
                        }
                        dirInderecta = dirInderecta + auxiliar;
                        Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(decrementar8bits(toCadenaBinaria(Memoria[dirInderecta]).toCharArray())));
                        PC= PC+3;
                        break;
                    }
                }
                break;
            }
            case "AND":{
                // como en las operaciones de suma de 8 bits el primer operando siempre
                // es el acumulador, entonces solo analizamos el segundo operador para 
                // direccionar la operacion el el switch case (simulacion de una suma implicita)
                switch(operandos[0]){
                    case "A":{
                        //
                        regA = and(regA, regA);
                        PC++;
                        break;
                    }
                    case "B":{
                        //
                        regA = and(regA, regB);
                        PC++;
                        break;
                    }
                    case "C":{
                        //
                        regA = and(regA, regC);
                        PC++;
                        break;
                    }
                    case "D":{
                        //
                        regA = and(regA, regD);
                        PC++;
                        break;
                    }
                    case "E":{
                        //
                        regA = and(regA, regE);
                        PC++;
                        break;
                    }
                    case "H":{
                        //
                        regA = and(regA, regH);
                        PC++;
                        break;
                    }
                    case "L":{
                        //
                        regA = and(regA, regL);
                        PC++;
                        break;
                    }
                    case "n":{
                        //
                        regA = and(regA, toCadenaBinaria(Memoria[PC+1]).toCharArray());
                        PC = PC +2;
                        break;
                    }
                    case "(HL)":{
                        //
                        regA = and(regA, toCadenaBinaria(Memoria[Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16)]).toCharArray());
                        PC++;
                        break;
                    }
                    case "(IX+d)":{
                        //
                        int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IX))),16);
                        int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                        if (auxiliar>127) {
                            auxiliar = auxiliar - 256;
                        }
                        dirInderecta = dirInderecta + auxiliar;
                        regA = and(regA, toCadenaBinaria(Memoria[dirInderecta]).toCharArray());
                        PC= PC+3;
                        break;
                    }
                    case "(IY+d)":{
                        //
                        int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IY))),16);
                        int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                        if (auxiliar>127) {
                            auxiliar = auxiliar - 256;
                        }
                        dirInderecta = dirInderecta + auxiliar;
                        regA = and(regA, toCadenaBinaria(Memoria[dirInderecta]).toCharArray());
                        PC= PC+3;
                        break;
                    }
                }
                break;
            }
            case "XOR":{
                // como en las operaciones de suma de 8 bits el primer operando siempre
                // es el acumulador, entonces solo analizamos el segundo operador para 
                // direccionar la operacion el el switch case (simulacion de una suma implicita)
                switch(operandos[0]){
                    case "A":{
                        //
                        regA = xor(regA, regA);
                        PC++;
                        break;
                    }
                    case "B":{
                        //
                        regA = xor(regA, regB);
                        PC++;
                        break;
                    }
                    case "C":{
                        //
                        regA = xor(regA, regC);
                        PC++;
                        break;
                    }
                    case "D":{
                        //
                        regA = xor(regA, regD);
                        PC++;
                        break;
                    }
                    case "E":{
                        //
                        regA = xor(regA, regE);
                        PC++;
                        break;
                    }
                    case "H":{
                        //
                        regA = xor(regA, regH);
                        PC++;
                        break;
                    }
                    case "L":{
                        //
                        regA = xor(regA, regL);
                        PC++;
                        break;
                    }
                    case "n":{
                        //
                        regA = xor(regA, toCadenaBinaria(Memoria[PC+1]).toCharArray());
                        PC = PC +2;
                        break;
                    }
                    case "(HL)":{
                        //
                        regA = xor(regA, toCadenaBinaria(Memoria[Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16)]).toCharArray());
                        PC++;
                        break;
                    }
                    case "(IX+d)":{
                        //
                        int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IX))),16);
                        int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                        if (auxiliar>127) {
                            auxiliar = auxiliar - 256;
                        }
                        dirInderecta = dirInderecta + auxiliar;
                        regA = xor(regA, toCadenaBinaria(Memoria[dirInderecta]).toCharArray());
                        PC= PC+3;
                        break;
                    }
                    case "(IY+d)":{
                        //
                        int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IY))),16);
                        int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                        if (auxiliar>127) {
                            auxiliar = auxiliar - 256;
                        }
                        dirInderecta = dirInderecta + auxiliar;
                        regA = xor(regA, toCadenaBinaria(Memoria[dirInderecta]).toCharArray());
                        PC= PC+3;
                        break;
                    }
                }
                break;
            }
            case "OR":{
                // como en las operaciones de suma de 8 bits el primer operando siempre
                // es el acumulador, entonces solo analizamos el segundo operador para 
                // direccionar la operacion el el switch case (simulacion de una suma implicita)
                switch(operandos[0]){
                    case "A":{
                        //
                        regA = or(regA, regA);
                        PC++;
                        break;
                    }
                    case "B":{
                        //
                        regA = or(regA, regB);
                        PC++;
                        break;
                    }
                    case "C":{
                        //
                        regA = or(regA, regC);
                        PC++;
                        break;
                    }
                    case "D":{
                        //
                        regA = or(regA, regD);
                        PC++;
                        break;
                    }
                    case "E":{
                        //
                        regA = or(regA, regE);
                        PC++;
                        break;
                    }
                    case "H":{
                        //
                        regA = or(regA, regH);
                        PC++;
                        break;
                    }
                    case "L":{
                        //
                        regA = or(regA, regL);
                        PC++;
                        break;
                    }
                    case "n":{
                        //
                        regA = or(regA, toCadenaBinaria(Memoria[PC+1]).toCharArray());
                        PC = PC +2;
                        break;
                    }
                    case "(HL)":{
                        //
                        regA = or(regA, toCadenaBinaria(Memoria[Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16)]).toCharArray());
                        PC++;
                        break;
                    }
                    case "(IX+d)":{
                        //
                        int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IX))),16);
                        int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                        if (auxiliar>127) {
                            auxiliar = auxiliar - 256;
                        }
                        dirInderecta = dirInderecta + auxiliar;
                        regA = or(regA, toCadenaBinaria(Memoria[dirInderecta]).toCharArray());
                        PC= PC+3;
                        break;
                    }
                    case "(IY+d)":{
                        //
                        int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IY))),16);
                        int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                        if (auxiliar>127) {
                            auxiliar = auxiliar - 256;
                        }
                        dirInderecta = dirInderecta + auxiliar;
                        regA = or(regA, toCadenaBinaria(Memoria[dirInderecta]).toCharArray());
                        PC= PC+3;
                        break;
                    }
                }
                break;
            }
            case "CP":{
                // como en las operaciones de suma de 8 bits el primer operando siempre
                // es el acumulador, entonces solo analizamos el segundo operador para 
                // direccionar la operacion el el switch case (simulacion de una suma implicita)
                switch(operandos[0]){
                    case "A":{
                        //
                        comparacion(regA, regA);
                        PC++;
                        break;
                    }
                    case "B":{
                        //
                        comparacion(regA, regB);
                        PC++;
                        break;
                    }
                    case "C":{
                        //
                        comparacion(regA, regC);
                        PC++;
                        break;
                    }
                    case "D":{
                        //
                        comparacion(regA, regD);
                        PC++;
                        break;
                    }
                    case "E":{
                        //
                        comparacion(regA, regE);
                        PC++;
                        break;
                    }
                    case "H":{
                        //
                        comparacion(regA, regH);
                        PC++;
                        break;
                    }
                    case "L":{
                        //
                        comparacion(regA, regL);
                        PC++;
                        break;
                    }
                    case "n":{
                        //
                        comparacion(regA, toCadenaBinaria(Memoria[PC+1]).toCharArray());
                        PC = PC +2;
                        break;
                    }
                    case "(HL)":{
                        //
                        comparacion(regA, toCadenaBinaria(Memoria[Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16)]).toCharArray());
                        PC++;
                        break;
                    }
                    case "(IX+d)":{
                        //
                        int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IX))),16);
                        int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                        if (auxiliar>127) {
                            auxiliar = auxiliar - 256;
                        }
                        dirInderecta = dirInderecta + auxiliar;
                        comparacion(regA, toCadenaBinaria(Memoria[dirInderecta]).toCharArray());
                        PC= PC+3;
                        break;
                    }
                    case "(IY+d)":{
                        //
                        int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IY))),16);
                        int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                        if (auxiliar>127) {
                            auxiliar = auxiliar - 256;
                        }
                        dirInderecta = dirInderecta + auxiliar;
                        comparacion(regA, toCadenaBinaria(Memoria[dirInderecta]).toCharArray());
                        PC= PC+3;
                        break;
                    }
                }
                break;
            }
            case "CPL":{
                regA= complemenTOuno(regA);
                PC++;
                break;
            }
            case "NEG":{
                regA= complemenTOdos(regA);
                PC= PC+2;
                break;
            }
            case "CCF":{
                
                break;
            }
            case "SCF":{
                
                break;
            }
            case "DAA":{
                
                break;
            }
            case "JP":{
                switch(operandos[0]){
                    case"Z":{
                        // CA, nn
                        if (regF[6]=='1') {
                            PC = Integer.parseInt((Memoria[PC+2]+Memoria[PC+1]), 2);
                        }else{
                            PC = PC +3; 
                        }
                        break;
                    }
                    case"NZ":{
                        // C2, nn
                        if (regF[6]=='0') {
                            PC = Integer.parseInt((Memoria[PC+2]+Memoria[PC+1]), 2);
                        }else{
                            PC = PC +3; 
                        }
                        break;
                    }
                    case"C":{
                        // DA, nn
                        if (regF[0]=='1') {
                            PC = Integer.parseInt((Memoria[PC+2]+Memoria[PC+1]), 2);
                        }else{
                            PC = PC +3; 
                        }
                        break;
                    }
                    case"NC":{
                        // D2, nn
                        if (regF[0]=='0') {
                            PC = Integer.parseInt((Memoria[PC+2]+Memoria[PC+1]), 2);
                        }else{
                            PC = PC +3; 
                        }
                        break;
                    }
                    case"PE":{
                        // EA, nn
                        if (regF[2]=='1') {
                            PC = Integer.parseInt((Memoria[PC+2]+Memoria[PC+1]), 2);
                        }else{
                            PC = PC +3; 
                        }
                        break;
                    }
                    case"PO":{
                        // E2, nn
                        if (regF[2]=='0') {
                            PC = Integer.parseInt((Memoria[PC+2]+Memoria[PC+1]), 2);
                        }else{
                            PC = PC +3; 
                        }
                        break;
                    }
                    case"M":{
                        // FA, nn
                        if (regF[7]=='1') {
                            PC = Integer.parseInt((Memoria[PC+2]+Memoria[PC+1]), 2);
                        }else{
                            PC = PC +3; 
                        }
                        break;
                    }
                    case"P":{
                        // F2, nn
                        if (regF[7]=='0') {
                            PC = Integer.parseInt((Memoria[PC+2]+Memoria[PC+1]), 2);
                        }else{
                            PC = PC +3; 
                        }
                        break;
                    }
                    case"nn":{
                        // F2, nn
                        PC = Integer.parseInt((Memoria[PC+2]+Memoria[PC+1]), 2);
                        break;
                    }
                    case"(HL)":{
                        // E9
                        PC = Integer.parseInt((Memoria[Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16)]), 2);
                        break;
                    }
                    case"(IX)":{
                        // DD, E9
                        PC = Integer.parseInt((Memoria[Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IX))),16)]), 2);
                        break;
                    }
                    case"(IY)":{
                        // FD, E9
                        PC = Integer.parseInt((Memoria[Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IY))),16)]), 2);
                        break;
                    }                    
                }
                break;
            }
            case "JR":{
                switch(operandos[0]){
                    case"Z":{
                        // 28, d
                        if (regF[6]=='1') {
                            PC = PC+Integer.parseInt(Memoria[PC+1], 2);
                        }else{
                            PC = PC +2; 
                        }
                        break;
                    }
                    case"NZ":{
                        // 20, d
                        if (regF[6]=='0') {
                            PC = PC+Integer.parseInt(Memoria[PC+1], 2);
                        }else{
                            PC = PC +2; 
                        }
                        break;
                    }
                    case"C":{
                        // 38, d
                        if (regF[0]=='1') {
                            PC = PC+Integer.parseInt(Memoria[PC+1], 2);
                        }else{
                            PC = PC +2; 
                        }
                        break;
                    }
                    case"NC":{
                        // 30, d
                        if (regF[0]=='0') {
                            PC = PC+Integer.parseInt(Memoria[PC+1], 2);
                        }else{
                            PC = PC +2; 
                        }
                        break;
                    }
                    case"d":{
                        // 18, d
                        PC = PC+Integer.parseInt(Memoria[PC+1], 2);
                        break;
                    }
                }
                break;
            }
            case "DJNZ":{
                regB = decrementar8bits(regB);
                if (regF[6]=='0') {
                    PC = PC+Integer.parseInt(Memoria[PC+1], 2);
                }else{
                    PC = PC +2; 
                }
                break;
            }
            case "EX":{
                switch(operandos[0]){
                    case"DE":{
                        // DE>>>HL
                        // EB
                        char []arregloIntercambio=regD;
                        regD = regH;
                        regH = arregloIntercambio;
                        
                        arregloIntercambio=regE;
                        regE = regL;
                        regL = arregloIntercambio;                      
                        PC++;
                        break;
                    }
                    case"AF":{
                        // AF>>>A'F'
                        // 08
                        char []arregloIntercambio=regA;
                        regA = regAo;
                        regAo = arregloIntercambio;
                        
                        arregloIntercambio=regF;
                        regF = regFo;
                        regFo = arregloIntercambio;                      
                        PC++;
                        break;
                    }
                    case"(SP)":{
                        switch(operandos[1]){
                            case"HL":{
                                // E3
                                char []arregloIntercambio=regH;
                                regH = toCadenaBinaria(Memoria[SP+1]).toCharArray();
                                Memoria[SP+1] = toCadenaBinaria(Arrays.toString(arregloIntercambio));

                                arregloIntercambio=regL;
                                regL = toCadenaBinaria(Memoria[SP]).toCharArray();
                                Memoria[SP] = toCadenaBinaria(Arrays.toString(arregloIntercambio));                   
                                PC++;
                                break;
                            }
                            case"IX":{
                                // DD,E3
                                char []arregloIntercambio=IX;
                                IX = toCadenaBinaria(Memoria[SP+1]+Memoria[SP]).toCharArray();
                                Memoria[SP+1] = toCadenaBinaria(Arrays.toString(arregloIntercambio)).substring(0,4);
                                Memoria[SP] = toCadenaBinaria(Arrays.toString(arregloIntercambio)).substring(4);                   
                                PC=PC+2;
                                break;
                            }
                            case"IY":{
                                // FD,E3
                                char []arregloIntercambio=IY;
                                IY = toCadenaBinaria(Memoria[SP+1]+Memoria[SP]).toCharArray();
                                Memoria[SP+1] = toCadenaBinaria(Arrays.toString(arregloIntercambio)).substring(0,4);
                                Memoria[SP] = toCadenaBinaria(Arrays.toString(arregloIntercambio)).substring(4);                   
                                PC=PC+2;
                                break;
                            }
                        }
                        
                    }
                }
                break;
            }
            case "EXX":{
                char []arregloIntercambio=regBo;
                regBo = regB;
                regB = arregloIntercambio;
                
                arregloIntercambio=regCo;
                regCo = regC;
                regC = arregloIntercambio;
                
                arregloIntercambio=regDo;
                regDo = regD;
                regD = arregloIntercambio;
                
                arregloIntercambio=regEo;
                regEo = regE;
                regE = arregloIntercambio;
                
                arregloIntercambio=regHo;
                regHo = regH;
                regH = arregloIntercambio;
                
                arregloIntercambio=regLo;
                regLo = regL;
                regL = arregloIntercambio;
                PC++;
                break;
            }
            case "LDI":{
                
                break;
            }
            case "LDIR":{
                
                break;
            }
            case "LDD":{
                
                break;
            }
            case "LDDR":{
                
                break;
            }
            case "CPI":{
                
                break;
            }
            case "CPIR":{
                
                break;
            }
            case "CPD":{
                
                break;
            }
            case "CPDR":{
                
                break;
            }
            case "RLCA":{
                regF[1]= '0';
                regF[4]='0';
                char resultado [] = new char [8];
                regF[0] = regA[7];
                for (int i = 1; i < 8; i++) {
                    resultado [i] = regA[i-1];       
                }
                resultado [0] = regF[0];
                regA = resultado;
                PC++;
                break;
            }
            case "RLA":{
                regF[1]= '0';
                regF[4]='0';
                char resultado [] = new char [8];
                resultado [0] = regF[0];
                regF[0] = regA[7];
                for (int i = 1; i < 8; i++) {
                    resultado [i] = regA[i-1];       
                }
                regA = resultado;
                PC++;
                break;
            }
            case "RRCA":{
                regF[1]= '0';
                regF[4]='0';
                char resultado [] = new char [8];
                regF[0] = regA[0];
                for (int i = 0; i < 7; i++) {
                    resultado [i] = regA[i+1];       
                }
                resultado [7] = regF[0];
                regA = resultado;
                PC++;
                break;
            }
            case "RRA":{
                regF[1]= '0';
                regF[4]='0';
                char resultado [] = new char [8];
                resultado [7] = regF[0];
                regF[0] = regA[0];
                for (int i = 0; i < 7; i++) {
                    resultado [i] = regA[i+1];       
                }
                regA = resultado;
                PC++;
                break;
            }
            case "RLC":{
                switch(operandos[0]){
                    case"A":{
                        regA = RLC(regA);
                        PC = PC + 2;
                        break;
                    }
                    case"B":{
                        regB = RLC(regB);
                        PC = PC + 2;
                        break;
                    }
                    case"C":{
                        regC = RLC(regC);
                        PC = PC + 2;
                        break;
                    }
                    case"D":{
                        regD = RLC(regD);
                        PC = PC + 2;
                        break;
                    }
                    case"E":{
                        regE = RLC(regE);
                        PC = PC + 2;
                        break;
                    }
                    case"H":{
                        regH = RLC(regH);
                        PC = PC + 2;
                        break;
                    }
                    case"L":{
                        regL = RLC(regL);
                        PC = PC + 2;
                        break;
                    }
                    case"(HL)":{
                        char [] arreglo = toCadenaBinaria(Memoria[Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16)]).toCharArray();
                        arreglo = RLC(arreglo);
                        Memoria[Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16)] = toCadenaBinaria(Arrays.toString(arreglo));
                        PC = PC + 2;
                        break;
                    }
                    case"(IX+d)":{
                        int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IX))),16);
                        int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                        if (auxiliar>127) {
                            auxiliar = auxiliar - 256;
                        }
                        dirInderecta = dirInderecta + auxiliar;
                        char [] arreglo =  toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                        arreglo = RLC(arreglo);
                        Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                        PC = PC + 4;
                        break;
                    }
                    case"(IY+d)":{
                        int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IY))),16);
                        int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                        if (auxiliar>127) {
                            auxiliar = auxiliar - 256;
                        }
                        dirInderecta = dirInderecta + auxiliar;
                        char [] arreglo =  toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                        arreglo = RLC(arreglo);
                        Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                        PC = PC + 4;
                        break;
                    }
                }
                break;
            }
            case "RL":{
                switch(operandos[0]){
                    case"A":{
                        regA = RL(regA);
                        PC = PC + 2;
                        break;
                    }
                    case"B":{
                        regB = RL(regB);
                        PC = PC + 2;
                        break;
                    }
                    case"C":{
                        regC = RL(regC);
                        PC = PC + 2;
                        break;
                    }
                    case"D":{
                        regD = RL(regD);
                        PC = PC + 2;
                        break;
                    }
                    case"E":{
                        regE = RL(regE);
                        PC = PC + 2;
                        break;
                    }
                    case"H":{
                        regH = RL(regH);
                        PC = PC + 2;
                        break;
                    }
                    case"L":{
                        regL = RL(regL);
                        PC = PC + 2;
                        break;
                    }
                    case"(HL)":{
                        char [] arreglo = toCadenaBinaria(Memoria[Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16)]).toCharArray();
                        arreglo = RL(arreglo);
                        Memoria[Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16)] = toCadenaBinaria(Arrays.toString(arreglo));
                        PC = PC + 2;
                        break;
                    }
                    case"(IX+d)":{
                        int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IX))),16);
                        int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                        if (auxiliar>127) {
                            auxiliar = auxiliar - 256;
                        }
                        dirInderecta = dirInderecta + auxiliar;
                        char [] arreglo =  toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                        arreglo = RL(arreglo);
                        Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                        PC = PC + 4;
                        break;
                    }
                    case"(IY+d)":{
                        int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IY))),16);
                        int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                        if (auxiliar>127) {
                            auxiliar = auxiliar - 256;
                        }
                        dirInderecta = dirInderecta + auxiliar;
                        char [] arreglo =  toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                        arreglo = RL(arreglo);
                        Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                        PC = PC + 4;
                        break;
                    }
                }
                break;
            }
            case "RRC":{
                switch(operandos[0]){
                    case"A":{
                        regA = RRC(regA);
                        PC = PC + 2;
                        break;
                    }
                    case"B":{
                        regB = RRC(regB);
                        PC = PC + 2;
                        break;
                    }
                    case"C":{
                        regC = RRC(regC);
                        PC = PC + 2;
                        break;
                    }
                    case"D":{
                        regD = RRC(regD);
                        PC = PC + 2;
                        break;
                    }
                    case"E":{
                        regE = RRC(regE);
                        PC = PC + 2;
                        break;
                    }
                    case"H":{
                        regH = RRC(regH);
                        PC = PC + 2;
                        break;
                    }
                    case"L":{
                        regL = RRC(regL);
                        PC = PC + 2;
                        break;
                    }
                    case"(HL)":{
                        char [] arreglo = toCadenaBinaria(Memoria[Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16)]).toCharArray();
                        arreglo = RRC(arreglo);
                        Memoria[Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16)] = toCadenaBinaria(Arrays.toString(arreglo));
                        PC = PC + 2;
                        break;
                    }
                    case"(IX+d)":{
                        int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IX))),16);
                        int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                        if (auxiliar>127) {
                            auxiliar = auxiliar - 256;
                        }
                        dirInderecta = dirInderecta + auxiliar;
                        char [] arreglo =  toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                        arreglo = RRC(arreglo);
                        Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                        PC = PC + 4;
                        break;
                    }
                    case"(IY+d)":{
                        int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IY))),16);
                        int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                        if (auxiliar>127) {
                            auxiliar = auxiliar - 256;
                        }
                        dirInderecta = dirInderecta + auxiliar;
                        char [] arreglo =  toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                        arreglo = RRC(arreglo);
                        Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                        PC = PC + 4;
                        break;
                    }
                }
                break;
            }
            case "RR":{
                switch(operandos[0]){
                    case"A":{
                        regA = RR(regA);
                        PC = PC + 2;
                        break;
                    }
                    case"B":{
                        regB = RR(regB);
                        PC = PC + 2;
                        break;
                    }
                    case"C":{
                        regC = RR(regC);
                        PC = PC + 2;
                        break;
                    }
                    case"D":{
                        regD = RR(regD);
                        PC = PC + 2;
                        break;
                    }
                    case"E":{
                        regE = RR(regE);
                        PC = PC + 2;
                        break;
                    }
                    case"H":{
                        regH = RR(regH);
                        PC = PC + 2;
                        break;
                    }
                    case"L":{
                        regL = RR(regL);
                        PC = PC + 2;
                        break;
                    }
                    case"(HL)":{
                        char [] arreglo = toCadenaBinaria(Memoria[Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16)]).toCharArray();
                        arreglo = RR(arreglo);
                        Memoria[Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16)] = toCadenaBinaria(Arrays.toString(arreglo));
                        PC = PC + 2;
                        break;
                    }
                    case"(IX+d)":{
                        int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IX))),16);
                        int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                        if (auxiliar>127) {
                            auxiliar = auxiliar - 256;
                        }
                        dirInderecta = dirInderecta + auxiliar;
                        char [] arreglo =  toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                        arreglo = RR(arreglo);
                        Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                        PC = PC + 4;
                        break;
                    }
                    case"(IY+d)":{
                        int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IY))),16);
                        int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                        if (auxiliar>127) {
                            auxiliar = auxiliar - 256;
                        }
                        dirInderecta = dirInderecta + auxiliar;
                        char [] arreglo =  toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                        arreglo = RR(arreglo);
                        Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                        PC = PC + 4;
                        break;
                    }
                }
                break;
            }
            case "SLA":{
                switch(operandos[0]){
                    case"A":{
                        regA = SLA(regA);
                        PC = PC + 2;
                        break;
                    }
                    case"B":{
                        regB = SLA(regB);
                        PC = PC + 2;
                        break;
                    }
                    case"C":{
                        regC = SLA(regC);
                        PC = PC + 2;
                        break;
                    }
                    case"D":{
                        regD = SLA(regD);
                        PC = PC + 2;
                        break;
                    }
                    case"E":{
                        regE = SLA(regE);
                        PC = PC + 2;
                        break;
                    }
                    case"H":{
                        regH = SLA(regH);
                        PC = PC + 2;
                        break;
                    }
                    case"L":{
                        regL = SLA(regL);
                        PC = PC + 2;
                        break;
                    }
                    case"(HL)":{
                        char [] arreglo = toCadenaBinaria(Memoria[Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16)]).toCharArray();
                        arreglo = SLA(arreglo);
                        Memoria[Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16)] = toCadenaBinaria(Arrays.toString(arreglo));
                        PC = PC + 2;
                        break;
                    }
                    case"(IX+d)":{
                        int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IX))),16);
                        int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                        if (auxiliar>127) {
                            auxiliar = auxiliar - 256;
                        }
                        dirInderecta = dirInderecta + auxiliar;
                        char [] arreglo =  toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                        arreglo = SLA(arreglo);
                        Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                        PC = PC + 4;
                        break;
                    }
                    case"(IY+d)":{
                        int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IY))),16);
                        int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                        if (auxiliar>127) {
                            auxiliar = auxiliar - 256;
                        }
                        dirInderecta = dirInderecta + auxiliar;
                        char [] arreglo =  toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                        arreglo = SLA(arreglo);
                        Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                        PC = PC + 4;
                        break;
                    }
                }
                break;
            }
            case "SRA":{
                switch(operandos[0]){
                    case"A":{
                        regA = SRA(regA);
                        PC = PC + 2;
                        break;
                    }
                    case"B":{
                        regB = SRA(regB);
                        PC = PC + 2;
                        break;
                    }
                    case"C":{
                        regC = SRA(regC);
                        PC = PC + 2;
                        break;
                    }
                    case"D":{
                        regD = SRA(regD);
                        PC = PC + 2;
                        break;
                    }
                    case"E":{
                        regE = SRA(regE);
                        PC = PC + 2;
                        break;
                    }
                    case"H":{
                        regH = SRA(regH);
                        PC = PC + 2;
                        break;
                    }
                    case"L":{
                        regL = SRA(regL);
                        PC = PC + 2;
                        break;
                    }
                    case"(HL)":{
                        char [] arreglo = toCadenaBinaria(Memoria[Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16)]).toCharArray();
                        arreglo = SRA(arreglo);
                        Memoria[Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16)] = toCadenaBinaria(Arrays.toString(arreglo));
                        PC = PC + 2;
                        break;
                    }
                    case"(IX+d)":{
                        int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IX))),16);
                        int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                        if (auxiliar>127) {
                            auxiliar = auxiliar - 256;
                        }
                        dirInderecta = dirInderecta + auxiliar;
                        char [] arreglo =  toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                        arreglo = SRA(arreglo);
                        Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                        PC = PC + 4;
                        break;
                    }
                    case"(IY+d)":{
                        int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IY))),16);
                        int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                        if (auxiliar>127) {
                            auxiliar = auxiliar - 256;
                        }
                        dirInderecta = dirInderecta + auxiliar;
                        char [] arreglo =  toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                        arreglo = SRA(arreglo);
                        Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                        PC = PC + 4;
                        break;
                    }
                }
                break;
            }
            case "SRL":{
                switch(operandos[0]){
                    case"A":{
                        regA = SRL(regA);
                        PC = PC + 2;
                        break;
                    }
                    case"B":{
                        regB = SRL(regB);
                        PC = PC + 2;
                        break;
                    }
                    case"C":{
                        regC = SRL(regC);
                        PC = PC + 2;
                        break;
                    }
                    case"D":{
                        regD = SRL(regD);
                        PC = PC + 2;
                        break;
                    }
                    case"E":{
                        regE = SRL(regE);
                        PC = PC + 2;
                        break;
                    }
                    case"H":{
                        regH = SRL(regH);
                        PC = PC + 2;
                        break;
                    }
                    case"L":{
                        regL = SRL(regL);
                        PC = PC + 2;
                        break;
                    }
                    case"(HL)":{
                        char [] arreglo = toCadenaBinaria(Memoria[Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16)]).toCharArray();
                        arreglo = SRL(arreglo);
                        Memoria[Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16)] = toCadenaBinaria(Arrays.toString(arreglo));
                        PC = PC + 2;
                        break;
                    }
                    case"(IX+d)":{
                        int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IX))),16);
                        int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                        if (auxiliar>127) {
                            auxiliar = auxiliar - 256;
                        }
                        dirInderecta = dirInderecta + auxiliar;
                        char [] arreglo =  toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                        arreglo = SRL(arreglo);
                        Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                        PC = PC + 4;
                        break;
                    }
                    case"(IY+d)":{
                        int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IY))),16);
                        int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                        if (auxiliar>127) {
                            auxiliar = auxiliar - 256;
                        }
                        dirInderecta = dirInderecta + auxiliar;
                        char [] arreglo =  toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                        arreglo = SRL(arreglo);
                        Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                        PC = PC + 4;
                        break;
                    }
                }
                break;
            }
            case "RLD":{
                regF[1]= '0';
                regF[4]='0';
                char [] arreglo = toCadenaBinaria(Memoria[Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16)]).toCharArray();
                arreglo = RLC(arreglo);
                char resultado [] = new char [8];
                resultado [0] = regF[0];
                regF[0] = regA[7];
                for (int i = 0; i < 4; i++) {
                    resultado[i+4]=arreglo[i];
                    resultado[i]=regA[i];
                }
                for (int i = 0; i < 4; i++) {
                    regA[i]=arreglo[i+4];
                }
                regF[7]=regA[7];
                regF[2]='0';
                if (Arrays.equals("00000000".toCharArray(),regA)) {
                    regF[6]='1';
                }else{
                    regF[6]='0';
                }
                Memoria[Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16)] = toCadenaBinaria(Arrays.toString(resultado));
                PC = PC + 2;
                break;
            }
            case "RRD":{
                regF[1]= '0';
                regF[4]='0';
                char [] arreglo = toCadenaBinaria(Memoria[Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16)]).toCharArray();
                arreglo = RLC(arreglo);
                char resultado [] = new char [8];
                resultado [0] = regF[0];
                regF[0] = regA[7];
                for (int i = 0; i < 4; i++) {
                    resultado[i]=arreglo[i+4];
                    resultado[i+4]=regA[i];
                }
                for (int i = 0; i < 4; i++) {
                    regA[i]=arreglo[i];
                }
                regF[7]=regA[7];
                regF[2]='0';
                if (Arrays.equals("00000000".toCharArray(),regA)) {
                    regF[6]='1';
                }else{
                    regF[6]='0';
                }
                Memoria[Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16)] = toCadenaBinaria(Arrays.toString(resultado));
                PC = PC + 2;
                break;
            }
            case "BIT":{
                switch(operandos[0]){
                    case"0":{
                        switch(operandos[1]){
                            case"A":{
                                if (regA[0]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"B":{
                                if (regB[0]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"C":{
                                if (regC[0]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"D":{
                                if (regD[0]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"E":{
                                if (regE[0]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"H":{
                                if (regH[0]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"L":{
                                if (regL[0]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"(HL)":{
                                char [] arreglo = toCadenaBinaria(Memoria[Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16)]).toCharArray();
                                if (arreglo[0]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"(IX+d)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IX))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                char [] arreglo =  toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                if (arreglo[0]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 4;
                                break;
                            }
                            case"(IY+d)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IY))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                char [] arreglo =  toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                if (arreglo[0]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 4;
                                break;
                            }
                        }
                        break;
                    }
                    case"1":{
                        switch(operandos[1]){
                            case"A":{
                                if (regA[1]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"B":{
                                if (regB[1]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"C":{
                                if (regC[1]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"D":{
                                if (regD[1]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"E":{
                                if (regE[1]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"H":{
                                if (regH[1]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"L":{
                                if (regL[1]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"(HL)":{
                                char [] arreglo = toCadenaBinaria(Memoria[Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16)]).toCharArray();
                                if (arreglo[1]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"(IX+d)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IX))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                char [] arreglo =  toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                if (arreglo[1]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 4;
                                break;
                            }
                            case"(IY+d)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IY))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                char [] arreglo =  toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                if (arreglo[1]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 4;
                                break;
                            }
                        }
                        break;
                    }
                    case"2":{
                        switch(operandos[1]){
                            case"A":{
                                if (regA[2]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"B":{
                                if (regB[2]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"C":{
                                if (regC[2]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"D":{
                                if (regD[2]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"E":{
                                if (regE[2]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"H":{
                                if (regH[2]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"L":{
                                if (regL[2]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"(HL)":{
                                char [] arreglo = toCadenaBinaria(Memoria[Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16)]).toCharArray();
                                if (arreglo[2]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"(IX+d)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IX))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                char [] arreglo =  toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                if (arreglo[2]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 4;
                                break;
                            }
                            case"(IY+d)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IY))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                char [] arreglo =  toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                if (arreglo[2]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 4;
                                break;
                            }
                        }
                        break;
                    }
                    case"3":{
                        switch(operandos[1]){
                            case"A":{
                                if (regA[3]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"B":{
                                if (regB[3]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"C":{
                                if (regC[3]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"D":{
                                if (regD[3]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"E":{
                                if (regE[3]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"H":{
                                if (regH[3]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"L":{
                                if (regL[3]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"(HL)":{
                                char [] arreglo = toCadenaBinaria(Memoria[Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16)]).toCharArray();
                                if (arreglo[3]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"(IX+d)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IX))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                char [] arreglo =  toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                if (arreglo[3]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 4;
                                break;
                            }
                            case"(IY+d)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IY))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                char [] arreglo =  toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                if (arreglo[3]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 4;
                                break;
                            }
                        }
                        break;
                    }
                    case"4":{
                        switch(operandos[1]){
                            case"A":{
                                if (regA[4]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"B":{
                                if (regB[4]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"C":{
                                if (regC[4]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"D":{
                                if (regD[4]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"E":{
                                if (regE[4]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"H":{
                                if (regH[4]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"L":{
                                if (regL[4]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"(HL)":{
                                char [] arreglo = toCadenaBinaria(Memoria[Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16)]).toCharArray();
                                if (arreglo[4]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"(IX+d)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IX))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                char [] arreglo =  toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                if (arreglo[4]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 4;
                                break;
                            }
                            case"(IY+d)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IY))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                char [] arreglo =  toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                if (arreglo[4]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 4;
                                break;
                            }
                        }
                        break;
                    }
                    case"5":{
                        switch(operandos[1]){
                            case"A":{
                                if (regA[5]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"B":{
                                if (regB[5]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"C":{
                                if (regC[5]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"D":{
                                if (regD[5]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"E":{
                                if (regE[5]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"H":{
                                if (regH[5]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"L":{
                                if (regL[5]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"(HL)":{
                                char [] arreglo = toCadenaBinaria(Memoria[Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16)]).toCharArray();
                                if (arreglo[5]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"(IX+d)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IX))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                char [] arreglo =  toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                if (arreglo[5]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 4;
                                break;
                            }
                            case"(IY+d)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IY))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                char [] arreglo =  toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                if (arreglo[5]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 4;
                                break;
                            }
                        }
                        break;
                    }
                    case"6":{
                        switch(operandos[1]){
                            case"A":{
                                if (regA[6]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"B":{
                                if (regB[6]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"C":{
                                if (regC[6]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"D":{
                                if (regD[6]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"E":{
                                if (regE[6]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"H":{
                                if (regH[6]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"L":{
                                if (regL[6]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"(HL)":{
                                char [] arreglo = toCadenaBinaria(Memoria[Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16)]).toCharArray();
                                if (arreglo[6]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"(IX+d)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IX))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                char [] arreglo =  toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                if (arreglo[6]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 4;
                                break;
                            }
                            case"(IY+d)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IY))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                char [] arreglo =  toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                if (arreglo[6]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 4;
                                break;
                            }
                        }
                        break;
                    }
                    case"7":{
                        switch(operandos[1]){
                            case"A":{
                                if (regA[7]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"B":{
                                if (regB[7]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"C":{
                                if (regC[7]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"D":{
                                if (regD[7]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"E":{
                                if (regE[7]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"H":{
                                if (regH[7]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"L":{
                                if (regL[7]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"(HL)":{
                                char [] arreglo = toCadenaBinaria(Memoria[Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16)]).toCharArray();
                                if (arreglo[7]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 2;
                                break;
                            }
                            case"(IX+d)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IX))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                char [] arreglo =  toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                if (arreglo[7]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 4;
                                break;
                            }
                            case"(IY+d)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IY))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                char [] arreglo =  toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                if (arreglo[7]=='1') {
                                    regF[6] = '0';
                                }else{
                                    regF[6] = '1';
                                }
                                regF[4] = '1';
                                regF[2] = '0';
                                PC = PC + 4;
                                break;
                            }
                        }
                        break;
                    }
                }
                break;
            }
            case "SET ":{
                switch(operandos[0]){
                    case"0":{
                        switch(operandos[1]){
                            case"A":{
                                regA[0]='1';
                                PC = PC + 2;
                                break;
                            }
                            case"B":{
                                regB[0]='1';
                                PC = PC + 2;
                                break;
                            }
                            case"C":{
                                regC[0]='1';
                                PC = PC + 2;
                                break;
                            }
                            case"D":{
                                regD[0]='1';
                                PC = PC + 2;
                                break;
                            }
                            case"E":{
                                regE[0]='1';
                                PC = PC + 2;
                                break;
                            }
                            case"H":{
                                regH[0]='1';
                                PC = PC + 2;
                                break;
                            }
                            case"L":{
                                regL[0]='1';
                                PC = PC + 2;
                                break;
                            }
                            case"(HL)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16);
                                char [] arreglo = toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                arreglo[0]='1';
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                                PC = PC + 2;
                                break;
                            }
                            case"(IX+d)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IX))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                char [] arreglo = toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                arreglo[0]='1';
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                                PC = PC + 4;
                                break;
                            }
                            case"(IY+d)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IY))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                char [] arreglo = toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                arreglo[0]='1';
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                                PC = PC + 4;
                                break;
                            }
                        }
                        break;
                    }
                    case"1":{
                        switch(operandos[1]){
                            case"A":{
                                regA[1]='1';
                                PC = PC + 2;
                                break;
                            }
                            case"B":{
                                regB[1]='1';
                                PC = PC + 2;
                                break;
                            }
                            case"C":{
                                regC[1]='1';
                                PC = PC + 2;
                                break;
                            }
                            case"D":{
                                regD[1]='1';
                                PC = PC + 2;
                                break;
                            }
                            case"E":{
                                regE[1]='1';
                                PC = PC + 2;
                                break;
                            }
                            case"H":{
                                regH[1]='1';
                                PC = PC + 2;
                                break;
                            }
                            case"L":{
                                regL[1]='1';
                                PC = PC + 2;
                                break;
                            }
                            case"(HL)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16);
                                char [] arreglo = toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                arreglo[1]='1';
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                                PC = PC + 2;
                                break;
                            }
                            case"(IX+d)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IX))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                char [] arreglo = toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                arreglo[1]='1';
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                                PC = PC + 4;
                                break;
                            }
                            case"(IY+d)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IY))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                char [] arreglo = toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                arreglo[1]='1';
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                                PC = PC + 4;
                                break;
                            }
                        }
                        break;
                    }
                    case"2":{
                        switch(operandos[1]){
                            case"A":{
                                regA[2]='1';
                                PC = PC + 2;
                                break;
                            }
                            case"B":{
                                regB[2]='1';
                                PC = PC + 2;
                                break;
                            }
                            case"C":{
                                regC[2]='1';
                                PC = PC + 2;
                                break;
                            }
                            case"D":{
                                regD[2]='1';
                                PC = PC + 2;
                                break;
                            }
                            case"E":{
                                regE[2]='1';
                                PC = PC + 2;
                                break;
                            }
                            case"H":{
                                regH[2]='1';
                                PC = PC + 2;
                                break;
                            }
                            case"L":{
                                regL[2]='1';
                                PC = PC + 2;
                                break;
                            }
                            case"(HL)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16);
                                char [] arreglo = toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                arreglo[2]='1';
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                                PC = PC + 2;
                                break;
                            }
                            case"(IX+d)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IX))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                char [] arreglo = toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                arreglo[2]='1';
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                                PC = PC + 4;
                                break;
                            }
                            case"(IY+d)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IY))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                char [] arreglo = toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                arreglo[2]='1';
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                                PC = PC + 4;
                                break;
                            }
                        }
                        break;
                    }
                    case"3":{
                        switch(operandos[1]){
                            case"A":{
                                regA[3]='1';
                                PC = PC + 2;
                                break;
                            }
                            case"B":{
                                regB[3]='1';
                                PC = PC + 2;
                                break;
                            }
                            case"C":{
                                regC[3]='1';
                                PC = PC + 2;
                                break;
                            }
                            case"D":{
                                regD[3]='1';
                                PC = PC + 2;
                                break;
                            }
                            case"E":{
                                regE[3]='1';
                                PC = PC + 2;
                                break;
                            }
                            case"H":{
                                regH[3]='1';
                                PC = PC + 2;
                                break;
                            }
                            case"L":{
                                regL[3]='1';
                                PC = PC + 2;
                                break;
                            }
                            case"(HL)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16);
                                char [] arreglo = toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                arreglo[3]='1';
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                                PC = PC + 2;
                                break;
                            }
                            case"(IX+d)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IX))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                char [] arreglo = toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                arreglo[3]='1';
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                                PC = PC + 4;
                                break;
                            }
                            case"(IY+d)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IY))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                char [] arreglo = toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                arreglo[3]='1';
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                                PC = PC + 4;
                                break;
                            }
                        }
                        break;
                    }
                    case"4":{
                        switch(operandos[1]){
                            case"A":{
                                regA[4]='1';
                                PC = PC + 2;
                                break;
                            }
                            case"B":{
                                regB[4]='1';
                                PC = PC + 2;
                                break;
                            }
                            case"C":{
                                regC[4]='1';
                                PC = PC + 2;
                                break;
                            }
                            case"D":{
                                regD[4]='1';
                                PC = PC + 2;
                                break;
                            }
                            case"E":{
                                regE[4]='1';
                                PC = PC + 2;
                                break;
                            }
                            case"H":{
                                regH[4]='1';
                                PC = PC + 2;
                                break;
                            }
                            case"L":{
                                regL[4]='1';
                                PC = PC + 2;
                                break;
                            }
                            case"(HL)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16);
                                char [] arreglo = toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                arreglo[4]='1';
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                                PC = PC + 2;
                                break;
                            }
                            case"(IX+d)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IX))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                char [] arreglo = toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                arreglo[4]='1';
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                                PC = PC + 4;
                                break;
                            }
                            case"(IY+d)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IY))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                char [] arreglo = toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                arreglo[4]='1';
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                                PC = PC + 4;
                                break;
                            }
                        }
                        break;
                    }
                    case"5":{
                        switch(operandos[5]){
                            case"A":{
                                regA[5]='1';
                                PC = PC + 2;
                                break;
                            }
                            case"B":{
                                regB[5]='1';
                                PC = PC + 2;
                                break;
                            }
                            case"C":{
                                regC[5]='1';
                                PC = PC + 2;
                                break;
                            }
                            case"D":{
                                regD[5]='1';
                                PC = PC + 2;
                                break;
                            }
                            case"E":{
                                regE[5]='1';
                                PC = PC + 2;
                                break;
                            }
                            case"H":{
                                regH[5]='1';
                                PC = PC + 2;
                                break;
                            }
                            case"L":{
                                regL[5]='1';
                                PC = PC + 2;
                                break;
                            }
                            case"(HL)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16);
                                char [] arreglo = toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                arreglo[5]='1';
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                                PC = PC + 2;
                                break;
                            }
                            case"(IX+d)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IX))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                char [] arreglo = toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                arreglo[5]='1';
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                                PC = PC + 4;
                                break;
                            }
                            case"(IY+d)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IY))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                char [] arreglo = toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                arreglo[5]='1';
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                                PC = PC + 4;
                                break;
                            }
                        }
                        break;
                    }
                    case"6":{
                        switch(operandos[1]){
                            case"A":{
                                regA[6]='1';
                                PC = PC + 2;
                                break;
                            }
                            case"B":{
                                regB[6]='1';
                                PC = PC + 2;
                                break;
                            }
                            case"C":{
                                regC[6]='1';
                                PC = PC + 2;
                                break;
                            }
                            case"D":{
                                regD[6]='1';
                                PC = PC + 2;
                                break;
                            }
                            case"E":{
                                regE[6]='1';
                                PC = PC + 2;
                                break;
                            }
                            case"H":{
                                regH[6]='1';
                                PC = PC + 2;
                                break;
                            }
                            case"L":{
                                regL[6]='1';
                                PC = PC + 2;
                                break;
                            }
                            case"(HL)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16);
                                char [] arreglo = toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                arreglo[6]='1';
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                                PC = PC + 2;
                                break;
                            }
                            case"(IX+d)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IX))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                char [] arreglo = toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                arreglo[6]='1';
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                                PC = PC + 4;
                                break;
                            }
                            case"(IY+d)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IY))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                char [] arreglo = toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                arreglo[6]='1';
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                                PC = PC + 4;
                                break;
                            }
                        }
                        break;
                    }
                    case"7":{
                        switch(operandos[1]){
                            case"A":{
                                regA[7]='1';
                                PC = PC + 2;
                                break;
                            }
                            case"B":{
                                regB[7]='1';
                                PC = PC + 2;
                                break;
                            }
                            case"C":{
                                regC[7]='1';
                                PC = PC + 2;
                                break;
                            }
                            case"D":{
                                regD[7]='1';
                                PC = PC + 2;
                                break;
                            }
                            case"E":{
                                regE[7]='1';
                                PC = PC + 2;
                                break;
                            }
                            case"H":{
                                regH[7]='1';
                                PC = PC + 2;
                                break;
                            }
                            case"L":{
                                regL[7]='1';
                                PC = PC + 2;
                                break;
                            }
                            case"(HL)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16);
                                char [] arreglo = toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                arreglo[7]='1';
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                                PC = PC + 2;
                                break;
                            }
                            case"(IX+d)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IX))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                char [] arreglo = toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                arreglo[7]='1';
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                                PC = PC + 4;
                                break;
                            }
                            case"(IY+d)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IY))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                char [] arreglo = toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                arreglo[7]='1';
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                                PC = PC + 4;
                                break;
                            }
                        }
                        break;
                    }
                }
                break;
            }
            case "RES":{
                switch(operandos[0]){
                    case"0":{
                        switch(operandos[1]){
                            case"A":{
                                regA[0]='0';
                                PC = PC + 2;
                                break;
                            }
                            case"B":{
                                regB[0]='0';
                                PC = PC + 2;
                                break;
                            }
                            case"C":{
                                regC[0]='0';
                                PC = PC + 2;
                                break;
                            }
                            case"D":{
                                regD[0]='0';
                                PC = PC + 2;
                                break;
                            }
                            case"E":{
                                regE[0]='0';
                                PC = PC + 2;
                                break;
                            }
                            case"H":{
                                regH[0]='0';
                                PC = PC + 2;
                                break;
                            }
                            case"L":{
                                regL[0]='0';
                                PC = PC + 2;
                                break;
                            }
                            case"(HL)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16);
                                char [] arreglo = toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                arreglo[0]='0';
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                                PC = PC + 2;
                                break;
                            }
                            case"(IX+d)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IX))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                char [] arreglo = toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                arreglo[0]='0';
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                                PC = PC + 4;
                                break;
                            }
                            case"(IY+d)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IY))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                char [] arreglo = toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                arreglo[0]='0';
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                                PC = PC + 4;
                                break;
                            }
                        }
                        break;
                    }
                    case"1":{
                        switch(operandos[1]){
                            case"A":{
                                regA[1]='0';
                                PC = PC + 2;
                                break;
                            }
                            case"B":{
                                regB[1]='0';
                                PC = PC + 2;
                                break;
                            }
                            case"C":{
                                regC[1]='0';
                                PC = PC + 2;
                                break;
                            }
                            case"D":{
                                regD[1]='0';
                                PC = PC + 2;
                                break;
                            }
                            case"E":{
                                regE[1]='0';
                                PC = PC + 2;
                                break;
                            }
                            case"H":{
                                regH[1]='0';
                                PC = PC + 2;
                                break;
                            }
                            case"L":{
                                regL[1]='0';
                                PC = PC + 2;
                                break;
                            }
                            case"(HL)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16);
                                char [] arreglo = toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                arreglo[1]='0';
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                                PC = PC + 2;
                                break;
                            }
                            case"(IX+d)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IX))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                char [] arreglo = toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                arreglo[1]='0';
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                                PC = PC + 4;
                                break;
                            }
                            case"(IY+d)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IY))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                char [] arreglo = toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                arreglo[1]='0';
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                                PC = PC + 4;
                                break;
                            }
                        }
                        break;
                    }
                    case"2":{
                        switch(operandos[1]){
                            case"A":{
                                regA[2]='0';
                                PC = PC + 2;
                                break;
                            }
                            case"B":{
                                regB[2]='0';
                                PC = PC + 2;
                                break;
                            }
                            case"C":{
                                regC[2]='0';
                                PC = PC + 2;
                                break;
                            }
                            case"D":{
                                regD[2]='0';
                                PC = PC + 2;
                                break;
                            }
                            case"E":{
                                regE[2]='0';
                                PC = PC + 2;
                                break;
                            }
                            case"H":{
                                regH[2]='0';
                                PC = PC + 2;
                                break;
                            }
                            case"L":{
                                regL[2]='0';
                                PC = PC + 2;
                                break;
                            }
                            case"(HL)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16);
                                char [] arreglo = toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                arreglo[2]='0';
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                                PC = PC + 2;
                                break;
                            }
                            case"(IX+d)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IX))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                char [] arreglo = toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                arreglo[2]='0';
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                                PC = PC + 4;
                                break;
                            }
                            case"(IY+d)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IY))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                char [] arreglo = toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                arreglo[2]='0';
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                                PC = PC + 4;
                                break;
                            }
                        }
                        break;
                    }
                    case"3":{
                        switch(operandos[1]){
                            case"A":{
                                regA[3]='0';
                                PC = PC + 2;
                                break;
                            }
                            case"B":{
                                regB[3]='0';
                                PC = PC + 2;
                                break;
                            }
                            case"C":{
                                regC[3]='0';
                                PC = PC + 2;
                                break;
                            }
                            case"D":{
                                regD[3]='0';
                                PC = PC + 2;
                                break;
                            }
                            case"E":{
                                regE[3]='0';
                                PC = PC + 2;
                                break;
                            }
                            case"H":{
                                regH[3]='0';
                                PC = PC + 2;
                                break;
                            }
                            case"L":{
                                regL[3]='0';
                                PC = PC + 2;
                                break;
                            }
                            case"(HL)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16);
                                char [] arreglo = toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                arreglo[3]='0';
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                                PC = PC + 2;
                                break;
                            }
                            case"(IX+d)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IX))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                char [] arreglo = toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                arreglo[3]='0';
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                                PC = PC + 4;
                                break;
                            }
                            case"(IY+d)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IY))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                char [] arreglo = toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                arreglo[3]='0';
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                                PC = PC + 4;
                                break;
                            }
                        }
                        break;
                    }
                    case"4":{
                        switch(operandos[1]){
                            case"A":{
                                regA[4]='0';
                                PC = PC + 2;
                                break;
                            }
                            case"B":{
                                regB[4]='0';
                                PC = PC + 2;
                                break;
                            }
                            case"C":{
                                regC[4]='0';
                                PC = PC + 2;
                                break;
                            }
                            case"D":{
                                regD[4]='0';
                                PC = PC + 2;
                                break;
                            }
                            case"E":{
                                regE[4]='0';
                                PC = PC + 2;
                                break;
                            }
                            case"H":{
                                regH[4]='0';
                                PC = PC + 2;
                                break;
                            }
                            case"L":{
                                regL[4]='0';
                                PC = PC + 2;
                                break;
                            }
                            case"(HL)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16);
                                char [] arreglo = toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                arreglo[4]='0';
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                                PC = PC + 2;
                                break;
                            }
                            case"(IX+d)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IX))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                char [] arreglo = toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                arreglo[4]='0';
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                                PC = PC + 4;
                                break;
                            }
                            case"(IY+d)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IY))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                char [] arreglo = toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                arreglo[4]='0';
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                                PC = PC + 4;
                                break;
                            }
                        }
                        break;
                    }
                    case"5":{
                        switch(operandos[5]){
                            case"A":{
                                regA[5]='0';
                                PC = PC + 2;
                                break;
                            }
                            case"B":{
                                regB[5]='0';
                                PC = PC + 2;
                                break;
                            }
                            case"C":{
                                regC[5]='0';
                                PC = PC + 2;
                                break;
                            }
                            case"D":{
                                regD[5]='0';
                                PC = PC + 2;
                                break;
                            }
                            case"E":{
                                regE[5]='0';
                                PC = PC + 2;
                                break;
                            }
                            case"H":{
                                regH[5]='0';
                                PC = PC + 2;
                                break;
                            }
                            case"L":{
                                regL[5]='0';
                                PC = PC + 2;
                                break;
                            }
                            case"(HL)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16);
                                char [] arreglo = toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                arreglo[5]='0';
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                                PC = PC + 2;
                                break;
                            }
                            case"(IX+d)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IX))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                char [] arreglo = toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                arreglo[5]='0';
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                                PC = PC + 4;
                                break;
                            }
                            case"(IY+d)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IY))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                char [] arreglo = toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                arreglo[5]='0';
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                                PC = PC + 4;
                                break;
                            }
                        }
                        break;
                    }
                    case"6":{
                        switch(operandos[1]){
                            case"A":{
                                regA[6]='0';
                                PC = PC + 2;
                                break;
                            }
                            case"B":{
                                regB[6]='0';
                                PC = PC + 2;
                                break;
                            }
                            case"C":{
                                regC[6]='0';
                                PC = PC + 2;
                                break;
                            }
                            case"D":{
                                regD[6]='0';
                                PC = PC + 2;
                                break;
                            }
                            case"E":{
                                regE[6]='0';
                                PC = PC + 2;
                                break;
                            }
                            case"H":{
                                regH[6]='0';
                                PC = PC + 2;
                                break;
                            }
                            case"L":{
                                regL[6]='0';
                                PC = PC + 2;
                                break;
                            }
                            case"(HL)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16);
                                char [] arreglo = toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                arreglo[6]='0';
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                                PC = PC + 2;
                                break;
                            }
                            case"(IX+d)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IX))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                char [] arreglo = toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                arreglo[6]='0';
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                                PC = PC + 4;
                                break;
                            }
                            case"(IY+d)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IY))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                char [] arreglo = toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                arreglo[6]='0';
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                                PC = PC + 4;
                                break;
                            }
                        }
                        break;
                    }
                    case"7":{
                        switch(operandos[1]){
                            case"A":{
                                regA[7]='0';
                                PC = PC + 2;
                                break;
                            }
                            case"B":{
                                regB[7]='0';
                                PC = PC + 2;
                                break;
                            }
                            case"C":{
                                regC[7]='0';
                                PC = PC + 2;
                                break;
                            }
                            case"D":{
                                regD[7]='0';
                                PC = PC + 2;
                                break;
                            }
                            case"E":{
                                regE[7]='0';
                                PC = PC + 2;
                                break;
                            }
                            case"H":{
                                regH[7]='0';
                                PC = PC + 2;
                                break;
                            }
                            case"L":{
                                regL[7]='0';
                                PC = PC + 2;
                                break;
                            }
                            case"(HL)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16);
                                char [] arreglo = toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                arreglo[7]='0';
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                                PC = PC + 2;
                                break;
                            }
                            case"(IX+d)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IX))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                char [] arreglo = toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                arreglo[7]='0';
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                                PC = PC + 4;
                                break;
                            }
                            case"(IY+d)":{
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IY))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                char [] arreglo = toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                arreglo[7]='0';
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(arreglo));
                                PC = PC + 4;
                                break;
                            }
                        }
                        break;
                    }
                }
                break;
            }
            case "CALL":{
                String PChexadecimal="";
                switch(operandos[0]){
                    case"Z":{
                        // CC, nn
                        if (regF[6]=='1') {
                            PChexadecimal = conversorINTtoHEXA(PC);
                            SP = SP -1;
                            Memoria[SP]= toCadenaBinaria(Arrays.toString(conversorHEXAtoBIN(PChexadecimal.substring(0, 2))));
                            SP = SP -1;
                            Memoria[SP]= toCadenaBinaria(Arrays.toString(conversorHEXAtoBIN(PChexadecimal.substring(2))));
                            PC = Integer.parseInt((Memoria[PC+2]+Memoria[PC+1]), 2);
                        }else{
                            PC = PC +3; 
                        }
                        break;
                    }
                    case"NZ":{
                        // C4, nn
                        if (regF[6]=='0') {
                            PChexadecimal = conversorINTtoHEXA(PC);
                            SP = SP -1;
                            Memoria[SP]= toCadenaBinaria(Arrays.toString(conversorHEXAtoBIN(PChexadecimal.substring(0, 2))));
                            SP = SP -1;
                            Memoria[SP]= toCadenaBinaria(Arrays.toString(conversorHEXAtoBIN(PChexadecimal.substring(2))));
                            PC = Integer.parseInt((Memoria[PC+2]+Memoria[PC+1]), 2);
                        }else{
                            PC = PC +3; 
                        }
                        break;
                    }
                    case"C":{
                        // DC, nn
                        if (regF[0]=='1') {
                            PChexadecimal = conversorINTtoHEXA(PC);
                            SP = SP -1;
                            Memoria[SP]= toCadenaBinaria(Arrays.toString(conversorHEXAtoBIN(PChexadecimal.substring(0, 2))));
                            SP = SP -1;
                            Memoria[SP]= toCadenaBinaria(Arrays.toString(conversorHEXAtoBIN(PChexadecimal.substring(2))));
                            PC = Integer.parseInt((Memoria[PC+2]+Memoria[PC+1]), 2);
                        }else{
                            PC = PC +3; 
                        }
                        break;
                    }
                    case"NC":{
                        // D4, nn
                        if (regF[0]=='0') {
                            PChexadecimal = conversorINTtoHEXA(PC);
                            SP = SP -1;
                            Memoria[SP]= toCadenaBinaria(Arrays.toString(conversorHEXAtoBIN(PChexadecimal.substring(0, 2))));
                            SP = SP -1;
                            Memoria[SP]= toCadenaBinaria(Arrays.toString(conversorHEXAtoBIN(PChexadecimal.substring(2))));
                            PC = Integer.parseInt((Memoria[PC+2]+Memoria[PC+1]), 2);
                        }else{
                            PC = PC +3; 
                        }
                        break;
                    }
                    case"PE":{
                        // EC, nn
                        if (regF[2]=='1') {
                            PChexadecimal = conversorINTtoHEXA(PC);
                            SP = SP -1;
                            Memoria[SP]= toCadenaBinaria(Arrays.toString(conversorHEXAtoBIN(PChexadecimal.substring(0, 2))));
                            SP = SP -1;
                            Memoria[SP]= toCadenaBinaria(Arrays.toString(conversorHEXAtoBIN(PChexadecimal.substring(2))));
                            PC = Integer.parseInt((Memoria[PC+2]+Memoria[PC+1]), 2);
                        }else{
                            PC = PC +3; 
                        }
                        break;
                    }
                    case"PO":{
                        // E4, nn
                        if (regF[2]=='0') {
                            PChexadecimal = conversorINTtoHEXA(PC);
                            SP = SP -1;
                            Memoria[SP]= toCadenaBinaria(Arrays.toString(conversorHEXAtoBIN(PChexadecimal.substring(0, 2))));
                            SP = SP -1;
                            Memoria[SP]= toCadenaBinaria(Arrays.toString(conversorHEXAtoBIN(PChexadecimal.substring(2))));
                            PC = Integer.parseInt((Memoria[PC+2]+Memoria[PC+1]), 2);
                        }else{
                            PC = PC +3; 
                        }
                        break;
                    }
                    case"M":{
                        // FC, nn
                        if (regF[7]=='1') {
                            PChexadecimal = conversorINTtoHEXA(PC);
                            SP = SP -1;
                            Memoria[SP]= toCadenaBinaria(Arrays.toString(conversorHEXAtoBIN(PChexadecimal.substring(0, 2))));
                            SP = SP -1;
                            Memoria[SP]= toCadenaBinaria(Arrays.toString(conversorHEXAtoBIN(PChexadecimal.substring(2))));
                            PC = Integer.parseInt((Memoria[PC+2]+Memoria[PC+1]), 2);
                        }else{
                            PC = PC +3; 
                        }
                        break;
                    }
                    case"P":{
                        // F4, nn
                        if (regF[6]=='0') {
                            PChexadecimal = conversorINTtoHEXA(PC);
                            SP = SP -1;
                            Memoria[SP]= toCadenaBinaria(Arrays.toString(conversorHEXAtoBIN(PChexadecimal.substring(0, 2))));
                            SP = SP -1;
                            Memoria[SP]= toCadenaBinaria(Arrays.toString(conversorHEXAtoBIN(PChexadecimal.substring(2))));
                            PC = Integer.parseInt((Memoria[PC+2]+Memoria[PC+1]), 2);
                        }else{
                            PC = PC +3; 
                        }
                        break;
                    }
                    case"nn":{
                        // CD, nn
                        PChexadecimal = conversorINTtoHEXA(PC);
                        SP = SP -1;
                        Memoria[SP]= toCadenaBinaria(Arrays.toString(conversorHEXAtoBIN(PChexadecimal.substring(0, 2))));
                        SP = SP -1;
                        Memoria[SP]= toCadenaBinaria(Arrays.toString(conversorHEXAtoBIN(PChexadecimal.substring(2))));
                        PC = Integer.parseInt((Memoria[PC+2]+Memoria[PC+1]), 2);
                        break;
                    }                    
                }
                break;
            }
            case "RET":{
                String programCounter="";
                switch(operandos[0]){
                    case"Z":{
                        // C8
                        if (regF[6]=='1') {
                            programCounter = Memoria[SP];
                            SP++;
                            programCounter = programCounter+Memoria[SP];
                            SP++;
                            PC = Integer.parseInt(programCounter, 2);
                        }else{
                            PC++; 
                        }
                        break;
                    }
                    case"NZ":{
                        // C0
                        if (regF[6]=='0') {
                            programCounter = Memoria[SP];
                            SP++;
                            programCounter = programCounter+Memoria[SP];
                            SP++;
                            PC = Integer.parseInt(programCounter, 2);
                        }else{
                            PC++; 
                        }
                        break;
                    }
                    case"C":{
                        // D8
                        if (regF[0]=='1') {
                            programCounter = Memoria[SP];
                            SP++;
                            programCounter = programCounter+Memoria[SP];
                            SP++;
                            PC = Integer.parseInt(programCounter, 2);
                        }else{
                            PC++; 
                        }
                        break;
                    }
                    case"NC":{
                        // D0
                        if (regF[0]=='0') {
                            programCounter = Memoria[SP];
                            SP++;
                            programCounter = programCounter+Memoria[SP];
                            SP++;
                            PC = Integer.parseInt(programCounter, 2);
                        }else{
                            PC++; 
                        }
                        break;
                    }
                    case"PE":{
                        // E8
                        if (regF[2]=='1') {
                            programCounter = Memoria[SP];
                            SP++;
                            programCounter = programCounter+Memoria[SP];
                            SP++;
                            PC = Integer.parseInt(programCounter, 2);
                        }else{
                            PC++; 
                        }
                        break;
                    }
                    case"PO":{
                        // E0
                        if (regF[2]=='0') {
                            programCounter = Memoria[SP];
                            SP++;
                            programCounter = programCounter+Memoria[SP];
                            SP++;
                            PC = Integer.parseInt(programCounter, 2);
                        }else{
                            PC++; 
                        }
                        break;
                    }
                    case"M":{
                        // F8
                        if (regF[7]=='1') {
                            programCounter = Memoria[SP];
                            SP++;
                            programCounter = programCounter+Memoria[SP];
                            SP++;
                            PC = Integer.parseInt(programCounter, 2);
                        }else{
                            PC++; 
                        }
                        break;
                    }
                    case"P":{
                        // F0
                        if (regF[6]=='0') {
                            programCounter = Memoria[SP];
                            SP++;
                            programCounter = programCounter+Memoria[SP];
                            SP++;
                            PC = Integer.parseInt(programCounter, 2);
                        }else{
                            PC++; 
                        }
                        break;
                    }
                    case"nn":{
                        // C9
                        programCounter = Memoria[SP];
                        SP++;
                        programCounter = programCounter+Memoria[SP];
                        SP++;
                        PC = Integer.parseInt(programCounter, 2);
                        break;
                    }
                }
                break;
            }
            case "RETI":{
                //
                //
                break;
            }
            case "RETN":{
                //
                //
                break;
            }
            case "RST":{
                String PChexadecimal="";
                switch(operandos[0]){
                    case "00":{
                        PChexadecimal = conversorINTtoHEXA(PC);
                        SP = SP -1;
                        Memoria[SP]= toCadenaBinaria(Arrays.toString(conversorHEXAtoBIN(PChexadecimal.substring(0, 2))));
                        SP = SP -1;
                        Memoria[SP]= toCadenaBinaria(Arrays.toString(conversorHEXAtoBIN(PChexadecimal.substring(2))));
                        PC = Integer.parseInt("0000", 16);
                    }
                    case "08":{
                        PChexadecimal = conversorINTtoHEXA(PC);
                        SP = SP -1;
                        Memoria[SP]= toCadenaBinaria(Arrays.toString(conversorHEXAtoBIN(PChexadecimal.substring(0, 2))));
                        SP = SP -1;
                        Memoria[SP]= toCadenaBinaria(Arrays.toString(conversorHEXAtoBIN(PChexadecimal.substring(2))));
                        PC = Integer.parseInt("0008", 16);
                    }
                    case "10":{
                        PChexadecimal = conversorINTtoHEXA(PC);
                        SP = SP -1;
                        Memoria[SP]= toCadenaBinaria(Arrays.toString(conversorHEXAtoBIN(PChexadecimal.substring(0, 2))));
                        SP = SP -1;
                        Memoria[SP]= toCadenaBinaria(Arrays.toString(conversorHEXAtoBIN(PChexadecimal.substring(2))));
                        PC = Integer.parseInt("0010", 16);
                    }
                    case "18":{
                        PChexadecimal = conversorINTtoHEXA(PC);
                        SP = SP -1;
                        Memoria[SP]= toCadenaBinaria(Arrays.toString(conversorHEXAtoBIN(PChexadecimal.substring(0, 2))));
                        SP = SP -1;
                        Memoria[SP]= toCadenaBinaria(Arrays.toString(conversorHEXAtoBIN(PChexadecimal.substring(2))));
                        PC = Integer.parseInt("0018", 16);
                    }
                    case "20":{
                        PChexadecimal = conversorINTtoHEXA(PC);
                        SP = SP -1;
                        Memoria[SP]= toCadenaBinaria(Arrays.toString(conversorHEXAtoBIN(PChexadecimal.substring(0, 2))));
                        SP = SP -1;
                        Memoria[SP]= toCadenaBinaria(Arrays.toString(conversorHEXAtoBIN(PChexadecimal.substring(2))));
                        PC = Integer.parseInt("0020", 16);
                    }
                    case "28":{
                        PChexadecimal = conversorINTtoHEXA(PC);
                        SP = SP -1;
                        Memoria[SP]= toCadenaBinaria(Arrays.toString(conversorHEXAtoBIN(PChexadecimal.substring(0, 2))));
                        SP = SP -1;
                        Memoria[SP]= toCadenaBinaria(Arrays.toString(conversorHEXAtoBIN(PChexadecimal.substring(2))));
                        PC = Integer.parseInt("0028", 16);
                    }
                    case "30":{
                        PChexadecimal = conversorINTtoHEXA(PC);
                        SP = SP -1;
                        Memoria[SP]= toCadenaBinaria(Arrays.toString(conversorHEXAtoBIN(PChexadecimal.substring(0, 2))));
                        SP = SP -1;
                        Memoria[SP]= toCadenaBinaria(Arrays.toString(conversorHEXAtoBIN(PChexadecimal.substring(2))));
                        PC = Integer.parseInt("0030", 16);
                    }
                    case "38":{
                        PChexadecimal = conversorINTtoHEXA(PC);
                        SP = SP -1;
                        Memoria[SP]= toCadenaBinaria(Arrays.toString(conversorHEXAtoBIN(PChexadecimal.substring(0, 2))));
                        SP = SP -1;
                        Memoria[SP]= toCadenaBinaria(Arrays.toString(conversorHEXAtoBIN(PChexadecimal.substring(2))));
                        PC = Integer.parseInt("0038", 16);
                    }
                }
                break;
            }
            case "IN":{
                switch(operandos[0]){
                    case "A":{
                        switch(operandos[1]){
                            case"(C)":{
                                regA = inputs();
                                PC = PC+2;
                                break;
                            }
                            default:{
                                char [] aux = toCadenaBinaria(Memoria[PC+1]).toCharArray();
                                for (int i = 0; i < 8; i++) {
                                    direcciones [i] = aux[i];
                                    direcciones [i+8] = regA[i];
                                }
                                int dir = Integer.parseInt(toCadenaBinaria(Arrays.toString(aux)), 2);
                                DataBus = toCadenaBinaria(IO[dir]).toCharArray();
                                regA = DataBus;
                                PC = PC+2;
                                break;
                            }
                        }
                        break;
                    }
                    case "B":{
                        regB = inputs();
                        PC = PC+2;
                        break;
                    }
                    case "C":{
                        regC = inputs();
                        PC = PC+2;
                        break;
                    }
                    case "D":{
                        regD = inputs();
                        PC = PC+2;
                        break;
                    }
                    case "E":{
                        regE = inputs();
                        PC = PC+2;
                        break;
                    }
                    case "H":{
                        regH = inputs();
                        PC = PC+2;
                        break;
                    }
                    case "L":{
                        regL = inputs();
                        PC = PC+2;
                        break;
                    }
                }
                break;
            }
            case "INI":{
                
                break;
            }
            case "INIR":{
                
                break;
            }
            case "INDR":{
                
                break;
            }
            case "OUT":{
                switch(operandos[1]){
                    case "A":{
                        switch(operandos[0]){
                            case"(C)":{
                                String datos [] = outputs(regA);
                                IO[Integer.parseInt(datos[0])] = datos[1];
                                PC = PC+2;
                                break;
                            }
                            default:{
                                char [] aux = toCadenaBinaria(Memoria[PC+1]).toCharArray();
                                for (int i = 0; i < 8; i++) {
                                    direcciones [i] = aux[i];
                                    direcciones [i+8] = regA[i];
                                }
                                int dir = Integer.parseInt(toCadenaBinaria(Arrays.toString(aux)), 2);
                                DataBus = regA;
                                IO[dir] = toCadenaBinaria(Arrays.toString(DataBus));
                                PC = PC+2;
                                break;
                            }
                        }
                        break;
                    }
                    case "B":{
                        String datos [] = outputs(regB);
                        IO[Integer.parseInt(datos[0])] = datos[1];
                        PC = PC+2;
                        break;
                    }
                    case "C":{
                        String datos [] = outputs(regC);
                        IO[Integer.parseInt(datos[0])] = datos[1];
                        PC = PC+2;
                        break;
                    }
                    case "D":{
                        String datos [] = outputs(regD);
                        IO[Integer.parseInt(datos[0])] = datos[1];
                        PC = PC+2;
                        break;
                    }
                    case "E":{
                        String datos [] = outputs(regE);
                        IO[Integer.parseInt(datos[0])] = datos[1];
                        PC = PC+2;
                        break;
                    }
                    case "H":{
                        String datos [] = outputs(regH);
                        IO[Integer.parseInt(datos[0])] = datos[1];
                        PC = PC+2;
                        break;
                    }
                    case "L":{
                        String datos [] = outputs(regL);
                        IO[Integer.parseInt(datos[0])] = datos[1];
                        PC = PC+2;
                        break;
                    }
                }
                break;
            }
            case "OUTI":{
                
                break;
            }
            case "OTIR":{
                
                break;
            }
            case "OUTD":{
                
                break;
            }
            case "OTDR":{
                
                break;
            }
            case "NOP":{
                
                break;
            }
            case "HALT":{
                regF[3]='1';
                break;
            }
            case "DI":{
                
                break;
            }
            case "EI":{
                
                break;
            }
            case "IM":{
                
                break;
            }
            case "EQU":{
                
                break;
            }
            case "DEFB":{
                
                break;
            }
            case "DEFW":{
                
                break;
            }
            case "DEFS":{
                
                break;
            }
            case "DEFM":{
                
                break;
            }
            case "IF":{
                
                break;
            }
            case "ELSE":{
                
                break;
            }
            case "END":{
                regF[3]='1';
                break;
            }
            case "E":{
                
                break;
            }
            case "Hs":{
                
                break;
            }
            case "S":{
                
                break;
            }
            case "L-":{
                
                break;
            }
            case "L+":{
                
                break;
            }
            case "D-":{
                
                break;
            }
            case "D+":{
                
                break;
            }
            case "C-":{
                
                break;
            }
            case "C+":{
                
                break;
            }
            case "F":{
                
                break;
            }
            case "ORG":{
                direccionInicial = Integer.parseInt(operandosFuente, 16);
                auxDireccion = direccionInicial;
                break;
            }
        }
    }
    
    public static void LDop(String operandos[]){
        switch(operandos[0]){
                    case "A":{
                        switch(operandos[1]){
                            case "A":{
                                //
                                regA = regA ;
                                PC++;
                                break;
                            }
                            case "B":{
                                //
                                regA = regB ;
                                PC++;
                                break;
                            }
                            case "C":{
                                //
                                regA = regC ;
                                PC++;
                                break;
                            }
                            case "D":{
                                //
                                regA = regD ;
                                PC++;
                                break;
                            }
                            case "E":{
                                //
                                regA = regE ;
                                PC++;
                                break;
                            }
                            case "H":{
                                //
                                regA = regH ;
                                PC++;
                                break;
                            }
                            case "L":{
                                //
                                regA = regL ;
                                PC++;
                                break;
                            }
                            case "(HL)":{
                                //
                                regA =  toCadenaBinaria(Memoria[Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16)]).toCharArray();
                                PC++;
                                break;
                            }
                            case "(IX+d)":{
                                //
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IX))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                buffer = conversorBINtoHEXA(Memoria[PC+2]);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                regA =  toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                buffer = conversorBINtoHEXA(Memoria[dirInderecta]);
                                PC= PC+3;
                                break;
                            }
                            case "(IY+d)":{
                                //
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IY))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                buffer = conversorBINtoHEXA(Memoria[PC+2]);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                regA =  toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                buffer = conversorBINtoHEXA(Memoria[dirInderecta]);
                                PC= PC+3;
                                break;
                            }
                            case "(BC)":{
                                //
                                regA =  toCadenaBinaria(Memoria[Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regB))+toCadenaBinaria(Arrays.toString(regC))),16)]).toCharArray();
                                PC++;
                                break;
                            }
                            case "(DE)":{
                                //
                                regA =  toCadenaBinaria(Memoria[Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regD))+toCadenaBinaria(Arrays.toString(regE))),16)]).toCharArray();
                                PC++;
                                break;
                            }
                            case "(nn)":{
                                //
                                regA =  toCadenaBinaria(Memoria[Integer.parseInt(conversorBINtoHEXA(Memoria[PC+1]+Memoria[PC+2]),16)]).toCharArray();
                                PC= PC+3;
                                break;
                            }
                            case "n":{
                                //
                                regA =  toCadenaBinaria(Memoria[PC+1]).toCharArray();
                                PC= PC+2;
                                break;
                            }
                            case "I":{
                                //
                                //
                                break;
                            }
                            case "R":{
                                //
                                //
                                break;
                            }
                        }
                        break;
                    }
                    case "B":{
                        switch(operandos[1]){
                            case "A":{
                                //
                                regB = regA ;
                                PC++;
                                break;
                            }
                            case "B":{
                                //
                                regB = regB ;
                                PC++;
                                break;
                            }
                            case "C":{
                                //
                                regB = regC ;
                                PC++;
                                break;
                            }
                            case "D":{
                                //
                                regB = regD ;
                                PC++;
                                break;
                            }
                            case "E":{
                                //
                                regB = regE ;
                                PC++;
                                break;
                            }
                            case "H":{
                                //
                                regB = regH ;
                                PC++;
                                break;
                            }
                            case "L":{
                                //
                                regB = regL ;
                                PC++;
                                break;
                            }
                            case "(HL)":{
                                //
                                regB =  toCadenaBinaria(Memoria[Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16)]).toCharArray();
                                PC++;
                                break;
                            }
                            case "(IX+d)":{
                                //
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IX))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                regB =  toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                PC= PC+3;
                                break;
                            }
                            case "(IY+d)":{
                                //
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IY))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                regB =  toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                PC= PC+3;
                                break;
                            }
                            case "n":{
                                //
                                regB =  toCadenaBinaria(Memoria[PC+1]).toCharArray();
                                buffer = conversorBINtoHEXA(Memoria[PC+1]);
                                PC= PC+2;
                                break;
                            }
                        }
                        break;
                    }
                    case "C":{
                        switch(operandos[1]){
                            case "A":{
                                //
                                regC = regA ;
                                PC++;
                                break;
                            }
                            case "B":{
                                //
                                regC = regB ;
                                PC++;
                                break;
                            }
                            case "C":{
                                //
                                regC = regC ;
                                PC++;
                                break;
                            }
                            case "D":{
                                //
                                regC = regD ;
                                PC++;
                                break;
                            }
                            case "E":{
                                //
                                regC = regE ;
                                PC++;
                                break;
                            }
                            case "H":{
                                //
                                regC = regH ;
                                PC++;
                                break;
                            }
                            case "L":{
                                //
                                regC = regL ;
                                PC++;
                                break;
                            }
                            case "(HL)":{
                                //
                                regC =  toCadenaBinaria(Memoria[Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16)]).toCharArray();
                                PC++;
                                break;
                            }
                            case "(IX+d)":{
                                //
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IX))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                regC =  toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                PC= PC+3;
                                break;
                            }
                            case "(IY+d)":{
                                //
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IY))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                regC =  toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                PC= PC+3;
                                break;
                            }
                            case "n":{
                                //
                                regC =  toCadenaBinaria(Memoria[PC+1]).toCharArray();
                                buffer = conversorBINtoHEXA(Memoria[PC+1]);
                                PC= PC+2;
                                break;
                            }
                        }
                        break;
                    }
                    case "D":{
                        switch(operandos[1]){
                            case "A":{
                                //
                                regD = regA ;
                                PC++;
                                break;
                            }
                            case "B":{
                                //
                                regD = regB ;
                                PC++;
                                break;
                            }
                            case "C":{
                                //
                                regD = regC ;
                                PC++;
                                break;
                            }
                            case "D":{
                                //
                                regD = regD ;
                                PC++;
                                break;
                            }
                            case "E":{
                                //
                                regD = regE ;
                                PC++;
                                break;
                            }
                            case "H":{
                                //
                                regD = regH ;
                                PC++;
                                break;
                            }
                            case "L":{
                                //
                                regD = regL ;
                                PC++;
                                break;
                            }
                            case "(HL)":{
                                //
                                regD =  toCadenaBinaria(Memoria[Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16)]).toCharArray();
                                PC++;
                                break;
                            }
                            case "(IX+d)":{
                                //
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IX))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                regD =  toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                PC= PC+3;
                                break;
                            }
                            case "(IY+d)":{
                                //
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IY))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                regD =  toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                PC= PC+3;
                                break;
                            }
                            case "n":{
                                //
                                regD =  toCadenaBinaria(Memoria[PC+1]).toCharArray();
                                buffer = conversorBINtoHEXA(Memoria[PC+1]);
                                PC= PC+2;
                                break;
                            }
                        }
                        break;
                    }
                    case "E":{
                        switch(operandos[1]){
                            case "A":{
                                //
                                regE = regA ;
                                PC++;
                                break;
                            }
                            case "B":{
                                //
                                regE = regB ;
                                PC++;
                                break;
                            }
                            case "C":{
                                //
                                regE = regC ;
                                PC++;
                                break;
                            }
                            case "D":{
                                //
                                regE = regD ;
                                PC++;
                                break;
                            }
                            case "E":{
                                //
                                regE = regE ;
                                PC++;
                                break;
                            }
                            case "H":{
                                //
                                regE = regH ;
                                PC++;
                                break;
                            }
                            case "L":{
                                //
                                regE = regL ;
                                PC++;
                                break;
                            }
                            case "(HL)":{
                                //
                                regE =  toCadenaBinaria(Memoria[Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16)]).toCharArray();
                                PC++;
                                break;
                            }
                            case "(IX+d)":{
                                //
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IX))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                regE =  toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                PC= PC+3;
                                break;
                            }
                            case "(IY+d)":{
                                //
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IY))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                regE =  toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                PC= PC+3;
                                break;
                            }
                            case "n":{
                                //
                                regE =  toCadenaBinaria(Memoria[PC+1]).toCharArray();
                                buffer = conversorBINtoHEXA(Memoria[PC+1]);
                                PC= PC+2;
                                break;
                            }
                        }
                        break;
                    }
                    case "H":{
                        switch(operandos[1]){
                            case "A":{
                                //
                                regH = regA ;
                                PC++;
                                break;
                            }
                            case "B":{
                                //
                                regH = regB ;
                                PC++;
                                break;
                            }
                            case "C":{
                                //
                                regH = regC ;
                                PC++;
                                break;
                            }
                            case "D":{
                                //
                                regH = regD ;
                                PC++;
                                break;
                            }
                            case "E":{
                                //
                                regH = regE ;
                                PC++;
                                break;
                            }
                            case "H":{
                                //
                                regH = regH ;
                                PC++;
                                break;
                            }
                            case "L":{
                                //
                                regH = regL ;
                                PC++;
                                break;
                            }
                            case "(HL)":{
                                //
                                regH =  toCadenaBinaria(Memoria[Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16)]).toCharArray();
                                PC++;
                                break;
                            }
                            case "(IX+d)":{
                                //
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IX))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                regH =  toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                PC= PC+3;
                                break;
                            }
                            case "(IY+d)":{
                                //
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IY))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                regH =  toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                PC= PC+3;
                                break;
                            }
                            case "n":{
                                //
                                regH =  toCadenaBinaria(Memoria[PC+1]).toCharArray();
                                buffer = conversorBINtoHEXA(Memoria[PC+1]);
                                PC= PC+2;
                                break;
                            }
                        }
                        break;
                    }
                    case "L":{
                        switch(operandos[1]){
                            case "A":{
                                //
                                regL = regA ;
                                PC++;
                                break;
                            }
                            case "B":{
                                //
                                regL = regB ;
                                PC++;
                                break;
                            }
                            case "C":{
                                //
                                regL = regC ;
                                PC++;
                                break;
                            }
                            case "D":{
                                //
                                regL = regD ;
                                PC++;
                                break;
                            }
                            case "E":{
                                //
                                regL = regE ;
                                PC++;
                                break;
                            }
                            case "H":{
                                //
                                regL = regH ;
                                PC++;
                                break;
                            }
                            case "L":{
                                //
                                regL = regL ;
                                PC++;
                                break;
                            }
                            case "(HL)":{
                                //
                                regL =  toCadenaBinaria(Memoria[Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16)]).toCharArray();
                                PC++;
                                break;
                            }
                            case "(IX+d)":{
                                //
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IX))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                regL =  toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                PC= PC+3;
                                break;
                            }
                            case "(IY+d)":{
                                //
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IY))),16);
                                int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                                if (auxiliar>127) {
                                    auxiliar = auxiliar - 256;
                                }
                                dirInderecta = dirInderecta + auxiliar;
                                regL =  toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                PC= PC+3;
                                break;
                            }
                            case "n":{
                                //
                                regL =  toCadenaBinaria(Memoria[PC+1]).toCharArray();
                                buffer = conversorBINtoHEXA(Memoria[PC+1]);
                                PC= PC+2;
                                break;
                            }
                        }
                        break;
                    }
                    case "(HL)":{
                        switch(operandos[1]){
                            case "A":{
                                //
                                Memoria[Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16)] = toCadenaBinaria(Arrays.toString(regA));
                                PC++;
                                break;
                            }
                            case "B":{
                                //
                                Memoria[Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16)] = toCadenaBinaria(Arrays.toString(regB));
                                PC++;
                                break;
                            }
                            case "C":{
                                //
                                Memoria[Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16)] = toCadenaBinaria(Arrays.toString(regC));
                                PC++;
                                break;
                            }
                            case "D":{
                                //
                                Memoria[Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16)] = toCadenaBinaria(Arrays.toString(regD));
                                PC++;
                                break;
                            }
                            case "E":{
                                //
                                Memoria[Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16)] = toCadenaBinaria(Arrays.toString(regE));
                                PC++;
                                break;
                            }
                            case "H":{
                                //
                                Memoria[Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16)] = toCadenaBinaria(Arrays.toString(regH));
                                PC++;
                                break;
                            }
                            case "L":{
                                //
                                Memoria[Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16)] = toCadenaBinaria(Arrays.toString(regL));
                                PC++;
                                break;
                            }
                            case "n":{
                                //
                                Memoria[Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH))+toCadenaBinaria(Arrays.toString(regL))),16)] = Memoria[PC+1];
                                buffer = conversorBINtoHEXA(Memoria[PC+1]);
                                PC++;
                                break;
                            }
                        }
                        break;
                    }
                    case "(IX+d)":{
                        //
                        int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IX))),16);
                        int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                        if (auxiliar>127) {
                            auxiliar = auxiliar - 256;
                        }
                        dirInderecta = dirInderecta + auxiliar;
                                
                        switch(operandos[1]){
                            case "A":{
                                //
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(regA));
                                PC= PC+3;
                                break;
                            }
                            case "B":{
                                //
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(regB));
                                PC= PC+3;
                                break;
                            }
                            case "C":{
                                //
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(regC));
                                PC= PC+3;
                                break;
                            }
                            case "D":{
                                //
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(regD));
                                PC= PC+3;
                                break;
                            }
                            case "E":{
                                //
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(regE));
                                PC= PC+3;
                                break;
                            }
                            case "H":{
                                //
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(regH));
                                PC= PC+3;
                                break;
                            }
                            case "L":{
                                //
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(regL));
                                PC= PC+3;
                                break;
                            }
                            case "n":{
                                //
                                Memoria[dirInderecta] = Memoria[PC+3];
                                buffer = conversorBINtoHEXA(Memoria[PC+3]);
                                PC= PC+4;
                                break;
                            }
                        }
                        break;
                    }
                    case "(IY+d)":{
                        //
                        int dirInderecta = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IY))),16);
                        int auxiliar = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]),16);
                        if (auxiliar>127) {
                            auxiliar = auxiliar - 256;
                        }
                        dirInderecta = dirInderecta + auxiliar;
                                
                        switch(operandos[1]){
                            case "A":{
                                //
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(regA));
                                PC= PC+3;
                                break;
                            }
                            case "B":{
                                //
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(regB));
                                PC= PC+3;
                                break;
                            }
                            case "C":{
                                //
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(regC));
                                PC= PC+3;
                                break;
                            }
                            case "D":{
                                //
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(regD));
                                PC= PC+3;
                                break;
                            }
                            case "E":{
                                //
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(regE));
                                PC= PC+3;
                                break;
                            }
                            case "H":{
                                //
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(regH));
                                PC= PC+3;
                                break;
                            }
                            case "L":{
                                //
                                Memoria[dirInderecta] = toCadenaBinaria(Arrays.toString(regL));
                                PC= PC+3;
                                break;
                            }
                            case "n":{
                                //
                                Memoria[dirInderecta] = Memoria[PC+3];
                                PC= PC+4;
                                break;
                            }
                        }
                        break;
                    }
                    case "(BC)":{
                        //
                        Memoria[Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regB))+toCadenaBinaria(Arrays.toString(regC))),16)] = toCadenaBinaria(Arrays.toString(regA));
                        PC++;
                        break;
                    }
                    case "(DE)":{
                        //
                        Memoria[Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regD))+toCadenaBinaria(Arrays.toString(regE))),16)] = toCadenaBinaria(Arrays.toString(regA));
                        PC++;
                        break;
                    }
                    case "I":{
                        //
                        I = regA;
                        break;
                    }
                    case "R":{
                        //
                        R = regA;
                        break;
                    }
                    case "BC":{
                        switch(operandos[1]){
                            case "nn":{
                                //
                                System.out.println(PC);
                                regB = toCadenaBinaria(Memoria[PC+2]).toCharArray();
                                regC = toCadenaBinaria(Memoria[PC+1]).toCharArray();
                                System.out.println(PC);
                                PC = PC+3;
                                break;
                            }
                            case "(nn)":{
                                //
                                System.out.println("entra a los parentesis");
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+3]+Memoria[PC+2]),16);
                                regB = toCadenaBinaria(Memoria[dirInderecta+1]).toCharArray();
                                regC = toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                PC= PC+4;
                                break;
                            }
                        }
                        break;
                    }
                    case "DE":{
                        switch(operandos[1]){
                            case "nn":{
                                //
                                regD = toCadenaBinaria(Memoria[PC+2]).toCharArray();
                                regE = toCadenaBinaria(Memoria[PC+1]).toCharArray();
                                PC = PC+3;
                                break;
                            }
                            case "(nn)":{
                                //
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+3]+Memoria[PC+2]),16);
                                regD = toCadenaBinaria(Memoria[dirInderecta+1]).toCharArray();
                                regE = toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                PC= PC+4;
                                break;
                            }
                        }
                        break;
                    }
                    case "HL":{
                        switch(operandos[1]){
                            case "nn":{
                                //
                                regH = toCadenaBinaria(Memoria[PC+2]).toCharArray();
                                regL = toCadenaBinaria(Memoria[PC+1]).toCharArray();
                                PC = PC+3;
                                break;
                            }
                            case "(nn)":{
                                //
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]+Memoria[PC+1]),16);
                                regB = toCadenaBinaria(Memoria[dirInderecta+1]).toCharArray();
                                regC = toCadenaBinaria(Memoria[dirInderecta]).toCharArray();
                                PC= PC+4;
                                break;
                            }
                        }
                        break;
                    }
                    case "IX":{
                        switch(operandos[1]){
                            case "nn":{
                                //
                                IX = toCadenaBinaria(Memoria[PC+3]+Memoria[PC+2]).toCharArray();
                                PC = PC+4;
                                break;
                            }
                            case "(nn)":{
                                //
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+3]+Memoria[PC+2]),16);
                                IX = toCadenaBinaria(Memoria[dirInderecta+1]+Memoria[dirInderecta]).toCharArray();
                                PC= PC+4;
                                break;
                            }
                        }
                        break;
                    }
                    case "IY":{
                        switch(operandos[1]){
                            case "nn":{
                                //
                                IY = toCadenaBinaria(Memoria[PC+3]+Memoria[PC+2]).toCharArray();
                                PC = PC+4;
                                break;
                            }
                            case "(nn)":{
                                //
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+3]+Memoria[PC+2]),16);
                                IY = toCadenaBinaria(Memoria[dirInderecta+1]+Memoria[dirInderecta]).toCharArray();
                                PC= PC+4;
                                break;
                            }
                        }
                        break;
                    }
                    case "SP":{
                        switch(operandos[1]){
                            case "HL":{
                                //
                                SP = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(regH)) + toCadenaBinaria(Arrays.toString(regL))),16);
                                PC++;
                                break;
                            }
                            case "IX":{
                                //
                                SP = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IX))),16);
                                PC = PC+2;
                                break;
                            }
                            case "IY":{
                                //
                                SP = Integer.parseInt(conversorBINtoHEXA(toCadenaBinaria(Arrays.toString(IY))),16);
                                PC = PC+2;
                                break;
                            }
                            case "nn":{
                                //
                                SP = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]+Memoria[PC+1]),16);
                                PC = PC+3;
                                break;
                            }
                            case "(nn)":{
                                //
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+3]+Memoria[PC+2]),16);
                                SP = Integer.parseInt(conversorBINtoHEXA(Memoria[dirInderecta+1]+Memoria[dirInderecta]),16);
                                PC= PC+4;
                                break;
                            }
                        }
                        break;
                    }
                    case "(nn)":{
                        switch(operandos[1]){
                            case "HL":{
                                //
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]+Memoria[PC+1]),16);
                                Memoria[dirInderecta]= toCadenaBinaria(Arrays.toString(regL));
                                Memoria[dirInderecta+1]= toCadenaBinaria(Arrays.toString(regH));
                                PC= PC+3;
                                break;
                            }
                            case "BC":{
                                //
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+3]+Memoria[PC+2]),16);
                                Memoria[dirInderecta]= toCadenaBinaria(Arrays.toString(regC));
                                Memoria[dirInderecta+1]= toCadenaBinaria(Arrays.toString(regB));
                                PC= PC+4;
                                break;
                            }
                            case "DE":{
                                //
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+3]+Memoria[PC+2]),16);
                                Memoria[dirInderecta]= toCadenaBinaria(Arrays.toString(regE));
                                Memoria[dirInderecta+1]= toCadenaBinaria(Arrays.toString(regD));
                                PC= PC+4;
                                break;
                            }
                            case "SP":{
                                //
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+3]+Memoria[PC+2]),16);
                                String SPaux = Integer.toHexString(SP);
                                switch(SPaux.length()){
                                    case 1:{
                                        SPaux = "000"+SPaux;
                                        break;
                                    }
                                    case 2:{
                                        SPaux = "00"+SPaux;
                                        break;
                                    }
                                    case 3:{
                                        SPaux = "0"+SPaux;
                                        break;
                                    }
                                }
                                SPaux = toCadenaBinaria(Arrays.toString(conversorHEXAtoBIN(SPaux)));
                                Memoria[dirInderecta]= SPaux.substring(8);
                                Memoria[dirInderecta+1]= SPaux.substring(0,8);
                                PC= PC+3;
                                break;
                            }
                            case "IX":{
                                //
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+3]+Memoria[PC+2]),16);
                                String SPaux = toCadenaBinaria(Arrays.toString(IX));
                                Memoria[dirInderecta]= SPaux.substring(8);
                                Memoria[dirInderecta+1]= SPaux.substring(0,8);
                                PC= PC+3;
                                break;
                            }
                            case "IY":{
                                //
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+3]+Memoria[PC+2]),16);
                                String SPaux = toCadenaBinaria(Arrays.toString(IY));
                                Memoria[dirInderecta]= SPaux.substring(8);
                                Memoria[dirInderecta+1]= SPaux.substring(0,8);
                                PC= PC+3;
                                break;
                            }
                            case "A":{
                                //
                                int dirInderecta = Integer.parseInt(conversorBINtoHEXA(Memoria[PC+2]+Memoria[PC+1]),16);
                                String SPaux = toCadenaBinaria(Arrays.toString(regA));
                                Memoria[dirInderecta]= SPaux;
                                PC= PC+3;
                                break;
                            }
                        }
                        break;
                    }
                }
    }
    
    public static String [] isntruccionFuente(String llave){
        String [] instruccion= {"",""};
        String [] auxiliar = llave.split("\t");
        String [] auxiliar2;
        String auxiliar3="";
        llave = llave.replace("\t", " ");
        do {            
           if (InstruccionesCompilador.containsKey(llave)) {
                instruccion[0] = InstruccionesCompilador.get(llave); 
                break;
            }else{
               //System.out.println(llave);
               auxiliar2= auxiliar[1].split(",");
                if (auxiliar2.length==1) {
                    if (etiquetas.containsKey(auxiliar[1]))  {
                        if (auxiliar[1].contains("(")) {
                            if (InstruccionesCompilador.containsKey(auxiliar[0]+" (nn)")) {
                            instruccion[0] = InstruccionesCompilador.get(auxiliar[0]+" (nn)"); 
                            instruccion[1] = auxiliar[1].substring(1, auxiliar2[1].lastIndexOf(")")); 
                            break;
                            }
                        }else{
                        if (InstruccionesCompilador.containsKey(auxiliar[0]+" nn")) {
                            instruccion[0] = InstruccionesCompilador.get(auxiliar[0]+" nn"); 
                            instruccion[1] = auxiliar[1]; 
                            break;
                        }
                        }
                    }
               }else if (auxiliar2.length==2) {
                    if (etiquetas.containsKey(auxiliar2[1]))  {
                        if (auxiliar2[1].contains("(")) {
                            if (InstruccionesCompilador.containsKey(auxiliar[0]+" "+auxiliar2[0]+",(nn)")) {
                            instruccion[0] = InstruccionesCompilador.get(auxiliar[0]+" "+auxiliar2[0]+",(nn)"); 
                            instruccion[1] = auxiliar2[1].substring(1, auxiliar2[1].lastIndexOf(")")); 
                            break;
                            }
                        }else{
                        if (InstruccionesCompilador.containsKey(auxiliar[0]+" "+auxiliar2[0]+",nn")) {
                            instruccion[0] = InstruccionesCompilador.get(auxiliar[0]+" "+auxiliar2[0]+",nn"); 
                            instruccion[1] = auxiliar2[1]; 
                            break;
                        }
                    }
                    }
                }
               
                
               
                
                if (auxiliar2.length==1) {
                    if(auxiliar2[0].contains("(IX")){
                        auxiliar3=" (IX+d)";
                    }else{
                        auxiliar3=" (IY+d)";
                    }
                    if (InstruccionesCompilador.containsKey(auxiliar[0]+" n")) {
                        instruccion[0] = InstruccionesCompilador.get(auxiliar[0]+" n"); 
                        instruccion[1] = auxiliar2[0]; 
                        break;
                    }else if (InstruccionesCompilador.containsKey(auxiliar[0]+" nn")) {
                        instruccion[0] = InstruccionesCompilador.get(auxiliar[0]+" nn"); 
                        instruccion[1] = auxiliar2[0]; 
                        break;
                    }else if (InstruccionesCompilador.containsKey(auxiliar[0]+auxiliar3)) {
                        instruccion[0] = InstruccionesCompilador.get(auxiliar[0]+auxiliar3); 
                        instruccion[1] = auxiliar2[0].substring(3,6); 
                        break;
                    }
                }else{
                    if(auxiliar2[1].contains("(IX")){
                        auxiliar3=",(IX+d)";
                    }else if (auxiliar2[1].contains("(IY")){
                        auxiliar3=",(IY+d)";
                    }else if (auxiliar2[0].contains("(IX")){
                        auxiliar3=" (IX+d)";
                    }else if (auxiliar2[0].contains("(IY")){
                        auxiliar3=" (IY+d)";
                    }
                    if (InstruccionesCompilador.containsKey(auxiliar[0]+" (nn),"+auxiliar2[1])) {
                        instruccion[0] = InstruccionesCompilador.get(auxiliar[0]+" (nn),"+auxiliar2[1]); 
                        instruccion[1] = auxiliar2[0].substring(1, auxiliar2[0].lastIndexOf(")"));
                        break;
                    }else if (InstruccionesCompilador.containsKey(auxiliar[0]+" "+auxiliar2[0]+",n")) {
                        instruccion[0] = InstruccionesCompilador.get(auxiliar[0]+" "+auxiliar2[0]+",n"); 
                        instruccion[1] = auxiliar2[1]; 
                        break;
                    }else if (InstruccionesCompilador.containsKey(auxiliar[0]+" "+auxiliar2[0]+",d")) {
                        instruccion[0] = InstruccionesCompilador.get(auxiliar[0]+" "+auxiliar2[0]+",d"); 
                        instruccion[1] = auxiliar2[1]; 
                        break;
                    }else if (InstruccionesCompilador.containsKey(auxiliar[0]+" "+auxiliar2[0]+",nn") && !auxiliar2[1].contains("(")) {
                        instruccion[0] = InstruccionesCompilador.get(auxiliar[0]+" "+auxiliar2[0]+",nn"); 
                        instruccion[1] = auxiliar2[1]; 
                        break;
                    }else if (InstruccionesCompilador.containsKey(auxiliar[0]+" "+auxiliar2[0]+",(nn)")) {
                        instruccion[0] = InstruccionesCompilador.get(auxiliar[0]+" "+auxiliar2[0]+",(nn)"); 
                        instruccion[1] = auxiliar2[1].substring(1, auxiliar2[1].lastIndexOf(")"));
                        break;
                    }else if (InstruccionesCompilador.containsKey(auxiliar[0]+" "+auxiliar2[0]+auxiliar3)) {
                        instruccion[0] = InstruccionesCompilador.get(auxiliar[0]+" "+auxiliar2[0]+auxiliar3); 
                        instruccion[1] = auxiliar2[1].substring(3,6); 
                        break;
                    }else if (InstruccionesCompilador.containsKey(auxiliar[0]+auxiliar3+",n")) {
                        instruccion[0] = InstruccionesCompilador.get(auxiliar[0]+auxiliar3+",n"); 
                        instruccion[1] = auxiliar2[0].substring(3,6); 
                        instruccion[1] = auxiliar2[1]+instruccion[1]; 
                        break;
                    }
                    break;
               }
                break;
            } 
        } while (true);
        return instruccion;
    }
    
    public static String []armarIntruccion(int dirMemo){
        String instruccion[]={"",""};
        String llave = conversorBINtoHEXA(Memoria[dirMemo]);
        buffer = conversorBINtoHEXA(Memoria[dirMemo]);
        do {            
           if (contenedorInstrucciones.containsKey(llave)) {
                instruccion[0] = contenedorInstrucciones.get(llave); 
                instruccion[1]= ""+(llave.split(",")).length;
                break;
            }else{
               if (especiales.contains("#"+llave+",#")) {
                   for (int i = 0; i < 4; i++) {
                       switch(i){
                           case 0:{
                               if (contenedorInstrucciones.containsKey(llave+",n")) {
                                   llave = llave+",n";
                                   instruccion[0] = contenedorInstrucciones.get(llave);
                                   instruccion[1]= ""+(llave.split(",")).length;
                                   break;
                               }
                           }
                           case 1:{
                               if (contenedorInstrucciones.containsKey(llave+",n,n")) {
                                   llave = llave+",n,n";
                                   instruccion[0] = contenedorInstrucciones.get(llave);
                                   instruccion[1]= ""+(llave.split(",")).length;
                                   break;
                               }
                           }
                           case 2:{
                               if (contenedorInstrucciones.containsKey(llave+",d")) {
                                   llave = llave+",d";
                                   instruccion[0] = contenedorInstrucciones.get(llave);
                                   instruccion[1]= ""+(llave.split(",")).length;
                                   break;
                               }
                           }
                           case 3:{
                               if (contenedorInstrucciones.containsKey(llave+",d,n")) {
                                   llave = llave+",d,n";
                                   instruccion[0] = contenedorInstrucciones.get(llave);
                                   instruccion[1]= ""+(llave.split(",")).length;
                                   break;
                               }
                           }
                       }
                       break;
                   }
                   break;
               }else if ("DD,BC".equals(llave)||"FD,BC".equals(llave)) {
                   llave = llave+",d";
                   dirMemo++;
               }
               dirMemo++;
               llave = llave+","+conversorBINtoHEXA(Memoria[dirMemo]);
               buffer = conversorBINtoHEXA(Memoria[dirMemo]);
            } 
        } while (true);
        return instruccion;
    }
    
    public static String conversorINTtoHEXA(int entero){
        String hexadecimal="";
        if (entero<16) {
            hexadecimal = "000"+Integer.toHexString(entero);
        }else if (15<entero && entero<256) {
            hexadecimal = "00"+Integer.toHexString(entero);
        }else if (255<entero && entero<4096) {
            hexadecimal = "0"+Integer.toHexString(entero);
        }else{
            hexadecimal = Integer.toHexString(entero);
        }
        return hexadecimal;
    }
    
    public static byte[] conversorHEXAtoBIN(String hexadecimal){
        int numHex = Integer.parseInt(hexadecimal, 16);
        String binary = Integer.toBinaryString(numHex);
        char caracteresBinarios[] = binary.toCharArray();
        byte binarios[] = new byte [0];
        if(-32768>numHex || numHex>65535){
            System.out.println("Sobre paso el rango de los 16 bits");
            System.exit(0);
        }else if(hexadecimal.length()==2){
            binarios = new byte [8];
            for (int i = 0; i < caracteresBinarios.length; i++) {
                binarios[i] = Byte.valueOf(""+caracteresBinarios[caracteresBinarios.length-1-i]);
                if ((i+1)>7) {
                    break;
                }
            }
        }else{
            binarios = new byte [16];
            for (int i = 0; i < caracteresBinarios.length; i++) {
                binarios[i] = Byte.valueOf(""+caracteresBinarios[caracteresBinarios.length-1-i]);
                if ((i+1)>15) {
                    break;
                }
            }
        }
        return binarios;
    }

    public static String conversorBINtoHEXA(String binaria){
        int aux = Integer.parseInt(binaria, 2);
        String Hexa= Integer.toHexString(aux);
        if (binaria.length()==8) {
            if (Hexa.length()==1) {
                Hexa = "0"+Hexa;
            }
        }else if (binaria.length()==16) {
            switch (Hexa.length()){
                case 1 :{
                    Hexa = "000"+Hexa;
                    break;
                }
                case 2 :{
                    Hexa = "00"+Hexa;
                    break;
                }
                case 3 :{
                    Hexa = "0"+Hexa;
                    break;
                }
            }
        }
        Hexa = Hexa.toUpperCase();
        return Hexa;
    }
    
    public static String toCadenaBinaria (String arregloBinario  ){
        String cadena = "" ;
        arregloBinario = arregloBinario.replace(", ", "");
        arregloBinario = arregloBinario.replace("[", "");
        arregloBinario = arregloBinario.replace("]", "");
        char [] arregloInv = arregloBinario.toCharArray();
        for (int i = 0; i < arregloInv.length; i++) {
            cadena = cadena.concat(""+arregloInv[arregloInv.length-1-i]);
        }
        return cadena;
    }
    
    public static char [] sumarBinyBin(char []operando1, char []opernado2, char C){
        regF[1]= '0';
        regF[4]='0';
        regF[0]='0';
        char resultado [] = new char [8];
        String sumandos="";
        char carryAux = '0';
        if (C == '1') {
            carryAux = '1';
        }
        
        for (int i = 0; i < 8; i++) {
            sumandos = ""+carryAux+operando1[i]+opernado2[i];
            switch (sumandos){
                case "000":{
                    resultado[i] ='0';
                    carryAux= '0';
                    break;
                }
                case "010":{
                    resultado[i] ='1';
                    carryAux= '0';
                    break;
                }
                case "001":{
                    resultado[i] ='1';
                    carryAux= '0';
                    break;
                }
                case "100":{
                    resultado[i] ='1';
                    carryAux= '0';
                    break;
                }
                case "011":{
                    resultado[i] ='0';
                    carryAux= '1';
                    break;
                }
                case "101":{
                    resultado[i] ='0';
                    carryAux= '1';
                    break;
                }
                case "110":{
                    resultado[i] ='0';
                    carryAux= '1';
                    break;
                }
                case "111":{
                    resultado[i] ='1';
                    carryAux= '1';
                    break;
                }
            }
            if (i==3) {
                if (carryAux == '1') {
                    regF[4]='1';
                }
            }
        }
        if (carryAux == '1') {
            regF[0]='1';
        }
        if (Arrays.equals("00000000".toCharArray(), resultado)) {
            regF[6]='1';
        }else{
            regF[6]='0';
        }
        if (resultado[7]!=operando1[7]) {
            regF[2]='1';
        }else{
            regF[2]='0';
        }
        regF[7] = resultado[7];
        return resultado;
    }
    
    public static char [] restarBinyBin(char []operando1, char []sustrendo, char C){
        char []operando2 = sustrendo;
        operando2 = complemenTOdos(operando2);
        if (sustrendo[7]=='1') {
            operando2[7]='1';
        }
        regF[1]= '1';
        regF[4]='0';
        regF[0]='0';
        char resultado [] = new char [8];
        String sumandos="";
        char carryAux = '0';
        if (C == '1') {
            carryAux = '1';
        }
        
        for (int i = 0; i < 8; i++) {
            sumandos = ""+carryAux+operando1[i]+operando2[i];
            switch (sumandos){
                case "000":{
                    resultado[i] ='0';
                    carryAux= '0';
                    break;
                }
                case "010":{
                    resultado[i] ='1';
                    carryAux= '0';
                    break;
                }
                case "001":{
                    resultado[i] ='1';
                    carryAux= '0';
                    break;
                }
                case "100":{
                    resultado[i] ='1';
                    carryAux= '0';
                    break;
                }
                case "011":{
                    resultado[i] ='0';
                    carryAux= '1';
                    break;
                }
                case "101":{
                    resultado[i] ='0';
                    carryAux= '1';
                    break;
                }
                case "110":{
                    resultado[i] ='0';
                    carryAux= '1';
                    break;
                }
                case "111":{
                    resultado[i] ='1';
                    carryAux= '1';
                    break;
                }
            }
            if (i==3) {
                if (carryAux == '0') {
                    regF[4]='1';
                }
            }
        }
        if (carryAux == '0') {
            regF[0]='1';
        }
        if (Arrays.equals("00000000".toCharArray(), resultado)) {
            regF[6]='1';
        }else{
            regF[6]='0';
        }
        if (resultado[7]!=operando1[7]) {
            regF[2]='1';
        }else{
            regF[2]='0';
        }
        regF[7] = resultado[7];
        return resultado;
    }
    
    public static char [] and(char []operando1, char []opernado2){
        regF[1]= '0';
        regF[4]='1';
        regF[0]='0';
        char resultado [] = new char [8];
        String sumandos="";
        for (int i = 0; i < 8; i++) {
            sumandos = ""+operando1[i]+opernado2[i];
            switch (sumandos){
                case "00":{
                    resultado[i] ='0';
                    break;
                }
                case "10":{
                    resultado[i] ='0';
                    break;
                }
                case "01":{
                    resultado[i] ='0';
                    break;
                }
                case "11":{
                    resultado[i] ='1';
                    break;
                }
            }            
        }
        if (Arrays.equals("00000000".toCharArray(), resultado)) {
            regF[6]='1';
        }else{
            regF[6]='0';
        }
        if (resultado[7]!=operando1[7]) {
            regF[2]='1';
        }else{
            regF[2]='0';
        }
        regF[7] = resultado[7];
        return resultado;
    }
    
    public static char [] xor(char []operando1, char []opernado2){
        regF[1]= '0';
        regF[4]='1';
        regF[0]='0';
        char resultado [] = new char [8];
        String sumandos="";
        for (int i = 0; i < 8; i++) {
            sumandos = ""+operando1[i]+opernado2[i];
            switch (sumandos){
                case "00":{
                    resultado[i] ='0';
                    break;
                }
                case "01":{
                    resultado[i] ='1';
                    break;
                }
                case "10":{
                    resultado[i] ='1';
                    break;
                }
                case "11":{
                    resultado[i] ='0';
                    break;
                }
            }            
        }
        if (Arrays.equals("00000000".toCharArray(), resultado)) {
            regF[6]='1';
        }else{
            regF[6]='0';
        }
        if (resultado[7]!=operando1[7]) {
            regF[2]='1';
        }else{
            regF[2]='0';
        }
        regF[7] = resultado[7];
        return resultado;
    }
    
    public static char [] or(char []operando1, char []opernado2){
        regF[1]= '0';
        regF[4]='1';
        regF[0]='0';
        char resultado [] = new char [8];
        String sumandos="";
        for (int i = 0; i < 8; i++) {
            sumandos = ""+operando1[i]+opernado2[i];
            switch (sumandos){
                case "00":{
                    resultado[i] ='0';
                    break;
                }
                case "10":{
                    resultado[i] ='1';
                    break;
                }
                case "01":{
                    resultado[i] ='1';
                    break;
                }
                case "11":{
                    resultado[i] ='1';
                    break;
                }
            }            
        }
        if (Arrays.equals("00000000".toCharArray(), resultado)) {
            regF[6]='1';
        }else{
            regF[6]='0';
        }
        if (resultado[7]!=operando1[7]) {
            regF[2]='1';
        }else{
            regF[2]='0';
        }
        regF[7] = resultado[7];
        return resultado;
    }
    
    public static char []SRA(char []operando){
        regF[1]= '0';
        regF[4]='0';
        regF[0]='0';
        char resultado [] = new char [8];
        regF[0] = operando[0];
        for (int i = 0; i < 7; i++) {
            resultado [i] = operando[i+1];
        }
        resultado [7] = operando[7];
        if (Arrays.equals("00000000".toCharArray(), resultado)) {
            regF[6]='1';
        }else{
            regF[6]='0';
        }
        if (resultado[7]!=operando[7]) {
            regF[2]='1';
        }else{
            regF[2]='0';
        }
        regF[7] = resultado[7];
        return resultado;
    }
    
    public static char []RR(char []operando){
        regF[1]= '0';
        regF[4]='0';
        regF[0]='0';
        char resultado [] = new char [8];
        char auxCarry = regF[0];
        regF[0] = operando[0];
        for (int i = 0; i < 7; i++) {
            resultado [i] = operando[i+1];       
        }
        resultado [7] = auxCarry;
        if (Arrays.equals("00000000".toCharArray(), resultado)) {
            regF[6]='1';
        }else{
            regF[6]='0';
        }
        if (resultado[7]!=operando[7]) {
            regF[2]='1';
        }else{
            regF[2]='0';
        }
        regF[7] = resultado[7];
        return resultado;
    }
    
    public static char []SRL(char []operando){
        regF[1]= '0';
        regF[4]='0';
        regF[0]='0';
        char resultado [] = new char [8];
        char auxCarry = '0';
        regF[0] = operando[0];
        for (int i = 0; i < 7; i++) {
            resultado [i] = operando[i+1];       
        }
        resultado [7] = auxCarry;
        if (Arrays.equals("00000000".toCharArray(), resultado)) {
            regF[6]='1';
        }else{
            regF[6]='0';
        }
        if (resultado[7]!=operando[7]) {
            regF[2]='1';
        }else{
            regF[2]='0';
        }
        regF[7] = resultado[7];
        return resultado;
    }
    
    public static char []RRC(char []operando){
        regF[1]= '0';
        regF[4]='0';
        regF[0]='0';
        char resultado [] = new char [8];
        regF[0] = operando[0];
        for (int i = 0; i < 7; i++) {
            resultado [i] = operando[i+1];       
        }
        resultado [7] = regF[0];
        if (Arrays.equals("00000000".toCharArray(), resultado)) {
            regF[6]='1';
        }else{
            regF[6]='0';
        }
        if (resultado[7]!=operando[7]) {
            regF[2]='1';
        }else{
            regF[2]='0';
        }
        regF[7] = resultado[7];
        return resultado;
    }
    
    public static char []RL(char []operando){
        regF[1]= '0';
        regF[4]='0';
        regF[0]='0';
        char resultado [] = new char [8];
        char auxCarry = regF[0];
        regF[0] = operando[7];
        for (int i = 1; i < 8; i++) {
            resultado [i] = operando[i-1];       
        }
        resultado [0] = auxCarry;
        if (Arrays.equals("00000000".toCharArray(), resultado)) {
            regF[6]='1';
        }else{
            regF[6]='0';
        }
        if (resultado[7]!=operando[7]) {
            regF[2]='1';
        }else{
            regF[2]='0';
        }
        regF[7] = resultado[7];
        return resultado;
    }
    
    public static char []SLA(char []operando){
        regF[1]= '0';
        regF[4]='0';
        regF[0]='0';
        char resultado [] = new char [8];
        char auxCarry = '0';
        regF[0] = operando[7];
        for (int i = 1; i < 8; i++) {
            resultado [i] = operando[i-1];       
        }
        resultado [0] = auxCarry;
        if (Arrays.equals("00000000".toCharArray(), resultado)) {
            regF[6]='1';
        }else{
            regF[6]='0';
        }
        if (resultado[7]!=operando[7]) {
            regF[2]='1';
        }else{
            regF[2]='0';
        }
        regF[7] = resultado[7];
        return resultado;
    }
    
    public static char []RLC(char []operando){
        regF[1]= '0';
        regF[4]='0';
        regF[0]='0';
        char resultado [] = new char [8];
        regF[0] = operando[7];
        for (int i = 1; i < 8; i++) {
            resultado [i] = operando[i-1];       
        }
        resultado [0] = regF[0];
        if (Arrays.equals("00000000".toCharArray(), resultado)) {
            regF[6]='1';
        }else{
            regF[6]='0';
        }
        if (resultado[7]!=operando[7]) {
            regF[2]='1';
        }else{
            regF[2]='0';
        }
        regF[7] = resultado[7];
        return resultado;
    }
    
    public static void comparacion(char []operando1, char []sustrendo){
        char []operando2 = sustrendo;
        operando2 = complemenTOdos(operando2);
        if (sustrendo[7]=='1') {
            operando2[7]='1';
        }
        regF[1]= '1';
        regF[4]='0';
        regF[0]='0';
        char resultado [] = new char [8];
        String sumandos="";
        char carryAux = '0';
        for (int i = 0; i < 8; i++) {
            sumandos = ""+carryAux+operando1[i]+operando2[i];
            switch (sumandos){
                case "000":{
                    resultado[i] ='0';
                    carryAux= '0';
                    break;
                }
                case "010":{
                    resultado[i] ='1';
                    carryAux= '0';
                    break;
                }
                case "001":{
                    resultado[i] ='1';
                    carryAux= '0';
                    break;
                }
                case "100":{
                    resultado[i] ='1';
                    carryAux= '0';
                    break;
                }
                case "011":{
                    resultado[i] ='0';
                    carryAux= '1';
                    break;
                }
                case "101":{
                    resultado[i] ='0';
                    carryAux= '1';
                    break;
                }
                case "110":{
                    resultado[i] ='0';
                    carryAux= '1';
                    break;
                }
                case "111":{
                    resultado[i] ='1';
                    carryAux= '1';
                    break;
                }
            }
            if (i==3) {
                if (carryAux == '0') {
                    regF[4]='1';
                }
            }
        }
        if (carryAux == '0') {
            regF[0]='1';
        }
        if (Arrays.equals("00000000".toCharArray(), resultado)) {
            regF[6]='1';
        }else{
            regF[6]='0';
        }
        if (resultado[7]!=operando1[7]) {
            regF[2]='1';
        }else{
            regF[2]='0';
        }
        regF[7] = resultado[7];
        
    }
    
    public static char [] complemenTOuno(char []operando){
        char resultado [] = new char [8];
        for (int i = 0; i < 8; i++) {
            switch(operando[i]){
                case '0':{
                    resultado[i]='1';
                    break;
                }
                case '1':{
                    resultado[i]='0';
                    break;
                }
            }
        }
        return resultado;
    }
    
    public static char [] complemenTOdos(char []operando){
        char resultado [] = new char [8];
        // tener cuidado con las banderas que puede modificar
        // deberia tener un metodo propio sin que afecte las banderas inicialmente 
        resultado = sumarBinyBin(complemenTOuno(operando),"00000000".toCharArray(),'1');
        return resultado;
    }
    
    public static char [] decrementar8bits(char []operando1){
        char [] opernado2 = "11111111".toCharArray();
        regF[1]= '1';
        regF[4]='0';
        char resultado [] = new char [8];
        String sumandos="";
        char carryAux = '0';
        
        for (int i = 0; i < 8; i++) {
            sumandos = ""+carryAux+operando1[i]+opernado2[i];
            switch (sumandos){
                case "000":{
                    resultado[i] ='0';
                    carryAux= '0';
                    break;
                }
                case "010":{
                    resultado[i] ='1';
                    carryAux= '0';
                    break;
                }
                case "001":{
                    resultado[i] ='1';
                    carryAux= '0';
                    break;
                }
                case "100":{
                    resultado[i] ='1';
                    carryAux= '0';
                    break;
                }
                case "011":{
                    resultado[i] ='0';
                    carryAux= '1';
                    break;
                }
                case "101":{
                    resultado[i] ='0';
                    carryAux= '1';
                    break;
                }
                case "110":{
                    resultado[i] ='0';
                    carryAux= '1';
                    break;
                }
                case "111":{
                    resultado[i] ='1';
                    carryAux= '1';
                    break;
                }
            }
            if (i==3) {
                if (carryAux == '0') {
                    regF[4]='1';
                }
            }
        }
        if (Arrays.equals("00000000".toCharArray(), resultado)) {
            regF[6]='1';
        }else{
            regF[6]='0';
        }
        if (resultado[7]!=operando1[7]) {
            regF[2]='1';
        }else{
            regF[2]='0';
        }
        regF[7] = resultado[7];
        return resultado;
    }
    
    public static char [] incrementar8bits(char []operando1){
        char [] opernado2 = "00000001".toCharArray();
        regF[1]= '0';
        regF[4]='0';
        regF[0]='0';
        char resultado [] = new char [8];
        String sumandos="";
        char carryAux = '0';
        
        for (int i = 0; i < 8; i++) {
            sumandos = ""+carryAux+operando1[i]+opernado2[i];
            switch (sumandos){
                case "000":{
                    resultado[i] ='0';
                    carryAux= '0';
                    break;
                }
                case "010":{
                    resultado[i] ='1';
                    carryAux= '0';
                    break;
                }
                case "001":{
                    resultado[i] ='1';
                    carryAux= '0';
                    break;
                }
                case "100":{
                    resultado[i] ='1';
                    carryAux= '0';
                    break;
                }
                case "011":{
                    resultado[i] ='0';
                    carryAux= '1';
                    break;
                }
                case "101":{
                    resultado[i] ='0';
                    carryAux= '1';
                    break;
                }
                case "110":{
                    resultado[i] ='0';
                    carryAux= '1';
                    break;
                }
                case "111":{
                    resultado[i] ='1';
                    carryAux= '1';
                    break;
                }
            }
            if (i==3) {
                if (carryAux == '1') {
                    regF[4]='1';
                }
            }
        }
        if (carryAux == '1') {
            regF[0]='1';
        }
        if (Arrays.equals("00000000".toCharArray(), resultado)) {
            regF[6]='1';
        }else{
            regF[6]='0';
        }
        if (resultado[7]!=operando1[7]) {
            regF[2]='1';
        }else{
            regF[2]='0';
        }
        regF[7] = resultado[7];
        return resultado;
    }
    
    public static char [] inputs(){
        for (int i = 0; i < 8; i++) {
            direcciones [i] = regC[i];
            direcciones [i+8] = regB[i];
        }
        int dir = Integer.parseInt(toCadenaBinaria(Arrays.toString(regC)), 2);
        DataBus = toCadenaBinaria(IO[dir]).toCharArray();
        regF[1] = '0';
        regF[4] = '0';
        regF[7] = DataBus[7];
        if (DataBus.equals("00000000")) {
            regF[6] ='1';
        }else{
            regF[6] ='0';
        }
        if (DataBus[0] == '0') {
            regF[2] ='1';
        }else{
            regF[2] ='0';
        }
        return DataBus;
    }
    
    public static String [] outputs(char [] aux){
        for (int i = 0; i < 8; i++) {
            direcciones [i] = regC[i];
            direcciones [i+8] = regB[i];
        }
        int dir = Integer.parseInt(toCadenaBinaria(Arrays.toString(regC)), 2);
        DataBus = aux;
        String datos [] ={Integer.toString(dir),toCadenaBinaria(Arrays.toString(DataBus))};
        return datos;
        
    }
    
    public static void conjuntoInstrucciones(){
        contenedorInstrucciones.put("7F", "LD A,A");
        contenedorInstrucciones.put("78", "LD A,B");
        contenedorInstrucciones.put("79", "LD A,C");
        contenedorInstrucciones.put("7A", "LD A,D");
        contenedorInstrucciones.put("7B", "LD A,E");
        contenedorInstrucciones.put("7C", "LD A,H");
        contenedorInstrucciones.put("7D", "LD A,L");
        contenedorInstrucciones.put("47", "LD B,A");
        contenedorInstrucciones.put("40", "LD B,B");
        contenedorInstrucciones.put("41", "LD B,C");
        contenedorInstrucciones.put("42", "LD B,D");
        contenedorInstrucciones.put("43", "LD B,E");
        contenedorInstrucciones.put("44", "LD B,H");
        contenedorInstrucciones.put("45", "LD B,L");
        contenedorInstrucciones.put("4F", "LD C,A");
        contenedorInstrucciones.put("48", "LD C,B");
        contenedorInstrucciones.put("49", "LD C,C");
        contenedorInstrucciones.put("4A", "LD C,D");
        contenedorInstrucciones.put("4B", "LD C,E");
        contenedorInstrucciones.put("4C", "LD C,H");
        contenedorInstrucciones.put("4D", "LD C,L");
        contenedorInstrucciones.put("57", "LD D,A");
        contenedorInstrucciones.put("50", "LD D,B");
        contenedorInstrucciones.put("51", "LD D,C");
        contenedorInstrucciones.put("52", "LD D,D");
        contenedorInstrucciones.put("53", "LD D,E");
        contenedorInstrucciones.put("54", "LD D,H");
        contenedorInstrucciones.put("55", "LD D,L");
        contenedorInstrucciones.put("5F", "LD E,A");
        contenedorInstrucciones.put("58", "LD E,B");
        contenedorInstrucciones.put("59", "LD E,C");
        contenedorInstrucciones.put("5A", "LD E,D");
        contenedorInstrucciones.put("5B", "LD E,E");
        contenedorInstrucciones.put("5C", "LD E,H");
        contenedorInstrucciones.put("5D", "LD E,L");
        contenedorInstrucciones.put("67", "LD H,A");
        contenedorInstrucciones.put("60", "LD H,B");
        contenedorInstrucciones.put("61", "LD H,C");
        contenedorInstrucciones.put("62", "LD H,D");
        contenedorInstrucciones.put("63", "LD H,E");
        contenedorInstrucciones.put("64", "LD H,H");
        contenedorInstrucciones.put("65", "LD H,L");
        contenedorInstrucciones.put("6F", "LD L,A");
        contenedorInstrucciones.put("68", "LD L,B");
        contenedorInstrucciones.put("69", "LD L,C");
        contenedorInstrucciones.put("6A", "LD L,D");
        contenedorInstrucciones.put("6B", "LD L,E");
        contenedorInstrucciones.put("6C", "LD L,H");
        contenedorInstrucciones.put("6D", "LD L,L");
        contenedorInstrucciones.put("3E,n", "LD A,n");
        contenedorInstrucciones.put("06,n", "LD B,n");
        contenedorInstrucciones.put("0E,n", "LD C,n");
        contenedorInstrucciones.put("16,n", "LD D,n");
        contenedorInstrucciones.put("1E,n", "LD E,n");
        contenedorInstrucciones.put("26,n", "LD H,n");
        contenedorInstrucciones.put("2E,n", "LD L,n");
        contenedorInstrucciones.put("7E", "LD A,(HL)");
        contenedorInstrucciones.put("46", "LD B,(HL)");
        contenedorInstrucciones.put("4E", "LD C,(HL)");
        contenedorInstrucciones.put("56", "LD D,(HL)");
        contenedorInstrucciones.put("5E", "LD E,(HL)");
        contenedorInstrucciones.put("66", "LD H,(HL)");
        contenedorInstrucciones.put("6E", "LD L,(HL)");
        contenedorInstrucciones.put("DD,7E,d", "LD A,(IX+d)");
        contenedorInstrucciones.put("DD,46,d", "LD B,(IX+d)");
        contenedorInstrucciones.put("DD,4E,d", "LD C,(IX+d)");
        contenedorInstrucciones.put("DD,56,d", "LD D,(IX+d)");
        contenedorInstrucciones.put("DD,5E,d", "LD E,(IX+d)");
        contenedorInstrucciones.put("DD,66,d", "LD H,(IX+d)");
        contenedorInstrucciones.put("DD,6E,d", "LD L,(IX+d)");
        contenedorInstrucciones.put("FD,7E,d", "LD A,(IY+d)");
        contenedorInstrucciones.put("FD,46,d", "LD B,(IY+d)");
        contenedorInstrucciones.put("FD,4E,d", "LD C,(IY+d)");
        contenedorInstrucciones.put("FD,56,d", "LD D,(IY+d)");
        contenedorInstrucciones.put("FD,5E,d", "LD E,(IY+d)");
        contenedorInstrucciones.put("FD,66,d", "LD H,(IY+d)");
        contenedorInstrucciones.put("FD,6E,d", "LD L,(IY+d)");
        contenedorInstrucciones.put("77", "LD (HL),A");
        contenedorInstrucciones.put("70", "LD (HL),B");
        contenedorInstrucciones.put("71", "LD (HL),C");
        contenedorInstrucciones.put("72", "LD (HL),D");
        contenedorInstrucciones.put("73", "LD (HL),E");
        contenedorInstrucciones.put("74", "LD (HL),H");
        contenedorInstrucciones.put("75", "LD (HL),L");
        contenedorInstrucciones.put("DD,77,d", "LD (IX+d),A");
        contenedorInstrucciones.put("DD,70,d", "LD (IX+d),B");
        contenedorInstrucciones.put("DD,71,d", "LD (IX+d),C");
        contenedorInstrucciones.put("DD,72,d", "LD (IX+d),D");
        contenedorInstrucciones.put("DD,73,d", "LD (IX+d),E");
        contenedorInstrucciones.put("DD,74,d", "LD (IX+d),H");
        contenedorInstrucciones.put("DD,75,d", "LD (IX+d),L");
        contenedorInstrucciones.put("FD,77,d", "LD (IY+d),A");
        contenedorInstrucciones.put("FD,70,d", "LD (IY+d),B");
        contenedorInstrucciones.put("FD,71,d", "LD (IY+d),C");
        contenedorInstrucciones.put("FD,72,d", "LD (IY+d),D");
        contenedorInstrucciones.put("FD,73,d", "LD (IY+d),E");
        contenedorInstrucciones.put("FD,74,d", "LD (IY+d),H");
        contenedorInstrucciones.put("FD,75,d", "LD (IY+d),L");
        contenedorInstrucciones.put("36,n", "LD (HL),n");
        contenedorInstrucciones.put("DD,36,d,n", "LD (IX+d),n");
        contenedorInstrucciones.put("FD,36,d,n", "LD (IY+d),n");
        contenedorInstrucciones.put("0A", "LD A,(BC)");
        contenedorInstrucciones.put("1A", "LD A,(DE)");
        contenedorInstrucciones.put("3A,n,n", "LD A,(nn)");
        contenedorInstrucciones.put("ED,57", "LD A,I");
        contenedorInstrucciones.put("ED,5F", "LD A,R");
        contenedorInstrucciones.put("2", "LD (BC),A");
        contenedorInstrucciones.put("12", "LD (DE),A");
        contenedorInstrucciones.put("32,n,n", "LD (nn),A");
        contenedorInstrucciones.put("ED,47", "LD I,A");
        contenedorInstrucciones.put("ED,4F", "LD R,A");
        contenedorInstrucciones.put("01,n,n", "LD BC,nn");
        contenedorInstrucciones.put("11,n,n", "LD DE,nn");
        contenedorInstrucciones.put("21,n,n", "LD HL,nn");
        contenedorInstrucciones.put("31,n,n", "LD SP,nn");
        contenedorInstrucciones.put("DD,21,n,n", "LD IX,nn");
        contenedorInstrucciones.put("FD,21,n,n", "LD IY,nn");
        contenedorInstrucciones.put("2A,n,n", "LD HL,(nn)");
        contenedorInstrucciones.put("ED,4B,n,n", "LD BC,(nn)");
        contenedorInstrucciones.put("ED,5B,n,n", "LD DE,(nn)");
        contenedorInstrucciones.put("ED,7B,n,n", "LD SP,(nn)");
        contenedorInstrucciones.put("DD,2A,n,n", "LD IX,(nn)");
        contenedorInstrucciones.put("FD,2A,n,n", "LD IY,(nn)");
        contenedorInstrucciones.put("22,n,n", "LD (nn),HL");
        contenedorInstrucciones.put("ED,43,n,n", "LD (nn),BC");
        contenedorInstrucciones.put("ED,53,n,n", "LD (nn),DE");
        contenedorInstrucciones.put("ED,73,n,n", "LD (nn),SP");
        contenedorInstrucciones.put("DD,22,n,n", "LD (nn),IX");
        contenedorInstrucciones.put("FD,22,n,n", "LD (nn),IY");
        contenedorInstrucciones.put("F9", "LD SP,HL");
        contenedorInstrucciones.put("DD,F9", "LD SP,IX");
        contenedorInstrucciones.put("FD,F9", "LD SP,IY");
        contenedorInstrucciones.put("C5", "PUSH BC");
        contenedorInstrucciones.put("D5", "PUSH DE");
        contenedorInstrucciones.put("E5", "PUSH HL");
        contenedorInstrucciones.put("F5", "PUSH AF");
        contenedorInstrucciones.put("DD,E5", "PUSH IX");
        contenedorInstrucciones.put("FD,E5", "PUSH IY");
        contenedorInstrucciones.put("C1", "POP BC");
        contenedorInstrucciones.put("D1", "POP DE");
        contenedorInstrucciones.put("E1", "POP HL");
        contenedorInstrucciones.put("F1", "POP AF");
        contenedorInstrucciones.put("DD,E1", "POP IX");
        contenedorInstrucciones.put("FD,E1", "POP IY");
        contenedorInstrucciones.put("87", "ADD A,A");
        contenedorInstrucciones.put("80", "ADD A,B");
        contenedorInstrucciones.put("81", "ADD A,C");
        contenedorInstrucciones.put("82", "ADD A,D");
        contenedorInstrucciones.put("83", "ADD A,E");
        contenedorInstrucciones.put("84", "ADD A,H");
        contenedorInstrucciones.put("85", "ADD A,L");
        contenedorInstrucciones.put("C6,n", "ADD A,n");
        contenedorInstrucciones.put("86", "ADD A,(HL)");
        contenedorInstrucciones.put("DD,86,d", "ADD A,(IX+d)");
        contenedorInstrucciones.put("FD,86,d", "ADD A,(IY+d)");
        contenedorInstrucciones.put("8F", "ADC A,A");
        contenedorInstrucciones.put("88", "ADC A,B");
        contenedorInstrucciones.put("89", "ADC A,C");
        contenedorInstrucciones.put("8A", "ADC A,D");
        contenedorInstrucciones.put("8B", "ADC A,E");
        contenedorInstrucciones.put("8C", "ADC A,H");
        contenedorInstrucciones.put("8D", "ADC A,L");
        contenedorInstrucciones.put("CE,n", "ADC A,n");
        contenedorInstrucciones.put("8E", "ADC A,(HL)");
        contenedorInstrucciones.put("DD,8E,d", "ADC A,(IX+d)");
        contenedorInstrucciones.put("FD,8E,d", "ADC A,(IY+d)");
        contenedorInstrucciones.put("97", "SUB A");
        contenedorInstrucciones.put("90", "SUB B");
        contenedorInstrucciones.put("91", "SUB C");
        contenedorInstrucciones.put("92", "SUB D");
        contenedorInstrucciones.put("93", "SUB E");
        contenedorInstrucciones.put("94", "SUB H");
        contenedorInstrucciones.put("95", "SUB L");
        contenedorInstrucciones.put("D6,n", "SUB n");
        contenedorInstrucciones.put("96", "SUB (HL)");
        contenedorInstrucciones.put("DD,96,d", "SUB (IX+d)");
        contenedorInstrucciones.put("FD,96,d", "SUB (IY+d)");
        contenedorInstrucciones.put("9F", "SBC A,A");
        contenedorInstrucciones.put("98", "SBC A,B");
        contenedorInstrucciones.put("99", "SBC A,C");
        contenedorInstrucciones.put("9A", "SBC A,D");
        contenedorInstrucciones.put("9B", "SBC A,E");
        contenedorInstrucciones.put("9C", "SBC A,H");
        contenedorInstrucciones.put("9D", "SBC A,L");
        contenedorInstrucciones.put("DE,n", "SBC A,n");
        contenedorInstrucciones.put("9E", "SBC A,(HL)");
        contenedorInstrucciones.put("DD,9E,d", "SBC A,(IX+d)");
        contenedorInstrucciones.put("FD,9E,d", "SBC A,(IY+d)");
        contenedorInstrucciones.put("CA,n,n", "JP Z,nn");
        contenedorInstrucciones.put("C2,n,n", "JP NZ,nn");
        contenedorInstrucciones.put("DA,n,n", "JP C,nn");
        contenedorInstrucciones.put("D2,n,n", "JP NC,nn");
        contenedorInstrucciones.put("EA,n,n", "JP PE,nn");
        contenedorInstrucciones.put("E2,n,n", "JP PO,nn");
        contenedorInstrucciones.put("FA,n,n", "JP M,nn");
        contenedorInstrucciones.put("F2,n,n", "JP P,nn");
        contenedorInstrucciones.put("E9", "JP (HL)");
        contenedorInstrucciones.put("DD,E9", "JP (IX)");
        contenedorInstrucciones.put("FD,E9", "JP (IY)");
        contenedorInstrucciones.put("C3,n,n", "JP nn");
        contenedorInstrucciones.put("28,d", "JR Z,d");
        contenedorInstrucciones.put("20,d", "JR NZ,d");
        contenedorInstrucciones.put("38,d", "JR C,d");
        contenedorInstrucciones.put("30,d", "JR NC,d");
        contenedorInstrucciones.put("18,d", "JR d");
        contenedorInstrucciones.put("10,d", "DJNZ d");
        contenedorInstrucciones.put("CC,n,n", "CALL Z,nn");
        contenedorInstrucciones.put("C4,n,n", "CALL NZ,nn");
        contenedorInstrucciones.put("DC,n,n", "CALL C,nn");
        contenedorInstrucciones.put("D4,n,n", "CALL NC,nn");
        contenedorInstrucciones.put("EC,n,n", "CALL PE,nn");
        contenedorInstrucciones.put("E4,n,n", "CALL PO,nn");
        contenedorInstrucciones.put("FC,n,n", "CALL M,nn");
        contenedorInstrucciones.put("F4,n,n", "CALL P,nn");
        contenedorInstrucciones.put("CD,n,n", "CALL nn");
        contenedorInstrucciones.put("C8", "RET Z");
        contenedorInstrucciones.put("C0", "RET NZ");
        contenedorInstrucciones.put("D8", "RET C");
        contenedorInstrucciones.put("D0", "RET NC");
        contenedorInstrucciones.put("E8", "RET PE");
        contenedorInstrucciones.put("E0", "RET PO");
        contenedorInstrucciones.put("F8", "RET M");
        contenedorInstrucciones.put("F0", "RET P");
        contenedorInstrucciones.put("C9", "RET");
        contenedorInstrucciones.put("ED,4D", "RETI");
        contenedorInstrucciones.put("ED,45", "RETN");
        contenedorInstrucciones.put("C7", "RST 00");
        contenedorInstrucciones.put("CF", "RST 08");
        contenedorInstrucciones.put("D7", "RST 10");
        contenedorInstrucciones.put("DF", "RST 18");
        contenedorInstrucciones.put("E7", "RST 20");
        contenedorInstrucciones.put("EF", "RST 28");
        contenedorInstrucciones.put("F7", "RST 30");
        contenedorInstrucciones.put("FF", "RST 38");
        contenedorInstrucciones.put("CB,47", "BIT 0,A");
        contenedorInstrucciones.put("CB,40", "BIT 0,B");
        contenedorInstrucciones.put("CB,41", "BIT 0,C");
        contenedorInstrucciones.put("CB,42", "BIT 0,D");
        contenedorInstrucciones.put("CB,43", "BIT 0,E");
        contenedorInstrucciones.put("CB,44", "BIT 0,H");
        contenedorInstrucciones.put("CB,45", "BIT 0,L");
        contenedorInstrucciones.put("CB,46", "BIT 0,(HL)");
        contenedorInstrucciones.put("DD,CB,d,46", "BIT 0,(IX+d)");
        contenedorInstrucciones.put("FD,CB,d,46", "BIT 0,(IY+d)");
        contenedorInstrucciones.put("CB,4F", "BIT 1,A");
        contenedorInstrucciones.put("CB,48", "BIT 1,B");
        contenedorInstrucciones.put("CB,49", "BIT 1,C");
        contenedorInstrucciones.put("CB,4A", "BIT 1,D");
        contenedorInstrucciones.put("CB,4B", "BIT 1,E");
        contenedorInstrucciones.put("CB,4C", "BIT 1,H");
        contenedorInstrucciones.put("CB,4D", "BIT 1,L");
        contenedorInstrucciones.put("CB,4E", "BIT 1,(HL)");
        contenedorInstrucciones.put("DD,CB,d,4E", "BIT 1,(IX+d)");
        contenedorInstrucciones.put("FD,CB,d,4E", "BIT 1,(IY+d)");
        contenedorInstrucciones.put("CB,57", "BIT 2,A");
        contenedorInstrucciones.put("CB,50", "BIT 2,B");
        contenedorInstrucciones.put("CB,51", "BIT 2,C");
        contenedorInstrucciones.put("CB,52", "BIT 2,D");
        contenedorInstrucciones.put("CB,53", "BIT 2,E");
        contenedorInstrucciones.put("CB,54", "BIT 2,H");
        contenedorInstrucciones.put("CB,55", "BIT 2,L");
        contenedorInstrucciones.put("CB,56", "BIT 2,(HL)");
        contenedorInstrucciones.put("DD,CB,d,56", "BIT 2,(IX+d)");
        contenedorInstrucciones.put("FD,CB,d,56", "BIT 2,(IY+d)");
        contenedorInstrucciones.put("CB,5F", "BIT 3,A");
        contenedorInstrucciones.put("CB,58", "BIT 3,B");
        contenedorInstrucciones.put("CB,59", "BIT 3,C");
        contenedorInstrucciones.put("CB,5A", "BIT 3,D");
        contenedorInstrucciones.put("CB,5B", "BIT 3,E");
        contenedorInstrucciones.put("CB,5C", "BIT 3,H");
        contenedorInstrucciones.put("CB,5D", "BIT 3,L");
        contenedorInstrucciones.put("CB,5E", "BIT 3,(HL)");
        contenedorInstrucciones.put("DD,CB,d,5E", "BIT 3,(IX+d)");
        contenedorInstrucciones.put("FD,CB,d,5E", "BIT 3,(IY+d)");
        contenedorInstrucciones.put("CB,67", "BIT 4,A");
        contenedorInstrucciones.put("CB,60", "BIT 4,B");
        contenedorInstrucciones.put("CB,61", "BIT 4,C");
        contenedorInstrucciones.put("CB,62", "BIT 4,D");
        contenedorInstrucciones.put("CB,63", "BIT 4,E");
        contenedorInstrucciones.put("CB,64", "BIT 4,H");
        contenedorInstrucciones.put("CB,65", "BIT 4,L");
        contenedorInstrucciones.put("CB,66", "BIT 4,(HL)");
        contenedorInstrucciones.put("DD,CB,d,66", "BIT 4,(IX+d)");
        contenedorInstrucciones.put("FD,CB,d,66", "BIT 4,(IY+d)");
        contenedorInstrucciones.put("CB,6F", "BIT 5,A");
        contenedorInstrucciones.put("CB,68", "BIT 5,B");
        contenedorInstrucciones.put("CB,69", "BIT 5,C");
        contenedorInstrucciones.put("CB,6A", "BIT 5,D");
        contenedorInstrucciones.put("CB,6B", "BIT 5,E");
        contenedorInstrucciones.put("CB,6C", "BIT 5,H");
        contenedorInstrucciones.put("CB,6D", "BIT 5,L");
        contenedorInstrucciones.put("CB,6E", "BIT 5,(HL)");
        contenedorInstrucciones.put("DD,CB,d,6E", "BIT 5,(IX+d)");
        contenedorInstrucciones.put("FD,CB,d,6E", "BIT 5,(IY+d)");
        contenedorInstrucciones.put("CB,77", "BIT 6,A");
        contenedorInstrucciones.put("CB,70", "BIT 6,B");
        contenedorInstrucciones.put("CB,71", "BIT 6,C");
        contenedorInstrucciones.put("CB,72", "BIT 6,D");
        contenedorInstrucciones.put("CB,73", "BIT 6,E");
        contenedorInstrucciones.put("CB,74", "BIT 6,H");
        contenedorInstrucciones.put("CB,75", "BIT 6,L");
        contenedorInstrucciones.put("CB,76", "BIT 6,(HL)");
        contenedorInstrucciones.put("DD,CB,d,76", "BIT 6,(IX+d)");
        contenedorInstrucciones.put("FD,CB,d,76", "BIT 6,(IY+d)");
        contenedorInstrucciones.put("CB,7F", "BIT 7,A");
        contenedorInstrucciones.put("CB,78", "BIT 7,B");
        contenedorInstrucciones.put("CB,79", "BIT 7,C");
        contenedorInstrucciones.put("CB,7A", "BIT 7,D");
        contenedorInstrucciones.put("CB,7B", "BIT 7,E");
        contenedorInstrucciones.put("CB,7C", "BIT 7,H");
        contenedorInstrucciones.put("CB,7D", "BIT 7,L");
        contenedorInstrucciones.put("CB,7E", "BIT 7,(HL)");
        contenedorInstrucciones.put("DD,CB,d,7E", "BIT 7,(IX+d)");
        contenedorInstrucciones.put("FD,CB,d,E", "BIT 7,(IY+d)");
        contenedorInstrucciones.put("CB,87", "RES 0,A");
        contenedorInstrucciones.put("CB,80", "RES 0,B");
        contenedorInstrucciones.put("CB,81", "RES 0,C");
        contenedorInstrucciones.put("CB,82", "RES 0,D");
        contenedorInstrucciones.put("CB,83", "RES 0,E");
        contenedorInstrucciones.put("CB,84", "RES 0,H");
        contenedorInstrucciones.put("CB,85", "RES 0,L");
        contenedorInstrucciones.put("CB,86", "RES 0,(HL)");
        contenedorInstrucciones.put("DD,CB,d,86", "RES 0,(IX+d)");
        contenedorInstrucciones.put("FD,CB,d,86", "RES 0,(IY+d)");
        contenedorInstrucciones.put("CB,8F", "RES 1,A");
        contenedorInstrucciones.put("CB,88", "RES 1,B");
        contenedorInstrucciones.put("CB,89", "RES 1,C");
        contenedorInstrucciones.put("CB,8A", "RES 1,D");
        contenedorInstrucciones.put("CB,8B", "RES 1,E");
        contenedorInstrucciones.put("CB,8C", "RES 1,H");
        contenedorInstrucciones.put("CB,8D", "RES 1,L");
        contenedorInstrucciones.put("CB,8E", "RES 1,(HL)");
        contenedorInstrucciones.put("DD,CB,d,8E", "RES 1,(IX+d)");
        contenedorInstrucciones.put("FD,CB,d,8E", "RES 1,(IY+d)");
        contenedorInstrucciones.put("CB,97", "RES 2,A");
        contenedorInstrucciones.put("CB,90", "RES 2,B");
        contenedorInstrucciones.put("CB,91", "RES 2,C");
        contenedorInstrucciones.put("CB,92", "RES 2,D");
        contenedorInstrucciones.put("CB,93", "RES 2,E");
        contenedorInstrucciones.put("CB,94", "RES 2,H");
        contenedorInstrucciones.put("CB,95", "RES 2,L");
        contenedorInstrucciones.put("CB,96", "RES 2,(HL)");
        contenedorInstrucciones.put("DD,CB,d,96", "RES 2,(IX+d)");
        contenedorInstrucciones.put("FD,CB,d,96", "RES 2,(IY+d)");
        contenedorInstrucciones.put("CB,9F", "RES 3,A");
        contenedorInstrucciones.put("CB,98", "RES 3,B");
        contenedorInstrucciones.put("CB,99", "RES 3,C");
        contenedorInstrucciones.put("CB,9A", "RES 3,D");
        contenedorInstrucciones.put("CB,9B", "RES 3,E");
        contenedorInstrucciones.put("CB,9C", "RES 3,H");
        contenedorInstrucciones.put("CB,9D", "RES 3,L");
        contenedorInstrucciones.put("CB,9E", "RES 3,(HL)");
        contenedorInstrucciones.put("DD,CB,d,9E", "RES 3,(IX+d)");
        contenedorInstrucciones.put("FD,CB,d,9E", "RES 3,(IY+d)");
        contenedorInstrucciones.put("CB,A7", "RES 4,A");
        contenedorInstrucciones.put("CB,A0", "RES 4,B");
        contenedorInstrucciones.put("CB,A1", "RES 4,C");
        contenedorInstrucciones.put("CB,A2", "RES 4,D");
        contenedorInstrucciones.put("CB,A3", "RES 4,E");
        contenedorInstrucciones.put("CB,A4", "RES 4,H");
        contenedorInstrucciones.put("CB,A5", "RES 4,L");
        contenedorInstrucciones.put("CB,A6", "RES 4,(HL)");
        contenedorInstrucciones.put("DD,CB,d,A6", "RES 4,(IX+d)");
        contenedorInstrucciones.put("FD,CB,d,A6", "RES 4,(IY+d)");
        contenedorInstrucciones.put("CB,AF", "RES 5,A");
        contenedorInstrucciones.put("CB,A8", "RES 5,B");
        contenedorInstrucciones.put("CB,A9", "RES 5,C");
        contenedorInstrucciones.put("CB,AA", "RES 5,D");
        contenedorInstrucciones.put("CB,AB", "RES 5,E");
        contenedorInstrucciones.put("CB,AC", "RES 5,H");
        contenedorInstrucciones.put("CB,AD", "RES 5,L");
        contenedorInstrucciones.put("CB,AE", "RES 5,(HL)");
        contenedorInstrucciones.put("DD,CB,d,AE", "RES 5,(IX+d)");
        contenedorInstrucciones.put("FD,CB,d,AE", "RES 5,(IY+d)");
        contenedorInstrucciones.put("CB,B7", "RES 6,A");
        contenedorInstrucciones.put("CB,B0", "RES 6,B");
        contenedorInstrucciones.put("CB,B1", "RES 6,C");
        contenedorInstrucciones.put("CB,B2", "RES 6,D");
        contenedorInstrucciones.put("CB,B3", "RES 6,E");
        contenedorInstrucciones.put("CB,B4", "RES 6,H");
        contenedorInstrucciones.put("CB,B5", "RES 6,L");
        contenedorInstrucciones.put("CB,B6", "RES 6,(HL)");
        contenedorInstrucciones.put("DD,CB,d,B6", "RES 6,(IX+d)");
        contenedorInstrucciones.put("FD,CB,d,B6", "RES 6,(IY+d)");
        contenedorInstrucciones.put("CB,BF", "RES 7,A");
        contenedorInstrucciones.put("CB,B8", "RES 7,B");
        contenedorInstrucciones.put("CB,B9", "RES 7,C");
        contenedorInstrucciones.put("CB,BA", "RES 7,D");
        contenedorInstrucciones.put("CB,BB", "RES 7,E");
        contenedorInstrucciones.put("CB,BC", "RES 7,H");
        contenedorInstrucciones.put("CB,BD", "RES 7,L");
        contenedorInstrucciones.put("CB,BE", "RES 7,(HL)");
        contenedorInstrucciones.put("DD,CB,d,BE", "RES 7,(IX+d)");
        contenedorInstrucciones.put("FD,CB,d,BE", "RES 7,(IY+d)");
        contenedorInstrucciones.put("CB,C7", "SET 0,A");
        contenedorInstrucciones.put("CB,C0", "SET 0,B");
        contenedorInstrucciones.put("CB,C1", "SET 0,C");
        contenedorInstrucciones.put("CB,C2", "SET 0,D");
        contenedorInstrucciones.put("CB,C3", "SET 0,E");
        contenedorInstrucciones.put("CB,C4", "SET 0,H");
        contenedorInstrucciones.put("CB,C5", "SET 0,L");
        contenedorInstrucciones.put("CB,C6", "SET 0,(HL)");
        contenedorInstrucciones.put("DD,CB,d,C6", "SET 0,(IX+d)");
        contenedorInstrucciones.put("FD,CB,d,C6", "SET 0,(IY+d)");
        contenedorInstrucciones.put("CB,CF", "SET 1,A");
        contenedorInstrucciones.put("CB,C8", "SET 1,B");
        contenedorInstrucciones.put("CB,C9", "SET 1,C");
        contenedorInstrucciones.put("CB,CA", "SET 1,D");
        contenedorInstrucciones.put("CB,CB", "SET 1,E");
        contenedorInstrucciones.put("CB,CC", "SET 1,H");
        contenedorInstrucciones.put("CB,CD", "SET 1,L");
        contenedorInstrucciones.put("CB,CE", "SET 1,(HL)");
        contenedorInstrucciones.put("DD,CB,d,CE", "SET 1,(IX+d)");
        contenedorInstrucciones.put("FD,CB,d,CE", "SET 1,(IY+d)");
        contenedorInstrucciones.put("CB,D7", "SET 2,A");
        contenedorInstrucciones.put("CB,D0", "SET 2,B");
        contenedorInstrucciones.put("CB,D1", "SET 2,C");
        contenedorInstrucciones.put("CB,D2", "SET 2,D");
        contenedorInstrucciones.put("CB,D3", "SET 2,E");
        contenedorInstrucciones.put("CB,D4", "SET 2,H");
        contenedorInstrucciones.put("CB,D5", "SET 2,L");
        contenedorInstrucciones.put("CB,D6", "SET 2,(HL)");
        contenedorInstrucciones.put("DD,CB,d,D6", "SET 2,(IX+d)");
        contenedorInstrucciones.put("FD,CB,d,D6", "SET 2,(IY+d)");
        contenedorInstrucciones.put("CB,DF", "SET 3,A");
        contenedorInstrucciones.put("CB,D8", "SET 3,B");
        contenedorInstrucciones.put("CB,D9", "SET 3,C");
        contenedorInstrucciones.put("CB,DA", "SET 3,D");
        contenedorInstrucciones.put("CB,DB", "SET 3,E");
        contenedorInstrucciones.put("CB,DC", "SET 3,H");
        contenedorInstrucciones.put("CB,DD", "SET 3,L");
        contenedorInstrucciones.put("CB,DE", "SET 3,(HL)");
        contenedorInstrucciones.put("DD,CB,d,DE", "SET 3,(IX+d)");
        contenedorInstrucciones.put("FD,CB,d,DE", "SET 3,(IY+d)");
        contenedorInstrucciones.put("CB,E7", "SET 4,A");
        contenedorInstrucciones.put("CB,E0", "SET 4,B");
        contenedorInstrucciones.put("CB,E1", "SET 4,C");
        contenedorInstrucciones.put("CB,E2", "SET 4,D");
        contenedorInstrucciones.put("CB,E3", "SET 4,E");
        contenedorInstrucciones.put("CB,E4", "SET 4,H");
        contenedorInstrucciones.put("CB,E5", "SET 4,L");
        contenedorInstrucciones.put("CB,E6", "SET 4,(HL)");
        contenedorInstrucciones.put("DD,CB,d,E6", "SET 4,(IX+d)");
        contenedorInstrucciones.put("FD,CB,d,E6", "SET 4,(IY+d)");
        contenedorInstrucciones.put("CB,EF", "SET 5,A");
        contenedorInstrucciones.put("CB,E8", "SET 5,B");
        contenedorInstrucciones.put("CB,E9", "SET 5,C");
        contenedorInstrucciones.put("CB,EA", "SET 5,D");
        contenedorInstrucciones.put("CB,EB", "SET 5,E");
        contenedorInstrucciones.put("CB,EC", "SET 5,H");
        contenedorInstrucciones.put("CB,ED", "SET 5,L");
        contenedorInstrucciones.put("CB,EE", "SET 5,(HL)");
        contenedorInstrucciones.put("DD,CB,d,EE", "SET 5,(IX+d)");
        contenedorInstrucciones.put("FD,CB,d,EE", "SET 5,(IY+d)");
        contenedorInstrucciones.put("CB,F7", "SET 6,A");
        contenedorInstrucciones.put("CB,F0", "SET 6,B");
        contenedorInstrucciones.put("CB,F1", "SET 6,C");
        contenedorInstrucciones.put("CB,F2", "SET 6,D");
        contenedorInstrucciones.put("CB,F3", "SET 6,E");
        contenedorInstrucciones.put("CB,F4", "SET 6,H");
        contenedorInstrucciones.put("CB,F5", "SET 6,L");
        contenedorInstrucciones.put("CB,F6", "SET 6,(HL)");
        contenedorInstrucciones.put("DD,CB,d,F6", "SET 6,(IX+d)");
        contenedorInstrucciones.put("FD,CB,d,F6", "SET 6,(IY+d)");
        contenedorInstrucciones.put("CB,FF", "SET 7,A");
        contenedorInstrucciones.put("CB,F8", "SET 7,B");
        contenedorInstrucciones.put("CB,F9", "SET 7,C");
        contenedorInstrucciones.put("CB,FA", "SET 7,D");
        contenedorInstrucciones.put("CB,FB", "SET 7,E");
        contenedorInstrucciones.put("CB,FC", "SET 7,H");
        contenedorInstrucciones.put("CB,FD", "SET 7,L");
        contenedorInstrucciones.put("CB,FE", "SET 7,(HL)");
        contenedorInstrucciones.put("DD,CB,d,FE", "SET 7,(IX+d)");
        contenedorInstrucciones.put("FD,CB,d,FE", "SET 7,(IY+d)");
        contenedorInstrucciones.put("A7", "AND A");
        contenedorInstrucciones.put("A0", "AND B");
        contenedorInstrucciones.put("A1", "AND C");
        contenedorInstrucciones.put("A2", "AND D");
        contenedorInstrucciones.put("A3", "AND E");
        contenedorInstrucciones.put("A4", "AND H");
        contenedorInstrucciones.put("A5", "AND L");
        contenedorInstrucciones.put("A6", "AND (HL)");
        contenedorInstrucciones.put("E6,n", "AND n");
        contenedorInstrucciones.put("DD,A6,d", "AND (IX+d)");
        contenedorInstrucciones.put("FD,A6,d", "AND (IY+d)");
        contenedorInstrucciones.put("AF", "XOR A");
        contenedorInstrucciones.put("A8", "XOR B");
        contenedorInstrucciones.put("A9", "XOR C");
        contenedorInstrucciones.put("AA", "XOR D");
        contenedorInstrucciones.put("AB", "XOR E");
        contenedorInstrucciones.put("AC", "XOR H");
        contenedorInstrucciones.put("AD", "XOR L");
        contenedorInstrucciones.put("AE", "XOR (HL)");
        contenedorInstrucciones.put("EE,n", "XOR n");
        contenedorInstrucciones.put("DD,AE,d", "XOR (IX+d)");
        contenedorInstrucciones.put("FD,AE,d", "XOR (IY+d)");
        contenedorInstrucciones.put("B7", "OR A");
        contenedorInstrucciones.put("B0", "OR B");
        contenedorInstrucciones.put("B1", "OR C");
        contenedorInstrucciones.put("B2", "OR D");
        contenedorInstrucciones.put("B3", "OR E");
        contenedorInstrucciones.put("B4", "OR H");
        contenedorInstrucciones.put("B5", "OR L");
        contenedorInstrucciones.put("B6", "OR (HL)");
        contenedorInstrucciones.put("F6,n", "OR n");
        contenedorInstrucciones.put("DD,B6,d", "OR (IX+d)");
        contenedorInstrucciones.put("FD,B6,d", "OR (IY+d)");
        contenedorInstrucciones.put("BF", "CP A");
        contenedorInstrucciones.put("B8", "CP B");
        contenedorInstrucciones.put("B9", "CP C");
        contenedorInstrucciones.put("BA", "CP D");
        contenedorInstrucciones.put("BB", "CP E");
        contenedorInstrucciones.put("BC", "CP H");
        contenedorInstrucciones.put("BD", "CP L");
        contenedorInstrucciones.put("BE", "CP (HL)");
        contenedorInstrucciones.put("FE,n", "CP n");
        contenedorInstrucciones.put("DD,BE,d", "CP (IX+d)");
        contenedorInstrucciones.put("FD,BE,d", "CP (IY+d)");
        contenedorInstrucciones.put("3C", "INC A");
        contenedorInstrucciones.put("04", "INC B");
        contenedorInstrucciones.put("0C", "INC C");
        contenedorInstrucciones.put("14", "INC D");
        contenedorInstrucciones.put("1C", "INC E");
        contenedorInstrucciones.put("24", "INC H");
        contenedorInstrucciones.put("2C", "INC L");
        contenedorInstrucciones.put("34", "INC (HL)");
        contenedorInstrucciones.put("DD,34,d", "INC (IX+d)");
        contenedorInstrucciones.put("FD,34,d", "INC (IY+d)");
        contenedorInstrucciones.put("3D", "DEC A");
        contenedorInstrucciones.put("05", "DEC B");
        contenedorInstrucciones.put("0D", "DEC C");
        contenedorInstrucciones.put("15", "DEC D");
        contenedorInstrucciones.put("1D", "DEC E");
        contenedorInstrucciones.put("25", "DEC H");
        contenedorInstrucciones.put("2D", "DEC L");
        contenedorInstrucciones.put("35", "DEC (HL)");
        contenedorInstrucciones.put("DD,35,d", "DEC (IX+d)");
        contenedorInstrucciones.put("FD,35,d", "DEC (IY+d)");
        contenedorInstrucciones.put("27", "DAA");
        contenedorInstrucciones.put("2F", "CPL");
        contenedorInstrucciones.put("ED,44", "NEG");
        contenedorInstrucciones.put("CB,1F", "RR A");
        contenedorInstrucciones.put("CB,18", "RR B");
        contenedorInstrucciones.put("CB,19", "RR C");
        contenedorInstrucciones.put("CB,1A", "RR D");
        contenedorInstrucciones.put("CB,1B", "RR E");
        contenedorInstrucciones.put("CB,1C", "RR H");
        contenedorInstrucciones.put("CB,1D", "RR L");
        contenedorInstrucciones.put("CB,1E", "RR (HL)");
        contenedorInstrucciones.put("DD,CB,d,1E", "RR (IX+d)");
        contenedorInstrucciones.put("FD,CB,d,1E", "RR (IY+d)");
        contenedorInstrucciones.put("CB,17", "RL A");
        contenedorInstrucciones.put("CB,10", "RL B");
        contenedorInstrucciones.put("CB,11", "RL C");
        contenedorInstrucciones.put("CB,12", "RL D");
        contenedorInstrucciones.put("CB,13", "RL E");
        contenedorInstrucciones.put("CB,14", "RL H");
        contenedorInstrucciones.put("CB,15", "RL L");
        contenedorInstrucciones.put("CB,16", "RL (HL)");
        contenedorInstrucciones.put("DD,CB,d,16", "RL (IX+d)");
        contenedorInstrucciones.put("FD,CB,d,16", "RL (IY+d)");
        contenedorInstrucciones.put("CB,0F", "RRC A");
        contenedorInstrucciones.put("CB,08", "RRC B");
        contenedorInstrucciones.put("CB,09", "RRC C");
        contenedorInstrucciones.put("CB,0A", "RRC D");
        contenedorInstrucciones.put("CB,0B", "RRC E");
        contenedorInstrucciones.put("CB,0C", "RRC H");
        contenedorInstrucciones.put("CB,0D", "RRC L");
        contenedorInstrucciones.put("CB,0E", "RRC (HL)");
        contenedorInstrucciones.put("DD,CB,d,0E", "RRC (IX+d)");
        contenedorInstrucciones.put("FD,CB,d,0E", "RRC (IY+d)");
        contenedorInstrucciones.put("CB,07", "RLC A");
        contenedorInstrucciones.put("CB,00", "RLC B");
        contenedorInstrucciones.put("CB,01", "RLC C");
        contenedorInstrucciones.put("CB,02", "RLC D");
        contenedorInstrucciones.put("CB,03", "RLC E");
        contenedorInstrucciones.put("CB,04", "RLC H");
        contenedorInstrucciones.put("CB,05", "RLC L");
        contenedorInstrucciones.put("CB,06", "RLC (HL)");
        contenedorInstrucciones.put("DD,CB,d,06", "RLC (IX+d)");
        contenedorInstrucciones.put("FD,CB,d,06", "RLC (IY+d)");
        contenedorInstrucciones.put("CB,2F", "SRA A");
        contenedorInstrucciones.put("CB,28", "SRA B");
        contenedorInstrucciones.put("CB,29", "SRA C");
        contenedorInstrucciones.put("CB,2A", "SRA D");
        contenedorInstrucciones.put("CB,2B", "SRA E");
        contenedorInstrucciones.put("CB,2C", "SRA H");
        contenedorInstrucciones.put("CB,2D", "SRA L");
        contenedorInstrucciones.put("CB,2E", "SRA (HL)");
        contenedorInstrucciones.put("DD,CB,d,2E", "SRA (IX+d)");
        contenedorInstrucciones.put("FD,CB,d,2E", "SRA (IY+d)");
        contenedorInstrucciones.put("CB,27", "SLA A");
        contenedorInstrucciones.put("CB,20", "SLA B");
        contenedorInstrucciones.put("CB,21", "SLA C");
        contenedorInstrucciones.put("CB,22", "SLA D");
        contenedorInstrucciones.put("CB,23", "SLA E");
        contenedorInstrucciones.put("CB,24", "SLA H");
        contenedorInstrucciones.put("CB,25", "SLA L");
        contenedorInstrucciones.put("CB,26", "SLA (HL)");
        contenedorInstrucciones.put("DD,CB,d,26", "SLA (IX+d)");
        contenedorInstrucciones.put("FD,CB,d,26", "SLA (IY+d)");
        contenedorInstrucciones.put("CB,3F", "SRL A");
        contenedorInstrucciones.put("CB,38", "SRL B");
        contenedorInstrucciones.put("CB,39", "SRL C");
        contenedorInstrucciones.put("CB,3A", "SRL D");
        contenedorInstrucciones.put("CB,3B", "SRL E");
        contenedorInstrucciones.put("CB,3C", "SRL H");
        contenedorInstrucciones.put("CB,3D", "SRL L");
        contenedorInstrucciones.put("CB,3E", "SRL (HL)");
        contenedorInstrucciones.put("DD,CB,d,3E", "SRL (IX+d)");
        contenedorInstrucciones.put("FD,CB,d,3E", "SRL (IY+d)");
        contenedorInstrucciones.put("0F", "RRCA");
        contenedorInstrucciones.put("07", "RLCA");
        contenedorInstrucciones.put("1F", "RRA");
        contenedorInstrucciones.put("17", "RLA");
        contenedorInstrucciones.put("ED,6F", "RLD (HL)");
        contenedorInstrucciones.put("EB", "EX DE,HL");
        contenedorInstrucciones.put("08", "EX AF,AF");
        contenedorInstrucciones.put("D9", "EXX");
        contenedorInstrucciones.put("E3", "EX (SP),HL");
        contenedorInstrucciones.put("DD,E3", "EX (SP),IX");
        contenedorInstrucciones.put("FD,E3", "EX (SP),IY");
        contenedorInstrucciones.put("76", "HALT");
        contenedorInstrucciones.put("ED,78", "IN A,(C)");
        contenedorInstrucciones.put("DB,n", "IN A,(n)");
        contenedorInstrucciones.put("ED,40", "IN B,(C)");
        contenedorInstrucciones.put("ED,48", "IN C,(C)");
        contenedorInstrucciones.put("ED,50", "IN D,(C)");
        contenedorInstrucciones.put("ED,58", "IN E,(C)");
        contenedorInstrucciones.put("ED,60", "IN H,(C)");
        contenedorInstrucciones.put("ED,68", "IN L,(C)");
        contenedorInstrucciones.put("ED,79", "IN (C),A");
        contenedorInstrucciones.put("D3,n", "IN (n),A");
        contenedorInstrucciones.put("ED,41", "IN (C),B");
        contenedorInstrucciones.put("ED,49", "IN (C),C");
        contenedorInstrucciones.put("ED,51", "IN (C),D");
        contenedorInstrucciones.put("ED,59", "IN (C),E");
        contenedorInstrucciones.put("ED,61", "IN (C),H");
        contenedorInstrucciones.put("ED,69", "IN (C),L");
        
    }

    public static void instruccionesCompilador(){
        InstruccionesCompilador.put("LD A,A", "7F");
        InstruccionesCompilador.put("LD A,B", "78");
        InstruccionesCompilador.put("LD A,C", "79");
        InstruccionesCompilador.put("LD A,D", "7A");
        InstruccionesCompilador.put("LD A,E", "7B");
        InstruccionesCompilador.put("LD A,H", "7C");
        InstruccionesCompilador.put("LD A,L", "7D");
        InstruccionesCompilador.put("LD B,A", "47");
        InstruccionesCompilador.put("LD B,B", "40");
        InstruccionesCompilador.put("LD B,C", "41");
        InstruccionesCompilador.put("LD B,D", "42");
        InstruccionesCompilador.put("LD B,E", "43");
        InstruccionesCompilador.put("LD B,H", "44");
        InstruccionesCompilador.put("LD B,L", "45");
        InstruccionesCompilador.put("LD C,A", "4F");
        InstruccionesCompilador.put("LD C,B", "48");
        InstruccionesCompilador.put("LD C,C", "49");
        InstruccionesCompilador.put("LD C,D", "4A");
        InstruccionesCompilador.put("LD C,E", "4B");
        InstruccionesCompilador.put("LD C,H", "4C");
        InstruccionesCompilador.put("LD C,L", "4D");
        InstruccionesCompilador.put("LD D,A", "57");
        InstruccionesCompilador.put("LD D,B", "50");
        InstruccionesCompilador.put("LD D,C", "51");
        InstruccionesCompilador.put("LD D,D", "52");
        InstruccionesCompilador.put("LD D,E", "53");
        InstruccionesCompilador.put("LD D,H", "54");
        InstruccionesCompilador.put("LD D,L", "55");
        InstruccionesCompilador.put("LD E,A", "5F");
        InstruccionesCompilador.put("LD E,B", "58");
        InstruccionesCompilador.put("LD E,C", "59");
        InstruccionesCompilador.put("LD E,D", "5A");
        InstruccionesCompilador.put("LD E,E", "5B");
        InstruccionesCompilador.put("LD E,H", "5C");
        InstruccionesCompilador.put("LD E,L", "5D");
        InstruccionesCompilador.put("LD H,A", "67");
        InstruccionesCompilador.put("LD H,B", "60");
        InstruccionesCompilador.put("LD H,C", "61");
        InstruccionesCompilador.put("LD H,D", "62");
        InstruccionesCompilador.put("LD H,E", "63");
        InstruccionesCompilador.put("LD H,H", "64");
        InstruccionesCompilador.put("LD H,L", "65");
        InstruccionesCompilador.put("LD L,A", "6F");
        InstruccionesCompilador.put("LD L,B", "68");
        InstruccionesCompilador.put("LD L,C", "69");
        InstruccionesCompilador.put("LD L,D", "6A");
        InstruccionesCompilador.put("LD L,E", "6B");
        InstruccionesCompilador.put("LD L,H", "6C");
        InstruccionesCompilador.put("LD L,L", "6D");
        InstruccionesCompilador.put("LD A,n", "3E,n");
        InstruccionesCompilador.put("LD B,n", "06,n");
        InstruccionesCompilador.put("LD C,n", "0E,n");
        InstruccionesCompilador.put("LD D,n", "16,n");
        InstruccionesCompilador.put("LD E,n", "1E,n");
        InstruccionesCompilador.put("LD H,n", "26,n");
        InstruccionesCompilador.put("LD L,n", "2E,n");
        InstruccionesCompilador.put("LD A,(HL)", "7E");
        InstruccionesCompilador.put("LD B,(HL)", "46");
        InstruccionesCompilador.put("LD C,(HL)", "4E");
        InstruccionesCompilador.put("LD D,(HL)", "56");
        InstruccionesCompilador.put("LD E,(HL)", "5E");
        InstruccionesCompilador.put("LD H,(HL)", "66");
        InstruccionesCompilador.put("LD L,(HL)", "6E");
        InstruccionesCompilador.put("LD A,(IX+d)", "DD,7E,d");
        InstruccionesCompilador.put("LD B,(IX+d)", "DD,46,d");
        InstruccionesCompilador.put("LD C,(IX+d)", "DD,4E,d");
        InstruccionesCompilador.put("LD D,(IX+d)", "DD,56,d");
        InstruccionesCompilador.put("LD E,(IX+d)", "DD,5E,d");
        InstruccionesCompilador.put("LD H,(IX+d)", "DD,66,d");
        InstruccionesCompilador.put("LD L,(IX+d)", "DD,6E,d");
        InstruccionesCompilador.put("LD A,(IY+d)", "FD,7E,d");
        InstruccionesCompilador.put("LD B,(IY+d)", "FD,46,d");
        InstruccionesCompilador.put("LD C,(IY+d)", "FD,4E,d");
        InstruccionesCompilador.put("LD D,(IY+d)", "FD,56,d");
        InstruccionesCompilador.put("LD E,(IY+d)", "FD,5E,d");
        InstruccionesCompilador.put("LD H,(IY+d)", "FD,66,d");
        InstruccionesCompilador.put("LD L,(IY+d)", "FD,6E,d");
        InstruccionesCompilador.put("LD (HL),A", "77");
        InstruccionesCompilador.put("LD (HL),B", "70");
        InstruccionesCompilador.put("LD (HL),C", "71");
        InstruccionesCompilador.put("LD (HL),D", "72");
        InstruccionesCompilador.put("LD (HL),E", "73");
        InstruccionesCompilador.put("LD (HL),H", "74");
        InstruccionesCompilador.put("LD (HL),L", "75");
        InstruccionesCompilador.put("LD (IX+d),A", "DD,77,d");
        InstruccionesCompilador.put("LD (IX+d),B", "DD,70,d");
        InstruccionesCompilador.put("LD (IX+d),C", "DD,71,d");
        InstruccionesCompilador.put("LD (IX+d),D", "DD,72,d");
        InstruccionesCompilador.put("LD (IX+d),E", "DD,73,d");
        InstruccionesCompilador.put("LD (IX+d),H", "DD,74,d");
        InstruccionesCompilador.put("LD (IX+d),L", "DD,75,d");
        InstruccionesCompilador.put("LD (IY+d),A", "FD,77,d");
        InstruccionesCompilador.put("LD (IY+d),B", "FD,70,d");
        InstruccionesCompilador.put("LD (IY+d),C", "FD,71,d");
        InstruccionesCompilador.put("LD (IY+d),D", "FD,72,d");
        InstruccionesCompilador.put("LD (IY+d),E", "FD,73,d");
        InstruccionesCompilador.put("LD (IY+d),H", "FD,74,d");
        InstruccionesCompilador.put("LD (IY+d),L", "FD,75,d");
        InstruccionesCompilador.put("LD (HL),n", "36,n");
        InstruccionesCompilador.put("LD (IX+d),n", "DD,36,d,n");
        InstruccionesCompilador.put("LD (IY+d),n", "FD,36,d,n");
        InstruccionesCompilador.put("LD A,(BC)", "0A");
        InstruccionesCompilador.put("LD A,(DE)", "1A");
        InstruccionesCompilador.put("LD A,(nn)", "3A,n,n");
        InstruccionesCompilador.put("LD A,I", "ED,57");
        InstruccionesCompilador.put("LD A,R", "ED,5F");
        InstruccionesCompilador.put("LD (BC),A", "02");
        InstruccionesCompilador.put("LD (DE),A", "12");
        InstruccionesCompilador.put("LD (nn),A", "32,n,n");
        InstruccionesCompilador.put("LD I,A", "ED,47");
        InstruccionesCompilador.put("LD R,A", "ED,4F");
        InstruccionesCompilador.put("LD BC,nn", "01,n,n");
        InstruccionesCompilador.put("LD DE,nn", "11,n,n");
        InstruccionesCompilador.put("LD HL,nn", "21,n,n");
        InstruccionesCompilador.put("LD SP,nn", "31,n,n");
        InstruccionesCompilador.put("LD IX,nn", "DD,21,n,n");
        InstruccionesCompilador.put("LD IY,nn", "FD,21,n,n");
        InstruccionesCompilador.put("LD HL,(nn)", "2A,n,n");
        InstruccionesCompilador.put("LD BC,(nn)", "ED,4B,n,n");
        InstruccionesCompilador.put("LD DE,(nn)", "ED,5B,n,n");
        InstruccionesCompilador.put("LD SP,(nn)", "ED,7B,n,n");
        InstruccionesCompilador.put("LD IX,(nn)", "DD,2A,n,n");
        InstruccionesCompilador.put("LD IY,(nn)", "FD,2A,n,n");
        InstruccionesCompilador.put("LD (nn),HL", "22,n,n");
        InstruccionesCompilador.put("LD (nn),BC", "ED,43,n,n");
        InstruccionesCompilador.put("LD (nn),DE", "ED,53,n,n");
        InstruccionesCompilador.put("LD (nn),SP", "ED,73,n,n");
        InstruccionesCompilador.put("LD (nn),IX", "DD,22,n,n");
        InstruccionesCompilador.put("LD (nn),IY", "FD,22,n,n");
        InstruccionesCompilador.put("LD SP,HL", "F9");
        InstruccionesCompilador.put("LD SP,IX", "DD,F9");
        InstruccionesCompilador.put("LD SP,IY", "FD,F9");
        InstruccionesCompilador.put("PUSH BC", "C5");
        InstruccionesCompilador.put("PUSH DE", "D5");
        InstruccionesCompilador.put("PUSH HL", "E5");
        InstruccionesCompilador.put("PUSH AF", "F5");
        InstruccionesCompilador.put("PUSH IX", "DD,E5");
        InstruccionesCompilador.put("PUSH IY", "FD,E5");
        InstruccionesCompilador.put("POP BC", "C1");
        InstruccionesCompilador.put("POP DE", "D1");
        InstruccionesCompilador.put("POP HL", "E1");
        InstruccionesCompilador.put("POP AF", "F1");
        InstruccionesCompilador.put("POP IX", "DD,E1");
        InstruccionesCompilador.put("POP IY", "FD,E1");
        InstruccionesCompilador.put("ADD A,A", "87");
        InstruccionesCompilador.put("ADD A,B", "80");
        InstruccionesCompilador.put("ADD A,C", "81");
        InstruccionesCompilador.put("ADD A,D", "82");
        InstruccionesCompilador.put("ADD A,E", "83");
        InstruccionesCompilador.put("ADD A,H", "84");
        InstruccionesCompilador.put("ADD A,L", "85");
        InstruccionesCompilador.put("ADD A,n", "C6,n");
        InstruccionesCompilador.put("ADD A,(HL)", "86");
        InstruccionesCompilador.put("ADD A,(IX+d)", "DD,86,d");
        InstruccionesCompilador.put("ADD A,(IY+d)", "FD,86,d");
        InstruccionesCompilador.put("ADC A,A", "8F");
        InstruccionesCompilador.put("ADC A,B", "88");
        InstruccionesCompilador.put("ADC A,C", "89");
        InstruccionesCompilador.put("ADC A,D", "8A");
        InstruccionesCompilador.put("ADC A,E", "8B");
        InstruccionesCompilador.put("ADC A,H", "8C");
        InstruccionesCompilador.put("ADC A,L", "8D");
        InstruccionesCompilador.put("ADC A,n", "CE,n");
        InstruccionesCompilador.put("ADC A,(HL)", "8E");
        InstruccionesCompilador.put("ADC A,(IX+d)", "DD,8E,d");
        InstruccionesCompilador.put("ADC A,(IY+d)", "FD,8E,d");
        InstruccionesCompilador.put("SUB A", "97");
        InstruccionesCompilador.put("SUB B", "90");
        InstruccionesCompilador.put("SUB C", "91");
        InstruccionesCompilador.put("SUB D", "92");
        InstruccionesCompilador.put("SUB E", "93");
        InstruccionesCompilador.put("SUB H", "94");
        InstruccionesCompilador.put("SUB L", "95");
        InstruccionesCompilador.put("SUB n", "D6,n");
        InstruccionesCompilador.put("SUB (HL)", "96");
        InstruccionesCompilador.put("SUB (IX+d)", "DD,96,d");
        InstruccionesCompilador.put("SUB (IY+d)", "FD,96,d");
        InstruccionesCompilador.put("SBC A,A", "9F");
        InstruccionesCompilador.put("SBC A,B", "98");
        InstruccionesCompilador.put("SBC A,C", "99");
        InstruccionesCompilador.put("SBC A,D", "9A");
        InstruccionesCompilador.put("SBC A,E", "9B");
        InstruccionesCompilador.put("SBC A,H", "9C");
        InstruccionesCompilador.put("SBC A,L", "9D");
        InstruccionesCompilador.put("SBC A,n", "DE,n");
        InstruccionesCompilador.put("SBC A,(HL)", "9E");
        InstruccionesCompilador.put("SBC A,(IX+d)", "DD,9E,d");
        InstruccionesCompilador.put("SBC A,(IY+d)", "FD,9E,d");
        InstruccionesCompilador.put("JP Z,nn", "CA,n,n");
        InstruccionesCompilador.put("JP NZ,nn", "C2,n,n");
        InstruccionesCompilador.put("JP C,nn", "DA,n,n");
        InstruccionesCompilador.put("JP NC,nn", "D2,n,n");
        InstruccionesCompilador.put("JP PE,nn", "EA,n,n");
        InstruccionesCompilador.put("JP PO,nn", "E2,n,n");
        InstruccionesCompilador.put("JP M,nn", "FA,n,n");
        InstruccionesCompilador.put("JP P,nn", "F2,n,n");
        InstruccionesCompilador.put("JP (HL)", "E9");
        InstruccionesCompilador.put("JP (IX)", "DD,E9");
        InstruccionesCompilador.put("JP (IY)", "FD,E9");
        InstruccionesCompilador.put("JP nn", "C3,n,n");
        InstruccionesCompilador.put("JR Z,d", "28,d");
        InstruccionesCompilador.put("JR NZ,d", "20,d");
        InstruccionesCompilador.put("JR C,d", "38,d");
        InstruccionesCompilador.put("JR NC,d", "30,d");
        InstruccionesCompilador.put("JR d", "18,d");
        InstruccionesCompilador.put("DJNZ d", "10,d");
        InstruccionesCompilador.put("CALL Z,nn", "CC,n,n");
        InstruccionesCompilador.put("CALL NZ,nn", "C4,n,n");
        InstruccionesCompilador.put("CALL C,nn", "DC,n,n");
        InstruccionesCompilador.put("CALL NC,nn", "D4,n,n");
        InstruccionesCompilador.put("CALL PE,nn", "EC,n,n");
        InstruccionesCompilador.put("CALL PO,nn", "E4,n,n");
        InstruccionesCompilador.put("CALL M,nn", "FC,n,n");
        InstruccionesCompilador.put("CALL P,nn", "F4,n,n");
        InstruccionesCompilador.put("CALL nn", "CD,n,n");
        InstruccionesCompilador.put("RET Z", "C8");
        InstruccionesCompilador.put("RET NZ", "C0");
        InstruccionesCompilador.put("RET C", "D8");
        InstruccionesCompilador.put("RET NC", "D0");
        InstruccionesCompilador.put("RET PE", "E8");
        InstruccionesCompilador.put("RET PO", "E0");
        InstruccionesCompilador.put("RET M", "F8");
        InstruccionesCompilador.put("RET P", "F0");
        InstruccionesCompilador.put("RET", "C9");
        InstruccionesCompilador.put("RETI", "ED,4D");
        InstruccionesCompilador.put("RETN", "ED,45");
        InstruccionesCompilador.put("RST 00", "C7");
        InstruccionesCompilador.put("RST 08", "CF");
        InstruccionesCompilador.put("RST 10", "D7");
        InstruccionesCompilador.put("RST 18", "DF");
        InstruccionesCompilador.put("RST 20", "E7");
        InstruccionesCompilador.put("RST 28", "EF");
        InstruccionesCompilador.put("RST 30", "F7");
        InstruccionesCompilador.put("RST 38", "FF");
        InstruccionesCompilador.put("BIT 0,A", "CB,47");
        InstruccionesCompilador.put("BIT 0,B", "CB,40");
        InstruccionesCompilador.put("BIT 0,C", "CB,41");
        InstruccionesCompilador.put("BIT 0,D", "CB,42");
        InstruccionesCompilador.put("BIT 0,E", "CB,43");
        InstruccionesCompilador.put("BIT 0,H", "CB,44");
        InstruccionesCompilador.put("BIT 0,L", "CB,45");
        InstruccionesCompilador.put("BIT 0,(HL)", "CB,46");
        InstruccionesCompilador.put("BIT 0,(IX+d)", "DD,CB,d,46");
        InstruccionesCompilador.put("BIT 0,(IY+d)", "FD,CB,d,46");
        InstruccionesCompilador.put("BIT 1,A", "CB,4F");
        InstruccionesCompilador.put("BIT 1,B", "CB,48");
        InstruccionesCompilador.put("BIT 1,C", "CB,49");
        InstruccionesCompilador.put("BIT 1,D", "CB,4A");
        InstruccionesCompilador.put("BIT 1,E", "CB,4B");
        InstruccionesCompilador.put("BIT 1,H", "CB,4C");
        InstruccionesCompilador.put("BIT 1,L", "CB,4D");
        InstruccionesCompilador.put("BIT 1,(HL)", "CB,4E");
        InstruccionesCompilador.put("BIT 1,(IX+d)", "DD,CB,d,4E");
        InstruccionesCompilador.put("BIT 1,(IY+d)", "FD,CB,d,4E");
        InstruccionesCompilador.put("BIT 2,A", "CB,57");
        InstruccionesCompilador.put("BIT 2,B", "CB,50");
        InstruccionesCompilador.put("BIT 2,C", "CB,51");
        InstruccionesCompilador.put("BIT 2,D", "CB,52");
        InstruccionesCompilador.put("BIT 2,E", "CB,53");
        InstruccionesCompilador.put("BIT 2,H", "CB,54");
        InstruccionesCompilador.put("BIT 2,L", "CB,55");
        InstruccionesCompilador.put("BIT 2,(HL)", "CB,56");
        InstruccionesCompilador.put("BIT 2,(IX+d)", "DD,CB,d,56");
        InstruccionesCompilador.put("BIT 2,(IY+d)", "FD,CB,d,56");
        InstruccionesCompilador.put("BIT 3,A", "CB,5F");
        InstruccionesCompilador.put("BIT 3,B", "CB,58");
        InstruccionesCompilador.put("BIT 3,C", "CB,59");
        InstruccionesCompilador.put("BIT 3,D", "CB,5A");
        InstruccionesCompilador.put("BIT 3,E", "CB,5B");
        InstruccionesCompilador.put("BIT 3,H", "CB,5C");
        InstruccionesCompilador.put("BIT 3,L", "CB,5D");
        InstruccionesCompilador.put("BIT 3,(HL)", "CB,5E");
        InstruccionesCompilador.put("BIT 3,(IX+d)", "DD,CB,d,5E");
        InstruccionesCompilador.put("BIT 3,(IY+d)", "FD,CB,d,5E");
        InstruccionesCompilador.put("BIT 4,A", "CB,67");
        InstruccionesCompilador.put("BIT 4,B", "CB,60");
        InstruccionesCompilador.put("BIT 4,C", "CB,61");
        InstruccionesCompilador.put("BIT 4,D", "CB,62");
        InstruccionesCompilador.put("BIT 4,E", "CB,63");
        InstruccionesCompilador.put("BIT 4,H", "CB,64");
        InstruccionesCompilador.put("BIT 4,L", "CB,65");
        InstruccionesCompilador.put("BIT 4,(HL)", "CB,66");
        InstruccionesCompilador.put("BIT 4,(IX+d)", "DD,CB,d,66");
        InstruccionesCompilador.put("BIT 4,(IY+d)", "FD,CB,d,66");
        InstruccionesCompilador.put("BIT 5,A", "CB,6F");
        InstruccionesCompilador.put("BIT 5,B", "CB,68");
        InstruccionesCompilador.put("BIT 5,C", "CB,69");
        InstruccionesCompilador.put("BIT 5,D", "CB,6A");
        InstruccionesCompilador.put("BIT 5,E", "CB,6B");
        InstruccionesCompilador.put("BIT 5,H", "CB,6C");
        InstruccionesCompilador.put("BIT 5,L", "CB,6D");
        InstruccionesCompilador.put("BIT 5,(HL)", "CB,6E");
        InstruccionesCompilador.put("BIT 5,(IX+d)", "DD,CB,d,6E");
        InstruccionesCompilador.put("BIT 5,(IY+d)", "FD,CB,d,6E");
        InstruccionesCompilador.put("BIT 6,A", "CB,77");
        InstruccionesCompilador.put("BIT 6,B", "CB,70");
        InstruccionesCompilador.put("BIT 6,C", "CB,71");
        InstruccionesCompilador.put("BIT 6,D", "CB,72");
        InstruccionesCompilador.put("BIT 6,E", "CB,73");
        InstruccionesCompilador.put("BIT 6,H", "CB,74");
        InstruccionesCompilador.put("BIT 6,L", "CB,75");
        InstruccionesCompilador.put("BIT 6,(HL)", "CB,76");
        InstruccionesCompilador.put("BIT 6,(IX+d)", "DD,CB,d,76");
        InstruccionesCompilador.put("BIT 6,(IY+d)", "FD,CB,d,76");
        InstruccionesCompilador.put("BIT 7,A", "CB,7F");
        InstruccionesCompilador.put("BIT 7,B", "CB,78");
        InstruccionesCompilador.put("BIT 7,C", "CB,79");
        InstruccionesCompilador.put("BIT 7,D", "CB,7A");
        InstruccionesCompilador.put("BIT 7,E", "CB,7B");
        InstruccionesCompilador.put("BIT 7,H", "CB,7C");
        InstruccionesCompilador.put("BIT 7,L", "CB,7D");
        InstruccionesCompilador.put("BIT 7,(HL)", "CB,7E");
        InstruccionesCompilador.put("BIT 7,(IX+d)", "DD,CB,d,7E");
        InstruccionesCompilador.put("BIT 7,(IY+d)", "FD,CB,d,E");
        InstruccionesCompilador.put("RES 0,A", "CB,87");
        InstruccionesCompilador.put("RES 0,B", "CB,80");
        InstruccionesCompilador.put("RES 0,C", "CB,81");
        InstruccionesCompilador.put("RES 0,D", "CB,82");
        InstruccionesCompilador.put("RES 0,E", "CB,83");
        InstruccionesCompilador.put("RES 0,H", "CB,84");
        InstruccionesCompilador.put("RES 0,L", "CB,85");
        InstruccionesCompilador.put("RES 0,(HL)", "CB,86");
        InstruccionesCompilador.put("RES 0,(IX+d)", "DD,CB,d,86");
        InstruccionesCompilador.put("RES 0,(IY+d)", "FD,CB,d,86");
        InstruccionesCompilador.put("RES 1,A", "CB,8F");
        InstruccionesCompilador.put("RES 1,B", "CB,88");
        InstruccionesCompilador.put("RES 1,C", "CB,89");
        InstruccionesCompilador.put("RES 1,D", "CB,8A");
        InstruccionesCompilador.put("RES 1,E", "CB,8B");
        InstruccionesCompilador.put("RES 1,H", "CB,8C");
        InstruccionesCompilador.put("RES 1,L", "CB,8D");
        InstruccionesCompilador.put("RES 1,(HL)", "CB,8E");
        InstruccionesCompilador.put("RES 1,(IX+d)", "DD,CB,d,8E");
        InstruccionesCompilador.put("RES 1,(IY+d)", "FD,CB,d,8E");
        InstruccionesCompilador.put("RES 2,A", "CB,97");
        InstruccionesCompilador.put("RES 2,B", "CB,90");
        InstruccionesCompilador.put("RES 2,C", "CB,91");
        InstruccionesCompilador.put("RES 2,D", "CB,92");
        InstruccionesCompilador.put("RES 2,E", "CB,93");
        InstruccionesCompilador.put("RES 2,H", "CB,94");
        InstruccionesCompilador.put("RES 2,L", "CB,95");
        InstruccionesCompilador.put("RES 2,(HL)", "CB,96");
        InstruccionesCompilador.put("RES 2,(IX+d)", "DD,CB,d,96");
        InstruccionesCompilador.put("RES 2,(IY+d)", "FD,CB,d,96");
        InstruccionesCompilador.put("RES 3,A", "CB,9F");
        InstruccionesCompilador.put("RES 3,B", "CB,98");
        InstruccionesCompilador.put("RES 3,C", "CB,99");
        InstruccionesCompilador.put("RES 3,D", "CB,9A");
        InstruccionesCompilador.put("RES 3,E", "CB,9B");
        InstruccionesCompilador.put("RES 3,H", "CB,9C");
        InstruccionesCompilador.put("RES 3,L", "CB,9D");
        InstruccionesCompilador.put("RES 3,(HL)", "CB,9E");
        InstruccionesCompilador.put("RES 3,(IX+d)", "DD,CB,d,9E");
        InstruccionesCompilador.put("RES 3,(IY+d)", "FD,CB,d,9E");
        InstruccionesCompilador.put("RES 4,A", "CB,A7");
        InstruccionesCompilador.put("RES 4,B", "CB,A0");
        InstruccionesCompilador.put("RES 4,C", "CB,A1");
        InstruccionesCompilador.put("RES 4,D", "CB,A2");
        InstruccionesCompilador.put("RES 4,E", "CB,A3");
        InstruccionesCompilador.put("RES 4,H", "CB,A4");
        InstruccionesCompilador.put("RES 4,L", "CB,A5");
        InstruccionesCompilador.put("RES 4,(HL)", "CB,A6");
        InstruccionesCompilador.put("RES 4,(IX+d)", "DD,CB,d,A6");
        InstruccionesCompilador.put("RES 4,(IY+d)", "FD,CB,d,A6");
        InstruccionesCompilador.put("RES 5,A", "CB,AF");
        InstruccionesCompilador.put("RES 5,B", "CB,A8");
        InstruccionesCompilador.put("RES 5,C", "CB,A9");
        InstruccionesCompilador.put("RES 5,D", "CB,AA");
        InstruccionesCompilador.put("RES 5,E", "CB,AB");
        InstruccionesCompilador.put("RES 5,H", "CB,AC");
        InstruccionesCompilador.put("RES 5,L", "CB,AD");
        InstruccionesCompilador.put("RES 5,(HL)", "CB,AE");
        InstruccionesCompilador.put("RES 5,(IX+d)", "DD,CB,d,AE");
        InstruccionesCompilador.put("RES 5,(IY+d)", "FD,CB,d,AE");
        InstruccionesCompilador.put("RES 6,A", "CB,B7");
        InstruccionesCompilador.put("RES 6,B", "CB,B0");
        InstruccionesCompilador.put("RES 6,C", "CB,B1");
        InstruccionesCompilador.put("RES 6,D", "CB,B2");
        InstruccionesCompilador.put("RES 6,E", "CB,B3");
        InstruccionesCompilador.put("RES 6,H", "CB,B4");
        InstruccionesCompilador.put("RES 6,L", "CB,B5");
        InstruccionesCompilador.put("RES 6,(HL)", "CB,B6");
        InstruccionesCompilador.put("RES 6,(IX+d)", "DD,CB,d,B6");
        InstruccionesCompilador.put("RES 6,(IY+d)", "FD,CB,d,B6");
        InstruccionesCompilador.put("RES 7,A", "CB,BF");
        InstruccionesCompilador.put("RES 7,B", "CB,B8");
        InstruccionesCompilador.put("RES 7,C", "CB,B9");
        InstruccionesCompilador.put("RES 7,D", "CB,BA");
        InstruccionesCompilador.put("RES 7,E", "CB,BB");
        InstruccionesCompilador.put("RES 7,H", "CB,BC");
        InstruccionesCompilador.put("RES 7,L", "CB,BD");
        InstruccionesCompilador.put("RES 7,(HL)", "CB,BE");
        InstruccionesCompilador.put("RES 7,(IX+d)", "DD,CB,d,BE");
        InstruccionesCompilador.put("RES 7,(IY+d)", "FD,CB,d,BE");
        InstruccionesCompilador.put("SET 0,A", "CB,C7");
        InstruccionesCompilador.put("SET 0,B", "CB,C0");
        InstruccionesCompilador.put("SET 0,C", "CB,C1");
        InstruccionesCompilador.put("SET 0,D", "CB,C2");
        InstruccionesCompilador.put("SET 0,E", "CB,C3");
        InstruccionesCompilador.put("SET 0,H", "CB,C4");
        InstruccionesCompilador.put("SET 0,L", "CB,C5");
        InstruccionesCompilador.put("SET 0,(HL)", "CB,C6");
        InstruccionesCompilador.put("SET 0,(IX+d)", "DD,CB,d,C6");
        InstruccionesCompilador.put("SET 0,(IY+d)", "FD,CB,d,C6");
        InstruccionesCompilador.put("SET 1,A", "CB,CF");
        InstruccionesCompilador.put("SET 1,B", "CB,C8");
        InstruccionesCompilador.put("SET 1,C", "CB,C9");
        InstruccionesCompilador.put("SET 1,D", "CB,CA");
        InstruccionesCompilador.put("SET 1,E", "CB,CB");
        InstruccionesCompilador.put("SET 1,H", "CB,CC");
        InstruccionesCompilador.put("SET 1,L", "CB,CD");
        InstruccionesCompilador.put("SET 1,(HL)", "CB,CE");
        InstruccionesCompilador.put("SET 1,(IX+d)", "DD,CB,d,CE");
        InstruccionesCompilador.put("SET 1,(IY+d)", "FD,CB,d,CE");
        InstruccionesCompilador.put("SET 2,A", "CB,D7");
        InstruccionesCompilador.put("SET 2,B", "CB,D0");
        InstruccionesCompilador.put("SET 2,C", "CB,D1");
        InstruccionesCompilador.put("SET 2,D", "CB,D2");
        InstruccionesCompilador.put("SET 2,E", "CB,D3");
        InstruccionesCompilador.put("SET 2,H", "CB,D4");
        InstruccionesCompilador.put("SET 2,L", "CB,D5");
        InstruccionesCompilador.put("SET 2,(HL)", "CB,D6");
        InstruccionesCompilador.put("SET 2,(IX+d)", "DD,CB,d,D6");
        InstruccionesCompilador.put("SET 2,(IY+d)", "FD,CB,d,D6");
        InstruccionesCompilador.put("SET 3,A", "CB,DF");
        InstruccionesCompilador.put("SET 3,B", "CB,D8");
        InstruccionesCompilador.put("SET 3,C", "CB,D9");
        InstruccionesCompilador.put("SET 3,D", "CB,DA");
        InstruccionesCompilador.put("SET 3,E", "CB,DB");
        InstruccionesCompilador.put("SET 3,H", "CB,DC");
        InstruccionesCompilador.put("SET 3,L", "CB,DD");
        InstruccionesCompilador.put("SET 3,(HL)", "CB,DE");
        InstruccionesCompilador.put("SET 3,(IX+d)", "DD,CB,d,DE");
        InstruccionesCompilador.put("SET 3,(IY+d)", "FD,CB,d,DE");
        InstruccionesCompilador.put("SET 4,A", "CB,E7");
        InstruccionesCompilador.put("SET 4,B", "CB,E0");
        InstruccionesCompilador.put("SET 4,C", "CB,E1");
        InstruccionesCompilador.put("SET 4,D", "CB,E2");
        InstruccionesCompilador.put("SET 4,E", "CB,E3");
        InstruccionesCompilador.put("SET 4,H", "CB,E4");
        InstruccionesCompilador.put("SET 4,L", "CB,E5");
        InstruccionesCompilador.put("SET 4,(HL)", "CB,E6");
        InstruccionesCompilador.put("SET 4,(IX+d)", "DD,CB,d,E6");
        InstruccionesCompilador.put("SET 4,(IY+d)", "FD,CB,d,E6");
        InstruccionesCompilador.put("SET 5,A", "CB,EF");
        InstruccionesCompilador.put("SET 5,B", "CB,E8");
        InstruccionesCompilador.put("SET 5,C", "CB,E9");
        InstruccionesCompilador.put("SET 5,D", "CB,EA");
        InstruccionesCompilador.put("SET 5,E", "CB,EB");
        InstruccionesCompilador.put("SET 5,H", "CB,EC");
        InstruccionesCompilador.put("SET 5,L", "CB,ED");
        InstruccionesCompilador.put("SET 5,(HL)", "CB,EE");
        InstruccionesCompilador.put("SET 5,(IX+d)", "DD,CB,d,EE");
        InstruccionesCompilador.put("SET 5,(IY+d)", "FD,CB,d,EE");
        InstruccionesCompilador.put("SET 6,A", "CB,F7");
        InstruccionesCompilador.put("SET 6,B", "CB,F0");
        InstruccionesCompilador.put("SET 6,C", "CB,F1");
        InstruccionesCompilador.put("SET 6,D", "CB,F2");
        InstruccionesCompilador.put("SET 6,E", "CB,F3");
        InstruccionesCompilador.put("SET 6,H", "CB,F4");
        InstruccionesCompilador.put("SET 6,L", "CB,F5");
        InstruccionesCompilador.put("SET 6,(HL)", "CB,F6");
        InstruccionesCompilador.put("SET 6,(IX+d)", "DD,CB,d,F6");
        InstruccionesCompilador.put("SET 6,(IY+d)", "FD,CB,d,F6");
        InstruccionesCompilador.put("SET 7,A", "CB,FF");
        InstruccionesCompilador.put("SET 7,B", "CB,F8");
        InstruccionesCompilador.put("SET 7,C", "CB,F9");
        InstruccionesCompilador.put("SET 7,D", "CB,FA");
        InstruccionesCompilador.put("SET 7,E", "CB,FB");
        InstruccionesCompilador.put("SET 7,H", "CB,FC");
        InstruccionesCompilador.put("SET 7,L", "CB,FD");
        InstruccionesCompilador.put("SET 7,(HL)", "CB,FE");
        InstruccionesCompilador.put("SET 7,(IX+d)", "DD,CB,d,FE");
        InstruccionesCompilador.put("SET 7,(IY+d)", "FD,CB,d,FE");
        InstruccionesCompilador.put("AND A", "A7");
        InstruccionesCompilador.put("AND B", "A0");
        InstruccionesCompilador.put("AND C", "A1");
        InstruccionesCompilador.put("AND D", "A2");
        InstruccionesCompilador.put("AND E", "A3");
        InstruccionesCompilador.put("AND H", "A4");
        InstruccionesCompilador.put("AND L", "A5");
        InstruccionesCompilador.put("AND (HL)", "A6");
        InstruccionesCompilador.put("AND n", "E6,n");
        InstruccionesCompilador.put("AND (IX+d)", "DD,A6,d");
        InstruccionesCompilador.put("AND (IY+d)", "FD,A6,d");
        InstruccionesCompilador.put("XOR A", "AF");
        InstruccionesCompilador.put("XOR B", "A8");
        InstruccionesCompilador.put("XOR C", "A9");
        InstruccionesCompilador.put("XOR D", "AA");
        InstruccionesCompilador.put("XOR E", "AB");
        InstruccionesCompilador.put("XOR H", "AC");
        InstruccionesCompilador.put("XOR L", "AD");
        InstruccionesCompilador.put("XOR (HL)", "AE");
        InstruccionesCompilador.put("XOR n", "EE,n");
        InstruccionesCompilador.put("XOR (IX+d)", "DD,AE,d");
        InstruccionesCompilador.put("XOR (IY+d)", "FD,AE,d");
        InstruccionesCompilador.put("OR A", "B7");
        InstruccionesCompilador.put("OR B", "B0");
        InstruccionesCompilador.put("OR C", "B1");
        InstruccionesCompilador.put("OR D", "B2");
        InstruccionesCompilador.put("OR E", "B3");
        InstruccionesCompilador.put("OR H", "B4");
        InstruccionesCompilador.put("OR L", "B5");
        InstruccionesCompilador.put("OR (HL)", "B6");
        InstruccionesCompilador.put("OR n", "F6,n");
        InstruccionesCompilador.put("OR (IX+d)", "DD,B6,d");
        InstruccionesCompilador.put("OR (IY+d)", "FD,B6,d");
        InstruccionesCompilador.put("CP A", "BF");
        InstruccionesCompilador.put("CP B", "B8");
        InstruccionesCompilador.put("CP C", "B9");
        InstruccionesCompilador.put("CP D", "BA");
        InstruccionesCompilador.put("CP E", "BB");
        InstruccionesCompilador.put("CP H", "BC");
        InstruccionesCompilador.put("CP L", "BD");
        InstruccionesCompilador.put("CP (HL)", "BE");
        InstruccionesCompilador.put("CP n", "FE,n");
        InstruccionesCompilador.put("CP (IX+d)", "DD,BE,d");
        InstruccionesCompilador.put("CP (IY+d)", "FD,BE,d");
        InstruccionesCompilador.put("INC A", "3C");
        InstruccionesCompilador.put("INC B", "04");
        InstruccionesCompilador.put("INC C", "0C");
        InstruccionesCompilador.put("INC D", "14");
        InstruccionesCompilador.put("INC E", "1C");
        InstruccionesCompilador.put("INC H", "24");
        InstruccionesCompilador.put("INC L", "2C");
        InstruccionesCompilador.put("INC (HL)", "34");
        InstruccionesCompilador.put("INC (IX+d)", "DD,34,d");
        InstruccionesCompilador.put("INC (IY+d)", "FD,34,d");
        InstruccionesCompilador.put("DEC A", "3D");
        InstruccionesCompilador.put("DEC B", "05");
        InstruccionesCompilador.put("DEC C", "0D");
        InstruccionesCompilador.put("DEC D", "15");
        InstruccionesCompilador.put("DEC E", "1D");
        InstruccionesCompilador.put("DEC H", "25");
        InstruccionesCompilador.put("DEC L", "2D");
        InstruccionesCompilador.put("DEC (HL)", "35");
        InstruccionesCompilador.put("DEC (IX+d)", "DD,35,d");
        InstruccionesCompilador.put("DEC (IY+d)", "FD,35,d");
        InstruccionesCompilador.put("DAA", "27");
        InstruccionesCompilador.put("CPL", "2F");
        InstruccionesCompilador.put("NEG", "ED,44");
        InstruccionesCompilador.put("RR A", "CB,1F");
        InstruccionesCompilador.put("RR B", "CB,18");
        InstruccionesCompilador.put("RR C", "CB,19");
        InstruccionesCompilador.put("RR D", "CB,1A");
        InstruccionesCompilador.put("RR E", "CB,1B");
        InstruccionesCompilador.put("RR H", "CB,1C");
        InstruccionesCompilador.put("RR L", "CB,1D");
        InstruccionesCompilador.put("RR (HL)", "CB,1E");
        InstruccionesCompilador.put("RR (IX+d)", "DD,CB,d,1E");
        InstruccionesCompilador.put("RR (IY+d)", "FD,CB,d,1E");
        InstruccionesCompilador.put("RL A", "CB,17");
        InstruccionesCompilador.put("RL B", "CB,10");
        InstruccionesCompilador.put("RL C", "CB,11");
        InstruccionesCompilador.put("RL D", "CB,12");
        InstruccionesCompilador.put("RL E", "CB,13");
        InstruccionesCompilador.put("RL H", "CB,14");
        InstruccionesCompilador.put("RL L", "CB,15");
        InstruccionesCompilador.put("RL (HL)", "CB,16");
        InstruccionesCompilador.put("RL (IX+d)", "DD,CB,d,16");
        InstruccionesCompilador.put("RL (IY+d)", "FD,CB,d,16");
        InstruccionesCompilador.put("RRC A", "CB,0F");
        InstruccionesCompilador.put("RRC B", "CB,08");
        InstruccionesCompilador.put("RRC C", "CB,09");
        InstruccionesCompilador.put("RRC D", "CB,0A");
        InstruccionesCompilador.put("RRC E", "CB,0B");
        InstruccionesCompilador.put("RRC H", "CB,0C");
        InstruccionesCompilador.put("RRC L", "CB,0D");
        InstruccionesCompilador.put("RRC (HL)", "CB,0E");
        InstruccionesCompilador.put("RRC (IX+d)", "DD,CB,d,0E");
        InstruccionesCompilador.put("RRC (IY+d)", "FD,CB,d,0E");
        InstruccionesCompilador.put("RLC A", "CB,07");
        InstruccionesCompilador.put("RLC B", "CB,00");
        InstruccionesCompilador.put("RLC C", "CB,01");
        InstruccionesCompilador.put("RLC D", "CB,02");
        InstruccionesCompilador.put("RLC E", "CB,03");
        InstruccionesCompilador.put("RLC H", "CB,04");
        InstruccionesCompilador.put("RLC L", "CB,05");
        InstruccionesCompilador.put("RLC (HL)", "CB,06");
        InstruccionesCompilador.put("RLC (IX+d)", "DD,CB,d,06");
        InstruccionesCompilador.put("RLC (IY+d)", "FD,CB,d,06");
        InstruccionesCompilador.put("SRA A", "CB,2F");
        InstruccionesCompilador.put("SRA B", "CB,28");
        InstruccionesCompilador.put("SRA C", "CB,29");
        InstruccionesCompilador.put("SRA D", "CB,2A");
        InstruccionesCompilador.put("SRA E", "CB,2B");
        InstruccionesCompilador.put("SRA H", "CB,2C");
        InstruccionesCompilador.put("SRA L", "CB,2D");
        InstruccionesCompilador.put("SRA (HL)", "CB,2E");
        InstruccionesCompilador.put("SRA (IX+d)", "DD,CB,d,2E");
        InstruccionesCompilador.put("SRA (IY+d)", "FD,CB,d,2E");
        InstruccionesCompilador.put("SLA A", "CB,27");
        InstruccionesCompilador.put("SLA B", "CB,20");
        InstruccionesCompilador.put("SLA C", "CB,21");
        InstruccionesCompilador.put("SLA D", "CB,22");
        InstruccionesCompilador.put("SLA E", "CB,23");
        InstruccionesCompilador.put("SLA H", "CB,24");
        InstruccionesCompilador.put("SLA L", "CB,25");
        InstruccionesCompilador.put("SLA (HL)", "CB,26");
        InstruccionesCompilador.put("SLA (IX+d)", "DD,CB,d,26");
        InstruccionesCompilador.put("SLA (IY+d)", "FD,CB,d,26");
        InstruccionesCompilador.put("SRL A", "CB,3F");
        InstruccionesCompilador.put("SRL B", "CB,38");
        InstruccionesCompilador.put("SRL C", "CB,39");
        InstruccionesCompilador.put("SRL D", "CB,3A");
        InstruccionesCompilador.put("SRL E", "CB,3B");
        InstruccionesCompilador.put("SRL H", "CB,3C");
        InstruccionesCompilador.put("SRL L", "CB,3D");
        InstruccionesCompilador.put("SRL (HL)", "CB,3E");
        InstruccionesCompilador.put("SRL (IX+d)", "DD,CB,d,3E");
        InstruccionesCompilador.put("SRL (IY+d)", "FD,CB,d,3E");
        InstruccionesCompilador.put("RRCA", "0F");
        InstruccionesCompilador.put("RLCA", "07");
        InstruccionesCompilador.put("RRA", "1F");
        InstruccionesCompilador.put("RLA", "17");
        InstruccionesCompilador.put("RLD (HL)", "ED,6F");
        InstruccionesCompilador.put("EX DE,HL", "EB");
        InstruccionesCompilador.put("EX AF,AF", "08");
        InstruccionesCompilador.put("EXX", "D9");
        InstruccionesCompilador.put("EX (SP),HL", "E3");
        InstruccionesCompilador.put("EX (SP),IX", "DD,E3");
        InstruccionesCompilador.put("EX (SP),IY", "FD,E3");
        InstruccionesCompilador.put("HALT", "76");
        InstruccionesCompilador.put("IN A,(C)", "ED,78");
        InstruccionesCompilador.put("IN A,(n)", "DB,n");
        InstruccionesCompilador.put("IN B,(C)", "ED,40");
        InstruccionesCompilador.put("IN C,(C)", "ED,48");
        InstruccionesCompilador.put("IN D,(C)", "ED,50");
        InstruccionesCompilador.put("IN E,(C)", "ED,58");
        InstruccionesCompilador.put("IN H,(C)", "ED,60");
        InstruccionesCompilador.put("IN L,(C)", "ED,68");
        InstruccionesCompilador.put("IN (C),A", "ED,79");
        InstruccionesCompilador.put("IN (n),A", "D3,n");
        InstruccionesCompilador.put("IN (C),B", "ED,41");
        InstruccionesCompilador.put("IN (C),C", "ED,49");
        InstruccionesCompilador.put("IN (C),D", "ED,51");
        InstruccionesCompilador.put("IN (C),E", "ED,59");
        InstruccionesCompilador.put("IN (C),H", "ED,61");
        InstruccionesCompilador.put("IN (C),L", "ED,69");
        
    }
    
}
