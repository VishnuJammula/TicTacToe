import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class MainFrame implements ActionListener{
	static JFrame jf;
	
	JPanel jp;
	JButton twoPlayerButton;
	JButton singlePlayerButton;
	JButton exitButton;
	
	optimalTTT object = new optimalTTT();
	JFrame jf1 = object.getTTTFrame();
	public void addPanel()
	{
		jp = new JPanel();
		Dimension dim = jp.getPreferredSize();
		dim.width = 360;
		dim.height = 280;
		jp.setPreferredSize(dim);
		jp.setLayout(new GridBagLayout());
		jf.add(jp,BorderLayout.WEST);
		jp.setBackground(new Color(66,133,244));
	}
	public void addControlButtons()
	{
		twoPlayerButton  = new JButton("Two player");
		twoPlayerButton.addActionListener((ActionListener)this);
		singlePlayerButton = new JButton("Single player");
		singlePlayerButton.addActionListener((ActionListener)this);
		exitButton = new JButton("Exit");
		exitButton.addActionListener((ActionListener)this);
		GridBagConstraints gc = new GridBagConstraints();
		/* Adding twoPlayerButton */
		
	
	
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		gc.gridy = 0;
		jp.add(twoPlayerButton,gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		jp.add(singlePlayerButton,gc);
		
		
		gc.gridx = 0;
		gc.gridy = 2;
		jp.add(exitButton,gc);
	}
	static JFrame getMainFrame()
	{
		return jf;
	}
	public void actionPerformed(ActionEvent ae)
	{
		String source = ae.getActionCommand();
		if(source.equals("Exit"))
		{
			System.exit(1);
		}
		if(source.equals("Single player"))
		{
			jf1.show();
			jf.dispose();
		}
		if(source.equals("Two player"))
		{
			//jp.setBackground(new Color(123,234,100));
		}
	}
	public MainFrame()
	{
		jf = new JFrame("TicTacToe");
		jf.setLayout(new GridLayout());
		jf.setPreferredSize(new Dimension(360,360));
		jf.pack();
		jf.setLocationRelativeTo(null);
		addPanel();
		addControlButtons();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
public static void main(String args[])
{
	new MainFrame();
}
}
