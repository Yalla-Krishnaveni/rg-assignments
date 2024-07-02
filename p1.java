//Impure Function
public class TaxUtil {
   double rate = 0.15;

   public double calculateTax(double amount) {
       return amount * rate;
   }
}
//Pure Function
public class TaxUtil {
   public double calculateTax(double amount, double rate) {
       return amount * rate;
   }
}

