/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ConnectDatabase.DBConnect;
import Entity.SinhVien;
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
public class SinhVienDAO implements ISinhVienDAO{
    @Override
    public ArrayList<SinhVien> getAll() {
        ArrayList<SinhVien> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select *from SinhVien");
                rs = ps.executeQuery();
                list = new ArrayList<SinhVien>();
                while (rs.next()) {
                    SinhVien sv = new SinhVien();
                    sv.setMaSinhVien(rs.getString(1));
                    sv.setTenSinhVien(rs.getString(2));
                    sv.setNgaySinh(rs.getString(3));
                    sv.setGioitinh(rs.getString(4));
                    sv.setDiaChi(rs.getString(5));
                    sv.setHeDT(rs.getString(6));
                    sv.setMaLop(rs.getString(7));
                    list.add(sv);
                }
            } catch (SQLException ex) {
                Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }
        }
        return list;
    }

    @Override
    public ArrayList<SinhVien> findByMaLopHoc(String maLop) {
        ArrayList<SinhVien> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select  * from SinhVien where Malop = ?");
                ps.setString(1, maLop);
                rs = ps.executeQuery();
                list = new ArrayList<SinhVien>();
                while (rs.next()) {
                    SinhVien gv = new SinhVien();
                    gv.setMaSinhVien(rs.getString(1));
                    gv.setTenSinhVien(rs.getString(2));
                    gv.setNgaySinh(rs.getString(3));
                    gv.setGioitinh(rs.getString(4));
                    gv.setDiaChi(rs.getString(5));
                    gv.setHeDT(rs.getString(6));
                    gv.setMaLop(rs.getString(7));
                    list.add(gv);

                }
            } catch (SQLException ex) {
                Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }
        }
        return list;
    }

    @Override
    public SinhVien addNew(SinhVien sv) {
        PreparedStatement ps = null;
       
        if (DBConnect.open()) {
            try {
                
                ps = DBConnect.cnn.prepareStatement("INSERT INTO SinhVien values (?,?,?,?,?,?,?)"
                        + "insert into TaiKhoan values (?,?)");
                ps.setString(1, sv.getMaSinhVien());
                ps.setString(2, sv.getTenSinhVien());
                ps.setString(3, sv.getNgaySinh());
                ps.setString(4, sv.getGioitinh());
                ps.setString(5, sv.getDiaChi());
                ps.setString(6, sv.getHeDT());
                ps.setString(7, sv.getMaLop());
                ps.setString(8,sv.getMaSinhVien());
                ps.setString(9, "123456");                               
                int row = ps.executeUpdate();
                if (row < 1) {
                    sv = null;
                }
            } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, "Lớp học có mã "+sv.getMaLop()+" không có trong danh sách lớp. Thêm lớp học này trong quản lý lớp trước khi thêm sinh viên");
                sv = null;
            } finally {
                DBConnect.close(ps);
            }
        }
        return sv;
    }

    @Override
    public SinhVien updateByMaSV(SinhVien sv) {
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("update SinhVien set TenSV =?,NgaySinh=?,GioiTinh=?,DiaChi = ?,HeDT = ?,MaLop=? where MaSV = ?");
                
                ps.setString(1, sv.getTenSinhVien());
                ps.setString(2, sv.getNgaySinh());
                ps.setString(3, sv.getGioitinh());
                ps.setString(4, sv.getDiaChi());
                ps.setString(5, sv.getHeDT());
                ps.setString(6, sv.getMaLop());
                ps.setString(7,sv.getMaSinhVien());

                int row = ps.executeUpdate();
                if (row < 1) {
                    sv = null;
                } 
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Lớp học có mã "+sv.getMaLop()+" không có trong danh sách lớp. Thêm lớp học này trong quản lý lớp trước khi sửa sinh viên");
            } finally {
                DBConnect.close();
            }
        }
        return sv;
    }
    public void deleteMaSV(String SinhVienID)throws SQLException,ClassNotFoundException{
    PreparedStatement ps = null;
        if (DBConnect.open()) {
            ps = DBConnect.cnn.prepareStatement("delete from SinhVien where MaSV= ?");
            ps.setString(1, SinhVienID);
            ps.executeUpdate();
            DBConnect.close();
        }
    }
    public void deleteUserSV(String SinhVienID)throws SQLException,ClassNotFoundException{
    PreparedStatement ps = null;
        if (DBConnect.open()) {
            ps = DBConnect.cnn.prepareStatement("delete from TaiKhoan where TenTK= ?");
            ps.setString(1, SinhVienID);
            ps.executeUpdate();
            DBConnect.close();
        }
    }
    
    @Override
    public ArrayList<SinhVien> CheckMaSV(String magv) {
      ArrayList<SinhVien> list = null;
        PreparedStatement psCheck = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                psCheck = DBConnect.cnn.prepareStatement("select *from SinhVien where MaSV=?");
               psCheck.setString(1, magv);
                rs = psCheck.executeQuery();
                    list = new ArrayList<SinhVien>();
                    while (rs.next()) {
                        SinhVien sinhVien = new SinhVien();
                        sinhVien.setMaSinhVien(rs.getString(1));
                        list.add(sinhVien);
                    }
            } catch (SQLException ex) {
                Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
            DBConnect.close(psCheck, rs);
            }
        }
        return  list;
    }

    @Override
    public ArrayList<SinhVien> findByMaSV(String maSV) {
        ArrayList<SinhVien> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select  * from SinhVien where MaSV = ?");
                ps.setString(1, maSV);
                rs = ps.executeQuery();
                list = new ArrayList<SinhVien>();
                while (rs.next()) {
                    SinhVien gv = new SinhVien();
                    gv.setMaSinhVien(rs.getString(1));
                    gv.setTenSinhVien(rs.getString(2));
                    gv.setNgaySinh(rs.getString(3));
                    gv.setGioitinh(rs.getString(4));
                    gv.setDiaChi(rs.getString(5));
                    gv.setHeDT(rs.getString(6));
                    gv.setMaLop(rs.getString(7));
                    list.add(gv);

                }
            } catch (SQLException ex) {
                Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }
        }
        return list;
    }
}
