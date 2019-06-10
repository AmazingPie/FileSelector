/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.*;
import javafx.scene.control.*;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import java.io.File;

/**
 * FXML Controller class for the main scene of the program.
 * This will handle almost all of the buttons for controlling the program
 *
 * @author chris
 */
public class MainSceneController implements Initializable
{
	@FXML private ImageView img_preview;
	@FXML private TextField chosen_dir;
	private Stage primaryStage;
	private URL url;
	private ResourceBundle rb;
	
	public MainSceneController(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	/**
	 * Initializes the controller class.
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		this.url = url;
		this.rb = rb;
	}
	
	/**
	 * Opens a directory chooser interface and sets the chosen_dir text field to the selected folder
	 * @param e the event that was generated when button was pressed
	 */
	@FXML
	protected void handleChooseDir(ActionEvent e) {
		DirectoryChooser dc = new DirectoryChooser();
		File chosen_file = dc.showDialog(primaryStage);
	}
	
	/**
	 * Generates a random image that is then displayed in the image preview
	 * @param e the event that was generated when button was pressed
	 */
	@FXML 
	protected void handleRandImg(ActionEvent e) {
		
	}
	
	@FXML
	protected void toggleBorder(ActionEvent e) {
		
	}
	
	@FXML
	protected void addWindow(ActionEvent e) {
		
	}
	
	@FXML
	protected void addGallery(ActionEvent e) {
		
	}
	
	@FXML
	protected void rmGallery(ActionEvent e) {
		
	}
	
	@FXML
	protected void tessellate(ActionEvent e) {
		
	}
	
}
