package emuladorprocesadorz80;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class MemoTable extends javax.swing.JDialog {
    
    public static EmuladorProcesadorZ80 procesador = new EmuladorProcesadorZ80();
    public static DefaultTableModel md;
    public static String [] memoria = new String [65536];
    public static String [][] memoria1 = new String [16][4096];
    public static String [] aux = new String[4096];
    public static String [] aux2 = new String[4096];
    String data[][];
    String cabeza[]={};
    
    public MemoTable() {
        initComponents();
        initMemo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(300, 600));
        setResizable(false);

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11", "Title 12", "Title 13", "Title 14", "Title 15", "Title 16", "Title 17"
            }
        ));
        jTable1.setColumnSelectionAllowed(true);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(6).setResizable(false);
            jTable1.getColumnModel().getColumn(7).setResizable(false);
            jTable1.getColumnModel().getColumn(8).setResizable(false);
            jTable1.getColumnModel().getColumn(9).setResizable(false);
            jTable1.getColumnModel().getColumn(10).setResizable(false);
            jTable1.getColumnModel().getColumn(11).setResizable(false);
            jTable1.getColumnModel().getColumn(12).setResizable(false);
            jTable1.getColumnModel().getColumn(13).setResizable(false);
            jTable1.getColumnModel().getColumn(14).setResizable(false);
            jTable1.getColumnModel().getColumn(15).setResizable(false);
            jTable1.getColumnModel().getColumn(16).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void initMemo(){
        md = new DefaultTableModel(data, cabeza);
        jTable1.setModel(md);
        for (int i = 0; i < 4096; i++) {
            aux[i]="00000000";
        }
        int y =0;
        for (int i = 0; i < 65536; i+=16) {
            String aux1 =EmuladorProcesadorZ80.conversorINTtoHEXA(i);
            aux2[y++]=aux1.substring(0,3).toUpperCase();
        }
        md.addColumn("", aux2);
        for (int i = 0; i < 16; i++) {
            memoria1[i]=aux;
            md.addColumn(trad(i), memoria1[i]);
        }
        jTable1.setModel(md);
        jTable1.doLayout();
    }    

    public void setData(String bin,String hex){
        int[] b = hexaToIndex(hex);
        int x = b[0];
        int y = b[1];
        //System.out.println(x+" "+y);
        memoria1[y][x]=bin;
        jTable1.setValueAt(bin, x, y+1);
        //jTable1.updateUI();
    }
    
    public void getDataTest(String bin,String hex){
        int[] b = hexaToIndex(hex);
        int x = b[0];
        int y = b[1];
        System.out.println(x+" "+y);
        memoria1[y][x]=bin;
        jTable1.setValueAt(bin, x, y+1);
        jTable1.updateUI();
    }
    
    public String trad(int num){
        if(num<10){
            return num+"";
        }else if(num>=10 && num<16){
            switch (num) {
                case 10:
                    return "A";
                case 11:
                    return "B";
                case 12:
                    return "C";
                case 13:
                    return "D";
                case 14:
                    return "E";
                case 15:
                    return "F";
            }
        }
        return null;
    }
    
    public int trad(String num){
        num=num.toUpperCase();
        if(num.equals("A")||num.equals("B")||num.equals("C")||num.equals("D")||num.equals("E")||num.equals("F")){
            switch (num) {
                case "A":
                    return 10;
                case "B":
                    return 11;
                case "C":
                    return 12;
                case "D":
                    return 13;
                case "E":
                    return 14;
                case "F":
                    return 15;
            }
        }else if(Integer.valueOf(num)<10){
            return Integer.valueOf(num);
        }
        return 0;
    }
    
    public void rst(){
        initMemo();
        jTable1.updateUI();
    }
    
    public int byteToInt (byte[] b){
        int v =0;
        int r =0;
        for (int i = 0; i <b.length; i++) {
            if(b[i]==1){
                v=(int)(Math.pow(2, r))+v;
            }
            r++;
        }
        return v;          
    }
    
    public int[] hexaToIndex(String hex){
        int y = (trad(hex.substring(3)));
        int x = byteToInt(new EmuladorProcesadorZ80().conversorHEXAtoBIN(hex.substring(0, 3)));
        int z = byteToInt(new EmuladorProcesadorZ80().conversorHEXAtoBIN(hex));
        int[] r =new int[3];
        r[0]=x;
        r[1]=y;
        r[2]=z;
        return r;
    }
    
    public void grapTable(){//String[] memo){
        ArrayList<String> nev = new ArrayList<>();
        nev.add("23");
        nev.add("23");
        nev.add("23");
        nev.add("23");
        nev.add("23");
        nev.add(2, "24");
        for (int i = 0; i < nev.size(); i++) {
            System.out.println(nev.get(i));
        }
    }
    
    public void llenarMemoria(ArrayList<String> memo, ArrayList<Integer> pos,String[] m){//change?
        memoria=m;
        int y = pos.get(0);
        for (int i = 0; i < memo.size(); i++) {
            String x = memo.get(i);
            if(x.length()>15){
                String z = x.substring(0,8);
                String w = x.substring(8);
                setData(z, new EmuladorProcesadorZ80().conversorINTtoHEXA(y++));
                setData(w, new EmuladorProcesadorZ80().conversorINTtoHEXA(y++));
            }else{
                setData(x, new EmuladorProcesadorZ80().conversorINTtoHEXA(y++));
            }
            if(y==65535){
                break;
            }
        }
        jTable1.updateUI();
    }
    
    public void llenarMemoria(String[] memo1,ArrayList<Integer> pos){//change?
        ArrayList<String> memo = new ArrayList<>(Arrays.asList(memo1));
        int y = pos.get(0);
        for (int i = y; i < memo.size(); i++) {
            String x = memo.get(i);
            if(x.length()>15){
                String z = x.substring(0,8);
                String w = x.substring(8);
                setData(z, new EmuladorProcesadorZ80().conversorINTtoHEXA(y++));
                setData(w, new EmuladorProcesadorZ80().conversorINTtoHEXA(y++));
            }else{
                setData(x, new EmuladorProcesadorZ80().conversorINTtoHEXA(y++));
            }
            if(y==65535){
                break;
            }
        }        
        jTable1.updateUI();
    }
    
    /*
    public void llenarMemoria(String[] input){//change?
        for (int i = 0; i < input.length; i++) {
            String hex = new EmuladorProcesadorZ80().conversorINTtoHEXA(i);
            setData(input[i], hex);
        }
    }
    */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
