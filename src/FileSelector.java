/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.fxml.*;

/**
 *
 * @author chris
 */
public class FileSelector extends Application
{
	public static void main(String args[]){    
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("main_scene.fxml"));
		Scene scene = new Scene(root, 600, 300);
		primaryStage.setTitle("File Selector");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
}
