/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package calculadorae;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Zurdex.html
 */
/// Como usar una tabla en NeatBeans
/// No sabia como hacerlo se investigó
//link por si en un futuro lo ocupas :D
//https://youtu.be/6GMdqSO7OnQ?si=qtQz1kwhNygfRrLJ




//// primero crearemos las tablas con ayuda de DefaultTableModel 

public class Tablademo extends javax.swing.JFrame {
 DefaultTableModel dtn1 = new DefaultTableModel();
 /// añadimos  los metodos de ordenamiento
   Class_QuickSort quickSort = new Class_QuickSort();
   Class_Shell shellSort = new Class_Shell();
      DefaultTableModel dtm2 = new DefaultTableModel();
    
  
  public Tablademo() {
    initComponents();
    this.setLocationRelativeTo (null);
    // Configuración de la primera tabla (jTable1)
    String[] titulo1 = new String[] {"Valores", "Quick-Sort", "Shell"};
  
    dtn1.setColumnIdentifiers(titulo1);
    jTable1.setModel(dtn1);
    
    // Configuración de la segunda tabla (jTable2)
    String[] titulo2 = new String[] {"Error Absoluto", "pre desviacion"};
   
    dtm2.setColumnIdentifiers(titulo2);
    jTable2.setModel(dtm2);
}

/// metodo agregar dato 
   
    void agregar (){
    dtn1.addRow(new Object []{
    Datos.getText ()});
    dtn1.addRow(new Object []{
    Datos1.getText ()});
    dtn1.addRow(new Object []{
    Datos2.getText ()});
    dtn1.addRow(new Object []{
    Datos3.getText ()});
    dtn1.addRow(new Object []{
    Datos4.getText ()});
    dtn1.addRow(new Object []{
    Datos5.getText ()});
    dtn1.addRow(new Object []{
    Datos7.getText ()});
    dtn1.addRow(new Object []{
    Datos8.getText ()});
    dtn1.addRow(new Object []{
    Datos9.getText ()});
    dtn1.addRow(new Object []{
    Datos10.getText ()});
    dtn1.addRow(new Object []{
    Datos11.getText ()});
    dtn1.addRow(new Object []{
    Datos12.getText ()});
    dtn1.addRow(new Object []{
    Datos13.getText ()});
    dtn1.addRow(new Object []{
    Datos14.getText ()});
    dtn1.addRow(new Object []{
    Datos15.getText ()});
   
    }

   

    // eliminar fila 
    

    
    // actualiza toda la fila
    
   
    
    void limpiar_tabla (){
    int filas = dtn1.getRowCount();
   
    for (int i =0;i<filas;i++){
    dtn1.removeRow (0);
    }
    
    }
    void limpiar_tabla2(){
    int filas = dtm2.getRowCount();
    for (int i =0;i<filas;i++){
    dtm2.removeRow (0);
    }
      jTextField4.setText ("");
    Moda.setText ("");
    Mediana.setText ("");
    jTextField1.setText ("");
     jTextField2.setText ("");
    
    }
   
// Esto ya es en base a los videos de Tona
//  los conceptos es que promedio es 
// del conjunto con n elementos
// suma del valor de los elementos / nümero de elemtos
    
 private void calcularPromedio() {
    int rowCount = dtn1.getRowCount();
    double sum = 0.00; 
    for (int i = 0; i < rowCount; i++) {
        Object value = dtn1.getValueAt(i, 0); 
        if (value instanceof String) {
            try {
                double valor = Double.parseDouble((String) value); 
                sum += valor;
            } catch (NumberFormatException ex) {
                // Manejo de excepción si el valor no es un número válido
            }
        }
    }

    if (rowCount > 0) {
        double promedio = sum / rowCount; 
        jTextField4.setText(String.format("%.5f", promedio)); 
    } else {
        jTextField4.setText("0.00"); // Si no hay filas, mostrar "0.00" en jTextField4
    }
}

 // la mediana es de todos los elemtos el que esta en medio, por lo tanto es un numero entero
 //en caso de que sean dos elemtos la mediana es flotante
    
