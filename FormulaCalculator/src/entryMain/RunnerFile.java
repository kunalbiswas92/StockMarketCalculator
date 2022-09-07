package entryMain;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;

public class RunnerFile extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JScrollPane scrollPane;
	private static final DecimalFormat df = new DecimalFormat("0.00");
	private JButton btnNewButton_1;
	long FirstRowLow ;
	long FirstRowCurrent ;
	long FirstRowHigh ;

	// Last row values
	long LastRowLow ;
	long LastRowCurrent ;
	long LastRowHigh ;

	// 0 degree row values
	long ZeroDegreeLow ;
	long ZeroDegreeCurrent ;
	long ZeroDegreeHigh ;

	// 360 degree row values
	long ThreeSixtyDegreeLow ;
	long ThreeSixtyDegreeCurrent;
	long ThreeSixtyDegreeHigh ;

	// Constant difference per column
	int DifferenceLow ;
	int DifferenceCurrent ;
	int DifferenceHigh;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RunnerFile frame = new RunnerFile();
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
	public RunnerFile() {
		setTitle("Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1032, 670);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Enter CMP");
		lblNewLabel.setBounds(10, 13, 60, 14);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		

		textField.setBounds(104, 10, 133, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 70, 603, 552);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setForeground(new Color(0, 0, 0));
		table.setBorder(new CompoundBorder(new CompoundBorder(), null));
		table.setBackground(new Color(255, 255, 128));
		scrollPane.setViewportView(table);

		JButton btnNewButton = new JButton("Calculate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Userinput = textField.getText();
				int integerPart = Calculations.sqrtIntegerExtract(Userinput);

				// integer part of input number
				System.out.println("integer part of input number : " + integerPart);

				// First row values
				 FirstRowLow = integerPart - 1;
				 FirstRowCurrent = integerPart;
				 FirstRowHigh = integerPart + 1;

				// Last row values
				 LastRowLow = integerPart;
				 LastRowCurrent = integerPart + 1;
				 LastRowHigh = integerPart + 2;

				// 0 degree row values
				 ZeroDegreeLow = (long) Math.pow(FirstRowLow, 2);
				System.out.println("ZeroDegreeLow: " + ZeroDegreeLow);
				 ZeroDegreeCurrent = (long) Math.pow(FirstRowCurrent, 2);
				System.out.println("ZeroDegreeCurrent: " + ZeroDegreeCurrent);
				 ZeroDegreeHigh = (long) Math.pow(FirstRowHigh, 2);
				System.out.println("ZeroDegreeHigh: " + ZeroDegreeHigh);

				// 360 degree row values
				 ThreeSixtyDegreeLow = (long) Math.pow(LastRowLow, 2);
				 ThreeSixtyDegreeCurrent = (long) Math.pow(LastRowCurrent, 2);
				 ThreeSixtyDegreeHigh = (long) Math.pow(LastRowHigh, 2);

				// Constant difference per column
				 DifferenceLow = (int) (ThreeSixtyDegreeLow - ZeroDegreeLow);
				System.out.println("DifferenceLow: " + DifferenceLow);
				 DifferenceCurrent = (int) (ThreeSixtyDegreeCurrent - ZeroDegreeCurrent);
				System.out.println("DifferenceCurrent: " + DifferenceCurrent);
				 DifferenceHigh = (int) (ThreeSixtyDegreeHigh - ZeroDegreeHigh);
				System.out.println("DifferenceHigh: " + DifferenceHigh);

				System.out.println("*************************************");
				System.out.println("************ LOW column *************");
				System.out.println("*************************************");
				String ThirtyDegreeLow = df.format( ZeroDegreeLow +(double)DifferenceLow / 12);// 1764 + (85/12)
				System.out.println(ThirtyDegreeLow);
				String FortyFiveDegreeLow =  df.format( ZeroDegreeLow + (double)DifferenceLow / 8);
				System.out.println(FortyFiveDegreeLow);
				String SixtyDegreeLow =  df.format( ZeroDegreeLow + (double)DifferenceLow / 6);
				System.out.println(SixtyDegreeLow);
				String NinetyDegreeLow =  df.format( ZeroDegreeLow + (double)DifferenceLow / 4);
				System.out.println(NinetyDegreeLow);
				String OneTwentyDegreeLow =  df.format( ZeroDegreeLow + (double)DifferenceLow / 3);
				System.out.println(OneTwentyDegreeLow);
				String OneThirtyFiveDegreeLow =  df.format( ZeroDegreeLow + (double)DifferenceLow / 2.666);
				System.out.println(OneThirtyFiveDegreeLow);
				String OneFiftyDegreeLow =  df.format( ZeroDegreeLow + (double)DifferenceLow / 2.4);
				System.out.println(OneFiftyDegreeLow);
				String OneEightyDegreeLow =  df.format( ZeroDegreeLow + (double)DifferenceLow / 2);
				System.out.println(OneEightyDegreeLow);
				String TwoTenDegreeLow =  df.format( ZeroDegreeLow + (double)DifferenceLow / 1.71428);
				System.out.println(TwoTenDegreeLow);
				String TwoTwoFiveDegreeLow =  df.format( ZeroDegreeLow + (double)DifferenceLow / 1.6);
				System.out.println(TwoTwoFiveDegreeLow);
				String TwoFortyDegreeLow =  df.format( ZeroDegreeLow + (double)DifferenceLow / 1.5);
				System.out.println(TwoFortyDegreeLow);
				String TwoSeventyDegreeLow =  df.format( ZeroDegreeLow + (double)DifferenceLow / 1.333);
				System.out.println(TwoSeventyDegreeLow);
				String ThreeHundredDegreeLow =  df.format( ZeroDegreeLow + (double)DifferenceLow / 1.2);
				System.out.println(ThreeHundredDegreeLow);
				String ThreeHundredFifteenDegreeLow =  df.format( ZeroDegreeLow + (double)DifferenceLow / 1.1428);
				System.out.println(ThreeHundredFifteenDegreeLow);
				String ThreeHundredThirtyDegreeLow =  df.format( ZeroDegreeLow + (double)DifferenceLow / 1.090909);
				System.out.println(ThreeHundredThirtyDegreeLow);

				
		
				System.out.println("*************************************");
				System.out.println("************ Current column *************");
				System.out.println("*************************************");
				String ThirtyDegreeCurrent = df.format(ZeroDegreeCurrent + (double)DifferenceCurrent / 12);
				System.out.println(ThirtyDegreeCurrent);
				String FortyFiveDegreeCurrent = df.format(ZeroDegreeCurrent + (double)DifferenceCurrent / 8);
				System.out.println(FortyFiveDegreeCurrent);
				String SixtyDegreeCurrent = df.format(ZeroDegreeCurrent + (double)DifferenceCurrent / 6);
				System.out.println(SixtyDegreeCurrent);
				String NinetyDegreeCurrent = df.format(ZeroDegreeCurrent + (double)DifferenceCurrent / 4);
				System.out.println(NinetyDegreeCurrent);
				String OneTwentyDegreeCurrent = df.format(ZeroDegreeCurrent + (double)DifferenceCurrent / 3);
				System.out.println(OneTwentyDegreeCurrent);
				String OneThirtyFiveDegreeCurrent = df.format(ZeroDegreeCurrent + (double)DifferenceCurrent / 2.666);
				System.out.println(OneThirtyFiveDegreeCurrent);
				String OneFiftyDegreeCurrent = df.format(ZeroDegreeCurrent + (double)DifferenceCurrent / 2.4);
				System.out.println(OneFiftyDegreeCurrent);
				String OneEightyDegreeCurrent = df.format(ZeroDegreeCurrent + (double)DifferenceCurrent / 2);
				System.out.println(OneEightyDegreeCurrent);
				String TwoTenDegreeCurrent = df.format(ZeroDegreeCurrent + (double)DifferenceCurrent / 1.71428);
				System.out.println(TwoTenDegreeCurrent);
				String TwoTwoFiveDegreeCurrent = df.format(ZeroDegreeCurrent + (double)DifferenceCurrent / 1.6);
				System.out.println(TwoTwoFiveDegreeCurrent);
				String TwoFortyDegreeCurrent = df.format(ZeroDegreeCurrent + (double)DifferenceCurrent / 1.5);
				System.out.println(TwoFortyDegreeCurrent);
				String TwoSeventyDegreeCurrent = df.format(ZeroDegreeCurrent + (double)DifferenceCurrent / 1.333);
				System.out.println(TwoSeventyDegreeCurrent);
				String ThreeHundredDegreeCurrent = df.format(ZeroDegreeCurrent + (double)DifferenceCurrent / 1.2);
				System.out.println(ThreeHundredDegreeCurrent);
				String ThreeHundredFifteenDegreeCurrent = df.format(ZeroDegreeCurrent + (double)DifferenceCurrent / 1.1428);
				System.out.println(ThreeHundredFifteenDegreeCurrent);
				String ThreeHundredThirtyDegreeCurrent = df.format(ZeroDegreeCurrent + (double)DifferenceCurrent / 1.090909);
				System.out.println(ThreeHundredThirtyDegreeCurrent);
				
				System.out.println("*************************************");
				System.out.println("************ High column *************");
				System.out.println("*************************************");
				String ThirtyDegreeHigh = df.format(ZeroDegreeHigh + (double)DifferenceHigh / 12);
				System.out.println(ThirtyDegreeHigh);
				String FortyFiveDegreeHigh = df.format(ZeroDegreeHigh + (double)DifferenceHigh / 8);
				System.out.println(FortyFiveDegreeHigh);
				String SixtyDegreeHigh = df.format(ZeroDegreeHigh + (double)DifferenceHigh / 6);
				System.out.println(SixtyDegreeHigh);
				String NinetyDegreeHigh = df.format(ZeroDegreeHigh + (double)DifferenceHigh / 4);
				System.out.println(NinetyDegreeHigh);
				String OneTwentyDegreeHigh = df.format(ZeroDegreeHigh + (double)DifferenceHigh / 3);
				System.out.println(OneTwentyDegreeHigh);
				String OneThirtyFiveDegreeHigh = df.format(ZeroDegreeHigh + (double)DifferenceHigh / 2.666);
				System.out.println(OneThirtyFiveDegreeHigh);
				String OneFiftyDegreeHigh = df.format(ZeroDegreeHigh + (double)DifferenceHigh / 2.4);
				System.out.println(OneFiftyDegreeHigh);
				String OneEightyDegreeHigh = df.format(ZeroDegreeHigh + (double)DifferenceHigh / 2);
				System.out.println(OneEightyDegreeHigh);
				String TwoTenDegreeHigh = df.format(ZeroDegreeHigh + (double)DifferenceHigh / 1.71428);
				System.out.println(TwoTenDegreeHigh);
				String TwoTwoFiveDegreeHigh = df.format(ZeroDegreeHigh +(double)DifferenceHigh / 1.6);
				System.out.println(TwoTwoFiveDegreeHigh);
				String TwoFortyDegreeHigh = df.format(ZeroDegreeHigh + (double)DifferenceHigh / 1.5);
				System.out.println(TwoFortyDegreeHigh);
				String TwoSeventyDegreeHigh = df.format(ZeroDegreeHigh + (double)DifferenceHigh / 1.333);
				System.out.println(TwoSeventyDegreeHigh);
				String ThreeHundredDegreeHigh = df.format(ZeroDegreeHigh + (double)DifferenceHigh / 1.2);
				System.out.println(ThreeHundredDegreeHigh);
				String ThreeHundredFifteenDegreeHigh = df.format(ZeroDegreeHigh + (double)DifferenceHigh / 1.1428);
				System.out.println(ThreeHundredFifteenDegreeHigh);
				String ThreeHundredThirtyDegreeHigh = df.format(ZeroDegreeHigh + (double) DifferenceHigh / 1.090909);
				System.out.println(ThreeHundredThirtyDegreeHigh);

				table.setModel(new DefaultTableModel(new Object[][] { 
						{ "", FirstRowLow, FirstRowCurrent, FirstRowHigh, null },
						{ "0", ZeroDegreeLow, ZeroDegreeCurrent, ZeroDegreeHigh, "360" }, 
						{ "30", ThirtyDegreeLow, ThirtyDegreeCurrent, ThirtyDegreeHigh, "330" },
						{ "45", FortyFiveDegreeLow, FortyFiveDegreeCurrent, FortyFiveDegreeHigh, "315" }, 
						{ "60", SixtyDegreeLow, SixtyDegreeCurrent, SixtyDegreeHigh, "300" },
						{ "90", NinetyDegreeLow, NinetyDegreeCurrent, NinetyDegreeHigh, "270" }, 
						{ "120", OneTwentyDegreeLow, OneTwentyDegreeCurrent, OneTwentyDegreeHigh, "240" },
						{ "135", OneThirtyFiveDegreeLow, OneThirtyFiveDegreeCurrent, OneThirtyFiveDegreeHigh, "225" }, 
						{ "150", OneFiftyDegreeLow, OneFiftyDegreeCurrent, OneFiftyDegreeHigh, "210" },
						{ "180", OneEightyDegreeLow, OneEightyDegreeCurrent, OneEightyDegreeHigh, "180" }, 
						{ "210", TwoTenDegreeLow, TwoTenDegreeCurrent, TwoTenDegreeHigh, "150" },
						{ "225", TwoTwoFiveDegreeLow, TwoTwoFiveDegreeCurrent, TwoTwoFiveDegreeHigh, "135" }, 
						{ "240", TwoFortyDegreeLow, TwoFortyDegreeCurrent, TwoFortyDegreeHigh, "120" },
						{ "270", TwoSeventyDegreeLow, TwoSeventyDegreeCurrent, TwoSeventyDegreeHigh, "90" }, 
						{ "300", ThreeHundredDegreeLow, ThreeHundredDegreeCurrent, ThreeHundredDegreeHigh, "60" },
						{ "315", ThreeHundredFifteenDegreeLow, ThreeHundredFifteenDegreeCurrent, ThreeHundredFifteenDegreeHigh, "45" }, 
						{ "330", ThreeHundredThirtyDegreeLow, ThreeHundredThirtyDegreeCurrent, ThreeHundredThirtyDegreeHigh, "30" },
						{ "360", ThreeSixtyDegreeLow, ThreeSixtyDegreeCurrent, ThreeSixtyDegreeHigh, "0" }, 
						{ null, LastRowLow, LastRowCurrent, LastRowHigh, null }, },
						new String[] { "VALUE1", "LOW", "CURRENT", "HIGH", "VALUE2" }));

			}
		});
		
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Userinput = textField.getText();
				int integerPart = Calculations.sqrtIntegerExtract(Userinput);

				// integer part of input number
				System.out.println("integer part of input number : " + integerPart);

				// First row values
				 FirstRowLow = integerPart - 1;
				 FirstRowCurrent = integerPart;
				 FirstRowHigh = integerPart + 1;

				// Last row values
				 LastRowLow = integerPart;
				 LastRowCurrent = integerPart + 1;
				 LastRowHigh = integerPart + 2;

				// 0 degree row values
				 ZeroDegreeLow = (long) Math.pow(FirstRowLow, 2);
				System.out.println("ZeroDegreeLow: " + ZeroDegreeLow);
				 ZeroDegreeCurrent = (long) Math.pow(FirstRowCurrent, 2);
				System.out.println("ZeroDegreeCurrent: " + ZeroDegreeCurrent);
				 ZeroDegreeHigh = (long) Math.pow(FirstRowHigh, 2);
				System.out.println("ZeroDegreeHigh: " + ZeroDegreeHigh);

				// 360 degree row values
				 ThreeSixtyDegreeLow = (long) Math.pow(LastRowLow, 2);
				 ThreeSixtyDegreeCurrent = (long) Math.pow(LastRowCurrent, 2);
				 ThreeSixtyDegreeHigh = (long) Math.pow(LastRowHigh, 2);

				// Constant difference per column
				 DifferenceLow = (int) (ThreeSixtyDegreeLow - ZeroDegreeLow);
				System.out.println("DifferenceLow: " + DifferenceLow);
				 DifferenceCurrent = (int) (ThreeSixtyDegreeCurrent - ZeroDegreeCurrent);
				System.out.println("DifferenceCurrent: " + DifferenceCurrent);
				 DifferenceHigh = (int) (ThreeSixtyDegreeHigh - ZeroDegreeHigh);
				System.out.println("DifferenceHigh: " + DifferenceHigh);

				System.out.println("*************************************");
				System.out.println("************ LOW column *************");
				System.out.println("*************************************");
				String ThirtyDegreeLow = df.format( ZeroDegreeLow +(double)DifferenceLow / 12);// 1764 + (85/12)
				System.out.println(ThirtyDegreeLow);
				String FortyFiveDegreeLow =  df.format( ZeroDegreeLow + (double)DifferenceLow / 8);
				System.out.println(FortyFiveDegreeLow);
				String SixtyDegreeLow =  df.format( ZeroDegreeLow + (double)DifferenceLow / 6);
				System.out.println(SixtyDegreeLow);
				String NinetyDegreeLow =  df.format( ZeroDegreeLow + (double)DifferenceLow / 4);
				System.out.println(NinetyDegreeLow);
				String OneTwentyDegreeLow =  df.format( ZeroDegreeLow + (double)DifferenceLow / 3);
				System.out.println(OneTwentyDegreeLow);
				String OneThirtyFiveDegreeLow =  df.format( ZeroDegreeLow + (double)DifferenceLow / 2.666);
				System.out.println(OneThirtyFiveDegreeLow);
				String OneFiftyDegreeLow =  df.format( ZeroDegreeLow + (double)DifferenceLow / 2.4);
				System.out.println(OneFiftyDegreeLow);
				String OneEightyDegreeLow =  df.format( ZeroDegreeLow + (double)DifferenceLow / 2);
				System.out.println(OneEightyDegreeLow);
				String TwoTenDegreeLow =  df.format( ZeroDegreeLow + (double)DifferenceLow / 1.71428);
				System.out.println(TwoTenDegreeLow);
				String TwoTwoFiveDegreeLow =  df.format( ZeroDegreeLow + (double)DifferenceLow / 1.6);
				System.out.println(TwoTwoFiveDegreeLow);
				String TwoFortyDegreeLow =  df.format( ZeroDegreeLow + (double)DifferenceLow / 1.5);
				System.out.println(TwoFortyDegreeLow);
				String TwoSeventyDegreeLow =  df.format( ZeroDegreeLow + (double)DifferenceLow / 1.333);
				System.out.println(TwoSeventyDegreeLow);
				String ThreeHundredDegreeLow =  df.format( ZeroDegreeLow + (double)DifferenceLow / 1.2);
				System.out.println(ThreeHundredDegreeLow);
				String ThreeHundredFifteenDegreeLow =  df.format( ZeroDegreeLow + (double)DifferenceLow / 1.1428);
				System.out.println(ThreeHundredFifteenDegreeLow);
				String ThreeHundredThirtyDegreeLow =  df.format( ZeroDegreeLow + (double)DifferenceLow / 1.090909);
				System.out.println(ThreeHundredThirtyDegreeLow);

				
		
				System.out.println("*************************************");
				System.out.println("************ Current column *************");
				System.out.println("*************************************");
				String ThirtyDegreeCurrent = df.format(ZeroDegreeCurrent + (double)DifferenceCurrent / 12);
				System.out.println(ThirtyDegreeCurrent);
				String FortyFiveDegreeCurrent = df.format(ZeroDegreeCurrent + (double)DifferenceCurrent / 8);
				System.out.println(FortyFiveDegreeCurrent);
				String SixtyDegreeCurrent = df.format(ZeroDegreeCurrent + (double)DifferenceCurrent / 6);
				System.out.println(SixtyDegreeCurrent);
				String NinetyDegreeCurrent = df.format(ZeroDegreeCurrent + (double)DifferenceCurrent / 4);
				System.out.println(NinetyDegreeCurrent);
				String OneTwentyDegreeCurrent = df.format(ZeroDegreeCurrent + (double)DifferenceCurrent / 3);
				System.out.println(OneTwentyDegreeCurrent);
				String OneThirtyFiveDegreeCurrent = df.format(ZeroDegreeCurrent + (double)DifferenceCurrent / 2.666);
				System.out.println(OneThirtyFiveDegreeCurrent);
				String OneFiftyDegreeCurrent = df.format(ZeroDegreeCurrent + (double)DifferenceCurrent / 2.4);
				System.out.println(OneFiftyDegreeCurrent);
				String OneEightyDegreeCurrent = df.format(ZeroDegreeCurrent + (double)DifferenceCurrent / 2);
				System.out.println(OneEightyDegreeCurrent);
				String TwoTenDegreeCurrent = df.format(ZeroDegreeCurrent + (double)DifferenceCurrent / 1.71428);
				System.out.println(TwoTenDegreeCurrent);
				String TwoTwoFiveDegreeCurrent = df.format(ZeroDegreeCurrent + (double)DifferenceCurrent / 1.6);
				System.out.println(TwoTwoFiveDegreeCurrent);
				String TwoFortyDegreeCurrent = df.format(ZeroDegreeCurrent + (double)DifferenceCurrent / 1.5);
				System.out.println(TwoFortyDegreeCurrent);
				String TwoSeventyDegreeCurrent = df.format(ZeroDegreeCurrent + (double)DifferenceCurrent / 1.333);
				System.out.println(TwoSeventyDegreeCurrent);
				String ThreeHundredDegreeCurrent = df.format(ZeroDegreeCurrent + (double)DifferenceCurrent / 1.2);
				System.out.println(ThreeHundredDegreeCurrent);
				String ThreeHundredFifteenDegreeCurrent = df.format(ZeroDegreeCurrent + (double)DifferenceCurrent / 1.1428);
				System.out.println(ThreeHundredFifteenDegreeCurrent);
				String ThreeHundredThirtyDegreeCurrent = df.format(ZeroDegreeCurrent + (double)DifferenceCurrent / 1.090909);
				System.out.println(ThreeHundredThirtyDegreeCurrent);
				
				System.out.println("*************************************");
				System.out.println("************ High column *************");
				System.out.println("*************************************");
				String ThirtyDegreeHigh = df.format(ZeroDegreeHigh + (double)DifferenceHigh / 12);
				System.out.println(ThirtyDegreeHigh);
				String FortyFiveDegreeHigh = df.format(ZeroDegreeHigh + (double)DifferenceHigh / 8);
				System.out.println(FortyFiveDegreeHigh);
				String SixtyDegreeHigh = df.format(ZeroDegreeHigh + (double)DifferenceHigh / 6);
				System.out.println(SixtyDegreeHigh);
				String NinetyDegreeHigh = df.format(ZeroDegreeHigh + (double)DifferenceHigh / 4);
				System.out.println(NinetyDegreeHigh);
				String OneTwentyDegreeHigh = df.format(ZeroDegreeHigh + (double)DifferenceHigh / 3);
				System.out.println(OneTwentyDegreeHigh);
				String OneThirtyFiveDegreeHigh = df.format(ZeroDegreeHigh + (double)DifferenceHigh / 2.666);
				System.out.println(OneThirtyFiveDegreeHigh);
				String OneFiftyDegreeHigh = df.format(ZeroDegreeHigh + (double)DifferenceHigh / 2.4);
				System.out.println(OneFiftyDegreeHigh);
				String OneEightyDegreeHigh = df.format(ZeroDegreeHigh + (double)DifferenceHigh / 2);
				System.out.println(OneEightyDegreeHigh);
				String TwoTenDegreeHigh = df.format(ZeroDegreeHigh + (double)DifferenceHigh / 1.71428);
				System.out.println(TwoTenDegreeHigh);
				String TwoTwoFiveDegreeHigh = df.format(ZeroDegreeHigh +(double)DifferenceHigh / 1.6);
				System.out.println(TwoTwoFiveDegreeHigh);
				String TwoFortyDegreeHigh = df.format(ZeroDegreeHigh + (double)DifferenceHigh / 1.5);
				System.out.println(TwoFortyDegreeHigh);
				String TwoSeventyDegreeHigh = df.format(ZeroDegreeHigh + (double)DifferenceHigh / 1.333);
				System.out.println(TwoSeventyDegreeHigh);
				String ThreeHundredDegreeHigh = df.format(ZeroDegreeHigh + (double)DifferenceHigh / 1.2);
				System.out.println(ThreeHundredDegreeHigh);
				String ThreeHundredFifteenDegreeHigh = df.format(ZeroDegreeHigh + (double)DifferenceHigh / 1.1428);
				System.out.println(ThreeHundredFifteenDegreeHigh);
				String ThreeHundredThirtyDegreeHigh = df.format(ZeroDegreeHigh + (double) DifferenceHigh / 1.090909);
				System.out.println(ThreeHundredThirtyDegreeHigh);

				table.setModel(new DefaultTableModel(new Object[][] { 
						{ "", FirstRowLow, FirstRowCurrent, FirstRowHigh, null },
						{ "0", ZeroDegreeLow, ZeroDegreeCurrent, ZeroDegreeHigh, "360" }, 
						{ "30", ThirtyDegreeLow, ThirtyDegreeCurrent, ThirtyDegreeHigh, "330" },
						{ "45", FortyFiveDegreeLow, FortyFiveDegreeCurrent, FortyFiveDegreeHigh, "315" }, 
						{ "60", SixtyDegreeLow, SixtyDegreeCurrent, SixtyDegreeHigh, "300" },
						{ "90", NinetyDegreeLow, NinetyDegreeCurrent, NinetyDegreeHigh, "270" }, 
						{ "120", OneTwentyDegreeLow, OneTwentyDegreeCurrent, OneTwentyDegreeHigh, "240" },
						{ "135", OneThirtyFiveDegreeLow, OneThirtyFiveDegreeCurrent, OneThirtyFiveDegreeHigh, "225" }, 
						{ "150", OneFiftyDegreeLow, OneFiftyDegreeCurrent, OneFiftyDegreeHigh, "210" },
						{ "180", OneEightyDegreeLow, OneEightyDegreeCurrent, OneEightyDegreeHigh, "180" }, 
						{ "210", TwoTenDegreeLow, TwoTenDegreeCurrent, TwoTenDegreeHigh, "150" },
						{ "225", TwoTwoFiveDegreeLow, TwoTwoFiveDegreeCurrent, TwoTwoFiveDegreeHigh, "135" }, 
						{ "240", TwoFortyDegreeLow, TwoFortyDegreeCurrent, TwoFortyDegreeHigh, "120" },
						{ "270", TwoSeventyDegreeLow, TwoSeventyDegreeCurrent, TwoSeventyDegreeHigh, "90" }, 
						{ "300", ThreeHundredDegreeLow, ThreeHundredDegreeCurrent, ThreeHundredDegreeHigh, "60" },
						{ "315", ThreeHundredFifteenDegreeLow, ThreeHundredFifteenDegreeCurrent, ThreeHundredFifteenDegreeHigh, "45" }, 
						{ "330", ThreeHundredThirtyDegreeLow, ThreeHundredThirtyDegreeCurrent, ThreeHundredThirtyDegreeHigh, "30" },
						{ "360", ThreeSixtyDegreeLow, ThreeSixtyDegreeCurrent, ThreeSixtyDegreeHigh, "0" }, 
						{ null, LastRowLow, LastRowCurrent, LastRowHigh, null }, },
						new String[] { "VALUE1", "LOW", "CURRENT", "HIGH", "VALUE2" }));

			
				
			}
		});
		btnNewButton.setBounds(268, 9, 89, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setModel(new DefaultTableModel(new Object[][] { 
					{ "", null, null, null, null },
					{ "0", null, null, null, "360" }, 
					{ "30", null, null, null, "330" },
					{ "45", null, null, null, "315" }, 
					{ "60", null, null, null, "300" },
					{ "90", null, null, null, "270" }, 
					{ "120", null, null, null, "240" },
					{ "135", null, null, null, "225" }, 
					{ "150", null, null, null, "210" },
					{ "180", null, null, null, "180" }, 
					{ "210", null, null, null, "150" },
					{ "225", null, null, null, "135" }, 
					{ "240", null, null, null, "120" },
					{ "270", null, null, null, "90" }, 
					{ "300", null, null, null, "60" },
					{ "315", null, null, null, "45" }, 
					{ "330", null, null, null, "30" },
					{ "360", null, null, null, "0" }, 
					{ null, null, null, null, null }, },
					new String[] { "VALUE1", "LOW", "CURRENT", "HIGH", "VALUE2" }));
			}
		});
		btnNewButton_1.setBounds(370, 9, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("src\\img\\stock.png"));
		lblNewLabel_1.setBounds(542, 0, 466, 622);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Calculation table");
		lblNewLabel_2.setBounds(253, 45, 113, 14);
		contentPane.add(lblNewLabel_2);
	}
}
