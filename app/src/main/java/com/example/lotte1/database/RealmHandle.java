package com.example.lotte1.database;

import com.example.lotte1.model.StudentModel;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

//
public class RealmHandle  {
    Realm realm = Realm.getDefaultInstance();
    private static RealmHandle instance;

    public static RealmHandle getInstance() {
        if (instance == null) {
            instance = new RealmHandle();
        }
        return instance;
    }

    public void saveStudent(StudentModel studentModel) {
        realm.beginTransaction();
        realm.copyToRealm(studentModel);
        realm.commitTransaction();

    }

    public List<StudentModel> getAll() {
        return realm.where(StudentModel.class)
                .findAll();
    }
    public void removeStudent(String code){
        realm.beginTransaction();
        RealmResults<StudentModel> s = realm.where(StudentModel.class)
                .equalTo("code",code)
                .findAll();
        s.deleteAllFromRealm();
        realm.commitTransaction();

    }
}
