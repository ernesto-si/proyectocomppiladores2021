/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ValidacionTabla;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author NETO
 */
public class ColorCelda extends JTable{
    //Invocar métodos
    public Component prepareRenderer(TableCellRenderer renderer, int rowIndex, int ColumnIndex){
        Component componente = super.prepareRenderer(renderer, rowIndex, ColumnIndex);
        //valor columna y fila especificada             si pertenece a los string
        if(getValueAt(rowIndex, ColumnIndex).getClass().equals(String.class)){
            String valor= (this.getValueAt(rowIndex, ColumnIndex).toString());
            
            if(valor=="error"){
                componente.setBackground(Color.RED.darker());
                componente.setForeground(Color.WHITE);
            }else if(valor=="**** FIN ****"){
                componente.setBackground(Color.BLUE.darker().darker().darker());
                componente.setForeground(Color.WHITE);
            }else{
            componente.setBackground(Color.WHITE);
            componente.setForeground(Color.BLACK);
        }
            
        }
        
        return componente;
    }
}
