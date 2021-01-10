package fbleague;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class dbInit {
	void init() throws IOException
	{
		
		System.out.println("\nDatabase Initialization has been started, please stand by...");
		Path currentWorkingDir = Paths.get("").toAbsolutePath();
		Path Users = Paths.get(currentWorkingDir.normalize().toString() + "//database//users//");
		Path Players = Paths.get(currentWorkingDir.normalize().toString() + "//database//players//");
		Path Squads = Paths.get(currentWorkingDir.normalize().toString() + "//database//squads//");
		Path Matches = Paths.get(currentWorkingDir.normalize().toString() + "//database//matches//");
		Path Leagues = Paths.get(currentWorkingDir.normalize().toString() + "//database//leagues//");
		System.out.println("\nInitializing Users Database...");
		Files.createDirectories(Users);
		System.out.println("\nInitializing Players Database...");
		Files.createDirectories(Players);
		System.out.println("\nInitializing Squads Database...");
		Files.createDirectories(Squads);
		System.out.println("\nInitializing Matches Database...");
		Files.createDirectories(Matches);
		System.out.println("\nInitializing Leagues Database...");
		Files.createDirectories(Leagues);
		
		System.out.print("\nDatabase Initialization Complete. You may now freely use the software. \n");
	}

}
