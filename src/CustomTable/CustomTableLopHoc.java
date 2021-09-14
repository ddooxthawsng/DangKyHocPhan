/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomTable;

import Entity.LopHoc;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author User
 */
public class CustomTableLopHoc extends AbstractTableModel{
     private String name[]={"Mã lớp","Tên lớp","Sĩ số","Khóa học","Mã chuyên ngành"};
    private Class classes[]={String.class,String.class,int.class,String.class,String.class};
    ArrayList<LopHoc> li=new ArrayList<>();

    public CustomTableLopHoc(ArrayList<LopHoc> li) {
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
            case 0: return li.get(rowIndex).getMaLop();
            case 1: return li.get(rowIndex).getTenLop();
            case 2: return li.get(rowIndex).getSiSo();
            case 4: return li.get(rowIndex).getMaChuyenNganh();
            case 3: return li.get(rowIndex).getKhoaHoc();
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
