import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;


public class FileIO {
	private FileReader fileReader;
	private FileWriter fileWriter;
	private InputStreamReader streamReader;
	private OutputStreamWriter streamWriter;
	private BufferedReader bReader;
	private BufferedWriter bWriter; 
	/* Error Message */
	private String errorMsg = "Sorry, Error accured. Message: ";
	
	/**
	 * Constructor
	 */
	public FileIO() {
		fileReader = null;
		fileWriter = null;
		streamReader = null;
		streamWriter = null;
		bReader = null;
	}
	
	/**
	 * Use to read character stream from specific file.
	 * @param path: specify the file path.
	 * @return String line by line in a file. One line per read
	 */
	public String readByChar(String path) {
		try {
			bReader = new BufferedReader(new FileReader(path));
			return bReader.readLine();
		} catch (FileNotFoundException e) {
			printError(e);
			return null;
		} catch (IOException e) {
			printError(e);
			return null;
		} finally {
			// Check whether 'bReader' Object is still alive
			if (bReader != null) {
				try {
					bReader.close(); 
				} catch (IOException e) {
					printError(e);
				}
			} 
		}
	}
	
	/**
	 * Use to read character stream from specific file to any List Collection.
	 * @param path
	 * @return List Collection of string
	 */
	public List<String> readByCharToCollection(String path) {
		List<String> list = new ArrayList<>();
		try {
			bReader = new BufferedReader(new FileReader(path));
			String str = null;
			while ((str = bReader.readLine()) != null) {
				list.add(str);
			}
			return list;
		} catch (FileNotFoundException e) {
			printError(e);
			return null;
		} catch (IOException e) {
			printError(e);
			return null;
		} finally {
			// Check whether 'bReader' Object is still alive
			if (bReader != null) {
				try {
					bReader.close(); 
				} catch (IOException e) {
					printError(e);
				}
			} 
		}
	}
	
	/**
	 * Use to readObject from specific file.
	 * @param path: specify the file path
	 * @return Object
	 */
	public Object readObject(String path) {
		ObjectInputStream obj = null;
		try {
			obj = new ObjectInputStream(new FileInputStream(path));
			return obj.readObject();
		} catch (FileNotFoundException e) {
			printError(e);
			return null;
		} catch (IOException e) {
			printError(e);
			return null;
		} catch (ClassNotFoundException e) {
			printError(e);
			return null;
		} catch (Exception e) {
			printError(e);
			return null;
		} finally {
			if (obj != null) {
				try {
					obj.close();
				} catch (IOException e) {
					printError(e);
				}
			}
		}
	}
	
	public List<Object> readObjectToCollection(String path) {
		ObjectInputStream obj = null;
		try {
			obj = new ObjectInputStream(new FileInputStream(path));
			return obj.readObject();
		} catch (FileNotFoundException e) {
			printError(e);
			return null;
		} catch (IOException e) {
			printError(e);
			return null;
		} catch (ClassNotFoundException e) {
			printError(e);
			return null;
		} catch (Exception e) {
			printError(e);
			return null;
		} finally {
			if (obj != null) {
				try {
					obj.close();
				} catch (IOException e) {
					printError(e);
				}
			}
		}
	}
	
	/**
	 * Use to writer character stream to specific file.
	 * @param path: specify the file path.
	 * @param text: text to write to file.
	 */
	public void writeByChar(String path, String text) { 
			try {
				bWriter = new BufferedWriter(new FileWriter(path));
				bWriter.write(text);
			} catch (IOException e) {
				printError(e);
			} catch(Exception e) {
				printError(e);
			} finally {
				if (bWriter != null) {
					try {
						bWriter.close();
					} catch (IOException e) {
						printError(e);
					}
				}
			}
	}
	
	/**
	 * Use to print Error Message to console.
	 * @param e: Exception Object to get Message from.
	 */
	public void printError(Exception e) {
		System.out.println(errorMsg + e.getMessage());
	}
}
