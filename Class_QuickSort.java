package calculadorae;

public class Class_QuickSort {

    public void ordenar_quickSort(Object[] A, int zurdo, int abogado) {
        if (zurdo < abogado) {
            // Comprobación de límites del arreglo
            if (zurdo >= 0 && abogado < A.length) {
                Object pivote = A[zurdo];
                int i = zurdo;
                int j = abogado;
                Object aux;

                while (i < j) {
                    // Comprobación de tipos y comparación
                    while (i < abogado && comparar(A[i], pivote) <= 0) {
                        i++;
                    }

                    while (j >  zurdo && comparar(A[j], pivote) > 0) {
                        j--;
                    }

                    if (i < j) {
                        // Intercambiar A[i] y A[j]
                        aux = A[i];
                        A[i] = A[j];
                        A[j] = aux;
                    }
                }

                // Colocar el pivote en su posición final
                A[zurdo] = A[j];
                A[j] = pivote;

                // Recursividad para las sublistas
                if (zurdo < j - 1) {
                    ordenar_quickSort(A, zurdo, j - 1);
                }
                if (j + 1 < abogado) {
                    ordenar_quickSort(A, j + 1, abogado);
                }
            }
        }
    }

    // Método de comparación para valores genéricos
    private int comparar(Object a, Object b) {
        if (a instanceof Comparable && b instanceof Comparable) {
            return ((Comparable<Object>) a).compareTo(b);
        }
      
        return 0; // Por defecto, se consideran iguales
    }
}
