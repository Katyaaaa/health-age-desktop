import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel {
	private JTextField age;
	private JRadioButton male;
	private JRadioButton female;

	private JLabel biteLabel;
	private JLabel breakfastLabel;
	private JLabel alcoLabel;
	private JLabel smokingLabel;
	private JLabel physLabel;
	private JLabel genderLabel;
	private JLabel sleepLabel;
	private JLabel psgLabel;
	private JTextField psg;
	private JTextField sleep;
	private JRadioButton physEveryday;
	private JRadioButton physFewTimes;
	private JRadioButton physRarely;
	private JRadioButton breakfastEveryday;
	private JRadioButton breakfastSometimes;
	private JRadioButton breakfastNever;
	private JRadioButton biteAlways;
	private JRadioButton biteSometimes;
	private JRadioButton biteNever;
	private JRadioButton smokingNever;
	private JRadioButton smokingGiveUp;
	private JRadioButton smokingYes;
	private JRadioButton alcoOften;
	private JRadioButton alcoRarely;
	private JRadioButton alcoNo;
	private JLabel weightLabel;
	private JLabel heightLabel;
	private JTextField height;
	private JTextField weight;
	private JButton submit;
	private JPanel panelMain;
	private JLabel ageLabel;

	private int habits;
	private StringBuilder recommendation;
	private int userAge;
	private int userPsg;
	private int userWeight;
	private int userHeight;
	private int userSleep;
	private boolean isMale;
	private double bioAge;

	public Panel() {

		recommendation = new StringBuilder();
		habits = 0;

		ButtonGroup gender = new ButtonGroup();
		gender.add(male);
		gender.add(female);

		ButtonGroup physicalEx = new ButtonGroup();
		physicalEx.add(physEveryday);
		physicalEx.add(physFewTimes);
		physicalEx.add(physRarely);

		ButtonGroup smoking = new ButtonGroup();
		smoking.add(smokingGiveUp);
		smoking.add(smokingNever);
		smoking.add(smokingYes);

		ButtonGroup alco = new ButtonGroup();
		alco.add(alcoNo);
		alco.add(alcoOften);
		alco.add(alcoRarely);

		ButtonGroup breakfast = new ButtonGroup();
		breakfast.add(breakfastEveryday);
		breakfast.add(biteAlways);
		breakfast.add(breakfastNever);

		ButtonGroup bite = new ButtonGroup();
		bite.add(biteAlways);
		bite.add(biteNever);
		bite.add(biteSometimes);

		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int passportAge=0;
				if (userAge<=25) passportAge=20;
				if (userAge>25 & userAge<=35) passportAge=30;
				if (userAge>35 & userAge<=45) passportAge=40;
				if (userAge>45 & userAge<=55) passportAge=50;
				if (userAge>55 & userAge<=65) passportAge=60;
				if (userAge>65) passportAge=70;
				switch (habits) {
					case 3: {switch (passportAge){
						case 20: bioAge = passportAge+7.4; break;
						case 30: bioAge = passportAge+9.1; break;
						case 40: bioAge = passportAge+10.7; break;
						case 50: bioAge = passportAge+12.4; break;
						case 60: bioAge = passportAge+14.0; break;
						case 70: bioAge = passportAge+15.7; break;
					} break;
					}
					case 4: {switch (passportAge){
						case 20: bioAge = passportAge+0.5; break;
						case 30: bioAge = passportAge+3.0; break;
						case 40: bioAge = passportAge+5.4; break;
						case 50: bioAge = passportAge+7.9; break;
						case 60: bioAge = passportAge+10.4; break;
						case 70: bioAge = passportAge+12.8; break;
					} break;
					}
					case 5: {switch (passportAge){
						case 20: bioAge = passportAge-1.1; break;
						case 30: bioAge = passportAge-0.6; break;
						case 40: bioAge = passportAge-0.1; break;
						case 50: bioAge = passportAge+0.3; break;
						case 60: bioAge = passportAge+0.8; break;
						case 70: bioAge = passportAge+1.3; break;
					} break;
					}
					case 6: {switch (passportAge){
						case 20: bioAge = passportAge-4.2; break;
						case 30: bioAge = passportAge-4.7; break;
						case 40: bioAge = passportAge-5.2; break;
						case 50: bioAge = passportAge-5.7; break;
						case 60: bioAge = passportAge-6.2; break;
						case 70: bioAge = passportAge-6.8; break;
					} break;
					}
					case 7: {switch (passportAge){
						case 20: bioAge = passportAge-9.4; break;
						case 30: bioAge = passportAge-11.1; break;
						case 40: bioAge = passportAge-12.9; break;
						case 50: bioAge = passportAge-14.7; break;
						case 60: bioAge = passportAge-16.4; break;
						case 70: bioAge = passportAge-18.2; break;
					} break;
					}
					default: {switch (passportAge){
						case 20: bioAge = passportAge+14.3; break;
						case 30: bioAge = passportAge+16.9; break;
						case 40: bioAge = passportAge+19.4; break;
						case 50: bioAge = passportAge+22.0; break;
						case 60: bioAge = passportAge+24.5; break;
						case 70: bioAge = passportAge+27.1; break;
					} break;
					}
				}
				if (habits==7) {
					recommendation.append("Вы ведете здоровый образ жизни. Так держать!");
				}
				JOptionPane.showMessageDialog(null, "Ваш биологический возраст: "+bioAge+
						"\n"+ "Количество хороших привычек: "+habits+"/7\n"+ "Рекомендации:\n"+
						recommendation);
				habits=0;
				recommendation=null;
				age.setText("");
				gender.clearSelection();
				physicalEx.clearSelection();
				smoking.clearSelection();
				breakfast.clearSelection();
				bite.clearSelection();
				weight.setText("");
				height.setText("");
				psg.setText("");
				sleep.setText("");
			}

		});


		age.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

					JOptionPane.showMessageDialog(null, "Введите возраст корректно.");
				userAge = Integer.parseInt(age.getText());
			}
		});

		weight.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				userWeight = Integer.parseInt(weight.getText());
				if (userWeight<10 || userWeight>300)
					JOptionPane.showMessageDialog(null, "Введите вес корректно.");
			}
		});

		height.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				userHeight = Integer.parseInt(height.getText());
			}
		});

		psg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				userPsg = Integer.parseInt(psg.getText());
				if (userPsg>30) {
					if (recommendation.length()>1) recommendation.append("\n");
					recommendation.append("Снизьте процент жира.");
				} else habits++;
			}
		});

		sleep.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				userSleep = Integer.parseInt(sleep.getText());
				if (userSleep==8 || userSleep==7) habits++;
				else {
					if (recommendation.length() > 1) recommendation.append("\n");
					recommendation.append("Спите 7-8 часов.");
				}
			}
		});


		male.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				isMale = true;
			}
		});
		female.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				isMale = false;
			}
		});


		physEveryday.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				habits++;
			}
		});
		physFewTimes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				habits++;
			}
		});
		physRarely.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (recommendation.length()>1) recommendation.append("\n");
				recommendation.append("Занимайтесь физическими упражнениями.");
			}
		});


		smokingNever.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				habits++;
			}
		});
		smokingGiveUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				habits++;
			}
		});
		smokingYes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (recommendation.length()>1) recommendation.append("\n");
				recommendation.append("Бросьте курить.");
			}
		});


		alcoOften.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (recommendation.length()>1) recommendation.append("\n");
				recommendation.append("Не употребляйте алкоголь.");
			}
		});
		alcoRarely.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (recommendation.length()>1) recommendation.append("\n");
				recommendation.append("Не употребляйте алкоголь.");
			}
		});
		alcoNo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				habits++;
			}
		});


		breakfastEveryday.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				habits++;
			}
		});
		breakfastSometimes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (recommendation.length()>1) recommendation.append("\n");
				recommendation.append("Регулярно завтракайте.");
			}
		});
		breakfastNever.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (recommendation.length()>1) recommendation.append("\n");
				recommendation.append("Регулярно завтракайте.");
			}
		});


		biteAlways.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (recommendation.length()>1) recommendation.append("\n");
				recommendation.append("Не перекусывайте.");
			}
		});
		biteSometimes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (recommendation.length()>1) recommendation.append("\n");
				recommendation.append("Не перекусывайте.");
			}
		});
		biteNever.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				habits++;
			}
		});
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Health-age");
		frame.setContentPane(new Panel().panelMain);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
