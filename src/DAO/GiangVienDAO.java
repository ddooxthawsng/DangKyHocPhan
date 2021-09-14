/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ConnectDatabase.DBConnect;
import Entity.GiangVien;
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
public class GiangVienDAO implements IGiangVienDAO{
    @Override
    public ArrayList<GiangVien> getAll() {
        ArrayList<GiangVien> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select *from GiangVien");
                rs = ps.executeQuery();
                list = new ArrayList<GiangVien>();
                while (rs.next()) {
                    GiangVien gv = new GiangVien();
                    gv.setMaGV(rs.getString(1));
                    gv.setTenGV(rs.getString(2));
                    gv.setNgaySinh(rs.getString(3));
                    gv.setGioiTinh(rs.getString(4)); 
                    gv.setDiaChi(rs.getString(5));
                    list.add(gv);
                }
            } catch (SQLException ex) {
                Logger.getLogger(GiangVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }
        }
        return list;
    }

    @Override
    public GiangVien addNew(GiangVien gv) {
        PreparedStatement ps = null;
       
        if (DBConnect.open()) {
            try {
                
                ps = DBConnect.cnn.prepareStatement("INSERT INTO GiangVien values (?,?,?,?,?)");
                ps.setString(1, gv.getMaGV());
                ps.setString(2, gv.getTenGV());
                ps.setString(3, gv.getNgaySinh());
                ps.setString(4, gv.getGioiTinh());
                ps.setString(5, gv.getDiaChi());                        
                int row = ps.executeUpdate();
                if (row < 1) {
                    gv = null;
                }
            } catch (SQLException ex) {
                Logger.getLogger(GiangVienDAO.class.getName()).log(Level.SEVERE, null, ex);
                gv = null;
            } finally {
                DBConnect.close(ps);
            }
        }
        return gv;
    }

    @Override
    public GiangVien updateByMaGV(GiangVien gv) {
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("update GiangVien set TenGV =?, NgaySinh=?,GioiTinh=?,DiaChi = ? where MaGV = ?");
                
                ps.setString(1, gv.getTenGV());
                ps.setString(2, gv.getNgaySinh());
                ps.setString(3, gv.getGioiTinh());
                ps.setString(4, gv.getDiaChi());
                ps.setString(5, gv.getMaGV());

                int row = ps.executeUpdate();
                if (row < 1) {
                    gv = null;
                } 
            } catch (SQLException ex) {
                Logger.getLogger(GiangVienDAO.class.getName()).log(Level.SEVERE, null, ex);
                gv = null;
            } finally {
                DBConnect.close();
            }
        }
        return gv;
    }
    public void deleteMaGV(String GiaoVienID)throws SQLException,ClassNotFoundException{
    PreparedStatement ps = null;
        if (DBConnect.open()) {
            ps = DBConnect.cnn.prepareStatement("delete from GiangVien where MaGV= ?");
            ps.setString(1, GiaoVienID);
            ps.executeUpdate();
            DBConnect.close();
        }
    }

    @Override
    public ArrayList<GiangVien> CheckMaGV(String magv) {
      ArrayList<GiangVien> list = null;
        PreparedStatement psCheck = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                psCheck = DBConnect.cnn.prepareStatement("select *from GiangVien where MaGV=?");
               psCheck.setString(1, magv);
                rs = psCheck.executeQuery();
                    list = new ArrayList<GiangVien>();
                    while (rs.next()) {
                        GiangVien giaoVien = new GiangVien();
                        giaoVien.setMaGV(rs.getString(1));
                        list.add(giaoVien);
                    }
            } catch (SQLException ex) {
                Logger.getLogger(GiangVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
            DBConnect.close(psCheck, rs);
            }
        }
        return  list;
    }

    @Override
    public ArrayList<GiangVien> findByMaGV(String maGV) {
        ArrayList<GiangVien> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select  * from GiangVien where MaGV = ?");
                ps.setString(1, maGV);
                rs = ps.executeQuery();
                list = new ArrayList<GiangVien>();
                while (rs.next()) {
                    GiangVien gv = new GiangVien();
                    gv.setMaGV(rs.getString(1));
                    gv.setTenGV(rs.getString(2));
                    gv.setNgaySinh(rs.getString(3));
                    gv.setGioiTinh(rs.getString(4)); 
                    gv.setDiaChi(rs.getString(5));
                    list.add(gv);

                }
            } catch (SQLException ex) {
                Logger.getLogger(GiangVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }
        }
        return list;
    }
}
