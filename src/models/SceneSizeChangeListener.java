package models;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Scale;


/**
 * Adjusts the size/scale of the content, whenever the window is resized, to keep the content
 * aspect ratio constant.
 * 
 * Original code taken from a letterboxing demo by jewelsea (https://gist.github.com/jewelsea/5603471) and then modified by chris
 * 
 * @author jewelsea + modified by chris
 */
class SceneSizeChangeListener implements ChangeListener<Number> {
    private final Scene scene;
    private final double ratio;
    private final double initHeight;
    private final double initWidth;
    private final Pane contentPane;

    public SceneSizeChangeListener(Scene scene, double ratio, double initHeight, double initWidth, Pane contentPane) {
		this.scene = scene;
		this.ratio = ratio;
		this.initHeight = initHeight;
		this.initWidth = initWidth;
		this.contentPane = contentPane;
    }

    @Override
    public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
		final double newWidth  = scene.getWidth();
		final double newHeight = scene.getHeight();

		double scaleFactor =
          newWidth / newHeight > ratio
				? newHeight / initHeight
				: newWidth / initWidth;

		if (scaleFactor >= 1) {
			Scale scale = new Scale(scaleFactor, scaleFactor);
			scale.setPivotX(0);
			scale.setPivotY(0);
			scene.getRoot().getTransforms().setAll(scale);

			contentPane.setPrefWidth (newWidth  / scaleFactor);
			contentPane.setPrefHeight(newHeight / scaleFactor);
		}
		else {
			contentPane.setPrefWidth (Math.max(initWidth,  newWidth));
			contentPane.setPrefHeight(Math.max(initHeight, newHeight));
		}
    }
}