 private void calcularMediana() {
    int rowCount = dtn1.getRowCount();
    double[] valoresIde = new double[rowCount];

    for (int i = 0; i < rowCount; i++) {
        Object value = dtn1.getValueAt(i, 0); // Obtener valor en la columna "Ide"
        if (value instanceof String) {
            try {
                double ide = Double.parseDouble((String) value);
                valoresIde[i] = ide;
            } catch (NumberFormatException ex) {
                // Manejo de excepción si el valor no es un número válido
            }
        }
    }

    if (rowCount > 0) {
        // Ordenar los valores manualmente (algoritmo de selección)
        for (int i = 0; i < rowCount - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < rowCount; j++) {
                if (valoresIde[j] < valoresIde[minIndex]) {
                    minIndex = j;
                }
            }
            // Intercambiar valores
            double temp = valoresIde[i];
            valoresIde[i] = valoresIde[minIndex];
            valoresIde[minIndex] = temp;
        }

        double mediana;
        if (rowCount % 2 == 0) {
            // Si hay un número par de elementos, calcular el promedio de los dos elementos del medio
            double medio1 = valoresIde[rowCount / 2 - 1];
            double medio2 = valoresIde[rowCount / 2];
            mediana = (medio1 + medio2) / 2.0;
        } else {
            // Si hay un número impar de elementos, tomar el elemento del medio
            mediana = valoresIde[rowCount / 2];
        }

        Mediana.setText(String.format("%.5f", mediana)); // Mostrar la mediana en jTextField5
    } else {
        Mediana.setText("0.00"); // Si no hay filas, mostrar "0.00" en jTextField5
    }
}

 // Moda es el valor del conjunto que mas se repite sisisis
 // la mediana es de todos los elemtos el que esta en medio, por lo tanto es un numero entero
 //en caso de que sean dos elemtos la mediana es flotante
private void calcularModa() {
    int rowCount = dtn1.getRowCount();
    ArrayList<Double> valores = new ArrayList<>();

    for (int i = 0; i < rowCount; i++) {
        Object value = dtn1.getValueAt(i, 0);
        if (value instanceof String) {
            try {
                double numero = Double.parseDouble((String) value);
                valores.add(numero);
            } catch (NumberFormatException ex) {
                // Manejo de excepción si el valor no es un número válido
            }
        }
    }

    if (!valores.isEmpty()) {
        Map<Double, Integer> frecuencia = new HashMap<>();

        for (double numero : valores) {
            frecuencia.put(numero, frecuencia.getOrDefault(numero, 0) + 1);
        }

        double moda = -1;
        int maxFrecuencia = 0;

        for (Map.Entry<Double, Integer> entry : frecuencia.entrySet()) {
            double numero = entry.getKey();
            int frecuenciaActual = entry.getValue();
            if (frecuenciaActual > maxFrecuencia || (frecuenciaActual == maxFrecuencia && numero < moda)) {
                moda = numero;
                maxFrecuencia = frecuenciaActual;
            }
        } 
        if (maxFrecuencia >1){
 
            Moda.setText(String.format("%.5f", moda));
        } else {
            Moda.setText("Sin moda");     }}
}

   /// quick short Class 

private void ordenar_quickSort() {
    // Obtén los datos que deseas ordenar en un array (por ejemplo, valores de la tabla)
    int rowCount = dtn1.getRowCount();
    Object[] valores = new Object[rowCount];
    
    for (int i = 0; i < rowCount; i++) {
        Object value = dtn1.getValueAt(i, 0); // Obtener valor en la columna "Valores"
        if (value instanceof String) {
            try {
                double valor = Double.parseDouble((String) value); // Utilizar double para el valor
                valores[i] = valor;
            } catch (NumberFormatException ex) {
                // Manejo de excepción si el valor no es un número válido
            }
        }
    }
    
    // Llama a la función de QuickSort pasando el array y los índices izq y der adecuados
    int izq = 0;
    int der = valores.length - 1;
    quickSort.ordenar_quickSort(valores, izq, der);
    
    // Ahora que tienes el array "valores" ordenado, actualiza la columna 1 en tu tabla
    for (int i = 0; i < rowCount; i++) {
        // Actualiza el valor en la columna 1 con el valor ordenado
        dtn1.setValueAt(valores[i].toString(), i, 1); // Cambia "1" a la columna deseada
    }
}



