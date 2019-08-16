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
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.scene.layout.Region;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import java.io.File;
import java.net.MalformedURLException;
import java.util.Random;
import java.util.ArrayList;

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
	@FXML private Text preview_path;
	private Stage primaryStage;
	private URL url;
	private ResourceBundle rb;
	private String curr_image;
	private Random rand;
	private ArrayList<Stage> windows;
	
	/**
	 * Only using this constructor to pass in variables from the main program loop.
	 * All other variables that need initialising should do so in initialize
	 * @param primaryStage 
	 */
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
		rand = new Random();
		windows = new ArrayList();
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
			//Clear any previous error messages
			err_msg.setVisible(false);
			chosen_dir.getStyleClass().clear();
			chosen_dir.getStyleClass().add("text-field");
			chosen_dir.getStyleClass().add("text-input");
			
			File[] imgs = tmp_dir.listFiles((dir, name) -> { 
				name = name.toLowerCase();
				return name.endsWith(".jpg") || name.endsWith(".png");
			});
			int rand_num = rand.nextInt(imgs.length);
			String image = imgs[rand_num].toURI().toURL().toExternalForm();
			
			curr_image = image;
			img_preview.setStyle("-fx-background-image: url('" + image + "');");
			
			String[] img_preview_text = image.split("/");
			preview_path.setText(img_preview_text[img_preview_text.length-1]);
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
		models.ZoomableLetterboxWindow lb = new models.ZoomableLetterboxWindow(curr_image);
		windows.add(lb.getStage());
	}
	
	/**
	 * Close all other windows that have been spawned from the main control panel
	 * @param e the event that was generated when button was pressed
	 */
	@FXML
	protected void cleanup(ActionEvent e) {
		windows.forEach((stage) -> stage.close());
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
