
package com.mycompany.mavenproject1.ggui;

import java.awt.Graphics;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import javax.swing.Icon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumnModel;
import org.openide.util.Exceptions;
import org.openide.util.ImageUtilities;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.event.ListSelectionListener;


/**
 *
 * @author xuewen
 */
public class ReportTable extends javax.swing.JFrame {

    /**
     * Creates new form refTable
     */
    private int COLUMN_COUNT;
    private String configDistributionFile="distribution_configure.txt"; //the config file in setting folder
    String rawKincoefficient_inputFile="";
    long timeMilli=0L;
    String workDir="";
   public ReportTable(String inKingFile ) {               
        initComponents();
        rawKincoefficient_inputFile=inKingFile;
        setIcon();
        
        //set up tag for tmp file
        Date date = new Date();
        timeMilli = date.getTime();
        
        //set up tmpdir
        Path path = Paths.get(inKingFile); // "/home/xw/test/file.txt"
        workDir=String.valueOf(path.getParent()); // /home/xw/test
        
        String winfilepath = java.lang.System.getProperty("user.dir");        
        String appDirParent= winfilepath.replaceAll("\\\\app",""); //C:\\genealogy\\genealogyUI_test
        configDistributionFile=appDirParent+"\\Settings\\"+configDistributionFile;

        String varianceErrorLevel="0";
        ReportAllRows(varianceErrorLevel, inKingFile);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
    }
   
       private void ReportAllRows(String varianceErrorLevel, String rawKincoefficient){
           rawKincoefficient_inputFile=rawKincoefficient;
            String FileNameWithPredictionAllRows="";
            try { 
                FileNameWithPredictionAllRows=DegreePredictAllRows(varianceErrorLevel,rawKincoefficient );
            } catch (IOException ex) {
                Exceptions.printStackTrace(ex);
            }

           //update Jtable
           COLUMN_COUNT=headColumn(FileNameWithPredictionAllRows);
           initialize(COLUMN_COUNT,FileNameWithPredictionAllRows);
           

    
       }


    private void cleanMyTmp() throws IOException {
                //check file exist and clean file
                String tmpfileName=workDir+"\\Predict"+timeMilli+".txt";
                  Files.delete(Paths.get(tmpfileName));
            }


       
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jButton2 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(org.openide.util.NbBundle.getMessage(ReportTable.class, "ReportTable.title")); // NOI18N
        setPreferredSize(new java.awt.Dimension(1300, 720));
        setSize(new java.awt.Dimension(1300, 750));

