package xxx.temp;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//mathClient//
import java.rmi.Naming;

public class MathClient extends Frame implements ActionListener {
	Button B1 = new Button("Sum");
	Button B2 = new Button("Subtract");
	Button B3 = new Button("Multiply");
	Button B4 = new Button("Divide");
	Label l1 = new Label("Number 1");
	Label l2 = new Label("Number 2");
	Label l3 = new Label("Result");
	TextField t1 = new TextField(20);
	TextField t2 = new TextField(20);
	TextField t3 = new TextField(20);

	public MathClient() {
		super("Calculator");
		setLayout(null);
		l1.setBounds(20, 50, 55, 25);
		add(l1);
		l2.setBounds(20, 100, 55, 25);
		add(l2);
		l3.setBounds(20, 150, 55, 25);
		add(l3);
		t1.setBounds(150, 50, 100, 25);
		add(t1);
		t2.setBounds(150, 100, 100, 25);
		add(t2);
		t3.setBounds(150, 150, 100, 25);
		add(t3);
		B1.setBounds(20, 200, 80, 25);
		add(B1);
		B2.setBounds(100, 200, 80, 25);
		add(B2);
		B3.setBounds(180, 200, 80, 25);
		add(B3);
		B4.setBounds(260, 200, 80, 25);
		add(B4);
		B1.addActionListener(this);
		B2.addActionListener(this);
		B3.addActionListener(this);
		B4.addActionListener(this);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public void actionPerformed(ActionEvent AE) {
		if (AE.getSource() == B1) {
			sum();
		} else if (AE.getSource() == B2) {
			subt();
		} else if (AE.getSource() == B3) {
			mult();
		} else if (AE.getSource() == B4) {
			div();
		}
	}

	public void sum() {
		int i = Integer.parseInt(t1.getText());
		int j = Integer.parseInt(t2.getText());
		int val;
		try {
			String ServerURL = "MathServ";
			MathInterface MI = (MathInterface) Naming.lookup(ServerURL);
			val = MI.add(i, j);
			t3.setText("" + val);
		} catch (Exception ex) {
			System.out.println("Exception:" + ex);
		}
	}

	public void subt() {
		int i = Integer.parseInt(t1.getText());
		int j = Integer.parseInt(t2.getText());
		int val;
		try {
			String ServerURL = "MathServ";
			MathInterface MI = (MathInterface) Naming.lookup(ServerURL);
			val = MI.subt(i, j);
			t3.setText("" + val);
		} catch (Exception ex) {
			System.out.println("Exception:" + ex);
		}
	}

	public void mult() {
		int i = Integer.parseInt(t1.getText());
		int j = Integer.parseInt(t2.getText());
		int val;
		try {
			String ServerURL = "MathServ";
			MathInterface MI = (MathInterface) Naming.lookup(ServerURL);
			val = MI.mult(i, j);
			t3.setText("" + val);
		} catch (Exception ex) {
			System.out.println("Exception:" + ex);
		}
	}

	public void div() {
		int i = Integer.parseInt(t1.getText());
		int j = Integer.parseInt(t2.getText());
		int val;
		try {
			String ServerURL = "MathServ";
			MathInterface MI = (MathInterface) Naming.lookup(ServerURL);
			val = MI.div(i, j);
			t3.setText("" + val);
		} catch (Exception ex) {
			System.out.println("Exception:" + ex);
		}
	}

	public static void main(String args[]) {
		MathClient MC = new MathClient();
		MC.setVisible(true);
		MC.setSize(600, 500);
	};
}