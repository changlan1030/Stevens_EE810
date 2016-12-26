import java.util.Scanner;

public class Complex {
	private double real;
	private double imag;
	
	public Complex() {
	}
	
	public Complex(double real, double imag) {
		this.real = real;
		this.imag = imag;
	}
	
	public double getReal() {
		return real;
	}
	 
	public double getImag() {
		return imag;
	}
	
	public void setReal(double real) {
		this.real = real;
	}
	
	public void setImag(double imag) {
		this.imag = imag;
	}
	
	public String toString() {
		String num = "";
		if (real != 0 || imag != 0) {
			if (real != 0) {
				num += real;
				if (imag > 0) {
					num += "+";
				}
			}
			if (imag != 0) {
				num += imag + "i";
			}
		}
		if (real == 0 && imag == 0) {
			num += 0;
		}
		return num;
	}
	
	public Complex add(Complex c) {
		return new Complex(this.real + c.real, this.imag + c.imag);
	}
	
	public Complex sub(Complex c) {
		return new Complex(this.real - c.real, this.imag - c.imag);
	}
	
	public Complex multi(Complex c) {
		return new Complex(this.real * c.real - this.imag * c.imag, this.imag * c.real + this.real * c.imag);
	}
	
	public Complex div(Complex c) {
		return new Complex((this.real * c.real + this.imag * c.imag) / (c.real * c.real + c.imag * c.imag),
				(this.imag * c.real - this.real * c.imag) / (c.real * c.real + c.imag * c.imag));
	}
	
	public boolean ck() {
		if (real == 0 && imag == 0) {
			return false;
		}
		return true;
	}
	
	public Complex conj() {
		return new Complex(real, -imag);
	}
	
	public Complex rec() {
		return new Complex(real / (real * real + imag * imag), -imag / (real * real + imag * imag));
	}
	
	public double abs() {
		return Math.sqrt(real * real + imag * imag);
	}
	
	public Complex sqrt() {
		return new Complex(Math.sqrt((real + abs()) / 2), Math.signum(imag) * Math.sqrt((-real + abs()) / 2));
	}
	
	public double ang() {
		if (real > 0) {
			return Math.atan(imag / real);
		}
		if (real < 0 && imag >= 0) {
			return Math.atan(imag / real) + Math.PI;
		}
		if (real < 0 && imag < 0) {
			return Math.atan(imag / real) - Math.PI;
		}
		if (real == 0 && imag > 0) {
			return Math.PI / 2;
		}
		if (real == 0 && imag < 0) {
			return -Math.PI / 2;
		}
		return Double.POSITIVE_INFINITY;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		Complex c1 = new Complex();
		Complex c2 = new Complex();
		
		System.out.print("Enter complex number 1(real imag): ");
		c1.setReal(input.nextDouble());
		c1.setImag(input.nextDouble());
		
		System.out.print("Enter complex number 2(real imag): ");
		c2.setReal(input.nextDouble());
		c2.setImag(input.nextDouble());
		
		System.out.println("c1:                    " + c1);
		System.out.println("c2:                    " + c2);
		System.out.println("c1 + c2:               " + c1.add(c2));
		System.out.println("c1 - c2:               " + c1.sub(c2));
		System.out.println("c1 * c2:               " + c1.multi(c2));
		if (c2.ck()) {
			System.out.println("c1 / c2:               " + c1.div(c2));
		}
		else {
			System.out.println("c1 / c2:               ERROR, c2 = 0");
		}
		System.out.println("real part of c1:       " + c1.getReal());
		System.out.println("imag part of c1:       " + c1.getImag());
		System.out.println("conjugate of c1:       " + c1.conj());
		
		if (c1.ck()) {
			System.out.println("reciprocal of c1:      " + c1.rec());
		}
		else {
			System.out.println("reciprocal of c1:      ERROR, c1 = 0");
		}
		System.out.println("square root of c1:     +/-(" + c1.sqrt() + ")");
		System.out.println("absolute value of c1:  " + c1.abs());
		if (c1.ang() != Double.POSITIVE_INFINITY) {
			System.out.println("argument of c1:        " + c1.ang());
		}
		else {
			System.out.println("argument of c1:        ERROR, c1 = 0");
		}
	}
}