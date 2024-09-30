/**
 * @author Thomas Riotto
 * <h1>Sviluppo posizionale</h1>
 * This script performs the positional process of a given number with his base
 * **/
public class Main
{
    /**
     * @param number The number in input
     * @param base the base of the number
     * @return returns a boolean that show us if the number is valid for the base**/
    public static boolean checkInput(int number, int base)
    {
        // Check if the number contains invalid numbers.
        String checksum = String.valueOf(number);
        for (int i = 0; i < checksum.length(); i++)
        {
            if ((Integer.parseInt(String.valueOf(checksum.charAt(i))) >= base))
            {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        if (args.length < 2)
        {
            System.err.println("You must insert two number, the number and the base of it.\n");
            return;
        }
        try
        {
            int number = Math.abs(Integer.parseInt(args[0]));
            int base = Math.abs(Integer.parseInt(args[1]));

            if (!Main.checkInput(number, base))
            {
                System.err.println("The digits of the number can not be greater or equal than the base of it.\n");
                return;
            }

            StringBuilder result = new StringBuilder();
            int value = 0;

            int i = 0;
            while (number > 0)
            {
                int tmp = number % 10;
                number /= 10;
                result.append(tmp).reverse();
                value += (int) (tmp * Math.pow(base, i));
                i++;
            }
            String output = result.append(" in base ").append(base).append(" is").append(" = ").append(value).append(" in base 10").toString().trim();
            System.out.println(output);
        }
        catch (NumberFormatException e)
        {
            System.err.println("Invalid input.");
        }
    }
}