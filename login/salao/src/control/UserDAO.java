package control;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import model.User;

public class UserDAO {

	private BufferedReader br;
	private String path = "C:\\Users\\oryc1\\OneDrive\\Área de Trabalho\\salao\\login\\salao\\dados\\user.csv";
			
	public ArrayList<User> open() {
			ArrayList<User> lines = new ArrayList<>();
			User user;
			try {
				br = new BufferedReader(new FileReader(path));
				String line = br.readLine();
				while(line != null) {
						user = new User(line);
						lines.add(user);
						line = br.readLine();
				}
				br.close();
			} catch (FileNotFoundException e) {
					System.out.println(e);
			} catch (IOException e) {
					System.out.println(e);
			}
			return lines;
	}
}
