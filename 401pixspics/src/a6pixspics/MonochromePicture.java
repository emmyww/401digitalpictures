package a6pixspics;

public class MonochromePicture implements Picture {
	private int width;
	private int height;
	private Pixel value;
	
	public MonochromePicture (int width, int height, Pixel value) {
		this.width = width; 
		this.height = height;
		this.value = value;
		
		if (this.width <= 0) {
			throw new IllegalArgumentException("width is null");
		}
		if (this.height <= 0) {
			throw new IllegalArgumentException("height is null");
		}
		if (this.value == null) {
			throw new IllegalArgumentException("value is null");
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
		if (x < 0 || x >= this.getWidth()) {
			throw new IllegalArgumentException("x is not in bounds");
		}
		if (y < 0 || y >= this.getHeight()) {
			throw new IllegalArgumentException("y is not in bounds");
		}
		if (value == null) {
			throw new IllegalArgumentException("value is null");
		}
		return value;
	}

	@Override
	public void paint(int x, int y, Pixel p) {
		throw new UnsupportedOperationException ("paint method was called");

	}

	@Override
	public void paint(int x, int y, Pixel p, double factor) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException ("paint method was called");

	}

	@Override
	public void paint(int ax, int ay, int bx, int by, Pixel p) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException ("paint method was called");

	}

	@Override
	public void paint(int ax, int ay, int bx, int by, Pixel p, double factor) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException ("paint method was called");

	}

	@Override
	public void paint(int cx, int cy, double radius, Pixel p) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException ("paint method was called");

	}

	@Override
	public void paint(int cx, int cy, double radius, Pixel p, double factor) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException ("paint method was called");

	}

}
