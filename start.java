import java.io.IOException;
import controller.maincontroller;
import model.fileDB;
import view.login.loginWindow;

public class start {
	public static void main(String args[]) throws IOException {
		fileDB DB=new fileDB("users");
		new maincontroller(new loginWindow(),DB);
	}
}
