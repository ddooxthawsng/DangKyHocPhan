/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ConnectDatabase.DBConnect;
import Entity.ChuyenNganh;
import com.microsoft.sqlserver.jdbc.SQLServerException;
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
public class ChuyenNganhDAO implements IChuyenNganhDAO{

   @Override
    public ArrayList<ChuyenNganh> getAll() {
        ArrayList<ChuyenNganh> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select *from ChuyenNganh");
                rs = ps.executeQuery();
                list = new ArrayList<ChuyenNganh>();
                while (rs.next()) {
         
                    ChuyenNganh cn = new ChuyenNganh();
                    cn.setMaChuyenNganh(rs.getString(1));
                    cn.setTenChuyenNganh(rs.getString(2));
                    cn.setMaKhoa(rs.getString(3));
                    list.add(cn);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ChuyenNganhDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }

        }
        return list;
    }

    @Override
    public ChuyenNganh addNew(ChuyenNganh ChuyenNganh) {
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("INSERT INTO ChuyenNganh values (?,?,?)");
                ps.setString(1, ChuyenNganh.getMaChuyenNganh());
                ps.setString(2, ChuyenNganh.getTenChuyenNganh());
                ps.setString(3, ChuyenNganh.getMaKhoa());
                int row = ps.executeUpdate();
                if (row < 1) {
                    ChuyenNganh = null;
                }
            } catch (SQLException ex) {
                //Logger.getLogger(ChuyenNganhDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Mã khoa "+ChuyenNganh.getMaKhoa()+" không có trong danh sách khoa, thêm khoa này vào danh sách khoa trước khi thêm chuyên ngành");
                ChuyenNganh = null;
            }finally{
                DBConnect.close(ps);
            }
        }
        return ChuyenNganh;
    }

    @Override
    public ChuyenNganh updateByMa(ChuyenNganh ChuyenNganh) {
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("update ChuyenNganh set TenCN =?, MaKhoa = ? where MaCN = ?");
                
                
                ps.setString(1, ChuyenNganh.getTenChuyenNganh());
                ps.setString(2, ChuyenNganh.getMaKhoa());
                ps.setString(3, ChuyenNganh.getMaChuyenNganh());
                int row = ps.executeUpdate();
                if (row < 1) {
                    ChuyenNganh = null;
                }
            } catch (SQLException ex) {
                Logger.getLogger(ChuyenNganhDAO.class.getName()).log(Level.SEVERE, null, ex);
                //JOptionPane.showMessageDialog(null, "Mã khoa "+ChuyenNganh.getMaKhoa()+" không có trong danh sách khoa, thêm khoa này vào danh sách khoa trước khi sửa chuyên ngành");
                ChuyenNganh = null;
            }finally{
                DBConnect.close(ps);
            }
        }
        return ChuyenNganh;
    }
    public void deleteChuyenNganh(String ChuyenNganhID) throws SQLException, ClassNotFoundException{
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            ps = DBConnect.cnn.prepareStatement("delete from ChuyenNganh where MaCN = ?");
            ps.setString(1, ChuyenNganhID);
            ps.executeUpdate();
            DBConnect.close();
        }
    }

    @Override
    public ArrayList<ChuyenNganh> checkMa(String maChuyenNganh) {
        ArrayList<ChuyenNganh> list = null;
        PreparedStatement psCheck = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                psCheck = DBConnect.cnn.prepareStatement("select *from ChuyenNganh where MaCN = ?");
                psCheck.setString(1, maChuyenNganh);
                rs = psCheck.executeQuery();
                list = new ArrayList<ChuyenNganh>();
                while (rs.next()) {
                    ChuyenNganh k = new ChuyenNganh();
                    k.setMaChuyenNganh(rs.getString(1));
                    list.add(k);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ChuyenNganhDAO.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                DBConnect.close(psCheck, rs);
            }
            
        }
        return list;
    }

    
}
