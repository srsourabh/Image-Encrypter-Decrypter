import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class ImageOperations {
	
	
	public static void operate(int key) {
		JFileChooser filechooser = new JFileChooser();
		filechooser.showOpenDialog(null);
		File file= filechooser.getSelectedFile();
		
		//file inputstream
		try {
			FileInputStream fis = new FileInputStream(file);
			byte []data = new byte[fis.available()];
			fis.read(data);
			//here file is converted to byte and now we have to encrypt the byte using XOR function
			
			int i = 0;
			for(byte b:data) {
				System.out.println(b);
				data[i] = (byte) (b^key);
				i++;
			}
			 FileOutputStream fos = new FileOutputStream(file);
			 fos.write(data);
			 fos.close();
			 fis.close();
			 JOptionPane.showMessageDialog(null, "Done");
			
		     
		}catch(Exception e) {
			 JOptionPane.showMessageDialog(null, "Please select a file to encrypt");

//			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.getContentPane().setBackground(new Color(255, 255, 102));
		f.setTitle("Image Operation");
		f.setSize(400,400 );
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Font font = new Font("Roboto",Font.BOLD,25);
		//creating button
		JButton btnSelectImage = new JButton();
		btnSelectImage.setBounds(90, 190, 207, 41);
		btnSelectImage.setText("Select Image");
		btnSelectImage.setFont(new Font("DengXian", Font.BOLD, 23));
		
		
		
		//creating textfield
		
		JTextField textfield = new JTextField("Enter the value");
		textfield.setBounds(102, 92, 187, 39);
		textfield.addFocusListener(new FocusListener() {
				
			@Override
			public void focusLost(FocusEvent e) {
			
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				textfield.setText("");
				
				
			}
		});
		 textfield.setFont(font);
		 
		 btnSelectImage.addActionListener(e->{
			 
				System.out.println("Button Clicked");
				try {
				String text = textfield.getText(); 
				int temp = Integer.parseInt(text);
				operate(temp);
				}catch(Exception r) {
					 JOptionPane.showMessageDialog(null, "Enter only numeric value");
				}
				
			
			});
		f.getContentPane().setLayout(null);
		
		JLabel lblEnterTheKey = new JLabel();
		lblEnterTheKey.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEnterTheKey.setBounds(132, 41, 187, 14);
		lblEnterTheKey.setText("Enter the value");
		f.getContentPane().add(lblEnterTheKey);
		f.getContentPane().add(textfield);
		f.getContentPane().add(btnSelectImage);
	
		
		
		
		
		f.setVisible(true);

	}

}
