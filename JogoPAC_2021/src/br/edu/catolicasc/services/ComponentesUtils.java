package br.edu.catolicasc.services;

import java.awt.Image;

import javax.swing.ImageIcon;

public class ComponentesUtils {
	
	public ImageIcon imageResource(String path,int w,int h) {
		
		ImageIcon img;
		if(w==0) {
			img = new ImageIcon(getClass().getResource("/resources/"+path));
		}else {
			img = new ImageIcon(new ImageIcon(getClass().getResource("/resources/"+path)).getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH));
		}
		
		return img;
		
	}
}
