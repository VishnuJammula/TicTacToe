import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class optimalTTT implements ActionListener
{
	int ROWS = 3,COLS = 3,count = 0;
	JFrame jf;
	JButton jb[] = new JButton[9];
	int BESTROW,BESTCOL;
	boolean gameover = false;
	char[][] board = new char[ROWS][COLS];
	public optimalTTT()
	{
		jf = new JFrame("TicTacToe");
		jf.setLayout(new GridLayout(3,3));
		jf.setPreferredSize(new Dimension(360,360));
		jf.pack();
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		for(int i=0;i<9;i++)
		{
			jb[i] = new JButton("");
			jb[i].addActionListener(this);
			jf.add(jb[i]);
		}
		jf.setVisible(true);
	}
	public void startNewGame(String msg)
	{
		JOptionPane.showMessageDialog(jf,msg);
		jf.dispose();
		new optimalTTT();
	}
	public void actionPerformed(ActionEvent a){
		JButton jb = (JButton)a.getSource();
		int col = jb.getX()/114;
		int row = jb.getY()/107;
		if(count==8)
		{
			startNewGame("MATCH DRAWN");
		}
		if(gameover==false)
		humanMove(jb,col,row);
	}
	void humanMove(JButton jb,int col,int row)
	{
		count++;
		if(board[row][col]=='\0')
		{
			board[row][col] = 'x';
			jb.setLabel("X");
			if(checkForWin('x'))
			{
				startNewGame("X won the game");
				gameover = true;
			}
			else
			{
				computerMove();
			}
		}
		else
		{
			return;
		}
	}
	void computerMove()
	{
		count++;
			if(findCellIndices(false))
			{
				board[BESTROW][BESTCOL] = 'o'; 
				jb[3*BESTROW+BESTCOL].setLabel("O");
				gameover = true;
				startNewGame("O won the game");
			}
			else if(findCellIndices(true))
			{
				board[BESTROW][BESTCOL] = 'o'; //true for x;
				jb[3*BESTROW+BESTCOL].setLabel("O");
			}
			else
			{
				if(board[0][0]=='\0') {jb[0].setLabel("O");board[0][0] = 'o';}
				else if(board[0][2]=='\0') {jb[2].setLabel("O");board[0][2] = 'o';}
				else if(board[2][0]=='\0') {jb[6].setLabel("O");board[2][0] = 'o';}
				else if(board[2][2]=='\0') {jb[8].setLabel("O");board[2][2] = 'o';}
			}
	}
		
	boolean checkForWin(char ch)
	{
		for(int i=0;i<=2;i++)  //check rows;
		{
			int j=0;
			if(board[i][j]==ch && board[i][j+1]==ch && board[i][j+2]==ch)
			return true;
		}
		for(int j=0;j<=2;j++)  //check cols
		{
			int i=0;
			if(board[i][j]==ch && board[i+1][j]==ch && board[i+2][j]==ch)
			return true;
		}
		if(board[0][0]==ch && board[1][1]==ch && board[2][2]==ch)
			return true;
		if(board[0][2]==ch && board[1][1]==ch && board[2][0]==ch)
			return true;

		return false;
	}
	boolean findCellIndices(boolean value)
	{
		char ch = (value==true)?'x':'o';
		for(int i=0;i<ROWS;i++)
		{
			for(int j=0;j<COLS;j++)
			{
				if(board[i][j]=='\0')
				{
					board[i][j] = ch;
					if(checkForWin(ch))
					{
						board[i][j] = '\0';
						BESTROW = i;
						BESTCOL = j;
						return true;
					}
					board[i][j] = '\0';
				}
			}
		}
		return false;
	}
	public static void main(String args[])
	{
		new optimalTTT();
	}
}
