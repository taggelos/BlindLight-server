package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;

import java.awt.*;
import java.util.Date;
import java.sql.*;
//import org.eclipse.paho.client.mqttv3.MqttClient;
import javafx.stage.Stage;
import sample.Pub_Sub.MqttPublisher;
import sample.Pub_Sub.MqttSubscriber;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.util.Date;
import java.sql.*;
import static sample.Controller.*;



public class Main extends Application {

    private static Stage pStage;
    public static Stage getPrimaryStage() {
        return pStage;
    }
    private void setPrimaryStage(Stage pStage) {
        this.pStage = pStage;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        setPrimaryStage(primaryStage);

        ObservableList items =
                FXCollections.observableArrayList();


        Parent root = FXMLLoader.load(getClass().getResource("Settings.fxml"));
        primaryStage.setTitle("BlindLight(Beta)");
        primaryStage.setScene(new Scene(root, 800, 400));
        primaryStage.getIcons().add(new Image("sample/icon.png"));
        primaryStage.show();
    }

    public static void main(String[] args) {



        //------------Empty Data Base-----------


        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "MyNewPass");
            Statement stmt = connection.createStatement( );
            // Use TRUNCATE
            String sql = "TRUNCATE blind_light_data";
            // Execute deletion
            stmt.executeUpdate(sql);
        }
        catch ( SQLException err ) {
            System.out.println( err.getMessage( ) );
        }


        launch(args);



    }



}
