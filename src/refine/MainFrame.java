package refine;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class MainFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tf_char1;
	private JTextField tf_char2;
	private JTextField tf_char3;
	private JTextField tf_char4;
	private JTextField tf_char5;
	private JTextArea outputArea;
	private String[] AllWords = 
		{"about","after","again","below","could",
		"every","first","found","great","house",
		"large","learn","never","other","place",
		"plant","point","right","small","sound",
		"spell","still","study","their","there",
		"these","thing","think","three","water",
		"where","which","world","would","write"};
	private String[] result; 

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
		setTitle("�w�p�X���[�h�x�i�荞��");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(120, 120, 650, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_char1 = new JLabel("1������");
		label_char1.setBounds(30, 30, 45, 13);
		contentPane.add(label_char1);
		JLabel label_char2 = new JLabel("2������");
		label_char2.setBounds(30, 80, 45, 13);
		contentPane.add(label_char2);
		JLabel label_char3 = new JLabel("3������");
		label_char3.setBounds(30, 130, 45, 13);
		contentPane.add(label_char3);
		JLabel label_char4 = new JLabel("4������");
		label_char4.setBounds(30, 180, 45, 13);
		contentPane.add(label_char4);
		JLabel label_char5 = new JLabel("5������");
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
		
		outputArea = new JTextArea();
		outputArea.setText(output(AllWords));
		outputArea.setEditable(false);
		scrollPane.setViewportView(outputArea);
		
		JButton refineButton = new JButton("�i�荞��");
		refineButton.setBounds(81, 268, 87, 21);
	    refineButton.addActionListener(this);
	    refineButton.setActionCommand("refine");
		contentPane.add(refineButton);
	}
	
	//�z��Ƃ��Ē�`������������e�L�X�g�Ƃ��ĕԂ��i109�s�ڂŎg���Ă���j
	public String output(String[] words) {
		//�e�L�X�g�G���A�ɕԂ��p�̕ϐ����`
		String texts = "";
		for(String str : words) {
			// \r\n �ŉ��s��\��
			texts += str +"\r\n";
		}
		return texts;
	}
	
	//�i�荞�݂�����
	public void refine() {
		//�e�L�X�g�t�B�[���h�ɉ������͂���Ă��Ȃ���΂��ׂāiAllWords�j��\��
		if ((tf_char1.getText().equals("")) && (tf_char2.getText().equals("")) && (tf_char3.getText().equals("")) && (tf_char4.getText().equals("")) && (tf_char5.getText().equals(""))) {
			outputArea.setText(output(AllWords));		
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
	    String command = ( String ) e.getActionCommand();	
	    //�u�i�荞�݁v�{�^���������ꂽ��
	    if (command.equals("refine")) {
	    	refine();
	    }	
	}
}
