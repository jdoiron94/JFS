package ui.panels;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jacob
 * @since 11/5/2016
 */
public class FamilyContainer extends JPanel {

    private final JList<String> fonts = new JList<>();

    public FamilyContainer() {
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        JLabel fontFamily = new JLabel("Font");
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(5, 0, 0, 0);
        add(fontFamily, constraints);
        fonts.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        fonts.setFixedCellHeight(20);
        fonts.setModel(getModel());
        fonts.addListSelectionListener(event -> PreviewContainer.setFontName(fonts.getSelectedValue()));
        fonts.setSelectedIndex(0);
        JScrollPane pane = new JScrollPane(fonts);
        pane.setPreferredSize(new Dimension(175, 140));
        constraints.insets = new Insets(5, 10, 10, 10);
        constraints.gridy = 1;
        add(pane, constraints);
    }

    /**
     * Gets the list of fonts supported on the device
     * @return The list of supported fonts
     */
    public List<String> loadFonts() {
        GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        List<String> fonts = new ArrayList<>();
        if (environment != null) {
            for (Font font : environment.getAllFonts()) {
                for (char character : font.getFontName().toCharArray()) {
                    if (!font.canDisplay(character)) {
                        break;
                    }
                }
                fonts.add(font.getName());
            }
        }
        return fonts;
    }

    /**
     * Generates the list model of available fonts
     * @return The DefaultListModel for all available fonts
     */
    private DefaultListModel<String> getModel() {
        List<String> fonts = loadFonts();
        DefaultListModel<String> model = new DefaultListModel<>();
        fonts.forEach(model::addElement);
        return model;
    }

    /**
     * Gets the selected font family name
     * @return The selected font family name
     */
    public String getFamily() {
        return fonts.getSelectedValue();
    }
}