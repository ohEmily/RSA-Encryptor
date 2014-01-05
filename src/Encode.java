import io.IO;

public class Encode
{
	public static void main(String[] args)
	{
		String keys = IO.readFile(args[0]);
		String message = IO.readLine();
		String contents = RSAMachine.encryptDecrypt(message, keys);
		System.out.print(contents);
	}
}