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
public class Componentes {
	
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
	public JButton button (String texto,String id,int eixo_x,int eixo_y,int largura, int altura,boolean areaFilled,boolean opaque,ActionListener action) {
		JButton bt = new JButton(texto);
		bt.setName(id);
		bt.setBounds(eixo_x,eixo_y, largura, altura);
		bt.setContentAreaFilled(areaFilled);
		bt.setOpaque(opaque);
		bt.addActionListener(action);
		return bt;
	}
	
}
