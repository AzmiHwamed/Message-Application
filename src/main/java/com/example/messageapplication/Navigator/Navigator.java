package com.example.messageapplication.Navigator;

import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;

public class Navigator {
    static Navigator obj;
    Stage stage;
    HashMap<String,Scene> hashMap=new HashMap<>();
    private Navigator() {
    }
    public static Navigator getInstance(){
        if(obj==null)
            obj=new Navigator();
        return obj;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void addScene(String name, Scene scene){
        this.hashMap.put(name,scene);
    }
    public void removeScene(String name){
        this.hashMap.remove(name);
    }
    public void showScene(String name){
        this.stage.setScene(obj.hashMap.get(name));
    }
}
