/*
 * Main.java
 *
 * Created on 6. červenec 2007, 15:37
 */

package esmska;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.AbstractListModel;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import operators.Operator;
import operators.OperatorEnum;

/**
 *
 * @author  ripper
 */
public class Main extends javax.swing.JFrame {
    
    private Action quitAction = new QuitAction();
    private Action sendAction = new SendAction();
    private Action smsQueuePauseAction = new SMSQueuePauseAction();
    private Action deleteSMSAction = new DeleteSMSAction();
    private Action editSMSAction = new EditSMSAction();
    private JFrame aboutFrame;
    
    /** actual queue of sms's */
    private ArrayList<SMS> smsQueue = new ArrayList<SMS>();
    private SMSSender smsSender = new SMSSender(smsQueue, this);
    
    /** Creates new form Main */
    public Main() {
        //set program icon
        this.setIconImage(new ImageIcon(getClass().getResource("resources/esmska.png")).getImage());
        
        initComponents();
        deleteSMSAction.setEnabled(false);
        editSMSAction.setEnabled(false);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        mainPanel = new javax.swing.JPanel();
        smsNumberTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        smsTextArea = new javax.swing.JTextArea();
        sendButton = new javax.swing.JButton();
        operatorComboBox = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        smsQueueList = new javax.swing.JList();
        pauseButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        senderNumberTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        senderNameTextField = new javax.swing.JTextField();
        statusPanel = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        statusMessageLabel = new javax.swing.JLabel();
        statusAnimationLabel = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Esmska");
        smsNumberTextField.setColumns(9);
        smsNumberTextField.setInputVerifier(new InputVerifier() {
            public boolean verify(JComponent input) {
                JTextField tf = (JTextField) input;
                if (tf.getText().length() != 9)
                return false;
                for (Character c : tf.getText().toCharArray()) {
                    if (!Character.isDigit(c))
                    return false;
                }
                return true;
            }
        });
        smsNumberTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                smsNumberTextFieldKeyReleased(evt);
            }
        });

        jLabel1.setText("+420");

        smsTextArea.setColumns(20);
        smsTextArea.setRows(5);
        jScrollPane1.setViewportView(smsTextArea);

        sendButton.setAction(sendAction);

        operatorComboBox.setModel(new DefaultComboBoxModel(OperatorEnum.getAsList().toArray()));

        smsQueueList.setModel(new SMSQueueListModel());
        smsQueueList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                smsQueueListValueChanged(evt);
            }
        });

        jScrollPane2.setViewportView(smsQueueList);

        pauseButton.setAction(smsQueuePauseAction);

        deleteButton.setAction(deleteSMSAction);

        editButton.setAction(editSMSAction);

        jLabel2.setText("+420");

        senderNumberTextField.setColumns(9);
        senderNumberTextField.setInputVerifier(smsNumberTextField.getInputVerifier());

        jLabel3.setText("Odesilatel");

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(smsNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(operatorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(sendButton)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(senderNameTextField))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(senderNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(88, 88, 88)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(editButton)
                            .addComponent(deleteButton)))
                    .addComponent(pauseButton))
                .addGap(68, 68, 68))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(smsNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(operatorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(sendButton))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(deleteButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editButton))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pauseButton)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(senderNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(senderNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        statusMessageLabel.setText("V\u00edtejte");

        statusAnimationLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/esmska/resources/task-idle.png")));

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addComponent(statusMessageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 568, Short.MAX_VALUE)
                .addComponent(statusAnimationLabel))
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusMessageLabel)
                    .addComponent(statusAnimationLabel)))
        );

        jMenu1.setText("Program");
        aboutMenuItem.setText("O programu");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });

        jMenu1.add(aboutMenuItem);

        exitMenuItem.setAction(quitAction);
        jMenu1.add(exitMenuItem);

        menuBar.add(jMenu1);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statusPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        if (aboutFrame == null)
            aboutFrame = new AboutFrame();
        aboutFrame.setVisible(true);
    }//GEN-LAST:event_aboutMenuItemActionPerformed
    
    private void smsQueueListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_smsQueueListValueChanged
        if (!evt.getValueIsAdjusting()) {
            deleteSMSAction.setEnabled(smsQueueList.getModel().getSize() != 0
                    && smsQueueList.getSelectedIndices().length != 0);
            editSMSAction.setEnabled(smsQueueList.getModel().getSize() != 0
                    && smsQueueList.getSelectedIndices().length == 1);
        }
    }//GEN-LAST:event_smsQueueListValueChanged
    
    private void smsNumberTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_smsNumberTextFieldKeyReleased
        boolean ok = smsNumberTextField.getInputVerifier().verify(smsNumberTextField);
        if (!ok)
            smsNumberTextField.setBackground(Color.RED);
        else
            smsNumberTextField.setBackground(Color.GREEN);
    }//GEN-LAST:event_smsNumberTextFieldKeyReleased
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //set native L&F
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            Logger.getLogger("global").log(Level.SEVERE, "Error setting L&F", ex);
        }
        
        //start main frame
        java.awt.EventQueue.invokeLater(new java.lang.Runnable() {
            public void run() {
                new esmska.Main().setVisible(true);
            }
        });
    }
    
    public void printStatusMessage(String message) {
        statusMessageLabel.setText(message);
    }
    
    public void setTaskRunning(boolean b) {
        if (b == false)
            statusAnimationLabel.setIcon(new ImageIcon(getClass().getResource("resources/task-idle.png")));
        else
            statusAnimationLabel.setIcon(new ImageIcon(getClass().getResource("resources/task-busy.gif")));
    }
    
    public void smsQueueChanged() {
        ((SMSQueueListModel)smsQueueList.getModel()).fireContentsChanged(
                smsQueueList.getModel(), 0, smsQueue.size());
        smsQueueListValueChanged(new ListSelectionEvent(
                smsQueueList,0,smsQueueList.getModel().getSize(),false));
    }
    
    public void pauseSMSQueue() {
        smsQueuePauseAction.actionPerformed(null);
    }
    
    /** Action to send sms to queue */
    private class SendAction extends AbstractAction {
        public SendAction() {
            super("Poslat");
        }
        public void actionPerformed(ActionEvent e) {
            SMS sms = new SMS();
            sms.setNumber(smsNumberTextField.getText());
            sms.setText(smsTextArea.getText());
            sms.setOperator((Operator)operatorComboBox.getSelectedItem());
            sms.setSenderNumber(senderNumberTextField.getText());
            sms.setSenderName(senderNameTextField.getText());
            
            smsQueue.add(sms);
            smsQueueChanged();
            smsSender.announceNewSMS();
            
            smsTextArea.setText(null);
        }
    }
    
    /** pause/unpause the sms queue */
    private class SMSQueuePauseAction extends AbstractAction {
        private boolean makePause = true;
        public SMSQueuePauseAction() {
            super("Zastavit");
        }
        public void actionPerformed(ActionEvent e) {
            if (makePause) {
                smsSender.setPaused(true);
                this.putValue(AbstractAction.NAME,"Pokračovat");
            } else {
                smsSender.setPaused(false);
                this.putValue(AbstractAction.NAME,"Zastavit");
            }
            makePause = !makePause;
        }
    }
    
    /** erase sms from queue list */
    private class DeleteSMSAction extends AbstractAction {
        public DeleteSMSAction() {
            super("Smazat");
        }
        public void actionPerformed(ActionEvent e) {
            Object[] smsArray = smsQueueList.getSelectedValues();
            for (Object o : smsArray) {
                SMS sms = (SMS) o;
                smsQueue.remove(sms);
            }
            smsQueueChanged();
        }
    }
    
    /** action to quit the program */
    private class QuitAction extends AbstractAction {
        public QuitAction() {
            super("Ukončit");
        }
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
    
    /** edit sms from queue */
    private class EditSMSAction extends AbstractAction {
        public EditSMSAction() {
            super("Upravit");
        }
        public void actionPerformed(ActionEvent e) {
            SMS sms = (SMS) smsQueueList.getSelectedValue();
            if (sms == null)
                return;
            smsNumberTextField.setText(sms.getNumber());
            smsTextArea.setText(sms.getText());
            operatorComboBox.setSelectedItem(sms.getOperator());
            senderNameTextField.setText(sms.getSenderName());
            senderNumberTextField.setText(sms.getSenderNumber());
            smsQueue.remove(sms);
            smsQueueChanged();
        }
    }
    
    /** Model for SMSQueueList */
    private class SMSQueueListModel extends AbstractListModel {
        public Object getElementAt(int index) {
            return smsQueue.get(index);
        }
        public int getSize() {
            return smsQueue.size();
        }
        
        protected void fireIntervalRemoved(Object source, int index0, int index1) {
            super.fireIntervalRemoved(source, index0, index1);
        }
        
        protected void fireIntervalAdded(Object source, int index0, int index1) {
            super.fireIntervalAdded(source, index0, index1);
        }
        
        protected void fireContentsChanged(Object source, int index0, int index1) {
            super.fireContentsChanged(source, index0, index1);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JComboBox operatorComboBox;
    private javax.swing.JButton pauseButton;
    private javax.swing.JButton sendButton;
    private javax.swing.JTextField senderNameTextField;
    private javax.swing.JTextField senderNumberTextField;
    private javax.swing.JTextField smsNumberTextField;
    private javax.swing.JList smsQueueList;
    private javax.swing.JTextArea smsTextArea;
    private javax.swing.JLabel statusAnimationLabel;
    private javax.swing.JLabel statusMessageLabel;
    private javax.swing.JPanel statusPanel;
    // End of variables declaration//GEN-END:variables
}