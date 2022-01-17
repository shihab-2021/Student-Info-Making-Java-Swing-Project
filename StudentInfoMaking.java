import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.awt.*;

class StudentInfoMaking extends JFrame implements ActionListener {
    private Container c;
    private JLabel headingLabel, titleLabel, fnLabel, lnLabel, phoneLabel, gpaLabel;
    private JTable table;
    private JTextField fnTf, lnTf, phoneTf, gpaTf;
    private JButton addButton, updateButton, deleteButton, clearButton;
    private Font f1, f2;
    private DefaultTableModel model;
    private JScrollPane scroll;

    private String[] columns = {"First name", "Last name", "Phone number", "GPA"};
    private String[] rows = new String[4];

    StudentInfoMaking(){
        initComponents();
    }
    public void initComponents(){
        Color hsb = new Color(204, 204, 255);
        f1 = new Font("Tahoma", Font.BOLD, 25);
        f2 = new Font("Tahoma", Font.BOLD, 16);
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(hsb);

        headingLabel = new JLabel("Student Information Taking");
        headingLabel.setBounds(200, 20, 350, 30);
        headingLabel.setFont(f1);
        c.add(headingLabel);

        fnLabel = new JLabel("First Name : ");
        fnLabel.setBounds(30, 80, 140, 30);
        fnLabel.setFont(f2);
        c.add(fnLabel);

        fnTf = new JTextField();
        fnTf.setBounds(140, 80,  200, 30);
        fnTf.setFont(f2);
        c.add(fnTf);

        addButton = new JButton("Add");
        addButton.setBounds(400, 80, 100, 30);
        addButton.setFont(f2);
        c.add(addButton);

        lnLabel = new JLabel("Last Name : ");
        lnLabel.setBounds(30, 130, 140, 30);
        lnLabel.setFont(f2);
        c.add(lnLabel);

        lnTf = new JTextField();
        lnTf.setBounds(140, 130, 200, 30);
        lnTf.setFont(f2);
        c.add(lnTf);

        updateButton = new JButton("Update");
        updateButton.setBounds(400, 130, 100, 30);
        updateButton.setFont(f2);
        c.add(updateButton);

        phoneLabel = new JLabel("Phone : ");
        phoneLabel.setBounds(30, 180, 140, 30);
        phoneLabel.setFont(f2);
        c.add(phoneLabel);

        phoneTf = new JTextField();
        phoneTf.setBounds(140, 180, 200, 30);
        phoneTf.setFont(f2);
        c.add(phoneTf);

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(400, 180, 100, 30);
        deleteButton.setFont(f2);
        c.add(deleteButton);

        gpaLabel = new JLabel("GPA : ");
        gpaLabel.setBounds(30, 230, 140, 30);
        gpaLabel.setFont(f2);
        c.add(gpaLabel);

        gpaTf = new JTextField();
        gpaTf.setBounds(140, 230, 200, 30);
        gpaTf.setFont(f2);
        c.add(gpaTf);

        clearButton = new JButton("Clear");
        clearButton.setBounds(400, 230, 100, 30);
        clearButton.setFont(f2);
        c.add(clearButton);
        
        titleLabel = new JLabel("Student Details Table :");
        titleLabel.setBounds(30, 300, 200, 30);
        titleLabel.setFont(f2);
        c.add(titleLabel);

        table = new JTable();
        
        model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        table.setModel(model);
        table.setFont(f2);
        table.setSelectionBackground(Color.CYAN);
        table.setBackground(Color.white);
        table.setRowHeight(30);

        scroll = new JScrollPane(table);
        scroll.setBounds(30, 350, 700, 250);
        c.add(scroll);

        addButton.addActionListener(this);
        clearButton.addActionListener(this);
        deleteButton.addActionListener(this);
        updateButton.addActionListener(this);

        table.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                int numberOfRow = table.getSelectedRow();

                String f_name = model.getValueAt(numberOfRow, 0).toString();
                String l_name = model.getValueAt(numberOfRow, 1).toString();
                String phone = model.getValueAt(numberOfRow, 2).toString();
                String gpa = model.getValueAt(numberOfRow, 3).toString();

                fnTf.setText(f_name);
                lnTf.setText(l_name);
                phoneTf.setText(phone);
                gpaTf.setText(gpa);
            }
        });

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addButton){
            rows[0] = fnTf.getText();
            rows[1] = lnTf.getText();
            rows[2] = phoneTf.getText();
            rows[3] = gpaTf.getText();
            model.addRow(rows);
        }
        else if(e.getSource() == clearButton){
            fnTf.setText("");
            lnTf.setText("");
            phoneTf.setText("");
            gpaTf.setText("");
        }
        else if(e.getSource() == deleteButton){
            int numberOfRow = table.getSelectedRow();
            if(numberOfRow >= 0){
                model.removeRow(numberOfRow);
            }
            else{
                JOptionPane.showMessageDialog(null, "No row has been selected or no row exists!");
            }
        }
        else if(e.getSource() == updateButton){
            int numberOfRow = table.getSelectedRow();

            String f_name = fnTf.getText();
            String l_name = lnTf.getText();
            String phone = phoneTf.getText();
            String gpa = gpaTf.getText();

            model.setValueAt(f_name, numberOfRow, 0);
            model.setValueAt(l_name, numberOfRow, 1);
            model.setValueAt(phone, numberOfRow, 2);
            model.setValueAt(gpa, numberOfRow, 3);
        }
        
    }

    public static void main(String[] args){
        StudentInfoMaking frame = new StudentInfoMaking();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(780, 690);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Student Information Making");
    }
}