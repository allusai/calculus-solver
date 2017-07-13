import java.lang.Math;

public class Calculus 
{
	/*These constants can modified to change the accuracy of approximation
	*A smaller epsilon/step size uses more memory but yields a more
	*accurate approximation of the derivative/integral respectively
	*/
	private final double EPSILON;
	private final double STEP_SIZE;
	
	public Calculus()
	{
		EPSILON = 0.0000001;
		STEP_SIZE = 0.01;
	}
	
	/** The user must implement this function as the equation
	 *  of the graph.
	 *  
	 *  @param double  the x-coordinate
	 *  @return double  the y-coordinate
	 */
	public double function(double x)
	{
		//Example function: y = e^x
		double y = Math.exp(x);
		
		return y;
		
	}
	
	/** Calculates the derivative around a certain point using
	 * a numerical approximation.
	 * @param double  the x-coordinate at which to approximate the derivative
	 * @return double  the derivative at the specified point
	 */
	public double getDerivative(double x)
	{
		//The y-cooridnates of the points close to the specified x-coordiante
		double yOne = function(x-EPSILON);
		double yTwo = function(x+EPSILON);
		
		return calculateSlope(x, yOne, yTwo);
	}
	
	/** Calculates the integral between specified limits of integration
	 * using a numerical approximation.
	 * @param double  starting limit of integration
	 * @param double  ending limit of integration
	 * @return double  the integral between the specified points
	 */
	public double getIntegral(double start, double end)
	{
		/*This method will be implemented using the Left Riemann Approximation Method
		* www.beyondcalculus.com/integrals/ram.html
		*/
		
		//The numPoints will determine how many points are used in the approximation
		int numPoints = (int) ( (end-start) / (STEP_SIZE) );
		
		double[] xCoordinates = new double[numPoints];
		double[] yCoordinates = new double[numPoints];
		
		//Populate the coordinate arrays 
		for(int i = 0; i < numPoints; i++)
		{
			xCoordinates[i] = start + i*STEP_SIZE;
			yCoordinates[i] = function(xCoordinates[i]);
		}
		
		return lram(xCoordinates, yCoordinates);
	
	}

	/** Calculates the slope around a specified point
	 * 
	 * @param double x
	 * @param double yOne
	 * @param double yTwo
	 * @return double  the slope
	 */
	public double calculateSlope(double x, double yOne, double yTwo)
	{
		return (yTwo-yOne)/(2*EPSILON);
	}
	
	/** This implementation uses the Left Riemann Approximation Method
	 * which is explained in the following link
	 * www.beyondcalculus.com/integrals/ram.html
	 * 
	 * @param double[]  xCoordinates passed in as a reference
	 * @param double[]  yCoordinates passed in as a reference
	 * @return double  the approximate value of the integral
	 */
	public double lram(double[] xCoordinates, double[] yCoordinates)
	{
		double integralValue = 0.0;
		
		for(int i = 0; i < xCoordinates.length-1; i++)
		{
			double rectangularArea = (xCoordinates[i+1]-xCoordinates[i])*(yCoordinates[i]);
			integralValue += rectangularArea;
		}
		
		return integralValue;
	}
	
	/** Calculates the percent error between the expected value and
	 * the numerical approximation method for the derivative/integral
	 * 
	 * @param double  theoretical value found using a real calculator
	 * @param double  approximation based on the program's methods
	 * @return double  the percent error between the two values
	 */
	
	public double getPercentError(double theoretical, double approximation)
	{
		return Math.abs(( (theoretical-approximation)/(theoretical) )) * 100;
	}
	
}
