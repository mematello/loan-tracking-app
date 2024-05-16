/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marcusoliver.loan.tracker;

import javax.swing.DefaultCellEditor;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Carl Joshua
 */
public class NumericCellEditor extends DefaultCellEditor {
    private JTextField textField;

    public NumericCellEditor() {
        super(new JTextField());
        textField = (JTextField) getComponent();
        textField.setDocument(new NumericDocument());
    }

    @Override
    public Object getCellEditorValue() {
        return textField.getText();
    }

    public class NumericDocument extends PlainDocument {
        @Override
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
            if (str.matches("[0-9]*")) {
                super.insertString(offs, str, a);
            }
        }
    }
}
