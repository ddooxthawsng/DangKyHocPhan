/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Khoa;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public interface IKhoaDAO {
    public ArrayList<Khoa> getAll();
    public Khoa addNew(Khoa khoa);
    public Khoa updateByMa(Khoa khoa);
    public ArrayList<Khoa> checkMa(String makhoa);
}
