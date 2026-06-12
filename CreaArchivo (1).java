import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
public class CreaArchivo {
public static void main(String args[]) {

//Creación del Archivo
try {
FileOutputStream f= new FileOutputStream("prograoo.txt");
} catch (FileNotFoundException ex) {
System.out.println("Existe un error " + ex);
}
//Escritura en el archivo
String nombre, direccion, telefono;
FileWriter w;
try {
w = new FileWriter("prograoo.txt",true);
PrintWriter wr = new PrintWriter(w);
for (int x = 1; x <= 3; x++) {
nombre=(JOptionPane.showInputDialog("Nombre: "));
direccion=(JOptionPane.showInputDialog("Dirección: "));
telefono = (JOptionPane.showInputDialog("Teléfono: "));
wr.println(nombre+" "+ direccion+ " "+ telefono);
}
wr.close();
w.close();
} catch (IOException ex) {
System.out.println("Error " + ex);
}
}
}