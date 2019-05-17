/*
	Harinder Gakhal
	5/17/19
	CSE 223
	Programming Assignment 3
	This program will using Swing to build a basic calculator
*/

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Variable inits
	private JLabel ansDisplay;
	private double firstNum;	// First operand
	private double secNum;		// Second operand
	private double result = 0;	// result number for final answer
	private char opp;			// Current operator
	private boolean replace = true;	// Replace current field

	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ansDisplay = new JLabel("0");
		ansDisplay.setHorizontalAlignment(SwingConstants.TRAILING);
		ansDisplay.setFont(new Font("Tahoma", Font.BOLD, 21));		// Large font for easy readability
		ansDisplay.setBounds(35, 10, 362, 49);
		contentPane.add(ansDisplay);
		
		// NUMBERS
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addChar("7");
			}
		});
		btn7.setBounds(35, 70, 52, 33);
		contentPane.add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addChar("8");
			}
		});
		btn8.setBounds(97, 70, 52, 33);
		contentPane.add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addChar("9");
			}
		});
		btn9.setBounds(159, 70, 52, 33);
		contentPane.add(btn9);
		
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addChar("4");
			}
		});
		btn4.setBounds(35, 114, 52, 33);
		contentPane.add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addChar("5");
			}
		});
		btn5.setBounds(97, 114, 52, 33);
		contentPane.add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addChar("6");
			}
		});
		btn6.setBounds(159, 114, 52, 33);
		contentPane.add(btn6);
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addChar("1");
			}
		});
		btn1.setBounds(35, 158, 52, 33);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addChar("2");
			}
		});
		btn2.setBounds(97, 158, 52, 33);
		contentPane.add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addChar("3");
			}
		});
		btn3.setBounds(159, 158, 52, 33);
		contentPane.add(btn3);
		
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addChar("0");
			}
		});
		btn0.setBounds(35, 202, 114, 33);
		contentPane.add(btn0);
		
		JButton btnDec = new JButton(".");
		btnDec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Cannot place more than one .
				if(!ansDisplay.getText().contains("."))
					ansDisplay.setText(ansDisplay.getText() + ".");
			}
		});
		btnDec.setBounds(159, 202, 52, 33);
		contentPane.add(btnDec);
		
		// OPERATORS  
		JButton btnAdd = new JButton("+");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstNum = Double.valueOf(ansDisplay.getText());
				replace = true;
				opp = '+';
			}
		});
		btnAdd.setBounds(221, 202, 52, 33);
		contentPane.add(btnAdd);
		
		JButton btnSub = new JButton("-");
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstNum = Double.valueOf(ansDisplay.getText());
				replace = true;
				opp = '-';
			}
		});
		btnSub.setBounds(221, 158, 52, 33);
		contentPane.add(btnSub);
		
		JButton btnMult = new JButton("*");
		btnMult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstNum = Double.valueOf(ansDisplay.getText());
				replace = true;
				opp = '*';
			}
		});
		btnMult.setBounds(221, 114, 52, 33);
		contentPane.add(btnMult);
		
		JButton btnDiv = new JButton("/");
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstNum = Double.valueOf(ansDisplay.getText());
				replace = true;
				opp = '/';
			}
		});
		btnDiv.setBounds(221, 70, 52, 33);
		contentPane.add(btnDiv);
		
		// CLEAR BUTTONS
		JButton btnAc = new JButton("AC");
		btnAc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Clear current field and previous numbers
				ansDisplay.setText("0");
				firstNum = 0;
				secNum = 0;
				replace = true;
			}
		});
		btnAc.setBounds(300, 70, 52, 33);
		contentPane.add(btnAc);
		
		JButton btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Clear current field
				ansDisplay.setText("0");
				replace = true;
			}
		});
		btnC.setBounds(300, 114, 52, 33);
		contentPane.add(btnC);
		
		// EQUALS
		JButton btnEquals = new JButton("=");
		btnEquals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Get second number, and perform operation
				secNum = Double.valueOf(ansDisplay.getText());
				switch(opp)
				{
					case '+':
						result = firstNum + secNum;
						ansDisplay.setText("" + result);
						break;
					case '-':
						result = firstNum - secNum;
						ansDisplay.setText("" + result);
						break;
					case '*':
						result = firstNum * secNum;
						ansDisplay.setText("" + result);
						break;
					case '/':
						result = firstNum / secNum;
						ansDisplay.setText("" + result);
						break;
				}
			}
		});
		btnEquals.setBounds(300, 202, 52, 33);
		contentPane.add(btnEquals);
	
	}
	
	public void addChar(String s)
	{
		// Check to see if it is safe to replace everything on the display
		if(replace)
		{
			ansDisplay.setText(s);
			// Prevents 00007
			if(!ansDisplay.getText().contentEquals("0"))
				replace = false;
		}
		else
			ansDisplay.setText(ansDisplay.getText() + s);
	}
}
