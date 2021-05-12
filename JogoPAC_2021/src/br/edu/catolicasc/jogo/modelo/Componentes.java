/**
 * 
 */
package br.edu.catolicasc.jogo.modelo;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * @author jjunkes
 *
 */
public class Componentes implements ActionListener {
	
	public JTextField textBox(String texto,String id,int eixo_x,int eixo_y,int largura, int altura) {
		JTextField txtBox = new JTextField(texto);
		txtBox.setBounds(eixo_x, eixo_y, largura, altura);
		txtBox.setName(id);
		return txtBox;
	}
	public JLabel label (String texto,String id,int eixo_x,int eixo_y,int largura, int altura) {
		JLabel lb = new JLabel(texto);
		lb.setBounds(eixo_x,eixo_y, largura, altura);
		lb.setName(id);
		return lb;
	}
	public JButton button (String texto,String id,int eixo_x,int eixo_y,int largura, int altura,boolean areaFilled,boolean opaque) {
		JButton bt = new JButton(texto);
		bt.setName(id);
		bt.setBounds(eixo_x,eixo_y, largura, altura);
		bt.setContentAreaFilled(areaFilled);
		bt.setOpaque(opaque);
		bt.addActionListener(this);
		return bt;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String origem =  e.getSource().toString().replace('[',',').replace(']',' ');
		String[] obj = origem.split(",");
		//obj[1]  Contém nome do componente setado pelo setName()
		if(obj[1].equals("bt_logon")) {
			System.out.println("Botao Logon Clicado");
			
		}
		else if(obj[1].equals("bt_logoff")) {
			System.out.println("Botao Logoff Clicado");
		}
		
	}
}
