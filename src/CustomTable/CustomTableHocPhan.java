/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomTable;

import Entity.HocPhan;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author User
 */
public class CustomTableHocPhan extends AbstractTableModel{
    
    private String name[]={"Mã học phần","Tên học phần","Tín chỉ lý thuyết","Tín chỉ thực hành","Đơn giá tín chỉ","Tổng tiền","Hình thức thi"};
    private Class classes[]={String.class,String.class,int.class,int.class,int.class,int.class,String.class};
    ArrayList<HocPhan> li=new ArrayList<>();

    public CustomTableHocPhan(ArrayList<HocPhan> li) {
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
            case 0: return li.get(rowIndex).getMaHP();
            case 1: return li.get(rowIndex).getTenHP();
            case 2: return li.get(rowIndex).getTCLT();
            case 3: return li.get(rowIndex).getTCTH();
            case 4: return li.get(rowIndex).getDonGiaTC();
            case 5: return li.get(rowIndex).TongTien();
            case 6: return li.get(rowIndex).getHinhThucThi();
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
