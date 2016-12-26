import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TranslatingTextEditor2 extends JFrame {
	public TranslatingTextEditor2(String title) {
		super(title);
		setSize(1200, 800);
		
		Container c = this.getContentPane();
		Font f = new Font("Helvetica", Font.BOLD, 30);
		
		JTextArea t = new JTextArea();
		t.setFont(f);
		c.add(t, BorderLayout.CENTER);
		
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(4, 1, 5, 10));
		c.add(p, BorderLayout.WEST);
		
		JButton b1 = new JButton("Translate");
		JButton b2 = new JButton("Clear");
		b1.setFont(f);
		b2.setFont(f);
		p.add(b1);
		p.add(b2);
		
		b1.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							Dict dict = new Dict();
							String textEnglish = t.getText();
							String textChinese = "";
							Scanner textInput = new Scanner(textEnglish);
							while (textInput.hasNext()) {
								String wordEnglish = textInput.next();
								String wordChinese = dict.translate(wordEnglish);
								if (wordChinese != null) {
									textChinese += wordChinese + " ";
								}
								else {
									textChinese += wordEnglish + " ";
								}
							}
							t.setText(textChinese);
						}
						catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				});
		b2.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						t.setText("");
					}
				});
		
		JMenuBar mb = new JMenuBar();
		JMenu menu = new JMenu("File");
		JMenuItem item1 = new JMenuItem("Open...");
		JMenuItem item2 = new JMenuItem("Save");
		JMenuItem item3 = new JMenuItem("Quit");
		menu.setFont(f);
		item1.setFont(f);
		item2.setFont(f);
		item3.setFont(f);
		menu.add(item1);
		menu.add(item2);
		menu.add(item3);
		mb.add(menu);
		setJMenuBar(mb);
		
		item1.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JFileChooser fc = new JFileChooser();
						fc.setFileFilter(new FileNameExtensionFilter("Text Documents (*.txt)", "txt"));
						fc.showOpenDialog(null);
						File f = fc.getSelectedFile();
						try {
							Scanner fileInput = new Scanner(f);
							String text = "";
							while (fileInput.hasNext()) {
								String word = fileInput.nextLine();
								text += word;
							}
							t.setText(text);
						} 
						catch (FileNotFoundException e1) {
							e1.printStackTrace();
						}
					}
				});
		item2.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JFileChooser fc = new JFileChooser();
						fc.setFileFilter(new FileNameExtensionFilter("Text Documents (*.txt)", "txt"));
						int result = fc.showSaveDialog(null);
						if (result == JFileChooser.APPROVE_OPTION) {
							File file = fc.getSelectedFile();
							if (!file.getPath().endsWith(".txt")) {
								file = new File(file.getPath() + ".txt");
							}
							FileOutputStream fos = null;
							try {
								if (!file.exists()) {
									file.createNewFile();
								}
								fos = new FileOutputStream(file);
								fos.write(t.getText().getBytes());
								fos.flush();
							}
							catch (IOException e1) {
								e1.printStackTrace();
							}
						}
					}
				});
		item3.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new TranslatingTextEditor2("Translating Text Editor");
	}
}

class Dict {
	private Properties p;
	private FileReader r;
	public Dict() throws Exception {
		p = new Properties();
		r = new FileReader("dict.dat");
		p.load(r);
		r.close();
	}
	public String translate(String word) {
		return p.getProperty(word);
	}
}