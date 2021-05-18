package edu.neu.coe.info6205.functions;

/**
 * This class determines the derivative of a polynomial.
 * See https://www.geeksforgeeks.org/program-derivative-polynomial/
 */
public class PolynomialDerivative {

    public PolynomialDerivative(final String equation) {
        this.equation = equation;
    }
    
    static Double derivativeTerm(String pTerm, Double val)
    {
   
      // Get coefficient
      String coeffStr = "";
      int i;
      for (i = 0; pTerm.charAt(i) != 'x' ; i++)
      {
        if(pTerm.charAt(i)==' ')
          continue;
        coeffStr += (pTerm.charAt(i));
      }
   
      long coeff = Long.parseLong(coeffStr);
   
      // Get Power (Skip 2 characters for x and ^)
      String powStr = ""; 
      for (i = i + 2; i != pTerm.length() && pTerm.charAt(i) != ' '; i++)
      {
        powStr += pTerm.charAt(i);
      }
   
      long power=Long.parseLong(powStr);
   
      // For ax^n, we return a(n-1)x^(n-1)
      return (double) (coeff * power * (long)Math.pow(val, power - 1));
    }
    
    public Double solve(final double x0) {
        Double ans = 0.0;
        
        int i = 0;
        String[] stSplit = equation.split("\\+");
        while(i<stSplit.length)
        {
          ans = (ans +derivativeTerm(stSplit[i], x0));
          i++;
        }
        return ans;
    }

    public static void main(String[] args) {

        PolynomialDerivative pd = new PolynomialDerivative("4x^3 + 3x^1 + 2x^2");

        Double result = pd.solve(2.0);
        System.out.println("The derivative of " + pd.equation + " for a value of X=" + 2.0 + " is " + result);
    }

    private final String equation;
}
