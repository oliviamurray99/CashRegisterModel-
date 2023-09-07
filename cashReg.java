/** Cash Register
 * This program uses GUI to create a
 * calculator interface where users can
 * buy items and get the total
 *@author OliviaMurray
 *@date 13 06 2023
 */

//imports
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

//public class
public class cashReg extends JFrame implements ActionListener {


    //initialize variables and arrays
    JTextArea totalTextArea;
    JLabel lStatus;
    JLabel costLabel, taxLabel, totalLabel, itemCountLabel;

    double total = 0;
    double taxRate = 0.13;


    int itemCount=0;

    JButton clearButton;

    JButton voidButton;

    JButton EmpDiscButton;

    JButton MealDiscButton;

    JButton ONBUTTON;
    JButton OFFBUTTON;

    JButton[] buttons = new JButton[18];






    //for lookup
    //array of button names
    String[] buttonNameStrings = {
            "Boston cream donut", "Bruce Potato's", "Honey Croissant", "Blueberry peach Pie",
            "Chocolate Croissant", "Pecan butter tart", "lemon loaf", "Fruit danish",
            "Walnut sticky buns", "Flax bread", "Wild yeast Sourdough", "European White bread",
            "Alpine Loaf", "Peanut Butter Brownie", "Strawberry Tart", "Blueberry Scone",
            "Strawberry Cupcake", "Peanut Butter Chocolate Tart"

    };




    //for lookup
    //array of button prices
    double[] buttonPricesDoubles = {
            3.99, 2.50, 3.75, 10.75,
            3.75, 1.75, 6.50, 4.00,
            8.30, 7.50, 9.99, 11.50,
            6.99, 1.50, 2.99, 1.75,
            2.78, 7.99,

    };


    //main method
    cashReg() {
        // Creating the main panel and setting its layout and border
        JPanel mainP = new JPanel();
        mainP.setLayout(new BorderLayout(30, 30));
        mainP.setBorder(new LineBorder(new Color(238, 238, 238), 10));


        //for layout
        // Define a 2D array to store the names of bakery items
        String[][] buttonNames = {
                {"Boston Cream Donut", "Bruce Potato's", "Honey Croissant", "Blueberry Peach Pie"},
                {"Chocolate Croissant", "Pecan Butter Tart", "Lemon loaf", "Fruit Danish"},
                {"Walnut Sticky Buns", "Flax Bread", "Wild Yeast Sourdough", "European White bread"},
                {"Alpine Loaf", "Peanut Butter Brownie", "Strawberry Tart", "Blueberry Scone"},
                {"Strawberry Cupcake", "Peanut Butter Chocolate Tart"}
        };



        // Create and configure various buttons for the cash register
        //make new button, disable button, and add action listener
        clearButton = new JButton("*CLEAR*");
        clearButton.setEnabled(false);
        clearButton.addActionListener(this);
        clearButton.setForeground(Color.CYAN);



        voidButton = new JButton("*VOID*");
        voidButton.setEnabled(false);
        voidButton.addActionListener(this);
        voidButton.setForeground(Color.BLUE);


        EmpDiscButton = new JButton("Emp Disc ($-2.5)");
        EmpDiscButton.setEnabled(false);
        EmpDiscButton.addActionListener(this);
        EmpDiscButton.setForeground(Color.RED);

        MealDiscButton = new JButton("Meal Disc ($-1.25)");
        MealDiscButton.setEnabled(false);
        MealDiscButton.addActionListener(this);
        MealDiscButton.setForeground(Color.ORANGE);


        ONBUTTON = new JButton("ON");
        ONBUTTON.addActionListener(this);
        ONBUTTON.setForeground(Color.PINK);

        OFFBUTTON = new JButton("OFF");
        OFFBUTTON.addActionListener(this);
        OFFBUTTON.setForeground(Color.GREEN);



        // Set the size, default close operation, and layout for the main frame
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(5, 5));



        // NORTH
        // Create a label for the bakery name and add it to the north panel
        setTitle("OFFSHORE BAKERY");
        setSize(400,600);
        setLayout(new BorderLayout());


