package com.example.lotte1.model;

import io.realm.RealmObject;

public class StudentModel extends RealmObject {
    private String code;
    private String url;

    public void iniitStudentModel(String code) {
        this.code = code;
        this.url ="http://anhsv.hust.edu.vn/Student/"+code+".jpg";
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "StudentModel{" +
                "code='" + code + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
