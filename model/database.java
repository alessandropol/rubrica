package model;

import java.io.IOException;
import java.util.AbstractCollection;

public interface database {
	public void insertDB(String _element) throws IOException;
	public void deleteDB(String _element) throws IOException;
	public AbstractCollection<String> readDB(String _element) throws IOException;;

}