        jPanel1.setFocusTraversalPolicyProvider(true);
        jPanel1.setName("Reference"); // NOI18N
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(790, 300));

        jScrollPane1.setAutoscrolls(true);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(700, 300));

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setToolTipText(org.openide.util.NbBundle.getMessage(ReportTable.class, "ReportTable.jTable1.toolTipText")); // NOI18N
        jTable1.setDragEnabled(true);
        jTable1.setFillsViewportHeight(true);
        jTable1.setFocusTraversalPolicyProvider(true);
        jTable1.setPreferredSize(null);
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jTable1.setShowGrid(true);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setHeaderValue(org.openide.util.NbBundle.getMessage(ReportTable.class, "ReportTable.jTable1.columnModel.title0")); // NOI18N
            jTable1.getColumnModel().getColumn(1).setHeaderValue(org.openide.util.NbBundle.getMessage(ReportTable.class, "ReportTable.jTable1.columnModel.title1")); // NOI18N
            jTable1.getColumnModel().getColumn(2).setHeaderValue(org.openide.util.NbBundle.getMessage(ReportTable.class, "ReportTable.jTable1.columnModel.title2")); // NOI18N
            jTable1.getColumnModel().getColumn(3).setHeaderValue(org.openide.util.NbBundle.getMessage(ReportTable.class, "ReportTable.jTable1.columnModel.title3")); // NOI18N
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setMinimumSize(new java.awt.Dimension(150, 150));
        jPanel2.setPreferredSize(new java.awt.Dimension(300, 300));

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLayeredPane1.setToolTipText(org.openide.util.NbBundle.getMessage(ReportTable.class, "ReportTable.jLayeredPane1.toolTipText")); // NOI18N

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText(org.openide.util.NbBundle.getMessage(ReportTable.class, "ReportTable.jButton1.text")); // NOI18N
        jButton1.setToolTipText(org.openide.util.NbBundle.getMessage(ReportTable.class, "ReportTable.jButton1.toolTipText")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "0.01", "0.02", "0.03", "0.04", "0.05" }));

        jLabel1.setText(org.openide.util.NbBundle.getMessage(ReportTable.class, "ReportTable.jLabel1.text")); // NOI18N

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setText(org.openide.util.NbBundle.getMessage(ReportTable.class, "ReportTable.jButton3.text")); // NOI18N
        jButton3.setToolTipText(org.openide.util.NbBundle.getMessage(ReportTable.class, "ReportTable.jButton3.toolTipText")); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLayeredPane1.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jComboBox1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLayeredPane2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setText(org.openide.util.NbBundle.getMessage(ReportTable.class, "ReportTable.jButton2.text")); // NOI18N
        jButton2.setToolTipText(org.openide.util.NbBundle.getMessage(ReportTable.class, "ReportTable.jButton2.toolTipText")); // NOI18N
        jButton2.setPreferredSize(new java.awt.Dimension(143, 23));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText(org.openide.util.NbBundle.getMessage(ReportTable.class, "ReportTable.jRadioButton1.text")); // NOI18N

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText(org.openide.util.NbBundle.getMessage(ReportTable.class, "ReportTable.jRadioButton2.text")); // NOI18N

        jLayeredPane2.setLayer(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jRadioButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jRadioButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                .addContainerGap())
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLayeredPane3.setLayer(jLayeredPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane3Layout = new javax.swing.GroupLayout(jLayeredPane3);
        jLayeredPane3.setLayout(jLayeredPane3Layout);
        jLayeredPane3Layout.setHorizontalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane3Layout.createSequentialGroup()
                .addGap(0, 9, Short.MAX_VALUE)
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jLayeredPane3Layout.setVerticalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        jPanel3.setPreferredSize(new java.awt.Dimension(790, 200));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText(org.openide.util.NbBundle.getMessage(ReportTable.class, "ReportTable.jLabel2.text")); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 1098, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1054, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1))
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1300, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(ReportTable.class, "ReportTable.AccessibleContext.accessibleName")); // NOI18N

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    String winfilepathOUT = java.lang.System.getProperty("user.dir").replaceAll("app",""); //C:\\genealogy\\genealogyUI_test;        
    String defOutFileSelected=winfilepathOUT+"\\mySelectedKinOut.xls";
    
    List outlist = new ArrayList();
    //prepare file  
    private void saveTable(List outlist) {
         //choose an output file name with default
             FileChooserWithDefName fcwdn = new FileChooserWithDefName();
             File file=fcwdn.chooseMyFile(defOutFileSelected);
            
          try {
                 FileWriter out = new FileWriter(file);  
                          String outlist_string = "";
                            for(int i=0;i<outlist.size();i++) {
                            outlist_string += String.valueOf(outlist.get(i));
                          }
                           out.write(outlist_string);
                 out.close();
              }
             catch (IOException ex) {
                 javax.swing.JOptionPane.showMessageDialog(this, ex);
            }
          //}
     }
   
    List listPredictOutValues=new ArrayList(); 

   String predictHeader="#Sample_ID\tReference_ID\tNumber of markers\tKinship_coefficient\tD1\tD2\tD3\tUnrelated\n";
    private String DegreePredictAllRows(String errorLevel, String kcoefficientTableFile) throws IOException{
        ArrayList<String> kincoefList= readKincoefficientTable(kcoefficientTableFile);
        String OutputKinPrediction=null;
        String fileTag=String.valueOf(timeMilli); 
        String predictedErrorAssociated=workDir+"\\Predict"+fileTag+".txt"; 
        FileWriter predictedOutFile=new FileWriter(predictedErrorAssociated);
        BufferedWriter bwPredictedOutFile = new BufferedWriter(predictedOutFile);
        
         for(int k=0; k<kincoefList.size(); k ++){
           String kinLine=kincoefList.get(k);
           String[] kincells=kinLine.split("\\t");
           String kincoef=kincells[3];
           List predictedKinValues=new ArrayList<String>();
           
           for(int kinc=0; kinc < kincells.length ; kinc++){
                    String kincellTmp=String.valueOf(kincells[kinc]);
                    predictedKinValues.add( kincellTmp );
            }
           
           //get distribution config                          
             String winfilepath = java.lang.System.getProperty("user.dir");        
             String appDirParent= winfilepath.replaceAll("\\\\app",""); //C:\\genealogy\\genealogyUI_test
             
             String distributionFile=varErrorConfig(errorLevel, configDistributionFile);
             distributionFile=appDirParent+"\\Settings\\"+distributionFile; // C:\genealogy\genealogyUI_test\Settings\distribution_degree_err0.01_noNA.txt
                          
             
           if( ! (kinLine.contains("#sample")|| kinLine.contains("#Sample"))){
                //predict
                String imageSampleRefNameB=kincells[0] +" vs "+kincells[1];
                String[] curvePars={distributionFile, errorLevel, imageSampleRefNameB, kincoef}; 
                KinshipCoefficientDistribution kcd = new KinshipCoefficientDistribution();
                double[] myPercents=null;
                try { 
                    myPercents=kcd.degreePredict(curvePars);
                } catch (IOException ex) {
                     Exceptions.printStackTrace(ex);
                }
                
                //append the prediction values to each row of orginal kincoef data row
                for(int p=0; p < myPercents.length ; p++){
                    String percent=String.valueOf(myPercents[p]);
                    //System.out.print( percent+" " );
                    predictedKinValues.add( percent );
                }
                
                //output the prediction to generate a table for Jtable model
                String outTMP;
                for(int c=0; c < predictedKinValues.size() ; c++){
                    if(c < ( predictedKinValues.size()-1) ){
                        outTMP=predictedKinValues.get(c)+"\t";
                        bwPredictedOutFile.write(outTMP);
                    }else{
                        outTMP=predictedKinValues.get(c)+"\n";
                        bwPredictedOutFile.write(outTMP);
                    }
               }
                
                    
            }else{
//               String predictHeader="#Sample_ID\tReference_ID\tNumber of markers\tKinship_coefficient\tD1\tD2\tD3\tUnrelated\n";
               bwPredictedOutFile.write(predictHeader);
            }
         }
        bwPredictedOutFile.close();
        // the output file name with path
        return predictedErrorAssociated;
    }

    public ArrayList<String> readKincoefficientTable(String fileName) throws IOException {
		ArrayList<String> KincoefRawTable = new ArrayList<String>();
                BufferedReader in = new BufferedReader(new FileReader(fileName));
                String kincoefOneRow=""; //= in.readLine(); //first line
                while ((kincoefOneRow = in.readLine()) != null) {
                    /* data format
                    #sample_ID	reference_ID	marker_size	kinship_coefficient
                    Sample1	Reference1	490444	0.1345
                    */
                    kincoefOneRow=kincoefOneRow.strip();
                     if (kincoefOneRow.length() > 0) {
            	         KincoefRawTable.add(kincoefOneRow);
                    }
                }
                in.close();
                return KincoefRawTable;
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //get data from jtable 
        int rcount=jTable1.getRowCount();    
        //save certain cells
         int rowid = jTable1.getSelectedRow();
         if(rowid == -1){
             javax.swing.JOptionPane.showMessageDialog(this, "Tip:\nPlease select a row in the table first.");
         }else{
             int viewRowId=rowid; 
             int modelRow = jTable1.convertRowIndexToModel(viewRowId);
             String errorInput=jComboBox1.getSelectedItem().toString();
             String rowSampleName=(String) jTable1.getModel().getValueAt(rowid, 2);
             String rowReferenceName=(String) jTable1.getModel().getValueAt(rowid, 3);
             String modelRowSampleName=(String) jTable1.getModel().getValueAt(modelRow, 2);
             String modelRowReferenceName=(String) jTable1.getModel().getValueAt(modelRow, 3);             
             
             
             String imageSampleRefName=modelRowSampleName +" vs "+modelRowReferenceName;
             String varianceErrorLevel=errorInput; //or read from given value
             String kincoefficient=(String) jTable1.getModel().getValueAt(modelRow, 5);
             
             //predict kinship             
             String distributionFile=""; //="C:\\genealogy\\genealogyUI_test\\Settings\\distribution_degree_err0.01_noNA.txt";
          
             //get config of var error                
             String winfilepath = java.lang.System.getProperty("user.dir");        
             String appDirParent= winfilepath.replaceAll("\\\\app",""); //C:\\genealogy\\genealogyUI_test
             distributionFile=varErrorConfig(varianceErrorLevel, configDistributionFile);
             distributionFile=appDirParent+"\\Settings\\"+distributionFile; // C:\genealogy\genealogyUI_test\Settings\distribution_degree_err0.01_noNA.txt
            
             String[] curvePars={distributionFile,varianceErrorLevel, imageSampleRefName, kincoefficient};
             KinshipCoefficientDistribution kcd = new KinshipCoefficientDistribution();
             try {                    

                    
                    //get curve image
                    kcd.distriPlot(curvePars);
                     
                    // get percentage in degree in kinships
                    double[] myPercents=kcd.degreePredict(curvePars);
                    
                    String percent2Report= String.join("\t", Arrays.toString(myPercents));
                    listPredictOutValues.add(imageSampleRefName+"\t"+varianceErrorLevel+"\t"+percent2Report+"\n");
                    
                    jTextArea1.setLineWrap(true);
                    jTextArea1.setCaretPosition(jTextArea1.getText().length());
                    String predictOutValuesHeader="# The ratio [0-1] for the lowest to the highest relative percent in each pedigree category\n";
                    predictOutValuesHeader=predictOutValuesHeader+"Sample_vs_Refernce\tError\tRatio [D1,D2,D3,Unrelated]\n";
                    jTextArea1.setText(predictOutValuesHeader);
                    for (int op=0; op <listPredictOutValues.size(); op++){
                    jTextArea1.append( (String) listPredictOutValues.get(op) );
                    }
                    jTextArea1.paintImmediately(jTextArea1.getBounds());
                 } catch (IOException ex) {
                     Exceptions.printStackTrace(ex);
                     
                 } 

         }
         
         
    }//GEN-LAST:event_jButton1ActionPerformed

    private void wrapPredictOutValues(String args){
        //to update the displayPredictValues
                    jTextArea1.setLineWrap(true);
                    jTextArea1.setCaretPosition(jTextArea1.getText().length());
                    jTextArea1.setText("Sample_vs_Refernce"+"\tError\t"+"Predicted%_[D1,D2,D3,Unrelated]"+"\n");
                    jTextArea1.paintImmediately(jTextArea1.getBounds());
        }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

       // to save the selected
        List selectedKins=new ArrayList(); //unknown rows of selection
        selectedKins.add( predictHeader); //headlines
        String saveOption=""; //=jComboBox2.getSelectedItem().toString();
        int rcount=jTable1.getRowCount();  
        int colcount=jTable1.getColumnCount();
       
        //universal to get selected button
        Enumeration elements = buttonGroup1.getElements();
        while (elements.hasMoreElements()) {
            AbstractButton button = (AbstractButton)elements.nextElement();
            if (button.isSelected()) {
                saveOption=button.getText();
            }
        }
        
        
        for (int rc=0; rc< rcount; rc ++){
            List oneRow=new ArrayList();
            boolean check =false;
            String oneRowString=null;
            for (int cc=2; cc<colcount; cc ++){
                //ingore first two columns
                 Object oneCell =  jTable1.getModel().getValueAt(rc, cc);
                 check = (boolean) jTable1.getModel().getValueAt(rc, 1);
                 oneRow.add(oneCell);
             }
                for (int h=0; h <oneRow.size(); h++){
                    if(oneRowString ==  null){
                            oneRowString =String.valueOf(oneRow.get(h));
                      }else{
                        if(h <= (oneRow.size()-2)){
                            oneRowString = oneRowString+"\t"+String.valueOf(oneRow.get(h));
                        }else{
                            oneRowString = oneRowString+"\t"+String.valueOf( oneRow.get(h) )+"\n";
                        }
                        
                      }
                    oneRowString=oneRowString.replace("*\\t", "");  //remove the first empty column
                }
                
                 if(saveOption.equals("Checked rows")){
                     if(check){
                       selectedKins.add(oneRowString);
                     }
                 }else if( saveOption.equals("All rows") ){
                        selectedKins.add(oneRowString);
                }                
                 
        }
        saveTable(selectedKins);
        selectedKins.clear(); 
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

            String varianceErrorLevel=jComboBox1.getSelectedItem().toString();
            JOptionPane.showMessageDialog(this, "For variance error level: "+varianceErrorLevel);
            String FileNameWithPredictionAllRows="";
            String rawKincoefficient=rawKincoefficient_inputFile; // "C:\\genealogy\\genealogyUI_test\\data\\sample1.bcf_list5.kingAll.txt";
            try { 
                FileNameWithPredictionAllRows=DegreePredictAllRows(varianceErrorLevel,rawKincoefficient );
            } catch (IOException ex) {
                Exceptions.printStackTrace(ex);
            }

           //update Jtable
           COLUMN_COUNT=headColumn(FileNameWithPredictionAllRows);
           initialize(COLUMN_COUNT,FileNameWithPredictionAllRows);  
           
            //clean tmp file

            String tmpfileName=workDir+"\\Predict"+timeMilli+".txt";
        try {
            if(Files.exists(Paths.get(tmpfileName) )){
               Files.delete(Paths.get(tmpfileName));
            }
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed


    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ReportTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReportTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        
        /* Create and display the form */
        String inKingFile = (args.length == 0) ? "C:\\genealogy\\GKin\\Settings\\example_kingOut.txt" : args[0];
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ReportTable(inKingFile).setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables


//Get the content of headline and store in headcells2
String[] headcells;
List headcells2 = new ArrayList();    
private int headColumn(String inKingFile){
        // to autocreate the needed number of columns
        int colct=0;
        headcells2.clear();
        try{
            FileReader read1 = new FileReader(inKingFile);
            
            //get the number of collumn in file
            Scanner scan = new Scanner(read1);
           while(scan.hasNextLine()){
            String temp=scan.nextLine();
            String[] tempcells =temp.split("\t");
            if(tempcells[0].startsWith("#")){
                   // to insert two extra headnames in the beginning
                    headcells2.add("AutoID");
                    headcells2.add("Check");
                    tempcells[0]=tempcells[0].replace("#",""); //remove the #
                    for(int h=2; h< tempcells.length+2; h ++){
                      headcells2.add(tempcells[h-2]);
                    }
            colct=headcells2.size();
            break;
            
            }
           } 
           scan.close();
    }catch(Exception e){
            JOptionPane.showMessageDialog(this, "error: "+e);
            e.printStackTrace();
        }
    return colct;
}
    


private String varErrorConfig(String varLevel ,String distributionConfigureFile ) {
     List errorLevelFiles = new ArrayList();
     if(distributionConfigureFile.length()==0){
         //default
        distributionConfigureFile=workDir+"\\Settings\\distribution_configure.txt";
     }
     String distriFileName=""; //distribution file name returned
     HashMap<String, String> distriFileNameHash=new HashMap<String, String>();
        try{ // get hash paire info data from file          
          FileReader read2 = new FileReader(distributionConfigureFile);
          Scanner scan = new Scanner(read2);
          int rct=1; //row autoID
             while(scan.hasNextLine()){
                String temp=scan.nextLine();
                temp=temp.strip();
                String tempcells[] =temp.split("\t");// \t ot \\t same
                distriFileNameHash.put(tempcells[0],tempcells[1]);
          }
        }
        catch(FileNotFoundException e){
                    JOptionPane.showMessageDialog(this, "error: "+e);
        }
        
        distriFileName=distriFileNameHash.get(varLevel);
     return distriFileName;
}
        

//update Jtable 
private void updateJtableTblModel(List dataUpdate){
    model = new TblModel(dataUpdate);   
     jTable1.setModel(model);    
     jTable1.getTableHeader().resizeAndRepaint();
     jTable1.setFillsViewportHeight(true);
     jTable1.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
     getContentPane().add(jScrollPane1);
     jScrollPane1.setViewportView(jTable1);
    
    TableColumnModel tcm = jTable1.getColumnModel();
    tcm.getColumn(0).setPreferredWidth(20); 
    tcm.getColumn(1).setPreferredWidth(80);
    tcm.getColumn(2).setPreferredWidth(200); 
    tcm.getColumn(3).setPreferredWidth(200); 
}


//construct model based on column count
 private TblModel model;
  
 private void initialize(int COLUMN_COUNT , String inKingFile) {
     List data = new ArrayList();     
        try{ // get data from file          
          FileReader read2 = new FileReader(inKingFile);
          Scanner scan = new Scanner(read2);
          int rct=1; //row autoID
             while(scan.hasNextLine()){
                String temp=scan.nextLine();
                String tempcells[] =temp.split("\t");// \t ot \\t same
                
                //get headline
                if(tempcells[0].startsWith("#")){
                   headcells=tempcells;
                   continue;
                }
                
                if(temp.length() > 0){                    
                Object record[] = new Object[COLUMN_COUNT];
                record[0]=rct; //check
                record[1]=Boolean.FALSE; //check
                for (int j = 2; j < COLUMN_COUNT; j ++) {                    
                    record[j] = tempcells[j-2];
                }
                data.add(record);
                rct ++; 
             }
             }
             scan.close();
        }
        catch(FileNotFoundException e){
                    JOptionPane.showMessageDialog(this, "error: "+e);
        }

     model = new TblModel(data);
     jTable1.setModel(model);
     
     jTable1.getTableHeader().resizeAndRepaint();
     jTable1.setFillsViewportHeight(true);
     jTable1.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
     jTable1.setRowSelectionAllowed(true);
     getContentPane().add(jScrollPane1);
     jScrollPane1.setViewportView(jTable1);
    
    TableColumnModel tcm = jTable1.getColumnModel();
    tcm.getColumn(0).setPreferredWidth(40); 
    tcm.getColumn(1).setPreferredWidth(80);
    tcm.getColumn(2).setPreferredWidth(150); 
    tcm.getColumn(3).setPreferredWidth(150); 
    tcm.getColumn(4).setPreferredWidth(120); 
    tcm.getColumn(5).setPreferredWidth(120);
    


        String tmpfileName=workDir+"\\Predict"+timeMilli+".txt";
        try {
            if(Files.exists(Paths.get(tmpfileName) )){
               Files.delete(Paths.get(tmpfileName));
            }
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);}
        
    }
     
    class TblModel extends AbstractTableModel {
 
        private List data;
        public TblModel(List data) {
            this.data = data;     
        }

        public int getColumnCount() {
            return COLUMN_COUNT;
        }
    
        public int getRowCount() {
            return data == null ? 0 : data.size();
        }
      
        public void setValueAt(Object value, int rowIndex, int columnIndex) {
            getRecord(rowIndex)[columnIndex] = value;
            super.fireTableCellUpdated(rowIndex, columnIndex);
        }
     
        public Object getValueAt(int rowIndex, int columnIndex) {            
            return getRecord(rowIndex)[columnIndex];
        }
    
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return columnIndex==1 ;
        }
      
        public Class getColumnClass(int columnIndex) {
            if (data == null || data.size() == 0) {
                return Object.class;
            }
        
            Object o = getValueAt(0, columnIndex);
            return o == null ? Object.class : o.getClass();
        }
     
        private Object[] getRecord(int rowIndex) {
            return (Object[]) data.get(rowIndex);
        }
        
        public String getColumnName(int index) {
          String[] headArray = new String[COLUMN_COUNT];         
          for (int a=0; a< headcells2.size(); a ++){
            headArray[a]=(String) headcells2.get(a);          
          }
            return headArray[index];          
        }
} 
 
 
    public void valueChanged(ListSelectionEvent e) {
        if (! e.getValueIsAdjusting() ) {
            ListSelectionModel lsm = (ListSelectionModel) e.getSource();
            int index = lsm.getMinSelectionIndex();
            model.setValueAt(Boolean.TRUE, index, 1);
        }
    }



 private void setIcon() {
         setIconImage((Image) makeIcon("Gkin.png"));
    }
 
  private static Icon makeIcon(String iconBase) {
      return ImageUtilities.image2Icon(
             ImageUtilities.loadImageIcon(iconBase, false).getImage());
  }
  
}
