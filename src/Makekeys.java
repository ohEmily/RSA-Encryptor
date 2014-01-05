import io.IO; 

/**
 * Creates text files, public and private, based on the argument passed.
 * @author Emily Pakulski
 */

public class Makekeys
{
	public static void main(String[] args)
	{
		String fileName = args[0];
		String inputFile = fileName + ".public";
		String outputFile = fileName + ".private";
		KeyGenerator generator = new KeyGenerator();
		generator.setKeys();
		
		IO.writeFile(inputFile, generator.outputPublicKeys());
		IO.writeFile(outputFile, generator.outputPrivateKey());
	}
}