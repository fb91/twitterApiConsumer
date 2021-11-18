package com.fabri.twitterApiConsumer.responseDTO;

public class TweetsMetaData {
    public Long oldest_id;
    public Long newest_id;
    public int result_count;
    public String next_token;

    public TweetsMetaData() {
    }

    public Long getOldest_id() {
        return oldest_id;
    }

    public void setOldest_id(Long oldest_id) {
        this.oldest_id = oldest_id;
    }

    public Long getNewest_id() {
        return newest_id;
    }

    public void setNewest_id(Long newest_id) {
        this.newest_id = newest_id;
    }

    public int getResult_count() {
        return result_count;
    }

    public void setResult_count(int result_count) {
        this.result_count = result_count;
    }

    public String getNext_token() {
        return next_token;
    }

    public void setNext_token(String next_token) {
        this.next_token = next_token;
    }

    @Override
    public String toString() {
        return "TweetsMetaData{" +
                "oldest_id=" + oldest_id +
                ", newest_id=" + newest_id +
                ", result_count=" + result_count +
                ", next_token='" + next_token + '\'' +
                '}';
    }
}
