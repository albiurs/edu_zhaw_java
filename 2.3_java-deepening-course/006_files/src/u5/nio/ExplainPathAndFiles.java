package u5.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

public class ExplainPathAndFiles {

	public static void main(String[] args) throws IOException {

		// Vor Java 7
		File file = new File("src/u5/nio/einFile");
		file.isDirectory();
		file.isFile();

		// Java 7
		Path path = Paths.get("src/u5/nio/personen23.txt");
		boolean deleteIfExists = Files.deleteIfExists(path);
		System.out.println("Delete File If Exists: " + deleteIfExists);
		System.out.println("getFileName: " + path.getFileName());
		System.out.println("toAbsolutePath: " + path.toAbsolutePath());
		System.out.println("getName: " + path.getName(1));
		System.out.println("getParent: " + path.getParent());
		System.out.println("subpath: " + path.subpath(0, 2));

		// Java6-File nach Java7-Path transformieren:
		Path tPath = new File("src/u5/nio/fileName").toPath();
		System.out.println("toAbsolutePath: " + tPath.toAbsolutePath());

		// Files (Java 7)
		System.out.println("isRegularFile: " + Files.isRegularFile(path));
		System.out.println("exists: " + Files.exists(path));
		// File erstellen
		System.out.println("createFile: " + Files.createFile(path));
		System.out.println("isRegularFile: " + Files.isRegularFile(path));
		System.out.println("exists: " + Files.exists(path));
		System.out.println("isReadable: " + Files.isReadable(path));

		// Ordner erstellen
		Path ordner = Paths.get("src/u5/nio/new_folder");
		Files.createDirectories(ordner);
		path = Paths.get("src/u5/nio/personen.txt");
		Files.copy(path, Paths.get("src/u5/nio/new_folder/personen.txt"));

		// zuerst inhalt des ordners loeschen, wenn der Ordner existiert.
		if (Files.isDirectory(ordner)) {
			try (DirectoryStream<Path> stream = Files.newDirectoryStream(ordner)) {
				for (Path p : stream) {
					System.out.println("Delete file: " + p.getFileName());
					Files.delete(p);
				}
			}
		}
		// falls noch ein Ordner vorhanden ist --> loeschen
		Files.deleteIfExists(ordner);

		Files.createDirectory(ordner);
		try {
			System.out.println("Ordner Berechtigungen: "
					+ Files.getPosixFilePermissions(ordner));
		} catch (UnsupportedOperationException e) {
			System.out.println("Windows not Posix compatible");
		}

		// Zuerst alte Dateien bereinigen
		Files.deleteIfExists(Paths.get("src/u5/nio/personen2.txt"));
		Files.deleteIfExists(Paths.get("src/u5/nio/personen3.txt"));
		Files.deleteIfExists(Paths.get("src/u5/nio/personen4.txt"));

		// Datei kopieren und verschieben
		Files.copy(path, Paths.get("src/u5/nio/personen2.txt"));
		Files.copy(path, Paths.get("src/u5/nio/personen3.txt"));
		Path path3 = Paths.get("src/u5/nio/personen3.txt");
		Files.move(path3, Paths.get("src/u5/nio/personen4.txt"));

		// Path auf neuen folder
		Path dir = Paths.get("src/u5/nio/new_folder");

		try {
			// Dateiattribute setzen (Berechtigungen)
			Set<PosixFilePermission> perms = PosixFilePermissions.fromString("r--r--r--");
			FileAttribute<Set<PosixFilePermission>> attr = PosixFilePermissions
					.asFileAttribute(perms);
			Path path2 = Paths.get("src/u5/nio/personen3.txt");
			// existierende ordner loeschen
			Files.deleteIfExists(path2);
			Files.createFile(path2, attr);
			// existierende Ordner loeschen
			Files.deleteIfExists(dir);
			Files.createDirectory(dir, attr);
			Files.setPosixFilePermissions(dir,
					PosixFilePermissions.fromString("rw-r--r--"));
			System.out.println("testOrdern Berechtigungen: "
					+ Files.getPosixFilePermissions(dir));
		} catch (UnsupportedOperationException e) {
			System.out.println("Windows not Posix compatible");
		}


		// File Attribute auslesen
		BasicFileAttributes attributes = Files.readAttributes(dir,
				BasicFileAttributes.class);
		System.out.println("creationTime: " + attributes.creationTime());
		System.out.println("lastAccessTime: " + attributes.lastAccessTime());
		System.out.println("lastModifiedTime: " + attributes.lastModifiedTime());

		System.out.println("isDirectory: " + attributes.isDirectory());
		System.out.println("isOther: " + attributes.isOther());
		System.out.println("isRegularFile: " + attributes.isRegularFile());
		System.out.println("isSymbolicLink: " + attributes.isSymbolicLink());

		Path testFolder = Paths.get("src/u5/nio/new_folder");
		Files.copy(path, Paths.get("src/u5/nio/new_folder/personen2.txt"));
		Path testFolderFolder = Paths.get("src/u5/nio/new_folder/new_folder");
		Files.createDirectories(testFolderFolder);
		Files.copy(path, Paths.get("src/u5/nio/new_folder/new_folder/personen2.txt"));

		if (Files.isDirectory(testFolder)) {

			Files.walkFileTree(testFolder, new SimpleFileVisitor<Path>() {
				@Override
				public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
						throws IOException {
					System.out.println("Delete File: " + file);
					Files.delete(file);
					return FileVisitResult.CONTINUE;
				}

				@Override
				public FileVisitResult postVisitDirectory(Path dir, IOException e)
						throws IOException {
					if (e == null) {
						System.out.println("Delete Directory: " + dir);
						Files.delete(dir);
						return FileVisitResult.CONTINUE;
					} else {
						// directory iteration failed
						throw e;
					}
				}
			});

		}
		// alte Dateien bereinigen
		Files.deleteIfExists(Paths.get("src/u5/nio/personen2.txt"));
		Files.deleteIfExists(Paths.get("src/u5/nio/personen3.txt"));
		Files.deleteIfExists(Paths.get("src/u5/nio/personen4.txt"));
		Files.deleteIfExists(Paths.get("src/u5/nio/personen23.txt"));
	}		


}



