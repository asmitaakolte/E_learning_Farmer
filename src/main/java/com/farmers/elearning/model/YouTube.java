package com.farmers.elearning.model;

import jakarta.persistence.*;

@Entity
public class YouTube {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String youtubeLink;

    @ManyToOne
    @JoinColumn(name = "crop_id")
    private Crop crop;

    // Getters and Setters
    public String getYoutubeLink() {
        return youtubeLink;
    }

    public void setYoutubeLink(String youtubeLink) {
        this.youtubeLink = youtubeLink;
    }

    public Crop getCrop() {
        return crop;
    }

    public void setCrop(Crop crop) {
        this.crop = crop;
    }
}
