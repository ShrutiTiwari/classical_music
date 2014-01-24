package com.aqua.music.view.main;

import java.awt.BorderLayout;

import javax.swing.JApplet;

/**
 * @author "Shruti Tiwari"
 *
 */
public class AppletLauncher extends JApplet {
	public void init() {
		try {
			add(new UIMainPanel().getJPanel(), BorderLayout.CENTER);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("createGUI failed");
		}
	}
}
