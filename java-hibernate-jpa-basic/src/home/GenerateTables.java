package home;

import javax.swing.JOptionPane;

public class GenerateTables {

	public static void main(String[] args) throws Exception {

		HibernateUtil hb = new HibernateUtil();

		hb.setUp();

		String name = JOptionPane.showInputDialog("Name: ");
		String email = JOptionPane.showInputDialog("Email: ");

		hb.testBasicInsert(name, email);

		hb.testBasicList();

		hb.tearDown();

	}
}
