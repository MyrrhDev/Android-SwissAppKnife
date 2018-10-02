package helloworld.com.calclogfrags;

import java.util.Date;

import io.realm.RealmObject;

public class Puntuacion extends RealmObject{

    private Integer puntuacion;
    private Date date;

    public Puntuacion() {

    }



    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}