package Group_K;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyFrame extends JFrame implements ActionListener {
    JLabel title, nameLabel, mobileLabel, genderLabel, dobLabel, addressLabel, resultLabel;
    JTextField nameField, mobileField;
    JRadioButton maleBtn, femaleBtn;
    JComboBox<String> day, month, year;
    JTextArea addressArea, outputArea;
    JCheckBox terms;
    JButton submitBtn, resetBtn;

    public MyFrame() {
        setTitle("Registration Form");
        setBounds(150,150,800,500); //instead of using 'setSize', 'setLocation', we combined them into 'setBounds'
        setResizable(false); //The window size can't be changed
        setDefaultCloseOperation(EXIT_ON_CLOSE); //The program will exit when the window is closed

        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //prints the title of form
        title = new JLabel("Registration Form");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBounds(300,25,300,25);
        add(title);

        //Display the label "Name"
        nameLabel = new JLabel("Name ");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        nameLabel.setBounds(80,80,100,20);
        add(nameLabel);

        //Text field for "Name" Label
        nameField = new JTextField();
        nameField.setFont(new Font("Arial", Font.PLAIN, 14));
        nameField.setBounds(180,80,250,25);
        add(nameField);

        //Display the label "Mobile"
        mobileLabel = new JLabel("Mobile ");
        mobileLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        mobileLabel.setBounds(80,120,100,20);
        add(mobileLabel);

        //Text field for "Mobile" Label
        mobileField = new JTextField();
        mobileField.setFont(new Font("Arial", Font.PLAIN, 14));
        mobileField.setBounds(180,120,250,25);
        add(mobileField);

        //Display the label "Gender"
        genderLabel = new JLabel("Gender");
        genderLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        genderLabel.setBounds(80,160,100,20);
        add(genderLabel);

        //Radio button for "Male"
        maleBtn = new JRadioButton("Male");
        maleBtn.setFont(new Font("Arial", Font.PLAIN, 14));
        maleBtn.setBounds(180,160,100,20);

        //Radio button for "Female"
        femaleBtn = new JRadioButton("Female");
        femaleBtn.setFont(new Font("Arial", Font.PLAIN, 14));
        femaleBtn.setBounds(280,160,100,20);

        //Group the radio buttons so that only one can be selected at a time
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleBtn);
        genderGroup.add(femaleBtn);
        add(maleBtn);
        add(femaleBtn);

        //Display the label "DOB"
        dobLabel = new JLabel("DOB");
        dobLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        dobLabel.setBounds(80, 200, 100, 20);
        add(dobLabel);

        //Creating days for ComboBox of "Day". This creates an array of strings from 1 to 31 which represents the days of a month.
        String[] days = new String[31];
        for (int i = 1; i <= 31; i++) {
            days[i - 1] = String.valueOf(i);
        }

        //Displays the Dropdown menu for "Day"
        day = new JComboBox<>(days);
        day.setFont(new Font("Arial", Font.PLAIN, 14));
        day.setBounds(180, 200, 60, 25);
        add(day);

        //Creating months for ComboBox of "Month". This creates an array of strings represents the months of a year.
        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};

        //Displays the Dropdown menu for "Month"
        month = new JComboBox<>(months);
        month.setFont(new Font("Arial", Font.PLAIN, 14));
        month.setBounds(250, 200, 100, 25);
        add(month);

        //Creating years for ComboBox of "Year". This creates an array of strings from 1900 to 2025. We choose 1900 as the starting year.
        String[] years = new String[51];
        for (int i = 0; i < 51; i++) {
            years[i] = String.valueOf(1975 + i);
        }

        //Displays the Dropdown menu for "Year"
        year = new JComboBox<>(years);
        year.setFont(new Font("Arial", Font.PLAIN, 14));
        year.setBounds(360, 200, 80, 25);
        add(year);

        //Display the label "Address"
        addressLabel = new JLabel("Address");
        addressLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        addressLabel.setBounds(80,240,100,20);
        add(addressLabel);

        //Text area for "Address" Label
        addressArea = new JTextArea();
        addressArea.setFont(new Font("Arial", Font.PLAIN, 14));
        addressArea.setBounds(180,240,250,80);
        addressArea.setWrapStyleWord(true); //This keeps the words without breaking in text area
        addressArea.setLineWrap(true); //This allows the text to wrap within the text area

        add(addressArea);

        //Checkbox for "Terms and Conditions"
        terms = new JCheckBox("Accept Terms and Conditions");
        terms.setFont(new Font("Arial", Font.PLAIN, 14));
        terms.setBounds(180, 330, 250, 20);
        add(terms);

        //Text area for output
        outputArea = new JTextArea();
        outputArea.setFont(new Font("Arial", Font.PLAIN, 14));
        outputArea.setBounds(480, 80, 250, 300);
        outputArea.setEditable(false); //This makes the text area non-editable
        outputArea.setWrapStyleWord(true);
        outputArea.setLineWrap(true);
        add(outputArea);

        //Button for "Submit"
        submitBtn = new JButton("Submit");
        submitBtn.setFont(new Font("Arial", Font.PLAIN, 14));
        submitBtn.setBounds(180, 380, 80, 20);
        add(submitBtn);

        //Button for "Reset"
        resetBtn = new JButton("Reset");
        resetBtn.setFont(new Font("Arial", Font.PLAIN, 14));
        resetBtn.setBounds(300, 380, 80, 20);
        add(resetBtn);

        //Display "Result" label
        resultLabel = new JLabel("");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 14));
        resultLabel.setBounds(80, 410, 400, 20);
        add(resultLabel);

        //Action listener for the "Submit" and "Reset" buttons
        submitBtn.addActionListener(this);
        resetBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitBtn) {
            String name = nameField.getText();
            String mobile = mobileField.getText();
            String gender = maleBtn.isSelected() ? "Male" : "Female";
            String dob = day.getSelectedItem()+"/"+month.getSelectedItem()+"/"+year.getSelectedItem();
            String address = addressArea.getText();

            if(name.isEmpty() || mobile.isEmpty() || address.isEmpty()){
                outputArea.setText("\nRegistration Failed...!!!");
                JOptionPane.showMessageDialog(this,"Please fill all the fields");
            } else if (!terms.isSelected()) {
                JOptionPane.showMessageDialog(this,"Please accept the Terms and Conditions");
            } else {
                outputArea.setText("Registration Successful...!!!\n\n" +
                                    "Name: " + name + "\n\n" +
                                    "Mobile: " + mobile + "\n\n" +
                                    "Gender: " + gender + "\n\n" +
                                    "DOB: " + dob + "\n\n" +
                                    "Address: " + address);
                JOptionPane.showMessageDialog(this, "Registration Successful");
            }
        } else if (e.getSource() == resetBtn){
            nameField.setText("");
            mobileField.setText("");
            maleBtn.setSelected(false);
            femaleBtn.setSelected(false);
            day.setSelectedIndex(0);
            month.setSelectedIndex(0);
            year.setSelectedIndex(0);
            addressArea.setText("");
            terms.setSelected(false);
            outputArea.setText("");
            resultLabel.setText("");
        }
    }

    public static void main (String[]args){
        MyFrame registrationForm = new MyFrame();
        registrationForm.setVisible(true);
    }
}