/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registration;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author jit
 */
public class Registration extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
//       Pane paneTableUser = FXMLLoader.load(getClass().getResource("TableUser.fxml"));
//         Map<String, Pane> mapPanes = new TreeMap<>();
//         mapPanes.put("TableUser", paneTableUser);
//        Scene scene = new Scene(mapPanes.get("TableUser"));
//        primaryStage.setTitle("Streams App");
//        primaryStage.setScene(scene);
//        primaryStage.show();
   try{
        
        Parent log = FXMLLoader.load(getClass().getResource("TableUser.fxml")); 
          Scene scene = new Scene(log);
        //scene2=new Scene (book);
        primaryStage.setTitle("Library Management");
        primaryStage.setScene(scene);
        primaryStage.show();
        } catch (IOException e) {
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
