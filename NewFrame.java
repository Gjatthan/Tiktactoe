package tiktactoe;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

//public abstract class first extends JFrame implements ActionListener{
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	JPanel panel= new JPanel();
//	JLabel tlbl=new JLabel();
//	JButton sp=new JButton();
//	JButton tp=new JButton();
//	
//}

 public abstract class NewFrame extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//JFrame win = new JFrame();
	JPanel panel=new JPanel(new BorderLayout());
	JLabel imgg = new JLabel();
	JPanel titlepan = new JPanel();
	//JPanel btnpan = new JPanel();
	JPanel scrpan=new JPanel();
	JButton[] btn = new JButton[9];
	JLabel title = new JLabel();
	JLabel csl,hsl,rl,cs,hs,r;
	JLabel slbl[]=new JLabel[3];
	JLabel cross1=new JLabel();
	JLabel cross2=new JLabel();
	JLabel cross3=new JLabel();
	JLabel cross4=new JLabel();
	String shead[]= {"Computer Score","Round","Your Score"};
	JButton b;
	ImageIcon bg=new ImageIcon("back.png");
	JButton back=new JButton(bg);
	String magic = "834159672";
	NewFrame()
	{
		ImageIcon icon = new ImageIcon("C://Users//Admin//Downloads//tic-tac-toe.png");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		getContentPane().setBackground(Color.decode("#000000"));
		//getContentPane().setBackground(Color.CYAN);
		setTitle("TikTakToe");
		setIconImage(icon.getImage());
		setSize(800,700);
        
		back.setBounds(10, 10, 100, 50);
		back.addActionListener(this);
//		ImageIcon bg=new ImageIcon("back.png");
//		back.setIcon(bg.getImage());
		//back.setsetIconImage(bg.getImage());
		//back.setForeground(Color.yellow);
		back.setBorderPainted(true);
		back.setBackground(Color.yellow);
		back.setFocusPainted(false);
		back.setText("X");
		add(back);
		
		ImageIcon image=new ImageIcon("imageback.jpg");
		imgg.setSize(this.getSize());
		imgg.setIcon(image);
//		add(imgg);
		
		cross1.setBounds(100, 300, 100, 200);
//		cross1.setBackground(Color.WHITE);
		cross1.setBackground(Color.CYAN);
		cross1.setSize(100, 200);
		titlepan.add(cross1);
//		this.add(cross1);
		
		
		title.setFont(new Font("Viner Hand ITC", Font.BOLD, 40));
		title.setForeground(Color.decode("#ffffff")); //"#ff9a15"
		title.setText("Tic Tac Toe");

		titlepan.setLayout(new BorderLayout());
		titlepan.setBounds(140, 10, 500, 100);
		title.setHorizontalAlignment(JLabel.CENTER);
		titlepan.add(title, JLabel.CENTER);
		titlepan.setOpaque(false);
		JLabel bg=new JLabel(new ImageIcon("E:\\java\\Game\\src\\image\\background.png"));
		bg.setBounds(160,205,440,310);
		bg.setBackground( Color.decode("#123456"));
		add(titlepan);
		add(bg);
//GridLayout layout=new GridLayout(3,3);
//layout.setHgap(10);
//layout.setVgap(10);
//		btnpan.setLayout(layout);
//		btnpan.setLayout(new FlowLayout());
//		btnpan.setBackground(Color.WHITE);
//		btnpan.setBorder(null);
//		//btnpan.setBorder(new Color(Color.decode("#121212")));
//		btnpan.setBounds(130, 200, 500, 370);
		int x=0,y=0;
		for (int i = 0; i < 9; i++)
		{
			btn[i] = new JButton();
			btn[i].addActionListener(this);
			btn[i].setFocusable(false);
			btn[i].setSize(120,90);
			btn[i].setBorder(BorderFactory.createEmptyBorder());
			btn[i].setBackground(Color.decode("#000000"));
			btn[i].setFont(new Font("Segoe Script", Font.BOLD, 30));
			
			btn[i].setBorderPainted(false);
			
			if(i==0)
			{
				x=0;
				y=0;
			}
			else
			if(i%3==0)
			{
				x=0;
				y+=100;
			}
			else
				x+=150;
			btn[i].setLocation(170+x, 210+y);
			add(btn[i]);
//			btn[i].setOpaque(false);
			btn[i].setForeground(Color.decode("#121212"));
			btn[i].setActionCommand(magic.substring(i, i + 1));
			// System.out.println(magic.substring(i, i));
		}

		//add(btnpan);
		scrpan.setLayout(new GridLayout(2,3));
		scrpan.setOpaque(false);
		for(int i=0;i<3;i++)
		{
			slbl[i]=new JLabel(shead[i]);
			slbl[i].setHorizontalAlignment(JLabel.CENTER);
			slbl[i].setForeground(Color.ORANGE);
			slbl[i].setFont(new Font("Segoe Print", Font.BOLD, 15));
			scrpan.add(slbl[i]);
		}
		cs=new JLabel("0");
		hs=new JLabel("0");
		r=new JLabel("1");
		cs.setHorizontalAlignment(JLabel.CENTER);
		cs.setForeground(Color.GRAY);
		hs.setForeground(Color.GRAY);
		r.setForeground(Color.decode("#009f10"));
		cs.setFont(new Font("Segoe Print", Font.BOLD, 20));
		hs.setFont(new Font("Segoe Print", Font.BOLD, 20));
		hs.setHorizontalAlignment(JLabel.CENTER);
		r.setHorizontalAlignment(JLabel.CENTER);
		r.setFont(new Font("Segoe Print", Font.BOLD, 25));
		scrpan.add(cs);
		scrpan.add(r);
		scrpan.add(hs);
		scrpan.setBounds(130,100,500,100);
		
		add(scrpan);
		setVisible(true);
		
	}

	public NewFrame(int n) {
		System.out.println("hello");// TODO Auto-generated constructor stub
	}}

