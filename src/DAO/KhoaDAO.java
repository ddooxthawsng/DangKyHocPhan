/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ConnectDatabase.DBConnect;
import Entity.Khoa;
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
public class KhoaDAO implements IKhoaDAO{
     @Override
    public ArrayList<Khoa> getAll() {
        ArrayList<Khoa> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select *from Khoa");
                rs = ps.executeQuery();
                list = new ArrayList<Khoa>();
                while (rs.next()) {
                    Khoa k = new Khoa();
                    k.setMaKhoa(rs.getString(1));
                    k.setTenKhoa(rs.getString(2));
                    list.add(k);
                }
            } catch (SQLException ex) {
                Logger.getLogger(KhoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }

        }
        return list;
    }

    @Override
    public Khoa addNew(Khoa khoa) {
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("INSERT INTO Khoa values (?,?)");
                ps.setString(1, khoa.getMaKhoa());
                ps.setString(2, khoa.getTenKhoa());
                int row = ps.executeUpdate();
                if (row < 1) {
                    khoa = null;
                }
            } catch (SQLException ex) {
                Logger.getLogger(KhoaDAO.class.getName()).log(Level.SEVERE, null, ex);
                khoa = null;
            }finally{
                DBConnect.close(ps);
            }
        }
        return khoa;
    }

    @Override
    public Khoa updateByMa(Khoa khoa) {
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("update Khoa set TenKhoa =? where MaKhoa = ?");
               
                ps.setString(1, khoa.getTenKhoa());
                ps.setString(2, khoa.getMaKhoa());
                int row = ps.executeUpdate();
                if (row < 1) {
                    khoa = null;
                }
            } catch (SQLException ex) {
                Logger.getLogger(KhoaDAO.class.getName()).log(Level.SEVERE, null, ex);
                khoa = null;
            }finally{
                DBConnect.close();
            }
        }
        return khoa;
    }
    public void deleteKhoa(String KhoaID) throws SQLException, ClassNotFoundException{
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            ps = DBConnect.cnn.prepareStatement("delete from Khoa where MaKhoa = ?");
            ps.setString(1, KhoaID);
            ps.executeUpdate();
            DBConnect.close();
        }
    }

    @Override
    public ArrayList<Khoa> checkMa(String makhoa) {
        ArrayList<Khoa> list = null;
        PreparedStatement psCheck = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                psCheck = DBConnect.cnn.prepareStatement("select *from Khoa where MaKhoa = ?");
                psCheck.setString(1, makhoa);
                rs = psCheck.executeQuery();
                list = new ArrayList<Khoa>();
                while (rs.next()) {
                    Khoa k = new Khoa();
                    k.setMaKhoa(rs.getString(1));
                    list.add(k);
                }
            } catch (SQLException ex) {
                Logger.getLogger(KhoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                DBConnect.close(psCheck, rs);
            }
            
        }
        return list;
    }
}
