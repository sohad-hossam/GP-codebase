package unisa.gps.etour.gui.operatoreagenzia.tables;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import unisa.gps.etour.gui.operatoreagenzia.Home;

/**
 * <b>MediaVotiRenderer</b>
 * <p>
 * This class creates a custom renderer for the average ratings of a
 * Site.</p>
 *
 * @See javax.swing.table.DefaultTableRenderer;
 * @See javax.swing.table.TableCellRenderer;
 * @Version 1.0
 * @Author Mario Gallo
 */
public class MediaVotiRenderer extends DefaultTableCellRenderer {

    /**
     * Method that returns the custom component for the
     * Display of the data contained in the cell of a table.
     *
     * @param pTable   JTable - the table.
     * @param pValue   Object - the data.
     * @param pSelected boolean -
     *                 <ul>
     *                 <li><i>True</i> if the selected cell.
     *                 <li><i>False</i> otherwise.
     *                 </ul>
     * @param pFocus   boolean -
     *                 <ul>
     *                 <li><i>True</i> if the cell has the focus.
     *                 <li><i>False</i> otherwise.
     *                 </ul>
     * @param pRow     int - the line number.
     * @param pColumn  int - the column number.
     * @return Component - the component that customizes render the cell.
     * @throws IllegalArgumentException - if the value of the cell can not
     *                                  Be rendered by this renderer.
     */
    public Component getTableCellRendererComponent(JTable pTable, Object pValue, boolean pSelected, boolean pFocus, int pRow, int pColumn) throws IllegalArgumentException {
        if ((pValue instanceof Double || pValue instanceof Integer)) {
            throw new IllegalArgumentException("Value cell unexpected.");
        }
        double rating = 0;
        if (pValue instanceof Double) {
            rating = (Double) pValue;
        } else {
            rating += (Integer) pValue;
        }

        JLabel aLabel = new JLabel("");
        aLabel.setHorizontalAlignment(JLabel.CENTER);

        if (rating > 4) {
            aLabel.setIcon(new ImageIcon(getClass().getResource(Home.URL_IMAGES + "stella5.gif")));
        } else if (rating <= 4 && rating > 3) {
            aLabel.setIcon(new ImageIcon(getClass().getResource(Home.URL_IMAGES + "stella4.gif")));
        } else if (rating <= 3 && rating > 2) {
            aLabel.setIcon(new ImageIcon(getClass().getResource(Home.URL_IMAGES + "stella3.gif")));
        } else if (rating <= 2 && rating > 1) {
            aLabel.setIcon(new ImageIcon(getClass().getResource(Home.URL_IMAGES + "stella2.gif")));
        } else {
            aLabel.setIcon(new ImageIcon(getClass().getResource(Home.URL_IMAGES + "stella1.gif")));
        }
        return aLabel;
    }
}
