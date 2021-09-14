/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import CustomTable.CustomTableGiangVien;
import DAO.GiangVienDAO;
import DAO.IGiangVienDAO;
import Entity.GiangVien;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class QuanLyGiangVien extends javax.swing.JPanel {

    /**
     * Creates new form QuanLyGiangVien
     */
     private String magv,tengv,ngaysinh,gioitinh,diachi;
    int selectedRow=-1;
    ArrayList<GiangVien> li=new ArrayList<GiangVien>();
    public QuanLyGiangVien() {
        initComponents();
        LoadData();
        LoadTable();
    }
 public void LoadTable(){
        jTableGiangVien.setModel(new CustomTableGiangVien(li));
    }
    public void LoadData(){
         try {
            IGiangVienDAO giangVienDAO = (IGiangVienDAO) Class.forName("DAO.GiangVienDAO").newInstance();
            li = new GiangVienDAO().getAll();
            LoadTable();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuanLyGiangVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(QuanLyGiangVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(QuanLyGiangVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void LamMoi(){
        txtMaGV.setText("");
        txtTenGV.setText("");
        txtNgaySinh.setText("");
        radNam.setSelected(false);
        radNu.setSelected(false);
        txtDiaChi.setText("");
        buttonGroup1.clearSelection();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableGiangVien = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMaGV = new javax.swing.JTextField();
        txtTenGV = new javax.swing.JTextField();
        txtNgaySinh = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        radNam = new javax.swing.JRadioButton();
        radNu = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        Them = new javax.swing.JButton();
        Xoa = new javax.swing.JButton();
        Sua = new javax.swing.JButton();
        Lammoi = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("QUẢN LÝ GIẢNG VIÊN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        jTableGiangVien.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTableGiangVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableGiangVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableGiangVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableGiangVien);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setText("Mã giảng viên:");
        jLabel2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                jLabel2ComponentHidden(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setText("Tên giảng viên:");
        jLabel3.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                jLabel3ComponentHidden(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setText("Giới tính:");
        jLabel5.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                jLabel5ComponentHidden(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setText("Địa chỉ:");
        jLabel6.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                jLabel6ComponentHidden(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setText("Ngày sinh:");
        jLabel7.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                jLabel7ComponentHidden(evt);
            }
        });

        buttonGroup1.add(radNam);
        radNam.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        radNam.setText("Nam");

        buttonGroup1.add(radNu);
        radNu.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        radNu.setText("Nữ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTenGV, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtMaGV, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(18, 18, 18)
                                    .addComponent(radNam)
                                    .addGap(18, 18, 18)
                                    .addComponent(radNu))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(37, 37, 37)
                                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7)
                    .addComponent(txtMaGV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(txtTenGV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radNam)
                    .addComponent(radNu))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        Them.setBackground(new java.awt.Color(0, 153, 255));
        Them.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Them.setText("Thêm");
        Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThemActionPerformed(evt);
            }
        });

        Xoa.setBackground(new java.awt.Color(0, 153, 255));
        Xoa.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Xoa.setText("Xóa");
        Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XoaActionPerformed(evt);
            }
        });

        Sua.setBackground(new java.awt.Color(0, 153, 255));
        Sua.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Sua.setText("Sửa");
        Sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuaActionPerformed(evt);
            }
        });

        Lammoi.setBackground(new java.awt.Color(0, 153, 255));
        Lammoi.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Lammoi.setText("Làm mới");
        Lammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LammoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Lammoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Xoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Sua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Them, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Them)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Sua)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Xoa)
                .addGap(18, 18, 18)
                .addComponent(Lammoi)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 9, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTableGiangVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableGiangVienMouseClicked
        // TODO add your handling code here:
        selectedRow=jTableGiangVien.getSelectedRow();
        GiangVien gv=li.get(selectedRow);
        txtMaGV.setText(gv.getMaGV()+"");
        txtTenGV.setText(gv.getTenGV()+"");
        txtNgaySinh.setText(gv.getNgaySinh()+"");
        if(gv.getGioiTinh().equals("Nam"))
        {
            radNam.setSelected(true);
            radNu.setSelected(false);
        }
        if(gv.getGioiTinh().equals("Nữ"))
        {
            radNam.setSelected(false);
            radNu.setSelected(true);
        }
        txtDiaChi.setText(gv.getDiaChi()+"");
    }//GEN-LAST:event_jTableGiangVienMouseClicked

    private void jLabel2ComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jLabel2ComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2ComponentHidden

    private void jLabel3ComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jLabel3ComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3ComponentHidden

    private void jLabel5ComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jLabel5ComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5ComponentHidden

    private void jLabel6ComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jLabel6ComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6ComponentHidden

    private void jLabel7ComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jLabel7ComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7ComponentHidden

    private void ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThemActionPerformed
         // TODO add your handling code here:
        try{
            if(radNam.isSelected()||radNu.isSelected()){
                if(txtMaGV.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Mã giảng viên không được để trống"); 
                }
                else if(txtTenGV.getText().equals("")||txtNgaySinh.getText().equals("")||txtDiaChi.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Điền đầy đủ thông tin của sinh viên trước khi thêm");
                }
                else{
                    magv=txtMaGV.getText();
                    tengv=txtTenGV.getText();
                    ngaysinh=txtNgaySinh.getText();
                    if(radNam.isSelected())
                        gioitinh="Nam";
                    if(radNu.isSelected())
                        gioitinh="Nữ";
                    diachi=txtDiaChi.getText();
                    GiangVien check=new GiangVien(magv);
                    GiangVien gv=new GiangVien(magv,tengv,ngaysinh,gioitinh,diachi);
                    if(li.contains(check)){
                        JOptionPane.showMessageDialog(null, "Mã giảng viên bị trùng, không thể thêm"); 
                    }
                    else{
                        GiangVien add=new GiangVienDAO().addNew(gv);
                        li.add(gv);
                        LamMoi();
                        LoadTable();
                         JOptionPane.showMessageDialog(null, "Thêm thành công"); 
                    }
                }
            }
            else
                JOptionPane.showMessageDialog(null, "Giới tính không được để trống"); 
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Điền đầy đủ thông tin của sinh viên trước khi thêm");
        }
    }//GEN-LAST:event_ThemActionPerformed

    private void XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XoaActionPerformed
        // TODO add your handling code here:
        if(jTableGiangVien.getRowCount()==0){
             JOptionPane.showMessageDialog(null, "Danh sách rỗng");
        }
        else{
            String ma=txtMaGV.getText();
            GiangVien gv=new GiangVien(ma);
            if(li.contains(gv)){
                int chose=JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa giảng viên này?","Thông báo",
                        JOptionPane.YES_NO_OPTION);
                
                
                
                if(chose==JOptionPane.YES_OPTION){
                    li.remove(li.indexOf(gv));
                    try {
                        new GiangVienDAO().deleteMaGV(ma);
                        //new GiangVienDAO().deleteUserGV(magv);
                        LoadTable();
                        JOptionPane.showMessageDialog(this, "Xóa thành công !", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

                    } catch (SQLException ex) {
                        Logger.getLogger(QuanLyGiangVien.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(QuanLyGiangVien.class.getName()).log(Level.SEVERE, null, ex);
                    }
                       
                        }
                    }
            else{
                JOptionPane.showMessageDialog(null, "Giảng viên có mã "+ma+" không có trong danh sách");
            }
        }
        LamMoi();
    }//GEN-LAST:event_XoaActionPerformed

    private void SuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuaActionPerformed
        // TODO add your handling code here:
        try{
            if(radNam.isSelected()||radNu.isSelected()){
                if(txtMaGV.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Mã giảng viên không được để trống"); 
                }
                else if(txtTenGV.getText().equals("")||txtNgaySinh.getText().equals("")||txtDiaChi.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Điền đầy đủ thông tin của sinh viên trước khi sửa");
                }
                else{
                    String ma=txtMaGV.getText();
                    selectedRow=jTableGiangVien.getSelectedRow();
                    magv=txtMaGV.getText();
                        tengv=txtTenGV.getText();
                        ngaysinh=txtNgaySinh.getText();
                        if(radNam.isSelected())
                            gioitinh="Nam";
                        if(radNu.isSelected())
                            gioitinh="Nữ";
                        diachi=txtDiaChi.getText();
                        GiangVien gvm=new GiangVien(magv,tengv,ngaysinh,gioitinh,diachi);

                    //if( selectedRow==-1){
                        GiangVien gv=new GiangVien(ma);
                        if(li.contains(gv)){
                            li.set(li.indexOf(gv), gvm);
                            GiangVien update=new GiangVienDAO().updateByMaGV(gvm);
                            JOptionPane.showMessageDialog(null, "Sửa thành công"); 
                        }
                        else
                            JOptionPane.showMessageDialog(null,"Không cập nhật được thông tin cho giảng viên có mã "+ma);
                    LamMoi();
                    LoadTable();
                }
            }else
                JOptionPane.showMessageDialog(null, "Giới tính không được để trống"); 
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Điền đầy đủ thông tin của sinh viên trước khi sửa");
        }
        
    }//GEN-LAST:event_SuaActionPerformed

    private void LammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LammoiActionPerformed
        // TODO add your handling code here:
        LamMoi();
    }//GEN-LAST:event_LammoiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Lammoi;
    private javax.swing.JButton Sua;
    private javax.swing.JButton Them;
    private javax.swing.JButton Xoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableGiangVien;
    private javax.swing.JRadioButton radNam;
    private javax.swing.JRadioButton radNu;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtMaGV;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtTenGV;
    // End of variables declaration//GEN-END:variables
}