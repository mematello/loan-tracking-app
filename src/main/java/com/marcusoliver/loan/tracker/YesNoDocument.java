/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marcusoliver.loan.tracker;

import javax.swing.text.Document;

/**
 *
 * @author Carl Joshua
 */
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class YesNoDocument extends PlainDocument {
    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        String currentText = getText(0, getLength());
        StringBuilder filteredText = new StringBuilder(currentText.substring(0, offs));

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isLetter(c) && (currentText.length() + filteredText.length() < 3)) {
                filteredText.append(Character.toLowerCase(c));
            }
        }

        String newText = filteredText.toString() + currentText.substring(offs);
        if (newText.equalsIgnoreCase("yes") || newText.equalsIgnoreCase("no")) {
            super.remove(0, getLength());
            super.insertString(0, newText, a);
        }
    }
}
