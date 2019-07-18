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
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import java.io.File;
import java.net.MalformedURLException;
import java.util.Random;

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
	@FXML private Text err_msg;
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
	protected void chooseDir(ActionEvent e) {
		DirectoryChooser dc = new DirectoryChooser();
		chosen_dir.setText(dc.showDialog(primaryStage).getPath());
	}
	
	/**
	 * Generates a random image that is then displayed in the image preview
	 * @param e the event that was generated when button was pressed
	 */
	@FXML 
	protected void randImg(ActionEvent e) throws MalformedURLException {
		File tmp_dir = new File(chosen_dir.getText());
		if (tmp_dir.exists()) {
			File[] imgs = tmp_dir.listFiles((dir, name) -> { 
				name = name.toLowerCase();
				return name.endsWith(".jpg") || name.endsWith(".png");
			});
			Random rand = new Random();
			int rand_num = rand.nextInt(imgs.length);
			img_preview.setImage(new Image(imgs[rand_num].toURI().toURL().toExternalForm()));
		}
		else {
			err_msg.setVisible(true);
			chosen_dir.getStyleClass().add("error");
		}
	}
	
	@FXML
	protected void togBorder(ActionEvent e) {
		
	}
	
	@FXML
	protected void addWin(ActionEvent e) {
		
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
