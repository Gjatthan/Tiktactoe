package tiktactoe;

import java.awt.Color;
import java.awt.event.*;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JOptionPane;


@SuppressWarnings("serial")
public class TGame extends NewFrame implements ActionListener
{
	int o[] = new int[10];
	int x[] = new int[10];
	int io = -1, ix = -1;
	TGame()
	{
		super();
	}
	void randomMove() 
	{
		Random r = new Random();
		while (true) 
		{
			int rndnum = r.nextInt(9);
			if(rndnum<=0)
				continue;
			if (x[0]!=rndnum)
			{
				setO(rndnum);
				break;
			}
		}
	}
	void getPos()
	{
		boolean flg=true;
		for(int i=1;i<10;i++)
		{
			for(int j=0;j<=ix;j++)
				if(x[j]==i||o[j]==i)
				{
					flg=false;
					break;
				}
			if(flg)
			{
				setO(i);
				break;
			}
			flg=true;
		}
	}

	void setO(int pos) 
	{
		for (JButton b : btn)
		{
			if (Integer.parseInt(b.getActionCommand()) == pos)
			{
				b.setForeground(Color.blue);
				b.setText("O");
				o[++io]=pos;
				b.removeActionListener(this);
			}
		}
	}


	void setX(JButton b) throws InterruptedException
	{
		b.setForeground(Color.RED);
		b.setText("X");
		x[++ix]=Integer.parseInt(b.getActionCommand());
		b.removeActionListener(this);
		Thread.sleep(100);
	}
	
	int WinIndx(int arr[],int i)
	{
		for(int x=0;x<=i;x++)
		{
			for(int y=0;y<=i;y++)
			{
				int diff=(15-(arr[x]+arr[y]));
				if(arr[y]==arr[x]||diff>9||diff<1)
					continue;
				if(!(indexCheck(diff,o)||indexCheck(diff,this.x)))
					return diff;
			}
		}	
		return -1;
	}

	boolean indexCheck(int index,int arr[])
	{
		for(int i:arr)
			if(i==index)
				return true;
			else
				continue;
		return false;
	}

	void   generalMove()
	{
		int num=o[io];
		int diff=15-num;
		boolean flg=true;
		for(int i=1;i<=9&&flg;i++)
			for(int j=1;j<=9&&flg;j++)
				if(i+j==diff&&i!=j)
					if(!(indexCheck(i,o)||indexCheck(j,o)||indexCheck(i,x)||indexCheck(j,x)))
					{
						setO(i);
						flg=false;
					}
		if(flg&&ix < 4 && io < 3)
			getPos();
	}
	
	boolean isOWin()
	{
		if(io>=2)
		{
			for(int a=0;a<=io;a++)
				for(int b=0;b<=io;b++)
					for(int c=0;c<=io;c++)
					{
						if(o[a]!=o[b]&&o[a]!=o[c]&&o[b]!=o[c])
						{
							if(o[a]+o[b]+o[c]==15)
							{
								return true;
							}
						}
					}
		}
		return false;
	}
	
	void reset()
	{
		for(int i=0;i<9;i++)
		{
			btn[i].setText("");
			btn[i].removeActionListener(this);
		}
		for(int i=0;i<9;i++)
		{
			btn[i].setText("");
			btn[i].addActionListener(this);
		}
		for(int i=0;i<10;i++)
		{
			x[i]=0;
			o[i]=0;
		}
		ix=-1;
		io=-1;
		
		r.setText(String.valueOf(Integer.parseInt(r.getText())+1));
	}
	
	boolean isXWin()
	{
		if(ix>=2)
		{
			for(int a=0;a<=ix;a++)
				for(int b=0;b<=ix;b++)
					for(int c=0;c<=ix;c++)
					{
						if(x[a]!=x[b]&&x[a]!=x[c]&&x[b]!=x[c])
						{
							if(x[a]+x[b]+x[c]==15)
							{
								return true;
							}
						}
					}
		}
		return false;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		try 
		{
			setX((JButton)e.getSource());
				if (io == -1) 
					randomMove();
				else 
				{
					int indx1 = WinIndx(o, io);
					int indx2 = WinIndx(x, ix);
					if (indx1 != -1) 
						setO(indx1); 
					else if (indx2 != -1) 
						setO(indx2);
					else 
						generalMove();
					if(isXWin())
					{
						JOptionPane p=new JOptionPane();
						p.setFocusable(false);
						p.showMessageDialog(this,"You Won");
						hs.setText(String.valueOf(Integer.parseInt(hs.getText())+1));
						reset();
					}
					else
					if (isOWin()) 
					{
						JOptionPane p=new JOptionPane();
						p.setFocusable(false);
						p.showMessageDialog(this,"You Won");
						cs.setText(String.valueOf(Integer.parseInt(cs.getText()) + 1));
						reset();
					} 
					else if (ix >= 4 && io >= 3 && !(isOWin()) && !(isXWin())) 
					{
						JOptionPane.showMessageDialog(this, "Draw");
						reset();
					}
				}
		}
		catch (Exception e1) 
		{
			JOptionPane.showMessageDialog(null, e1.toString());
		}
	}

	public static void main(String args[]) 
	{
		new TGame();
	}
}
