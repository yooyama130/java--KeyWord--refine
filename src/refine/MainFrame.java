package refine;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
	private JLabel label_result;
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
		
		outputArea = new JTextArea();
		outputArea.setText(output(AllWords));
		outputArea.setEditable(false);
		scrollPane.setViewportView(outputArea);
		
		JButton refineButton = new JButton("絞り込む");
		refineButton.setBounds(81, 268, 87, 21);
	    refineButton.addActionListener(this);
	    refineButton.setActionCommand("refine");
		contentPane.add(refineButton);
		
		label_result = new JLabel("結果："+ 35 +" / 35");
		label_result.setBounds(471, 30, 77, 13);
		contentPane.add(label_result);
	}
	
	//配列として定義した文字列をテキストとして返す（113行目で使用）
	public String output(String[] words) {
		//テキストエリアに返す用の変数を定義
		String texts = "";
		for(String str : words) {
			// \r\n で改行を表す
			texts += str +"\r\n";
		}
		return texts;
	}
	
	//リストをテキストとして返す（202行目で使用)
	public String output(List<String> lists) {
		//テキストエリアに返す用の変数を定義
		String texts = "";
		for(String str : lists) {
			// \r\n で改行を表す
			texts += str +"\r\n";
		}
		return texts;
	}
	
	//『テキストフィールドが空のとき』という条件式(194行目で使用)
	public boolean is_blank(JTextField tf){
		return tf.getText().equals("");
	}
	
	
	//絞り込む（202行目で使用)
	public void refine() {
		//テキストフィールドに入力された文字を文字列strXとしてそれぞれ受け取る
		String str1 = tf_char1.getText();
		String str2 = tf_char2.getText();
		String str3 = tf_char3.getText();
		String str4 = tf_char4.getText();
		String str5 = tf_char5.getText();
		//入力した物を１文字１文字分けたものを、配列strArrayXとしてそれぞれ入れる
		String[] strArray1 = str1.split("");
		String[] strArray2 = str2.split("");
		String[] strArray3 = str3.split("");
		String[] strArray4 = str4.split("");
		String[] strArray5 = str5.split("");
		//分けた文字をそれぞれすべて見ていく
		for(String c1 : strArray1) {
			for(String c2 : strArray2) {
				for(String c3 : strArray3) {
					for(String c4 : strArray4) {
						for(String c5 : strArray5) {
							for(String word : AllWords) {
								//c1~c5それぞれが空白、あるいはスペースありなら正規表現[a-z]を代入
								//contains()、startsWith()は、単に引数として渡された文字列が含まれている or 文字列で始まるかどうかを返します。 
								//一方、 matches()は正規表現を引数として受け取り、同じパターンの文字列であればtrueを返します。
								if(c1.equals("") | c1.equals(" ")) { c1 = "[a-z]";}
								if(c2.equals("") | c2.equals(" ")) { c2 = "[a-z]";}	
								if(c3.equals("") | c3.equals(" ")) { c3 = "[a-z]";}
								if(c4.equals("") | c4.equals(" ")) { c4 = "[a-z]";}
								if(c5.equals("") | c5.equals(" ")) { c5 = "[a-z]";}
								System.out.println(c1+c2+c3+c4+c5);
								//分けた文字をあわせたものから始まるwordをリストresultに追加していく
								if ( word.matches(c1+c2+c3+c4+c5)) {
									result.add(word);
								}
							}
						}
					}
				}
			}
		}
	}
	
	//絞り込んで結果を出す（絞り込むボタンの処理）
	public void outputResult() {
		//テキストフィールドに何も入力されていなければすべて（AllWords）を表示
		if ( (is_blank(tf_char1)) && (is_blank(tf_char2)) && (is_blank(tf_char3)) && (is_blank(tf_char4)) && (is_blank(tf_char5)) ) {
			outputArea.setText(output(AllWords));
			label_result.setText("結果："+ 35 +" / 35");
		}
		else {
			//リストresultを一度初期化
			result = new ArrayList<String>();
			refine();
			//すべての処理が終わったら、setTextで出力
			outputArea.setText(output(result));
			label_result.setText("結果："+ result.size() +" / 35");
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
	    String command = ( String ) e.getActionCommand();	
	    //「絞り込み」ボタンを押された時
	    if (command.equals("refine")) {
	    	outputResult();
	    }	
	}
}