//////shell

private void ordenar_shell() {
    // Obtén los datos que deseas ordenar en un array (por ejemplo, valores de la tabla)
    int rowCount = dtn1.getRowCount();
    Object[] valores = new Object[rowCount];
    
    for (int i = 0; i < rowCount; i++) {
        Object value = dtn1.getValueAt(i, 0); // Obtener valor en la columna "Valores"
        if (value instanceof String) {
            try {
                double valor = Double.parseDouble((String) value); // Utilizar double para el valor
                valores[i] = valor;
            } catch (NumberFormatException ex) {
                // Manejo de excepción si el valor no es un número válido
            }
        }
    }
    
   
    
    // Llama a la función de Shell pasando el array
    shellSort.ordenarShell(valores);
    
    // Ahora  el array  ordenado, actualiza la columna 1 en tu tabla
    for (int i = 0; i < rowCount; i++) {
        // Actualiza el valor en la columna 1 con el valor ordenado
        dtn1.setValueAt(valores[i].toString(), i, 2); 
    }
}




/// errror absoluto
private void calcularErrorAbsoluto() {


    int rowCount = dtn1.getRowCount();
    for (int i = 0; i < rowCount; i++) {
        Object valor1 = dtn1.getValueAt(i, 0);
        if (valor1 instanceof String) {
            try {
                double valorDato = Double.parseDouble((String) valor1);

                // Calcula el error absoluto (por ejemplo, con respecto al promedio)
                double promedio = Double.parseDouble(jTextField4.getText());
                double errorAbsoluto = (valorDato - promedio);

                // Agrega el valor del error absoluto a la segunda tabla en la columna 0
                dtm2.addRow(new Object[]{String.format("%.6f", errorAbsoluto)});
            } catch (NumberFormatException ex) {
                // Manejo de excepción si el valor no es un número válido
            }
    
        
    }
}
}



private void elevarerror() {
    int rowCount = dtm2.getRowCount();
    
    for (int i = 0; i < rowCount; i++) {
        Object value = dtm2.getValueAt(i, 0); // Obtén el valor de la columna 0
        if (value instanceof String) {
            try {
                double valor = Double.parseDouble((String) value);
                double valorCuadrado = valor * valor; // Eleva al cuadrado el valor
                
                // Actualiza el valor en la columna 1 con el valor al cuadrado
                dtm2.setValueAt(String.format("%.9f", valorCuadrado), i, 1);
            } catch (NumberFormatException ex) {
            }
        }
    }
}



/// desviacio
private void desviacion() {
   int rowCount = dtm2.getRowCount();
    double sum = 0.00; 
    for (int i = 0; i < rowCount; i++) {
        Object value = dtm2.getValueAt(i, 1); 
        if (value instanceof String) {
            try {
                double valor = Double.parseDouble((String) value); 
                sum += valor;
            } catch (NumberFormatException ex) {
                // Manejo de excepción si el valor no es un número válido
            }
        }
    }
double desv = sum / (rowCount-1);

    
   
    // Display the total absolute error
    jTextField1.setText(String.format("%.7f", desv));
}


