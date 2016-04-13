
import com.sun.glass.events.KeyEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Form5 extends javax.swing.JFrame {

    
    public Form5() {
        initComponents();
        
        
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sh = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        d = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SHORTEST PATH");

        sh.setEditable(false);
        sh.setBackground(new java.awt.Color(204, 204, 204));
        sh.setFont(new java.awt.Font("Monotype Corsiva", 3, 20)); // NOI18N
        sh.setForeground(new java.awt.Color(0, 153, 51));
        sh.setBorder(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel1.setText("Select the destination router");

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setText("Compute");
        jButton1.setPreferredSize(new java.awt.Dimension(103, 25));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton2.setText("Main Menu");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/short-path.jpg"))); // NOI18N

        d.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        d.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        d.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(d, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                        .addGap(10, 10, 10)))
                .addComponent(sh, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(d, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(sh, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                    link page=new link(); 
                    page.setVisible(true);
                    this.setVisible(false);        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        int destinationRouter = 0;
        try{
        if(d.getText().equals("")){
                
                System.out.println("Blank");
        }
            destinationRouter= Integer.parseInt(d.getText());
            if (destinationRouter <= 0 || destinationRouter > Fram3.b) {
                                         JOptionPane.showMessageDialog(this, "Invalid input : Destination Router number is between 1 and size of matrix","Error", JOptionPane.ERROR_MESSAGE);         
                                         d.setText("");
                            }
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Invalid Input","WRONG CHOICE", JOptionPane.OK_CANCEL_OPTION);
                d.setText("");
            }
        

				// coding is based on assumption destinationRouter index
				// 0,1,2.., not 1,2,3
				destinationRouter = destinationRouter - 1;

		

				// finding shortest path and cost
				printPathandCost(destinationRouter);
        try {
            sh.read(new FileReader("temp2.txt"), "here's a description of the file");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Form5.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Form5.class.getName()).log(Level.SEVERE, null, ex);
        }
        d.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void dKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dKeyPressed
        
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
        if(d.getText().equals("")){
               
                System.out.println("Blank");
        }
        int destinationRouter = 0;
        try{
            destinationRouter= Integer.parseInt(d.getText());
            if (destinationRouter <= 0 || destinationRouter > Fram3.b) {
                                         JOptionPane.showMessageDialog(this, "Invalid input : Destination Router number is between 1 and size of matrix","Error", JOptionPane.ERROR_MESSAGE);         
                                         d.setText("");
            }
        }
            catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Invalid Input","WRONG CHOICE", JOptionPane.OK_CANCEL_OPTION);
                d.setText("");
            }
                            

				// coding is based on assumption destinationRouter index
				// 0,1,2.., not 1,2,3
				destinationRouter = destinationRouter - 1;

		

				// finding shortest path and cost
				printPathandCost(destinationRouter);
        try {
            sh.read(new FileReader("temp2.txt"), "here's a description of the file");
// TODO add your handling code here:
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Form5.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Form5.class.getName()).log(Level.SEVERE, null, ex);
        }
        d.setText("");
        }
    }//GEN-LAST:event_dKeyPressed

    
    public static void printPathandCost(int destinationRouter) {

		int lestCost = 0;
		int currRouter = Fram3.srcRtr;
		int findRouter = 0;
		Stack lifo = new Stack();
		if (Fram3.upPar.get(destinationRouter) == currRouter) {
			lestCost = lestCost + Fram3.mat[currRouter][destinationRouter];
			lifo.push(destinationRouter);

		} else {
			if (Fram3.upPar.get(destinationRouter) == -1) {
				// skip
			} else {
				int i = 0;
				findRouter = destinationRouter;
				int currSource;
				while (i != 1) {

					lifo.push(findRouter);
					currSource = Fram3.upPar.get(findRouter);
					lestCost = lestCost + Fram3.mat[currSource][findRouter];

					if (Fram3.upPar.get(currSource) == currRouter) {
						lestCost = lestCost + Fram3.mat[currRouter][currSource];
						lifo.push(currSource);
						i = 1;
					} else {
						findRouter = currSource;

					}

				}

			}

		}

		lifo.push(currRouter);
                PrintWriter writer1=null;
        try {
            writer1 = new PrintWriter("temp2.txt", "UTF-8");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Form5.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Form5.class.getName()).log(Level.SEVERE, null, ex);
        }
		
                writer1.print("\n\tThe shortest path from " + "\n\t" + "the router "
				+ (Fram3.srcRtr + 1) + " to router " + (destinationRouter + 1)
				+ " is : ");

		if (lifo.size() == 1) {
			
                        writer1.print("NO PATH");
		} else {
                        

			while (!lifo.empty()) {
				int x = (Integer) lifo.pop();
				x++;
				
                                writer1.print(x);
				if (!lifo.empty())
					
                                        writer1.print('-');
			}
                        writer1.print("\n");
		}
		
                writer1.print("\n");
                writer1.print("\tThe total cost is: " + lestCost);
                writer1.close();

	}
    
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
            java.util.logging.Logger.getLogger(Form5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form5().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField d;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField sh;
    // End of variables declaration//GEN-END:variables
}
