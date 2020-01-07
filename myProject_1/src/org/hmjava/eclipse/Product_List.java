package org.hmjava.eclipse;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
//import java.util.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class Product_List extends JFrame {
	static JTable realtable = new JTable();
	static String contents[][];
	public Product_List() {		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		 
		this.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 100);
		setSize(600,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Product List");
		
		Image img = kit.getImage("and.png");
		setIconImage(img);
		
		String header[] = {"제품명", "제품ID", "카테고리", "가격", "재고수", "최소재고량", "기타 메모"};
		//String contents[][] = null;
		/*
		String contents[][] = {
				{"Coffee", "1-00010", "1", "1000", "100", "50", "Test1"},
				{"연필", "2-50010", "2", "100", "1000", "500", ""}
		};
		*/
		try {
			loadTable();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		DefaultTableModel model;
		
		model = new DefaultTableModel(contents, header) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		JTable table = new JTable(model);
		JScrollPane scrollpane = new JScrollPane(table);
		
		JPanel panel = new JPanel();
		GridLayout gridButton = new GridLayout(4,1);
		panel.setLayout(gridButton);
		
		JButton addBtn = new JButton("Add");
		addBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {	
				AddModifyCommon fs = new AddModifyCommon();
				
				fs.doneBtn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						String inputStr[] = fs.getInputStr();
						
						for(int i = 0; i<7 ; i++) {
							if(inputStr[i]==null) {
								inputStr[i] = " ";
							}
						}
						
						model.addRow(inputStr);
					}
					
					
				});
				
			}
			
		});
		
		JButton deleteBtn = new JButton("Delete");
		deleteBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {	
				if(table.getSelectedRow() == -1) {
					return;
				}	
				else {
					model.removeRow(table.getSelectedRow());
				}
			}
			
		});
		
		JButton modifyBtn = new JButton("Modify");
		modifyBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				if(table.getSelectedRow() == -1) {
					return;
				}	
				else {
					int rowIndex = table.getSelectedRow();
					
					JFrame fs = new JFrame("Modify a product line");
					
					
					fs.setSize(600, 200);
					fs.setLocation(200,200);
					
					JTextField productName = new JTextField(5);
					JTextField productId = new JTextField(5);
					JTextField category = new JTextField(5);
					JTextField price = new JTextField(5);
					JTextField productNum = new JTextField(5);
					JTextField productMinNum = new JTextField(5);
					JTextField etcMemo = new JTextField(5);
					
					productName.setText((String) table.getValueAt(rowIndex, 0));
					productId.setText((String) table.getValueAt(rowIndex, 1));
					category.setText((String) table.getValueAt(rowIndex, 2));
					price.setText((String) table.getValueAt(rowIndex, 3));
					productNum.setText((String) table.getValueAt(rowIndex, 4));
					productMinNum.setText((String) table.getValueAt(rowIndex, 5));
					etcMemo.setText((String) table.getValueAt(rowIndex, 6));
					
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
					
					fs.add(panel8, BorderLayout.CENTER);
					
					
					JButton doneBtn = new JButton("Done");
					doneBtn.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							
							String inputStr[] = new String[7];
							inputStr[0] = productName.getText();
							inputStr[1] = productId.getText();
							inputStr[2] = category.getText();
							inputStr[3] = price.getText();
							inputStr[4] = productNum.getText();
							inputStr[5] = productMinNum.getText();
							inputStr[6] = etcMemo.getText();
							
							for(int i = 0; i<7 ; i++) {
								if(inputStr[i]==null) {
									inputStr[i] = " ";
								}
								table.setValueAt(inputStr[i],rowIndex,i);
							}
							
						}
						
						
					});
					fs.add(doneBtn,BorderLayout.EAST);
					fs.pack();
					fs.setVisible(true);
					fs.setResizable(true);
					
				}
				
			}
			
		});
		
		JButton saveFileBtn = new JButton("Save File");
		saveFileBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
					table.setModel(model);
					realtable=table;
					try {
						saveTable();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
			}
			
		});
		
		panel.add(addBtn);
		panel.add(deleteBtn);
		panel.add(modifyBtn);
		panel.add(saveFileBtn);
		
		add(scrollpane, BorderLayout.CENTER);
		add(panel, BorderLayout.EAST);
		
		setVisible(true);
		setResizable(true);
		
		
	}
	
	
	public void saveTable()throws Exception 
	{ 
	    BufferedWriter bfw = new BufferedWriter(new FileWriter("Data.txt")); 
	   
	    for (int i = 0 ; i < realtable.getRowCount(); i++) 
	    { 
	     
	    	for(int j = 0 ; j < realtable.getColumnCount();j++) 
	    	{   
	    		if((String)(realtable.getValueAt(i,j))==null) {
	    			realtable.setValueAt(" ",i,j);
	    		}
	    		bfw.write((String)(realtable.getValueAt(i,j))); 
	    		bfw.write("\t");; 
	    	} 
	    	bfw.newLine();
	    } 
	    bfw.close(); 
	} 	
	
	public void loadTable()throws Exception
	{
		 try{
	            //파일 객체 생성
	            File file = new File("C:\\Users\\hmkim\\eclipse-workspace\\myProject_1\\Data.txt");
	            //입력 스트림 생성
	            FileReader filereader = new FileReader(file);
	            //입력 버퍼 생성
	            BufferedReader bufReader = new BufferedReader(filereader);
	            String line = "";
	            
	            List<String[]> contentsLoad = new ArrayList<String[]>();
	            
	            while((line = bufReader.readLine()) != null) {
	            	String[] oneLine = line.split("\t");
	            	contentsLoad.add(oneLine);
	            }
	            String[][] simpleArray = new String[contentsLoad.size()][];
	            for(int i = 0;i<contentsLoad.size();i++) {
	            	String[] row = contentsLoad.get(i);
	            	simpleArray[i] = new String[row.length];
	            	for(int j = 0; j<row.length;j++) {
	            		simpleArray[i][j] = row[j];
	            	}
	            }
	            
	            contents = simpleArray;
	           
	            //.readLine()은 끝에 개행문자를 읽지 않는다.            
	            bufReader.close();
	        }catch (FileNotFoundException e) {
	            // TODO: handle exception
	        }catch(IOException e){
	            System.out.println(e);
	        }
	}
	
}
