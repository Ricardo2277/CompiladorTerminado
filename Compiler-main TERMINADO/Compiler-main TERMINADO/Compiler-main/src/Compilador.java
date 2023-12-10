
import com.formdev.flatlaf.FlatIntelliJLaf;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import compilerTools.Directory;
import compilerTools.ErrorLSSL;
import compilerTools.Functions;
import compilerTools.Production;
import compilerTools.TextColor;
import compilerTools.Token;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

public class Compilador extends javax.swing.JFrame {

    private DefaultTableModel modeloTabla;
    private String title;
    private Directory directorio;
    private ArrayList<Token> tokens;
    private ArrayList<ErrorLSSL> errors;
    private ArrayList<TextColor> textsColor;
    private Timer timerKeyReleased;
    private ArrayList<Production> identProd;
    private HashMap<String, String> identificadores;
    private boolean codeHasBeenCompiled = false;

    //constructor
    public Compilador() {
        initComponents();
        init();

    }

    private void init() {
        title = "Compiler";
        setLocationRelativeTo(null);
        setTitle(title);
        directorio = new Directory(this, escritura, title, ".comp");
        addWindowListener(new WindowAdapter() {// Cuando presiona la "X" de la esquina superior derecha
            @Override
            public void windowClosing(WindowEvent e) {
                directorio.Exit();
                System.exit(0);
            }
        });
        Functions.setLineNumberOnJTextComponent(escritura);
        timerKeyReleased = new Timer((int) (1000 * 0.3), (ActionEvent e) -> {
            timerKeyReleased.stop();
            colorAnalysis();
        });
        Functions.insertAsteriskInName(this, escritura, () -> {
            timerKeyReleased.restart();
        });
        tokens = new ArrayList<>();
        errors = new ArrayList<>();
        textsColor = new ArrayList<>();
        identProd = new ArrayList<>();
        identificadores = new HashMap<>();
        Functions.setAutocompleterJTextComponent(new String[]{}, escritura, () -> {
            timerKeyReleased.restart();
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu2 = new javax.swing.JPopupMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        rootPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        escritura = new javax.swing.JTextPane();
        panelButtonCompilerExecute = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnCompilar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        mensajes = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaPila = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        mensajes1 = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();

        jMenuItem12.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem12.setText("Cortar");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12jmiCortar(evt);
            }
        });
        jPopupMenu2.add(jMenuItem12);

        jMenuItem14.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem14.setText("Copiar");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14jmiCopiar(evt);
            }
        });
        jPopupMenu2.add(jMenuItem14);

        jMenuItem15.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem15.setText("Pegar");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15jmiPegar(evt);
            }
        });
        jPopupMenu2.add(jMenuItem15);

        jMenuItem16.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
        jMenuItem16.setText("Borrar");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16jmiBorrar(evt);
            }
        });
        jPopupMenu2.add(jMenuItem16);

        jMenuItem17.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem17.setText("Seleccionar Todo");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17jmiSeleccionarTodo(evt);
            }
        });
        jPopupMenu2.add(jMenuItem17);

        jMenu4.setText("File");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("Edit");
        jMenuBar2.add(jMenu5);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        escritura.setComponentPopupMenu(jPopupMenu2);
        jScrollPane1.setViewportView(escritura);

        jButton1.setText("📄");
        jButton1.setToolTipText("Nuevo archivo..");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("📂");
        jButton2.setToolTipText("Abrir archivo...");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("📝");
        jButton3.setToolTipText("Guardar el archivo...");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnCompilar.setText("▶");
        btnCompilar.setToolTipText("Analizar el programa...");
        btnCompilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompilarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelButtonCompilerExecuteLayout = new javax.swing.GroupLayout(panelButtonCompilerExecute);
        panelButtonCompilerExecute.setLayout(panelButtonCompilerExecuteLayout);
        panelButtonCompilerExecuteLayout.setHorizontalGroup(
            panelButtonCompilerExecuteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonCompilerExecuteLayout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCompilar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelButtonCompilerExecuteLayout.setVerticalGroup(
            panelButtonCompilerExecuteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelButtonCompilerExecuteLayout.createSequentialGroup()
                .addComponent(btnCompilar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnCompilar.getAccessibleContext().setAccessibleName(" ▶️");

        mensajes.setEditable(false);
        mensajes.setBackground(new java.awt.Color(255, 255, 255));
        mensajes.setColumns(20);
        mensajes.setRows(5);
        jScrollPane2.setViewportView(mensajes);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Componente léxico"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tabla);

        tablaPila.setName("tablaPila"); // NOI18N
        jScrollPane4.setViewportView(tablaPila);

        mensajes1.setEditable(false);
        mensajes1.setBackground(new java.awt.Color(255, 255, 255));
        mensajes1.setColumns(20);
        mensajes1.setRows(5);
        jScrollPane5.setViewportView(mensajes1);

        javax.swing.GroupLayout rootPanelLayout = new javax.swing.GroupLayout(rootPanel);
        rootPanel.setLayout(rootPanelLayout);
        rootPanelLayout.setHorizontalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rootPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1035, Short.MAX_VALUE)
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(panelButtonCompilerExecute, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(17, 17, 17))
        );
        rootPanelLayout.setVerticalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rootPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelButtonCompilerExecute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE))
        );

        getContentPane().add(rootPanel);

        jMenu1.setText("Archivo");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setText("Nuevo");
        jMenuItem1.setToolTipText("");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiNuevo(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem2.setText("Abrir");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAbrir(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem3.setText("Guardar");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiGuardar(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Editar");

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem7.setText("Cortar");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCortar(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem8.setText("Copiar");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCopiar(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem9.setText("Pegar");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPegar(evt);
            }
        });
        jMenu2.add(jMenuItem9);

        jMenuItem10.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
        jMenuItem10.setText("Borrar");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiBorrar(evt);
            }
        });
        jMenu2.add(jMenuItem10);

        jMenuItem11.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem11.setText("Seleccionar Todo");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSeleccionarTodo(evt);
            }
        });
        jMenu2.add(jMenuItem11);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Correr");

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem5.setText("Analizar");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCompilar(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiNuevo(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiNuevo
        // TODO add your handling code here:
        directorio.New();
        clearFields();
    }//GEN-LAST:event_jmiNuevo

    private void jmiAbrir(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAbrir
        // TODO add your handling code here:
        if (directorio.Open()) {
            colorAnalysis();
            clearFields();
        }
    }//GEN-LAST:event_jmiAbrir

    private void jmiGuardar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiGuardar
        // TODO add your handling code here:
        if (directorio.Save()) {
            clearFields();
        }
    }//GEN-LAST:event_jmiGuardar

    private void jmiCompilar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCompilar
        // TODO add your handling code here:
