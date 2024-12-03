public class Primes {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i < isPrime.length; i++) {
            isPrime[i] = true;
        }
        for (int i = 0; i < isPrime.length; i++) {
            if (isPrime[i] == true) {
                int newIndex = i;
                while (newIndex + i < isPrime.length) {
                    isPrime[newIndex + i] = false;
                    newIndex = newIndex + i;
                }
            }
        }
        int count = 0;
        System.out.println("Prime numbers up to " + n + ":");
        for (int i = 0; i < isPrime.length; i++) {
            if (isPrime[i]) {
                System.err.println(i);
                count++;
            }
        }
        System.out.println(
                "There are " + count + " primes between 2 and " + n + " (" + (count * 100) / n + "% are primes)");
    }

}
