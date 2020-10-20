import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.util.LinkedList;
import java.util.List;

public class DictionaryApplication extends JFrame {
    private JPanel panel1 = new JPanel();
    private JButton searchButton = new JButton();
    private JButton historyButton = new JButton();
    private JLabel label1 = new JLabel();
    private JTextField searchTextField = new JTextField();
    private String prevSerachText = "*";
    private JScrollPane scrollpane1 = new JScrollPane();
    private JList<Word> word_targetList = new JList<>();
    private DefaultListModel<Word> word_targetListModel = new DefaultListModel<>();
    private JPanel panel2 = new JPanel();
    private JLabel label2 = new JLabel();
    private JButton speakerButton = new JButton();
    private JButton updateButton = new JButton();
    private boolean updateStatus = false;
    private JButton deleteButton = new JButton();
    private JButton newButton = new JButton();
    private boolean newStatus = false;
    private JScrollPane scrollpane2 = new JScrollPane();
    private JTextArea word_explainText = new JTextArea();
    private List<Word> searchListWord = new LinkedList<>();

    private void initComponents() {
        panel1.setBackground(new Color(0, 100, 175));

        searchButton.setFont(new Font("Times New Roman", 0, 12));
        searchButton.setIcon(new ImageIcon("icon\\searchIcon.png"));
        searchButton.setText("Search");
        searchButton.setBorder(null);
        searchButton.setMargin(new Insets(2, 0, 2, 2));
        searchButton.setPreferredSize(new Dimension(75, 24));

        historyButton.setFont(new Font("Times New Roman", 0, 12));
        historyButton.setIcon(new ImageIcon("icon\\historyIcon.png"));
        historyButton.setText("History");
        historyButton.setBorder(null);
        historyButton.setMargin(new Insets(2, 0, 2, 2));
        historyButton.setPreferredSize(new Dimension(75, 24));

        label1.setBackground(new Color(204, 204, 204));
        label1.setFont(new Font("Times New Roman", 0, 18));
        label1.setForeground(new Color(255, 255, 255));
        label1.setText("Dictionary");

        searchTextField.setFont(new Font("Times New Roman", 0, 18));
        searchTextField.setText("");
        searchTextField.setBorder(null);

        scrollpane1.setBorder(null);

        word_targetList.setFont(new Font("Times New Roman", 0, 18));
        word_targetList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        word_targetList.setSelectionBackground(new Color(0, 100, 175));
        word_targetList.setSelectionForeground(new Color(255, 255, 255));
        word_targetList.setModel(word_targetListModel);

        panel2.setBackground(new Color(0, 100, 175));

        label2.setBackground(new Color(204, 204, 204));
        label2.setFont(new Font("Times New Roman", 0, 18));
        label2.setForeground(new Color(255, 255, 255));
        label2.setText("Definition");

        speakerButton.setFont(new Font("Times New Roman", 0, 12));
        speakerButton.setIcon(new ImageIcon("icon\\speakerIcon.png"));
        speakerButton.setText("US");
        speakerButton.setBorder(null);
        speakerButton.setMargin(new Insets(2, 0, 2, 2));
        speakerButton.setPreferredSize(new Dimension(47, 24));

        updateButton.setFont(new Font("Times New Roman", 0, 12));
        updateButton.setIcon(new ImageIcon("icon\\updateIcon.png"));
        updateButton.setText("Update");
        updateButton.setBorder(null);
        updateButton.setMargin(new Insets(2, 0, 2, 2));
        updateButton.setPreferredSize(new Dimension(47, 24));

        deleteButton.setFont(new Font("Times New Roman", 0, 12));
        deleteButton.setIcon(new ImageIcon("icon\\deleteIcon.png"));
        deleteButton.setText("Delete");
        deleteButton.setBorder(null);
        deleteButton.setMargin(new Insets(2, 0, 2, 2));
        deleteButton.setPreferredSize(new Dimension(47, 24));

        newButton.setFont(new Font("Times New Roman", 0, 12));
        newButton.setText("Add");
        newButton.setBorder(null);
        newButton.setMargin(new Insets(2, 0, 2, 2));
        newButton.setPreferredSize(new Dimension(47, 24));

        scrollpane2.setBorder(null);

        word_explainText.setColumns(20);
        word_explainText.setFont(new Font("Times New Roman", 0, 24));
        word_explainText.setRows(5);
        word_explainText.setBorder(null);
        word_explainText.setEditable(false);

        GroupLayout panel1Layout = new GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(panel1Layout.createSequentialGroup().addContainerGap()
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                        .addComponent(searchButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(historyButton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap()));
        panel1Layout.setVerticalGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(panel1Layout.createSequentialGroup().addContainerGap()
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(historyButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateWord();
                addWord();
                searchTextField.setText("");
                word_explainText.setText("");
                searchListWord = Dictionary.words;
                DictionaryCommandline.dictionarySearcher("", word_targetListModel, searchListWord);
            }
        });

        historyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateWord();
                addWord();
                searchTextField.setText("");
                word_explainText.setText("");
                searchListWord = Dictionary.historyWords;
                DictionaryCommandline.dictionarySearcher("", word_targetListModel, searchListWord);
            }
        });

        GroupLayout panel2Layout = new GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(panel2Layout.createSequentialGroup().addGap(18, 18, 18)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(speakerButton, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 188, Short.MAX_VALUE)
                        .addComponent(deleteButton, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(updateButton, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(newButton,
                                GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap()));
        panel2Layout.setVerticalGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
                GroupLayout.Alignment.TRAILING,
                panel2Layout.createSequentialGroup().addContainerGap().addGroup(panel2Layout
                        .createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(speakerButton, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                        .addComponent(updateButton, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                        .addComponent(deleteButton, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                        .addComponent(newButton, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap()));

        speakerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (word_targetList.getSelectedValue() == null) return;
                DictionaryManagement.removeWord(word_targetList.getSelectedValue());
                int deleteIndex = word_targetList.getSelectedIndex();
                if (deleteIndex + 1 == word_targetListModel.getSize()) {
                    word_targetList.setSelectedIndex(deleteIndex - 1);
                } else {
                    word_targetList.setSelectedIndex(deleteIndex + 1);
                }
                word_targetListModel.removeElementAt(deleteIndex);
            }
        });

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (word_targetList.getSelectedValue() == null) return;
                if (updateStatus == false) {
                    updateStatus = true;
                    updateButton.setText("Save");
                    word_explainText.setEditable(true);
                } else {
                    updateWord();
                }
            }
        });

        newButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (newStatus == false) {
                    newStatus = true;
                    updateWord();
                    newButton.setText("Add");
                    searchTextField.setText("");
                    word_explainText.setText("");
                    word_explainText.setEditable(true);
                    word_targetListModel.clear();
                } else {
                    addWord();
                }
            }
        });

        searchTextField.addKeyListener(new KeyListener(){
            public void keyPressed(KeyEvent event) {

            }

            public void keyTyped(KeyEvent event) {

            }

            public void keyReleased(KeyEvent event) {
                String searchText = searchTextField.getText();
                if (!searchText.equals(prevSerachText) && newStatus == false) {
                    word_explainText.setText(searchText);
                    word_targetList.clearSelection();
                    DictionaryCommandline.dictionarySearcher(searchText, word_targetListModel, searchListWord);
                    prevSerachText = searchText;
                }
            }
        });

        scrollpane1.setViewportView(word_targetList);

        word_targetList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (word_targetList.getSelectedValue() != null) {
                    Word word = word_targetList.getSelectedValue();
                    DictionaryManagement.addToHistory(word);
                    searchTextField.setText(word.word_target);
                    String s = word.word_explain + "\n";
                    s += word.word_type + "\n";
                    s += word.word_pronounce;
                    word_explainText.setText(s);
                }
            }
        });

        scrollpane2.setViewportView(word_explainText);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(searchTextField, GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                    .addComponent(scrollpane1)
                    .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(scrollpane2)
                    .addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchTextField, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(scrollpane1, GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE))
                    .addComponent(scrollpane2)))
        );

        pack();
        setLocationRelativeTo(null);
    }

    public void updateWord() {
        if (word_targetList.getSelectedValue() == null) return;
        if (updateStatus == true) {
            updateStatus = false;
            updateButton.setText("Update");
            word_explainText.setEditable(false);
            String[] wordInfo = word_explainText.getText().split("\\n");
            Word newWord = new Word(word_targetList.getSelectedValue().word_target, wordInfo[1], wordInfo[2], wordInfo[0]);
            DictionaryManagement.updateWord(word_targetList.getSelectedValue(), newWord);
            word_targetListModel.setElementAt(newWord, word_targetList.getSelectedIndex());
        }
    }

    public void addWord() {
        if (newStatus == true) {
            newStatus = false;
            newButton.setText("New");
            word_explainText.setEditable(false);
            String[] wordInfo = word_explainText.getText().split("\\n");
            if (searchTextField.getText().length() == 0 || wordInfo[0].length() == 0) return;
            Word newWord = new Word(searchTextField.getText(), wordInfo[1], wordInfo[2], wordInfo[0]);
            DictionaryManagement.insertNewWord(newWord);
            searchTextField.setText("");
            word_explainText.setText("");
            searchListWord = Dictionary.words;
            DictionaryCommandline.dictionarySearcher("", word_targetListModel, searchListWord);
        }
    }

    public DictionaryApplication() {
        DictionaryManagement.insertFromFile();
        searchListWord = Dictionary.words;
        DictionaryCommandline.dictionarySearcher(searchTextField.getText(), word_targetListModel, searchListWord);
        initComponents();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                DictionaryManagement.dictionaryExportToFile();
            }
        });
        setTitle("Dictionary");
        setResizable(false);
        setVisible(true);
    }

    public static void runApplication() {
        DictionaryApplication app = new DictionaryApplication();
    }

    public static void main(String[] args) {
        runApplication();
    }
}