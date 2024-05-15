package tiktactoe;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;


@SuppressWarnings("serial")
abstract public class TFrame extends JFrame implements ActionListener
{
	//JFrame win = new JFrame();
	JPanel titlepan = new JPanel();
	JPanel btnpan = new JPanel();
	JPanel scrpan=new JPanel();
	JButton[] btn = new JButton[9];
	JLabel title = new JLabel();
	JLabel csl,hsl,rl,cs,hs,r;
	JLabel slbl[]=new JLabel[3];
	String shead[]= {"Computer Score","Round","Your Score"};
	JButton b;
	String magic = "834159672";
	TFrame()
	{
		ImageIcon icon = new ImageIcon("C://Users//Admin//Downloads//tic-tac-toe.png");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		getContentPane().setBackground(new Color(25, 25, 100));
		setTitle("TikTakToe");
		setIconImage(icon.getImage());
		setSize(500, 600);

		title.setFont(new Font("Viner Hand ITC", Font.BOLD, 30));
		title.setForeground(Color.decode("#ff9a15"));
		title.setText("Tik Tac Toe");

		titlepan.setLayout(new BorderLayout());
		titlepan.setBounds(0, 0, 500, 100);
		title.setHorizontalAlignment(JLabel.CENTER);
		titlepan.add(title, JLabel.CENTER);
		add(titlepan);

		btnpan.setLayout(new GridLayout(3, 3));
		btnpan.setBackground(Color.DARK_GRAY);
		btnpan.setBounds(0, 200, 500, 370);

		for (int i = 0; i < 9; i++)
		{
			btn[i] = new JButton();
			btn[i].addActionListener(this);
			btn[i].setFocusable(false);
			btn[i].setBackground(new Color(250, 250, 250));
			btn[i].setFont(new Font("Segoe Script", Font.BOLD, 30));
			btnpan.add(btn[i]);
			btn[i].setActionCommand(magic.substring(i, i + 1));
			// System.out.println(magic.substring(i, i));
		}

		add(btnpan);
		scrpan.setLayout(new GridLayout(2,3));
		for(int i=0;i<3;i++)
		{
			slbl[i]=new JLabel(shead[i]);
			slbl[i].setHorizontalAlignment(JLabel.CENTER);
			slbl[i].setFont(new Font("Segoe Print", Font.BOLD, 15));
			scrpan.add(slbl[i]);
		}
		cs=new JLabel("0");
		hs=new JLabel("0");
		r=new JLabel("1");
		cs.setHorizontalAlignment(JLabel.CENTER);
		cs.setForeground(Color.BLUE);
		hs.setForeground(Color.RED);
		r.setForeground(Color.decode("#009f10"));
		cs.setFont(new Font("Segoe Print", Font.BOLD, 20));
		hs.setFont(new Font("Segoe Print", Font.BOLD, 20));
		hs.setHorizontalAlignment(JLabel.CENTER);
		r.setHorizontalAlignment(JLabel.CENTER);
		r.setFont(new Font("Segoe Print", Font.BOLD, 25));
		scrpan.add(cs);
		scrpan.add(r);
		scrpan.add(hs);
		scrpan.setBounds(0,100,500,100);
		add(scrpan);
		setVisible(true);
	}
}
