
package emuladorprocesadorz80;

import java.io.*;
import java.awt.Color;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.io.File;
import java.io.FileWriter;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class interfazProcesadorZ80 extends javax.swing.JFrame {

    public static EmuladorProcesadorZ80 procesador = new EmuladorProcesadorZ80();
    
    //public static MemoriaView0 RAM = new MemoriaView0();
    public static MemoTable memor = new MemoTable();
    //public static pastillaZ80 pastilla = new pastillaZ80();
    
    public static Hashtable<String,String> lineasEtiquetas =new Hashtable<String,String>();
    
    public static String cadenaMemoria="";
    public static int numeroLines =0;

    public interfazProcesadorZ80() {
        this.setResizable(false);
        initComponents();
        settearRegistros();
        colorRegistros();
        new Thread(new vistaBuffer()).start();
        pasoPaso.setEnabled(false);
        completoPaso.setEnabled(false);
        panelFauxiliar.setVisible(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelR = new javax.swing.JPanel();
        regL = new javax.swing.JLabel();
        regH = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        regB = new javax.swing.JLabel();
        regC = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        regD = new javax.swing.JLabel();
        regE = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panelRauxiliar = new javax.swing.JPanel();
        regLo = new javax.swing.JLabel();
        regHo = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        regBo = new javax.swing.JLabel();
        regCo = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        regDo = new javax.swing.JLabel();
        regEo = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        panelF = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        r5 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        r4 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        r3 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        r2 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        r1 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        r0 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        panelFauxiliar = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        r5o = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        r4o = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        r3o = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        r2o = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        r1o = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        r0o = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        panelIXIY = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        regIX = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        regIY = new javax.swing.JLabel();
        panelA = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        regA = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        regAo = new javax.swing.JLabel();
        contadores = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        PC = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        SP = new javax.swing.JLabel();
        txtBuffer = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        resetButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        codigoFuenteAlto = new javax.swing.JTextArea();
        tituloCaja1 = new javax.swing.JLabel();
        cargarCodigo1 = new javax.swing.JButton();
        completoPaso1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtOutput = new javax.swing.JTextArea();
        jLabel28 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        pasoPaso = new javax.swing.JButton();
        completoPaso = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        codigoFuenteAssm = new javax.swing.JTextArea();
        tituloCaja = new javax.swing.JLabel();
        cargarCodigo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EmulatorZ80");
        setMinimumSize(new java.awt.Dimension(1300, 650));
        setResizable(false);

        regL.setText("FFh");

        regH.setText("FFh");

        jLabel5.setText("H");

        jLabel6.setText("L");

        regB.setText("FFh");

        regC.setText("FFh");

        jLabel3.setText("B");

        jLabel4.setText("C");

        regD.setText("FFh");

        regE.setText("FFh");

        jLabel1.setText("D");

        jLabel2.setText("E");

        javax.swing.GroupLayout panelRLayout = new javax.swing.GroupLayout(panelR);
        panelR.setLayout(panelRLayout);
        panelRLayout.setHorizontalGroup(
            panelRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(regH, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(regB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(regD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21)
                .addGroup(panelRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRLayout.createSequentialGroup()
                        .addGroup(panelRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(regC, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(regL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(regE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelRLayout.setVerticalGroup(
            panelRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(regB)
                    .addComponent(regC))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(regD)
                    .addComponent(regE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(regH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(regL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        regLo.setText("FFh");

        regHo.setText("FFh");

        jLabel7.setText("H'");

        jLabel8.setText("L'");

        regBo.setText("FFh");

        regCo.setText("FFh");

        jLabel11.setText("B'");

        jLabel12.setText("C'");

        regDo.setText("FFh");

        regEo.setText("FFh");

        jLabel9.setText("D'");

        jLabel10.setText("E'");

        javax.swing.GroupLayout panelRauxiliarLayout = new javax.swing.GroupLayout(panelRauxiliar);
        panelRauxiliar.setLayout(panelRauxiliarLayout);
        panelRauxiliarLayout.setHorizontalGroup(
            panelRauxiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRauxiliarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRauxiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRauxiliarLayout.createSequentialGroup()
                        .addGroup(panelRauxiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelRauxiliarLayout.createSequentialGroup()
                                .addGroup(panelRauxiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(regDo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addGroup(panelRauxiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(regEo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRauxiliarLayout.createSequentialGroup()
                        .addGroup(panelRauxiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(regBo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(regHo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(panelRauxiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(regLo, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                            .addComponent(regCo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        panelRauxiliarLayout.setVerticalGroup(
            panelRauxiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRauxiliarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRauxiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRauxiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(regDo)
                    .addComponent(regEo))
                .addGap(18, 18, 18)
                .addGroup(panelRauxiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRauxiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(regBo)
                    .addComponent(regCo))
                .addGap(18, 18, 18)
                .addGroup(panelRauxiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRauxiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(regLo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(regHo))
                .addContainerGap())
        );

        jLabel18.setText("S");

        r5.setText("F");

        jLabel24.setText("Z");

        r4.setText("F");

        jLabel26.setText("H");

        r3.setText("F");

        jLabel22.setText("P/v");

        r2.setText("F");

        jLabel32.setText("N");

        r1.setText("F");

        jLabel30.setText("C");

        r0.setText("F");

        jLabel16.setText("F");

        javax.swing.GroupLayout panelFLayout = new javax.swing.GroupLayout(panelF);
        panelF.setLayout(panelFLayout);
        panelFLayout.setHorizontalGroup(
            panelFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFLayout.createSequentialGroup()
                .addGroup(panelFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelFLayout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelFLayout.createSequentialGroup()
                                .addComponent(r5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(r4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(r3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(r2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(r1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(r0, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelFLayout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelFLayout.setVerticalGroup(
            panelFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel24)
                    .addComponent(jLabel26)
                    .addComponent(jLabel22)
                    .addComponent(jLabel32)
                    .addComponent(jLabel30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r5)
                    .addComponent(r4)
                    .addComponent(r3)
                    .addComponent(r2)
                    .addComponent(r1)
                    .addComponent(r0))
                .addContainerGap())
        );

        jLabel20.setText("S");

        r5o.setText("F");

        jLabel25.setText("Z");

        r4o.setText("F");

        jLabel27.setText("H");

        r3o.setText("F");

        jLabel23.setText("P/v");

        r2o.setText("F");

        jLabel35.setText("N");

        r1o.setText("F");

        jLabel34.setText("C");

        r0o.setText("F");

        jLabel19.setText("F");

        javax.swing.GroupLayout panelFauxiliarLayout = new javax.swing.GroupLayout(panelFauxiliar);
        panelFauxiliar.setLayout(panelFauxiliarLayout);
        panelFauxiliarLayout.setHorizontalGroup(
            panelFauxiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFauxiliarLayout.createSequentialGroup()
                .addGroup(panelFauxiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFauxiliarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelFauxiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelFauxiliarLayout.createSequentialGroup()
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelFauxiliarLayout.createSequentialGroup()
                                .addComponent(r5o, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(r4o, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(r3o, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(r2o, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(r1o, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(r0o, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelFauxiliarLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelFauxiliarLayout.setVerticalGroup(
            panelFauxiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFauxiliarLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFauxiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel25)
                    .addComponent(jLabel27)
                    .addComponent(jLabel23)
                    .addComponent(jLabel35)
                    .addComponent(jLabel34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelFauxiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r5o)
                    .addComponent(r4o)
                    .addComponent(r3o)
                    .addComponent(r2o)
                    .addComponent(r1o)
                    .addComponent(r0o))
                .addContainerGap())
        );

        jLabel13.setText("IX");

        regIX.setText("FFFFh");

        jLabel14.setText("IY");

        regIY.setText("FFFFh");

        javax.swing.GroupLayout panelIXIYLayout = new javax.swing.GroupLayout(panelIXIY);
        panelIXIY.setLayout(panelIXIYLayout);
        panelIXIYLayout.setHorizontalGroup(
            panelIXIYLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIXIYLayout.createSequentialGroup()
                .addGroup(panelIXIYLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelIXIYLayout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelIXIYLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(panelIXIYLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(regIY, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelIXIYLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(regIX, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(57, 57, 57))
        );
        panelIXIYLayout.setVerticalGroup(
            panelIXIYLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIXIYLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(regIX)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(regIY)
                .addContainerGap())
        );

        jLabel15.setText("A");

        regA.setText("FFh");

        jLabel17.setText("A'");

        regAo.setText("FFh");

        javax.swing.GroupLayout panelALayout = new javax.swing.GroupLayout(panelA);
        panelA.setLayout(panelALayout);
        panelALayout.setHorizontalGroup(
            panelALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelALayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelALayout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelALayout.createSequentialGroup()
                        .addGroup(panelALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(regA, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                            .addComponent(regAo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(64, 64, 64))))
        );
        panelALayout.setVerticalGroup(
            panelALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelALayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel15)
                .addGap(4, 4, 4)
                .addComponent(regA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(regAo)
                .addContainerGap())
        );

        jLabel21.setText("PC");

        PC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PC.setText("FFFFh");

        jLabel29.setText("SP");

        SP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SP.setText("0000h");

        javax.swing.GroupLayout contadoresLayout = new javax.swing.GroupLayout(contadores);
        contadores.setLayout(contadoresLayout);
        contadoresLayout.setHorizontalGroup(
            contadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contadoresLayout.createSequentialGroup()
                .addGroup(contadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contadoresLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel21))
                    .addGroup(contadoresLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel29)))
                .addGap(36, 36, 36))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contadoresLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(contadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(SP)
                    .addComponent(PC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28))
        );
        contadoresLayout.setVerticalGroup(
            contadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contadoresLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(42, 42, 42)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SP)
                .addGap(27, 27, 27))
        );

        txtBuffer.setText("FFh");

        jLabel31.setFont(new java.awt.Font("Bookman Old Style", 2, 14)); // NOI18N
        jLabel31.setText("Buffer");

        resetButton1.setText("Reset");
        resetButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButton1ActionPerformed(evt);
            }
        });

        codigoFuenteAlto.setColumns(20);
        codigoFuenteAlto.setRows(5);
        codigoFuenteAlto.setText("ALGORITMO pruebas(a, b, c):\n{\n\t/* comentario simple */\n        /* multilinea\n\t\tcomentando\t*/\n\n\t#Probando condicional IF\n\ta = 1;\n\tsi (a>2) entonces{\n\t\timprimirPantalla(\"hola\");\n\t} \n\tsi_no si a==1{\n\t\timprimirPantalla(a);\n\t}\n\tsi_no {\n\t\timprimirPantalla(5);\n\t}\n\n\t#########################\n\t#Probando el iterador WHILE\n\ta=10;\n\tmientras a>2{\n\t\ta=a-1;\n\t\timprimirPantalla(a);\n\t}\n\n\t#################\n\t#Probando el iterador DO WHILE\n\ta=0;\n\thacer{\n\t\ta=a+1;\n\t\timprimirPantalla(a);\n\t}mientras a<10\n\n\t#################\n\t#Probando el condicional SWITCH \n\ta=1;\n\tseleccionar a {\n\t\tcaso 1: imprimirPantalla(1);\n\t\tcaso 2: imprimirPantalla(2);\n\t\tdefecto: imprimirPantalla(\"Defecto\");\n\t}\n\n\t#################\n\t#Probando el iterador FOR\n\tpara a=-8; a<=10; a=a+1 {\n\t\timprimirPantalla(a);\n\t}\n\n\t#################\n\t#Probando imprimir expresiones\n\timprimirPantalla (verdadero && falso);\n\timprimirPantalla (!falso || !verdadero);\n\timprimirPantalla (2>=5);\n\timprimirPantalla (5==(2+2*2-1));\n\n\t#################\n\t#Probando asignaciones\n\ta = \"Hola\";\n\tb = \"Mundo\";\n\timprimirPantalla (a + \" \" + b);\n\n\t#################\n\t#Probando ejecución de funciones predefinidas\n\timprimirPantalla (sen(2));\n\tpi=3.1415926;\n\timprimirPantalla (csc(cos(sen(tan(sec(pi))))));\n\ta = 2.3e15+2i+2+i;\n\timprimirPantalla (2.2+2i+a);\n\n\t#################\n\t#Probando vectores y matrices\n\tb = {2,3,4,5};\n\timprimirPantalla (b+b);\n\tc = {9,10,12,20};\n\timprimirPantalla (c-b);\n\timprimirPantalla (b+b+b);\n\tc = {{2,1,5},{2,2,9},{3,4,-1}};\n\timprimirPantalla (\"\");\n\timprimirMatriz (c);\n\timprimirPantalla (\"\");\n\timprimirPantalla (c+c);\n\timprimirPantalla (c*c);\n\timprimirPantalla (c-c);\n\timprimirPantalla (c[0][0]);\n\timprimirPantalla (c[1][2]);\n\timprimirPantalla (c[2][0]);\n\n\t#################\n\t#Definición de un procedimiento\n\tdef a (x, y) {\n\t\timprimirPantalla(x);\n\t}\n\tb = a(1,2);\n\tc = a(55,10);\n\tdef a (x, y) {\n\t\timprimirPantalla(x+y);\n\t}\n\td = a(32,5);\n\t\n\t#Definición de una función que retorna un STRING\n\tdef cadena b(x){\n\t\timprimirPantalla (2+2);\n\t\tretornar \"hola\"+\" \"+x;\n\t}\n\t\n\tc = b(\"camilo\");\n\timprimirPantalla (c);\n\n\t#Definición del factorial de 'x', definida iterativamente\n\tdef entero f(x){\n\t\taux = 1;\n\t\tpara (i=x; i>0; i=i-1) {\n\t\t\taux = aux * i;\n\t\t}\n\t\tretornar aux;\t\n\t}\n\td = f(10);\n\timprimirPantalla (d);\n\n\t#Definición recursiva del factorial de 'y'\n\tdef entero g(y){\n\t\tres = 0;\n\t\tsi y < 2 {\n\t\t\tres = 1;\n\t\t}\n\t\tsi_no {\n\t\t\tres = y * g(y-1);\n\t\t}\n\t\tretornar res;\n\t}\n\te = g(10);\n\timprimirPantalla (e);\n\t\n\t#Escribir en archivos\n\tlimpiarArchivo(\"file.txt\");\n\n\timprimirArchivo(\"file.txt\", 1);\n\n\tpara i = 0; i < tamanoArchivo(\"file.txt\"); i=i+1 {\n\t\t#imprimirArchivo(\"file.txt\", 1);\n\t\timprimirPantalla(sen(3.1415)*50*1);\n\t\t#imprimirArchivo(\"file.txt\", sen(3.1415)*50*1);\n\t}\n\n\tpara i = 0; i < tamanoArchivo(\"file.txt\"); i=i+1 {\n\t\ta = leerArchivo(\"file.txt\", i);\n\t\timprimirPantalla(a);\n\t}\n\n\n\tpara i = 0; i < 5; i=i+1 {\n    \t\tu = aleatorio(5,10);\n    \t\timprimirPantalla(u);\n    }\n}\n.");
        jScrollPane2.setViewportView(codigoFuenteAlto);

        tituloCaja1.setFont(new java.awt.Font("Bookman Old Style", 2, 14)); // NOI18N
        tituloCaja1.setText("Ingrese aquí su codigo en alto nivel");

        cargarCodigo1.setText("Compilar");
        cargarCodigo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarCodigo1ActionPerformed(evt);
            }
        });

        completoPaso1.setText("Ejecutar");
        completoPaso1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                completoPaso1ActionPerformed(evt);
            }
        });

        txtOutput.setEditable(false);
        txtOutput.setColumns(20);
        txtOutput.setRows(5);
        jScrollPane3.setViewportView(txtOutput);

        jLabel28.setText("SALIDA");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane3)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cargarCodigo1)
                                .addGap(18, 18, 18)
                                .addComponent(completoPaso1)
                                .addGap(18, 18, 18)
                                .addComponent(resetButton1)
                                .addGap(133, 133, 133))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tituloCaja1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)))))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloCaja1)
                .addGap(24, 24, 24)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel28)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cargarCodigo1)
                    .addComponent(completoPaso1)
                    .addComponent(resetButton1))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Alto Nivel", jPanel2);

        pasoPaso.setText("Ejecucion Paso a Paso");
        pasoPaso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasoPasoActionPerformed(evt);
            }
        });

        completoPaso.setText("Ejecucion Completa");
        completoPaso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                completoPasoActionPerformed(evt);
            }
        });

        resetButton.setText("Reset");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        codigoFuenteAssm.setColumns(20);
        codigoFuenteAssm.setRows(5);
        jScrollPane1.setViewportView(codigoFuenteAssm);

        tituloCaja.setFont(new java.awt.Font("Bookman Old Style", 2, 14)); // NOI18N
        tituloCaja.setText("Ingrese aquí su codigo en assembler");

        cargarCodigo.setText("Cargar Codigo");
        cargarCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarCodigoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cargarCodigo)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(resetButton)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(pasoPaso)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(completoPaso)))
                        .addGap(63, 63, 63))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(tituloCaja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloCaja)
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cargarCodigo)
                    .addComponent(pasoPaso)
                    .addComponent(completoPaso))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(resetButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Assembler", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(panelR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(panelRauxiliar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(panelIXIY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(panelFauxiliar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(panelF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(58, 58, 58))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelA, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(152, 152, 152)))
                        .addComponent(contadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(292, 292, 292)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtBuffer, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(panelRauxiliar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(panelR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(panelF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(panelFauxiliar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(contadores, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(panelIXIY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(panelA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(108, 108, 108)
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuffer)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        procesador.initEmul();
        codigoFuenteAssm.setEditable(true);
        codigoFuenteAssm.setText("");
        memor.rst();
        cargarCodigo.setEnabled(true);
        pasoPaso.setEnabled(false);
        completoPaso.setEnabled(false);
    }//GEN-LAST:event_resetButtonActionPerformed

    private void completoPasoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_completoPasoActionPerformed
        do {
            cadenaMemoria = procesador.nucleo();
            settearRegistros();
            //numeroLines++;
            numeroLines = Integer.parseInt(lineasEtiquetas.get(procesador.getPC()+"&"));
        } while (cadenaMemoria != null);
        memor.llenarMemoria(procesador.getMemoria(), procesador.getPos1());
        //memor.llenarMemoria(procesador.getMemo1(),procesador.getPos1(),procesador.getMemoria());
        System.out.println("memoria cargada");
        cargarCodigo.setEnabled(false);
        pasoPaso.setEnabled(false);
        completoPaso.setEnabled(false);
        //RAM.ram();
        //pastilla.setteardireciones();
        numeroLines = Integer.parseInt(lineasEtiquetas.get(procesador.getPC()+"&"));
        setearCodigo(numeroLines);
        //procesador.getMemoria());
    }//GEN-LAST:event_completoPasoActionPerformed

    private void pasoPasoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasoPasoActionPerformed
        cadenaMemoria = procesador.nucleo();
        //System.out.println(cadenaMemoria);
        settearRegistros();

        if (cadenaMemoria == null) {
            cargarCodigo.setEnabled(true);
            pasoPaso.setEnabled(false);
            completoPaso.setEnabled(false);
        }
        //RAM.ram();
        memor.llenarMemoria(procesador.getMemoria(), procesador.getPos1());
        //memor.llenarMemoria(procesador.getMemo1(),procesador.getPos1(),procesador.getMemoria());
        //pastilla.setteardireciones();
        numeroLines = Integer.parseInt(lineasEtiquetas.get(procesador.getPC()+"&"));

        setearCodigo(numeroLines);
    }//GEN-LAST:event_pasoPasoActionPerformed

    private void cargarCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarCodigoActionPerformed
        boolean bool =true;
        //System.out.println("<"+codigoFuente.getText()+">");
        codigoFuenteAssm.setEditable(false);
        PrintWriter pw;
        FileWriter guardado ;

        try {
            guardado = new FileWriter("archivo.txt");
            pw = new PrintWriter(guardado);
            codigoFuenteAssm.write(pw);
        } catch (IOException ex) {
            Logger.getLogger(interfazProcesadorZ80.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            procesador.almacenar();
            //cargar debera realizarse despues del linker
        } catch (Exception ex){//IOException ex) {
            System.out.println("paso  por catch");
            JOptionPane.showMessageDialog(rootPane, "El archivo no fue guardado con éxito en la ruta establecida");
            codigoFuenteAssm.setEditable(true);
            bool = false;
            Logger.getLogger(interfazProcesadorZ80.class.getName()).log(Level.SEVERE, null, ex);

        }
        if(bool){
            JOptionPane.showMessageDialog(rootPane, "El archivo fue guardado con éxito en la ruta establecida");
            this.setEnabled(false);
            new enlazador(this, true).setVisible(true);
            numeroLines = procesador.getPC();
            setearCodigo(0);
            try {
                cargarLineas();
            } catch (IOException ex) {
                Logger.getLogger(interfazProcesadorZ80.class.getName()).log(Level.SEVERE, null, ex);
            }
            cargarCodigo.setEnabled(false);
            this.setEnabled(true);

            pasoPaso.setEnabled(true);
            completoPaso.setEnabled(true);

            //RAM.ram();
            memor.setVisible(true);
            memor.llenarMemoria(procesador.getMemo1(), procesador.getPos1(),procesador.getMemoria());
            //pastilla.setteardireciones();
        }
    }//GEN-LAST:event_cargarCodigoActionPerformed

    private void completoPaso1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_completoPaso1ActionPerformed
        String text = "";
        String codigo = this.codigoFuenteAlto.getText();
        compLexer lexer = new compLexer(CharStreams.fromString(codigo));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        compParser parser = new compParser(tokens);
        ParseTree tree = parser.program();
        System.out.println(parser.assembler);
        this.txtOutput.setText(parser.assembler);//prueba
    }//GEN-LAST:event_completoPaso1ActionPerformed

    private void resetButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resetButton1ActionPerformed

    private void cargarCodigo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarCodigo1ActionPerformed
        boolean bool =true;
        //System.out.println("<"+codigoFuente.getText()+">");
        codigoFuenteAlto.setEditable(false);
        PrintWriter pw;
        FileWriter guardado ;

        try {
            guardado = new FileWriter("altonivel.txt");
            pw = new PrintWriter(guardado);
            codigoFuenteAlto.write(pw);
        } catch (IOException ex) {
            Logger.getLogger(interfazProcesadorZ80.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            procesador.almacenar();
        } catch (Exception ex){//IOException ex) {
            JOptionPane.showMessageDialog(rootPane, "El archivo no fue guardado con éxito en la ruta establecida");
        }
        if(bool){
            //Comienza Análisis Léxico
            int tokens=0;
        txtOutput.append("COMPILANDO...\n");
        txtOutput.append("1. COMIENZA ANÁLISIS LÉXICO...\n");
        txtOutput.append("\n");
        try {
            BufferedReader buffer = new BufferedReader(new FileReader("altonivel.txt"));
            AnalizadorLexico analizadorJFlex = new AnalizadorLexico(buffer);

            while (true) {
                TokenPersonalizado token = analizadorJFlex.yylex();

                if (!analizadorJFlex.existenTokens()) {
                    break;
                }
                tokens++;
                System.out.println(token.toString());
                txtOutput.append(token.toString()+"\n");
            }
            txtOutput.append("\n");
            txtOutput.append("-ANÁLISIS LÉXICO COMPLETADO CON ÉXITO-\n");
            txtOutput.append("- "+tokens+" Tokens encontrados-");
        } catch (Exception e) {
            txtOutput.append("-ERROR-\n");
            txtOutput.append(e.toString());
            System.out.println(e.toString());
        }
        //Finaliza Análisis Léxico
        }
        
        

    }//GEN-LAST:event_cargarCodigo1ActionPerformed

    public static void main(String args[]) throws IOException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(interfazProcesadorZ80.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(interfazProcesadorZ80.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(interfazProcesadorZ80.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(interfazProcesadorZ80.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        procesador.incializarRegistros();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new interfazProcesadorZ80().setVisible(true);
        });   
    }
        
    public void colorRegistros(){
        regB.setBackground(Color.WHITE);
        regB.setOpaque(true);
        regC.setBackground(Color.WHITE);
        regC.setOpaque(true);
        regH.setBackground(Color.WHITE);
        regH.setOpaque(true);
        regL.setBackground(Color.WHITE);
        regL.setOpaque(true);
        regD.setBackground(Color.WHITE);
        regD.setOpaque(true);
        regE.setBackground(Color.WHITE);
        regE.setOpaque(true);
        regBo.setBackground(Color.WHITE);
        regBo.setOpaque(true);
        regCo.setBackground(Color.WHITE);
        regCo.setOpaque(true);
        regHo.setBackground(Color.WHITE);
        regHo.setOpaque(true);
        regLo.setBackground(Color.WHITE);
        regLo.setOpaque(true);
        regDo.setBackground(Color.WHITE);
        regDo.setOpaque(true);
        regEo.setBackground(Color.WHITE);
        regEo.setOpaque(true);
        regA.setBackground(Color.WHITE);
        regA.setOpaque(true);
        regAo.setBackground(Color.WHITE);
        regAo.setOpaque(true);
        regIX.setBackground(Color.WHITE);
        regIX.setOpaque(true);
        regIY.setBackground(Color.WHITE);
        regIY.setOpaque(true);
        r0.setBackground(Color.WHITE);
        r0.setOpaque(true);
        r0o.setBackground(Color.WHITE);
        r0o.setOpaque(true);
        r1.setBackground(Color.WHITE);
        r1.setOpaque(true);
        r1o.setBackground(Color.WHITE);
        r1o.setOpaque(true);
        r2.setBackground(Color.WHITE);
        r2.setOpaque(true);
        r2o.setBackground(Color.WHITE);
        r2o.setOpaque(true);
        r3.setBackground(Color.WHITE);
        r3.setOpaque(true);
        r3o.setBackground(Color.WHITE);
        r3o.setOpaque(true);
        r4.setBackground(Color.WHITE);
        r4.setOpaque(true);
        r4o.setBackground(Color.WHITE);
        r4o.setOpaque(true);
        r5.setBackground(Color.WHITE);
        r5.setOpaque(true);
        r5o.setBackground(Color.WHITE);
        r5o.setOpaque(true);
        PC.setBackground(Color.WHITE);
        PC.setOpaque(true);
        SP.setBackground(Color.WHITE);
        SP.setOpaque(true);
        txtBuffer.setBackground(Color.WHITE);
        txtBuffer.setOpaque(true);
        
        regB.setBorder(BorderFactory.createLineBorder(Color.black));
        regC.setBorder(BorderFactory.createLineBorder(Color.black));
        regD.setBorder(BorderFactory.createLineBorder(Color.black));
        regE.setBorder(BorderFactory.createLineBorder(Color.black));
        regH.setBorder(BorderFactory.createLineBorder(Color.black));
        regL.setBorder(BorderFactory.createLineBorder(Color.black));
        regBo.setBorder(BorderFactory.createLineBorder(Color.black));
        regCo.setBorder(BorderFactory.createLineBorder(Color.black));
        regDo.setBorder(BorderFactory.createLineBorder(Color.black));
        regEo.setBorder(BorderFactory.createLineBorder(Color.black));
        regHo.setBorder(BorderFactory.createLineBorder(Color.black));
        regLo.setBorder(BorderFactory.createLineBorder(Color.black));
        regA.setBorder(BorderFactory.createLineBorder(Color.black));
        regAo.setBorder(BorderFactory.createLineBorder(Color.black));
        regIX.setBorder(BorderFactory.createLineBorder(Color.black));
        regIY.setBorder(BorderFactory.createLineBorder(Color.black));
        r0.setBorder(BorderFactory.createLineBorder(Color.black));
        r0o.setBorder(BorderFactory.createLineBorder(Color.black));
        r1.setBorder(BorderFactory.createLineBorder(Color.black));
        r1o.setBorder(BorderFactory.createLineBorder(Color.black));
        r2.setBorder(BorderFactory.createLineBorder(Color.black));
        r2o.setBorder(BorderFactory.createLineBorder(Color.black));
        r3.setBorder(BorderFactory.createLineBorder(Color.black));
        r3o.setBorder(BorderFactory.createLineBorder(Color.black));
        r4.setBorder(BorderFactory.createLineBorder(Color.black));
        r4o.setBorder(BorderFactory.createLineBorder(Color.black));
        r5.setBorder(BorderFactory.createLineBorder(Color.black));
        r5o.setBorder(BorderFactory.createLineBorder(Color.black));
        PC.setBorder(BorderFactory.createLineBorder(Color.black));
        SP.setBorder(BorderFactory.createLineBorder(Color.black));
        txtBuffer.setBorder(BorderFactory.createLineBorder(Color.black));
        
        panelR.setBorder(BorderFactory.createLineBorder(Color.black));
        panelRauxiliar.setBorder(BorderFactory.createLineBorder(Color.black));
        panelF.setBorder(BorderFactory.createLineBorder(Color.black));
        panelFauxiliar.setBorder(BorderFactory.createLineBorder(Color.black));
        panelA.setBorder(BorderFactory.createLineBorder(Color.black));
        panelIXIY.setBorder(BorderFactory.createLineBorder(Color.black));
        contadores.setBorder(BorderFactory.createLineBorder(Color.black));
        regHo.setEnabled(false);
        regLo.setEnabled(false);
        regDo.setEnabled(false);
        regEo.setEnabled(false);
        regBo.setEnabled(false);
        regCo.setEnabled(false);
        regAo.setEnabled(false);
        r0o.setEnabled(false);
        r1o.setEnabled(false);
        r2o.setEnabled(false);
        r3o.setEnabled(false);
        r4o.setEnabled(false);
        r5o.setEnabled(false);
        
        regA.setHorizontalAlignment(SwingConstants.CENTER);
        regAo.setHorizontalAlignment(SwingConstants.CENTER);
        regB.setHorizontalAlignment(SwingConstants.CENTER);
        regBo.setHorizontalAlignment(SwingConstants.CENTER);
        regC.setHorizontalAlignment(SwingConstants.CENTER);
        regCo.setHorizontalAlignment(SwingConstants.CENTER);
        regD.setHorizontalAlignment(SwingConstants.CENTER);
        regDo.setHorizontalAlignment(SwingConstants.CENTER);
        regE.setHorizontalAlignment(SwingConstants.CENTER);
        regEo.setHorizontalAlignment(SwingConstants.CENTER);
        regH.setHorizontalAlignment(SwingConstants.CENTER);
        regHo.setHorizontalAlignment(SwingConstants.CENTER);
        regL.setHorizontalAlignment(SwingConstants.CENTER);
        regLo.setHorizontalAlignment(SwingConstants.CENTER);
        regIX.setHorizontalAlignment(SwingConstants.CENTER);
        regIY.setHorizontalAlignment(SwingConstants.CENTER);
        r0.setHorizontalAlignment(SwingConstants.CENTER);
        r0o.setHorizontalAlignment(SwingConstants.CENTER);
        r1.setHorizontalAlignment(SwingConstants.CENTER);
        r1o.setHorizontalAlignment(SwingConstants.CENTER);
        r2.setHorizontalAlignment(SwingConstants.CENTER);
        r2o.setHorizontalAlignment(SwingConstants.CENTER);
        r3.setHorizontalAlignment(SwingConstants.CENTER);
        r3o.setHorizontalAlignment(SwingConstants.CENTER);
        r4.setHorizontalAlignment(SwingConstants.CENTER);
        r4o.setHorizontalAlignment(SwingConstants.CENTER);
        r5.setHorizontalAlignment(SwingConstants.CENTER);
        r5o.setHorizontalAlignment(SwingConstants.CENTER);
        PC.setHorizontalAlignment(SwingConstants.CENTER);
        SP.setHorizontalAlignment(SwingConstants.CENTER);
        tituloCaja.setHorizontalAlignment(SwingConstants.CENTER);
        txtBuffer.setHorizontalAlignment(SwingConstants.CENTER);
        
    }
    
    public void settearRegistros(){
        //RAM.setVisible(true);
        //pastilla.setVisible(true);
        
        
        completoPaso.setSelected(false);
        String cadena;
        cadena = procesador.getConversorBINtoHEXA(procesador.getRegB()); 
        regB.setText(cadena+"h");
        cadena = procesador.getConversorBINtoHEXA(procesador.getRegC());
        regC.setText(cadena+"h");
        cadena = procesador.getConversorBINtoHEXA(procesador.getRegD());
        regD.setText(cadena+"h");
        cadena = procesador.getConversorBINtoHEXA(procesador.getRegE());
        regE.setText(cadena+"h");
        cadena = procesador.getConversorBINtoHEXA(procesador.getRegH());
        regH.setText(cadena+"h");
        cadena = procesador.getConversorBINtoHEXA(procesador.getRegL());
        regL.setText(cadena+"h");
        cadena = procesador.getConversorBINtoHEXA(procesador.getRegBo()); 
        regBo.setText(cadena+"h");
        cadena = procesador.getConversorBINtoHEXA(procesador.getRegCo());
        regCo.setText(cadena+"h");
        cadena = procesador.getConversorBINtoHEXA(procesador.getRegDo());
        regDo.setText(cadena+"h");
        cadena = procesador.getConversorBINtoHEXA(procesador.getRegEo());
        regEo.setText(cadena+"h");
        cadena = procesador.getConversorBINtoHEXA(procesador.getRegHo());
        regHo.setText(cadena+"h");
        cadena = procesador.getConversorBINtoHEXA(procesador.getRegLo());
        regLo.setText(cadena+"h");
        cadena = procesador.getConversorBINtoHEXA(procesador.getRegA());
        regA.setText(cadena+"h");
        cadena = procesador.getConversorBINtoHEXA(procesador.getRegAo());
        regAo.setText(cadena+"h");
        cadena = procesador.getConversorBINtoHEXA(procesador.getIX());
        regIX.setText(cadena+"h");
        cadena = procesador.getConversorBINtoHEXA(procesador.getIY());
        regIY.setText(cadena+"h");
        cadena = Integer.toHexString(procesador.getPC()).toUpperCase();
        PC.setText(cadena+"h");
        cadena = Integer.toHexString(procesador.getSP()).toUpperCase();
        SP.setText(cadena+"h");
        
        char []f=procesador.getRegF();
        char []fo=procesador.getRegFo();
        r0.setText(f[0]+"");
        r1.setText(f[1]+"");
        r2.setText(f[2]+"");
        r3.setText(f[4]+"");
        r4.setText(f[6]+"");
        r5.setText(f[7]+"");
        r0o.setText(fo[0]+"");
        r1o.setText(fo[1]+"");
        r2o.setText(fo[2]+"");
        r3o.setText(fo[4]+"");
        r4o.setText(fo[5]+"");
        r5o.setText(fo[7]+"");
    }
    
    public void setearCodigo(int line){
        String lineas = "";
        String []codigo = codigoFuenteAssm.getText().split("\n");
        for (int i = 0; i < codigo.length; i++) {
            codigo[i] = codigo[i].replace("<<<<< ULTIMO >>>>>", "");
            if (line==i) {
                lineas = lineas+codigo[i]+"<<<<< ACTUAL >>>>>\n";
            }else{
                if (codigo[i].contains("<<<<< ACTUAL >>>>>")) {
                    
                    lineas = lineas+codigo[i].replace("<<<<< ACTUAL >>>>>", "<<<<< ULTIMO >>>>>\n");
                }else{
                    lineas = lineas+codigo[i]+"\n";
                }
            }
        }
        codigoFuenteAssm.setText(lineas);
    }
    
    public void cargarLineas() throws FileNotFoundException, IOException{
        String et;
        FileReader fEt = new FileReader("achivoEtiquetas.txt");
        BufferedReader bEt = new BufferedReader(fEt);
        String auxEt [];
        int nline =0;
        while ((et = bEt.readLine())!=null) {
            auxEt = et.split(" ");
            if (auxEt[0].contains("&")) {
                auxEt[0]= auxEt[0].replace("&", "");
                nline = Integer.parseInt(auxEt[0],16);
                nline = nline + numeroLines;
                auxEt[0]= nline+"&";
            }
            lineasEtiquetas.put(auxEt[0],auxEt[1]);
        } 
        bEt.close();
    }
    
    public class vistaBuffer implements Runnable {
        @Override
        public void run(){
            System.out.println("corriendo");
            String mensaje="h";
            String auxMensaje = "";
            while (true) {
                auxMensaje = procesador.getBuffer();
                //System.out.println("buffer---------"+auxMensaje+"+++++++");
                auxMensaje = auxMensaje+"h";
                if (mensaje != auxMensaje) {
                    mensaje = auxMensaje;
                    txtBuffer.setText(mensaje);    
                }
            }
        }
    }  
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PC;
    private javax.swing.JLabel SP;
    private javax.swing.JButton cargarCodigo;
    private javax.swing.JButton cargarCodigo1;
    private javax.swing.JTextArea codigoFuenteAlto;
    private javax.swing.JTextArea codigoFuenteAssm;
    private javax.swing.JButton completoPaso;
    private javax.swing.JButton completoPaso1;
    private javax.swing.JPanel contadores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel panelA;
    private javax.swing.JPanel panelF;
    private javax.swing.JPanel panelFauxiliar;
    private javax.swing.JPanel panelIXIY;
    private javax.swing.JPanel panelR;
    private javax.swing.JPanel panelRauxiliar;
    private javax.swing.JButton pasoPaso;
    private javax.swing.JLabel r0;
    private javax.swing.JLabel r0o;
    private javax.swing.JLabel r1;
    private javax.swing.JLabel r1o;
    private javax.swing.JLabel r2;
    private javax.swing.JLabel r2o;
    private javax.swing.JLabel r3;
    private javax.swing.JLabel r3o;
    private javax.swing.JLabel r4;
    private javax.swing.JLabel r4o;
    private javax.swing.JLabel r5;
    private javax.swing.JLabel r5o;
    private javax.swing.JLabel regA;
    private javax.swing.JLabel regAo;
    private javax.swing.JLabel regB;
    private javax.swing.JLabel regBo;
    private javax.swing.JLabel regC;
    private javax.swing.JLabel regCo;
    private javax.swing.JLabel regD;
    private javax.swing.JLabel regDo;
    private javax.swing.JLabel regE;
    private javax.swing.JLabel regEo;
    private javax.swing.JLabel regH;
    private javax.swing.JLabel regHo;
    private javax.swing.JLabel regIX;
    private javax.swing.JLabel regIY;
    private javax.swing.JLabel regL;
    private javax.swing.JLabel regLo;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton resetButton1;
    private javax.swing.JLabel tituloCaja;
    private javax.swing.JLabel tituloCaja1;
    private javax.swing.JLabel txtBuffer;
    private javax.swing.JTextArea txtOutput;
    // End of variables declaration//GEN-END:variables

}
