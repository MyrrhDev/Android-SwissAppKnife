package helloworld.com.calclogfrags.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PuntPOST {

    @SerializedName("puntuacion")
    @Expose
    private GamePoints puntuacion;

    public GamePoints getPuntuacion() {
        return puntuacion;
    }

    public PuntPOST setPuntuacion(GamePoints puntuacion) {
        this.puntuacion = puntuacion;
        return this;
    }

}