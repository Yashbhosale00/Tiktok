package com.example.tik_tok;

public class model {
    String videourl;
    int profile;
    String name;

    public model(String videourl, int profile, String name) {
        this.videourl = videourl;
        this.profile = profile;
        this.name = name;
    }

    public String getVideourl() {
        return videourl;
    }

    public void setVideourl(String videourl) {
        this.videourl = videourl;
    }

    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
