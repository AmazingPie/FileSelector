package models;

import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.stage.Stage;

/**
 * Creates a new dynamically sized letterboxed image window with dynamic.
 * This means that there is a central image with black lines around the outside which maintain the
 * aspect ratio of the image.
 * 
 * Original code taken from a letterboxing demo by jewelsea (https://gist.github.com/jewelsea/5603471) and then modified by chris
 * 
 * @author jewelsea + modified by chris
 */
public class LetterboxWindow {
	private Image image;

	public LetterboxWindow(String url) {
		image = new Image(url);
		Pane root = createPane();
		
		Stage stage = new Stage();
		stage.setTitle("Image");
		Scene scene = new Scene(new Group(root));
		stage.setScene(scene);
		stage.show();

		letterbox(scene, root);
	}

  private StackPane createPane() {
    final int MAX_HEIGHT = 400;

    StackPane stack = new StackPane();

    Pane content = new Pane();

    ImageView imageView = new ImageView(image);
    imageView.setPreserveRatio(true);
    imageView.setFitHeight(MAX_HEIGHT);
    double width = imageView.getLayoutBounds().getWidth();
    content.getChildren().add(imageView);

    content.setMaxSize(width, MAX_HEIGHT);
    content.setClip(new Rectangle(width, MAX_HEIGHT));

    stack.getChildren().add(content);
    stack.setStyle("-fx-background-color: black");

    return stack;
  }

	private void letterbox(final Scene scene, final Pane contentPane) {
		final double initWidth  = scene.getWidth();
		final double initHeight = scene.getHeight();
		final double ratio      = initWidth / initHeight;

		SceneSizeChangeListener sizeListener = new SceneSizeChangeListener(scene, ratio,initHeight, initWidth, contentPane);
		scene.widthProperty().addListener(sizeListener);
		scene.heightProperty().addListener(sizeListener);
	}
}