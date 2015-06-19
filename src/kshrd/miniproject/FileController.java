package kshrd.miniproject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;

public class FileController {
	
	private Path defaultPath; 
	private Path logPath;
	private String folderName = "Article Data";
	
	public FileController() {
		defaultPath = Paths.get(System.getProperty("user.home") + File.separator + folderName);
		if (!Files.exists(defaultPath)) {
			try {
				Files.createDirectory(defaultPath);
				System.out.println("Success");
			} catch (IOException e) {
				System.err.println("We're sorry, Error occured." + e);
			}
		}
		createLogFile("article.log", "success initialized.");
	}
	
	public void createLogFile(String logFileName, String text) {
		logPath = Paths.get(defaultPath.toString() + File.separator + logFileName);
		FileWriter fw = null;
		if ( Files.notExists(logPath) ) {
			try {
				Files.createFile(logPath);
				fw = new FileWriter(logPath.toString(), true);
				fw.write(Calendar.getInstance().toString() + ": " + text);
			} catch (IOException e) {
				System.err.println("We're sorry, Error occured." + e);
			} catch (Exception e) {
				System.err.println("We're sorry, Error occured." + e);
			} finally {
				if (fw != null) {
					try {
						fw.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new FileController();
	}
}
