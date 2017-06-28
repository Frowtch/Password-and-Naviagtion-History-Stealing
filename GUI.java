package project;

import java.util.*;

import java.awt.*;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.*;

import java.io.*;

import com.jgoodies.forms.factories.*;

import com.jgoodies.forms.layout.*;

import java.awt.event.MouseEvent;


import java.awt.event.MouseListener;

import javax.swing.filechooser.FileNameExtensionFilter;

/*

* Created by JFormDesigner on Sun Jun 12 21:28:15 UTC 2016

*/

/**

* @author Marouane Talib

*/

public class toolbox extends JFrame implements ActionListener {

public static void main(String[] args){

toolbox home = new toolbox();

home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

home.setVisible(true);

}

private JLabel label1;

private ButtonGroup group;

private JRadioButton radioButton1;

private JRadioButton radioButton2;

private JRadioButton radioButton3;

private JRadioButton radioButton4;

private JButton button1;

private TextField chosenfile;

private TextField chosenfile2;

private JFileChooser filechooser;

private FileNameExtensionFilter filter;


public toolbox() {

initComponents();

}

private void initComponents() {

// JFormDesigner - Component initialization - DO NOT MODIFY //GEN-
BEGIN:initComponents

// Generated using JFormDesigner Evaluation license - Marouane Talib

label1 = new JLabel();

group = new ButtonGroup();

radioButton1 = new JRadioButton();

radioButton2 = new JRadioButton();

radioButton3 = new JRadioButton();

radioButton4 = new JRadioButton();

button1 = new JButton();

chosenfile = new TextField();

chosenfile2 = new TextField();

filechooser = new JFileChooser();

filter = new FileNameExtensionFilter("PDF Documents", "pdf");

filechooser.setFileFilter(filter);

group.add(radioButton1);

group.add(radioButton2);

group.add(radioButton3);

group.add(radioButton4);


button1.addActionListener(this);

radioButton1.addActionListener(this);

radioButton2.addActionListener(this);

radioButton3.addActionListener(this);

radioButton4.addActionListener(this);

chosenfile.addMouseListener(new MouseListener() {

@Override

public void mouseClicked(MouseEvent e) {

Component contentPane = getContentPane();

int returnVal = filechooser.showOpenDialog(contentPane);



chosenfile.setText(filechooser.getSelectedFile().getAbsolutePath());

}

@Override

public void mousePressed(MouseEvent e) {

}

@Override

public void mouseReleased(MouseEvent e) {

}

@Override

public void mouseEntered(MouseEvent e) {



}

@Override

public void mouseExited(MouseEvent e) {

}


});

//======== this ========

Container contentPane = getContentPane();

contentPane.setLayout(new FormLayout(

"16*(default, $lcgap), default",

"16*(default, $lgap), default"));

//---- label1 ----

label1.setText("Penetration testing scripts:");

contentPane.add(label1, CC.xy(3, 3));

//---- radioButton1 ----

radioButton1.setText("Passwords");

contentPane.add(radioButton1, CC.xywh(5, 7, 21, 1));

//---- radioButton2 ----

radioButton2.setText("Navigation history");

contentPane.add(radioButton2, CC.xy(5, 11));

//---- radioButton3 ----

radioButton3.setText("Make PDF");

contentPane.add(radioButton3, CC.xy(5, 15));

//---- radioButton4 ----

radioButton4.setText("Scan PDF");

contentPane.add(radioButton4, CC.xy(5, 19));



//---- FileChooser ----

contentPane.add(chosenfile, CC.xy(5, 21));

contentPane.add(chosenfile2, CC.xy(21, 15));


//---- button1 ----

button1.setText("Run");

contentPane.add(button1, CC.xy(21, 21));



// JFormDesigner - End of component initialization //GEN-
END:initComponents

}

public void actionPerformed(ActionEvent e) {

String selected = getSelectedButtonText(group);

if(e.getSource() == button1) {

switch(selected) {

case "Passwords" :

try {

runPythonScript("C:\\Users\\ACER V

Nitro\\Desktop\\Yassir\\Python Stuffs\\passes.py", false);

}

catch(IOException ioe) {

ioe.printStackTrace();

}

break;

case "Navigation history" :

try {

runPythonScript("C:\\Users\\ACER V

Nitro\\Desktop\\Yassir\\Python Stuffs\\HistoryRevisited.py", false);

}

catch(IOException ioe) {


ioe.printStackTrace();

}

break;

case "Make PDF" :

try {

runPythonScript("C:\\Users\\ACER V

Nitro\\Desktop\\Yassir\\Python Stuffs\\make-pdf-javascript.py", true);

}

catch(IOException ioe) {

ioe.printStackTrace();

}

break;

case "Scan PDF" :

try {

runPythonScript("C:\\Users\\ACER V

Nitro\\Desktop\\Yassir\\Python Stuffs\\pdfid.py", true);

}

catch(IOException ioe) {

ioe.printStackTrace();

}

break;

}

}

if(e.getSource() == radioButton4) {

chosenfile.setVisible(true);

chosenfile2.setVisible(false);


}

if(e.getSource()== radioButton3) {

chosenfile2.setVisible(true);

chosenfile.setVisible(false);

}



if(e.getSource()==radioButton1 || e.getSource()==radioButton2) {

chosenfile.setVisible(false);

chosenfile2.setVisible(false);

}



}

public String getSelectedButtonText(ButtonGroup buttonGroup) {

for (Enumeration<AbstractButton> buttons =

buttonGroup.getElements(); buttons.hasMoreElements();) {

AbstractButton button = buttons.nextElement();

if (button.isSelected()) {

return button.getText();

}

}

return null;

}


public void runPythonScript(String pythonScriptPath, Boolean hasArg) throws

IOException{

// set up the command and parameter

String[] cmd;

if(!hasArg) {

cmd = new String[2];

cmd[0] = "C:\\Program Files (x86)\\Python\\python.exe";

cmd[1] = pythonScriptPath;

}

else {

cmd = new String[3];

cmd[0] = "C:\\Program Files (x86)\\Python\\python.exe";

cmd[1] = pythonScriptPath;

if(getSelectedButtonText(group)=="Make PDF") {

cmd[2] = chosenfile2.getText();

}

if(getSelectedButtonText(group)=="Scan PDF") {

cmd[2] = chosenfile.getText();

}

}



// create runtime to execute external command

Runtime rt = Runtime.getRuntime();

Process pr = rt.exec(cmd);


// retrieve output from python script

BufferedReader bfr = new BufferedReader(new

InputStreamReader(pr.getInputStream()));

String line;

while((line = bfr.readLine()) != null){

// display each output line form python script

System.out.println(line);

}

}

// JFormDesigner - Variables declaration - DO NOT MODIFY //GEN-
BEGIN:variables

// Generated using JFormDesigner Evaluation license - Marouane Talib

// JFormDesigner - End of variables declaration //GEN-END:variables

}
