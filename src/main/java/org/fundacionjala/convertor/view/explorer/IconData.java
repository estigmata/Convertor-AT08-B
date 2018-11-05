package org.fundacionjala.convertor.view.explorer;

import javax.swing.Icon;

/**
 * Class Icon Data.
 */
class IconData {
    protected Icon m_icon;
    protected Icon m_expandedIcon;
    protected Object m_data;

    /**
     * Constructor.
     *
     * @param icon Icon object.
     * @param data object.
     */
    public IconData(Icon icon, Object data) {
        m_icon = icon;
        m_expandedIcon = null;
        m_data = data;
    }

    /**
     * Constructor.
     *
     * @param icon         Icon object.
     * @param expandedIcon Icon object.
     * @param data         Object data.
     */
    public IconData(Icon icon, Icon expandedIcon, Object data) {
        m_icon = icon;
        m_expandedIcon = expandedIcon;
        m_data = data;
    }

    /**
     * Method to get Icon.
     *
     * @return Icon object.
     */
    public Icon getIcon() {
        return m_icon;
    }

    /**
     * Method to get Expanded Icon.
     *
     * @return Icon object.
     */
    public Icon getExpandedIcon() {
        return m_expandedIcon != null ? m_expandedIcon : m_icon;
    }

    /**
     * Method to get Object.
     *
     * @return Object.
     */
    public Object getObject() {
        return m_data;
    }

    /**
     * Method to String.
     *
     * @return String.
     */
    public String toString() {
        return m_data.toString();
    }
}
