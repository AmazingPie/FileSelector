package models;

import javafx.scene.input.ScrollEvent;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author chris
 */
public class ZoomableLetterboxWindow extends LetterboxWindow
{
	private double start_x;
	private double start_y;
	private double start_trans_x;
	private double start_trans_y;
	
	
	public ZoomableLetterboxWindow(String url) {
		super(url);
		//Zooming
		scene.setOnScroll((ScrollEvent e) -> {
			if (e.getDeltaY() < 0) {
				root.setScaleX(root.getScaleX() * 0.95);
				root.setScaleY(root.getScaleY() * 0.95);
			}
			else {
				root.setScaleX(root.getScaleX() * 1.05);
				root.setScaleY(root.getScaleY() * 1.05);
			}
			e.consume();
		});
		
		//"Movement"
		scene.setOnMousePressed((MouseEvent e) -> {
			start_x = e.getX();
			start_y = e.getY();
			start_trans_x = root.getTranslateX();
			start_trans_y = root.getTranslateY();
		});
		scene.setOnMouseDragged((MouseEvent e) -> {
			root.setTranslateX(e.getX() - start_x + start_trans_x);
			root.setTranslateY(e.getY() - start_y + start_trans_y);
		});
	}
}