import java.awt.geom.Rectangle2D;

/**
 * This class is a subclass of FractalGenerator.  It is used to compute the
 * Tricorn fractal.
 */
public class Tricorn extends FractalGenerator {
    /**
     * A constant for the number of maximum iterations.
     */
    public static final int MAX_ITERATIONS = 2000;

    /**
     * This method allows the fractal generator to specify which part
     * of the complex plane is the most interesting for a fractal.
     * It is passed a rectangle object and the method modifies the
     * rectangle's fields to show the correct initial range for the fractal.
     * This implementation sets the initial range to x=-2, y=-2, width=height=4.
     */
    public void getInitialRange(Rectangle2D.Double range) {
        range.x = -2;
        range.y = -2;
        range.width = 4;
        range.height = 4;
    }

    /**
     * This method implements the iterative function for the Tricorn fractal.
     * It takes two doubles for the real and imaginary parts of the complex
     * plane and returns the number of iterations for the corresponding
     * coordinate.
     */
    public int numIterations(double x, double y) {
        // Start with iterations at 0.
        int iteration = 0;
        // Initialize zreal and zimaginary.
        double zReal = 0;
        double zImaginary = 0;

        /**
         * Compute Zn = [complex conjugate(Zn-1)]^2 + c where values are
         * complex numbers represented by zReal and zImaginary, Z0=0, and
         * c is the particular point in the fractal that we are displaying
         * (given by x and y).  It is iterated until Z^2 > 4 (absolute value
         * of Z is greater than 2) or maximum number of iterations is reached.
         */
        while (iteration < MAX_ITERATIONS &&
                zReal * zReal + zImaginary * zImaginary < 4) {
            double zRealUpdated = zReal * zReal - zImaginary * zImaginary + x;
            double zImaginaryUpdated = -2 * zReal * zImaginary + y;
            zReal = zRealUpdated;
            zImaginary = zImaginaryUpdated;
            iteration += 1;
        }

        /**
         * If the number of maximum iterations is reached, return -1 to
         * indicate the point didn't escape outside of the boundary.
         */
        if (iteration == MAX_ITERATIONS) {
            return -1;
        }

        return iteration;
    }

    public String toString() {
        return "Tricorn.";
    }
}
