/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomTable;

import Entity.HocPhan;
import Entity.LopHocPhan;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author User
 */
public class CusTomTableDangKyHocPhan extends AbstractTableModel {
    private String name[]={"Mã lớp học phần","Mã học phần","Tên học phần","Tiết học","Thứ","Ngày bắt đầu","Địa điểm",};
    private Class classes[]={String.class,String.class,String.class,String.class,String.class,String.class,String.class};
    ArrayList<LopHocPhan> li=new ArrayList<>();
    ArrayList<HocPhan> lihp=new ArrayList<>();

    public CusTomTableDangKyHocPhan(ArrayList<LopHocPhan> li,ArrayList<HocPhan> lihp) {
        this.li=li;
        this.lihp=lihp;
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
            case 0: return li.get(rowIndex).getMaLHP();
            case 1: return li.get(rowIndex).getMaHP();
            case 2: return lihp.get(rowIndex).getTenHP();
            case 3: return li.get(rowIndex).getTietHoc();
            case 4: return li.get(rowIndex).getThu();
            case 5: return li.get(rowIndex).getNgayBatDau();
            case 6: return li.get(rowIndex).getDiaDiem();
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
