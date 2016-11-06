package ui.panels;

import ui.view.CenteredEditorKit;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

/**
 * @author Jacob
 * @since 11/5/2016
 */
public class PreviewContainer extends JPanel {

    private static final JTextPane preview = new JTextPane();

    public PreviewContainer(int width) {
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        setBorder(BorderFactory.createTitledBorder("Preview:"));
        CenteredEditorKit kit = new CenteredEditorKit();
        preview.setEditorKit(kit);
        preview.setText("aAbBcCdDeEfF");
        preview.setEditable(false);
        JScrollPane pane = new JScrollPane(preview);
        pane.setPreferredSize(new Dimension(width, 100));
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets =  new Insets(0, 0, 0, 0);
        add(pane, constraints);
    }

    /**
     * Sets the font style for the preview container
     * @param style The font style to set
     */
    protected static void setFontStyle(int style) {
        preview.setFont(preview.getFont().deriveFont(style));
    }

    /**
     * Sets the font size for the preview container
     * @param size The font size to set
     */
    protected static void setFontSize(float size) {
        preview.setFont(preview.getFont().deriveFont(size));
    }

    /**
     * Sets the font name for the preview container
     * @param name The font name to set
     */
    protected static void setFontName(String name) {
        preview.setFont(new Font(name, preview.getFont().getStyle(), preview.getFont().getSize()));
    }
}