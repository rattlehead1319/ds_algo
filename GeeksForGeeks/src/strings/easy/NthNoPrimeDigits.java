package strings.easy;

public class NthNoPrimeDigits {
    public static int primeDigits(int n){
        int rem;
        String num="";
        int number = n;
        while (number>0) {
            // remainder for check element position
            rem = number % 4;
            switch (rem) {

                // if number is 1st position in tree
                case 1:
                    num+='2';
                    break;

                // if number is 2nd position in tree
                case 2:
                    num+='3';
                    break;

                // if number is 3rd position in tree
                case 3:
                    num+='5';
                    break;

                // if number is 4th position in tree
                case 0:
                    num+='7';
                    break;
            }

            if (number % 4 == 0)
                number--;

            number = number / 4;
        }

        return Integer.parseInt(new StringBuilder(num).reverse().toString());
    }
}
