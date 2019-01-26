package pkg;

public class Run {

	public static void main(String[] args) throws Exception {
		
		String classpath = System.getProperty("java.class.path");
		args =
			new String[] {
				"-i", "src/main/java",
				"--source-classpath", classpath,
				"--compliance", "8",
				"-o", "out",
				"-d", "target/spooned-classes",
				"-p", MyProcessor.class.getName(),
				"--compile" };
		spoon.Launcher.main(args);
	}
}
