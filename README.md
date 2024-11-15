
# Aplikasi penghitungan hari

Aplikasi Perhitungan Hari adalah sebuah aplikasi berbasis antarmuka grafis (GUI) yang dikembangkan dengan Java Swing untuk mempermudah pengguna dalam melakukan berbagai perhitungan terkait tanggal. Aplikasi ini menawarkan fitur utama untuk menampilkan hari pertama dan terakhir dari bulan yang dipilih, serta menghitung jumlah hari antara dua tanggal. Berikut adalah penjelasan mengenai fitur-fitur yang disediakan:

Fitur Utama Pemilihan Bulan dan Tahun

Pengguna dapat memilih bulan dan tahun menggunakan JComboBox untuk memilih bulan dan JSpinner untuk memilih tahun. Aplikasi akan menampilkan informasi mengenai hari pertama dan terakhir dalam bulan yang dipilih, berdasarkan kombinasi bulan dan tahun yang telah ditentukan. Fitur ini membantu pengguna mengetahui tanggal awal dan akhir dari bulan tertentu, termasuk menyesuaikan hasil untuk tahun kabisat.









## Authors

- Muhammad Rizki Insnai 2210010075


## Documentation

```
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.Year;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


/**
 *
 * @author asus0
 */
public class PerhitunganHariFrame extends javax.swing.JFrame {

    public PerhitunganHariFrame() {
         initComponents();
          buttonHitung.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateResults();
            }
        });

        // Sinkronkan JComboBox dan JSpinner dengan JDateChooser
        comboBulan.addActionListener(evt -> {
            updateDateChooser();
            calculateResults();
        });

        spinnerTahun.addPropertyChangeListener("value", evt -> {
            updateDateChooser();
            calculateResults();
        });
    
        // Sinkronkan JDateChooser dengan JComboBox dan JSpinner
        dateChooserStart.addPropertyChangeListener("date", evt -> {
            updateComboBoxAndSpinner();
            calculateResults();
        });

        // Sinkronkan JCalendar dengan JComboBox, JSpinner, dan JDateChooser
       Calendar1.addPropertyChangeListener("calendar", new PropertyChangeListener() {
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        updateDateFromCalendar();
        calculateResults();
    }
});

    }
    
    private void updateDateChooser() {
        int month = comboBulan.getSelectedIndex();
        int year = spinnerTahun.getValue();
        LocalDate date = LocalDate.of(year, month + 1, 1);
        dateChooserStart.setDate(Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant()));
    }

      private void updateComboBoxAndSpinner() {
        Date selectedDate = dateChooserStart.getDate();
        if (selectedDate != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(selectedDate);
            comboBulan.setSelectedIndex(calendar.get(Calendar.MONTH));
            spinnerTahun.setValue(calendar.get(Calendar.YEAR));
        }
    }
     
      private void updateDateFromCalendar() {
        Calendar cal = Calendar1.getCalendar();
        Date selectedDate = cal.getTime();
        dateChooserStart.setDate(selectedDate);
        updateComboBoxAndSpinner();
    }
     
  





   
    
    
    
    private void calculateResults() {
        Date startDate = dateChooserStart.getDate();
        Date endDate = Calendar1.getDate();
    
        SimpleDateFormat fullDateFormat = new SimpleDateFormat("EEEE, dd MMMM yyyy", new Locale("id", "ID"));

        if (startDate != null && endDate != null) {
            LocalDate tanggalMulai = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate tanggalAkhir = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            long selisihHari = ChronoUnit.DAYS.between(tanggalMulai, tanggalAkhir);

            YearMonth yearMonth = YearMonth.of(tanggalMulai.getYear(), tanggalMulai.getMonthValue() + 1);
            LocalDate hariPertamaBulan = yearMonth.atDay(1);
            LocalDate hariTerakhirBulan = yearMonth.atEndOfMonth();

            // Cek apakah tahun adalah tahun kabisat
            boolean isLeapYear = Year.of(tanggalMulai.getYear()).isLeap();
            String leapYearText = isLeapYear ? "Ya, tahun kabisat" : "Bukan tahun kabisat";

            // Mendapatkan jumlah hari dalam bulan yang dipilih
            int totalHariBulan = yearMonth.lengthOfMonth();

            // Format hasil dalam JLabel
            jLabel3.setText("<html>Selisih Hari: " + selisihHari + " hari<br>"
                            + "Hari Pertama Bulan: " + fullDateFormat.format(Date.from(hariPertamaBulan.atStartOfDay(ZoneId.systemDefault()).toInstant())) + "<br>"
                            + "Hari Terakhir Bulan: " + fullDateFormat.format(Date.from(hariTerakhirBulan.atStartOfDay(ZoneId.systemDefault()).toInstant()))
                            + "</html>");
            
            jLabelLeapYear.setText("Tahun Kabisat: " + leapYearText);
            jLabelTotalHariBulan.setText("Total Hari dalam Bulan: " + totalHariBulan + " hari");
        } else {
            jLabel3.setText("<html><font color='red'>Silakan pilih kedua tanggal terlebih dahulu.</font></html>");
            jLabelLeapYear.setText("");
            jLabelTotalHariBulan.setText("");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comboBulan = new javax.swing.JComboBox<>();
        spinnerTahun = new com.toedter.components.JSpinField();
        buttonHitung = new javax.swing.JButton();
        lblFirstDay = new javax.swing.JLabel();
        lblLastDay = new javax.swing.JLabel();
        dateChooserStart = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        labelHasil = new javax.swing.JLabel();
        Calendar1 = new com.toedter.calendar.JCalendar();
        jLabelLeapYear = new javax.swing.JLabel();
        jLabelTotalHariBulan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Input Bulan");

        jLabel2.setText("Input Tahun");

        comboBulan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember" }));
        comboBulan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBulanActionPerformed(evt);
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

        jLabel3.setText("hasil selisih");

        jLabelLeapYear.setText("Kabisat:");

        jLabelTotalHariBulan.setText("Total Hari:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(buttonHitung)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(203, 203, 203)
                                        .addComponent(lblLastDay, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE))
                                    .addComponent(lblFirstDay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(30, 30, 30))
                            .addComponent(dateChooserStart, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(Calendar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelTotalHariBulan)
                            .addComponent(jLabelLeapYear)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(comboBulan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(74, 74, 74)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(spinnerTahun, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelHasil, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBulan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(spinnerTahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Calendar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(dateChooserStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblFirstDay)
                        .addGap(35, 35, 35)
                        .addComponent(lblLastDay)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addComponent(buttonHitung)
                        .addGap(93, 93, 93)
                        .addComponent(jLabelTotalHariBulan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelLeapYear, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)))
                .addComponent(labelHasil, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(344, 344, 344))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        
    
   

   
    
    private void comboBulanActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void buttonHitungActionPerformed(java.awt.event.ActionEvent evt) {                                             

    }                                            

    private void dateChooserStartPropertyChange(java.beans.PropertyChangeEvent evt) {                                                
      
    }                                               

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new PerhitunganHariFrame().setVisible(true));
    }

    // Variables declaration - do not modify                     
    private com.toedter.calendar.JCalendar Calendar1;
    private javax.swing.JButton buttonHitung;
    private javax.swing.JComboBox<String> comboBulan;
    private com.toedter.calendar.JDateChooser dateChooserStart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelLeapYear;
    private javax.swing.JLabel jLabelTotalHariBulan;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelHasil;
    private javax.swing.JLabel lblFirstDay;
    private javax.swing.JLabel lblLastDay;
    private com.toedter.components.JSpinField spinnerTahun;
    // End of variables declaration                   
}

```

