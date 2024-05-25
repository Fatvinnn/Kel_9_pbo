
package aplikasikasir;

import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.event.DocumentEvent;
import javax.swing.table.DefaultTableModel;
import java.util.UUID;

public class FormKasir extends javax.swing.JFrame {

    /**
     * Creates new form FormKasir
     */
   
    
    NumberFormat nf = NumberFormat.getNumberInstance(new Locale ("in", "ID"));
    public FormKasir() {
        initComponents();
        KodeBarang();
        TotalHarga();
        UUID uuid = UUID.randomUUID();
        String shortUuid = uuid.toString().substring(0,8);
        txtFaktur.setText(shortUuid);
        Diskon();
    }
    
        private void Diskon(){
        tfdiskon.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                //DISKON
                int hasilDiskon;
                if(tfdiskon.getText().equals("")){
                hasilDiskon = 0; 
                tfhargadiskon.setText("0");
                }
                else {
                    hasilDiskon = Integer.parseInt(txtJumlahHarga.getText().replace(".", ""))
                        * Integer.parseInt(tfdiskon.getText()) / 100 ;

                }
                tfhargadiskon.setText(nf.format(hasilDiskon));

                //PPN
                int ppn = 0;
                if (chkppn.isSelected()){
                    ppn = Integer.parseInt(txtTotalHarga.getText().replace(".", "")) * 11/100 ;
                    tfhasilppn.setText("Rp. " +nf.format(ppn));
                }
                else{
                    ppn = 0;
                    tfhasilppn.setText("Rp. " + nf.format(ppn));
                }

                // TOTAL BERSIH SEMUA
                int totalBersih;
                totalBersih = Integer.parseInt(txtTotalHarga.getText().replace(".", "")) - hasilDiskon + ppn;
                tftotalhargaakhir.setText("Rp. " + nf.format(totalBersih));
                jLabel1.setText(tftotalhargaakhir.getText());

        
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                //DISKON
                //DISKON
                int hasilDiskon;
                if(tfdiskon.getText().equals("")){
                hasilDiskon = 0; 
                tfhargadiskon.setText("0");
                }
                else {
                    hasilDiskon = Integer.parseInt(txtTotalHarga.getText().replace(".", ""))
                        * Integer.parseInt(tfdiskon.getText()) / 100 ;

                }
                tfhargadiskon.setText(nf.format(hasilDiskon));

                //PPN
                int ppn = 0;
                if (chkppn.isSelected()){
                    ppn = Integer.parseInt(txtTotalHarga.getText().replace(".", "")) * 11/100 ;
                    tfhasilppn.setText("Rp. " +nf.format(ppn));
                }
                else{
                    ppn = 0;
                    tfhasilppn.setText("Rp. " + nf.format(ppn));
                }

                // TOTAL BERSIH SEMUA
                int totalBersih;
                totalBersih = Integer.parseInt(txtTotalHarga.getText().replace(".", "")) - hasilDiskon + ppn;
                txtTotalHarga.setText("Rp. " + nf.format(totalBersih));
                jLabel1.setText(tftotalhargaakhir.getText());

        
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                //DISKON
                int hasilDiskon;
                if(tfdiskon.getText().equals("")){
                hasilDiskon = 0; 
                tfhargadiskon.setText("0");
                }
                else {
                    hasilDiskon = Integer.parseInt(txtTotalHarga.getText().replace(".", ""))
                        * Integer.parseInt(tfdiskon.getText()) / 100 ;

                }
                tfhargadiskon.setText(nf.format(hasilDiskon));

                //PPN
                int ppn = 0;
                if (chkppn.isSelected()){
                    ppn = Integer.parseInt(txtTotalHarga.getText().replace(".", "")) * 11/100 ;
                    tfhasilppn.setText("Rp. " +nf.format(ppn));
                }
                else{
                    ppn = 0;
                    tfhasilppn.setText("Rp. " + nf.format(ppn));
                }

                // TOTAL BERSIH SEMUA
                int totalBersih;
                totalBersih = Integer.parseInt(txtTotalHarga.getText().replace(".", "")) - hasilDiskon + ppn;
                tftotalhargaakhir.setText("Rp. " + nf.format(totalBersih));
                jLabel1.setText(tftotalhargaakhir.getText());

        
            }
        });
    }
    
    private void TotalHarga(){
        txtQTY.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent arg0) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                try {
                int hasil = 0;
                if (txtQTY.getText().equals("")){
                    hasil = Integer.parseInt(txtHarga.getText().replace(".", "")) * 0;
                }else {
                     hasil = Integer.parseInt(txtHarga.getText().replace(".", "")) * 
                             Integer.parseInt(txtQTY.getText());
                }
                txtTotalHarga.setText(nf.format(hasil));
                } catch (Exception e) {
                }
            }

            @Override
            public void removeUpdate(DocumentEvent arg0) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                     try {
                int hasil = 0;
                if (txtQTY.getText().equals("")){
                    hasil = Integer.parseInt(txtHarga.getText().replace(".", "")) * 0;
                }else {
                     hasil = Integer.parseInt(txtHarga.getText().replace(".", "")) * 
                             Integer.parseInt(txtQTY.getText());
                }
                txtTotalHarga.setText(nf.format(hasil));
                } catch (Exception e) {
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
    }

    private void KodeBarang (){
        txtKodeBarang.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                String KodeBarang;
                KodeBarang = (String) txtKodeBarang.getText();
                
                switch(KodeBarang){
                case "SR001" : 
                txtNamaBarang.setText("Surya 12");
                txtHarga.setText(nf.format (26000));
                txtQTY.grabFocus();
                break;
                
                case "SR002" : 
                txtNamaBarang.setText("Surya 16");
                txtHarga.setText(nf.format (35000));
                txtQTY.grabFocus();
                break;
                
                case "SR003" : 
                txtNamaBarang.setText("Surya KALENG");
                txtHarga.setText(nf.format (100000));
                txtQTY.grabFocus();
                break;
                
                case "SP001" : 
                txtNamaBarang.setText("Sampoerna 12");
                txtHarga.setText(nf.format (26000));
                txtQTY.grabFocus();
                break;
                
                case "SP002" : 
                txtNamaBarang.setText("Sampoerna 16");
                txtHarga.setText(nf.format (36000));
                txtQTY.grabFocus();
                break;
                
                case "SP003" : 
                txtNamaBarang.setText("Sampoerna 50");
                txtHarga.setText(nf.format (130000));
                txtQTY.grabFocus();
                break;
                
                default :
                    txtNamaBarang.setText("");
                    txtHarga.setText("");
            }
        }

            @Override
            public void removeUpdate(DocumentEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            
                                String KodeBarang;
                KodeBarang = (String) txtKodeBarang.getText();
                
                switch(KodeBarang){
                case "SR001" : 
                txtNamaBarang.setText("Surya 12");
                txtHarga.setText(nf.format (26000));
                txtQTY.grabFocus();
                break;
                
                case "SR002" : 
                txtNamaBarang.setText("Surya 16");
                txtHarga.setText(nf.format (35000));
                txtQTY.grabFocus();
                break;
                
                case "SR003" : 
                txtNamaBarang.setText("Surya KALENG");
                txtHarga.setText(nf.format (100000));
                txtQTY.grabFocus();
                break;
                
                case "SP001" : 
                txtNamaBarang.setText("Sampoerna 12");
                txtHarga.setText(nf.format (26000));
                txtQTY.grabFocus();
                break;
                
                case "SP002" : 
                txtNamaBarang.setText("Sampoerna 16");
                txtHarga.setText(nf.format (36000));
                txtQTY.grabFocus();
                break;
                
                case "SP003" : 
                txtNamaBarang.setText("Sampoerna 50");
                txtHarga.setText(nf.format (130000));
                txtQTY.grabFocus();
                break;
                
                default :
                    txtNamaBarang.setText("");
                    txtHarga.setText("");
            }
        }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtFaktur = new javax.swing.JTextField();
        txtKodeBarang = new javax.swing.JTextField();
        txtNamaBarang = new javax.swing.JTextField();
        txtHarga = new javax.swing.JTextField();
        txtQTY = new javax.swing.JTextField();
        txtTotalHarga = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblList = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtJumlahHarga = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfdiskon = new javax.swing.JTextField();
        tfhargadiskon = new javax.swing.JTextField();
        chkppn = new javax.swing.JCheckBox();
        tfhasilppn = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tftotalhargaakhir = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        lblJmlQty = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Rp.");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Kode Barang");

        jLabel2.setText("No. Faktur");

        txtFaktur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFakturActionPerformed(evt);
            }
        });

        txtKodeBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKodeBarangActionPerformed(evt);
            }
        });

        txtNamaBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaBarangActionPerformed(evt);
            }
        });

        txtHarga.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHargaActionPerformed(evt);
            }
        });

        txtQTY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQTYActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtFaktur, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                    .addComponent(txtKodeBarang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtQTY, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTotalHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtFaktur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQTY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        tblList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Kode barang", "Nama Barang", "Harga ", "QTY", "Total harga "
            }
        ));
        jScrollPane1.setViewportView(tblList);

        jLabel4.setText("Jumlah Harga");

        txtJumlahHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJumlahHargaActionPerformed(evt);
            }
        });

        jLabel5.setText("Diskon");

        tfhargadiskon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfhargadiskonActionPerformed(evt);
            }
        });

        chkppn.setText("PPN 11%");
        chkppn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkppnActionPerformed(evt);
            }
        });

        jLabel6.setText("Total Harga");

        tftotalhargaakhir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tftotalhargaakhirActionPerformed(evt);
            }
        });

        jLabel7.setText("Item yang Dibeli :");

        lblJmlQty.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 905, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(chkppn, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtJumlahHarga)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(tfdiskon, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(tfhasilppn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                                                    .addComponent(tfhargadiskon)))
                                            .addComponent(tftotalhargaakhir))))
                                .addGap(0, 15, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblJmlQty, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblJmlQty))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtJumlahHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfdiskon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfhargadiskon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkppn)
                    .addComponent(tfhasilppn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tftotalhargaakhir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(946, 604));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtFakturActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFakturActionPerformed
        //nang kene bos
    }//GEN-LAST:event_txtFakturActionPerformed

    private void txtKodeBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKodeBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKodeBarangActionPerformed

    private void txtJumlahHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJumlahHargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJumlahHargaActionPerformed

    private void tftotalhargaakhirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tftotalhargaakhirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tftotalhargaakhirActionPerformed

    private void txtQTYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQTYActionPerformed
        // TODO add your handling code here:
        if(txtQTY.getText().equals("")) {
            return;
        }else
        {
            DefaultTableModel model = (DefaultTableModel) tblList.getModel();
            
            Object obj[] = new Object[6];
            obj [1] = txtKodeBarang.getText();
            obj [2] = txtNamaBarang.getText();
            obj [3] = txtHarga.getText();
            obj [4] = txtQTY.getText();
            obj [5] = txtTotalHarga.getText();
            
            model.addRow(obj);
            
            int baris = model.getRowCount();
            for(int a = 0; a < baris; a ++){
                String no = String.valueOf(a + 1);
                model.setValueAt(no + ".", a, 0);
            }
            tblList.setRowHeight(30);
            
            lblJmlQty.setText(String.valueOf(baris));
            
            jmlTotalHarga();
            
            bersih();
        }
    }//GEN-LAST:event_txtQTYActionPerformed

    private void tfhargadiskonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfhargadiskonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfhargadiskonActionPerformed

    private void txtNamaBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaBarangActionPerformed

    private void txtHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHargaActionPerformed

    private void chkppnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkppnActionPerformed
        jmlTotalHarga();
    }//GEN-LAST:event_chkppnActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormKasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormKasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormKasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormKasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormKasir().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chkppn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblJmlQty;
    private javax.swing.JTable tblList;
    private javax.swing.JTextField tfdiskon;
    private javax.swing.JTextField tfhargadiskon;
    private javax.swing.JTextField tfhasilppn;
    private javax.swing.JTextField tftotalhargaakhir;
    private javax.swing.JTextField txtFaktur;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtJumlahHarga;
    private javax.swing.JTextField txtKodeBarang;
    private javax.swing.JTextField txtNamaBarang;
    private javax.swing.JTextField txtQTY;
    private javax.swing.JTextField txtTotalHarga;
    // End of variables declaration//GEN-END:variables

    private void jmlTotalHarga() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    int sub_total = 0;
    for (int a = 0; a < tblList.getRowCount(); a ++){
        sub_total += Integer.parseInt((String) 
                tblList.getValueAt(a, 5 ).toString().replace(".", ""));
    }
          txtJumlahHarga.setText(nf.format(sub_total));
          
             //DISKON
                int hasilDiskon;
                if(tfdiskon.getText().equals("")){
                hasilDiskon = 0; 
                tfhargadiskon.setText("0");
                }
                else {
                    hasilDiskon = Integer.parseInt(txtJumlahHarga.getText().replace(".", ""))
                        * Integer.parseInt(tfdiskon.getText()) / 100 ;

                }
                tfhargadiskon.setText(nf.format(hasilDiskon));

                //PPN
                int ppn = 0;
                if (chkppn.isSelected()){
                    ppn = Integer.parseInt(txtJumlahHarga.getText().replace(".", "")) * 11/100 ;
                    tfhasilppn.setText("Rp. " +nf.format(ppn));
                }
                else{
                    ppn = 0;
                    tfhasilppn.setText("Rp. " + nf.format(ppn));
                }

                // TOTAL BERSIH SEMUA
                int totalBersih;
                totalBersih = Integer.parseInt(txtJumlahHarga.getText().replace(".", "")) - hasilDiskon + ppn;
                tftotalhargaakhir.setText("Rp. " + nf.format(totalBersih));
                jLabel1.setText(tftotalhargaakhir.getText());
    }
    void bersih (){
        txtKodeBarang.setText("");
        txtKodeBarang.grabFocus();
        txtQTY.setText("");
        txtTotalHarga.setText("");
    }
}
