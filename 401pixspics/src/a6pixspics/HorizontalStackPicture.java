package a6pixspics;

public class HorizontalStackPicture implements Picture {
	private Picture left;
	private Picture right;
	// width is column (y)
	// height is row (x)
	
	public HorizontalStackPicture (Picture left, Picture right) {
		this.left = left;
		this.right = right;
		
		if (left == null || right == null) {
			throw new IllegalArgumentException("top is null");
		}
		if (left.getHeight() != right.getHeight() ) {
			throw new IllegalArgumentException("bottom is null");
		}
	
	}
	// if i < getWidth -- left
	// if i > getWidth -- right

	@Override
	public int getWidth() {
		return this.left.getWidth() + this.right.getWidth();
	}

	@Override
	public int getHeight() {
		return this.left.getHeight();

	}

	@Override
	public Pixel getPixel(int x, int y) {
		if (x < 0 || x >= this.getWidth()) {
			throw new IllegalArgumentException("x is not in bounds");
		}
		if (x < this.left.getWidth()) {
			return left.getPixel(x, y);
		} else {
			return right.getPixel(x - left.getWidth(), y);
		}
	}

	@Override
	public void paint(int x, int y, Pixel p) {
		if (x >= left.getWidth()) {
			right.paint (x , y, p, 1);
		}
			left.paint (x , y, p, 1);
		}
		


	@Override
	public void paint(int x, int y, Pixel p, double factor) {
		if (x < left.getWidth()) {
			left.paint(x, y, p, factor);
		} else {
			right.paint(x -left.getWidth(), y, p, factor);
		}
		
		
		
		// TODO Auto-generated method stub

	}

	@Override
	public void paint(int ax, int ay, int bx, int by, Pixel p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void paint(int ax, int ay, int bx, int by, Pixel p, double factor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void paint(int cx, int cy, double radius, Pixel p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void paint(int cx, int cy, double radius, Pixel p, double factor) {
		// TODO Auto-generated method stub

	}

}
