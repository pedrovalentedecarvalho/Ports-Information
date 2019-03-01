import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

import layout.TableLayout;
public class Imprimir extends JFrame implements ActionListener{
JList jlist;

public Imprimir(String[] dados){
	createJanela(dados);
}

private void createJanela(String[] dados){
	setTitle("Configuração de portas série");
	setPreferredSize(new Dimension(500, 340));
	
	double size[][] = {{5, 475},
			{10, TableLayout.FILL, 35, 0}};
	setLayout(new TableLayout(size));
	
	jlist = new JList(dados);
	jlist.setVisibleRowCount(5);
	jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	add(jlist, "1, 1");
	
	JPanel Buttons = new JPanel (new FlowLayout());
	
	JButton btn = new JButton("SAIR");
	btn.addActionListener(this);
	Buttons.add(btn);
	add(Buttons, "1, 2, 1");
	btn.setActionCommand("Sair");
	pack();
	setVisible(true);
	}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getActionCommand().matches("Sair")){
		dispose();
}
}
}