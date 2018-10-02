
package helloworld.com.calclogfrags.Models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PuntuacionGlobal {

    @SerializedName("puntuaciones")
    @Expose
    private List<Puntuacione> puntuaciones = new ArrayList<>();



    public List<Puntuacione> getPuntuaciones() {
        return puntuaciones;
    }

    public void setPuntuaciones(List<Puntuacione> puntuaciones) {
        this.puntuaciones = puntuaciones;
    }

    public int getSize() {
        return this.puntuaciones.size();
    }

    public Puntuacione position(int i) {
        return this.puntuaciones.get(i);
    }

    public boolean add(Puntuacione puntuacion) {
        this.puntuaciones.add(puntuacion);
        return true;
    }

    public void sortScores() {
        Collections.sort(puntuaciones);

    }

}
