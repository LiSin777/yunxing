public class Complex {
    private int real;
    private int image;

    public int getReal() {
        return real;
    }

    public void setReal(int real) {
        this.real = real;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Complex() {
        this.real = 0;
        this.image = 0;
    }

    public Complex(int real, int image) {
        this.real = real;
        this.image = image;
    }

    public Complex add(Complex other){
        Complex result = new Complex();
        result.real = this.real + other.real;
        result.image = this.image + other.image;
        return result;
    }

    public Complex reduce(Complex other){
        Complex result = new Complex();
        result.real = this.real - other.real;
        result.image = this.image - other.image;
        return result;
    }

    public Complex multiply(Complex other){
        Complex result = new Complex();
        result.real = this.real * other.real;
        result.image = this.image * other.image;
        return result;
    }
}
