
package com.karthik.aiainsurance.domain;

import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImageDetails {
    @SerializedName("link")
    private String link;
    @SerializedName("points")
    private int points;
    @SerializedName("score")
    private int score;

    public ImageDetails(@NonNull String link, int points, int score) {
        this.link = link;
        this.points = points;
        this.score = score;
    }

    public String getLink() {
        return link;
    }

    public int getPoints() {
        return points;
    }

    public int getScore() {
        return score;
    }
}
