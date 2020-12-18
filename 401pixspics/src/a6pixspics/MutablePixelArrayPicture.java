package a6pixspics;

public class MutablePixelArrayPicture implements Picture {
	private Pixel[][] _pixels;
	private Pixel initial_value;
	// test x to width and y to height
	/*
	 *  x axis is vertical, y is horizontal
	*/
	
	
	
	// Creates new object using values provided by pixel_array, matching in size. 
	public MutablePixelArrayPicture(Pixel[][] pixel_array) {
	
	
	
		
		if (pixel_array == null) {
			throw new IllegalArgumentException("array is null");
		}
		if (pixel_array.length == 0) {
			throw new IllegalArgumentException("array is empty");
		}
		
		for (int i=0; i < pixel_array.length; i++) {
			if (pixel_array[i] == null) {
				throw new IllegalArgumentException("array is empty");
			}
			if (pixel_array[i].length != pixel_array[0].length) {
				throw new IllegalArgumentException("uneven");
			}
		}

			int width = pixel_array.length;
			int height = pixel_array[0].length;
			_pixels = new Pixel[width][height];
			
			for (int j=0; j < width; j++) {
				for (int k=0; k< height; k++) {
				if (pixel_array[j][k] == null) {
					throw new IllegalArgumentException("there's a null pixel somewhere");
				}
				_pixels[j][k] = pixel_array[j][k];
			}
			}
	}
			
//			for (int j=1; j < pixel_array.length; j++) {
//				int check = this.pixel_array[0].length;
//				if (this.pixel_array[j] == null) {
//					throw new IllegalArgumentException("array is null");
//				}
//				if (this.pixel_array[j].length == 0) {
//					throw new IllegalArgumentException("array is empty");
//				}
//				if (check != this.pixel_array[j].length) {
//					throw new IllegalArgumentException("dimensions");
//				}
//			}
//			// dimension check
//	
//			for (int j=0; j < this.pixel_array[i].length; j++) {
//				if (this.pixel_array[i][j] == null) {
//					throw new IllegalArgumentException("value is null");
//				}
//			}
	

		
//	Pixel [][] pixelArray = new Pixel [width][height];
//		
//		for (int i = 0; i < width; i++) {
//			for (int j = 0; j < height; j++) {
//				pixelArray[i][j] = new GrayPixel(0.5);
//			}
//		}
//		this.pixel_array = pixelArray;
		


	
	// Creates new object by providing geometry of picture and an initial value for all pixels.
	public MutablePixelArrayPicture(int width, int height, Pixel initial_value) {
		
		
		if (width < 1) {
			throw new IllegalArgumentException("width is out");
		}
		if (height < 1) {
			throw new IllegalArgumentException("height is null");
		}
		if (initial_value == null) {
			throw new IllegalArgumentException("initial value is null");
		}
		_pixels = new Pixel [width][height];
		
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				_pixels[i][j] = initial_value;
			}
		}
	}


	
	// Creates new object by providing geometry of picture. 
	// Initial value of all pixels should be medium gray (i.e., a grayscale pixel with intensity 0.5)
	public MutablePixelArrayPicture(int width, int height) {
		//this.pixel_array = pixel_array;
			this(width, height, new GrayPixel(0.5));

	}
		
	
	@Override
	public int getWidth() {
		return _pixels.length;
	}

	@Override
	public int getHeight() {
		return _pixels[0].length;
	}

	// getPixel(x, y) retrieves the pixel at position (x,y) in the
	// picture. The coordinate (0,0) is the upper left
	// corner of the picture. The coordinate (getWidth()-1, getHeight()-1)
	// is the lower right of the picture. An IllegalArgumentException
	// is thrown if x or y are not in range.
	

	public Pixel getPixel(int x, int y) {
		if (x < 0 || x >= getWidth() || y < 0|| y >= getHeight()) {
			throw new IllegalArgumentException("x's and y's are not in range");
	}
	return _pixels[x][y];
	}


	// The various forms of the paint() method return a new
	// picture object based on this picture with certain pixel
	// positions "painted" with a new value.
	
	// paint(int x, int y, Pixel p) paints the pixel at
	// position (x,y) with the pixel value p. The second 
	// form includes a factor parameter that specifies a
	// blending factor. A factor of 0.0 leaves the specified
	// pixel unchanged. A factor of 1.0 results in replacing
	// the value with the specified pixel value. Values between
	// 0.0 and 1.0 blend proportionally.

	public void paint(int x, int y, Pixel p) {

		paint (x, y, p, 1);
	}

	@Override
	public void paint(int x, int y, Pixel p, double factor) {
		if (x < 0 || x >= this.getWidth()) {
			throw new IllegalArgumentException("x's are not in range");
		}
		if (y < 0|| y >= this.getHeight()) {
			throw new IllegalArgumentException("y's are not in range");
		}
		if (p == null) {
			throw new IllegalArgumentException("p is null");
		}
		if (factor < 0.0 || factor > 1.0) {
			throw new IllegalArgumentException("factor is out of range");
		}
		_pixels[x][y] = _pixels[x][y].blend(p, factor);

	}

	@Override
	public void paint(int ax, int ay, int bx, int by, Pixel p) {
		if (ax >= this.getWidth() || ax < 0) {
			throw new IllegalArgumentException("ax is out");
		}
		if (bx >= this.getWidth() || bx < 0) {
			throw new IllegalArgumentException("bx is out");
		}
		if (ay >= this.getHeight() || ay < 0) {
			throw new IllegalArgumentException("ay is out");
		}
		if (by >= this.getHeight() || by < 0) {
			throw new IllegalArgumentException("by is out");
		}
		paint (ax, ay, bx, by, p, 1);
	}


	@Override
	public void paint(int ax, int ay, int bx, int by, Pixel p, double factor) {

		if (ax >= this.getWidth() || ax < 0) {
			throw new IllegalArgumentException("ax is out");
		}
		if (bx >= this.getWidth() || bx < 0) {
			throw new IllegalArgumentException("bx is out");
		}
		if (ay >= this.getHeight() || ay < 0) {
			throw new IllegalArgumentException("ay is out");
		}
		if (by >= this.getHeight() || by < 0) {
			throw new IllegalArgumentException("by is out");
		}
		if (factor < 0.0 || factor > 1.0) {
			throw new IllegalArgumentException("factor illegal");
		}
		if (p == null) {
			throw new IllegalArgumentException("p null");
		}
		
			
		int rowMin = Math.min(ax, bx);
		int rowMax = Math.max(ax, bx);
		
		int colMin = Math.min(ay, by);
		int colMax = Math.max(ay, by);
		

		for (int i=rowMin; i <= rowMax; i++) {
			for (int j=colMin; j <= colMax; j++) {
				_pixels[i][j] = _pixels[i][j].blend(p, factor);
			}
		}

	}

	@Override
	public void paint(int cx, int cy, double radius, Pixel p) {

		if (radius < 0.0) {
			throw new IllegalArgumentException("rad out of bounds");
		}
		if (p == null) {
			throw new IllegalArgumentException("p null");
		}
		paint (cx, cy, radius, p, 1);
	}

	@Override
	public void paint(int cx, int cy, double radius, Pixel p, double factor) {

		if (radius < 0.0) {
			throw new IllegalArgumentException("rad out of bounds");
		}
		if (p == null) {
			throw new IllegalArgumentException("p null");
		}
		if (factor < 0.0 || factor > 1.0) {
			throw new IllegalArgumentException("factor illegal");
		}
		for (int i=0; i < this.getWidth(); i++) {
			for (int j=0; j < this.getHeight(); j++) {
				if (Math.sqrt((i-cx)*(i-cx)+(j-cy)*(j-cy)) <= radius) {
					Pixel a = _pixels[i][j].blend(p, factor);
					_pixels[i][j] = a;
				}
			}
		}
	}
}	
