/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ConnectDatabase.DBConnect;
import Entity.DangKy;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class DangKyDAO {
    public void dangky(String MaLHP,String MaSV){
   
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("insert INTO DangKy(MaLHP,MaSV) values(?,?)");
                ps.setString(1, MaLHP);
                ps.setString(2, MaSV);
                ps.executeUpdate();
//                int row = ps.executeUpdate();
//                if (row < 1) {
//                    dkd = null;
//                }
            } catch (SQLException ex) {
                Logger.getLogger(DangKyDAO.class.getName()).log(Level.SEVERE, null, ex);
              //  dkd = null;
            } finally {
                DBConnect.close(ps);
            }
        }
       // return dkd;
    }
    public void dangky(){
   
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("insert INTO DangKy values(?,?)");
               
                ps.executeUpdate();
//                int row = ps.executeUpdate();
//                if (row < 1) {
//                    dkd = null;
//                }
            } catch (SQLException ex) {
                Logger.getLogger(DangKyDAO.class.getName()).log(Level.SEVERE, null, ex);
               
            } finally {
                DBConnect.close(ps);
            }
        }
      
    }
    public void huydangkyhoc(String maLHP,String maSV) throws SQLException{
   
       PreparedStatement ps = null;
        if (DBConnect.open()) {
            ps = DBConnect.cnn.prepareStatement("delete from DangKy where MaLHP= ? and MaSV =?");
            ps.setString(1, maLHP);
            ps.setString(2, maSV);
            ps.executeUpdate();
            DBConnect.close();
        }
    }
    public ArrayList<DangKy> getAll() {
        ArrayList<DangKy> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select *from DangKy");
                rs = ps.executeQuery();
                list = new ArrayList<DangKy>();
                while (rs.next()) {
                    DangKy dkd = new DangKy();   
                    dkd.setMaLHP(rs.getString(1));
                    dkd.setMaSV(rs.getString(2));
                    list.add(dkd);
                }
            } catch (SQLException ex) {
                Logger.getLogger(LopHocPhanDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }
        }
        return list;
    }
    public ArrayList<DangKy> checkID(String maLHP) {
      ArrayList<DangKy> list = null;
      PreparedStatement psCheck = null;
      ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                psCheck = DBConnect.cnn.prepareStatement("select *from DangKy where MaLHP=?");
                psCheck.setString(1, maLHP);
                rs = psCheck.executeQuery();
                list = new ArrayList<DangKy>();
                while (rs.next()) {
                    DangKy lh = new DangKy();
                    lh.setMaLHP(rs.getString(1));
                    list.add(lh);
                }
            } catch (SQLException ex) {
                Logger.getLogger(LopHocDAO.class.getName()).log(Level.SEVERE, null, ex);
                list=null;
            }finally{
            DBConnect.close(psCheck, rs);
            }
            
        }
        return list;
    }
    
//    public ArrayList<PhieuDangKyHoc> sapxeptheoNamHoc(String namHoc) {
//        ArrayList<PhieuDangKyHoc> list = null;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        if (DBConnect.open()) {
//            try {
//                ps = DBConnect.cnn.prepareStatement("select * from tblPhieuDangKyHoc where fldNamHoc = ?");
//               ps.setString(1, namHoc);
//                rs = ps.executeQuery();
//                list = new ArrayList<PhieuDangKyHoc>();
//                while (rs.next()) {
//                    PhieuDangKyHoc dkd = new PhieuDangKyHoc();
//                    dkd.setMaLHP(rs.getString(1));
//                    dkd.setMaSV(rs.getString(2));
//                    dkd.setHocKy(rs.getString(3));
//                    dkd.setNamHoc(rs.getString(4));
//                    dkd.setNgayDangKy(rs.getString(5));
//                    list.add(dkd);
//                }
//
//            } catch (SQLException ex) {
//                Logger.getLogger(LopHocDAO.class.getName()).log(Level.SEVERE, null, ex);
//                list=null;
//            } finally {
//                DBConnect.close(ps, rs);
//            }
//        }
//        return list;
//    }
   public ArrayList<DangKy> getAll_LHP_ByMaSV(String maSV) {
        ArrayList<DangKy> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select * from DangKy where MaSV = ?");
               ps.setString(1, maSV);
                rs = ps.executeQuery();
                list = new ArrayList<DangKy>();
                while (rs.next()) {
                    DangKy dkd = new DangKy();
                    dkd.setMaLHP(rs.getString(1));
                    dkd.setMaSV(rs.getString(2));
                    list.add(dkd);
                }

            } catch (SQLException ex) {
                Logger.getLogger(LopHocDAO.class.getName()).log(Level.SEVERE, null, ex);
                list=null;
            } finally {
                DBConnect.close(ps, rs);
            }
        }
        return list;
    }
   
   public ArrayList<DangKy> getOne_LHP_By_MaLHP_MaSV(String maLHP,String maSV) {
        ArrayList<DangKy> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select * from DangKy where MaLHP = ? and MaSV=?");
               ps.setString(1, maLHP);
               ps.setString(2, maSV);
                rs = ps.executeQuery();
                list = new ArrayList<DangKy>();
                while (rs.next()) {
                    DangKy dkd = new DangKy();
                    dkd.setMaLHP(rs.getString(1));
                    dkd.setMaSV(rs.getString(2));
                    list.add(dkd);
                }

            } catch (SQLException ex) {
                Logger.getLogger(LopHocDAO.class.getName()).log(Level.SEVERE, null, ex);
                list=null;
            } finally {
                DBConnect.close(ps, rs);
            }
        }
        return list;
    }
 
}
