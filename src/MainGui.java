import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import java.awt.Button;
import java.awt.Component;
import java.awt.Panel;
import javax.swing.JInternalFrame;
import javax.swing.JToolBar;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.List;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JTextPane;
import javax.swing.JTable;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class MainGui extends JFrame {
	private JTextField taskText;
	private JTextField descriptionText;
	private JTextField timeframeText;
	private JTable toDoTable;
	ArrayList<String> taskArr = new ArrayList<String>();
	ArrayList<String> taskArrWrite = new ArrayList<String>();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
//		Driver.readDB(taskArr);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGui frame = new MainGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public MainGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1899, 1071);
		getContentPane().setLayout(null);
		
		JButton settingsBtn = new JButton("Settings");
		settingsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		settingsBtn.setBounds(10, 93, 85, 21);
		getContentPane().add(settingsBtn);
		
		JButton taskBtn = new JButton("Tasks");
		taskBtn.setBounds(10, 0, 85, 21);
		getContentPane().add(taskBtn);
		
		JButton calendarBtn = new JButton("Calendar");
		calendarBtn.setBounds(10, 31, 85, 21);
		getContentPane().add(calendarBtn);
		
		JButton archiveBtn = new JButton("Archive");
		archiveBtn.setBounds(10, 62, 85, 21);
		getContentPane().add(archiveBtn);
		
		JLabel newTaskLabel = new JLabel("New Task");
		newTaskLabel.setFont(new Font("DejaVu Serif Condensed", Font.PLAIN, 30));
		newTaskLabel.setBounds(105, 30, 292, 53);
		getContentPane().add(newTaskLabel);
		
		taskText = new JTextField();
		taskText.setBounds(170, 87, 231, 33);
		getContentPane().add(taskText);
		taskText.setColumns(10);
		
		JLabel taskLabel = new JLabel("Task: ");
		taskLabel.setFont(new Font("DejaVu Serif Condensed", Font.PLAIN, 20));
		taskLabel.setBounds(105, 87, 55, 33);
		getContentPane().add(taskLabel);
		
		JLabel descriptionLabel = new JLabel("Description: ");
		descriptionLabel.setFont(new Font("DejaVu Serif Condensed", Font.PLAIN, 20));
		descriptionLabel.setBounds(410, 87, 118, 33);
		getContentPane().add(descriptionLabel);
		
		descriptionText = new JTextField();
		descriptionText.setBounds(538, 87, 231, 33);
		getContentPane().add(descriptionText);
		descriptionText.setColumns(10);
		
		JComboBox urgencyBox = new JComboBox();
		urgencyBox.setFont(new Font("DejaVu Serif Condensed", Font.PLAIN, 20));
		urgencyBox.setBounds(879, 87, 231, 33);
		getContentPane().add(urgencyBox);
		
		/*
		 * drop down menu used to select the task priority
		 */
		
		urgencyBox.addItem("High");
		urgencyBox.addItem("Medium");
		urgencyBox.addItem("Low");
		
		JLabel urgencyLabel = new JLabel("Urgency: ");
		urgencyLabel.setFont(new Font("DejaVu Serif Condensed", Font.PLAIN, 20));
		urgencyLabel.setBounds(779, 87, 90, 33);
		getContentPane().add(urgencyLabel);
		
		JLabel timeframeLabel = new JLabel("Timeframe: ");
		timeframeLabel.setFont(new Font("DejaVu Serif Condensed", Font.PLAIN, 20));
		timeframeLabel.setBounds(1120, 87, 118, 33);
		getContentPane().add(timeframeLabel);
		
		timeframeText = new JTextField();
		timeframeText.setFont(new Font("DejaVu Serif Condensed", Font.PLAIN, 20));
		timeframeText.setBounds(1248, 87, 231, 33);
		getContentPane().add(timeframeText);
		timeframeText.setColumns(10);
		
		JButton submitBtn = new JButton("Submit");
		
		/*
		 * Future plan is the have the submit button clear the text fields and refresh the program to show new tasks
		 */
		
		submitBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				taskArrWrite.add(taskText.getText());
				taskArrWrite.add(descriptionText.getText());
				taskArrWrite.add((String) urgencyBox.getSelectedItem());
				taskArrWrite.add(timeframeText.getText());
				Driver.writeDB(taskArrWrite.get(0), "To Do", taskArrWrite.get(1), taskArrWrite.get(2), taskArrWrite.get(3)); // task Name, task Status, task Description, task Priority, end Date
			}
		});
		
		submitBtn.setFont(new Font("DejaVu Serif Condensed", Font.PLAIN, 20));
		submitBtn.setBounds(1489, 87, 169, 33);
		getContentPane().add(submitBtn);
		
		int numToDo = Driver.numToDo();
		int numInProg = Driver.numInProg();
		int numDone = Driver.numDone();
		int i = 0;
		int yAxis = 163;
		int namePlace = 0;
		int descPlace = 2;
		int prioPlace = 3;
		
		/*
		 * this while loop is used to write the cards for the To Do tasks
		 */
		
		while(numToDo > i) {
		
			ArrayList<String> taskArr = Driver.readDB();
					
			toDoTable = new JTable();
			toDoTable.setFont(new Font("DejaVu Serif Condensed", Font.PLAIN, 18));
			toDoTable.setModel(new DefaultTableModel(
				new Object[][] {
					{"Task: ", taskArr.get(namePlace)},
					{"Description: ", taskArr.get(descPlace)},
					{"Priority: ", taskArr.get(prioPlace)},
				},
				new String[] {
					"row1", "row2"
				}
			) {
				Class[] columnTypes = new Class[] {
					String.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				boolean[] columnEditables = new boolean[] {
					false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
			toDoTable.getColumnModel().getColumn(0).setPreferredWidth(97);
			toDoTable.getColumnModel().getColumn(1).setPreferredWidth(97);
			toDoTable.setBounds(111, yAxis, 526, 89);
			getContentPane().add(toDoTable);
			
			int arrLength = taskArr.size();
			
			if(arrLength > 6) {
				yAxis = yAxis + 99;
				namePlace = namePlace + 6;
				descPlace = descPlace + 6;
				prioPlace = prioPlace + 6;
			}
			
			i++;
			
		}
		
 		namePlace = 0;
		int endDatePlace = 5;
		prioPlace = 3;
		yAxis = 163;
		i = 0;
		
		/*
		 * this while loop is used to write the cards for the in progress tasks
		 */
		
		while(numInProg > i) {
			
			ArrayList<String> taskArr = Driver.readInProg();
					
			toDoTable = new JTable();
			toDoTable.setFont(new Font("DejaVu Serif Condensed", Font.PLAIN, 18));
			toDoTable.setModel(new DefaultTableModel(
				new Object[][] {
					{"Task: ", taskArr.get(namePlace)},
					{"End Date: ", taskArr.get(endDatePlace)},
					{"Priority: ", taskArr.get(prioPlace)},
				},
				new String[] {
					"row1", "row2"
				}
			) {
				Class[] columnTypes = new Class[] {
					String.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				boolean[] columnEditables = new boolean[] {
					false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
			toDoTable.getColumnModel().getColumn(0).setPreferredWidth(97);
			toDoTable.getColumnModel().getColumn(1).setPreferredWidth(97);
			toDoTable.setBounds(647, yAxis, 526, 89);
			getContentPane().add(toDoTable);
			
			int arrLength = taskArr.size();
			
			if(arrLength > 6) {
				yAxis = yAxis + 99;
				namePlace = namePlace + 6;
				descPlace = descPlace + 6;
				prioPlace = prioPlace + 6;
			}
			
			i++;
			
		}
		
		namePlace = 0;
		descPlace = 2;
		endDatePlace = 5;
		yAxis = 163;
		i = 0;
		
		/*
		 * this while loop is used to write the cards for the completed tasks
		 */
		
		while(numDone > i) {
			
			ArrayList<String> taskArr = Driver.readDone();
					
			toDoTable = new JTable();
			toDoTable.setFont(new Font("DejaVu Serif Condensed", Font.PLAIN, 18));
			toDoTable.setModel(new DefaultTableModel(
				new Object[][] {
					{"Task: ", taskArr.get(namePlace)},
					{"Description: ", taskArr.get(descPlace)},
					{"End Date: ", taskArr.get(endDatePlace)},
				},
				new String[] {
					"row1", "row2"
				}
			) {
				Class[] columnTypes = new Class[] {
					String.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				boolean[] columnEditables = new boolean[] {
					false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
			toDoTable.getColumnModel().getColumn(0).setPreferredWidth(97);
			toDoTable.getColumnModel().getColumn(1).setPreferredWidth(97);
			toDoTable.setBounds(1183, yAxis, 526, 89);
			getContentPane().add(toDoTable);
			
			int arrLength = taskArr.size();
			
			if(arrLength > 6) {
				
				yAxis = yAxis + 99;
				namePlace = namePlace + 6;
				descPlace = descPlace + 6;
				endDatePlace = endDatePlace + 6;
				
			}
			
			i++;
			
		}
		
	}
}