package lab2;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
public class UIFrame<T extends Comparable<T>> extends JFrame {

    private ArrayList<T> itemList;

  
    private JTextField inputField;
    private JButton addButton;
    private JTextArea displayArea;

 
    public UIFrame() {
        itemList = new ArrayList<>();

        setTitle("Generic UI Frame");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        initComponents();
        addComponents();
    }


    private void initComponents() {
        inputField = new JTextField(20);
        addButton = new JButton("Add Item");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItemToList();
            }
        });
        displayArea = new JTextArea(10, 30);
        displayArea.setEditable(false);
    }


    private void addComponents() {
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Enter Item:"));
        inputPanel.add(inputField);
        inputPanel.add(addButton);

        JButton reverseButton = new JButton("Reverse");
        reverseButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                reverseItems();
            }
        });
        JButton uniqueButton = new JButton("Unique");
        uniqueButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                removeDuplicates();
            }
        });
        JButton randButton = new JButton("Randomize");
        randButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                randomizeItems();
            }
        });
        JButton mergeButton = new JButton("Merge");
        mergeButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                mergeItems();
            }
        });
        JButton maxButton = new JButton("Max");
        maxButton.addActionListener(new ActionListener() {
           
            public void actionPerformed(ActionEvent e) {
                showMax();
            }
        });
        JButton minButton = new JButton("Min");
        minButton.addActionListener(new ActionListener() {
           
            public void actionPerformed(ActionEvent e) {
                showMin();
            }
        });
        JButton sumButton = new JButton("Sum");
        sumButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                showSum();
            }
        });
        JButton avgButton = new JButton("Average");
        avgButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                showAverage();
            }
        });
       
        JButton sortButton = new JButton("Sort");
        sortButton.addActionListener(new ActionListener() {
           
            public void actionPerformed(ActionEvent e) {
                sortItems();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(reverseButton);
        buttonPanel.add(uniqueButton);
        buttonPanel.add(randButton);
        buttonPanel.add(mergeButton);
        buttonPanel.add(maxButton);
        buttonPanel.add(minButton);
        buttonPanel.add(sumButton);
        buttonPanel.add(avgButton);
        
        buttonPanel.add(sortButton);

        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(new JScrollPane(displayArea), BorderLayout.SOUTH);
    }


    private void addItemToList() {
        String inputText = inputField.getText();
        if (!inputText.isEmpty()) {
            itemList.add((T) inputText);
            displayItems();
            inputField.setText("");
        }
    }

   
    private void displayItems() {
        displayArea.setText("");
        for (T item : itemList) {
            displayArea.append(item.toString() + "\n");
        }
    }

    // Function to reverse the items in the list
    private void reverseItems() {
        Collections.reverse(itemList);
        displayItems();
    }

    // Function to remove duplicates from the list
    private void removeDuplicates() {
        Set<T> uniqueItems = new HashSet<>(itemList);
        itemList.clear();
        itemList.addAll(uniqueItems);
        displayItems();
    }

   
    private void randomizeItems() {
        Collections.shuffle(itemList, new Random());
        displayItems();
    }

    
    private void mergeItems() {
        ArrayList<T> mergedList = new ArrayList<>(itemList);
        mergedList.addAll(itemList);
        displayArea.setText("");
        for (T item : mergedList) {
            displayArea.append(item.toString() + "\n");
        }
    }

    
    private void showMax() {
        if (!itemList.isEmpty()) {
            T maxItem = Collections.max(itemList);
            JOptionPane.showMessageDialog(this, "Max Item: " + maxItem);
        }
    }

   
    private void showMin() {
        if (!itemList.isEmpty()) {
            T minItem = Collections.min(itemList);
            JOptionPane.showMessageDialog(this, "Min Item: " + minItem);
        }
    }

    private void showSum() {
        if (!itemList.isEmpty()) {
            double sum = 0;
            for (T item : itemList) {
                sum += Double.parseDouble(item.toString());
            }
            JOptionPane.showMessageDialog(this, "Sum: " + sum);
        }
    }


    private void showAverage() {
        if (!itemList.isEmpty()) {
            double sum = 0;
            for (T item : itemList) {
                sum += Double.parseDouble(item.toString());
            }
            double average = sum / itemList.size();
            JOptionPane.showMessageDialog(this, "Average: " + average);
        }
    }

  

  
    private void sortItems() {
        Collections.sort(itemList);
        displayItems();
    }

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable() {
            
            public void run() {
                new UIFrame<String>().setVisible(true);
            }
        });
    }
}


