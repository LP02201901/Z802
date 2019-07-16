package emuladorprocesadorz80;

import static emuladorprocesadorz80.interfazProcesadorZ80.procesador;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class enlazador extends javax.swing.JDialog {

    public enlazador(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        txtSalidaRelok.setEditable(false);
        mostrarRelok();
        enlazar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtSalidaRelok = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        posicionArranque = new javax.swing.JTextField();
        btnLinker = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(600, 600));
        setMinimumSize(new java.awt.Dimension(600, 600));

        jScrollPane1.setViewportView(txtSalidaRelok);

        jLabel1.setText("Ingrese la poscion de memoria donde desea que el programa ubique ");

        posicionArranque.setText("0");
        posicionArranque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                posicionArranqueActionPerformed(evt);
            }
        });

        btnLinker.setText("Enlazar y cargar");
        btnLinker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLinkerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(posicionArranque, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLinker, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(posicionArranque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLinker))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void posicionArranqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_posicionArranqueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_posicionArranqueActionPerformed

    private void btnLinkerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLinkerActionPerformed
        try {
            procesador.linker(Integer.parseInt(posicionArranque.getText()));
        } catch (IOException ex) {
            Logger.getLogger(interfazProcesadorZ80.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_btnLinkerActionPerformed

    public void mostrarRelok() {
        FileReader f = null;
        try {
            String input;
            f = new FileReader("achivoReLoc.txt");
            BufferedReader b = new BufferedReader(f);
            input = b.readLine();
            String [] auxIn = input.split(" ");
            input ="";
            for (int i = 0; i < auxIn.length; i++) {
                input = input+(i+1)+"\t"+auxIn[i]+"\n";
            }
            txtSalidaRelok.setText(input);
            b.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(enlazador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(enlazador.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                f.close();
            } catch (IOException ex) {
                Logger.getLogger(enlazador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void enlazar(){
        posicionArranque.addKeyListener(new KeyAdapter(){
           public void keyTyped(KeyEvent e)
           {
              char caracter = e.getKeyChar();

              // Verificar si la tecla pulsada no es un digito
              if(((caracter < '0') ||
                 (caracter > '9')) &&
                 (caracter != '\b' /*corresponde a BACK_SPACE*/))
              {
                 e.consume();  // ignorar el evento de teclado
              }
           }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnLinker;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField posicionArranque;
    private javax.swing.JTextPane txtSalidaRelok;
    // End of variables declaration//GEN-END:variables

}

