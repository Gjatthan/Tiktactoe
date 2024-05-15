package tiktactoe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;


public class Tik implements ActionListener
{
	JFrame win=new JFrame();
	JPanel titlepan=new JPanel();
	JPanel btnpan=new JPanel();
	JButton[] btn=new JButton[9];
	JLabel title=new JLabel();
	String magic="834159672";
	JButton b;
	int o[]=new int[10];
	int x[]=new int[10];
	int io=-1,ix=-1,round=0;
	
	Tik()
	{
		ImageIcon icon=new ImageIcon("C://Users//Admin//Downloads//tic-tac-toe.png");
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.setLayout(null);
		win.setResizable(false);
		win.getContentPane().setBackground(new Color(25,25,100));
		win.setTitle("TikTakToe");
		win.setIconImage(icon.getImage());
		win.setSize(500,500);
			
			
		title.setFont(new Font("Snap ITC",Font.BOLD,30));
		title.setForeground(Color.decode("#6eaa46"));
		title.setText("Tik Tac Toe");
			
		titlepan.setLayout(new BorderLayout());
		titlepan.setBounds(0,0,500,100);
		title.setHorizontalAlignment(JLabel.CENTER);
		titlepan.add(title,JLabel.CENTER);
		win.add(titlepan);
		
		btnpan.setLayout(new GridLayout(3,3));
		btnpan.setBackground(Color.DARK_GRAY);
		btnpan.setBounds(0,100,500,370);
		
		for(int i=0;i<9;i++)
		{
			btn[i]=new JButton();
			btn[i].addActionListener(this);
			btn[i].setFocusable(false);
			btn[i].setBackground(new Color(250,250,250));
			btn[i].setFont(new Font("Snap ITC",Font.BOLD,30));
			btnpan.add(btn[i]);
			btn[i].setActionCommand(magic.substring(i, i+1));
			//System.out.println(magic.substring(i, i));
		}
		
		win.add(btnpan);
		win.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		//try
		//{
		b = (JButton)e.getSource();
		ix+=1;
		x[ix]=Integer.parseInt(b.getActionCommand());
		b.setForeground(Color.blue);
		b.setText("X");
		b.removeActionListener(this);
		if(round==0)
			firstMove(true);
		else
		{
			//if(io>0)
				//move(o,io);
			//else
				move(x,ix);
		}
		//}
		//catch(Exception e1) {System.out.println(e1);}
		//System.out.println(ix+" "+io);
	}
	
	void firstMove(boolean gen)
	{
		//boolean gen=true;
		while(gen)
		{
			Random r=new Random();
			int n=r.nextInt(1,9);
			if(n!=x[ix])
			{
				
				gen=false;
				io+=1;
				o[io]=n;
				round++;
				setO(n);
			}
		}
	}
	void move(int[] arr,int n)
	{
		boolean flg=true,present=false;
		for(int l=0;l<=n&&flg;l++)
		{
			for(int m=0;m<=n&&flg;m++)
			{
				int diff=15-(arr[l]+arr[m]);
				if(diff>9||diff<1||m==l)
					continue;
				for(int y=0;y<arr.length;y++)
				{
					if(diff==x[y]||diff==o[y])
					{
						present=true;
						break;
					}
					else
						present=false;
				}
				if(!present)
				{
					io += 1;
					o[io] = diff;
					System.out.println(diff);
					setO(diff);
					flg = false;
					break;
				}
			}
		}
		if(ix!=io)
		 firstMove(true);
	}
	void setO(int n)
	{
		for(int i=0;i<9;i++)
		{
			if(Integer.parseInt(btn[i].getActionCommand())==n)
			{
				btn[i].setForeground(Color.red);
				btn[i].setText("o");
				btn[i].removeActionListener(this);
				break;
			}	
		}
	}
	public static void main(String args[])
	{
		new Tik();
	}

}
