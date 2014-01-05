/**
 * Static methods that allow encrypting or decrypting using the RSA method. 
 * @author Emily Pakulski
 */

public class RSAMachine
{
	/** Encrypts a String of ints and sets the private and public keys
	 * accordingly to allow for decryption.
	 * @return the encrypted message */
	public static String encryptDecrypt(String message, String keysString)
	{
		// prepare the message to be iterable
		int[] messageNumbers = parseStringToIntArray(message);	
		// prepare the keys
		int[] keys = parseStringToIntArray(keysString);
		int exponent = keys[0];
		int modulus = keys[1];
		// encrypt each int using the correct keys
		String encryptedMessage = "";
		for (int each : messageNumbers)
			encryptedMessage += encryptDecryptNumber(each, exponent, modulus) + " ";
		encryptedMessage = encryptedMessage.trim();
		return encryptedMessage;
	}
	
	/** Encrypts or decrypts each individual number in the message. */
	private static int encryptDecryptNumber(int number, int exponent, int modulus)
	{
		int returnVal = 1;
		
		// increases efficiency of the operation "number^e (mod n)"
		while (exponent > 0)
		{
			if (exponent % 2 == 0) // if exponent is even
			{
				number = (number * number) % modulus;
				exponent = exponent / 2;
			}
			else
			{
				returnVal = (returnVal * number) % modulus;
				exponent--;
			}
		}
		return returnVal;
	}		
	
	/** Helper method that makes parsing the components of a */
	private static int[] parseStringToIntArray(String message)
	{
		String[] messageStrings = message.split(" ");
		int[] stringContents = new int[messageStrings.length];
		for (int i = 0; i < messageStrings.length; i++)
			stringContents[i] = Integer.parseInt(messageStrings[i].trim());		
		return stringContents;
	}
}
