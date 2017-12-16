package RSAEncryption;

import java.util.Scanner;

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
    public static double encryptor(int message,int publickeyexponent,int publickeymodulus){
        return Math.pow(message,publickeyexponent)%publickeymodulus;
    }

    public static double decryptor(int message,int privateexponent,int privatemodulus){
        return Math.pow(message,privateexponent)%privatemodulus;
    }
    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter a prime number P");
        int p=scanner.nextInt();
        if(!isPrime(p)){
            while (true){
                System.out.println("Not Prime\nEnter a prime number P");
                p=scanner.nextInt();
                if(isPrime(p))
                    break;
            }
        }
        System.out.println("Enter a prime number Q");
        int q=scanner.nextInt();
        if(!isPrime(q)){
            while (true){
                System.out.println("Not Prime\nEnter a prime number Q");
                q=scanner.nextInt();
                if(isPrime(q))
                    break;
            }
        }
        int modulus=p*q;
        int totient=(p-1)*(q-1);
        System.out.println("Enter Public Key Exponent");
        int publicKeyExponent=scanner.nextInt();
        while (!isCoPrime(publicKeyExponent,totient)){
            System.out.println("Totient and Public key arent coprime");
            System.out.println("Enter Public Key Exponent");
            publicKeyExponent=scanner.nextInt();
            if(isCoPrime(publicKeyExponent,totient))
                break;
        }
        System.out.println("totient "+totient);
        int privateKeyExponent=dCalculator(publicKeyExponent,totient);
        System.out.println("Public Key Modulus "+modulus+" Exponent "+publicKeyExponent);
        System.out.println("Private Key Modulus "+modulus+" Exponent "+privateKeyExponent);
        System.out.println("Enter Message");
        int message=scanner.nextInt();
        System.out.println("Encrypted Message "+encryptor(message,publicKeyExponent,modulus));
        System.out.println("Decrypted Message "+decryptor(message,privateKeyExponent,modulus));
    }


}
