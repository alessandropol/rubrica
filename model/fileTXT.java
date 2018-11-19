package model;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;


public class fileTXT {
	
	private String nomeFile;
	
	public fileTXT(String _nomeFile){
		nomeFile=_nomeFile;
	}

	
	public void write(String _element) throws IOException{
		PrintStream printer = new PrintStream(new FileOutputStream(nomeFile, true));
	    printer.append(_element+"\n");
		printer.close();
	}
	
	
	public void delete(String _element) throws IOException {
		File file= new File(nomeFile);
		File temp= new File("temp");
		PrintStream printer = new PrintStream(new FileOutputStream(temp, true));

		if(file.exists())
		{
			Scanner scanner=new Scanner(file);
		    scanner.useDelimiter("\n");

			while(scanner.hasNext()) {
				String sup=scanner.next();
				if(!sup.equals(_element))
					printer.append(sup+"\n");
			}
			scanner.close();
		}
		printer.close();
		file.delete();
		temp.renameTo(file);
	}

	public ArrayList<String> load() throws IOException {
		File file= new File(nomeFile);
		ArrayList<String> array= new ArrayList<String>();
		if(file.exists())
		{
			Scanner scanner=new Scanner(file);
		    scanner.useDelimiter("\n");

			while(scanner.hasNext()) {
				array.add(scanner.next());
			}
			scanner.close();
		}
		return array;
	}

}
