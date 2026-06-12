import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Agenda {

    private static final String ARCHIVO = "agenda.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            String menu = """
                    === AGENDA DE CONTACTOS ===
                    1. Agregar Contacto
                    2. Mostrar Todos los Contactos
                    3. Salir
                    Elige una opción: """;

            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcion) {
                case 1:
                    agregarContacto();
                    break;
                case 2:
                    mostrarContactos();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "¡Hasta pronto!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
            }
        } while (opcion != 3);

        scanner.close();
    }

    // ==================== AGREGAR CONTACTO ====================
    private static void agregarContacto() {
        try (FileWriter fw = new FileWriter(ARCHIVO, true);
             PrintWriter pw = new PrintWriter(fw)) {

            String nombre = JOptionPane.showInputDialog("Nombre:");
            String direccion = JOptionPane.showInputDialog("Dirección:");
            String telefono = JOptionPane.showInputDialog("Teléfono:");
            String sexo = JOptionPane.showInputDialog("Sexo (M/F):");
            String ocupacion = JOptionPane.showInputDialog("Ocupación:");
            int edad = Integer.parseInt(JOptionPane.showInputDialog("Edad:"));

            pw.println(nombre + "|" + direccion + "|" + telefono + "|" + sexo + "|" + ocupacion + "|" + edad);

            JOptionPane.showMessageDialog(null, "Contacto guardado correctamente!");

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar: " + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: La edad debe ser un número");
        }
    }

    // ==================== MOSTRAR CONTACTOS ====================
    private static void mostrarContactos() {
        File archivo = new File(ARCHIVO);
        if (!archivo.exists()) {
            JOptionPane.showMessageDialog(null, "No hay contactos aún. Agrega algunos primero.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            StringBuilder contenido = new StringBuilder("=== CONTACTOS GUARDADOS ===\n\n");

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split("\\|");
                if (datos.length == 6) {
                    contenido.append("Nombre: ").append(datos[0]).append("\n")
                            .append("Dirección: ").append(datos[1]).append("\n")
                            .append("Teléfono: ").append(datos[2]).append("\n")
                            .append("Sexo: ").append(datos[3]).append("\n")
                            .append("Ocupación: ").append(datos[4]).append("\n")
                            .append("Edad: ").append(datos[5]).append("\n")
                            .append("-------------------------------\n\n");
                }
            }

            JOptionPane.showMessageDialog(null, contenido.toString());

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo: " + e.getMessage());
        }
    }
}

