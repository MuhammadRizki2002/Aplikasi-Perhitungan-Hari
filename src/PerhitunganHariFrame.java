import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;



/**
 *
 * @author asus0
 */
public class PerhitunganHariFrame extends javax.swing.JFrame {

    public PerhitunganHariFrame() {
        initComponents();

        // Inisialisasi JComboBox bulan
        String[] bulan = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
        JComboBox<String> comboBulan = new JComboBox<>(bulan);

        // Menambahkan comboBulan ke layout panel
        jPanel1.add(comboBulan);

        // Inisialisasi JSpinner untuk tahun dengan batas minimal 1900 dan maksimal 2100
        SpinnerModel modelTahun = new SpinnerNumberModel(2023, 1900, 2100, 1);
        JSpinner spinnerTahun = new JSpinner(modelTahun);

        // Tambahkan spinnerTahun ke panel atau layout yang diinginkan
        jPanel1.add(spinnerTahun);

        buttonHitung.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int bulan = comboBoxBulan.getSelectedIndex() + 1;
                int tahun = (int) spinnerTahun.getValue();

                // Menggunakan YearMonth untuk mendapatkan jumlah hari dalam bulan
                YearMonth yearMonth = YearMonth.of(tahun, bulan);
                int jumlahHari = yearMonth.lengthOfMonth();
                labelHasil.setText("Jumlah hari: " + jumlahHari);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comboBoxBulan = new javax.swing.JComboBox<>();
        spinnerTahun = new com.toedter.components.JSpinField();
        buttonHitung = new javax.swing.JButton();
        lblFirstDay = new javax.swing.JLabel();
        lblLastDay = new javax.swing.JLabel();
        dateChooserStart = new com.toedter.calendar.JDateChooser();
        dateChooserEnd = new com.toedter.calendar.JDateChooser();
        btnCalculateDifference = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        labelHasil = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Input Bulan");

        jLabel2.setText("Input Tahun");

        comboBoxBulan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember" }));
        comboBoxBulan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxBulanActionPerformed(evt);
            }
        });

        buttonHitung.setText("Hitung");
        buttonHitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHitungActionPerformed(evt);
            }
        });

        dateChooserStart.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateChooserStartPropertyChange(evt);
            }
        });

        dateChooserEnd.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateChooserEndPropertyChange(evt);
            }
        });

        btnCalculateDifference.setText("Hitung Selisih");
        btnCalculateDifference.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculateDifferenceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(btnCalculateDifference)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonHitung)
                        .addGap(63, 63, 63))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(comboBoxBulan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(spinnerTahun, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblLastDay, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                    .addComponent(lblFirstDay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dateChooserStart, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dateChooserEnd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(30, 30, 30))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spinnerTahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxBulan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFirstDay)
                    .addComponent(dateChooserStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLastDay)
                    .addComponent(dateChooserEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonHitung)
                    .addComponent(btnCalculateDifference))
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(268, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(labelHasil, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(139, 139, 139))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelHasil, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxBulanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxBulanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxBulanActionPerformed

    private void buttonHitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHitungActionPerformed
        initComponents();
        
        // Inisialisasi JPanel
        JPanel jPanel1 = new JPanel();
        
        // Inisialisasi JComboBox bulan
        String[] bulan = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
        JComboBox<String> comboBulan = new JComboBox<>(bulan);
        jPanel1.add(comboBulan); // Tambahkan comboBulan ke panel

        // Inisialisasi JSpinner untuk tahun
        SpinnerModel modelTahun = new SpinnerNumberModel(2023, 1900, 2100, 1);
        JSpinner spinnerTahun = new JSpinner(modelTahun);
        jPanel1.add(spinnerTahun); // Tambahkan spinnerTahun ke panel
        
        JButton buttonHitung = new JButton("Hitung");
        JLabel labelHasil = new JLabel("Jumlah hari: ");
        
        jPanel1.add(buttonHitung);
        jPanel1.add(labelHasil);
        
        add(jPanel1); // Menambahkan panel ke JFrame
        
        buttonHitung.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int bulanIndex = comboBulan.getSelectedIndex() + 1;
                int tahun = (int) spinnerTahun.getValue();
                
                YearMonth yearMonth = YearMonth.of(tahun, bulanIndex);
                int jumlahHari = yearMonth.lengthOfMonth();
                labelHasil.setText("Jumlah hari: " + jumlahHari);
            }
        });
    }//GEN-LAST:event_buttonHitungActionPerformed

    private void dateChooserStartPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateChooserStartPropertyChange
         Date selectedDate = dateChooserStart.getDate();
    if (selectedDate != null) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(selectedDate);

        // Mendapatkan hari pertama bulan
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date firstDayOfMonth = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
        lblFirstDay.setText("Hari Pertama: " + dateFormat.format(firstDayOfMonth));

        // Mendapatkan hari terakhir bulan
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date lastDayOfMonth = calendar.getTime();
        lblLastDay.setText("Hari Terakhir: " + dateFormat.format(lastDayOfMonth));
    }

    }//GEN-LAST:event_dateChooserStartPropertyChange

    private void dateChooserEndPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateChooserEndPropertyChange
        Date selectedDate = dateChooserStart.getDate();
    if (selectedDate != null) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(selectedDate);

        // Mendapatkan hari pertama bulan
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date firstDayOfMonth = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
        lblFirstDay.setText("Hari Pertama: " + dateFormat.format(firstDayOfMonth));

        // Mendapatkan hari terakhir bulan
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date lastDayOfMonth = calendar.getTime();
        lblLastDay.setText("Hari Terakhir: " + dateFormat.format(lastDayOfMonth));
    }
    }//GEN-LAST:event_dateChooserEndPropertyChange

    private void btnCalculateDifferenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculateDifferenceActionPerformed

        // Konversi tanggal dari JDateChooser ke LocalDate
        LocalDate tanggalMulai = dateChooserStart.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate tanggalAkhir = dateChooserEnd.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // Hitung selisih hari antara tanggalMulai dan tanggalAkhir
        long selisihHari = ChronoUnit.DAYS.between(tanggalMulai, tanggalAkhir);

        // Tampilkan hasil selisih hari di jLabel3
        jLabel3.setText("Selisih Hari: " + selisihHari + " hari");
    
    }//GEN-LAST:event_btnCalculateDifferenceActionPerformed

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
            java.util.logging.Logger.getLogger(PerhitunganHariFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PerhitunganHariFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PerhitunganHariFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PerhitunganHariFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PerhitunganHariFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalculateDifference;
    private javax.swing.JButton buttonHitung;
    private javax.swing.JComboBox<String> comboBoxBulan;
    private com.toedter.calendar.JDateChooser dateChooserEnd;
    private com.toedter.calendar.JDateChooser dateChooserStart;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelHasil;
    private javax.swing.JLabel lblFirstDay;
    private javax.swing.JLabel lblLastDay;
    private com.toedter.components.JSpinField spinnerTahun;
    // End of variables declaration//GEN-END:variables
}