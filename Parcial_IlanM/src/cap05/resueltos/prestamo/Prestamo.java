/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cap05.resueltos.prestamo;

/**
 *
 * @author carlo
 */
public class Prestamo extends javax.swing.JFrame {
    private double pagoMensual;
    private void jtablaPrestamoMouseClicked(java.awt.event.MouseEvent evt) {
    Object datoCelda = jtablaPrestamo.getValueAt(
                        jtablaPrestamo.getSelectedRow(),
                        jtablaPrestamo.getSelectedColumn());
    if (datoCelda != null && tablaPagos) {
        StringBuffer s = new StringBuffer(datoCelda.toString());
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '.') s.delete(i, i + 1);
            if (s.charAt(i) == ',') s.setCharAt(i, '.');
        }
        pagoMensual = Double.parseDouble(s.toString());
        jbtCalculoAmort.setEnabled(true);
    }
}
    private StringBuffer AlinDer(String patron, double dato) {
        java.text.FieldPosition fp =
            new java.text.FieldPosition(java.text.NumberFormat.FRACTION_FIELD);
        java.text.DecimalFormatSymbols simbolos =
        new java.text.DecimalFormatSymbols(new java.util.Locale("es", "ES"));
    java.text.DecimalFormat formato = new java.text.DecimalFormat(patron, simbolos);
        StringBuffer salida = new StringBuffer();
        formato.format(dato, salida, fp);
        for (int i = 0; i < (patron.length() - fp.getEndIndex()); i++)
            salida.insert(0, ' ');
        return salida;
}
    private int tiposIntrs;
    private int añosMeses;
    private javax.swing.JTable jtablaPrestamo;
    private javax.swing.JTable jtablaCabsFilas;
    private double credito;
    private int periodoMax, periodoMin;
    private double interesMin, interesMax;
    private double incremento;
    private boolean tablaPagos;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Prestamo.class.getName());

    /**
     * Creates new form Prestamo
     */
    public Prestamo() {
        initComponents();
        this.setTitle("Prestamo Bancario");
        setLocationRelativeTo(null);
        tiposIntrs = 18;
        añosMeses = 4;
        jmItemAños.setEnabled(false);
        jPanel1.setBorder(new javax.swing.border.TitledBorder("Años del préstamo"));
        jtfCredito.setText("6000");
        jtfPeriodoMax.setText("1");
        jtfPeriodoMin.setText("1");
        jtfInteresMax.setText("10.00");
        jtfInteresMin.setText("0.00");
        jcbIncremento.setSelectedIndex(2);
        initTable(tiposIntrs, añosMeses + 1);
    }
    private void initTable(final int filasTabla, final int colsTabla) {

        class CModeloTablaPrestamo extends javax.swing.table.AbstractTableModel {
            Object dato[][] = new Object[filasTabla][colsTabla];
            String cabecera[] = new String[colsTabla];
            boolean editColum[] = new boolean[colsTabla];

            CModeloTablaPrestamo() {
                for (int c = 0; c < colsTabla; ++c) {
                    cabecera[c] = "Columna " + c;
                    if (c != 0) editColum[c] = true;
                }
            }

            public int getColumnCount() { return cabecera.length; }
            public int getRowCount() { return dato.length; }
            public String getColumnName(int col) { return cabecera[col]; }

            public Object getValueAt(int fila, int col) {
                return dato[fila][col];
            }

            public void setValueAt(Object obj, int fila, int col) {
                dato[fila][col] = obj;
            }

            public boolean isCellEditable(int indFila, int indColum) {
                return editColum[indColum];
            }
        };

        javax.swing.table.TableColumnModel modeloColums =
            new javax.swing.table.DefaultTableColumnModel() {
            boolean primeraCol = true;

            public void addColumn(javax.swing.table.TableColumn col) {
                if (primeraCol) { primeraCol = false; return; }
                col.setMinWidth(110);
                super.addColumn(col);
            }
        };

        javax.swing.table.TableColumnModel modeloCabsFilas =
            new javax.swing.table.DefaultTableColumnModel() {
            boolean primeraCol = true;

            public void addColumn(javax.swing.table.TableColumn col) {
                if (primeraCol) {
                    col.setMaxWidth(55);
                    super.addColumn(col);
                    primeraCol = false;
                }
            }
        };

        javax.swing.table.TableModel modeloTabla = new CModeloTablaPrestamo();

        jtablaPrestamo = new javax.swing.JTable(modeloTabla, modeloColums);

        jtablaCabsFilas = new javax.swing.JTable(modeloTabla, modeloCabsFilas);

        jtablaPrestamo.createDefaultColumnsFromModel();
        jtablaCabsFilas.createDefaultColumnsFromModel();
        jtablaPrestamo.setSelectionModel(jtablaCabsFilas.getSelectionModel());
        jtablaCabsFilas.setBackground(java.awt.Color.lightGray);
        jtablaCabsFilas.setSelectionBackground(java.awt.Color.lightGray);
        jtablaPrestamo.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtablaCabsFilas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtablaPrestamo.setFont(new java.awt.Font("Courier New", 0, 12));
        jtablaCabsFilas.setFont(new java.awt.Font("Courier New", 0, 12));
        jScrollPane1.setViewportView(jtablaPrestamo);
        javax.swing.JViewport jv = new javax.swing.JViewport();
        jv.setView(jtablaCabsFilas);
        jv.setPreferredSize(jtablaCabsFilas.getMaximumSize());
        jScrollPane1.setRowHeader(jv);
        jtablaPrestamo.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        jtablaPrestamoMouseClicked(evt);
    }
});
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jtfCredito = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtfPeriodoMax = new javax.swing.JTextField();
        jtfPeriodoMin = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jtfInteresMin = new javax.swing.JTextField();
        jtfInteresMax = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jcbIncremento = new javax.swing.JComboBox<>();
        jbtCalculoPagos = new javax.swing.JButton();
        jbtCalculoAmort = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmnuOpciones = new javax.swing.JMenu();
        jmItemInstruc = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jmItemSalir = new javax.swing.JMenuItem();
        jmnuPrestamoEn = new javax.swing.JMenu();
        jmItemAños = new javax.swing.JMenuItem();
        jmItemMeses = new javax.swing.JMenuItem();
        jmnuAyuda = new javax.swing.JMenu();
        jmItemAcercaDe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Credito:");

        jtfCredito.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Duracion del Prestamo"));

        jLabel2.setText("Maximo:");

        jtfPeriodoMax.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jtfPeriodoMin.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel3.setText("Minimo:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfPeriodoMin)
                    .addComponent(jtfPeriodoMax))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfPeriodoMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfPeriodoMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(6, 6, 6))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de interés"));

        jLabel5.setText("% Maximo:");

        jtfInteresMin.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jtfInteresMax.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel4.setText("% Minimo:");

        jLabel6.setText("Incremento:");

        jcbIncremento.setEditable(true);
        jcbIncremento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0.10", "0.25", "0.50", "1.00" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfInteresMin)
                    .addComponent(jtfInteresMax)
                    .addComponent(jcbIncremento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtfInteresMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfInteresMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbIncremento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(3, 3, 3))
        );

        jbtCalculoPagos.setText("Pagos");
        jbtCalculoPagos.addActionListener(this::jbtCalculoPagosActionPerformed);

        jbtCalculoAmort.setText("Amortización");
        jbtCalculoAmort.setEnabled(false);
        jbtCalculoAmort.addActionListener(this::jbtCalculoAmortActionPerformed);

        jmnuOpciones.setMnemonic('O');
        jmnuOpciones.setText("Opciones");

        jmItemInstruc.setMnemonic('I');
        jmItemInstruc.setText("Instrucciones");
        jmItemInstruc.addActionListener(this::jmItemInstrucActionPerformed);
        jmnuOpciones.add(jmItemInstruc);
        jmnuOpciones.add(jSeparator1);

        jmItemSalir.setMnemonic('S');
        jmItemSalir.setText("Salir");
        jmItemSalir.addActionListener(this::jmItemSalirActionPerformed);
        jmnuOpciones.add(jmItemSalir);

        jMenuBar1.add(jmnuOpciones);

        jmnuPrestamoEn.setMnemonic('P');
        jmnuPrestamoEn.setText("Préstamo en...");

        jmItemAños.setMnemonic('A');
        jmItemAños.setText("Años");
        jmItemAños.addActionListener(this::jmItemAñosActionPerformed);
        jmnuPrestamoEn.add(jmItemAños);

        jmItemMeses.setMnemonic('M');
        jmItemMeses.setText("Meses");
        jmItemMeses.addActionListener(this::jmItemAñosMesesActionPerforme);
        jmnuPrestamoEn.add(jmItemMeses);

        jMenuBar1.add(jmnuPrestamoEn);

        jmnuAyuda.setMnemonic('A');
        jmnuAyuda.setText("Ayuda");

        jmItemAcercaDe.setMnemonic('A');
        jmItemAcercaDe.setText("Acerca de Préstamo...");
        jmItemAcercaDe.addActionListener(this::jmItemAcercaDeActionPerformed);
        jmnuAyuda.add(jmItemAcercaDe);

        jMenuBar1.add(jmnuAyuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtCalculoPagos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtCalculoAmort, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jtfCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtCalculoPagos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtCalculoAmort)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmItemInstrucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmItemInstrucActionPerformed
        // TODO add your handling code here:
        String mensaje;
