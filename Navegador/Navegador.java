package br.ufpr.tads.agenda.ui;

/**
 *
 * @author Dieval Guizelini
 */
public class Navegador extends javax.swing.JToolBar {
    private javax.swing.JButton[] buttons;
    
    public Navegador() {
        super();
        
        buttons = new javax.swing.JButton[10];
        buttons[0] = new javax.swing.JButton("");
        buttons[0].setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufpr/tads/agenda/ui/resource/first16.png"))); 
        buttons[1] = new javax.swing.JButton("");
        buttons[1].setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufpr/tads/agenda/ui/resource/prior16.png"))); 
        buttons[2] = new javax.swing.JButton("");
        buttons[2].setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufpr/tads/agenda/ui/resource/next16.png"))); 
        buttons[3] = new javax.swing.JButton("");
        buttons[3].setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufpr/tads/agenda/ui/resource/last16.png"))); 
        buttons[4] = new javax.swing.JButton("");
        buttons[4].setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufpr/tads/agenda/ui/resource/insert16.png"))); 
        buttons[5] = new javax.swing.JButton("");
        buttons[5].setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufpr/tads/agenda/ui/resource/delete16.png"))); 
        buttons[6] = new javax.swing.JButton("");
        buttons[6].setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufpr/tads/agenda/ui/resource/edit16.png"))); 
        buttons[7] = new javax.swing.JButton("");
        buttons[7].setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufpr/tads/agenda/ui/resource/save16.png"))); 
        buttons[8] = new javax.swing.JButton("");
        buttons[8].setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufpr/tads/agenda/ui/resource/cancel16.png"))); 
        buttons[9] = new javax.swing.JButton("");
        buttons[9].setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufpr/tads/agenda/ui/resource/refresh16.png"))); 
        for(javax.swing.JButton b : buttons) {
            super.add(b);
        }
    }
    
}
