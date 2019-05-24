package com.pojo.zj;

public class Feedback {
    private int id;
    private String teaname;
    private String content;

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", teaname='" + teaname + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeaname() {
        return teaname;
    }

    public void setTeaname(String teaname) {
        this.teaname = teaname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
