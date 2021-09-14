/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.LopHocPhan;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public interface ILopHocPhanDAO {
    public ArrayList<LopHocPhan> getAll();
   // public ArrayList<LopHocPhan> findByIDKhoa(String maKhoa);
    public ArrayList<LopHocPhan> findByMaLHP(String maLHP);
    public LopHocPhan addNew(LopHocPhan lhp);
    public LopHocPhan updateByMa(LopHocPhan lhp);
    public ArrayList<LopHocPhan> checkMaLHP(String maLHP);
}
