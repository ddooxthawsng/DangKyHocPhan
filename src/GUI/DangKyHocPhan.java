/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.DangKyDAO;
import DAO.HocPhanDAO;
import DAO.IHocPhanDAO;
import DAO.ILopHocPhanDAO;
import DAO.LopHocPhanDAO;
import Entity.DangKy;
import Entity.HocPhan;
import Entity.LopHocPhan;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class DangKyHocPhan extends javax.swing.JPanel {

    /**
     * Creates new form DangKyHocPhan
     */
    private String MaSV=Login.nameLogin,MaLHP="",mahp="",tenhp="",tiethoc="",thu="",ngaybd="",diadiem="";
    private DefaultTableModel dtm,dtm1;
    private ArrayList<LopHocPhan> listLHP=null;
    private ArrayList<DangKy> ListDKH=null;
    int selectedRow=-1;
    ArrayList<LopHocPhan> li=new ArrayList<>();
    ArrayList<HocPhan> lihp=new ArrayList<>();
    public DangKyHocPhan() {
        initComponents();
        initComponents();
       // setLocationRelativeTo(null);
        dtm = new DefaultTableModel();
        dtm.addColumn("Mã Lớp Học Phần");
        dtm.addColumn("Mã Học Phần");
        dtm.addColumn("Tên Môn Học");
        dtm.addColumn("Tiết Học");
        dtm.addColumn("Thứ");
        dtm.addColumn("Ngày Bắt Đầu");          
        dtm.addColumn("Địa Điểm");
        dtm.addColumn("Học phí");
        //
        dtm1 = new DefaultTableModel();
        dtm1.addColumn("Mã Lớp Học Phần");
        dtm1.addColumn("Mã Học Phần");
        dtm1.addColumn("Tên Môn Học");
        dtm1.addColumn("Tiết Học");
        dtm1.addColumn("Thứ");
        dtm1.addColumn("Ngày Bắt Đầu");          
        dtm1.addColumn("Địa Điểm");
        dtm1.addColumn("Học phí");
        txtTienNo.setEditable(false);
        loaddata();
    }
    private void loaddata() {
        try {

            ListDKH =new DangKyDAO().getAll();
           
            ILopHocPhanDAO lopHocPhanDAO = (ILopHocPhanDAO) Class.forName("DAO.LopHocPhanDAO").newInstance();
            listLHP = new LopHocPhanDAO().getAll();
            for (LopHocPhan lhp : listLHP) {
                dtm.addRow(toObjectsData(lhp));
            }
            jTableLHP.setModel(dtm);
        } catch (InstantiationException ex) {
            Logger.getLogger(DangKy.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DangKy.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DangKy.class.getName()).log(Level.SEVERE, null, ex);
        }
        TienNo();
    }

 
    public static Object[] toObjectsData(LopHocPhan lhp) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        HocPhan hp =new HocPhan();
        IHocPhanDAO hocPhanDAO = (IHocPhanDAO) Class.forName("DAO.HocPhanDAO").newInstance();
        ArrayList<HocPhan> listHP = new HocPhanDAO().findByMaHP(lhp.getMaHP());
                //.findIDMaMH(lhp.getMaMH());
        Object[] objectsData = {lhp.getMaLHP(), lhp.getMaHP(),listHP.get(0).getTenHP(),lhp.getTietHoc(), lhp.getThu(),lhp.getNgayBatDau(),lhp.getDiaDiem(),(listHP.get(0).getTCLT()+listHP.get(0).getTCTH())*listHP.get(0).getDonGiaTC()};
        return objectsData;
    }
    public static Object[] toObjectsDataFind(LopHocPhan lhp) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        HocPhan hp =new HocPhan();
        IHocPhanDAO monHocDAO = (IHocPhanDAO) Class.forName("DAO.HocPhanDAO").newInstance();
        ArrayList<HocPhan> listHP = new HocPhanDAO().findByMaHP(lhp.getMaHP());
                //.findIDMaMH(lhp.getMaMH());
        Object[] objectsData = {lhp.getMaLHP(), lhp.getMaHP(),listHP.get(0).getTenHP(),lhp.getTietHoc(), lhp.getThu(),lhp.getNgayBatDau(),lhp.getDiaDiem(),(listHP.get(0).getTCLT()+listHP.get(0).getTCTH())*listHP.get(0).getDonGiaTC()};
        return objectsData;
    }
    public int TienNo(){
            int TienNo=0;
            ListDKH =new DangKyDAO().getAll_LHP_ByMaSV(Login.nameLogin);/*Load danh sách đăng ký của sinh viên */
            ArrayList<LopHocPhan> LHP = new ArrayList<LopHocPhan>();
            //Tìm danh sách lớp học phần đã đăng ký
            for(int i=0;i<ListDKH.size();i++){
                ArrayList<LopHocPhan> listLHP_DaDangKy = new LopHocPhanDAO().findByMaLHP(ListDKH.get(i).getMaLHP());
                LHP.add(listLHP_DaDangKy.get(0));
            }
             //Tìm danh sách  học phần đã đăng ký
            ArrayList<HocPhan> HP = new ArrayList<HocPhan>();
            for(int i=0;i<LHP.size();i++){
                ArrayList<HocPhan> listHP_DaDangKy = new HocPhanDAO().findByMaHP(LHP.get(i).getMaHP());
                HP.add(listHP_DaDangKy.get(0));
          
            }
         for(int i=0;i<HP.size();i++){
             TienNo=TienNo+(HP.get(i).getTCLT()+HP.get(i).getTCTH())*HP.get(i).getDonGiaTC();
         }
         txtTienNo.setText(TienNo+"");
         return TienNo;
    }
    private boolean check() {  
        ListDKH =new DangKyDAO().getAll_LHP_ByMaSV(Login.nameLogin);/*Load danh sách đăng ký của sinh viên*/
        ArrayList<LopHocPhan> LHP = new ArrayList<LopHocPhan>();
        //Tìm danh sách lớp học phần đã đăng ký
        for(int i=0;i<ListDKH.size();i++){
            ArrayList<LopHocPhan> listLHP_DaDangKy = new LopHocPhanDAO().findByMaLHP(ListDKH.get(i).getMaLHP());
            LHP.add(listLHP_DaDangKy.get(0));
        }
        //Check đăng ký lớp học phần có mã học phần đã đăng ký rồi
        for(int i=0;i<LHP.size();i++){
            if(mahp.equals(LHP.get(i).getMaHP())){
                JOptionPane.showMessageDialog(this, "Bạn đã đăng ký học học phần này. Xem lại lịch học của bạn" , "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return false;
            }
        }
        String cacTietTrung="";
        for(int i=0;i<LHP.size();i++){
            if(thu.equals(LHP.get(i).getThu())){
                ArrayList<String> listdahoc = new ArrayList<>(Arrays.asList(LHP.get(i).getTietHoc().split(",")));
                String[] muondangky = tiethoc.split(",");
                for (String a:muondangky){
                    if(listdahoc.contains(a)){
                        cacTietTrung+= a+",";
                    }
                }

            }
       }
       if(cacTietTrung.equals("")){}
       else{
            JOptionPane.showMessageDialog(this, "Trùng lịch vào  "+thu+" tiết "+cacTietTrung.substring(0, cacTietTrung.length())+" !" , "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }  
       return true;
    }
    private void finddatabyMa() {
        try {
            String ten=txtTim.getText();
            ListDKH =new DangKyDAO().getAll();
            ILopHocPhanDAO lopHocPhanDAO = (ILopHocPhanDAO) Class.forName("DAO.LopHocPhanDAO").newInstance();
            listLHP = new LopHocPhanDAO().findByMaHP(ten);
            for (LopHocPhan lhp : listLHP) {
                dtm1.addRow(toObjectsData(lhp));
            }
            jTableLHP.setModel(dtm1);
        } catch (InstantiationException ex) {
            Logger.getLogger(DangKy.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DangKy.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DangKy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void dangky(){
        if(MaLHP.equals("")){
            JOptionPane.showMessageDialog(null, "Chọn học phần muốn đăng ký");
        }
        else{   
            if (!check()) {
                return;
            } 
            //Danh sách lớp học phần có mã MaLHP trong bảng đăng ký
            ArrayList<DangKy> listCheck = new DangKyDAO().checkID(MaLHP);
            //Danh sách lớp học phần có mã MaLHP  của sinh viên có mã MaSV trong bảng đăng ký
            ArrayList<DangKy> listCheck2 = new DangKyDAO().getOne_LHP_By_MaLHP_MaSV(MaLHP,MaSV);
            ArrayList<HocPhan> HPDK=new HocPhanDAO().findByMaHP(mahp);
            int TienNoMoi=TienNo()+(HPDK.get(0).getTCLT()+HPDK.get(0).getTCTH())*HPDK.get(0).getDonGiaTC();
            if(listCheck.size()>60){
                JOptionPane.showMessageDialog(this, "Lớp học phần này đã đủ sinh viên !", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            }  
           
            else
            if(TienNoMoi>10000000){
             JOptionPane.showMessageDialog(this, "Số tiền nợ quá 10 triệu. Bạn không thể đăng ký thêm học phần này" , "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
               DangKyDAO insert=new DangKyDAO();
               insert.dangky(MaLHP, MaSV);
               JOptionPane.showMessageDialog(this, "Đăng ký thành công !", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
               TienNo();
            }
        }
    } 
    
    private void huydangky(){
      if(MaLHP.equals("")){
            JOptionPane.showMessageDialog(null, "Chọn học phần muốn hủy đăng ký");
        }
      else{
            ArrayList<DangKy> listCheck = new DangKyDAO().getOne_LHP_By_MaLHP_MaSV(MaLHP,MaSV);
             if (listCheck.size() == 0) {
                  JOptionPane.showMessageDialog(this, "Lịch học của bạn không tồn tại lớp học phần này !", "Vui lòng kiểm tra lại", JOptionPane.ERROR_MESSAGE);
              }
             else{
              int b = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn hủy đăng ký lớp học phần này ?", "Thông Báo", JOptionPane.YES_NO_OPTION);
              if (b == JOptionPane.YES_OPTION) {
                  try {

                     // String maLHP = txtMaLHP.getText();
                     // new DangKyDAO().huydangkyhoc(MaLHP,Login.nameLogin);
                     new DangKyDAO().huydangkyhoc(MaLHP,MaSV);
                      JOptionPane.showMessageDialog(this, "Hủy đăng ký thành công !", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    //  resetForm();
                  }catch (SQLException ex) {}    
              }
            }    
        }
      TienNo();
    } 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableLHP = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        HuyDangKy = new javax.swing.JButton();
        DangKy = new javax.swing.JButton();
        txtXemLichHoc = new javax.swing.JButton();
        HienThiLai = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtTienNo = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnTim = new javax.swing.JButton();
        txtTim = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("ĐĂNG KÝ HỌC PHẦN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTableLHP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTableLHP.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableLHP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableLHPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableLHP);

        HuyDangKy.setBackground(new java.awt.Color(0, 153, 255));
        HuyDangKy.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        HuyDangKy.setText("Hủy đăng ký");
        HuyDangKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HuyDangKyActionPerformed(evt);
            }
        });

        DangKy.setBackground(new java.awt.Color(0, 153, 255));
        DangKy.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        DangKy.setText("Đăng ký");
        DangKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DangKyActionPerformed(evt);
            }
        });

        txtXemLichHoc.setBackground(new java.awt.Color(0, 153, 255));
        txtXemLichHoc.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtXemLichHoc.setText("Xem lịch học");
        txtXemLichHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtXemLichHocActionPerformed(evt);
            }
        });

        HienThiLai.setBackground(new java.awt.Color(0, 153, 255));
        HienThiLai.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        HienThiLai.setText("Hiển thị danh sách");
        HienThiLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HienThiLaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(HienThiLai)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(DangKy)
                .addGap(61, 61, 61)
                .addComponent(HuyDangKy)
                .addGap(46, 46, 46)
                .addComponent(txtXemLichHoc)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HuyDangKy, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DangKy, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtXemLichHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HienThiLai, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Tổng tiền nợ:");

        txtTienNo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtTienNo.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(28, 28, 28)
                        .addComponent(txtTienNo, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(186, 186, 186))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTienNo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        btnTim.setBackground(new java.awt.Color(0, 153, 255));
        btnTim.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnTim.setText("Tìm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        txtTim.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Tìm kiếm lớp theo mã học phần");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addContainerGap(522, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 13, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addComponent(btnTim, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTim))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        // TODO add your handling code here:
        finddatabyMa();
        
    }//GEN-LAST:event_btnTimActionPerformed

    private void jTableLHPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableLHPMouseClicked
        // TODO add your handling code here:
        int r=jTableLHP.getSelectedRow();
        MaLHP=(String) jTableLHP.getValueAt(r, 0);
        mahp=(String) jTableLHP.getValueAt(r, 1);
        tenhp=(String) jTableLHP.getValueAt(r, 2);
        tiethoc=(String) jTableLHP.getValueAt(r, 3);
        thu=(String) jTableLHP.getValueAt(r, 4);
        ngaybd=(String) jTableLHP.getValueAt(r, 5);
        diadiem=(String) jTableLHP.getValueAt(r, 6);

    }//GEN-LAST:event_jTableLHPMouseClicked

    private void HuyDangKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HuyDangKyActionPerformed
        // TODO add your handling code here:
        huydangky();
    }//GEN-LAST:event_HuyDangKyActionPerformed

    private void DangKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DangKyActionPerformed
        // TODO add your handling code here:
        dangky();
    }//GEN-LAST:event_DangKyActionPerformed

    private void txtXemLichHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtXemLichHocActionPerformed
        // TODO add your handling code here:
       
         try {
           LichHoc ld=new LichHoc();
           
           ld.show();
           ld.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lịch học trống !", "Vui lòng kiểm tra lại", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txtXemLichHocActionPerformed

    private void HienThiLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HienThiLaiActionPerformed
        // TODO add your handling code here:
        loaddata();
    }//GEN-LAST:event_HienThiLaiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DangKy;
    private javax.swing.JButton HienThiLai;
    private javax.swing.JButton HuyDangKy;
    private javax.swing.JButton btnTim;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableLHP;
    private javax.swing.JTextField txtTienNo;
    private javax.swing.JTextField txtTim;
    private javax.swing.JButton txtXemLichHoc;
    // End of variables declaration//GEN-END:variables
}
