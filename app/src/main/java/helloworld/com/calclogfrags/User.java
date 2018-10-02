package helloworld.com.calclogfrags;

import io.realm.RealmList;
import io.realm.RealmObject;

public class User extends RealmObject {
    private String nombre;
    private String apellidos;
    private String username;
    private String password;

    private String university;
    private String telefono;

    private RealmList<Puntuacion> punt; // One to many

    public User() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public RealmList<Puntuacion> getPunt() {
        return punt;
    }

    public String getUniversity() {
        return university;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean checkPass(String pass) {
        if (pass == this.password) return true;
        else return false;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
