/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

/**
 *
 * @author Jesus
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo = new javax.swing.JPanel();
        CampoUsuario = new java.awt.TextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        BtnIngresar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        CampoPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(400, 500));

        Fondo.setBackground(new java.awt.Color(102, 102, 102));
        Fondo.setMinimumSize(new java.awt.Dimension(400, 500));
        Fondo.setPreferredSize(new java.awt.Dimension(500, 500));
        Fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Fondo.add(CampoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 150, 20));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Jesus\\Documents\\ITO\\verano\\ProyectoFelinus\\src\\main\\java\\vista\\user32.png")); // NOI18N
        Fondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, -1, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Jesus\\Documents\\ITO\\verano\\ProyectoFelinus\\src\\main\\java\\vista\\pass32.png")); // NOI18N
        Fondo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Jesus\\Documents\\ITO\\verano\\ProyectoFelinus\\src\\main\\java\\vista\\user128.png")); // NOI18N
        Fondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, -1));

        BtnIngresar.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        BtnIngresar.setText("Ingresar");
        Fondo.add(BtnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 370, 120, 51));

        jLabel4.setFont(new java.awt.Font("Arial Narrow", 3, 24)); // NOI18N
        jLabel4.setText("FELINUS");
        Fondo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, 90, 33));

        CampoPassword.setBackground(new java.awt.Color(255, 255, 255));
        Fondo.add(CampoPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, 150, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BtnIngresar;
    public javax.swing.JPasswordField CampoPassword;
    public java.awt.TextField CampoUsuario;
    private javax.swing.JPanel Fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
