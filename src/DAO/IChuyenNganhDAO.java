/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import Entity.ChuyenNganh;
/**
 *
 * @author User
 */
public interface IChuyenNganhDAO {

    public ArrayList<ChuyenNganh> getAll();
    public ChuyenNganh addNew(ChuyenNganh chuyennganh);
    public ChuyenNganh updateByMa(ChuyenNganh chuyenNganh);
    public ArrayList<ChuyenNganh> checkMa(String machuyennganh);
}
