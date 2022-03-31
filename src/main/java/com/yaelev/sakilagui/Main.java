package com.yaelev.sakilagui;

import com.yaelev.sakilagui.dao.DataEntityManger;
import com.yaelev.sakilagui.entity.ActorEntity;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
// timmar vi lagt såhär långt är ca 5Timmar * 3
public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MainController.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);

        stage.setTitle("Hello!");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        DataEntityManger dataEntityManger = new DataEntityManger();
        try{

            dataEntityManger.read();
            //dataEntityManger.create2(new ActorEntity("Jocke","gård"));

        }catch (Exception e){
            System.out.println(e);
        }

        launch();
    }
}