package a6pixspics;

public class VerticalStackPicture implements Picture {
	private Picture top;
	private Picture bottom;
	
	public VerticalStackPicture(Picture top, Picture bottom) {
		this.top = top;
		this.bottom = bottom;

		if (this.top == null || this.bottom == null) {
			throw new IllegalArgumentException("top is null");
		}
		if (top.getWidth() != bottom.getWidth() ) {
			throw new IllegalArgumentException("bottom is null");
		}
	}

	@Override
	public int getWidth() {
		return this.top.getWidth();
	}

	@Override
	public int getHeight() {

		return this.top.getHeight() + this.bottom.getHeight();

	}

	@Override
	public Pixel getPixel(int x, int y) {
		if (y < 0 || y >= this.getHeight()) {
			throw new IllegalArgumentException("y is not in bounds");
		}
		if (y < this.top.getHeight()) {
			return top.getPixel(x, y);
		} else {
			return bottom.getPixel(x, y - top.getHeight());
		}
	}
	/*	if (x < 0 || x >= this.getWidth()) {
			throw new IllegalArgumentException("y is not in bounds");
		}
		if (x < this.left.getWidth()) {
			return left.getPixel(x, y);
		} else {
			return right.getPixel(x - left.getWidth(), y);
		}
		*/

	@Override
	public void paint(int x, int y, Pixel p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void paint(int x, int y, Pixel p, double factor) {
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
