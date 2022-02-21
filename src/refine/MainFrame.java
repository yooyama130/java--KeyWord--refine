package refine;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tf_char1;
	private JTextField tf_char2;
	private JTextField tf_char3;
	private JTextField tf_char4;
	private JTextField tf_char5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setTitle("『パスワード』絞り込み");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(120, 120, 650, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_char1 = new JLabel("1文字目");
		label_char1.setBounds(30, 30, 45, 13);
		contentPane.add(label_char1);
		JLabel label_char2 = new JLabel("2文字目");
		label_char2.setBounds(30, 80, 45, 13);
		contentPane.add(label_char2);
		JLabel label_char3 = new JLabel("3文字目");
		label_char3.setBounds(30, 130, 45, 13);
		contentPane.add(label_char3);
		JLabel label_char4 = new JLabel("4文字目");
		label_char4.setBounds(30, 180, 45, 13);
		contentPane.add(label_char4);
		JLabel label_char5 = new JLabel("5文字目");
		label_char5.setBounds(30, 230, 45, 13);
		contentPane.add(label_char5);
		
		tf_char1 = new JTextField();
		tf_char1.setBounds(81, 27, 127, 19);
		contentPane.add(tf_char1);
		tf_char1.setColumns(10);
		
		tf_char2 = new JTextField();
		tf_char2.setColumns(10);
		tf_char2.setBounds(81, 77, 127, 19);
		contentPane.add(tf_char2);
		
		tf_char3 = new JTextField();
		tf_char3.setColumns(10);
		tf_char3.setBounds(81, 127, 127, 19);
		contentPane.add(tf_char3);
		
		tf_char4 = new JTextField();
		tf_char4.setColumns(10);
		tf_char4.setBounds(81, 177, 127, 19);
		contentPane.add(tf_char4);
		
		tf_char5 = new JTextField();
		tf_char5.setColumns(10);
		tf_char5.setBounds(81, 227, 127, 19);
		contentPane.add(tf_char5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(311, 24, 150, 361);
		contentPane.add(scrollPane);
		
		JTextArea outputArea = new JTextArea();
		scrollPane.setViewportView(outputArea);
		outputArea.setRows(2);
		outputArea.setColumns(2);
		outputArea.setText(
				"about\r\nafter\r\nagain\r\nbelow\r\ncould\r\n"
				+ "every\r\nfirst\r\nfound\r\ngreat\r\nhouse\r\n"
				+ "large\r\nlearn\r\nnever\r\nother\r\nplace\r\n"
				+ "plant\r\npoint\r\nright\r\nsmall\r\nsound\r\n"
				+ "spell\r\nstill\r\nstudy\r\ntheir\r\nthere\r\n"
				+ "these\r\nthing\r\nthink\r\nthree\r\nwater\r\n"
				+ "where\r\nwhich\r\nworld\r\nwould\r\nwrite");
	}
}
