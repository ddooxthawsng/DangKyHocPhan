
package Entity;

import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class LopHocPhan {
    private String maLHP,maHP,maGV, tietHoc,thu,ngayBatDau,diaDiem;

    public LopHocPhan() {
    }

    public LopHocPhan(String maLHP) {
        this.maLHP = maLHP;
    }

    public LopHocPhan(String maLHP, String maHP, String maGV, String tietHoc, String thu, String ngayBatDau, String diaDiem) {
        this.maLHP = maLHP;
        this.maHP = maHP;
        this.maGV = maGV;
        this.tietHoc = tietHoc;
        this.thu = thu;
        this.ngayBatDau = ngayBatDau;
        this.diaDiem = diaDiem;
    }

    public String getMaLHP() {
        return maLHP;
    }

    public void setMaLHP(String maLHP) {
        this.maLHP = maLHP;
    }

    public String getMaHP() {
        return maHP;
    }

    public void setMaHP(String maHP) {
        this.maHP = maHP;
    }

    public String getMaGV() {
        return maGV;
    }

    public void setMaGV(String maGV) {
        this.maGV = maGV;
    }

    public String getTietHoc() {
        return tietHoc;
    }

    public void setTietHoc(String tietHoc) {
        this.tietHoc = tietHoc;
    }

    public String getThu() {
        return thu;
    }

    public void setThu(String thu) {
        this.thu = thu;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public String getDiaDiem() {
        return diaDiem;
    }

    public void setDiaDiem(String diaDiem) {
        this.diaDiem = diaDiem;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.maLHP);
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
        final LopHocPhan other = (LopHocPhan) obj;
        if (!Objects.equals(this.maLHP, other.maLHP)) {
            return false;
        }
        return true;
    }

    
    
    
}
