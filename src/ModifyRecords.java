import java.io.*;
import java.util.ArrayList;
import javax.swing.JFileChooser;

class ModifyRecords {
	String textfile;
	FileWriter fw;
	FileReader fr;
	PrintWriter writer;
	BufferedReader reader;
	
	public ModifyRecords(String name) {
		this.textfile = name;
		try {
			this.fw = new FileWriter(textfile);
			this.fr = new FileReader(textfile);
			this.writer = new PrintWriter(fw);
			this.reader = new BufferedReader(fr);
		} catch (IOException e) {
			System.out.println("Error: File " + name + " not found.");
		}
	}
	public ArrayList<String> readFromFile() {
		ArrayList<String> lines = new ArrayList<String>();
		String str;
		try {
			while ((str = reader.readLine()) != null) {
				lines.add(str);
			}
		} catch (IOException e) {
			try {
				System.out.println("File closed");
				reader.close();
			} catch (IOException ex) {
				System.out.println("Cannot close file");
			}
			return null;
		}
		return lines;
	}
	public void writeToFile(ArrayList<String> linelist) {
		ArrayList<String> newLines = this.modList(linelist);
		this.clearFile(fw);
		for (int i = 0; i < newLines.size(); i++) {
			writer.println(newLines.get(i));
		}
	}
	public ArrayList<String> modList(ArrayList<String> linelist) {
		ArrayList<String> newList = new ArrayList<String>();
		for (int i = 0; i < linelist.size(); i++) {
			String str = linelist.get(i);
			for (int j = 1; j <= 9999; j++) {
				String newStr = str + j;
				newList.add(newStr);
			}
		}
		return newList;
	}
	
	public void clearFile(FileWriter file) {
		PrintWriter printer = new PrintWriter(file);
		printer.flush();
	}
	public static void main (String args[]) {
		//String filename = JOptionPane.showInputDialog("Enter filepath to .csv or .txt: ");
			// would need to import javax.swing.JOptionPane
		
		int upperBound = 9999; // number of times each record is to be repeated
		try {
			// Obtain file path.
			String filename = "";
			JFileChooser fc = new JFileChooser();
			int response = fc.showOpenDialog(null);
			if (response == JFileChooser.APPROVE_OPTION) {
				filename = fc.getSelectedFile().toString();
			} else {
				System.out.println("File operation cancelled.");
				return;
			}
			
			System.out.println("Please wait while records are updated (this may take awhile).");
			
			// Read contents of file.
			FileReader fr = new FileReader(filename);;
			BufferedReader reader = new BufferedReader(fr);
			ArrayList<String> linelist = new ArrayList<String>();
			String str;
			while ((str = reader.readLine()) != null) {
				linelist.add(str);
			}
			reader.close();
			fr.close();
			
			// Clear contents of file and re-populate with repeated records.
			FileWriter fw = new FileWriter(filename);
			PrintWriter writer = new PrintWriter(filename);
			writer.flush();
			for (int i = 0; i < linelist.size(); i++) {
				String name = linelist.get(i);
				for (int j = 1; j <= upperBound; j++) {
					String line = name + j;
					writer.println(line);
				}
			}
			writer.close();
			fw.close();
			System.out.println("Records modified successfully!");
		} catch (IOException e) {
			System.out.println("Filepath is invalid.");
		}
	}
}









