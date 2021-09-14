/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ConnectDatabase.DBConnect;
import Entity.LopHoc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class LopHocDAO implements ILopHocDAO {
     @Override
    public ArrayList<LopHoc> getAll() {
        ArrayList<LopHoc> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select *from Lop");
                rs = ps.executeQuery();
                list = new ArrayList<LopHoc>();
                while (rs.next()) {
                    LopHoc lh = new LopHoc();
                    lh.setMaLop(rs.getString(1));
                    lh.setTenLop(rs.getString(2));
                    lh.setSiSo(rs.getInt(3));
                    lh.setKhoaHoc(rs.getString(4));
                    lh.setMaChuyenNganh(rs.getString(5));
                    list.add(lh);
                }
            } catch (SQLException ex) {
                Logger.getLogger(LopHocDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }
        }
        return list;
    }

    @Override
    public ArrayList<LopHoc> findByMaChuyenNganh(String maChuyenNganh) {
        ArrayList<LopHoc> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select * from Lop where MaCN = ?");
               ps.setString(1, maChuyenNganh);
                rs = ps.executeQuery();
                list = new ArrayList<LopHoc>();
                while (rs.next()) {
                    LopHoc lh = new LopHoc();
                    lh.setMaLop(rs.getString(1));
                    lh.setTenLop(rs.getString(2));
                    lh.setSiSo(rs.getInt(3));
                    lh.setKhoaHoc(rs.getString(4));
                    lh.setMaChuyenNganh(rs.getString(5));
                    list.add(lh);
                }

            } catch (SQLException ex) {
                Logger.getLogger(LopHocDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }
        }
        return list;
    }

    @Override
    public LopHoc addNew(LopHoc lh) {
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("insert into Lop values(?,?,?,?,?)");
                ps.setString(1, lh.getMaLop());
                ps.setString(2, lh.getTenLop());
                ps.setInt(3, lh.getSiSo());
                ps.setString(4,lh.getKhoaHoc());
                ps.setString(5, lh.getMaChuyenNganh());
                int row = ps.executeUpdate();
                if (row < 1) {
                    lh = null;
                }
            } catch (SQLException ex) {
                //Logger.getLogger(LopHocDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Chuyên ngành có mã "+lh.getMaChuyenNganh()+ " không có trong danh sách chuyên ngành, thêm chuyên ngành này trước khi thêm lớp học ");
                lh = null;
            } finally {
                DBConnect.close(ps);
            }
        }
        return lh;
    }


    @Override
    public LopHoc updateByMa(LopHoc lh) {
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("update Lop set TenLop =?,SiSo=?, KhoaHoc = ?,MaCN = ? where MaLop = ?");
                ps.setString(1, lh.getTenLop());
                ps.setInt(2, lh.getSiSo());
                ps.setString(3, lh.getKhoaHoc());
                ps.setString(4, lh.getMaChuyenNganh());
                 ps.setString(5, lh.getMaLop());
                int row = ps.executeUpdate();
                if (row < 1) {
                    lh = null;
                }
            } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, "Chuyên ngành có mã "+lh.getMaChuyenNganh()+ " không có trong danh sách chuyên ngành, thêm chuyên ngành này trước khi sửa lớp học ");
                lh = null;
            } finally {
                DBConnect.close();
            }
        }
        return lh;
    }
    public void deleteLopHoc(String LopID)throws SQLException, ClassNotFoundException{
    PreparedStatement ps = null;
        if (DBConnect.open()) {
            ps = DBConnect.cnn.prepareStatement("delete from Lop where MaLop= ?");
            ps.setString(1, LopID);
            ps.executeUpdate();
            DBConnect.close();
        }
    }

    @Override
    public ArrayList<LopHoc> checkMa(String malop) {
      ArrayList<LopHoc> list = null;
      PreparedStatement psCheck = null;
      ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                psCheck = DBConnect.cnn.prepareStatement("select *from Lop where MaLop=?");
                psCheck.setString(1, malop);
                rs = psCheck.executeQuery();
                list = new ArrayList<LopHoc>();
                while (rs.next()) {
                    LopHoc lh = new LopHoc();
                    lh.setMaLop(rs.getString(1));
                    list.add(lh);
                }
            } catch (SQLException ex) {
                Logger.getLogger(LopHocDAO.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
            DBConnect.close(psCheck, rs);
            }
            
        }
        return list;
    }
}
