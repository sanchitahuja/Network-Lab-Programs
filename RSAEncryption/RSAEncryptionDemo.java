package RSAEncryption;

public class RSAEncryptionDemo {

public static boolean isPrime(int number){
    double sqrt=Math.sqrt(number);
    for (int i = 2; i <sqrt ; i++) {
        if(number%i==0)
            return false;
    }
    return true;
}
    public static boolean isCoPrime(int num1,int num2){
        if(num1>num2){
            for (int i = 2; i <num2+1 ; i++) {
                if((num1%i==0)&&(num2%i==0))
                    return false;
            }
        }
        else if(num1<num2){
            for (int i = 2; i <num1+1 ; i++) {
                if((num1%i==0)&&(num2%i==0))
                    return false;
            }
        }
        else
            return false;
        return true;
    }
    public static int dCalculator(int exponent,int totient){
        int k=0;
        int d;
        while (true){
            if((1+totient*k)%exponent==0){
                d=(1+k*totient)/exponent;
                return d;
            }
        k++;
        }

    }






}
