package com.fabri.twitterApiConsumer.responseDTO;

import java.util.List;

public class TweetsResponse {
    public List<Tweet> data;
    public TweetsMetaData meta;

    public TweetsResponse() {
    }

    public List<Tweet> getData() {
        return data;
    }

    public void setData(List<Tweet> data) {
        this.data = data;
    }

    public TweetsMetaData getMeta() {
        return meta;
    }

    public void setMeta(TweetsMetaData meta) {
        this.meta = meta;
    }

    @Override
    public String toString() {
        return "TweetsResponse{" +
                "data=" + data +
                ", meta=" + meta +
                '}';
    }
}
