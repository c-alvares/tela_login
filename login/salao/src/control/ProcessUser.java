package control;

import java.util.ArrayList;

import model.User;

public class ProcessUser {

	public static ArrayList<User> users = new ArrayList<>();
	public static UserDAO ud = new UserDAO();

	public static void load() {
		users = ud.open();
	}

	public static int emailCheck(String email) {
			int back = -1;
			for (int i = 0; i < users.size(); i++) {
					if (users.get(i).getEmail().equals(email)) {
							return i;
					}
			}
			return back;
	}
	public static boolean passwordCheck(int index, String password) {
			if (users.get(index).getPassword().equals(password)) {
					return true;
			}
			return false;
	}
}
