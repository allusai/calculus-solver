# calculus-solver
This project can use numerical methods to accurately approximate derivatives and integrals at certain points

The Calculus class provides methods which calculate numerical approximations for the derivative and integral at certain points similar to the programs on many graphing calculators. 

There are two constants included in the Calculus class which determine the accuracy of the approximation. The epsilon constant can be decreased to use a point closer to the one the user provides, with no effect on the speed of the algorithm. The step size constant, however, can be decreased to use narrower rectangles for a better integral approximation, but will increase the memory used because we implement the program with an array which will now have more elements and also decrease the speed because, similarly, there are more elements to process. 

Derivative time complexity: O(1)
Integral time complexity: O(n)
