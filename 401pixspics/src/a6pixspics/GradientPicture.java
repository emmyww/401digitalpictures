package a6pixspics;

public class GradientPicture implements Picture {
	private int width;
	private int height;
	private Pixel upper_left;
	private Pixel upper_right;
	private Pixel lower_left;
	private Pixel lower_right;
	
	
	public GradientPicture (int width, int height, Pixel upper_left, Pixel upper_right, Pixel lower_left, Pixel lower_right) {
		this.width = width;
		this.height = height;
		this.upper_left = upper_left;
		this.upper_right = upper_right;
		this.lower_left = lower_left;
		this.lower_right = lower_right;
	
		
		if (this.width <= 0) {
			throw new IllegalArgumentException("width is null");
		}
		if (this.height <= 0) {
			throw new IllegalArgumentException("height is null");
		}
		if (this.upper_left == null) {
			throw new IllegalArgumentException("upper left is null");
		}
		if (this.upper_right == null) {
			throw new IllegalArgumentException("upper right is null");
		}
		if (this.lower_left == null) {
			throw new IllegalArgumentException("lower left is null");
		}
		if (this.lower_right == null) {
			throw new IllegalArgumentException("lower right is null");
		}
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return this.width;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return this.height;
	}

	@Override
	public Pixel getPixel(int x, int y) {
		double verticalFactor = 1 - (getHeight() - 1.0 - y) / (getHeight() - 1.0);
		Pixel left = this.upper_left.blend(this.lower_left, verticalFactor);
		Pixel right = this.upper_right.blend(this.lower_right, verticalFactor);
		double horizontalFactor = 1 - (getWidth() - 1.0 - x) / (getWidth() - 1.0);
		
		Pixel total = left.blend(right, horizontalFactor);
		return total;
	}

	@Override
	public void paint(int x, int y, Pixel p) {
		throw new UnsupportedOperationException ("paint method was called");

	}

	@Override
	public void paint(int x, int y, Pixel p, double factor) {
		throw new UnsupportedOperationException ("paint method was called");

	}

	@Override
	public void paint(int ax, int ay, int bx, int by, Pixel p) {
		throw new UnsupportedOperationException ("paint method was called");

	}

	@Override
	public void paint(int ax, int ay, int bx, int by, Pixel p, double factor) {
		throw new UnsupportedOperationException ("paint method was called");

	}

	@Override
	public void paint(int cx, int cy, double radius, Pixel p) {
		throw new UnsupportedOperationException ("paint method was called");

	}

	@Override
	public void paint(int cx, int cy, double radius, Pixel p, double factor) {
		throw new UnsupportedOperationException ("paint method was called");

	}

}
