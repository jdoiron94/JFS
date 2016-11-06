package ui.panels;

import ui.FontSelector;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

/**
 * @author Jacob
 * @since 11/5/2016
 */
public class ButtonContainer extends JPanel {

    public ButtonContainer(FontSelector selector) {
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        JButton apply = new JButton("Apply");
        apply.addActionListener(event -> selector.dispose());
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(10, 10, 10, 10);
        add(apply, constraints);
        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(event -> selector.dispose());
        constraints.gridx = 1;
        add(cancel, constraints);
    }
}