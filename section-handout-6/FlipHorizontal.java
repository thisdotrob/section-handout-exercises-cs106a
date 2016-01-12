import acm.graphics.*;
import acm.program.*;

public class FlipHorizontal extends GraphicsProgram {
	
	public void run(){
		GImage origImage = new GImage("frog.gif");
		GImage flippedImage = flipPixels(origImage);
		add(flippedImage, 0, 50);
		add(origImage,flippedImage.getWidth()+ 50,50);
	}

	private GImage flipPixels(GImage origImage) {
		int[][] origPixelArray = origImage.getPixelArray();
		int len1 = origPixelArray.length;
		int len2 = origPixelArray[0].length;
		int[][] flippedPixelArray = new int[len1][len2];
		for (int i = 0; i < len1; i++) {
			for (int j = 0; j < len2; j++) {
			flippedPixelArray[i][j] = origPixelArray[i][len2-j-1];	
			}
		}
		return new GImage(flippedPixelArray);
	}
	
	

}
