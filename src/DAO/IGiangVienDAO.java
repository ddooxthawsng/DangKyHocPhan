/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.GiangVien;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public interface IGiangVienDAO {
    public ArrayList<GiangVien> getAll();
    //public ArrayList<GiangVien> findByMaChuyenNganh(String maChuyenNganh);
    public ArrayList<GiangVien> findByMaGV(String maGV);
    public GiangVien addNew(GiangVien gv);
    public GiangVien updateByMaGV(GiangVien gv);
    public ArrayList<GiangVien> CheckMaGV(String maGV);
}
