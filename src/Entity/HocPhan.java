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
public class HocPhan {
    private String maHP,tenHP, hinhThucThi;
    private int TCLT,TCTH,donGiaTC;
    public int TongTien(){
        return (TCLT+TCTH)*donGiaTC;
    }
    public HocPhan() {
    }

    public HocPhan(String maHP) {
        this.maHP = maHP;
    }

    public HocPhan(String maHP, String tenHP, String hinhThucThi, int TCLT, int TCTH, int dongiaTC) {
        this.maHP = maHP;
        this.tenHP = tenHP;
        this.hinhThucThi = hinhThucThi;
        this.TCLT = TCLT;
        this.TCTH = TCTH;
        this.donGiaTC=dongiaTC;
    }

    

    public String getMaHP() {
        return maHP;
    }

    public void setMaHP(String maHP) {
        this.maHP = maHP;
    }

    public String getTenHP() {
        return tenHP;
    }

    public void setTenHP(String tenHP) {
        this.tenHP = tenHP;
    }

    public int getTCLT() {
        return TCLT;
    }

    public void setTCLT(int TCLT) {
        this.TCLT = TCLT;
    }

    public int getTCTH() {
        return TCTH;
    }

    public void setTCTH(int TCTH) {
        this.TCTH = TCTH;
    }

    public int getDonGiaTC() {
        return donGiaTC;
    }

    public void setDonGiaTC(int donGiaTC) {
        this.donGiaTC = donGiaTC;
    }

    public String getHinhThucThi() {
        return hinhThucThi;
    }

    public void setHinhThucThi(String hinhThucThi) {
        this.hinhThucThi = hinhThucThi;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.maHP);
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
        final HocPhan other = (HocPhan) obj;
        if (!Objects.equals(this.maHP, other.maHP)) {
            return false;
        }
        return true;
    }
    
    
}
