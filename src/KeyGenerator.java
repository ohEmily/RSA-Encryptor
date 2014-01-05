public class KeyGenerator {
	public int publicKeyE; // 'e' in Pasik's slides
	public int publicKeyN; // 'N' in Pasik's slides
	private int privateKey;
	private static final int LOWER_BOUND_PRIME_NUMBER = 64;
	private static final int UPPER_BOUND_PRIME_NUMBER = 128;
	
	/** Finds as small a number as possible that is relatively prime
	 * to the value passed
	 * @param number to which the return value should be relatively prime
	 * @return a relatively prime number
	 * */
	private static int relativelyPrimeCalculator(int number)
	{
		for (int i = 2; i < number; i++)
			if ((number % i) != 0 && prime(i))
				return i;
		return 0;
	}
	
	
	/** Create a new prime number between LOWER_BOUND_PRIME_NUMBER and 
	 * UPPER_BOUND_PRIME_NUMBER.
	 * @return a prime number in the designated range 
	 * */
	public static int getRandomPrime()
	{
		int primeNumber = 0;
		// keep getting a new number between the lower and upper bounds until
		// it is a prime number
		while (!prime(primeNumber)) 
		{
			primeNumber = LOWER_BOUND_PRIME_NUMBER + (int) (Math.random() 
					* (UPPER_BOUND_PRIME_NUMBER - LOWER_BOUND_PRIME_NUMBER));
		}
		return primeNumber;
	}
	
	/**
	 * Checks for primality.
	 * @author: http://www.mkyong.com/java/how-to-determine-a-prime-number-in-java/
	 * @param number
	 * @return
	 */
	public static boolean prime(int number) {
	    //check if n is a multiple of 2
	    if (number % 2 == 0) return false;
	    //if not, then just check the odds
	    for(int i = 3; i * i<=number;i += 2)
	    {
	        if(number % i == 0)
	            return false;
	    }
	    return true;
	}

	/** Set all the randomized values for the public and private keys. */
	public void setKeys()
	{
		int largePrimeA = getRandomPrime();
		int largePrimeB = getRandomPrime();
		publicKeyN = (largePrimeA * largePrimeB);
		int modulus = (largePrimeA - 1) * (largePrimeB - 1);
		publicKeyE = relativelyPrimeCalculator(modulus);
		// calculating the privateKey
		for (privateKey = 0; (publicKeyE * privateKey) % modulus != 1; 
				privateKey++);
//		System.out.println("Public key n: " + publicKeyN); // testing
//		System.out.println("A: " + largePrimeA + " | B: " + largePrimeB); // testing
//		System.out.println("Public key e: " + publicKeyE); // testing
	}

	
	/** Create a string with the two public keys.
	 * @return string with both keys separated by new line character 
	 * */
	public String outputPublicKeys()
	{
		return publicKeyE + " " + publicKeyN;
	}
	
	/**
	 * Create a string with a private key.
	 * @return string with the private key
	 */
	public String outputPrivateKey()
	{
		return privateKey + " " + publicKeyN;
	}
}
