
import com.sun.glass.events.KeyEvent;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class Fram3 extends javax.swing.JFrame {
    
    static int a, b;
	static Scanner iP = new Scanner(System.in);
	static int select;

	// Declarations of the variables
	static String fN;
	static int getRes;
	static int minValNxt;
	static int minValNextPos;
	static int srcRtr;
	static int usrBrk = 0;
	static int nSrc = 0;
	static int nMat = 0;

	// Variabe to keep track of visited nodes
	static ArrayList<Integer> visitArr = new ArrayList<Integer>();

	// keeping track of node values
	static ArrayList<Integer> listCurrVal = new ArrayList<Integer>();

	// keeping track of neighbour nodes
	static ArrayList<Integer> neighLst = new ArrayList<Integer>();

	// Parent Nodes
	static ArrayList<Integer> upPar = new ArrayList<Integer>();

	// Testing the array list
	static ArrayList<Integer> tstArrList = new ArrayList<Integer>();

	// Next Node Calculation
	static ArrayList<Integer> intrArr = new ArrayList<Integer>();

	// Matrix to store the input values
	static int[][] mat;
  public static int[][] readFile(String fileName) throws IOException {

		// SIze of the matrix
		String line = "";
		FileInputStream inputStream = new FileInputStream(fileName);
		Scanner scanner = new Scanner(inputStream);
		DataInputStream in = new DataInputStream(inputStream);
		BufferedReader bf = new BufferedReader(new InputStreamReader(in));

		line = bf.readLine();
		String[] getCountForSize = line.split(" ");
		int r = 0;
		for (int t = 0; t < getCountForSize.length; t++) {
			r++;
		}
		bf.close();

		
		int[][] matrixFilled = new int[r][r];

		

		String lineNum = "";
		FileInputStream inputStreamNum = new FileInputStream(fileName);
		Scanner scannerNum = new Scanner(inputStreamNum);
		DataInputStream inNum = new DataInputStream(inputStreamNum);
		BufferedReader bfNum = new BufferedReader(new InputStreamReader(inNum));

		int lineCount = 0;
		while ((lineNum = bfNum.readLine()) != null) {
			String[] numbers = lineNum.split(" ");
			a = 0;
			for (int i = 0; i < numbers.length; i++) {
				matrixFilled[lineCount][i] = Integer.parseInt(numbers[i]);
				a++;
			}
			b++;
			lineCount++;
		}
		bf.close();

		return matrixFilled;
	}
  
 
    
    
    public static void printArray(String fileName, int[][] matrix) {
		 

		for (int i = 0; i < a; i++) {
			for (int j = 0; j < b; j++) {
				
			}
			
		}
		
                
                
	}
    
    

    
    public Fram3() {
        initComponents();
        jLabel2.setVisible(false);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        pr1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SELECT A FILE");

        jLabel1.setFont(new java.awt.Font("Monotype Corsiva", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Input original network topology matix data file:");

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setText("Main Menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton2.setText("Browse");
        jButton2.setPreferredSize(new java.awt.Dimension(103, 25));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel2.setText("Review Original Topology Matrix:");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/open-file-icon.png"))); // NOI18N

        pr1.setEditable(false);
        pr1.setBackground(new java.awt.Color(204, 204, 204));
        pr1.setColumns(20);
        pr1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        pr1.setForeground(new java.awt.Color(51, 0, 204));
        pr1.setRows(5);
        jScrollPane2.setViewportView(pr1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 185, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        if(jTextField1.getText().equals("")){
            int selectedOption = JOptionPane.showConfirmDialog(this, "File Not Choosen ","CHOOSE FILE", JOptionPane.OK_CANCEL_OPTION);
            if (selectedOption == JOptionPane.CANCEL_OPTION) {
                this.dispose();
                JFrame f = new Fram3();
                f.setVisible(true);
            }
            if (selectedOption == JOptionPane.OK_OPTION){
                link page=new link(); 
                    page.setVisible(true);
                    this.setVisible(false); 
            }
        }
        if(!jTextField1.getText().equals("")){
        link page=new link(); 
                    page.setVisible(true);
                    this.setVisible(false); 
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JFileChooser chooser =  new JFileChooser();
        
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String filename = f.getAbsolutePath();
        jTextField1.setText(filename);
        
        nMat = 1;
        jLabel2.setVisible(true);
        try {

		mat = readFile(filename);
	} catch (Exception e) {
		System.err.print("\n Invalid input : Improper File Content ");
	    }
        
        try {
            pr1.read(new FileReader(filename), "here's a description of the file");
        } catch (IOException ex) {
            Logger.getLogger(Fram3.class.getName()).log(Level.SEVERE, null, ex);
        }
                             printArray(filename, mat);
                           
      
                             
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            String data = jTextField1.getText();
                
                                File f = new File(data);
				if (!f.exists()) {
                                    
                             System.err.print("\n Invalid input : Invalid Filename ");       
                            JOptionPane.showMessageDialog(this, "Incorrect file name","Error", JOptionPane.ERROR_MESSAGE);
                
				}

				nMat = 1;
				// the file is read
				try {

					mat = readFile(data);
				} catch (Exception e) {
					System.err.print("\n Invalid input : Improper File Content ");
					

				}  
                                
                               
        try {
            pr1.read(new FileReader(data), "here's a description of the file");
        } catch (IOException ex) {
            Logger.getLogger(Fram3.class.getName()).log(Level.SEVERE, null, ex);
        }
                             printArray(data, mat);
            
        }
    }//GEN-LAST:event_jTextField1KeyPressed

   
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Fram3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fram3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fram3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fram3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fram3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextArea pr1;
    // End of variables declaration//GEN-END:variables
}
