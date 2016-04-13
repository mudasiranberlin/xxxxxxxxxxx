

import com.sun.glass.events.KeyEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;


public class Form4 extends javax.swing.JFrame {

        Fram3 f3=new Fram3();
        public static int val = 0;
        
    public Form4() {
        initComponents();
 
    }

    
    @SuppressWarnings("unchecked")
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        source = new javax.swing.JTextField();
        ceec = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ct = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CONNECTION TABLE");
        setPreferredSize(new java.awt.Dimension(824, 479));

        source.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        source.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        source.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                sourceKeyPressed(evt);
            }
        });

        ceec.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        ceec.setText("Select a source router:");

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setLabel("Compute");
        jButton1.setPreferredSize(new java.awt.Dimension(103, 25));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton2.setText("Main Menu");
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dijkstra.png"))); // NOI18N

        ct.setBackground(new java.awt.Color(204, 204, 204));
        ct.setColumns(20);
        ct.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        ct.setRows(5);
        jScrollPane1.setViewportView(ct);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addComponent(ceec)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(source, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ceec)
                            .addComponent(source, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                    link page=new link(); 
                    page.setVisible(true);
                    this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        
        try{
            if(source.getText().equals("")){
                
                System.out.println("Blank");
            }
            f3.srcRtr= Integer.parseInt(source.getText());
            if (f3.srcRtr <= 0 || f3.srcRtr > f3.b)
            {
                JOptionPane.showMessageDialog(this, "Invalid input : Source router number is between 1 and size of matrix","ERROR", JOptionPane.ERROR_MESSAGE);
                source.setText("");
            }
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Invalid Input","WRONG CHOICE", JOptionPane.OK_CANCEL_OPTION);
            source.setText("");
            }
        val = f3.srcRtr;
        

        f3.nSrc = 1;
        // coding is based on assumption routers index 0,1,2.., not
        // 1,2,3
        f3.srcRtr = f3.srcRtr - 1;
        // clearing all values for next iteration.
        f3.minValNextPos = 0;
        f3.minValNxt = 0;
        f3.listCurrVal.clear();
        f3.upPar.clear();
        f3.visitArr.clear();
        f3.intrArr.clear();
        // initializing current list array
        addGivenRow(f3.srcRtr);
        // make source node as visited
        f3.visitArr.add(f3.srcRtr);
        // initilize the parent list
        updateParentList(f3.srcRtr);
        // print the Connection table
        printConnectionTable(f3.srcRtr, f3.mat);

        try {
            ct.read(new FileReader("temp.txt"), "here's a description of the file");

            // TODO add your handling code here:
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Form4.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Form4.class.getName()).log(Level.SEVERE, null, ex);
        }
        source.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void sourceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sourceKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
                        
            try{
            if(source.getText().equals("")){
               
                System.out.println("Blank");
            }
            f3.srcRtr= Integer.parseInt(source.getText());
            if (f3.srcRtr <= 0 || f3.srcRtr > f3.b)
            {
                JOptionPane.showMessageDialog(this, "Invalid input : Source router number is between 1 and size of matrix","ERROR", JOptionPane.ERROR_MESSAGE);
                source.setText("");
            }
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Invalid Input","WRONG CHOICE", JOptionPane.OK_CANCEL_OPTION);
            source.setText("");
            }
               
            val = f3.srcRtr;
            

            

            f3.nSrc = 1;
            // coding is based on assumption routers index 0,1,2.., not
            // 1,2,3
            f3.srcRtr = f3.srcRtr - 1;
            // clearing all values for next iteration.
            f3.minValNextPos = 0;
            f3.minValNxt = 0;
            f3.listCurrVal.clear();
            f3.upPar.clear();
            f3.visitArr.clear();
            f3.intrArr.clear();
            // initializing current list array
            addGivenRow(f3.srcRtr);
            // make source node as visited
            f3.visitArr.add(f3.srcRtr);
            // initilize the parent list
            updateParentList(f3.srcRtr);
            // print the Connection table
            printConnectionTable(f3.srcRtr, f3.mat);

            try {
                ct.read(new FileReader("temp.txt"), "here's a description of the file");

                // TODO add your handling code here:
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Form4.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Form4.class.getName()).log(Level.SEVERE, null, ex);
            }
            source.setText("");
        }
    }//GEN-LAST:event_sourceKeyPressed

    /**
     * 
     * 
     * 
     * 
     * 
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Form4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form4().setVisible(true);
            }
        });
        
    }

    
      public static void addGivenRow(int sourceRouter) {
		for (int j = 0; j < Fram3.b; j++) {
			if (j == sourceRouter) {
				Fram3.listCurrVal.add(0);
			} else {
				Fram3.listCurrVal.add(1000);
			}
			
		}

	}
        
        
        public static void printConnectionTable(int sourceRouter, int[][] matrix) {

		// storing initial source
		Fram3.minValNextPos = sourceRouter;
		while (Fram3.visitArr.size() != Fram3.b) {
			
			findNeibours(Fram3.minValNextPos);
			findWeiAndUpdateList(Fram3.minValNextPos);
			findMinValInRow();
			setVisitedNodeInList();
			

		}
		connectionTableArray(sourceRouter);
		Fram3.getRes = 0;
		while (Fram3.getRes != 1) {
			printTableValues();
			checkInterfaceListZeros();
		}
		printTable();
	}
        
        
        public static void printTable() 
        {
		PrintWriter writer = null;
            try {
                writer = new PrintWriter("temp.txt", "UTF-8");
                writer.println("\tRouter "+ val +" Connection Table\n");
                writer.println("\n                DESTINATION" + "\t" + "                   INTERFACE");;
                writer.println("              =============" + "\t" + "                ============");
                
                for (int k = 0; k < Fram3.b; k++) 
                {
                    
                    writer.println("\n\t" + (k + 1) + "\t\t" + Fram3.intrArr.get(k));
                }
                
                 writer.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Form4.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(Form4.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                writer.close();
            }
	}

	// used in finding next node.
	public static void checkInterfaceListZeros() {
		if (Fram3.intrArr.contains(0)) {
			Fram3.getRes = 0;
		} else {
			Fram3.getRes = 1;
		}
	}

	// finding next node, from parentlist
	public static void printTableValues() {
		int number = 0;
		int i = 0;
		int checkNumber = 0;
		for (int m = 0; m < Fram3.b; m++) {
			if (Fram3.intrArr.get(m) == 0) {
				number = Fram3.upPar.get(m);

				i = 0;
				while (i != 1) {
					if (Fram3.intrArr.get(number) == (number + 1)) {
						Fram3.intrArr.remove(m);
						Fram3.intrArr.add(m, number + 1);
						i = 1;
					} else {

						number = Fram3.intrArr.get(number);
						if (number == 0) {
							Fram3.intrArr.remove(m);
							Fram3.intrArr.add(m, 0);
							i = 1;
						} else {
							number--;
						}
					}
				}

			}
		}

	}

	// used in finding next node from the parent list
	public static void connectionTableArray(int sourceRouter) {
		for (int k = 0; k < Fram3.b; k++) {
			if (sourceRouter == Fram3.upPar.get(k)) {
				Fram3.intrArr.add(k + 1);
			} else {
				if (-1 == Fram3.upPar.get(k))
					Fram3.intrArr.add(-1);
				else
					Fram3.intrArr.add(0);
			}
		}
		

	}
        
        public static void findWeiAndUpdateList(int minValNextRouterPosition) {
		int y = 0;

		int nextMin = 0;
		for (int j = 0; j < Fram3.neighLst.size(); j++) {
			y = Fram3.neighLst.get(j);

			nextMin = Fram3.mat[minValNextRouterPosition][y] + Fram3.minValNxt;

			if (nextMin < Fram3.listCurrVal.get(y)) {

				Fram3.listCurrVal.add(y, nextMin);
				Fram3.listCurrVal.remove(y + 1);
				Fram3.upPar.add(y, minValNextRouterPosition);
				Fram3.upPar.remove(y + 1);

			}

		}
		

	}

	// finding neibours of current node
	public static void findNeibours(int minValNextRouterPosition) {
		int x;
		Fram3.neighLst.clear();
		for (int j = 0; j < Fram3.b; j++) {
			x = Fram3.mat[minValNextRouterPosition][j];
			if (Fram3.visitArr.contains(j)) {
				// nothing , don't add the visited node;
			} else {
				if ((x != -1) && (x > 0)) {
					Fram3.neighLst.add(j);

				}

			}

		}
		
	}

	// finding next min value,position
	public static void findMinValInRow() {
		Integer i = 0;
		int min = 1000;
		for (Integer x : Fram3.listCurrVal) {

			if ((x != -1) && (x > 0)) {
				if (x <= min && !(Fram3.visitArr.contains(i))) {
					Fram3.minValNxt = x;
					Fram3.minValNextPos = i;
					min = x;
				}
			}
			i++;
		}

		

	}

	// adding visited node in list
	public static void setVisitedNodeInList() {
		Fram3.visitArr.add(Fram3.minValNextPos);
		

	}

        
        
	// parent list contain -1 initially
	public static void updateParentList(int sourceRouter) {
		for (int j = 0; j < Fram3.b; j++) {

			Fram3.upPar.add(-1);

			

		}

	}
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ceec;
    private javax.swing.JTextArea ct;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField source;
    // End of variables declaration//GEN-END:variables
}
