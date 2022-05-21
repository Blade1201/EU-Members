
package eu;

import java.time.LocalDate;


public class EuClass {
    private String orszag;
    private LocalDate csatlakozas;
    
    
    public String getOrszag() {
        return orszag;
    }

    public void setOrszag(String orszag) {
        this.orszag = orszag;
    }

    public LocalDate getCsatlakozas() {
        return csatlakozas;
    }

    public void setCsatlakozas(LocalDate csatlakozas) {
        this.csatlakozas = csatlakozas;
    }

    @Override
    public String toString() {
        return "EuClass{" + "orszag=" + orszag + ", csatlakozas=" + csatlakozas + '}';
    }
}
