
package com.karthik.aiainsurance.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImageDetails {
    @SerializedName("link")
    @Expose
    private String link;

    public ImageDetails(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }

}
