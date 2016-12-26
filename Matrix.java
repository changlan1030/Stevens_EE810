public class Matrix {
	private double[] data;
	private int rows, cols;
	
	public Matrix(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		int n = rows * cols;
		data = new double[n];
		for (int i = 0; i < n; i++) {
			data[i] = 0;
		}
	}
	
	public static Matrix ident(int n) {
		Matrix data_ident = new Matrix(n, n);
		for (int i = 0; i < n; i++) {
			data_ident.set(i, i, 1);
		}
		return data_ident;
	}
	
	public void set(int i, int j, double v) {
		data[i * cols + j] = v;
	}
	
	public double get(int i, int j) {
		if (i < rows && j < cols) {
			return data[i * cols + j];
		}
		else {
			System.out.print("failure: ");
			return 0;
		}
	}
	
	public Matrix add(Matrix right) {
		if (this.rows == right.rows && this.cols == right.cols) {
			Matrix result = new Matrix(this.rows, this.cols);
			for (int i = 0; i < this.rows; i++) {
				for (int j = 0; j < this.cols; j++) {
					result.set(i, j, this.get(i, j) + right.get(i, j));
				}
			}
			return result;
		}
		else {
			return null;
		}
	}
	
	public Matrix sub(Matrix right) {
		if (this.rows == right.rows && this.cols == right.cols) {
			Matrix result = new Matrix(this.rows, this.cols);
			for (int i = 0; i < this.rows; i++) {
				for (int j = 0; j < this.cols; j++) {
					result.set(i, j, this.get(i, j) - right.get(i, j));
				}
			}
			return result;
		}
		else {
			return null;
		}
	}
	
	public Matrix mul(Matrix right) {
		if (this.cols == right.rows) {
			Matrix result = new Matrix(this.rows, right.cols);
			for (int i = 0; i < this.rows; i++) {
				for (int j = 0; j < right.cols; j++) {
					int temp = 0;
					for (int k = 0; k < right.rows; k++) {
						temp += this.get(i, k) * right.get(k, j);
					}
					result.set(i, j, temp);
				}
			}
			return result;
		}
		else {
			return null;
		}
	}
	
	public Matrix mul(double num) {
		Matrix result = new Matrix(this.rows, this.cols);
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.cols; j++) {
				result.set(i, j, this.get(i, j) * num);
			}
		}
		return result;
	}
	
	public Matrix transpose() {
		Matrix result = new Matrix(this.cols, this.rows);
		for (int i = 0; i < this.cols; i++) {
			for (int j = 0; j < this.rows; j++) {
				result.set(i, j, this.get(j, i));
			}
		}
		return result;
	}
	
	public String toString() {
		String output = "";
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				output += data[i * cols + j] + " ";
			}
			output = output.substring(0, output.length() - 1);
			output += '\n';
		}
		output = output.substring(0, output.length() - 1);
		return output;
	}
	
	public static void main(String[] args) {
		Matrix a = new Matrix(3, 4);
		System.out.println("a" + '\n' + a + '\n');
		// 0.0 0.0 0.0 0.0
		// 0.0 0.0 0.0 0.0
		// 0.0 0.0 0.0 0.0
		
		Matrix b = Matrix.ident(3);
		System.out.println("b" + '\n' + b + '\n');
		// 1.0 0.0 0.0
		// 0.0 1.0 0.0
		// 0.0 0.0 1.0
		
		int m = 1;
		Matrix c1 = new Matrix(3, 4);
		Matrix c2 = new Matrix(4, 3);
		Matrix c3 = new Matrix(3, 4);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				c1.set(i, j, m % 10);
				c2.set(j, i, m % 10);
				c3.set(i, j, m * 3 % 10);
				m++;
			}
		}
		System.out.println("c1" + '\n' + c1 + '\n');
		// 1.0 2.0 3.0 4.0
		// 5.0 6.0 7.0 8.0
		// 9.0 0.0 1.0 2.0
		System.out.println("c2" + '\n' + c2 + '\n');
		// 1.0 5.0 9.0
		// 2.0 6.0 0.0
		// 3.0 7.0 1.0
		// 4.0 8.0 2.0
		System.out.println("c3" + '\n' + c3 + '\n');
		// 3.0 6.0 9.0 2.0
		// 5.0 8.0 1.0 4.0
		// 7.0 0.0 3.0 6.0
		
		Matrix d1 = c1.add(c2);
		Matrix d2 = c1.add(c3);
		System.out.println("d1" + '\n' + d1 + '\n');
		// failure
		System.out.println("d2" + '\n' + d2 + '\n');
		// 4.0 8.0 12.0 6.0
		// 10.0 14.0 8.0 12.0
		// 16.0 0.0 4.0 8.0
		
		Matrix e1 = c2.sub(c1);
		Matrix e2 = c3.sub(c1);
		System.out.println("e1" + '\n' + e1 + '\n');
		// failure
		System.out.println("e2" + '\n' + e2 + '\n');
		// 2.0 4.0 6.0 -2.0
		// 0.0 2.0 -6.0 -4.0
		// -2.0 0.0 2.0 4.0
		
		Matrix f1 = c1.mul(1.5);
		Matrix f2 = c1.mul(c2);
		Matrix f3 = c1.mul(c3);
		System.out.println("f1" + '\n' + f1 + '\n');
		// 1.5 3.0 4.5 6.0
		// 7.5 9.0 10.5 12.0
		// 13.5 0.0 1.5 3.0
		System.out.println("f2" + '\n' + f2 + '\n');
		// 30.0 70.0 20.0
		// 70.0 174.0 68.0
		// 20.0 68.0 86.0
		System.out.println("f3" + '\n' + f3 + '\n');
		// failure
		
		Matrix g = c3.transpose();
		System.out.println("g" + '\n' + g + '\n');
		// 3.0 5.0 7.0
		// 6.0 8.0 0.0
		// 9.0 1.0 3.0
		// 2.0 4.0 6.0
		System.out.println("g(0, 2) = " + g.get(0, 2));
		// 7.0
		System.out.println("g(0, 3) = " + g.get(0, 3));
		// failure
	}
}