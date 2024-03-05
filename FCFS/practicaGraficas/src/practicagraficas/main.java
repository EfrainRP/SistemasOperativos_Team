package practicagraficas;

import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.util.Random;
import java.util.Queue;
import java.util.LinkedList;

public class main extends javax.swing.JFrame {
    int [] conjunto = {5,7,4,3,7,9,2,1,6,8}; 
    Burbuja b; //Instancia del objeto tipo Burbuja
    Grafico g; //Instancia objeto Grafica
    //--------------------------------------------------
    List<Process> procesos = new ArrayList<>(); // Lista procesos nuevos 
    List<Process> terminados = new ArrayList<>(); // Lista procesos terminados
    Process ejecucion; //Proceso en ejecucion 
    List<Integer> tiempos_procesos = new ArrayList<>(); // Lista para almacenar tiempos de procesos
    Queue<Process> cola_listos = new LinkedList<>(); //Cola de listos
    //----------------------------------------------------
    //proceso = new Process(1); //Process recibe como argumento el ID del proceso 
    //Variable, hilos e interrupciones
    private int contador_global; //Global Count
    private Thread contadorThread; //Global Count Thread
    private Thread GraficaThread; //Hilo de Grafica 
    private Thread tiemposThread; //Hilo de Tiempos
    private volatile boolean ejecutando = true; //Interrupcion Continuar/Pausar hilo
    private Thread bloqueadosThread; //Global Count Thread
    private volatile boolean bloqueados = true; // Bandera para controlar la ejecución del hilo
    private int threadCount = 0; // Contador para generar identificadores únicos de hilo
    private DefaultTableModel tablaBloqueados = new DefaultTableModel(); //Tabla bloqueados 
    private DefaultTableModel tablaCola = new DefaultTableModel(); //Tabla cola listos
    private DefaultTableModel tablaTerminados = new DefaultTableModel(); //Tabla terminados
    
