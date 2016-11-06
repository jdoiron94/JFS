package ui.panels;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

/**
 * @author Jacob
 * @since 11/5/2016
 */
public class StyleContainer extends JPanel {

    private final JList<String> styles = new JList<>();

    public StyleContainer() {
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        JLabel fontStyle = new JLabel("Style");
        styles.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        styles.setFixedCellHeight(20);
        DefaultListModel<String> model = new DefaultListModel<>();
        Object[][] options = {{"Regular", Font.PLAIN}, {"Italic", Font.ITALIC}, {"Bold", Font.BOLD},
                {"Bold Italic", Font.BOLD | Font.ITALIC}};
        for (Object[] option : options) {
            model.addElement((String) option[0]);
        }
        styles.setModel(model);
        styles.setSelectedIndex(0);
        styles.addListSelectionListener(e -> PreviewContainer.setFontStyle(getStyle()));
        JScrollPane stylePane = new JScrollPane(styles);
        stylePane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        stylePane.setPreferredSize(new Dimension(140, 140));
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(5, 0, 0, 0);
        add(fontStyle, constraints);
        constraints.insets = new Insets(5, 0, 10, 10);
        constraints.gridy = 1;
        add(stylePane, constraints);
    }

    /**
     * Gets the selected font style
     * @return The selected font style
     */
    public int getStyle() {
        int index = styles.getSelectedIndex();
        if (index == 0) {
            return Font.PLAIN;
        } else if (index == 1) {
            return Font.ITALIC;
        } else if (index == 2) {
            return Font.BOLD;
        } else {
            return Font.BOLD | Font.ITALIC;
        }
    }
}