public class CountPrimes {

    private int countPrimes(int n) {
        //Sieve of Eratosthenes
        boolean[] primes = new boolean[n];
        for(int i=2;i<primes.length;i++) {
            primes[i]=true;
        }

        for(int i=2;(i*i)<n; i++){
            for(int j=(i*2);j<n;j=j+i){
                if (primes[j]) {
                    primes[j]=false;
            }
         }
        }

        int count=0;
        for(int i=2;i<n;i++) {
            if (primes[i]) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        CountPrimes c = new CountPrimes();
        int n = 10;
        System.out.println(c.countPrimes(n));
    }
}
