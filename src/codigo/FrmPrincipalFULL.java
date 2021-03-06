/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import ValidacionTabla.ColorCelda;
import com.sun.awt.AWTUtilities;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author NETO
 */
public class FrmPrincipalFULL extends javax.swing.JFrame {

    DefaultTableModel modelo;
    int x,y;
    /**
     * Creates new form FrmPrincipal
     */
    public FrmPrincipalFULL() {
        this.setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
        AWTUtilities.setWindowOpaque(this, false);
        modelo=new DefaultTableModel();
        modelo.addColumn("                                   DATO");
        modelo.addColumn("                                   TIPO");
        this.tb_datos.setModel(modelo);
          DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
          tcr.setHorizontalAlignment(SwingConstants.CENTER);
          tb_datos.getColumnModel().getColumn(0).setCellRenderer(tcr);   
          tb_datos.getColumnModel().getColumn(1).setCellRenderer(tcr);  
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_analizar_sintactico = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt_Resultado3 = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_Resultado1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_datos = new ColorCelda();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbl_Analizar = new javax.swing.JLabel();
        lbl_Fondo = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txt_html = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_analizar_sintactico.setText("Analizar");
        btn_analizar_sintactico.setEnabled(false);
        btn_analizar_sintactico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_analizar_sintacticoActionPerformed(evt);
            }
        });
        getContentPane().add(btn_analizar_sintactico, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 690, -1, -1));

        txt_Resultado3.setEditable(false);
        txt_Resultado3.setColumns(20);
        txt_Resultado3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txt_Resultado3.setRows(5);
        jScrollPane3.setViewportView(txt_Resultado3);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 740, 550, 110));

        txt_Resultado1.setEditable(false);
        txt_Resultado1.setColumns(20);
        txt_Resultado1.setRows(5);
        jScrollPane1.setViewportView(txt_Resultado1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 110, 540, 520));

        tb_datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Column 1", "Column 2"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_datos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(tb_datos);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 530, 610));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("X");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 20, 20, -1));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/trash.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(432, 100, 40, 40));

        lbl_Analizar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lbl_Analizar.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Analizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Analizar.setText("ANALIZAR");
        lbl_Analizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_AnalizarMouseClicked(evt);
            }
        });
        getContentPane().add(lbl_Analizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 380, 40));

        lbl_Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo2_1.png"))); // NOI18N
        getContentPane().add(lbl_Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1890, 868));

        txt_html.setColumns(20);
        txt_html.setRows(5);
        jScrollPane4.setViewportView(txt_html);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 70, 600, 790));

        jButton1.setText("GUARDAR ARCHIVO HTML");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 10, 600, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_AnalizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_AnalizarMouseClicked
        borrar();
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        String []info = new String[2];
        File archivo = new File(chooser.getSelectedFile().getAbsolutePath());
        
        try {
            
            String ST = new String(Files.readAllBytes(archivo.toPath()));
            txt_Resultado1.setText(ST);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrmPrincipalFULL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipalFULL.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        try {
            btn_analizar_sintactico.setEnabled(true);
            Reader lector = new BufferedReader(new FileReader(chooser.getSelectedFile()));
            Lexer lexer = new Lexer(lector);
            String resultado = "";
            while (true) {
                Tokens tokens = lexer.yylex();
                if (tokens == null) {
                    resultado += "*************************FIN*************************";
                        info[0] = "**** FIN ****";
                        info[1] = "**** FIN ****";
                        modelo.addRow(info);
                    //txt_Resultado.setText(resultado);
                    return;
                }
                switch(tokens){
                    case body_a: case body_c: case bold_font: case border: case column: case coma:
                    case comillas: case dato: case division: case email:
                    case webpage: case head_a: case head_c: case height: case html_a: 
                    case html_c: case igual: case image_a: case image_c:
                    case list_a: case list_c: case name: case number_float: case number_int:
                    case parentesis_a: case parentesis_c: case print: case producto: case punto_coma:
                    case resta: case row_a: case row_c: case suma: case table_a:
                    case table_c: case titulo: case url: case width:
            
                        //resultado += lexer.lexeme + "\t\t Es un "+ tokens + "\n";
                        info[0] = lexer.lexeme;
                        info[1] = tokens.toString();
                        modelo.addRow(info);
                        break;
                    case error: 
                        //resultado += lexer.lexeme + "\t\t Es un "+ tokens + "\n";
                        info[0] = lexer.lexeme;
                        info[1] = tokens.toString();
                        modelo.addRow(info);
                        break;
                    default:
                        //resultado += lexer.lexeme + ": Es un \n";
                        break;
                }
                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrmPrincipalFULL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipalFULL.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }//GEN-LAST:event_lbl_AnalizarMouseClicked

    
    public void Asintactico(){
    String ST = txt_Resultado1.getText();
        Sintax s = new Sintax(new codigo.LexerCup(new StringReader(ST)));
        
        Lexer lexico = new Lexer(new BufferedReader(new StringReader(txt_Resultado1.getText())));
        String resultado = "";
        
        try {
            s.parse();
            
            txt_html.setText(s.resultado);
            
            txt_Resultado3.setText("Analisis realizado correctamente");
            txt_Resultado3.setForeground(new Color(25, 111, 61));
        } catch (Exception ex) {
            Symbol sym = s.getS();
            txt_Resultado3.setText("Error de sintaxis. Linea "+(sym.right+1)+" Columna: "+(sym.left+1)+", Texto: \""+sym.value+ "\"");
            txt_Resultado3.setForeground(Color.red);
        }
    }
    
    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        borrar();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        x=evt.getX();
       y=evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        Point point = MouseInfo.getPointerInfo().getLocation();
        setLocation(point.x - x, point.y - y);
    }//GEN-LAST:event_formMouseDragged

    private void btn_analizar_sintacticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_analizar_sintacticoActionPerformed
        Asintactico();
    }//GEN-LAST:event_btn_analizar_sintacticoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            String a = System.getProperty("user.name");
            Date myDate = new Date();


            String ruta = "C:\\Users\\"+a+"\\Desktop\\Generado_HTML_"+new SimpleDateFormat("dd-MM-yyyy").format(myDate)+".html";
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(txt_html.getText());
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public void borrar(){
        try {
            btn_analizar_sintactico.setEnabled(false);
            txt_Resultado1.setText("");
            txt_Resultado3.setText("");
            int fila=tb_datos.getRowCount();
            for (int i = fila-1; i >=0; i--) {
                modelo.removeRow(i);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error chaval "+e);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(FrmPrincipalFULL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipalFULL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipalFULL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipalFULL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipalFULL().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_analizar_sintactico;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbl_Analizar;
    private javax.swing.JLabel lbl_Fondo;
    private javax.swing.JTable tb_datos;
    private javax.swing.JTextArea txt_Resultado1;
    private javax.swing.JTextArea txt_Resultado3;
    private javax.swing.JTextArea txt_html;
    // End of variables declaration//GEN-END:variables
}
