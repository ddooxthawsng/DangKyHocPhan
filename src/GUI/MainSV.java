/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;




import Entity.DangKy;
import Entity.TimKiem;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.util.Calendar;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Administrator
 */
public class MainSV extends javax.swing.JFrame {

    public static String nameLogin;
    public Date today = new Date();
    Locale local = new Locale("vi", "VI");
    DateFormat d = DateFormat.getDateInstance(DateFormat.MEDIUM, local);
    public String date = d.format(today);

    /**
     * Creates new form Main
     */
    public MainSV() {
        
       
        initComponents();
        
        
        setIconImage(new ImageIcon(getClass().getResource("/icon/logodkhp.png")).getImage());
        
        setUser();
        Timer dongho = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Calendar lich = Calendar.getInstance();
                int gio = lich.get(Calendar.HOUR);
                int phut = lich.get(Calendar.MINUTE);
                int giay = lich.get(Calendar.SECOND);
                jtfCurrent.setText(" " + gio + " : " + phut + " : " + giay);
            }
        });
        dongho.start();
    }

    private void setUser() {
        nameLogin = Login.nameLogin;
        jlbUser.setText(nameLogin);
        thongBaoMatKhau.setText(Login.thongBaoMatKhau);
        jlbToday.setText(date);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jlbUser = new javax.swing.JLabel();
        jlbToday = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfCurrent = new javax.swing.JTextField();
        thongBaoMatKhau = new javax.swing.JLabel();
        jtpContent = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jmHeThong = new javax.swing.JMenu();
        jmidoimatkhau = new javax.swing.JMenuItem();
        jmiLogOff = new javax.swing.JMenuItem();
        jmiExit = new javax.swing.JMenuItem();
        dangkyhocphan = new javax.swing.JMenu();
        xemlichhoc = new javax.swing.JMenu();

        jMenuItem3.setText("jMenuItem3");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PHẦN MỀM ĐĂNG KÝ  HỌC PHẦN - TRƯỜNG ĐẠI HỌC CÔNG NGHIỆP HÀ NỘI");
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(1300, 620));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(0, 153, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 0, 51));
        jLabel2.setText("ID :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 0, 51));
        jLabel3.setText("Ngày :");

        jlbUser.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jlbUser.setForeground(new java.awt.Color(255, 255, 255));

        jlbToday.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jlbToday.setForeground(new java.awt.Color(255, 255, 255));
        jlbToday.setText("Hour");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 0, 51));
        jLabel5.setText("Giờ :");

        jtfCurrent.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jtfCurrent.setEnabled(false);
        jtfCurrent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfCurrentActionPerformed(evt);
            }
        });

        thongBaoMatKhau.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        thongBaoMatKhau.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbUser, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(thongBaoMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 193, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlbToday, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                    .addComponent(jtfCurrent))
                .addGap(22, 22, 22))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfCurrent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlbToday)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jlbUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(thongBaoMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jtpContent.setBackground(new java.awt.Color(0, 0, 0));
        jtpContent.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jtpContent.setMinimumSize(new java.awt.Dimension(1106, 638));
        jtpContent.setPreferredSize(new java.awt.Dimension(1106, 638));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1252, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 604, Short.MAX_VALUE)
        );

        jtpContent.addTab("Trang Chủ", jPanel6);

        jMenuBar2.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jmHeThong.setBackground(new java.awt.Color(186, 216, 219));
        jmHeThong.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jmHeThong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/taikhoan.png"))); // NOI18N
        jmHeThong.setText("Tài Khoản");
        jmHeThong.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jmHeThong.setPreferredSize(new java.awt.Dimension(145, 32));

        jmidoimatkhau.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        jmidoimatkhau.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jmidoimatkhau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/doimatkhau.png"))); // NOI18N
        jmidoimatkhau.setText("Đổi Mật Khẩu");
        jmidoimatkhau.setPreferredSize(new java.awt.Dimension(213, 30));
        jmidoimatkhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmidoimatkhauMouseClicked(evt);
            }
        });
        jmidoimatkhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmidoimatkhauActionPerformed(evt);
            }
        });
        jmHeThong.add(jmidoimatkhau);

        jmiLogOff.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jmiLogOff.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jmiLogOff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dangxuat.png"))); // NOI18N
        jmiLogOff.setText("Đăng Xuất");
        jmiLogOff.setPreferredSize(new java.awt.Dimension(213, 30));
        jmiLogOff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiLogOffActionPerformed(evt);
            }
        });
        jmHeThong.add(jmiLogOff);

        jmiExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jmiExit.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jmiExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/thoat.png"))); // NOI18N
        jmiExit.setText("Thoát");
        jmiExit.setPreferredSize(new java.awt.Dimension(213, 30));
        jmiExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiExitActionPerformed(evt);
            }
        });
        jmHeThong.add(jmiExit);

        jMenuBar2.add(jmHeThong);

        dangkyhocphan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dangkyday.png"))); // NOI18N
        dangkyhocphan.setText("Đăng Ký Học Phần");
        dangkyhocphan.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        dangkyhocphan.setPreferredSize(new java.awt.Dimension(200, 32));
        dangkyhocphan.setRolloverEnabled(false);
        dangkyhocphan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dangkyhocphanMouseClicked(evt);
            }
        });
        jMenuBar2.add(dangkyhocphan);

        xemlichhoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/xemlichday.png"))); // NOI18N
        xemlichhoc.setText("Xem Lịch Học");
        xemlichhoc.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        xemlichhoc.setPreferredSize(new java.awt.Dimension(155, 32));
        xemlichhoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                xemlichhocMouseClicked(evt);
            }
        });
        jMenuBar2.add(xemlichhoc);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jtpContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jtpContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jtpContent.getAccessibleContext().setAccessibleName("Trang Chủ");

        setSize(new java.awt.Dimension(1275, 807));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jmiExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jmiExitActionPerformed

    private void jmiLogOffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiLogOffActionPerformed
        dispose();
        Login login = new Login();
        login.setVisible(true);
    }//GEN-LAST:event_jmiLogOffActionPerformed

    private void jmidoimatkhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmidoimatkhauActionPerformed
        jtpContent.removeAll();
        DoiMatKhau ld=new DoiMatKhau();
         ld.show();
         ld.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        ld.setVisible(true);
