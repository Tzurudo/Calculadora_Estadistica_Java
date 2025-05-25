    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package calculadorae;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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

public class Tabla extends javax.swing.JFrame {
 DefaultTableModel dtn1 = new DefaultTableModel();
 /// añadimos  los metodos de ordenamiento
   Class_QuickSort quickSort = new Class_QuickSort();
   Class_Shell shellSort = new Class_Shell();
      DefaultTableModel dtm2 = new DefaultTableModel();
    
  
  public Tabla() {
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
   
 void agregar() throws InterruptedException {
    
    String inputText = Datos.getText();
    
    // Utilizar una expresión regular para verificar si el inputText contiene solo números y un punto.
    if (inputText.matches("^[0-9.]+$")) {
        dtn1.addRow(new Object[]{inputText});
        Datos.setText(""); // Limpia el campo de entrada.
    } else {
        // Mostrar un mensaje de error o realizar otra acción si el input no es válido.
        Datos.setText("Entrada inválida");
      
      
    }
}


   

    // eliminar fila 
    
    void eliminar (){
    int fila = jTable1.getSelectedRow();
    dtn1.removeRow(fila);
    }
    
    // actualiza toda la fila
    
    void actualizar (){
       int fila = jTable1.getSelectedRow();     
    dtn1.setValueAt (Datos.getText (), fila, 0); 
   
    }
    
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
     jTextField2.setText ("");
      jTextField1.setText ("");
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
 
            Moda.setText(String.format("%.6f", moda));
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
                dtm2.addRow(new Object[]{String.format("%.8f", errorAbsoluto)});
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
    jTextField1.setText(String.format("%.6f", desv));
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
        jButton1 = new javax.swing.JButton();
        Promedio = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Datos = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
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
        jButton6 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));
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
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(24, 24, 24))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 720, 50));

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
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

        jButton1.setBackground(new java.awt.Color(0, 153, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("añadir");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setPreferredSize(new java.awt.Dimension(60, 15));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton1MouseReleased(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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

        jButton8.setBackground(new java.awt.Color(0, 0, 204));
        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("shell");
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton8MouseClicked(evt);
            }
        });
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(0, 0, 204));
        jButton5.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("quick sort");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("SWItalc", 1, 14)); // NOI18N
        jLabel1.setText("Datos");

        Datos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
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

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Eliminar");
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

        jButton3.setBackground(new java.awt.Color(51, 51, 51));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Actualizar");
        jButton3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Datos))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(Promedio, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)))
                .addGap(260, 260, 260))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Datos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Promedio, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(43, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(56, 56, 56))))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 720, 230));

        jPanel5.setBackground(new java.awt.Color(0, 51, 102));

        jPanel6.setBackground(new java.awt.Color(204, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jTable2.setBackground(new java.awt.Color(153, 255, 51));
        jTable2.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        Moda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModaActionPerformed(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(102, 255, 153));
        jTable1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
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
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(12, 12, 12))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(36, 36, 36))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(Mediana, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Moda, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(4, 4, 4))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jTextField4)))
                                .addGap(91, 91, 91))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jTextField1)
                                .addGap(95, 95, 95))
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(23, 23, 23))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jTextField2))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(64, 64, 64)))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Mediana)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Moda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2)
                .addGap(35, 35, 35))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(15, 15, 15))
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
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(33, 33, 33))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 720, 340));

        jButton6.setBackground(new java.awt.Color(204, 204, 204));
        jButton6.setText("Retirarse");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, -1, -1));

        jMenuBar1.setFont(new java.awt.Font("SWComp", 0, 14)); // NOI18N

        jMenu1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jMenuBar1.add(jMenu1);

        jMenu2.setText("////////////////////////////////////////////////////////////////////////////// *INSTRUCCIONES");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jMenuItem1.setText("inserta los datos uno por uno");
        jMenu2.add(jMenuItem1);

        jMenuItem2.setText("da click en calcular");
        jMenu2.add(jMenuItem2);

        jMenuItem3.setText("escoge el metodo de preferencia");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem4.setText("o los dos!!");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
           // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void DatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DatosActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_DatosActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
     try {
         // TODO add your handling code here:
         agregar ();
     } catch (InterruptedException ex) {
         Logger.getLogger(Tabla.class.getName()).log(Level.SEVERE, null, ex);
     }
        
        
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked

  limpiar_tabla ();
  limpiar_tabla2();
    }//GEN-LAST:event_jButton4MouseClicked

    private void PromedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PromedioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PromedioActionPerformed

    private void PromedioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PromedioMouseClicked

        // TODO add your handling code here:
        
        calcularPromedio ();
        calcularErrorAbsoluto();
        calcularModa ();
        calcularMediana();
        elevarerror();
        desviacion();
        valorAceptado ();

    }//GEN-LAST:event_PromedioMouseClicked

    private void ModaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModaActionPerformed
        // TODO add your handlinde here:
        calcularModa ();
    }//GEN-LAST:event_ModaActionPerformed

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        // TODO add your handling code here:
        ordenar_quickSort() ;
      
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseClicked
        // TODO add your handling code here:
       ordenar_shell();
    }//GEN-LAST:event_jButton8MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void DatosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DatosKeyPressed
        // TODO add your handling code here:
  
              
    }//GEN-LAST:event_DatosKeyPressed

    private void DatosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DatosKeyReleased
        // TODO add your handling code here:
          
    }//GEN-LAST:event_DatosKeyReleased

    private void DatosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DatosKeyTyped
char caracter = evt.getKeyChar();

if (caracter == '\n') {
    try {
        agregar();
    } catch (InterruptedException ex) {
        Logger.getLogger(Tabla.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    }//GEN-LAST:event_DatosKeyTyped

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton1MousePressed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        eliminar ();
         limpiar_tabla2 ();
          calcularPromedio ();
        calcularErrorAbsoluto();
        calcularModa ();
        calcularMediana();
        elevarerror();
        desviacion();
        valorAceptado ();
        ordenar_quickSort();
        ordenar_shell ();
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        actualizar ();
        limpiar_tabla2 ();
         calcularPromedio ();
        calcularErrorAbsoluto();
        calcularModa ();
        calcularMediana();
        elevarerror();
        desviacion();
        valorAceptado ();
          ordenar_quickSort();
        ordenar_shell ();
        
    }//GEN-LAST:event_jButton3MouseClicked

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseReleased

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        // TODO add your handling code here:
        Tablademo a = new Tablademo ();
        a.setVisible (true);
        dispose ();
        
        
    }//GEN-LAST:event_jButton6MouseClicked

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
            java.util.logging.Logger.getLogger(Tabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tabla().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Datos;
    private javax.swing.JTextField Mediana;
    private javax.swing.JTextField Moda;
    private javax.swing.JButton Promedio;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
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
