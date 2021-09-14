/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomTable;

import Entity.GiangVien;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author User
 */
public class CustomTableGiangVien extends AbstractTableModel{
    private String name[]={"Mã giảng viên","Tên giảng viên","Ngày sinh","Giới tính","Địa chỉ"};
    private Class classes[]={String.class,String.class,String.class,String.class,String.class};
    ArrayList<GiangVien> li=new ArrayList<>();

    public CustomTableGiangVien(ArrayList<GiangVien> li) {
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
            case 0: return li.get(rowIndex).getMaGV();
            case 1: return li.get(rowIndex).getTenGV();
            case 2: return li.get(rowIndex).getNgaySinh();
            case 3: return li.get(rowIndex).getGioiTinh();
            case 4: return li.get(rowIndex).getDiaChi();
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
