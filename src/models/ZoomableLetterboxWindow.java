package models;

import javafx.scene.input.ScrollEvent;

/**
 *
 * @author chris
 */
public class ZoomableLetterboxWindow extends LetterboxWindow
{
	public ZoomableLetterboxWindow(String url) {
		super(url);
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
	}
}
