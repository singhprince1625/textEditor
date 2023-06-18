import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * textEditor
 */
public class textEditor implements ActionListener{
    JFrame frame;
    JMenuBar menuBar;
    JTextArea textArea;
    JMenu file, edit;
    JMenuItem newFile, open, save, cut, copy, paste, selectAll, close;
    static int x = 10;
    static int y = 10; 

    textEditor(){
        // initialize menuItems of file menu
        newFile = new JMenuItem("New");
        open = new JMenuItem("Open");
        save = new JMenuItem("Save");

        // initialize menuItems of edit menu
        cut = new JMenuItem("Cut");
        copy = new JMenuItem("Copy");
        paste = new JMenuItem("Paste");
        selectAll = new JMenuItem("SelectAll");
        close = new JMenuItem("Close");

        // adding the component of file menu with the Listener
        newFile.addActionListener(this);
        open.addActionListener(this);
        save.addActionListener(this);

        // adding the component of file menu with the Listener
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectAll.addActionListener(this);
        close.addActionListener(this);

        // initialize menu of menuBar
        file = new JMenu("File");
        edit = new JMenu("Edit");

        // adding menuItem in file menu
        file.add(newFile);
        file.add(open);
        file.add(save);

        // adding menuIten in edit menu
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll);
        edit.add(close);

        // initialize menuBar of textEditor
        menuBar = new JMenuBar();
         // Adding Menu in menuBar
        menuBar.add(file);
        menuBar.add(edit);

        // initialize textArea of textEditor
        textArea = new JTextArea();

        // initialize panel fo r adding scrollBAr
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        panel.setLayout(new BorderLayout(0, 0));

        panel.add(textArea, BorderLayout.CENTER);

        JScrollPane scrollPanel = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        panel.add(scrollPanel);
        // frame of testEditor
        frame = new JFrame();
        frame.setJMenuBar(menuBar);
        // frame.add(textArea);
        frame.add(panel);

        // frame properties
        x=x+5;
        y=y+5;
        frame.setTitle("Text Editor by Prince");
        frame.setBounds(x,y,600,400);
        frame.setVisible(true);
        frame.setLayout(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // defining  edit menuItem actionPerformed
        if(e.getSource()==cut){
            // using the predefine cut() function of JTextArea 
            textArea.cut();
        }
        
        if(e.getSource()==copy){
            // using the predefine copy() function of JTextArea 
            textArea.copy();
        }
        if(e.getSource()==paste){
            // using the predefine paste() function of JTextArea 
            textArea.paste();
        }
        if(e.getSource()==selectAll){
            // using the predefine seletAll() function of JTextArea
            textArea.selectAll();
        }
        if(e.getSource()==close){
            System.exit(0);
        }

    // defining  file menuItem actionPerformed
        if(e.getSource()==newFile){
            textEditor textEditor = new textEditor();
        }

        if(e.getSource()==open){
            JFileChooser fileChooser = new JFileChooser("D:");
            int chooseOptions = fileChooser.showOpenDialog(null);
            // if we clicked on open buttom
            if(chooseOptions==JFileChooser.APPROVE_OPTION){
                File file = fileChooser.getSelectedFile();
                String filePath = file.getPath();
                try {
                    FileReader fileReader = new FileReader(filePath);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    String st = "", stAll = "";

                    while ((st=bufferedReader.readLine())!=null) {
                        stAll+=st+"\n";
                    }
                    textArea.setText(stAll);
                    
                } catch (FileNotFoundException fileNotFoundException) {
                    // TODO: handle exception
                    fileNotFoundException.printStackTrace();
                } catch(IOException ioException){
                    ioException.printStackTrace();
                }
            }
        }

        if(e.getSource()==save){
            JFileChooser fileChooser = new JFileChooser("D:");
            int chooseOptions = fileChooser.showSaveDialog(null);
            if(chooseOptions==JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath()+".txt");
                try {
                    FileWriter fileWriter = new FileWriter(file);

                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    textArea.write(bufferedWriter);
                    bufferedWriter.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }


        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    

    public static void main(String[] args) {
        textEditor textEditor = new textEditor();
    }


}