import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

class BankAcc {
    private double balance;

    public BankAcc(double initialBal){
        balance = initialBal;
    }

    public double getBalance(){
        return balance;
    }

    public void deposit(double amt){
        balance += amt;
    }

    public boolean withdraw(double amt){
        if(amt<=balance){
            balance -= amt;
            return true;
        }
        else{
            return false;
        }
    }
}

class ATMGUI extends JFrame implements ActionListener {
    private BankAcc acc;
    private JTextField balField;
    private JTextField amtField;
    private JTextArea outputArea;

    public ATMGUI (BankAcc acc){
        this.acc = acc;

        setTitle("ATM Machine");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,2));

        JLabel balLabel = new JLabel("Balance");
        balField =  new JTextField(Double.toString(acc.getBalance()));
        balField.setEditable(false);

        JLabel amtLabel = new JLabel("Amount");
        amtField = new JTextField();

        JButton checkBalButton = new JButton("Check Balance");
        checkBalButton.addActionListener(this);

        JButton depositButton = new JButton("Deposit");
        depositButton.addActionListener(this);

        JButton withdrawButton =  new JButton("Withdraw");
        withdrawButton.addActionListener(this);

        outputArea = new JTextArea();
        outputArea.setEditable(false);

        panel.add(balLabel);
        panel.add(balField);
        panel.add(amtLabel);
        panel.add(amtField);
        panel.add(checkBalButton);
        panel.add(depositButton);
        panel.add(withdrawButton);
        panel.add(outputArea);

        add(panel);

    }
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("Check Balance")){
            outputArea.setText("Your balance is : Rs . " + acc.getBalance());
        }
        else if (e.getActionCommand().equals("Deposit")){
            try {
                double amt =   Double.parseDouble(amtField.getText());
                if(amt > 0){
                    acc.deposit(amt);
                    balField.setText(Double.toString(acc.getBalance()));
                    outputArea.setText("Deposit Successful");
                }else {
                    outputArea.setText("Invalid deposit amount");
                }
            }
            catch(NumberFormatException ee){
                outputArea.setText("Invalid input . Please enter a valid amount");
            }
        }
        else if (e.getActionCommand().equals("Withdraw")){
            try{
                double amt = Double.parseDouble(amtField.getText());
                if(amt >0 && acc.withdraw(amt)) {
                    balField.setText(Double.toString(acc.getBalance()));
                    outputArea.setText("Withdrawl successful");
                } else {
                    outputArea.setText("Invalid withdrawl amount  or  insufficient balance");
                }
            }
            catch (NumberFormatException ee){
                outputArea.setText("Invalid input. Please enter valid amount");
            }
        }
    }
}


public class Task3_ATMgui {
    public static void main(String[] args) {
        BankAcc useracc = new BankAcc(1000.0);
        ATMGUI atmGUI = new ATMGUI(useracc);
        atmGUI.setVisible(true);

    }
}