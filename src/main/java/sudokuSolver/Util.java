package sudokuSolver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Util {
	public static String fullyReadfile(String path) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path))))) {
			String puzzle = "";
			String line;

			while ((line = br.readLine()) != null) {
				puzzle += line;
			}

			return puzzle;
		} catch (Exception e) {
			throw e;
		}
	}
}
