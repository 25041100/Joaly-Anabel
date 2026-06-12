import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class LeerArchivo {
public static void main(String[] args) {
try {
BufferedReader fd=new BufferedReader(new FileReader("prograoo.txt"));
String linea = "";
while ((linea = fd.readLine()) != null) {
System.out.println(linea);
}
fd.close();
} catch (FileNotFoundException e) {
System.out.println("No pude abrir el archivo prograoo.txt");
} catch (IOException e) {
System.out.println("Error al leer");
}
}
}