/*        if (getTitle().contains("*") || getTitle().equals(title)) {
            if (directorio.Save()) {
                compile();
            }
        } else {
            compile();
        }*/
        compile();
    }//GEN-LAST:event_jmiCompilar

    private void jmiCortar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCortar
        // TODO add your handling code here:
        JTextComponent textComponent = escritura;
        textComponent.cut();
    }//GEN-LAST:event_jmiCortar

    private void jmiCopiar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCopiar
        // TODO add your handling code here:
        JTextComponent textComponent = escritura;
        textComponent.copy();
    }//GEN-LAST:event_jmiCopiar

    private void jmiPegar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPegar
        // TODO add your handling code here:
        JTextComponent textComponent = escritura;
        textComponent.paste();
    }//GEN-LAST:event_jmiPegar

    private void jmiBorrar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiBorrar
        // TODO add your handling code here:
        JTextComponent textComponent = escritura;
        textComponent.replaceSelection("");
    }//GEN-LAST:event_jmiBorrar

    private void jmiSeleccionarTodo(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSeleccionarTodo
        // TODO add your handling code here:
        JTextComponent textComponent = escritura;
        textComponent.selectAll();
        textComponent.requestFocusInWindow();
    }//GEN-LAST:event_jmiSeleccionarTodo

    private void jMenuItem12jmiCortar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12jmiCortar
        // TODO add your handling code here:
        JTextComponent textComponent = escritura;
        textComponent.cut();
    }//GEN-LAST:event_jMenuItem12jmiCortar

    private void jMenuItem14jmiCopiar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14jmiCopiar
        // TODO add your handling code here:
        JTextComponent textComponent = escritura;
        textComponent.copy();
    }//GEN-LAST:event_jMenuItem14jmiCopiar

    private void jMenuItem15jmiPegar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15jmiPegar
        // TODO add your handling code here:
        JTextComponent textComponent = escritura;
        textComponent.paste();
    }//GEN-LAST:event_jMenuItem15jmiPegar

    private void jMenuItem16jmiBorrar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16jmiBorrar
        // TODO add your handling code here:
        JTextComponent textComponent = escritura;
        textComponent.replaceSelection("");
    }//GEN-LAST:event_jMenuItem16jmiBorrar

    private void jMenuItem17jmiSeleccionarTodo(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17jmiSeleccionarTodo
        // TODO add your handling code here:
        JTextComponent textComponent = escritura;
        textComponent.selectAll();
        textComponent.requestFocusInWindow();
    }//GEN-LAST:event_jMenuItem17jmiSeleccionarTodo

    private void btnCompilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompilarActionPerformed
        /*    if (getTitle().contains("*") || getTitle().equals(title)) {
            if (directorio.Save()) {
                compile();
            }
        } else {
            compile();
        }*/

        compile();

    }//GEN-LAST:event_btnCompilarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (directorio.Save()) {
            clearFields();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (directorio.Open()) {
            colorAnalysis();
            clearFields();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        directorio.New();
        clearFields();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void compile() {
        clearFields();
        lexicalAnalysis();
        fillTableTokens();
        syntacticAnalysis();
        printConsole();
        codeHasBeenCompiled = true;
    }
    
    private void lexicalAnalysis() {
        // Extraer tokens
        Lexer lexer;
        try {
            File codigo = new File("code.encrypter");
            FileOutputStream output = new FileOutputStream(codigo);
            byte[] bytesText = escritura.getText().getBytes();
            output.write(bytesText);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream(codigo), "UTF8"));
            lexer = new Lexer(entrada);
            while (true) {
                Token token = lexer.yylex();
                if (token == null) {
                    break;
                }
                tokens.add(token);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no pudo ser encontrado... " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error al escribir en el archivo... " + ex.getMessage());
        }
    }

    /*========================================================*/
 /*========================================================*/
 /*========================================================*/
 /*========================================================*/
 /*========================================================*/
 /*========================================================*/
 /*========================================================*/
 /*========================================================*/

   

    String mTabla[][] = {
{	"-1"	,"int"	,"float","char"	,"id"	,"num"	,"if"	,"while","="	,","	,";"	,"+"	,"-"	,"*"	,"/"	,"("	,")"	,"{"	,"}"	,"=="	,"!="	,"<"	,">"	,"<="	,">="	,"cad"	,"print","read"	,"$"	,"P"	,"TIPO"	,"V"	,"A"	,"S"	,"E"	,"T"	,"F"	,"Z"	,"SENT"	,"O"	,"M"	,"R"	,"ARG"	},
{	"I0"	,"I4"	,"I5"	,"I6"	,"I9"	,"-1"	,"I10"	,"I11"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I67"	,"I68"	,"-1"	,"I1"	,"I2"	,"-1"	,"I7"	,"-1"	,"-1"	,"-1"	,"-1"	,"I3"	,"I8"	,"-1"	,"I65"	,"I66"	,"-1"	},
{	"I1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"P0"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I2"	,"-1"	,"-1"	,"-1"	,"I12"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I3"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"P2"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I4"	,"-1"	,"-1"	,"-1"	,"P3"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I5"	,"-1"	,"-1"	,"-1"	,"P4"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I6"	,"-1"	,"-1"	,"-1"	,"P5"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I7"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I13"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I8"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I14"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I9"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I15"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I10"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I16"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I11"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I17"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I12"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I19"	,"I20"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I18"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I13"	,"-1"	,"-1"	,"-1"	,"I9"	,"-1"	,"I10"	,"I11"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"P22"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I67"	,"I68"	,"P22"	,"-1"	,"-1"	,"-1"	,"I7"	,"-1"	,"-1"	,"-1"	,"-1"	,"I21"	,"I8"	,"-1"	,"I65"	,"I66"	,"-1"	},
{	"I14"	,"-1"	,"-1"	,"-1"	,"I9"	,"-1"	,"I10"	,"I11"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"P24"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I67"	,"I68"	,"P24"	,"-1"	,"-1"	,"-1"	,"I7"	,"-1"	,"-1"	,"-1"	,"-1"	,"I22"	,"I8"	,"-1"	,"I65"	,"I66"	,"-1"	},
{	"I15"	,"-1"	,"-1"	,"-1"	,"I30"	,"I31"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I24"	,"I25"	,"-1"	,"-1"	,"I29"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I23"	,"I26"	,"I27"	,"I28"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I16"	,"-1"	,"-1"	,"-1"	,"I30"	,"I31"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I29"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I32"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I17"	,"-1"	,"-1"	,"-1"	,"I30"	,"I31"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I29"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I33"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I18"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"P1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I19"	,"-1"	,"-1"	,"-1"	,"I34"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I20"	,"I4"	,"I5"	,"I6"	,"I9"	,"-1"	,"I10"	,"I11"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I67"	,"I68"	,"-1"	,"I35"	,"I2"	,"-1"	,"I7"	,"-1"	,"-1"	,"-1"	,"-1"	,"I3"	,"I8"	,"-1"	,"I65"	,"I66"	,"-1"	},
{	"I21"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"P21"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"P21"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I22"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"P23"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"P23"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I23"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"P8"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I24"	,"-1"	,"-1"	,"-1"	,"I30"	,"I31"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I29"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I36"	,"I27"	,"I28"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I25"	,"-1"	,"-1"	,"-1"	,"I30"	,"I31"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I29"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I37"	,"I27"	,"I28"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I26"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"P11"	,"I38"	,"I39"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I27"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"P14"	,"P14"	,"P14"	,"I40"	,"I41"	,"-1"	,"P14"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I28"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"P17"	,"P17"	,"P17"	,"P17"	,"P17"	,"-1"	,"P17"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I29"	,"-1"	,"-1"	,"-1"	,"I30"	,"I31"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I29"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I42"	,"I27"	,"I28"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I30"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"P19"	,"P19"	,"P19"	,"P19"	,"P19"	,"-1"	,"P19"	,"-1"	,"-1"	,"P19"	,"P19"	,"P19"	,"P19"	,"P19"	,"P19"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I31"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"P20"	,"P20"	,"P20"	,"P20"	,"P20"	,"-1"	,"P20"	,"-1"	,"-1"	,"P20"	,"P20"	,"P20"	,"P20"	,"P20"	,"P20"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I32"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I44"	,"I45"	,"I46"	,"I47"	,"I48"	,"I49"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I43"	,"-1"	,"-1"	,"-1"	},
{	"I33"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I44"	,"I45"	,"I46"	,"I47"	,"I48"	,"I49"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I50"	,"-1"	,"-1"	,"-1"	},
{	"I34"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I19"	,"I20"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I51"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I35"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"P7"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I36"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"P9"	,"I38"	,"I39"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I37"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"P10"	,"I38"	,"I39"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I38"	,"-1"	,"-1"	,"-1"	,"I30"	,"I31"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I29"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I52"	,"I28"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I39"	,"-1"	,"-1"	,"-1"	,"I30"	,"I31"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I29"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I53"	,"I28"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I40"	,"-1"	,"-1"	,"-1"	,"I30"	,"I31"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I29"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I54"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I41"	,"-1"	,"-1"	,"-1"	,"I30"	,"I31"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I29"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I55"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I42"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I38"	,"I39"	,"-1"	,"-1"	,"-1"	,"I56"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I43"	,"-1"	,"-1"	,"-1"	,"I30"	,"I31"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I29"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I57"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I44"	,"-1"	,"-1"	,"-1"	,"P27"	,"P27"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"P27"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I45"	,"-1"	,"-1"	,"-1"	,"P28"	,"P28"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"P28"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I46"	,"-1"	,"-1"	,"-1"	,"P29"	,"P29"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"P29"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I47"	,"-1"	,"-1"	,"-1"	,"P30"	,"P30"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"P30"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I48"	,"-1"	,"-1"	,"-1"	,"P31"	,"P31"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"P31"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I49"	,"-1"	,"-1"	,"-1"	,"P32"	,"P32"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"P32"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I50"	,"-1"	,"-1"	,"-1"	,"I30"	,"I31"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I29"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I58"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I51"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"P6"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I52"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"P12"	,"P12"	,"P12"	,"I40"	,"I41"	,"-1"	,"P12"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I53"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"P13"	,"P13"	,"P13"	,"I40"	,"I41"	,"-1"	,"P13"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I54"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"P15"	,"P15"	,"P15"	,"P15"	,"P15"	,"-1"	,"P15"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I55"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"P16"	,"P16"	,"P16"	,"P16"	,"P16"	,"-1"	,"P16"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I56"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"P18"	,"P18"	,"P18"	,"P18"	,"P18"	,"-1"	,"P18"	,"-1"	,"-1"	,"P18"	,"P18"	,"P18"	,"P18"	,"P18"	,"P18"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I57"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I59"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I58"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I60"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I59"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I61"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I60"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I62"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I61"	,"-1"	,"-1"	,"-1"	,"I9"	,"-1"	,"I10"	,"I11"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I67"	,"I68"	,"-1"	,"-1"	,"-1"	,"-1"	,"I7"	,"-1"	,"-1"	,"-1"	,"-1"	,"I63"	,"I8"	,"-1"	,"I65"	,"I66"	,"-1"	},
{	"I62"	,"-1"	,"-1"	,"-1"	,"I9"	,"-1"	,"I10"	,"I11"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I67"	,"I68"	,"-1"	,"-1"	,"-1"	,"-1"	,"I7"	,"-1"	,"-1"	,"-1"	,"-1"	,"I64"	,"I8"	,"-1"	,"I65"	,"I66"	,"-1"	},
{	"I63"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"P25"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I64"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"P26"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I65"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I69"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I66"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I70"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I67"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I71"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I68"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I72"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I69"	,"-1"	,"-1"	,"-1"	,"I9"	,"-1"	,"I10"	,"I11"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"P35"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I67"	,"I68"	,"P35"	,"-1"	,"-1"	,"-1"	,"I7"	,"-1"	,"-1"	,"-1"	,"-1"	,"I73"	,"I8"	,"-1"	,"I65"	,"I66"	,"-1"	},
{	"I70"	,"-1"	,"-1"	,"-1"	,"I9"	,"-1"	,"I10"	,"I11"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"P36"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I67"	,"I68"	,"P36"	,"-1"	,"-1"	,"-1"	,"I7"	,"-1"	,"-1"	,"-1"	,"-1"	,"I74"	,"I8"	,"-1"	,"I65"	,"I66"	,"-1"	},
{	"I71"	,"-1"	,"-1"	,"-1"	,"I77"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I76"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I75"	},
{	"I72"	,"-1"	,"-1"	,"-1"	,"I78"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I73"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"P33"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"P33"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I74"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"P34"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"P34"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I75"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I79"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I76"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I80"	,"-1"	,"-1"	,"-1"	,"-1"	,"P39"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I77"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I83"	,"-1"	,"-1"	,"-1"	,"-1"	,"P40"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I78"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I81"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I79"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"P37"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I80"	,"-1"	,"-1"	,"-1"	,"I77"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I76"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I82"	},
{	"I81"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"P38"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I82"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"P41"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	},
{	"I83"	,"-1"	,"-1"	,"-1"	,"I77"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I76"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"I84"	},
{	"I84"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"P42"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	,"-1"	}

    };
    
    Stack<String> pila = new Stack<>();

    private void errorLexico() {
        try {
            int banL = 0;
            while ("ERROR".equals(tokens.get(indice).getLexicalComp())) {
                if (tokens.get(indice).getLexeme().matches("[\']")) {
                    mensajes.setText(mensajes.getText() + "Error Lexico: token [ " + tokens.get(indice).getLexeme() + " ] se esperaba comilla simple de cierre [" + tokens.get(indice).getLine() + ", " + tokens.get(indice).getColumn() + "]");
                    ban = 1;
                } else if (tokens.get(indice).getLexeme().matches("'[^']*'")) {
                    mensajes.setText(mensajes.getText() + "Error Lexico: token [ " + tokens.get(indice).getLexeme() + " ] se esperaba solo un caracter entre las comillas simples [" + tokens.get(indice).getLine() + ", " + tokens.get(indice).getColumn() + "]");
                    ban = 1;
                } else {
                    mensajes.setText(mensajes.getText() + "Error Lexico: token [ " + tokens.get(indice).getLexeme() + " ] no es valido [" + tokens.get(indice).getLine() + ", " + tokens.get(indice).getColumn() + "]");
                    ban = 1 ;
                }
                indice++;
                banL = 1;
            }
            if (banL == 1) {
                indice--;
            }
        } catch (Exception e) {
        }
    }

    private void syntacticAnalysis() {
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Pila");
        tablaPila.setModel(modeloTabla);
        
        pila.clear();
        
        if(!tokens.isEmpty()){
            tokens.add( new Token("$","$", tokens.get(tokens.size()-1).getLine() , tokens.get(tokens.size()-1).getColumn() ) );
            ban = 0 ;
        }else{
            mensajes.setText(mensajes.getText() + "Error Linea: 0 Columna: 0");
            ban = 1;
        }
        
        programa();
        
        
        if (ban == 0) {            
            semanticAnalysis(); // analizador semantico
            if(ban == 0){
                mensajes.setText("Analisis terminado correctamente. La cadena si es aceptada...");
            }
        } else {
            String mmm = "";
            for(int i=1; i<=28; i++){
                String estado=pila.peek().substring(1,pila.peek().length()-1);
                int numEnt=Integer.parseInt(estado);
                if(!"-1".equals(mTabla[numEnt+1][i])){
                    mmm=mmm+mTabla[0][i] + "   ";
                }
            }
            mensajes.setText(mensajes.getText()+ "\nSe esperaba:\n" + mmm);
        }
    }
    
    
    private void fillPilaT() {
        modeloTabla.addRow(new Object[]{pila.toString()});
    }////////
  
    /////  inicio analisis /////
    int indice;
    int ban;
    private void programa() {
        mensajes1.setText("");
        pila.push(" $"); 
        pila.push("I0 ");
        indice=0;
        filasM=0;
        mAvanzar();
        if(ban == 0){
            fillPilaT();
        }
    }
    
    
    private void mAvanzar(){
        errorLexico();
        while(indice<tokens.size() && ban==0 && !(tokens.get(indice).getLexicalComp().equals("$") && pila.peek().equals("I0 ") )){
            mRecorrer();
            errorLexico();
        }
    }
    
    private void mRecorrer(){
        int num;
        for(int i=1; i<=28; i++){
            if(tokens.get(indice).getLexicalComp().equals(mTabla[0][i]) ){
                num=mEstado();
                if(mTabla[num+1][i].equals("-1")){
                    mensajes.setText(mensajes.getText()+ "Error en ´´ " + tokens.get(indice).getLexicalComp() + " ´´ Linea: " + tokens.get(indice).getLine() + " Columna: " + tokens.get(indice).getColumn());
                    ban=1;
                }else{
                    pila.push(" "+tokens.get(indice).getLexicalComp());
                    pila.push(mTabla[num+1][i]+" ");
                }
                if(pila.peek().charAt(0)=='P'){
                    mProduccion();
                }else{
                    indice++;
                }
                break;
            }
        } 
    }
    
    int filasM;
    private int mEstado(){
        int numEnt;
        String estado=pila.peek().substring(1,pila.peek().length()-1);
        numEnt=Integer.parseInt(estado);
        fillPilaT();
        if(pila.peek().equals("I12 ") || pila.peek().equals("I34 ")){ // identificar los id en la declaracion
            filasM++;   //contar esos id para la tabla donde se va a guardad el id y el tipo de dato
        }
        return numEnt;
    } 
    
    
        
    int arrProd[] ={ 1,   3,  1,  1,     1,     1,     3,  2,  3,  2,  2,  1,  3,  3,  1,  3,  3,  1,  3,  1,  1,  3,  2,  3,  2,  8,     8,     1,  1,  1,  1,  1,  1,  3,  3,  2,  2,  4,  4,  1,    1,    3,    3,     1,   1,   1};
    String arrPC[]={"P'","P","P","TIPO","TIPO","TIPO","V","V","A","S","S","S","E","E","E","T","T","T","F","F","F","Z","Z","Z","Z","SENT","SENT","O","O","O","O","O","O","Z","Z","Z","Z","M","R","ARG","ARG","ARG","ARG", "C", "C", "C"};
        
    private void mProduccion(){
        int numEnt;
        String produccion=pila.peek().substring(1,pila.peek().length()-1);
        numEnt=Integer.parseInt(produccion);
        pila.pop();
        pila.pop();
        for(int i=0; i<arrProd[numEnt]; i++){
            pila.pop();
            pila.pop();
        }
        int num;
        for(int i=28; i<=42; i++){
            if(arrPC[numEnt].equals(mTabla[0][i]) ){
                num=mEstado();
                pila.push(" "+arrPC[numEnt]);
                pila.push(mTabla[num+1][i]+" ");
                break;
            }
        }
    }
    
    
    
    // siguiente analisis //////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    String[][] matrizVariables;
    
    String cadVcw;
    private void semanticAnalysis(){
        matrizVariables = new String [filasM/2][3]; 
        indice = 0;
        int x=0,y=0;
        banCondicion1=0;
        banCondicion2=-1;
        cadVcw="";
        
        // tabla de las variables declaradas con su tipo de dato
        while(tokens.get(indice).getLexicalComp().equals("int") || tokens.get(indice).getLexicalComp().equals("float") || tokens.get(indice).getLexicalComp().equals("char")){
            String tipD = tokens.get(indice).getLexicalComp();
            do{
                matrizVariables[x][y]=tipD;
                indice++;
                y++;
                matrizVariables[x][y] = tokens.get(indice).getLexeme();
                mensajes1.setText(mensajes1.getText()+matrizVariables[x][0]+" "+matrizVariables[x][1]+";\n");
                indice++;
                x++;
                y--;
            }while(!tokens.get(indice).getLexicalComp().equals(";"));
            indice++;
        }
        
        for(int i=0 ; i<matrizVariables.length-1; i++){
            for(int j=i+1 ; j<matrizVariables.length; j++){
                if(matrizVariables[i][1].equals(matrizVariables[j][1])){
                    mensajes.setText(mensajes.getText()+ "La variable ´´" + matrizVariables[i][1] + "´´ ya fue declarada.\n");
                    ban=1;
                    break;
                }
            }
        }
        
        mensajes1.setText(mensajes1.getText()+"char v0;\nfloat v1;\nfloat v2;\nfloat v3;\nfloat Vc1;\nfloat Vc2;\nfloat Vw1;\nfloat Vw2;\n");
        
        Stack<Integer> pilaSiMientras = new Stack<>();
        pilaSiMientras.push(0);
        while(!tokens.get(indice).getLexicalComp().equals("$")){
            switch (tokens.get(indice).getLexicalComp()) {
                case "id":
                    mAsignar();
                    break;
                case "if":
                    indice++;
                    indice++;
                    cadVcw="Vc1";
                    mSi();
                    banCondicion1=banCondicion2;
                    indice++;
                    String opL1=tokens.get(indice).getLexicalComp();
                    indice++;
                    cadVcw="Vc2";
                    mSi();
                    if(banCondicion1!=banCondicion2){
                        mensajes.setText(mensajes.getText()+ "Error en Linea ["+tokens.get(indice).getLine()+"] : Operandos de diferentes tipos.\n");
                        ban=1;
                    }
                    banCondicion1=0;
                    banCondicion2=-1;
                    mensajes1.setText(mensajes1.getText()+"Vc1= Vc1"+opL1+"Vc2;\nif(!Vc1)\n    goto Else;\n");
                    pilaSiMientras.push(1);
                    break;
                case "while":
                    indice++;
                    indice++;
                    cadVcw="While:\n    Vw1";
                    mMientras();
                    banCondicion1=banCondicion2;
                    indice++;
                    String opL2=tokens.get(indice).getLexicalComp();
                    indice++;
                    cadVcw="    Vw2";
                    mMientras();
                    if(banCondicion1!=banCondicion2){
                        mensajes.setText(mensajes.getText()+ "Error en Linea ["+tokens.get(indice).getLine()+"] : Operandos de diferentes tipos.\n");
                        ban=1;
                    }
                    banCondicion1=0;
                    banCondicion2=-1;
                    mensajes1.setText(mensajes1.getText()+"    Vw1= Vw1"+opL2+"Vw2;\n    if(!Vw1)\n        goto Fin_While;\n");
                    pilaSiMientras.push(2);
                    break;
                case "print":
                    indice++;
                    indice++;
                    mensajes1.setText(mensajes1.getText()+"printf(\"");
                    variables="";
                    mPintar();
                    mensajes1.setText(mensajes1.getText()+"\""+variables+");\n");
                    break;
                case "read":
                    mensajes1.setText(mensajes1.getText()+"scanf(");
                    mLeer();
                    mensajes1.setText(mensajes1.getText()+");\n");
                    break;
            }
            indice++;
            if(tokens.get(indice).getLexicalComp().equals("}") && pilaSiMientras.peek()==1){
                mensajes1.setText(mensajes1.getText()+"    goto End_If;\nElse:\n    goto End_If;\nEnd_If:\n");
                pilaSiMientras.pop();
            }else if(tokens.get(indice).getLexicalComp().equals("}") && pilaSiMientras.peek()==2){
                mensajes1.setText(mensajes1.getText()+"        goto While;\nFin_While:\n");
                pilaSiMientras.pop();
            }
        }
    }
    
    
    
    int banCondicion1;
    int banCondicion2;
    
    private void mSi(){
        if(tokens.get(indice).getLexicalComp().equals("num")){
            banCondicion2=1;
            mensajes1.setText(mensajes1.getText()+cadVcw+"= "+tokens.get(indice).getLexeme()+";\n");
            return;
        }
        
        if(tokens.get(indice).getLexicalComp().equals("(")){
            mFlotante();//
            indice--;
            mensajes1.setText(mensajes1.getText()+cadVcw+"= v1;\n");
            banCondicion2=1;
            return;
        }
        
        if(tokens.get(indice).getLexicalComp().equals("id")){
            mensajes1.setText(mensajes1.getText()+cadVcw+"= "+tokens.get(indice).getLexeme()+";\n");
            if(tokens.get(indice).getLexeme().matches("'[^'\\\\]*'")){
                banCondicion2=2;
                return;
            }
            for(int i=0 ; i<matrizVariables.length; i++){
                if(matrizVariables[i][1].equals(tokens.get(indice).getLexeme())){
                    switch (matrizVariables[i][0]) {
                    case "int":
                        banCondicion2=1;
                        break;
                    case "float":
                        banCondicion2=1;
                        break;
                    case "char":
                        banCondicion2=2;
                        break;
                }
                return;
                }
            }
            
            mensajes.setText(mensajes.getText()+ "La variable ´´" + tokens.get(indice).getLexeme()+ "´´ no fue declarada.\n");
            ban=1;
        }
    }
    
    private void mMientras(){
        if(tokens.get(indice).getLexicalComp().equals("num")){
            banCondicion2=1;
            mensajes1.setText(mensajes1.getText()+cadVcw+"= "+tokens.get(indice).getLexeme()+";\n");
            return;
        }
        
        if(tokens.get(indice).getLexicalComp().equals("(")){
            mFlotante();
            indice--;
            mensajes1.setText(mensajes1.getText()+cadVcw+"= v1;\n");
            banCondicion2=1;
            return;
        }
        
        if(tokens.get(indice).getLexicalComp().equals("id")){
            mensajes1.setText(mensajes1.getText()+cadVcw+"= "+tokens.get(indice).getLexeme()+";\n");
            if(tokens.get(indice).getLexeme().matches("'[^'\\\\]*'")){
                banCondicion2=2;
                return;
            }
            for(int i=0 ; i<matrizVariables.length; i++){
                if(matrizVariables[i][1].equals(tokens.get(indice).getLexeme())){
                    switch (matrizVariables[i][0]) {
                    case "int":
                        banCondicion2=1;
                        break;
                    case "float":
                        banCondicion2=1;
                        break;
                    case "char":
                        banCondicion2=2;
                        break;
                }
                return;
                }
            }
            
            mensajes.setText(mensajes.getText()+ "La variable ´´" + tokens.get(indice).getLexeme()+ "´´ no fue declarada.\n");
            ban=1;
        }
    }
    
    String variables;
    private void mPintar(){
        if(tokens.get(indice).getLexicalComp().equals("cad")){
            /////quitar comillas
            String cadSinC="";
            for(int i=1; i<tokens.get(indice).getLexeme().length()-1; i++){
                cadSinC=cadSinC+tokens.get(indice).getLexeme().charAt(i)+"";
            }
            mensajes1.setText(mensajes1.getText()+cadSinC);
            indice++;
            if(tokens.get(indice).getLexicalComp().equals("+")){
                mensajes1.setText(mensajes1.getText()+" ");
                indice++;                
                mPintar();
            }
            return;
        }
        for(int i=0 ; i<matrizVariables.length; i++){
            if(matrizVariables[i][1].equals(tokens.get(indice).getLexeme())){
                variables=variables+","+tokens.get(indice).getLexeme();
                switch (matrizVariables[i][0]) {
                    case "int":
                        mensajes1.setText(mensajes1.getText()+" %d ");
                        break;
                    case "float":
                        mensajes1.setText(mensajes1.getText()+" %f ");
                        break;
                    case "char":
                        mensajes1.setText(mensajes1.getText()+" %c ");
                        break;
                }
                indice++;
                if(tokens.get(indice).getLexicalComp().equals("+")){
                    mensajes1.setText(mensajes1.getText()+" ");
                    indice++;                    
                    mPintar();
                }
                return;
            }
        }
        
        if(tokens.get(indice).getLexeme().matches("'[^'\\\\]*'")){
            mensajes.setText(mensajes.getText()+ "´´" + tokens.get(indice).getLexeme()+ "´´ tipo de dato no valido.\n");
        }else{
            mensajes.setText(mensajes.getText()+ "La variable ´´" + tokens.get(indice).getLexeme()+ "´´ no fue declarada.\n");
        }
        ban=1;
    }
    
    private void mLeer(){
        indice++;
        indice++;
        for(int i=0 ; i<matrizVariables.length; i++){
            if(matrizVariables[i][1].equals(tokens.get(indice).getLexeme())){
                //mensajes1.setText(mensajes1.getText()+matrizVariables[i][1]+" = v1;\n");
                switch (matrizVariables[i][0]) {
                    case "int":
                        mensajes1.setText(mensajes1.getText()+"\"%d\", &"+ tokens.get(indice).getLexeme());
                        break;
                    case "float":
                        mensajes1.setText(mensajes1.getText()+"\"%f\", &"+ tokens.get(indice).getLexeme());
                        break;
                    case "char":
                        mensajes1.setText(mensajes1.getText()+"\"%c\", &"+ tokens.get(indice).getLexeme());
                        break;
                }
                indice++;
                return;
            }
        }
        
        if(tokens.get(indice).getLexeme().matches("'[^'\\\\]*'")){
            mensajes.setText(mensajes.getText()+ "´´" + tokens.get(indice).getLexeme()+ "´´ tipo de dato no valido.\n");
        }else{
            mensajes.setText(mensajes.getText()+ "La variable ´´" + tokens.get(indice).getLexeme()+ "´´ no fue declarada.\n");
        }
        ban=1;
    }
    
    
    
    private void mAsignar(){
          // detalles a corregir, esto es para las asignaciones
          int ban0=0;
        for(int i=0 ; i<matrizVariables.length; i++){
            if(matrizVariables[i][1].equals(tokens.get(indice).getLexeme())){
                indice++;
                indice++;
                switch (matrizVariables[i][0]) {
                    case "int":
                        mEntero();
                        ban0=1;
                        break;
                    case "float":
                        mFlotante();
                        ban0=1;
                        break;
                    case "char":
                        mCaracter();
                        ban0=0;
                        break;
                }
                mensajes1.setText(mensajes1.getText()+matrizVariables[i][1]+"= v"+ban0+";\n");
                return;
            }
        }
        
        if(tokens.get(indice).getLexeme().matches("'[^'\\\\]*'")){
            mensajes.setText(mensajes.getText()+ "´´" + tokens.get(indice).getLexeme()+ "´´ tipo de dato no valido.\n");
        }else{
            mensajes.setText(mensajes.getText()+ "La variable ´´" + tokens.get(indice).getLexeme()+ "´´ no fue declarada.\n");
        }
        ban=1;
    }
    
    private void mEntero(){
        Stack<Character> pOP = new Stack<>();
        StringBuilder posfix = new StringBuilder();
        int banSolo=0;
        while(!tokens.get(indice).getLexicalComp().equals(";")){
            int ccc=0;
            banSolo++;
            String token = tokens.get(indice).getLexeme();
            if(tokens.get(indice).getLexicalComp().equals("id")){
                for(int i=0 ; i<matrizVariables.length; i++){
                    if(matrizVariables[i][1].equals(tokens.get(indice).getLexeme())){
                        if(matrizVariables[i][0].equals("int")){
                            posfix.append(tokens.get(indice).getLexeme()).append(" ");
                            ccc=1;
                            break;
                        }else{
                            mensajes.setText(mensajes.getText()+ "Debe de asignarse variables de tipo ´´int´´.\n");
                            ban=1;
                            return;
                        }
                    }
                }
                if(ccc==0){
                    if(tokens.get(indice).getLexeme().matches("'[^'\\\\]*'")){
                        mensajes.setText(mensajes.getText()+ "´´" + tokens.get(indice).getLexeme()+ "´´ tipo de dato no valido.\n");
                    }else{
                        mensajes.setText(mensajes.getText()+ "La variable ´´" + tokens.get(indice).getLexeme()+ "´´ no fue declarada.\n");
                    }
                    ban=1;
                    return; 
                }
                
            } else if (token.matches("[+-]?\\d+")) { // Verifica si es un número
                posfix.append(token).append(" ");
            } else if (token.equals("(")) {
                pOP.push('(');
            } else if (token.equals(")")) {
                while (!pOP.isEmpty() && pOP.peek() != '(') {
                    posfix.append(pOP.pop()).append(" ");
                }
                pOP.pop(); // Pop the '('
            } else if(tokens.get(indice).getLexicalComp().equals("num")){
                mensajes.setText(mensajes.getText()+ "Debe de asignarse numeros de tipo ´´int´´.\n");
                ban=1;
                return;
            }else {
                while (!pOP.isEmpty() && precedence(token.charAt(0)) <= precedence(pOP.peek())) {
                    posfix.append(pOP.pop()).append(" ");
                }
                pOP.push(token.charAt(0));
            }
            indice++;
        }////////////////////////////////////////
        

        
        while (!pOP.isEmpty()) {
            posfix.append(pOP.pop()).append(" ");
        }
        
        System.out.println("Notacion posfija: "+ posfix.toString().trim());
        
        if(banSolo==1 || banSolo==3){
            String valor1;
            if(tokens.get(indice-1).getLexicalComp().equals("id") && banSolo==1){
                valor1="0";
                mensajes1.setText(mensajes1.getText()+"v1= "+valor1+";\n");
                return;
            }else if(tokens.get(indice-2).getLexicalComp().equals("id") && banSolo==3){
                valor1="0";
                mensajes1.setText(mensajes1.getText()+"v1= "+valor1+";\n");
                return;
            }else if (banSolo==1){
                valor1=tokens.get(indice-1).getLexeme();
                mensajes1.setText(mensajes1.getText()+"v1= "+valor1+";\n");
                return;
            } else if(tokens.get(indice-1).getLexicalComp().equals(")")){
                valor1=tokens.get(indice-2).getLexeme();
                mensajes1.setText(mensajes1.getText()+"v1= "+valor1+";\n");
                return;
            }
        }
                
        float resultado = evaluarPosfix(posfix.toString().trim());
        System.out.println("Resultado: " + resultado); 
    }/////////////////////////////////////////
    
    
    
    // Método para evaluar una expresión posfija
    int vI;
    int banOP;
    String cadV = "";
    public  float evaluarPosfix(String posfix) {
        Stack<String> stack = new Stack<>();
        float operand2 = 0;
        float operand1 = 0;
        banOP=1;
        
        String expr= "[+-]?[1-9][0-9]*.[0-9]*[1-9][eE][-+][1-9][0-9]*|[+-]?[1-9][0-9]*[eE][-+][1-9][0-9]*|[+-]?[1-9][0-9]*.[0-9]*[1-9]|[+-]?[1-9][0-9]*|0.0|0|[+-]?0.[0-9]*[1-9][eE][-+][1-9][0-9]*|[+-]?0.[0-9]*[1-9]";
        for (String token : posfix.split("\\s+")) {
            if (token.matches(expr) || token.matches("[a-zA-Z_][a-zA-Z0-9_]*")) {
                stack.push(token);
            } else {
                vI=1;
                cadV = "";
                if(stack.peek().equals("$")){
                    stack.pop();
                } else{
                    cadV="v"+(banOP+1)+"= "+stack.peek()+";\n";
                }
                if(stack.peek().matches("[a-zA-Z_][a-zA-Z0-9_]*")){
                    stack.pop();
                    stack.push(0+"");
                }
                operand2 = Float.parseFloat(stack.pop());
                
                if(stack.peek().equals("$")){
                    stack.pop();
                } else{
                    cadV="v"+banOP+"= "+stack.peek()+";\n"+cadV;
                }
                
                if(banOP==2 && cadV.length()<9 && cadV.length()>1){
                     StringBuilder sb = new StringBuilder(cadV);
                     sb.setCharAt(1, '2');
                     cadV=sb+"";
                }
                mensajes1.setText(mensajes1.getText()+cadV);
                if(stack.peek().matches("[a-zA-Z_][a-zA-Z0-9_]*")){
                    stack.pop();
                    stack.push(0+"");
                }
                operand1 = Float.parseFloat(stack.pop());
                
                float result = realizarOperacion(operand1, operand2, token.charAt(0));
                stack.push(result+"");
                stack.push("$");
                banOP=2;
            }
        }
        vI=1;
        stack.pop();
        return Float.parseFloat(stack.pop());
    }

    // Método para obtener la precedencia de un operador
    private static float precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }

    // Método para realizar una operación aritmética
    private  float realizarOperacion(float operand1, float operand2, char operator) {
        int v1=1, v2=2;
        if(banOP==2 && cadV.length()>8){
            v1=2;
            v2=3;
            vI=2;
        }
        switch (operator) {
            case '+':
                mensajes1.setText(mensajes1.getText()+"v"+vI+"= v"+v1+" + v"+v2+";\n");
                return operand1 + operand2;
            case '-':
                mensajes1.setText(mensajes1.getText()+"v"+vI+"= v"+v1+" - v"+v2+";\n");
                return operand1 - operand2;
            case '*':
                mensajes1.setText(mensajes1.getText()+"v"+vI+"= v"+v1+" * v"+v2+";\n");
                return operand1 * operand2;
            case '/':
                if (operand2 != 0) {
                    mensajes1.setText(mensajes1.getText()+"v"+vI+"= v"+v1+" / v"+v2+";\n");
                    return operand1 / operand2;
                } else {
                    throw new ArithmeticException("Error: División por cero");
                }
            default:
                throw new IllegalArgumentException("Operador no válido: " + operator);
        }
    }////////////////////////////////
    
    
    private void mFlotante(){
        Stack<Character> pOP = new Stack<>();
        StringBuilder posfix = new StringBuilder();
        
        int banSolo=0;
        while(!tokens.get(indice).getLexicalComp().equals(";")  && !tokens.get(indice).getLexicalComp().equals("==") && !tokens.get(indice).getLexicalComp().equals("!=") && !tokens.get(indice).getLexicalComp().equals("<") && !tokens.get(indice).getLexicalComp().equals(">") && !tokens.get(indice).getLexicalComp().equals("<=") && !tokens.get(indice).getLexicalComp().equals(">=") && !tokens.get(indice+1).getLexicalComp().equals("{")){
            int ccc=0;
            banSolo++;
            //String token = tokens.get(indice).getLexeme();
            if(tokens.get(indice).getLexicalComp().equals("id")){
                for(int i=0 ; i<matrizVariables.length; i++){
                    if(matrizVariables[i][1].equals(tokens.get(indice).getLexeme())){
                        if(matrizVariables[i][0].equals("float") || matrizVariables[i][0].equals("int")){
                            posfix.append("0").append(" ");
                            ccc=1;
                            break;
                        }else{
                            mensajes.setText(mensajes.getText()+ "Debe de asignarse variables de tipo ´´float´´ o ´´int´´.\n");
                            ban=1;
                            return;
                        }
                    }
                }
                if(ccc==0){
                    if(tokens.get(indice).getLexeme().matches("'[^'\\\\]*'")){
                        mensajes.setText(mensajes.getText()+ "´´" + tokens.get(indice).getLexeme()+ "´´ tipo de dato no valido.\n");
                    }else{
                        mensajes.setText(mensajes.getText()+ "La variable ´´" + tokens.get(indice).getLexeme()+ "´´ no fue declarada.\n");
                    }
                    ban=1;
                    return;
                }
                
            }else if (tokens.get(indice).getLexicalComp().equals("num")) { // Verifica si es un número
                posfix.append(tokens.get(indice).getLexeme()).append(" ");
            } else if (tokens.get(indice).getLexeme().equals("(")) {
                pOP.push('(');
            } else if (tokens.get(indice).getLexeme().equals(")")) {
                while (!pOP.isEmpty() && pOP.peek() != '(') {
                    posfix.append(pOP.pop()).append(" ");
                }
                pOP.pop(); // Pop the '('
            } else {
                while (!pOP.isEmpty() && precedence(tokens.get(indice).getLexeme().charAt(0)) <= precedence(pOP.peek())) {
                    posfix.append(pOP.pop()).append(" ");
                }
                pOP.push(tokens.get(indice).getLexeme().charAt(0));
            }
            indice++;
        }
        
        
        while (!pOP.isEmpty()) {
            posfix.append(pOP.pop()).append(" ");
        }
        
        System.out.println("Notacion posfija: "+ posfix.toString().trim());
        
        if(banSolo==1 || banSolo==3){
            String valor1;
            if(tokens.get(indice-1).getLexicalComp().equals("id") && banSolo==1){
                valor1="0";
                mensajes1.setText(mensajes1.getText()+"v1= "+valor1+"\n");
                return;
            }else if(tokens.get(indice-2).getLexicalComp().equals("id") && banSolo==3){
                valor1="0";
                mensajes1.setText(mensajes1.getText()+"v1= "+valor1+"\n");
                return;
            }else if (banSolo==1){
                valor1=tokens.get(indice-1).getLexeme();
                mensajes1.setText(mensajes1.getText()+"v1= "+valor1+"\n");
                return;
            } else if(tokens.get(indice-1).getLexicalComp().equals(")")){
                valor1=tokens.get(indice-2).getLexeme();
                mensajes1.setText(mensajes1.getText()+"v1= "+valor1+"\n");
                return;
            }
        }
        
        float resultado = evaluarPosfix(posfix.toString().trim());
        System.out.println("Resultado: " + resultado); 
    }
    
    
    
    private void mCaracter(){
        vI=1;
        String cadena="";
        while(!tokens.get(indice).getLexicalComp().equals(";")){
            cadena=cadena + tokens.get(indice).getLexeme();
            indice++;
        }
        
        for(int i=0 ; i<matrizVariables.length; i++){
            if(matrizVariables[i][1].equals(cadena)){
                if(matrizVariables[i][0].equals("char")){
                    mensajes1.setText(mensajes1.getText()+ "v0 = "+cadena+";\n");
                    return;
                }
                break;
            }
        }
        if(!cadena.matches("'[^'\\\\]*'")) {
            mensajes.setText(mensajes.getText()+ "Debe de ser una asignacion de tipo ´´char´´.\n");
            ban=1;
        }else{
            mensajes1.setText(mensajes1.getText()+ "v0 = "+cadena+";\n");
        }
    }
    
    
/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
    /*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
    
    /*=====================================================*/
 /*=====================================================*/
 /*=====================================================*/
 /*=====================================================*/
 /*=====================================================*/
 /*=====================================================*/
 /*=====================================================*/
 /*=====================================================*/
 /*=====================================================*/
 /*=====================================================*/
    private void colorAnalysis() {
        /* Limpiar el arreglo de colores */
        textsColor.clear();
        /* Extraer rangos de colores */
        LexerColor lexerColor;
        try {
            File codigo = new File("color.encrypter");
            FileOutputStream output = new FileOutputStream(codigo);
            byte[] bytesText = escritura.getText().getBytes();
            output.write(bytesText);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream(codigo), "UTF8"));
            lexerColor = new LexerColor(entrada);
            while (true) {
                TextColor textColor = lexerColor.yylex();
                if (textColor == null) {
                    break;
                }
                textsColor.add(textColor);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no pudo ser encontrado... " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error al escribir en el archivo... " + ex.getMessage());
        }
        Functions.colorTextPane(textsColor, escritura, new Color(40, 40, 40));
    }

    private void fillTableTokens() {
        tokens.forEach(token -> {
            Object[] data = new Object[]{token.getLexicalComp(), token.getLexeme(), "[" + token.getLine() + ", " + token.getColumn() + "]"};
            Functions.addRowDataInTable(tabla, data);
        });
    }

    private void printConsole() {
        int sizeErrors = errors.size();
        if (sizeErrors > 0) {
            Functions.sortErrorsByLineAndColumn(errors);
            String strErrors = "\n";
            for (ErrorLSSL error : errors) {
                String strError = String.valueOf(error);
                strErrors += strError + "\n";
            }
            mensajes.setText("Analisis terminado...\n" + strErrors + "\nEl analisis terminó con errores...");
        } else {
            mensajes.setText("Analisis terminado...\n");
            this.syntacticAnalysis();
        }
        mensajes.setCaretPosition(0);
    }

    private void clearFields() {
        Functions.clearDataInTable(tabla);
        mensajes.setText("");
        mensajes1.setText("");
        tokens.clear();
        errors.clear();
        identProd.clear();
        identificadores.clear();
        codeHasBeenCompiled = false;
    }

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
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new FlatIntelliJLaf());
            } catch (UnsupportedLookAndFeelException ex) {
                System.out.println("LookAndFeel no soportado: " + ex);
            }
            new Compilador().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCompilar;
    private javax.swing.JTextPane escritura;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea mensajes;
    private javax.swing.JTextArea mensajes1;
    private javax.swing.JPanel panelButtonCompilerExecute;
    private javax.swing.JPanel rootPanel;
    private javax.swing.JTable tabla;
    private javax.swing.JTable tablaPila;
    // End of variables declaration//GEN-END:variables
}
