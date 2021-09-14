/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Objects;

/**
 *
 * @author User
 */
public class DangKy {
    private String maLHP,maSV;
//    private String ngayDK;
//    private int hocKy,namHoc;

    public DangKy() {
    }

    public DangKy(String maLHP) {
        this.maLHP = maLHP;
    }


    public DangKy(String MaLHP, String MaSV) {
        this.maLHP = maLHP;
        this.maSV = maSV;
    }
    
    public String getMaLHP() {
        return maLHP;
    }

    public void setMaLHP(String maLHP) {
        this.maLHP = maLHP;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.maLHP);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DangKy other = (DangKy) obj;
        if (!Objects.equals(this.maLHP, other.maLHP)) {
            return false;
        }
        return true;
    }
    
}