mensaje = "Introduzca el crédito, la duración del préstamo y el tipo\n";
mensaje += "de interés. Pulse el botón [Pagos] para visualizar\n";
mensaje += "los pagos mensuales en la rejilla.\n\n";
mensaje += "Elija un pago mensual y pulse el botón [Amortización]\n";
mensaje += "para visualizar el plan de amortización para el interés\n";
mensaje += "y periodos correspondientes al pago elegido.\n\n";
mensaje += "Para copiar datos en el portapapeles, seleccione las celdas\n";
mensaje += "que desee y pulse las teclas Ctrl+c.\n";
javax.swing.JOptionPane.showMessageDialog(
        null, mensaje, "Instrucciones",
        javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jmItemInstrucActionPerformed

    private void jmItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmItemSalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jmItemSalirActionPerformed

    private void jmItemAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmItemAcercaDeActionPerformed
        // TODO add your handling code here:
        javax.swing.JOptionPane.showMessageDialog(
            null,
            "Aplicación Préstamo. Versión 1.0\nCopyright (c) Ilan Motta, 2026",
            "Acerca de Préstamo",
            javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jmItemAcercaDeActionPerformed

    private void jmItemAñosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmItemAñosActionPerformed
        // TODO add your handling code here:
        Object item = evt.getSource();
        String tituloMarco = "";

        if (item == jmItemAños) {
            jmItemAños.setEnabled(false);
            jmItemMeses.setEnabled(true);
            tituloMarco = "Años del préstamo";
        } else if (item == jmItemMeses) {
            jmItemAños.setEnabled(true);
            jmItemMeses.setEnabled(false);
            tituloMarco = "Meses del préstamo";
        }

        jPanel1.setBorder(
          new javax.swing.border.TitledBorder(tituloMarco));
    }//GEN-LAST:event_jmItemAñosActionPerformed

    private void jmItemAñosMesesActionPerforme(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmItemAñosMesesActionPerforme
        // TODOadd your handling code here:
        jmItemAñosActionPerformed(evt);
    }//GEN-LAST:event_jmItemAñosMesesActionPerforme

    private void jbtCalculoPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCalculoPagosActionPerformed
        // TODO add your handling code here:
        try {
        credito = Double.parseDouble(jtfCredito.getText());
        periodoMin = Integer.parseInt(jtfPeriodoMin.getText());
        periodoMax = Integer.parseInt(jtfPeriodoMax.getText());
        interesMin = Double.parseDouble(jtfInteresMin.getText());
        interesMax = Double.parseDouble(jtfInteresMax.getText());
        incremento = Double.parseDouble((String) jcbIncremento.getSelectedItem());

        if (credito <= 0 ||
            periodoMin <= 0 || periodoMax <= 0 || periodoMax < periodoMin ||
            interesMin < 0 || interesMax < 0 || interesMax < interesMin)
            throw new NumberFormatException();
    } catch (NumberFormatException e) {
        javax.swing.JOptionPane.showMessageDialog(
                null, "Datos no válidos",
                "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        return;
    }

    tiposIntrs = (int) ((interesMax - interesMin) / incremento) + 1;
    añosMeses = (periodoMax - periodoMin) + 1;

    int filas = tiposIntrs, cols = añosMeses;
    if (tiposIntrs < 18) filas = 18;
    if (añosMeses < 4) cols = 4;

    initTable(filas, cols + 1);

    jtablaCabsFilas.setValueAt(AlinDer("##0.00", interesMin) + "%", 0, 0);
    for (int fila = 1; fila < tiposIntrs; ++fila)
        jtablaCabsFilas.setValueAt(AlinDer("##0.00",
            interesMin + incremento * fila) + "%", fila, 0);

    javax.swing.table.TableColumn colum = null;
    String per = " años";
    if (jmItemAños.isEnabled()) per = " meses";
    for (int columna = 0; columna < añosMeses; ++columna) {
        colum = jtablaPrestamo.getColumnModel().getColumn(columna);
        colum.setHeaderValue((periodoMin + columna) + per);
    }

    int P = 0;
    if (!jmItemAños.isEnabled())
        P = 12;
    else
        P = 1;  

    double interes = 0.0, pagoMensualCalc = 0.0;
    int meses;
    for (int fila = 0; fila < tiposIntrs; ++fila) {
        String sinteres = jtablaCabsFilas.getValueAt(fila, 0).toString();
        sinteres = sinteres.substring(0, sinteres.indexOf('%'));
        sinteres = sinteres.replace(',', '.');
        interes = Double.parseDouble(sinteres) / 100 / 12;
        for (int columna = 0; columna < añosMeses; ++columna) {    
            colum = jtablaPrestamo.getColumnModel().getColumn(columna);
            String smeses = (String) colum.getHeaderValue();
            smeses = smeses.substring(0, smeses.indexOf(' '));
            meses = Integer.parseInt(smeses) * P;    
            if (interes == 0.0)
                pagoMensualCalc = credito / meses;
            else
                pagoMensualCalc = credito * (interes / (1 - (1 /
                            (Math.pow(1.0 + interes, (double) meses)))));
            jtablaPrestamo.setValueAt(AlinDer("###,###,##0.00",
                pagoMensualCalc), fila, columna);
        }
    }
    tablaPagos = true;
    }//GEN-LAST:event_jbtCalculoPagosActionPerformed

    private void jbtCalculoAmortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCalculoAmortActionPerformed
        // TODO add your handling code here:
        int fila = jtablaPrestamo.getSelectedRow();
    int columna = jtablaPrestamo.getSelectedColumn();
    String sinteres = (String) jtablaCabsFilas.getValueAt(fila, 0);
    sinteres = sinteres.substring(0, sinteres.indexOf('%'));
    sinteres = sinteres.replace(',', '.');
    double interes = Double.parseDouble(sinteres) / 100 / 12;

    int P = 0;
    if (!jmItemAños.isEnabled())
        P = 12;
    else
        P = 1; 
    javax.swing.table.TableColumn colum = null;
    colum = jtablaPrestamo.getColumnModel().getColumn(columna);
    String smeses = (String) colum.getHeaderValue();
    smeses = smeses.substring(0, smeses.indexOf(' '));
    int meses = Integer.parseInt(smeses) * P;
    int filas = meses, cols = 5;
    if (filas < 18) filas = 18;

    initTable(filas, cols);

    for (int mes = 0; mes < meses; ++mes)
        jtablaCabsFilas.setValueAt(AlinDer("####", mes + 1), mes, 0);

    String cab[] = {"Capital", "Intereses", "Capital pendiente",
                     "Total intereses"};
    for (columna = 0; columna < 4; ++columna) {
        colum = jtablaPrestamo.getColumnModel().getColumn(columna);
        colum.setHeaderValue(cab[columna]);
    }

    double interesesMensuales = 0, creditoPendiente = credito;
    double capitalMensualAmort = 0, totalIntereses = 0;
    String formato = "###,###,##0.00";
    for (int mes = 0; mes < meses; ++mes) {
        interesesMensuales = creditoPendiente * interes;
        capitalMensualAmort = pagoMensual - interesesMensuales;
        creditoPendiente -= pagoMensual - interesesMensuales;
        totalIntereses += interesesMensuales;
        jtablaPrestamo.setValueAt(AlinDer(formato, capitalMensualAmort), mes, 0);
        jtablaPrestamo.setValueAt(AlinDer(formato, interesesMensuales), mes, 1);
        jtablaPrestamo.setValueAt(AlinDer(formato, creditoPendiente), mes, 2);
        jtablaPrestamo.setValueAt(AlinDer(formato, totalIntereses), mes, 3);
    }
    jbtCalculoAmort.setEnabled(false);
    tablaPagos = false;
    }//GEN-LAST:event_jbtCalculoAmortActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Prestamo().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JButton jbtCalculoAmort;
    private javax.swing.JButton jbtCalculoPagos;
    private javax.swing.JComboBox<String> jcbIncremento;
    private javax.swing.JMenuItem jmItemAcercaDe;
    private javax.swing.JMenuItem jmItemAños;
    private javax.swing.JMenuItem jmItemInstruc;
    private javax.swing.JMenuItem jmItemMeses;
    private javax.swing.JMenuItem jmItemSalir;
    private javax.swing.JMenu jmnuAyuda;
    private javax.swing.JMenu jmnuOpciones;
    private javax.swing.JMenu jmnuPrestamoEn;
    private javax.swing.JTextField jtfCredito;
    private javax.swing.JTextField jtfInteresMax;
    private javax.swing.JTextField jtfInteresMin;
    private javax.swing.JTextField jtfPeriodoMax;
    private javax.swing.JTextField jtfPeriodoMin;
    // End of variables declaration//GEN-END:variables
}
