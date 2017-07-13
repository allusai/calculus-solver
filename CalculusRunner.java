
public class CalculusRunner 
{

	public static void main(String[] args) 
	{
		Calculus test = new Calculus();
		
		/*Example tests are run here and compared with the real values
		* which were calculated on an actual calculator
		*/
		
		
		
		//Calculated value: 14.879732
		//Expected value: 14.8797
		//Percent error: 0.000213%
		double result = test.getDerivative(2.7);
		double actual = 14.8797;
		double percentError = test.getPercentError(actual, result);
		
		System.out.println("The derivative is " + result + " with a percent error of " + percentError);
		
		//Calculated value: 812.405827
		//Expected value: 812.4058
		//Percent error: 0.00000338%
		result = test.getDerivative(6.7);
		actual = 812.4058;
		percentError = test.getPercentError(actual, result);
		
		System.out.println("The derivative is " + result + " with a percent error of " + percentError);		
		
		
		//Calculated value: 116.6766
		//Expected value: 118.7244
		//Percent error: 1.725%
		
		result = test.getIntegral(1.357, 4.809);
		actual = 118.7244;
		percentError = test.getPercentError(actual, result);
		
		System.out.println("The integral is " + result + " with a percent error of " + percentError);
		
		//Calculated value: 281085.432
		//Expected value: 286681.920
		//Percent error: 1.952%

		result = test.getIntegral(3.1415, 12.566);
		actual = 286681.920;
		percentError = test.getPercentError(actual, result);
		
		System.out.println("The integral is " + result + " with a percent error of " + percentError);
		
		
		/* Conclusions:
		 * For the derivative tests, as the x-coordinate used increased,
		 * the approximation got better because the value of epsilon would
		 * not have as much impact on the slope calculation
		 * 
		 * For the integral tests, decreasing the step size dramatically
		 * improved the LRAM approximation. Also, as the distance between
		 * the limits of integration increased, the accuracy increased.
		 * 
		 */
		
	}

}
