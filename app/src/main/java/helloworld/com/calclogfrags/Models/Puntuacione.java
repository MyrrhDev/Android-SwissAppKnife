
package helloworld.com.calclogfrags.Models;

import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Puntuacione implements Comparable<Puntuacione>{


    @SerializedName("score")
    @Expose
    private double score;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("id")
    @Expose
    private int id;



    public Puntuacione( int id, String username, double score) {
        this.username = username;
        this.score = score;
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(@NonNull Puntuacione o) {


            if (score < o.score) {
                return 1;
            }
            else if (score >  o.score) {
                return -1;
            }
            else {
                return 0;
            }


    }
}