//        this.setVisible(false);
    }//GEN-LAST:event_jmidoimatkhauActionPerformed

    private void dangkyhocphanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dangkyhocphanMouseClicked
       jtpContent.removeAll();
       DangKyHocPhan dk=new DangKyHocPhan();
       jtpContent.add("Đăng ký học phần",dk);
      // dk.setVisible(true);
       // dk.setExtendedState(dk.MAXIMIZED_HORIZ);
      // dk.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);      
      // jtpContent.add("Đăng ký hoc", dkd);
       
       
    }//GEN-LAST:event_dangkyhocphanMouseClicked

    private void xemlichhocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xemlichhocMouseClicked
        try {
             jtpContent.removeAll();
            LichHoc ld=new LichHoc();
           // jtpContent.add("Lịch học",ld);
           ld.show();
           ld.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lịch học trống !", "Vui lòng kiểm tra lại", JOptionPane.ERROR_MESSAGE);
        }
 
    }//GEN-LAST:event_xemlichhocMouseClicked

    private void jtfCurrentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfCurrentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCurrentActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       this.setExtendedState(this.getExtendedState()|JFrame.MAXIMIZED_BOTH);
    }//GEN-LAST:event_formWindowOpened

    private void jmidoimatkhauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmidoimatkhauMouseClicked
        // TODO add your handling code here:DoiMatKhau ld=new DoiMatKhau();
    }//GEN-LAST:event_jmidoimatkhauMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
   
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainSV().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu dangkyhocphan;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel jlbToday;
    private javax.swing.JLabel jlbUser;
    private javax.swing.JMenu jmHeThong;
    private javax.swing.JMenuItem jmiExit;
    private javax.swing.JMenuItem jmiLogOff;
    private javax.swing.JMenuItem jmidoimatkhau;
    private javax.swing.JTextField jtfCurrent;
    private javax.swing.JTabbedPane jtpContent;
    private javax.swing.JLabel thongBaoMatKhau;
    private javax.swing.JMenu xemlichhoc;
    // End of variables declaration//GEN-END:variables
}