        JLabel bakeryNameLabel = new JLabel("Offshore Bakery");
        bakeryNameLabel.setForeground(Color.PINK);
        bakeryNameLabel.setHorizontalAlignment(SwingConstants.CENTER);


        Font labelFont = new Font("Courier New", Font.BOLD, 24);
        bakeryNameLabel.setFont(labelFont);

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(2,1));


        northPanel.add(bakeryNameLabel);
        mainP.add(northPanel, BorderLayout.NORTH);



        JLabel bakeryNameSlogan = new JLabel("Southampton's Best Baked Treats!");
        bakeryNameSlogan.setForeground(Color.LIGHT_GRAY);
        Font labelFont1 = new Font("Courier New", Font.BOLD, 24);
        bakeryNameSlogan.setFont(labelFont1);
        northPanel.add(bakeryNameSlogan);
        bakeryNameSlogan.setHorizontalAlignment(SwingConstants.CENTER);





        // WEST
        // Create the west panel and set its layout to a grid based on the buttonNames array dimensions
        JPanel westPanel = new JPanel();
        westPanel.setLayout(new GridLayout(buttonNames.length, buttonNames[0].length));


        // Iterate over the button names and create buttons for each item, then add them to the west panel
            for (int j = 0; j < buttonNameStrings.length; j++) {
                buttons[j] = new JButton(buttonNameStrings[j]);
                // Add action listener to handle button click
                buttons[j].setForeground(Color.MAGENTA);
                buttons[j].setBackground(Color.BLUE);
                buttons[j].addActionListener(this);
                westPanel.add(buttons[j]);
                buttons[j].setEnabled(false);

            }//end for


        // Add additional buttons to the west panel for clearing, voiding, employee discount, meal discount, and power on/off
        westPanel.add(clearButton);
        westPanel.add(voidButton);
        westPanel.add(EmpDiscButton);
        westPanel.add(MealDiscButton);
        westPanel.add(ONBUTTON);
        westPanel.add(OFFBUTTON);


        // Add the west panel to the main panel
        mainP.add(westPanel, BorderLayout.WEST);



        // EAST
        // Create a text area for displaying the total, wrap it in a scroll pane, and set it as non-editable
        totalTextArea = new JTextArea(10, 20);
        JScrollPane totalTAScroll = new JScrollPane(totalTextArea);
        totalTextArea.setEditable(false);


        // Create a text area for displaying the total, wrap it in a scroll pane, and set it as non-editable
        JPanel eastPanel = new JPanel();
        eastPanel.setLayout(new BorderLayout(5, 4));
        eastPanel.add(totalTAScroll, BorderLayout.CENTER);


        // Additional window in the east panel
        JPanel additionalPanel = new JPanel();
        additionalPanel.setLayout(new GridLayout(4, 2));

        costLabel = new JLabel("Cost: $0.00");
        taxLabel = new JLabel("Tax: $0.00");
        totalLabel = new JLabel("Total: $0.00");
        itemCountLabel = new JLabel("Items: 0");

        // Create labels for displaying cost, tax, total, and item count, and add them to the additional panel
        additionalPanel.add(costLabel);
        additionalPanel.add(taxLabel);
        additionalPanel.add(totalLabel);
        additionalPanel.add(itemCountLabel);

        // Add the additional panel to the east panel
        eastPanel.add(additionalPanel, BorderLayout.SOUTH);

        // Add the east panel to the main panel
        mainP.add(eastPanel, BorderLayout.EAST);

        // Add the main panel to the frame and make it visible
        add(mainP);
        setVisible(true);




        //SOUTH
        // Add a label for the status at the bottom of the main panel
        lStatus = new JLabel("OFF");
        mainP.add(lStatus, BorderLayout.SOUTH);


        add(mainP);
        setVisible(true);




    }//cashReg()

    /**
     * Methods iterates through buttons array and
     * enables all of them because of a boolean (true = enabled, \
     * false = disabled)
     * @param enabled
     */
    protected void setButtonsEnabled(boolean enabled) {
        // Use the buttons array
        for (int i = 0; i < buttons.length; i++) {
            JButton button = buttons[i];
            button.setEnabled(enabled);
        }//end for
    }//setButtonsEnabled(boolean enabled)


    /**
     * Method clears the text in the
     * total window
     */
    protected void clearAll() {
        //set item count to 0 and total to 0
        itemCount=0;
        total = 0;

        totalTextArea.setText("0.00");
        totalTextArea.setText("");


    }//void clearAll()


    /**
     * Method subtracts employee discount (-2.5)
     * from the subtotal
     */
    protected void EmpDiscount(){
        total=total-2.5;

    }//void EmpDiscount()


    /**
     * Method subtracts meal discount (-1.25)
     * from the subtotal
     */
    protected void MealDiscount(){
        total=total-1.25;

    }//void MealDiscount()


    /**
     * Method allows user to select
     * any item from total window and
     * delete that item (void)
     * @param selectedItem
     */
    protected void deleteSelectedItem(String selectedItem) {
        for (int i = 0; i < buttonNameStrings.length; i++) {
            if (selectedItem.equals(buttonNameStrings[i])) {
                total -= buttonPricesDoubles[i];
                itemCount--;

                // Find the index of the item in the text area
                int index = totalTextArea.getText().indexOf(selectedItem);

                // Find the index of the next line break (\n)
                int lineBreakIndex = totalTextArea.getText().indexOf("\n", index);

                // Remove the selected item from the text area
                if (lineBreakIndex != -1) {
                    totalTextArea.replaceRange("", index, lineBreakIndex);
                }//end if

                break;
            }//end if
        }//end for
    }//void deleteSelectedItem(String selectedItem)




    // Action listener implementation
    public void actionPerformed(ActionEvent e) {

        JButton button = (JButton) e.getSource();
        String buttonText = button.getText();
        String priceString = "";

        // if on button is pressed change text to running and enable all buttons
        if (e.getSource() == ONBUTTON) {
            // Enable buttons
            lStatus.setText("Running...");
            clearButton.setEnabled(true);
            voidButton.setEnabled(true);
            EmpDiscButton.setEnabled(true);
            MealDiscButton.setEnabled(true);
            setButtonsEnabled(true);


        }//end if


        // if off button is pressed change text to running and disable all buttons
        if (e.getSource() == OFFBUTTON) {
            // Enable buttons
            lStatus.setText("OFF");
            clearButton.setEnabled(false);
            voidButton.setEnabled(false);
            EmpDiscButton.setEnabled(false);
            MealDiscButton.setEnabled(false);
            setButtonsEnabled(false);
            clearAll();


        }//end if



        for ( int i = 0; i < buttonNameStrings.length; i++ ) {
            if ( buttonText.equals( buttonNameStrings[i] ) ) {
                //button texts matches get price from price array
                priceString = String.valueOf( buttonPricesDoubles[i]) ;
                total += buttonPricesDoubles[i];
                itemCount++;

            }//end if
        }//end for

        //user can enter items to delete manually
        if (e.getSource() == voidButton) {
            String selectedItem = JOptionPane.showInputDialog(this, "Type the item to delete:");
            if (selectedItem != null) {
                deleteSelectedItem(selectedItem);
            }//end if

        }//end if



        //if user presses a certain button, methods are called
        if (e.getSource() == clearButton)
            clearAll();

        if (e.getSource() == EmpDiscButton)
            EmpDiscount();

        if (e.getSource() == MealDiscButton)
            MealDiscount();


        // Append the selected item to the totalTextArea
        totalTextArea.append(buttonText + " " + priceString  + " \n" );



        //tax, subtotal and final cost calculations
        double tax = total * taxRate;
        double cost = total;
        double finalTotal= cost+tax;



        //final invoice is displayed
        costLabel.setText("Cost: $ " + String.format("%.2f", cost));
        taxLabel.setText("Tax: $ " + String.format("%.2f", tax));
        totalLabel.setText("Total: $ " + String.format("%.2f", finalTotal));
        itemCountLabel.setText("Items: " + (itemCount));




    }//void actionPerformed(ActionEvent e)



    //main
    public static void main(String[] args) {
        //cashReg is called
        new cashReg();
    }//public static void main(String[] args)


}//public class cashReg extends JFrame implements ActionListener
