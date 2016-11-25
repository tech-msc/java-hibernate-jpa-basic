package home;

import javax.swing.JOptionPane;

public class GenerateTables {

	public static void main(String[] args) throws Exception {

		HibernateUtil hibernateUtil = new HibernateUtil();

		hibernateUtil.setUp();

		String name = JOptionPane.showInputDialog("Publishing house name: ");
		String email = JOptionPane.showInputDialog("Publishing house email: ");

		hibernateUtil.testBasicInsert(name, email);

		hibernateUtil.testBasicList();

		hibernateUtil.tearDown();

	}
}
