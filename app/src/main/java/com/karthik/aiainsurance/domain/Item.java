
package com.karthik.aiainsurance.domain;

import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Item {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("datetime")
    @Expose
    private Integer datetime;
    private int points;
    @SerializedName("topic_id")
    @Expose
    private int topicId;
    @SerializedName("images")
    @Expose
    private List<ImageDetails> images = null;
    @SerializedName("score")
    @Expose
    private int score;

    public Item(@NonNull String title,
                Integer datetime, int points,
                int topicId, @NonNull List<ImageDetails> images, int score) {
        this.title = title;
        this.points = points;
        this.topicId = topicId;
        this.images = images;
        this.datetime = datetime;
        this.score = score;
    }

    @NonNull public String getTitle() {
        return title;
    }

    @NonNull public Integer getDatetime() {
        return datetime;
    }

    public int getPoints() {
        return points;
    }

    public int getTopicId() {
        return topicId;
    }

    @NonNull public List<ImageDetails> getImages() {
        return images;
    }

    public int getScore() {
        return score;
    }

}
