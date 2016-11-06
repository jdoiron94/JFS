package ui;

import ui.panels.ButtonContainer;
import ui.panels.FamilyContainer;
import ui.panels.SizeContainer;
import ui.panels.StyleContainer;
import ui.panels.PreviewContainer;
import util.OperatingSystem;
import util.ResourceLoader;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import java.awt.Font;
import java.awt.Image;
import java.io.InputStream;

/**
 * @author Jacob
 * @since 11/5/2016
 */
public class FontSelector extends JDialog {

    private final FamilyContainer family;
    private final StyleContainer style;
    private final SizeContainer size;

    public FontSelector() {
        setLAF();
        setTitle("Java Font Selector");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
        this.family = new FamilyContainer();
        this.style = new StyleContainer();
        this.size = new SizeContainer();
        ResourceLoader loader = new ResourceLoader("icons/");
        InputStream stream = loader.getStream("icon.png");
        if (stream != null) {
            byte[] bytes = loader.readStream(stream);
            Image icon = new ImageIcon(bytes).getImage();
            setIconImage(icon);
        }
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.LINE_AXIS));
        north.add(family);
        north.add(style);
        north.add(size);
        JPanel south = new JPanel();
        south.setLayout(new BoxLayout(south, BoxLayout.PAGE_AXIS));
        south.add(new PreviewContainer(north.getPreferredSize().width));
        south.add(new ButtonContainer(this));
        add(north);
        add(south);
        pack();
        setModal(true);
        setResizable(false);
        setLocationRelativeTo(getOwner());
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    /**
     * Sets the look and feel to the default system look and feel
     */
    protected void setLAF() {
        if (OperatingSystem.getSystem() == OperatingSystem.MAC) {
            System.setProperty("apple.laf.useScreenMenuBar", "true");
        } else {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Shows the FontSelector dialog and returns the selected font
     * @return The selected font
     */
    public Font showDialog() {
        setVisible(true);
        String family = this.family.getFamily();
        int style = this.style.getStyle();
        int size = this.size.getFontSize();
        dispose();
        return new Font(family, style, size);
    }
}