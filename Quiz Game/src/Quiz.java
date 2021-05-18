import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Quiz implements ActionListener{

	String[] questions =	{
								"Wave speed is _____ the period of a wave.",
								"A wave with a frequency of 1000 Hz has a period of",
								"A wave has a speed of 10 m/s and a frequency of 	100 Hz. What is its wavelength?",
								"The amplitude of a wave is a measure of its"
			   				};
	String[][] options = 	{
								{"smaller than","directly proportional to","larger than","inversely proportional to"},
								{"0.0001 seconds.","0.001 seconds.","0.01 seconds.","0.1 seconds."},
								{"1 meter","0.1 meters","10 meters","100 meters"},
								{"period.","height.","length.","speed."}
							};
	char[] answers =		{
								'D',
								'B',
								'B',
								'B'
							};
	char guess;
	char answer;
	int index;
	int correct_guess =0;
	int total_questions = questions.length;
	int result;
	int seconds=10;
	
	JFrame frame = new JFrame();
	JTextField textfield = new JTextField();
	JTextArea textarea = new JTextArea();
	JTextArea textarea2 = new JTextArea();
	JButton buttonA = new JButton();
	JButton buttonB = new JButton();
	JButton buttonC = new JButton();
	JButton buttonD = new JButton();
	JLabel answer_labelA = new JLabel();
	JLabel answer_labelB = new JLabel();
	JLabel answer_labelC = new JLabel();
	JLabel answer_labelD = new JLabel();
	JLabel time_label = new JLabel();
	JLabel seconds_left = new JLabel();
	JTextField number_right = new JTextField();
	JTextField percentage = new JTextField();
	
	Timer timer = new Timer(1000, new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			seconds--;
			seconds_left.setText(String.valueOf(seconds));
			if(seconds<=0) {
				displayAnswer();
			}
			}
		});
	
	public Quiz() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650,650);
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setLayout(null);
		frame.setResizable(false);
		
		textfield.setBounds(0,0,650,50);
		textfield.setBackground(new Color(25,25,25));
		textfield.setForeground(new Color(25,255,0));
		textfield.setFont(new Font("Helvetica",Font.BOLD,30));
		textfield.setBorder(BorderFactory.createBevelBorder(1));
		textfield.setHorizontalAlignment(JTextField.CENTER);
		textfield.setEditable(false);
		
		textarea.setBounds(0,50,650,75);
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
		textarea.setBackground(new Color(25,25,25));
		textarea.setForeground(new Color(25,255,0));
		textarea.setFont(new Font("Helvetica",Font.BOLD,25));
		textarea.setBorder(BorderFactory.createBevelBorder(1));
		textarea.setEditable(false);
		
		textarea2.setBounds(0,575,465,50);
		textarea2.setLineWrap(true);
		textarea2.setWrapStyleWord(true);
		textarea2.setBackground(new Color(25,25,25));
		textarea2.setForeground(new Color(31,190,214));
		textarea2.setFont(new Font("Helvetica",Font.BOLD,25));
		textarea2.setBorder(BorderFactory.createBevelBorder(1));
		textarea2.setText("Subject: Physics   |   Teacher: Mr. Jati");
	
		buttonA.setBounds(25,150,100,100);
		buttonA.setFont(new Font("Helvetica",Font.BOLD,35));
		buttonA.setFocusable(false);
		buttonA.addActionListener(this);
		buttonA.setText("A");
		
		buttonB.setBounds(25,250,100,100);
		buttonB.setFont(new Font("Helvetica",Font.BOLD,35));
		buttonB.setFocusable(false);
		buttonB.addActionListener(this);
		buttonB.setText("B");
		
		buttonC.setBounds(25,350,100,100);
		buttonC.setFont(new Font("Helvetica",Font.BOLD,35));
		buttonC.setFocusable(false);
		buttonC.addActionListener(this);
		buttonC.setText("C");
		
		buttonD.setBounds(25,450,100,100);
		buttonD.setFont(new Font("Helvetica",Font.BOLD,35));
		buttonD.setFocusable(false);
		buttonD.addActionListener(this);
		buttonD.setText("D");
		
		answer_labelA.setBounds(145,150,500,100);
		answer_labelA.setBackground(new Color(50,50,50));
		answer_labelA.setForeground(new Color(25,255,0));
		answer_labelA.setFont(new Font("Helvetica",Font.PLAIN,35));
		answer_labelA.setText("TESTTTT");
		
		answer_labelB.setBounds(145,250,500,100);
		answer_labelB.setBackground(new Color(50,50,50));
		answer_labelB.setForeground(new Color(25,255,0));
		answer_labelB.setFont(new Font("Helvetica",Font.PLAIN,35));
		answer_labelB.setText("");
		
		answer_labelC.setBounds(145,350,500,100);
		answer_labelC.setBackground(new Color(50,50,50));
		answer_labelC.setForeground(new Color(25,255,0));
		answer_labelC.setFont(new Font("Helvetica",Font.PLAIN,35));
		answer_labelC.setText("");
		
		answer_labelD.setBounds(145,450,500,100);
		answer_labelD.setBackground(new Color(50,50,50));
		answer_labelD.setForeground(new Color(25,255,0));
		answer_labelD.setFont(new Font("Helvetica",Font.PLAIN,35));
		answer_labelD.setText("");
		
		seconds_left.setBounds(533,510,100,100);
		seconds_left.setBackground(new Color(25,25,25));
		seconds_left.setForeground(new Color(255,0,0));
		seconds_left.setFont(new Font("Helvetica",Font.BOLD,60));
		seconds_left.setBorder(BorderFactory.createBevelBorder(1));
		seconds_left.setOpaque(true);
		seconds_left.setHorizontalAlignment(JTextField.CENTER);
		seconds_left.setText(String.valueOf(seconds));
		
		time_label.setBounds(533,475,100,25);
		time_label.setBackground(new Color(50,50,50));
		time_label.setForeground(new Color(255,0,0));
		time_label.setFont(new Font("Helvetica",Font.PLAIN,19));
		time_label.setHorizontalAlignment(JTextField.CENTER);
		time_label.setText("Timer:");
		
		number_right.setBounds(225,225,200,100);
		number_right.setBackground(new Color(25,25,25));
		number_right.setForeground(new Color(25,255,0));
		number_right.setFont(new Font("Helvetica",Font.BOLD,50));
		number_right.setBorder(BorderFactory.createBevelBorder(1));
		number_right.setHorizontalAlignment(JTextField.CENTER);
		number_right.setEditable(false);
		
		percentage.setBounds(225,325,200,100);
		percentage.setBackground(new Color(25,25,25));
		percentage.setForeground(new Color(25,255,0));
		percentage.setFont(new Font("Helvetica",Font.BOLD,50));
		percentage.setHorizontalAlignment(JTextField.CENTER);
		percentage.setBorder(BorderFactory.createBevelBorder(1));
		percentage.setEditable(false);
		
		
		
		frame.add(time_label);
		frame.add(seconds_left);
		frame.add(answer_labelA);
		frame.add(answer_labelB);
		frame.add(answer_labelC);
		frame.add(answer_labelD);
		frame.add(buttonA);
		frame.add(buttonB);
		frame.add(buttonC);
		frame.add(buttonD);
		frame.add(textarea);
		frame.add(textfield);
		frame.add(textarea2);
		frame.setVisible(true);
		
		nextQuestion();
	}
	public void nextQuestion() {
		
		if(index>=total_questions) {
			results();
		}
		else {
			textfield.setText("Question "+(index+1));
			textarea.setText(questions[index]);
			answer_labelA.setText(options[index][0]);
			answer_labelB.setText(options[index][1]);
			answer_labelC.setText(options[index][2]);
			answer_labelD.setText(options[index][3]);
			timer.start();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		if(e.getSource()==buttonA) {
			answer= 'A';
			if(answer == answers[index]) {
				correct_guess++;
			}
			
		}
		if(e.getSource()==buttonB) {
			answer= 'B';
			if(answer == answers[index]) {
				correct_guess++;
			}
			
		}
		if(e.getSource()==buttonC) {
			answer= 'C';
			if(answer == answers[index]) {
				correct_guess++;
			}
			
		}
		if(e.getSource()==buttonD) {
			answer= 'D';
			if(answer == answers[index]) {
				correct_guess++;
			}
			
		}
		displayAnswer();
		
	}
	public void displayAnswer() {
		
		timer.stop();
		
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		if(answers[index] != 'A')
			answer_labelA.setForeground(new Color(255,0,0));
		if(answers[index] != 'B')
			answer_labelB.setForeground(new Color(255,0,0));
		if(answers[index] != 'C')
			answer_labelC.setForeground(new Color(255,0,0));
		if(answers[index] != 'D')
			answer_labelD.setForeground(new Color(255,0,0));
		
		Timer pause = new Timer(2000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				answer_labelA.setForeground(new Color(25,255,0));
				answer_labelB.setForeground(new Color(25,255,0));
				answer_labelC.setForeground(new Color(25,255,0));
				answer_labelD.setForeground(new Color(25,255,0));
				
				answer = ' ';
				seconds=10;
				seconds_left.setText(String.valueOf(seconds));
				buttonA.setEnabled(true);
				buttonB.setEnabled(true);
				buttonC.setEnabled(true);
				buttonD.setEnabled(true);
				index++;
				nextQuestion();
				
			}
		});
		pause.setRepeats(false);
		pause.start();
		
	}
	public void results() {
		
		buttonA.setEnabled(false);
		buttonA.setEnabled(false);
		buttonA.setEnabled(false);
		buttonA.setEnabled(false);
		
		result = (int)((correct_guess/(double)total_questions)*100);
		
		textfield.setText("RESULTS!");
		textarea.setText("");
		answer_labelA.setText("");
		answer_labelB.setText("");
		answer_labelC.setText("");
		answer_labelD.setText("");
		
		number_right.setText("("+correct_guess+"/"+total_questions+")");
		percentage.setText(result+"%");
		
		frame.add(percentage);
		frame.add(number_right);
		
		
		
	}
}