private void valorAceptado() {
    String promedio = jTextField4.getText();
    String errorAbsoluto = jTextField1.getText();
    
    // Concatenate the values with the "+/-" sign
    String result = promedio + " ± " + errorAbsoluto;
    
    // Set the result as the text for jTextField2
    jTextField2.setText(result);
}


        
   
    /*
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        Promedio = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Datos = new javax.swing.JTextField();
        Datos1 = new javax.swing.JTextField();
        Datos2 = new javax.swing.JTextField();
        Datos3 = new javax.swing.JTextField();
        Datos4 = new javax.swing.JTextField();
        Datos5 = new javax.swing.JTextField();
        Datos7 = new javax.swing.JTextField();
        Datos8 = new javax.swing.JTextField();
        Datos9 = new javax.swing.JTextField();
        Datos10 = new javax.swing.JTextField();
        Datos11 = new javax.swing.JTextField();
        Datos12 = new javax.swing.JTextField();
        Datos13 = new javax.swing.JTextField();
        Datos14 = new javax.swing.JTextField();
        Datos15 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        Mediana = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        Moda = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 102, 255));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 102));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 204, 102), 5, true));

        jLabel2.setBackground(new java.awt.Color(255, 255, 0));
        jLabel2.setFont(new java.awt.Font("Stencil", 1, 35)); // NOI18N
        jLabel2.setText("\"Ordenamiento Shell y Quick Sort\"");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 720, 70));

        jPanel4.setBackground(new java.awt.Color(148, 165, 166));
        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jButton4.setBackground(new java.awt.Color(255, 0, 0));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("limpiar");
        jButton4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        Promedio.setBackground(new java.awt.Color(0, 153, 153));
        Promedio.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        Promedio.setForeground(new java.awt.Color(255, 255, 255));
        Promedio.setText("Calcular");
        Promedio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 153, 153), new java.awt.Color(0, 153, 153), new java.awt.Color(0, 102, 102), new java.awt.Color(0, 153, 153)));
        Promedio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PromedioMouseClicked(evt);
            }
        });
        Promedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PromedioActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("SWItalc", 1, 14)); // NOI18N
        jLabel1.setText("Datos");

        Datos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Datos.setText("19.36");
        Datos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DatosActionPerformed(evt);
            }
        });
        Datos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DatosKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                DatosKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                DatosKeyTyped(evt);
            }
        });

        Datos1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Datos1.setText("19.77");
        Datos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Datos1ActionPerformed(evt);
            }
        });
        Datos1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Datos1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Datos1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Datos1KeyTyped(evt);
            }
        });

        Datos2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Datos2.setText("19.98");
        Datos2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Datos2ActionPerformed(evt);
            }
        });
        Datos2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Datos2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Datos2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Datos2KeyTyped(evt);
            }
        });

        Datos3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Datos3.setText("19.95");
        Datos3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Datos3ActionPerformed(evt);
            }
        });
        Datos3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Datos3KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Datos3KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Datos3KeyTyped(evt);
            }
        });

        Datos4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Datos4.setText("19.40");
        Datos4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Datos4ActionPerformed(evt);
            }
        });
        Datos4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Datos4KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Datos4KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Datos4KeyTyped(evt);
            }
        });

        Datos5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Datos5.setText("19.85");
        Datos5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Datos5ActionPerformed(evt);
            }
        });
        Datos5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Datos5KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Datos5KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Datos5KeyTyped(evt);
            }
        });

        Datos7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Datos7.setText("19.78");
        Datos7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Datos7ActionPerformed(evt);
            }
        });
        Datos7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Datos7KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Datos7KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Datos7KeyTyped(evt);
            }
        });

        Datos8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Datos8.setText("19.40");
        Datos8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Datos8ActionPerformed(evt);
            }
        });
        Datos8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Datos8KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Datos8KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Datos8KeyTyped(evt);
            }
        });

        Datos9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Datos9.setText("19.85");
        Datos9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Datos9ActionPerformed(evt);
            }
        });
        Datos9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Datos9KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Datos9KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Datos9KeyTyped(evt);
            }
        });

        Datos10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Datos10.setText("19.56");
        Datos10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Datos10ActionPerformed(evt);
            }
        });
        Datos10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Datos10KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Datos10KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Datos10KeyTyped(evt);
            }
        });

        Datos11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Datos11.setText("19.66");
        Datos11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Datos11ActionPerformed(evt);
            }
        });
        Datos11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Datos11KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Datos11KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Datos11KeyTyped(evt);
            }
        });

        Datos12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Datos12.setText("19.53");
        Datos12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Datos12ActionPerformed(evt);
            }
        });
        Datos12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Datos12KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Datos12KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Datos12KeyTyped(evt);
            }
        });

        Datos13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Datos13.setText("19.85");
        Datos13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Datos13ActionPerformed(evt);
            }
        });
        Datos13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Datos13KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Datos13KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Datos13KeyTyped(evt);
            }
        });

        Datos14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Datos14.setText("19.72");
        Datos14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Datos14ActionPerformed(evt);
            }
        });
        Datos14.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Datos14KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Datos14KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Datos14KeyTyped(evt);
            }
        });

        Datos15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Datos15.setText("19.38");
        Datos15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Datos15ActionPerformed(evt);
            }
        });
        Datos15.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Datos15KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Datos15KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Datos15KeyTyped(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setText("Insertar Datos Personalizados");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Datos4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Datos3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Datos2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Datos1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Datos, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Datos9, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Datos8, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Datos7, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Datos5, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Datos10, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Datos11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Datos12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Datos13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Datos14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Datos15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Promedio, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(64, 64, 64))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Datos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Datos5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Datos11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Datos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Datos7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Datos12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Datos2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Datos8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Datos13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Datos3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Datos9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Datos14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Datos15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Datos10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Datos4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(Promedio, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addGap(32, 32, 32))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 720, 250));

        jPanel5.setBackground(new java.awt.Color(0, 51, 102));

        jPanel6.setBackground(new java.awt.Color(204, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jTable2.setBackground(new java.awt.Color(153, 255, 51));
        jTable2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        Moda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModaActionPerformed(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(102, 255, 153));
        jTable1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title1", "Title2", "Title3", "Title4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel3.setFont(new java.awt.Font("SWRomnt", 1, 12)); // NOI18N
        jLabel3.setText("MEDIANA;");

        jLabel4.setFont(new java.awt.Font("SWRomnt", 1, 12)); // NOI18N
        jLabel4.setText("PROMEDIO;");

        jLabel5.setFont(new java.awt.Font("SWRomnt", 1, 12)); // NOI18N
        jLabel5.setText("MODA:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("SWRomnt", 1, 12)); // NOI18N
        jLabel6.setText("DESVIACIÓN ESTANDAR:");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("SWRomnt", 1, 12)); // NOI18N
        jLabel7.setText(" VALOR ACEPTADO:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(Mediana, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Moda, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Mediana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Moda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 720, 330));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 697, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DatosActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_DatosActionPerformed

    private void PromedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PromedioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PromedioActionPerformed

    private void PromedioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PromedioMouseClicked

        // TODO add your handling code here:
        agregar ();
        calcularPromedio ();
        calcularErrorAbsoluto();
        calcularModa ();
        calcularMediana();
        elevarerror();
        desviacion();
        valorAceptado ();
        ordenar_quickSort ();
        ordenar_shell();
        

    }//GEN-LAST:event_PromedioMouseClicked

    private void ModaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModaActionPerformed
        // TODO add your handlinde here:
        calcularModa ();
    }//GEN-LAST:event_ModaActionPerformed

    private void DatosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DatosKeyPressed
        // TODO add your handling code here:
  
              
    }//GEN-LAST:event_DatosKeyPressed

    private void DatosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DatosKeyReleased
        // TODO add your handling code here:
          
    }//GEN-LAST:event_DatosKeyReleased

    private void DatosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DatosKeyTyped
  
    }//GEN-LAST:event_DatosKeyTyped

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked

        limpiar_tabla ();
        limpiar_tabla2();
    }//GEN-LAST:event_jButton4MouseClicked

    private void Datos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Datos1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Datos1ActionPerformed

    private void Datos1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Datos1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Datos1KeyPressed

    private void Datos1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Datos1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_Datos1KeyReleased

    private void Datos1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Datos1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_Datos1KeyTyped

    private void Datos2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Datos2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Datos2ActionPerformed

    private void Datos2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Datos2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Datos2KeyPressed

    private void Datos2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Datos2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_Datos2KeyReleased

    private void Datos2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Datos2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_Datos2KeyTyped

    private void Datos3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Datos3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Datos3ActionPerformed

    private void Datos3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Datos3KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Datos3KeyPressed

    private void Datos3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Datos3KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_Datos3KeyReleased

    private void Datos3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Datos3KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_Datos3KeyTyped

    private void Datos4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Datos4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Datos4ActionPerformed

    private void Datos4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Datos4KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Datos4KeyPressed

    private void Datos4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Datos4KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_Datos4KeyReleased

    private void Datos4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Datos4KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_Datos4KeyTyped

    private void Datos5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Datos5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Datos5ActionPerformed

    private void Datos5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Datos5KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Datos5KeyPressed

    private void Datos5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Datos5KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_Datos5KeyReleased

    private void Datos5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Datos5KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_Datos5KeyTyped

    private void Datos7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Datos7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Datos7ActionPerformed

    private void Datos7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Datos7KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Datos7KeyPressed

    private void Datos7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Datos7KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_Datos7KeyReleased

    private void Datos7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Datos7KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_Datos7KeyTyped

    private void Datos8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Datos8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Datos8ActionPerformed

    private void Datos8KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Datos8KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Datos8KeyPressed

    private void Datos8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Datos8KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_Datos8KeyReleased

    private void Datos8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Datos8KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_Datos8KeyTyped

    private void Datos9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Datos9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Datos9ActionPerformed

    private void Datos9KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Datos9KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Datos9KeyPressed

    private void Datos9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Datos9KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_Datos9KeyReleased

    private void Datos9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Datos9KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_Datos9KeyTyped

    private void Datos10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Datos10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Datos10ActionPerformed

    private void Datos10KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Datos10KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Datos10KeyPressed

    private void Datos10KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Datos10KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_Datos10KeyReleased

    private void Datos10KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Datos10KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_Datos10KeyTyped

    private void Datos11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Datos11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Datos11ActionPerformed

    private void Datos11KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Datos11KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Datos11KeyPressed

    private void Datos11KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Datos11KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_Datos11KeyReleased

    private void Datos11KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Datos11KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_Datos11KeyTyped

    private void Datos12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Datos12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Datos12ActionPerformed

    private void Datos12KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Datos12KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Datos12KeyPressed

    private void Datos12KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Datos12KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_Datos12KeyReleased

    private void Datos12KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Datos12KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_Datos12KeyTyped

    private void Datos13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Datos13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Datos13ActionPerformed

    private void Datos13KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Datos13KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Datos13KeyPressed

    private void Datos13KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Datos13KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_Datos13KeyReleased

    private void Datos13KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Datos13KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_Datos13KeyTyped

    private void Datos14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Datos14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Datos14ActionPerformed

    private void Datos14KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Datos14KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Datos14KeyPressed

    private void Datos14KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Datos14KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_Datos14KeyReleased

    private void Datos14KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Datos14KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_Datos14KeyTyped

    private void Datos15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Datos15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Datos15ActionPerformed

    private void Datos15KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Datos15KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Datos15KeyPressed

    private void Datos15KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Datos15KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_Datos15KeyReleased

    private void Datos15KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Datos15KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_Datos15KeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        Tabla  b = new Tabla();
        b.setVisible (true);
        dispose ();
    }//GEN-LAST:event_jButton2MouseClicked

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
            java.util.logging.Logger.getLogger(Tablademo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tablademo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tablademo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tablademo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tablademo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Datos;
    private javax.swing.JTextField Datos1;
    private javax.swing.JTextField Datos10;
    private javax.swing.JTextField Datos11;
    private javax.swing.JTextField Datos12;
    private javax.swing.JTextField Datos13;
    private javax.swing.JTextField Datos14;
    private javax.swing.JTextField Datos15;
    private javax.swing.JTextField Datos2;
    private javax.swing.JTextField Datos3;
    private javax.swing.JTextField Datos4;
    private javax.swing.JTextField Datos5;
    private javax.swing.JTextField Datos7;
    private javax.swing.JTextField Datos8;
    private javax.swing.JTextField Datos9;
    private javax.swing.JTextField Mediana;
    private javax.swing.JTextField Moda;
    private javax.swing.JButton Promedio;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
