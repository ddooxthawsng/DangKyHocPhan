/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.LopHoc;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public interface ILopHocDAO {
    public ArrayList<LopHoc> getAll();
    public ArrayList<LopHoc> findByMaChuyenNganh(String maChuyenNganh);
    public LopHoc addNew(LopHoc lh);
    public LopHoc updateByMa(LopHoc lh);
    public ArrayList<LopHoc> checkMa(String malop);
}
