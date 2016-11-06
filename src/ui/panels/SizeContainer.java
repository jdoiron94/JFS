package ui.panels;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Jacob
 * @since 11/5/2016
 */
public class SizeContainer extends JPanel {

    private final List<Integer> sizes = new ArrayList<>(16);
    private final JSpinner sizeSpinner = new JSpinner(new SpinnerNumberModel(12, 8, 72, 1));

    public SizeContainer() {
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        Integer[] sizes = new Integer[]{8, 9, 10, 11, 12, 14, 16, 18, 20, 22, 24, 26, 28, 36, 48, 72};
        Collections.addAll(this.sizes, sizes);
        JLabel sizeLabel = new JLabel("Size");
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(5, 0, 0, 0);
        add(sizeLabel, constraints);
        ((JSpinner.DefaultEditor) sizeSpinner.getEditor()).getTextField().setEditable(false);
        sizeSpinner.setPreferredSize(new Dimension(50, 25));
        JList<Integer> sizeList = new JList<>(sizes);
        sizeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        sizeList.setFixedCellHeight(20);
        sizeList.setSelectedValue(12, false);
        sizeList.addListSelectionListener(event -> sizeSpinner.setValue(sizeList.getSelectedValue()));
        sizeSpinner.addChangeListener(event -> {
            PreviewContainer.setFontSize((float) getFontSize());
            int index = this.sizes.indexOf(getFontSize());
            if (index >= 0) {
                sizeList.setSelectedIndex(index);
                sizeList.ensureIndexIsVisible(index);
            }
        });
        constraints.gridy = 1;
        constraints.insets = new Insets(5, 0, 10, 10);
        add(sizeSpinner, constraints);
        JScrollPane sizePane = new JScrollPane(sizeList);
        sizePane.setPreferredSize(new Dimension(50, 100));
        constraints.gridy = 2;
        add(sizePane, constraints);
    }

    /**
     * Gets the selected font size
     * @return The selected font size
     */
    public int getFontSize() {
        return (Integer) sizeSpinner.getValue();
    }
}