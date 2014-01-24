/**
 * 
 */
package com.aqua.music.view.components;

import java.awt.Dimension;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

/**
 * @author "Shruti Tiwari"
 * 
 */
class UiScrollPane {
	private final Dimension dimension;
	private final int itemCount;
	private final int maxNameLength;

	UiScrollPane(int itemCount, int maxNameLength, Dimension dimension) {
		this.itemCount = itemCount;
		this.maxNameLength = maxNameLength;
		this.dimension = dimension;
	}

	UiScrollPane() {
		this(10, 200, null);
	}

	JScrollPane createScrollPane(JList jList) {
		jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jList.setLayoutOrientation(JList.VERTICAL_WRAP);
		jList.setVisibleRowCount(itemCount);
		jList.setFixedCellWidth(maxNameLength);

		JScrollPane scrollPane = new JScrollPane(jList);
		if (dimension != null) {
			scrollPane.setPreferredSize(dimension);
		}
		return scrollPane;
	}
}
