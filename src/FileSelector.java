/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.fxml.*;

import java.net.URL;
import controllers.MainSceneController;

/**
 *
 * @author chris
 */
public class FileSelector extends Application
{
	private final URL main_scene;
	
	public FileSelector() {
		main_scene = getClass().getResource("scenes/main_scene.fxml");
	}
	
	public static void main(String args[]){    
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("scenes/main_scene.fxml"));
		loader.setLocation(main_scene);
		loader.setController(new MainSceneController(primaryStage));
		Parent root = (Parent)loader.load();
		//MainSceneController controller = (MainSceneController)loader.getController();
		Scene scene = new Scene(root, 1000, 600);
		primaryStage.setTitle("File Selector");
		primaryStage.setScene(scene);
		primaryStage.show(); 		
	}
}
