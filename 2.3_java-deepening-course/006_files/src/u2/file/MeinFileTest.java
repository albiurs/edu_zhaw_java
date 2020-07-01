package u2.file;

import java.io.File;

public class MeinFileTest {

	public static void main(String[] args) {
		String path = "src";
		File file = new File(path);
		
		String[] dir = file.list();
		
		for (String entry : dir) {
			System.out.println(entry);
		}
		
		System.out.println(file.getAbsolutePath());
		
		File file2 = new File("src/u2/file/MeinFileTest.java");
		if (file2.exists()) {
			System.out.println("length: " + file2.length());
		}
	   
		File file3 = new File("newFolder");
		file3.mkdir();
		file3.delete();
		
		
		

	}

}
