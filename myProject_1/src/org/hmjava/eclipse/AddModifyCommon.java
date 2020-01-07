package org.hmjava.eclipse;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class AddModifyCommon extends JFrame {
	String inputStr[] = new String[7];
	
	private JTextField productName;
	private JTextField productId;
	private JTextField category;
	private JTextField price;
	private JTextField productNum;
	private JTextField productMinNum;
	private JTextField etcMemo;
	public JButton doneBtn;
	
	public AddModifyCommon() {
		this("", "", "", "", "", "", "", "");
	}
	
	public AddModifyCommon(String name, String productName_, String productId_, String category_, String price_, String productNum_, String productMinNum_, String etcMemo_) {
		super("Add a newLine product line");
		this.setSize(600, 200);
		this.setLocation(200,200);
		
		productName = new JTextField(5);
		productId = new JTextField(5);
		category = new JTextField(5);
		price = new JTextField(5);
		productNum = new JTextField(5);
		productMinNum = new JTextField(5);
		etcMemo = new JTextField(5);
		
		productName.setText(productName_);
		productId.setText(productId_);
		category.setText(category_);
		price.setText(price_);
		productNum.setText(productNum_);
		productMinNum.setText(productMinNum_);
		etcMemo.setText(etcMemo_);
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		panel1.add(new JLabel("제품명"));
		panel1.add(productName);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
		panel2.add(new JLabel("제품ID"));
		panel2.add(productId);
		
		JPanel panel3 = new JPanel();
		panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
		panel3.add(new JLabel("카테고리"));
		panel3.add(category);
		
		JPanel panel4 = new JPanel();
		panel4.setLayout(new BoxLayout(panel4, BoxLayout.Y_AXIS));
		panel4.add(new JLabel("가격"));
		panel4.add(price);
		
		JPanel panel5 = new JPanel();
		panel5.setLayout(new BoxLayout(panel5, BoxLayout.Y_AXIS));
		panel5.add(new JLabel("재고 수"));
		panel5.add(productNum);
		
		JPanel panel6 = new JPanel();
		panel6.setLayout(new BoxLayout(panel6, BoxLayout.Y_AXIS));
		panel6.add(new JLabel("최소재고량"));
		panel6.add(productMinNum);
		
		JPanel panel7 = new JPanel();
		panel7.setLayout(new BoxLayout(panel7, BoxLayout.Y_AXIS));
		panel7.add(new JLabel("기타 메모"));
		panel7.add(etcMemo);
		
		JPanel panel8 = new JPanel();
		panel8.setLayout(new BoxLayout(panel8, BoxLayout.X_AXIS));
		panel8.add(panel1);
		panel8.add(panel2);
		panel8.add(panel3);
		panel8.add(panel4);
		panel8.add(panel5);
		panel8.add(panel6);
		panel8.add(panel7);
		
		this.add(panel8, BorderLayout.CENTER);
		
		doneBtn = new JButton("Done");
		
		this.add(doneBtn,BorderLayout.EAST);
		this.pack();
		this.setVisible(true);
		this.setResizable(true);
	}
	
	public String[] getInputStr() {
		inputStr[0] = productName.getText();
		inputStr[1] = productId.getText();
		inputStr[2] = category.getText();
		inputStr[3] = price.getText();
		inputStr[4] = productNum.getText();
		inputStr[5] = productMinNum.getText();
		inputStr[6] = etcMemo.getText();
		
		return inputStr;
	}
	
}
