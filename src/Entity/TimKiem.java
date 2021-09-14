/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author User
 */
public class TimKiem {
    private String malop;
    private String masv;

    public TimKiem() {
    }

    public TimKiem(String malop, String masv) {
        this.malop = malop;
        this.masv = masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public String getMasv() {
        return masv;
    }

    public TimKiem(String malop) {
        this.malop = malop;
    }

    public String getMalop() {
        return malop;
    }

    public void setMalop(String malop) {
        this.malop = malop;
    }
}
