import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class TeacherPortal extends JFrame implements ActionListener {

    JTextField tfname, tffname, tfaddress, tfphone, tfemail, tfx, tfxii, tfaadhar;
    JLabel labelempId;
    JComboBox cbcourse, cbbranch;
    JButton submit, cancel;

    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L) + 1000L);

    TeacherPortal() {

        setSize(800, 600);
        setLocation(300, 50);

        setLayout(null);

        JLabel heading = new JLabel("New Teacher Details");
        heading.setBounds(300, 30, 500, 50);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 150, 100, 30);
        lblname.setForeground(Color.WHITE);
        lblname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        add(tfname);

        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(400, 150, 200, 30);
        lblfname.setForeground(Color.WHITE);
        lblfname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblfname);

        tffname = new JTextField();
        tffname.setBounds(600, 150, 150, 30);
        add(tffname);

        JLabel lblempId = new JLabel("Employee Id");
        lblempId.setBounds(50, 200, 200, 30);
        lblempId.setForeground(Color.WHITE);
        lblempId.setFont(new Font("serif", Font.BOLD, 20));
        add(lblempId);

        labelempId = new JLabel("101" + first4);
        labelempId.setBounds(200, 200, 200, 30);
        labelempId.setForeground(Color.WHITE);
        labelempId.setFont(new Font("serif", Font.BOLD, 20));
        add(labelempId);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50, 260, 200, 30);
        lbladdress.setForeground(Color.WHITE);
        lbladdress.setFont(new Font("serif", Font.BOLD, 20));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200, 260, 150, 30);
        add(tfaddress);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(400, 200, 200, 30);
        lblphone.setForeground(Color.WHITE);
        lblphone.setFont(new Font("serif", Font.BOLD, 20));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(600, 200, 150, 30);
        add(tfphone);

        JLabel lblemail = new JLabel("Email Id");
        lblemail.setBounds(50, 320, 200, 30);
        lblemail.setForeground(Color.WHITE);
        lblemail.setFont(new Font("serif", Font.BOLD, 20));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200, 320, 150, 30);
        add(tfemail);

        JLabel cnic = new JLabel("CNIC Number");
        cnic.setBounds(400, 260, 200, 30);
        cnic.setForeground(Color.WHITE);
        cnic.setFont(new Font("serif", Font.BOLD, 20));
        add(cnic);

        tfaadhar = new JTextField();
        tfaadhar.setBounds(600, 260, 150, 30);
        add(tfaadhar);

        JLabel qualification = new JLabel("Qualification");
        qualification.setBounds(400, 320, 200, 30);
        qualification.setForeground(Color.WHITE);
        qualification.setFont(new Font("serif", Font.BOLD, 20));
        add(qualification);

        String course[] = {"B.Tech", "BBA", "BCA", "Bsc", "Msc", "MBA", "MCA", "MCom", "MA", "BA"};
        cbcourse = new JComboBox(course);
        cbcourse.setBounds(600, 320, 150, 30);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);

        submit = new JButton("Submit");
        submit.setBounds(230, 480, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(420, 480, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        getContentPane().setBackground(Color.GRAY);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String name = tfname.getText();
            String fname = tffname.getText();
            String rollno = labelempId.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String cnic = tfaadhar.getText();
            String qualification = (String) cbcourse.getSelectedItem();

            try {

                String query = "insert into teacher_info values('" + name + "', '" + fname + "', '" + rollno + "', '" + address + "', '" + phone + "', '" + email + "', '" + cnic + "', '" + qualification + "')";

                ConnectToMySql con = new ConnectToMySql();
                con.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Teacher Details Inserted Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
}
