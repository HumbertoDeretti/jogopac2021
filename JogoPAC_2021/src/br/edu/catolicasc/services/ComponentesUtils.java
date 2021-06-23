package br.edu.catolicasc.services;

import java.awt.Image;

import javax.swing.ImageIcon;

import br.edu.catolicasc.parametros.Globais;

public class ComponentesUtils {

	public ImageIcon imageResource(String path, int w, int h) {

		ImageIcon img;
		if (w == 0) {
			img = new ImageIcon(getClass().getResource("/resources/" + path));
		} else {
			img = new ImageIcon(new ImageIcon(getClass().getResource("/resources/" + path)).getImage()
					.getScaledInstance(w, h, Image.SCALE_SMOOTH));
		}

		return img;

	}
	
	public ImageIcon avatarResource(String path) {
		ImageIcon img;
		img = new ImageIcon(new ImageIcon(getClass().getResource("/resources_avatar/" + path)).getImage().getScaledInstance(Globais.LARGURA_AVATAR, Globais.ALTURA_AVATAR, Image.SCALE_SMOOTH));
	
		return img;
	}
	public ImageIcon fasesResource(String path, int w, int h) {

		ImageIcon img;
		if (w == 0) {
			img = new ImageIcon(getClass().getResource("/resources_fases/" + path));
		} else {
			img = new ImageIcon(new ImageIcon(getClass().getResource("/resources_fases/" + path)).getImage()
					.getScaledInstance(w, h, Image.SCALE_SMOOTH));
		}

		return img;

	}
	
}
