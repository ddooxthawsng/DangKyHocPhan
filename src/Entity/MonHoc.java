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
public class MonHoc {
    private String maHP,maChuyenNganh;

    public MonHoc() {
    }

    public MonHoc(String maHP) {
        this.maHP = maHP;
    }

    public MonHoc(String maHP, String maChuyenNganh) {
        this.maHP = maHP;
        this.maChuyenNganh = maChuyenNganh;
    }

    public String getMaHP() {
        return maHP;
    }

    public void setMaHP(String maHP) {
        this.maHP = maHP;
    }

    public String getMaChuyenNganh() {
        return maChuyenNganh;
    }

    public void setMaChuyenNganh(String maChuyenNganh) {
        this.maChuyenNganh = maChuyenNganh;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.maHP);
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
        final MonHoc other = (MonHoc) obj;
        if (!Objects.equals(this.maHP, other.maHP)) {
            return false;
        }
        return true;
    }
    
}
