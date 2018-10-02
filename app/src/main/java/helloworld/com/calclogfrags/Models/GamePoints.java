package helloworld.com.calclogfrags.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GamePoints {

    @SerializedName("score")
    @Expose
    private double score;
    @SerializedName("username")
    @Expose
    private String username;

    public GamePoints(double score, String username) {
        this.score = score;
        this.username = username;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}