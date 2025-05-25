package calculadorae;

public class Class_Shell {
   
    public void ordenarShell(Object[] A) {
        int n = A.length;
        
        int salto = n / 2; // Cambio de nombre a "salto"

        while (salto > 0) {
            for (int i = salto; i < n; i++) {
                Object temp = A[i];
                int j = i;

                while (j >= salto && ((Comparable<Object>) A[j - salto]).compareTo(temp) > 0) {
                    A[j] = A[j - salto];
                    j -= salto;
                }

                A[j] = temp;
            }

            salto /= 2; // Cambio de nombre a "salto"
        }
    }
}

