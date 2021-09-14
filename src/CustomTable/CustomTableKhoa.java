/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomTable;

import Entity.Khoa;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author User
 */
public class CustomTableKhoa extends AbstractTableModel{
    private String name[]={"Mã khoa","Tên khoa"};
    private Class classes[]={String.class,String.class};
    ArrayList<Khoa> li=new ArrayList<>();

    public CustomTableKhoa(ArrayList<Khoa> li) {
        this.li=li;
    }

    
    @Override
    public int getRowCount() {
        return li.size();
    }

    @Override
    public int getColumnCount() {
         return name.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return li.get(rowIndex).getMaKhoa();
            case 1: return li.get(rowIndex).getTenKhoa();
            default: return null;
        }
    }
     @Override
    public Class getColumnClass(int columnIndex) {
        return classes[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return name[column];
    }
}