    public main() {
        initComponents();
        b = new Burbuja(conjunto);
        g = new Grafico();
        contador_global = -1;  
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        cpu = new javax.swing.JList<>();
        panel_cpu3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        label_ocupado3 = new javax.swing.JLabel();
        label_tiempo3 = new javax.swing.JLabel();
        label_id4 = new javax.swing.JLabel();
        tiempo_cpu3 = new javax.swing.JLabel();
        id_cpu3 = new javax.swing.JLabel();
        ocupado_cpu3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        panel = new javax.swing.JPanel();
        panel_cpu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        label_ocupado = new javax.swing.JLabel();
        label_tiempo = new javax.swing.JLabel();
        label_id1 = new javax.swing.JLabel();
        tiempo_cpu = new javax.swing.JLabel();
        id_cpu = new javax.swing.JLabel();
        ocupado_cpu = new javax.swing.JLabel();
        panel_cpu1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        label_llegada = new javax.swing.JLabel();
        tiempo_llegada = new javax.swing.JLabel();
        panel_cpu2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        label_respuesta = new javax.swing.JLabel();
        tiempo_respuesta = new javax.swing.JLabel();
        panel_cpu4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        label_espera = new javax.swing.JLabel();
        tiempo_espera = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla_bloqueados = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabla_cola = new javax.swing.JTable();
        label_cola = new javax.swing.JLabel();
        label_bloqueados2 = new javax.swing.JLabel();
        iniciar = new javax.swing.JButton();
        bloquear = new javax.swing.JButton();
        terminar = new javax.swing.JButton();
        stop = new javax.swing.JButton();
        ejecutar = new javax.swing.JButton();
        nuevo = new javax.swing.JButton();
        label_leyenda = new javax.swing.JLabel();
        label_cola_listos = new javax.swing.JLabel();
        label_bloqueado = new javax.swing.JLabel();
        label_ejecutando = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabla_terminados = new javax.swing.JTable();
        label_bloqueados3 = new javax.swing.JLabel();
        label_contador = new javax.swing.JLabel();
        contador = new javax.swing.JLabel();

        cpu.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(cpu);

        panel_cpu3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel4.setText("Tiempo de respuesta");

        label_ocupado3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label_ocupado3.setText("Ocupado:");

        label_tiempo3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label_tiempo3.setText("Tiempo:");

        label_id4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label_id4.setText("ID:");

        tiempo_cpu3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tiempo_cpu3.setText("32");

        id_cpu3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        id_cpu3.setText("32");

        ocupado_cpu3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ocupado_cpu3.setText("32");

        javax.swing.GroupLayout panel_cpu3Layout = new javax.swing.GroupLayout(panel_cpu3);
        panel_cpu3.setLayout(panel_cpu3Layout);
        panel_cpu3Layout.setHorizontalGroup(
            panel_cpu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_cpu3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panel_cpu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_cpu3Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(panel_cpu3Layout.createSequentialGroup()
                        .addGroup(panel_cpu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_tiempo3)
                            .addComponent(label_id4)
                            .addComponent(label_ocupado3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panel_cpu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tiempo_cpu3)
                            .addComponent(id_cpu3)
                            .addComponent(ocupado_cpu3))
                        .addGap(71, 71, 71))))
        );
        panel_cpu3Layout.setVerticalGroup(
            panel_cpu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_cpu3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_cpu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_tiempo3)
                    .addComponent(tiempo_cpu3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_cpu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_id4)
                    .addComponent(id_cpu3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_cpu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_ocupado3)
                    .addComponent(ocupado_cpu3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));

        panel.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        panel_cpu.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("CPU");

        label_ocupado.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label_ocupado.setText("Ocupado:");

        label_tiempo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label_tiempo.setText("Tiempo:");

        label_id1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label_id1.setText("ID:");

        tiempo_cpu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tiempo_cpu.setText("32");

        id_cpu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        id_cpu.setText("32");

        ocupado_cpu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ocupado_cpu.setText("32");

        javax.swing.GroupLayout panel_cpuLayout = new javax.swing.GroupLayout(panel_cpu);
        panel_cpu.setLayout(panel_cpuLayout);
        panel_cpuLayout.setHorizontalGroup(
            panel_cpuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_cpuLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panel_cpuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_tiempo)
                    .addComponent(label_id1)
                    .addComponent(label_ocupado)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(panel_cpuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tiempo_cpu)
                    .addComponent(id_cpu)
                    .addComponent(ocupado_cpu))
                .addGap(71, 71, 71))
        );
        panel_cpuLayout.setVerticalGroup(
            panel_cpuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_cpuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_cpuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_tiempo)
                    .addComponent(tiempo_cpu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_cpuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_id1)
                    .addComponent(id_cpu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_cpuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_ocupado)
                    .addComponent(ocupado_cpu))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        panel_cpu1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel2.setText("Tiempo de llegada");

        label_llegada.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label_llegada.setText("Tiempo:");

        tiempo_llegada.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tiempo_llegada.setText("32");

        javax.swing.GroupLayout panel_cpu1Layout = new javax.swing.GroupLayout(panel_cpu1);
        panel_cpu1.setLayout(panel_cpu1Layout);
        panel_cpu1Layout.setHorizontalGroup(
            panel_cpu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_cpu1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panel_cpu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_cpu1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(panel_cpu1Layout.createSequentialGroup()
                        .addComponent(label_llegada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tiempo_llegada)
                        .addGap(71, 71, 71))))
        );
        panel_cpu1Layout.setVerticalGroup(
            panel_cpu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_cpu1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_cpu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_llegada)
                    .addComponent(tiempo_llegada))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_cpu2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel3.setText("Tiempo de respuesta");

        label_respuesta.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label_respuesta.setText("Tiempo:");

        tiempo_respuesta.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tiempo_respuesta.setText("32");

        javax.swing.GroupLayout panel_cpu2Layout = new javax.swing.GroupLayout(panel_cpu2);
        panel_cpu2.setLayout(panel_cpu2Layout);
        panel_cpu2Layout.setHorizontalGroup(
            panel_cpu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_cpu2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panel_cpu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_cpu2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(panel_cpu2Layout.createSequentialGroup()
                        .addComponent(label_respuesta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tiempo_respuesta)
                        .addGap(71, 71, 71))))
        );
        panel_cpu2Layout.setVerticalGroup(
            panel_cpu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_cpu2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_cpu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_respuesta)
                    .addComponent(tiempo_respuesta))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_cpu4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel5.setText("Tiempo de espera");

        label_espera.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label_espera.setText("Tiempo:");

        tiempo_espera.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tiempo_espera.setText("32");

        javax.swing.GroupLayout panel_cpu4Layout = new javax.swing.GroupLayout(panel_cpu4);
        panel_cpu4.setLayout(panel_cpu4Layout);
        panel_cpu4Layout.setHorizontalGroup(
            panel_cpu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_cpu4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panel_cpu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_cpu4Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(panel_cpu4Layout.createSequentialGroup()
                        .addComponent(label_espera)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tiempo_espera)
                        .addGap(71, 71, 71))))
        );
        panel_cpu4Layout.setVerticalGroup(
            panel_cpu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_cpu4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_cpu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_espera)
                    .addComponent(tiempo_espera))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        tabla_bloqueados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabla_bloqueados.setCellSelectionEnabled(true);
        jScrollPane3.setViewportView(tabla_bloqueados);

        tabla_cola.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabla_cola.setCellSelectionEnabled(true);
        jScrollPane4.setViewportView(tabla_cola);

        label_cola.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        label_cola.setForeground(new java.awt.Color(0, 153, 153));
        label_cola.setText("Cola listos");

        label_bloqueados2.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        label_bloqueados2.setForeground(new java.awt.Color(0, 153, 0));
        label_bloqueados2.setText("Bloqueados");

        iniciar.setBackground(new java.awt.Color(255, 255, 0));
        iniciar.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        iniciar.setText("Iniciar");
        iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarActionPerformed(evt);
            }
        });

        bloquear.setBackground(new java.awt.Color(0, 204, 0));
        bloquear.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        bloquear.setText("Bloquear");
        bloquear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bloquearActionPerformed(evt);
            }
        });

        terminar.setBackground(new java.awt.Color(255, 51, 51));
        terminar.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        terminar.setText("Terminar");
        terminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                terminarActionPerformed(evt);
            }
        });

        stop.setBackground(new java.awt.Color(0, 255, 204));
        stop.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        stop.setText("Stop");
        stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopActionPerformed(evt);
            }
        });

        ejecutar.setBackground(new java.awt.Color(0, 255, 204));
        ejecutar.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        ejecutar.setText("Ejecutar");
        ejecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ejecutarActionPerformed(evt);
            }
        });

        nuevo.setBackground(new java.awt.Color(102, 102, 255));
        nuevo.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        nuevo.setText("Nuevo");
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });

        label_leyenda.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        label_leyenda.setText("Leyenda:");

        label_cola_listos.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        label_cola_listos.setForeground(new java.awt.Color(0, 153, 153));
        label_cola_listos.setText("Cola listos");

        label_bloqueado.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        label_bloqueado.setForeground(new java.awt.Color(0, 204, 0));
        label_bloqueado.setText("Bloqueado");

        label_ejecutando.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        label_ejecutando.setForeground(new java.awt.Color(255, 0, 0));
        label_ejecutando.setText("Ejecutando");

        tabla_terminados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabla_terminados.setCellSelectionEnabled(true);
        jScrollPane5.setViewportView(tabla_terminados);

        label_bloqueados3.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        label_bloqueados3.setForeground(new java.awt.Color(204, 0, 51));
        label_bloqueados3.setText("Terminados");

        label_contador.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        label_contador.setForeground(new java.awt.Color(0, 0, 204));
        label_contador.setText("Conter:");

        contador.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        contador.setForeground(new java.awt.Color(204, 0, 0));
        contador.setText("32");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(iniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panel_cpu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label_leyenda, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(label_bloqueado)
                                .addGap(8, 8, 8)
                                .addComponent(label_cola_listos))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label_contador, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(contador)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(panel_cpu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panel_cpu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(panel_cpu4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(label_bloqueados2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label_ejecutando)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                        .addComponent(bloquear)
                        .addGap(18, 18, 18)
                        .addComponent(terminar)
                        .addGap(18, 18, 18)
                        .addComponent(stop)
                        .addGap(18, 18, 18)
                        .addComponent(ejecutar)
                        .addGap(18, 18, 18)
                        .addComponent(nuevo))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_cola, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_bloqueados3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(panel_cpu4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panel_cpu2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panel_cpu1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_bloqueados2)
                            .addComponent(label_cola)
                            .addComponent(label_bloqueados3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel_cpu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_contador, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(contador))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(bloquear)
                                .addComponent(terminar)
                                .addComponent(stop)
                                .addComponent(ejecutar)
                                .addComponent(nuevo))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(iniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(label_leyenda)
                                    .addComponent(label_bloqueado)
                                    .addComponent(label_cola_listos)
                                    .addComponent(label_ejecutando))))))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //Funcion principal
    private void iniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarActionPerformed
   //Creacion de procesos 
    tiempos_procesos.add(0); //Omite el primer tiempo en la grafica
    boolean cantidadIngresada = false; // Bandera para verificar si ya se ingresó la cantidad de procesos
    do {
            if (!cantidadIngresada) { // Solicitar la cantidad de procesos al usuario
                String cantidadText = JOptionPane.showInputDialog(null, "Ingrese la cantidad de procesos:");
                if (cantidadText != null && !cantidadText.isEmpty()) {
                    try {
                        int cantidad = Integer.parseInt(cantidadText) + 1; //Cantidad de procesos + 1 al graficarse

                        // Crear los procesos con IDs distintos y asignar tiempos
                        for (int i = 1; i < cantidad; i++) {
                            Process proceso = new Process(i);
                            procesos.add(proceso);
                        }

                        // Mostrar los procesos creados
                        StringBuilder sb = new StringBuilder("Procesos creados y sus tiempos:\n");
                        for (Process proceso : procesos){
                                sb.append("ID: ").append(proceso.getProcessId()).append(" | Time: ").append(proceso.getTime()).append("\n");
                        }
                        JOptionPane.showMessageDialog(null, sb.toString());

                        cantidadIngresada = true; // Marcar que la cantidad fue ingresada correctamente

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Ingrese un número válido para la cantidad de procesos.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    break; // Si se cancela el diálogo, salir del bucle
                }
            } else {
                break; // Si ya se ingresó la cantidad de procesos, salir del bucle
            }
        } while (true);
    contadorGlobal();  //Iniciaa el contador global 
   //Divide los procesos en sus respectivos estados "Ejecucion","Cola Listos","Nuevos"
            //Procesos maximos en la cola de listos = 5
             int count = 0; //Contador de procesos en el ciclo
                 for (Process proceso : procesos) { //Recorre los procesos 
                      if(count <= 4){ //Valida que solo 5 procesos inicien en la cola de listos
                          cola_listos.offer(proceso); //Añade a la cola de listos un maximo de 5 procesos 
                       }
                      count++;
                 }
            //Elimina los procesos repetidos en "nuevos" que han sido añadidos a listos 
             for(int j=0; j < cola_listos.size();j++){
                  procesos.remove(0); 
             }
 //Estados de procesos---------------------------------
     //Asigna el proceso en estado "Ejecucion" 
     ejecucion = cola_listos.remove(); 
     //System.out.println(ejecucion.getProcessId());
     tiempos_procesos.add(ejecucion.getTime()); //Añade el tiempo del proceso en ejecucion a la grafica 
     //Añade los tiempos de los procesos en "Cola de listos" a la grafica 
     for (Process proceso : cola_listos) {
         //System.out.println(proceso.getProcessId());
         tiempos_procesos.add(proceso.getTime());
     }  
     //Añade los tiempos de los procesos en "Nuevos" a la grafica 
     for (Process proceso : procesos){
         //System.out.println(proceso.getProcessId());
         tiempos_procesos.add(proceso.getTime());
     }
    actualizarGrafica();

  //------------------------------------------------------------------------
       //System.out.println("El valor es " + procesos[0].getProcessId());
        //conjunto2 puede representar el "tiempo" de cada proceso
        //int [] conjunto2 = {5,7,4,3,7,9,2,1,6,8,4,6,7,8,9,5,3,2,4,5,6,7,8,9,5,3};
        //int [] conjunto2 = {7,5,4,3,2,8};
        //g.crearHistograma(tiempos_procesos,panel,Color.white);
        //------------------------------------------------------------------------
        //Inicializacion de prueba tablas
           //Tabla de procesos bloqueados
           // Columnas de la tabla
           tablaBloqueados.setColumnIdentifiers(new Object[]{"ID", "Transcurrido"});
           // Modelo de la tabla y filas 
           tabla_bloqueados.setModel(tablaBloqueados);
           for (int i = 0; i < 4; i++) {
           tablaCola.addRow(new Object[]{5+i, 3+i});} 
            procesosBloqueados(13,0,0); //ID,fila,TT_actual = 0 (tiempo transcurrido bloqueado)
            procesosBloqueados(20,1,0);
            procesosBloqueados(35,2,0);
            procesosBloqueados(40,3,0);
           
           //Tabla de cola de procesos (Ej maxima cantidad de procesos en: bloqueados, ejecución y cola listos = 5) 
           tablaCola.setColumnIdentifiers(new Object[]{"ID", "Tiempo"});
           tabla_cola.setModel(tablaCola);
           for (int i = 0; i < 4; i++) {
           tablaCola.addRow(new Object[]{5+i, 3+i});}
           
           //Tabla de procesos terminados
           tablaTerminados.setColumnIdentifiers(new Object[]{"ID", "Tiempo finalización","Tiempo retorno"});
           tabla_terminados.setModel(tablaTerminados);
           for (int i = 0; i < 3; i++) {
           tablaTerminados.addRow(new Object[]{5+i, 3+i,4+i});}
        
        //Metodos eliminar y modificar <--
         // Elimina la fila del índice en la tabla 
           tablaBloqueados.removeRow(1);
           // Modifica un valor en la tabla --> Args (nuevoValor,fila,columna) Ej: (11,0,1) = 11, fila 1, columna 2
           tablaBloqueados.setValueAt(11, 0, 1); 
        //----------------------------------------------------------------------
     //Inicializacion de prueba paneles
          //Panel CPU
          tiempo_cpu.setText(String.valueOf(1));
          id_cpu.setText(String.valueOf(2));
          ocupado_cpu.setText(String.valueOf(3));
          //Tiempo llegada
          tiempo_llegada.setText(String.valueOf(4));
          //Tiempo respuesta
          tiempo_respuesta.setText(String.valueOf(5));
          //Tiempo espera
          tiempo_espera.setText(String.valueOf(7));
          tiemposProcesos();
    }//GEN-LAST:event_iniciarActionPerformed
    //Funciones de interrupciones
    
    //--------------------------------------------------------------
    private void pausar() { //Interrupcion de Pausa
        ejecutando = false; 
        bloqueados = false;
        contadorThread.interrupt(); // Interrumpir contador
        bloqueadosThread.interrupt(); //Interrumpir bloqueados
   }

    private void continuar() { //Interrupcion de Continuar o Ejecutar 
       ejecutando = true; 
       bloqueados = true;
       //Vuelven a iniciar los procesos bloqueados en su estado actual 
       int rowCount = tablaBloqueados.getRowCount(); // Obtiene los procesos bloqueados
        // Iterar sobre cada fila
        for (int i = 0; i < rowCount; i++) {
            // Obtener el ID de la fila en la columna 0
            int id = (int) tablaBloqueados.getValueAt(i, 0);
            // Obtener el tiempo de la fila en la columna 1
            int tiempo = (int) tablaBloqueados.getValueAt(i, 1);
            procesosBloqueados(id,i,tiempo); //ID,fila, TT_Actual (comienza el TT en donde se quedo)
        }
     contadorGlobal(); //Vuelve a iniciar el contador global 
    }
     private void nuevo() { //Interrupcion de nuevo proceso
       
   }
     private void terminar() { //Interrupcion de terminar proceso
       
   }
   //---------------------------------------------------------------
   //Hilos/Subprocesos
    private void contadorGlobal() { //Funcion/Hilo del contador global
        contadorThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (ejecutando) { // Mientras la bandera de ejecución sea verdadera
                    synchronized (this) { //Protege el codigo del hilo al poder haber varios hilos funcionando
                        // Lógica del contador
                        contador_global++;
                        contador.setText(String.valueOf(contador_global));
                        try {
                            Thread.sleep(1000); //Actualiza por seg
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                            return; // Salir del hilo si se interrumpe durante la espera
                        }
                    }
                }
            }
        });
        contadorThread.start(); // Iniciar el hilo
    }
    private void procesosBloqueados(int id,int fila, int TT_actual) { //Funcion/Hilo de procesos bloqueados
        bloqueadosThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int TT = 0;
                if(TT_actual != 0){//Actualiza el TT al actual del proceso bloqueado al ser despausado
                   TT = TT_actual;
                }
                tablaBloqueados.addRow(new Object[]{id, TT}); //Nuevo bloqueado en la tabla
                while (bloqueados && TT < 8) { // Mientras haya bloqueados y TT < 8
                    synchronized (this) { //Protege el codigo del hilo al poder haber varios hilos funcionando
                        TT++;
                        tablaBloqueados.setValueAt(id, fila, 0); //Actualiza el ID del proceso en la tabla
                        tablaBloqueados.setValueAt(TT, fila, 1); //Actualiza el TT del proceso en la tabla
                    }
                        try {
                            Thread.sleep(1000); //Actualiza por seg
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                            return; // Salir del hilo si se interrumpe durante la espera
                        }
                    }
                                                 //Antes de terminar, regresar a la tabla cola listos <--
                tablaBloqueados.removeRow(fila); //Termina el proceso bloqueado
                }
        });
        bloqueadosThread.start(); // Iniciar el hilo
    }
   private void actualizarGrafica() { //Funcion/Hilo de datos en Grafica
   
                // Llamar al método crearHistograma con tiempos_procesos
                g.crearHistograma(tiempos_procesos.stream().mapToInt(Integer::intValue).toArray(), panel, Color.white);
                for (int i = 0; i < tiempos_procesos.size(); i++) {
                    // Editar el color de un proceso en la grafica
                    if (i == 0) { // Color del proceso en ejecución
                        g.editarColorProceso(i, Color.red);
                    } else if (i > 0 && i < 5) { // Color de procesos en cola
                        g.editarColorProceso(i, Color.CYAN);
                    } else if (i >= 5) { // Color de procesos nuevos
                        g.editarColorProceso(i, new Color(139, 69, 19));
                    }
                }
         
}
  private void tiemposProcesos() { //Funcion/Hilo Tiempos/procesos
    tiemposThread = new Thread(() -> {
        try {
            boolean ejecutado = false; // Variable para controlar si ya se ejecutó el bloque de código
            int timer = 0;
            while (true) {
                // Verificar si ejecucion.getTime() es igual a contador_global
                if (ejecucion.getTime() == timer && !ejecutado) {
                    terminados.add(ejecucion); // Cambia el estado del proceso a "terminados"
                    System.out.println(timer);
                    recorrerProcesos();
                    ejecutado = true; // Marcar como ejecutado
                    timer = 0;
                    
                } else if (ejecucion.getTime() != timer) { 
                    ejecutado = false; // Reiniciar el indicador si el tiempo ha cambiado
                }
                // Agregar alguna pausa para evitar un bucle infinito sin descanso
                Thread.sleep(1000); // Por ejemplo, esperar 1000 milisegundos (1 segundo)
                tiempos_procesos.set(1, timer); // Actualizar el tiempo del proceso en ejecucion
                actualizarGrafica(); //Actualiza la barra de "ejecucion" de acuerdo a su tiempo 
                timer++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    });
    // Inicia el hilo
    tiemposThread.start();
}
      private void recorrerProcesos() { //Recorre la cola de procesos
    //Asigna el proceso en estado "Ejecucion" 
     if(cola_listos.size() != 0){ //Si hay procesos en cola 
         ejecucion = cola_listos.remove();
     }else{ //Si ya no hay procesos en cola
         pausar(); tiemposThread.interrupt(); tiempos_procesos.clear(); actualizarGrafica();
     } //Interrumpir bloqueados}
     //System.out.println(ejecucion.getProcessId());
     //Añade un proceso de "nuevos" a la "cola listos"
     if(procesos.size() != 0){cola_listos.offer(procesos.remove(0));}
     //System.out.println(ejecucion.getProcessId());
     tiempos_procesos.clear(); //Limpia los tiempos de los procesos anteriores 
     tiempos_procesos.add(0); //Omite el primer tiempo en la grafica
     tiempos_procesos.add(ejecucion.getTime()); //Añade el tiempo del proceso en ejecucion a la grafica 
     //Añade los tiempos de los procesos en "Cola de listos" a la grafica 
     //System.out.println("cola");
     if(cola_listos.size() != 0){
     for (Process proceso : cola_listos) {
         //System.out.println(proceso.getProcessId());
           tiempos_procesos.add(proceso.getTime());
     }}
     //System.out.println("nuevos");
     //Añade los tiempos de los procesos en "Nuevos" a la grafica 
     if(procesos.size() != 0){
        for (Process proceso : procesos){
            //System.out.println(proceso.getProcessId());
            tiempos_procesos.add(proceso.getTime());
     }}
     //actualizarGrafica();
       
   }
    //-------------------------------------------------------------------------
    private void bloquearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bloquearActionPerformed
        /*Datos prueba en distintos eventos (eliminar al implementar) <--
        b.Ordenar();
        conjunto = b.getConjunto();
        g.crearHistograma(conjunto,panel,Color.white);
        for (int i = 0; i < (conjunto.length)/2; i++) {
            g.editarColorProceso(i, Color.red);}
        //Panel CPU
          tiempo_cpu.setText(String.valueOf(conjunto[1]));
          id_cpu.setText(String.valueOf(conjunto[2]));
          ocupado_cpu.setText(String.valueOf(conjunto[4]));
          //Tiempo llegada
          tiempo_llegada.setText(String.valueOf(conjunto[3]));
          //Tiempo respuesta
          tiempo_respuesta.setText(String.valueOf(conjunto[5]));
          //Tiempo espera
          tiempo_espera.setText(String.valueOf(conjunto[6]));
        */
        procesosBloqueados(55,0,0);
    }//GEN-LAST:event_bloquearActionPerformed

    private void terminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_terminarActionPerformed
        // Terminar procesos en ejecución
    }//GEN-LAST:event_terminarActionPerformed

    private void stopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopActionPerformed
        pausar();
    }//GEN-LAST:event_stopActionPerformed

    private void ejecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ejecutarActionPerformed
        continuar();      
    }//GEN-LAST:event_ejecutarActionPerformed

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
      // Añadir procesos a "NUEVOS"
    }//GEN-LAST:event_nuevoActionPerformed

    
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
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bloquear;
    private javax.swing.JLabel contador;
    private javax.swing.JList<String> cpu;
    private javax.swing.JButton ejecutar;
    private javax.swing.JLabel id_cpu;
    private javax.swing.JLabel id_cpu3;
    private javax.swing.JButton iniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel label_bloqueado;
    private javax.swing.JLabel label_bloqueados2;
    private javax.swing.JLabel label_bloqueados3;
    private javax.swing.JLabel label_cola;
    private javax.swing.JLabel label_cola_listos;
    private javax.swing.JLabel label_contador;
    private javax.swing.JLabel label_ejecutando;
    private javax.swing.JLabel label_espera;
    private javax.swing.JLabel label_id1;
    private javax.swing.JLabel label_id4;
    private javax.swing.JLabel label_leyenda;
    private javax.swing.JLabel label_llegada;
    private javax.swing.JLabel label_ocupado;
    private javax.swing.JLabel label_ocupado3;
    private javax.swing.JLabel label_respuesta;
    private javax.swing.JLabel label_tiempo;
    private javax.swing.JLabel label_tiempo3;
    private javax.swing.JButton nuevo;
    private javax.swing.JLabel ocupado_cpu;
    private javax.swing.JLabel ocupado_cpu3;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panel_cpu;
    private javax.swing.JPanel panel_cpu1;
    private javax.swing.JPanel panel_cpu2;
    private javax.swing.JPanel panel_cpu3;
    private javax.swing.JPanel panel_cpu4;
    private javax.swing.JButton stop;
    private javax.swing.JTable tabla_bloqueados;
    private javax.swing.JTable tabla_cola;
    private javax.swing.JTable tabla_terminados;
    private javax.swing.JButton terminar;
    private javax.swing.JLabel tiempo_cpu;
    private javax.swing.JLabel tiempo_cpu3;
    private javax.swing.JLabel tiempo_espera;
    private javax.swing.JLabel tiempo_llegada;
    private javax.swing.JLabel tiempo_respuesta;
    // End of variables declaration//GEN-END:variables
}
