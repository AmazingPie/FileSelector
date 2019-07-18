/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.fxml.*;

import java.net.URL;
import java.util.ResourceBundle;
import java.io.IOException;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.scene.layout.Region;
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
	@FXML private Region img_preview;
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
			String image = imgs[rand_num].toURI().toURL().toExternalForm();
			img_preview.setStyle("-fx-background-image: url('" + image + "');");
		}
		else {
			err_msg.setVisible(true);
			chosen_dir.getStyleClass().add("error");
		}
	}
	
	/**
	 * Toggles the standard windows border on all windows generated
	 * @param e the event that was generated when button was pressed
	 */
	@FXML
	protected void togBorder(ActionEvent e) {
		
	}
	
	/**
	 * Makes a new window with the current image being viewed
	 * @param e the event that was generated when button was pressed
	 */
	@FXML
	protected void addWin(ActionEvent e) {
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getClassLoader().getResource("scenes/single_img_scene.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Image");
			Region node = new Region();
			String img = img_preview.getStyle();
			node.setStyle(img + " -fx-background-size: stretch;");
			//((Region)root).setBackground(img_preview.getBackground());
			Scene scene = new Scene(node, 450, 450);
            stage.setScene(scene);
			//scene.getRoot().setStyle("-fx-background-image: url('" + image + "');");
            stage.show();
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * Adds the current image being viewed to the gallery
	 * @param e the event that was generated when button was pressed
	 */
	@FXML
	protected void addGallery(ActionEvent e) {
		
	}
	
	/**
	 * Removes currently selected image from the gallery
	 * @param e the event that was generated when button was pressed
	 */
	@FXML
	protected void rmGallery(ActionEvent e) {
		
	}
	
	/**
	 * Makes a new window containing all images in the gallery which is tessellated to
	 * have all images fit into one window
	 * @param e the event that was generated when button was pressed
	 */
	@FXML
	protected void tessellate(ActionEvent e) {
		
	}
}
