package _03_To_Do_List;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save
	 * list, and load list.
	 * 
	 * When add task is clicked: ask the user for a task and save it to an array
	 * list
	 * 
	 * When the view tasks button is clicked: show all the tasks in the list
	 * 
	 * When the remove task button is clicked: prompt the user for which task to
	 * remove and take it off of the list.
	 * 
	 * When the save list button is clicked: Save the list to a file
	 * 
	 * When the load list button is clicked: Prompt the user for the location of the
	 * file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file
	 * into the list.
	 */
	static JFrame frame = new JFrame();
	static JPanel panel = new JPanel();
	static JButton add = new JButton();
	static JButton view = new JButton();
	static JButton remove = new JButton();
	static JButton save = new JButton();
	static JButton load = new JButton();
	ArrayList<String> tasks = new ArrayList<String>();

	public ToDoList() {
		frame.add(panel);
		panel.add(add);
		panel.add(view);
		panel.add(remove);
		panel.add(save);
		panel.add(load);
		frame.setVisible(true);
		add.setText("Add Task");
		view.setText("View Tasks");
		remove.setText("Remove Task");
		save.setText("Save List");
		load.setText("Load List");
		frame.pack();
		add.addActionListener(this);
		view.addActionListener(this);
		remove.addActionListener(this);
		save.addActionListener(this);
		load.addActionListener(this);
	}

	public static void main(String[] args) {
		ToDoList tdl = new ToDoList();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == add) {
			String str = JOptionPane.showInputDialog(null, "Input a message that you would like to be save to a file");
			tasks.add(str);
		} else if (e.getSource() == view) {
			JOptionPane.showMessageDialog(null, "Cuurent tasks: \n" + tasks);
		} else if (e.getSource() == remove) {
			String rev = JOptionPane.showInputDialog(null, "Whitch task will you like to remove?\n" + tasks);
			for (int i = 0; i < tasks.size(); i++) {
				if (rev.toLowerCase().equals(tasks.get(i).toLowerCase())) {
					tasks.remove(i);
				}
			}
		} else if (e.getSource() == save) {
			for (int i = 0; i < tasks.size(); i++) {
				try {
					FileWriter fw = new FileWriter("src/_03_To_Do_List/tasks.txt", true);
					fw.write(tasks.get(i) + "\n");
					fw.close();
				} catch (IOException j) {
					j.printStackTrace();
				}
			}
		} else if (e.getSource() == load) {
			try {
				BufferedReader br = new BufferedReader(new FileReader("src/_03_To_Do_List/tasks.txt"));
				String line = br.readLine();
				while (line != null) {
					tasks.add(line);
					line = br.readLine();
				}

				br.close();
			} catch (FileNotFoundException j1) {
				j1.printStackTrace();
			} catch (IOException j) {
				j.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Current tasks: \n" + tasks);
		}
	}
}
