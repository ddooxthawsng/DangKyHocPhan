/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.HocPhan;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public interface IHocPhanDAO {
    public ArrayList<HocPhan> getAll();

   // public ArrayList<HocPhan> findTenKhoa(String tenKhoa);

    public HocPhan addNew(HocPhan hp);

    public HocPhan updateByMaHP(HocPhan hp);
    public ArrayList<HocPhan> CheckMaHP(String maHP);
   // public ArrayList<HocPhan> CheckMaMH(String maMH);
}
