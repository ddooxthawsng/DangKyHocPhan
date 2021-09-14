/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomTable;

import Entity.ChuyenNganh;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author User
 */
public class CustomTableChuyenNganh extends AbstractTableModel{
    private String name[]={"Mã chuyên ngành","Tên chuyên ngành","Khoa"};
    private Class classes[]={String.class,String.class,String.class};
    ArrayList<ChuyenNganh> li=new ArrayList<>();

    public CustomTableChuyenNganh(ArrayList<ChuyenNganh> li) {
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
            case 0: return li.get(rowIndex).getMaChuyenNganh();
            case 1: return li.get(rowIndex).getTenChuyenNganh();
            case 2: return li.get(rowIndex).getMaKhoa();
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
