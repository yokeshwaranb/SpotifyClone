package com.training.spotifyclone.data.entities;

public class Song {

    private String mediaId;
    private String title;
    private String subtitle;
    private String songUrl;
    private String imageUrl;

    public Song(String mediaId, String title, String subtitle, String songUrl, String imageUrl) {
        this.mediaId = mediaId;
        this.title = title;
        this.subtitle = subtitle;
        this.songUrl = songUrl;
        this.imageUrl = imageUrl;
    }

    // Fixed Error
    // Could not deserialize object. Song does not define a no-argument constructor.
    // If you are using ProGuard, make sure these constructors are not stripped
    public Song() {
    }

    public String getMediaId() {
        return mediaId;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getSongUrl() {
        return songUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

}
