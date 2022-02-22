package refine;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

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
	private List<String> result = new ArrayList<String>();

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
		
		JLabel label_notice = new JLabel("���P�����ڂ��珇�ɓ��͂��Ȃ��Ɛ��������ʂ��o�܂���B");
		label_notice.setFont(new Font("MS UI Gothic", Font.PLAIN, 11));
		label_notice.setForeground(Color.RED);
		label_notice.setBounds(30, 320, 271, 34);
		contentPane.add(label_notice);
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
	
	//���X�g���e�L�X�g�Ƃ��ĕԂ�
	public String output(List<String> lists) {
		//�e�L�X�g�G���A�ɕԂ��p�̕ϐ����`
		String texts = "";
		for(String str : lists) {
			// \r\n �ŉ��s��\��
			texts += str +"\r\n";
		}
		return texts;
	}
	
	//�w�e�L�X�g�t�B�[���h����̂Ƃ��x�Ƃ���������
	public boolean is_blank(JTextField tf){
		return tf.getText().equals("");
	}
	
	
	//�i�荞�ށi175�s����g�p)
	public void refine() {
		//�e�L�X�g�t�B�[���h�ɓ��͂��ꂽ�����𕶎���strX�Ƃ��Ă��ꂼ��󂯎��
		String str1 = tf_char1.getText();
		String str2 = tf_char2.getText();
		String str3 = tf_char3.getText();
		String str4 = tf_char4.getText();
		String str5 = tf_char5.getText();
		//���͂��������P�����P�������������̂��A�z��strArrayX�Ƃ��Ă��ꂼ������
		String[] strArray1 = str1.split("");
		String[] strArray2 = str2.split("");
		String[] strArray3 = str3.split("");
		String[] strArray4 = str4.split("");
		String[] strArray5 = str5.split("");
		//���������������ꂼ�ꂷ�ׂČ��Ă���
		for(String c1 : strArray1) {
			for(String c2 : strArray2) {
				for(String c3 : strArray3) {
					for(String c4 : strArray4) {
						for(String c5 : strArray5) {
							for(String word : AllWords) {
								//���������������킹�����̂���n�܂�word�����X�gresult�ɒǉ����Ă���
								if ( word.startsWith(c1+c2+c3+c4+c5)) {
									result.add(word);	
								}
							}
						}
					}
				}
			}
		}
	}
	
	//�i�荞��Ō��ʂ��o���i�i�荞�ރ{�^���̏����j
	public void outputResult() {
		//�e�L�X�g�t�B�[���h�ɉ������͂���Ă��Ȃ���΂��ׂāiAllWords�j��\��
		if ( (is_blank(tf_char1)) && (is_blank(tf_char2)) && (is_blank(tf_char3)) && (is_blank(tf_char4)) && (is_blank(tf_char5)) ) {
			outputArea.setText(output(AllWords));		
		}
		else {
			//���X�gresult����x������
			result = new ArrayList<String>();
			//java.lang.UnsupportedOperationException: remove�Ƃ����G���[���o���̂ňȉ��ɕύX
			//result= new LinkedList(Arrays.asList(AllWords));
			refine();
			//���ׂĂ̏������I�������AsetText�ŏo��
			outputArea.setText(output(result));
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
	    String command = ( String ) e.getActionCommand();	
	    //�u�i�荞�݁v�{�^���������ꂽ��
	    if (command.equals("refine")) {
	    	outputResult();
	    }	
	}
}
