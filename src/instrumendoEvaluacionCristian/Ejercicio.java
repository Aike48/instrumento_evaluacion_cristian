package instrumendoEvaluacionCristian;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Ejercicio {
	
	private ArrayList <String> prodNombre;
	private ArrayList <String> prodCant;
	
	public Ejercicio () {
		prodNombre = new ArrayList<>();
		prodCant = new ArrayList<>();
	}
	
	public void iniciar() {
        int opcion;
        do {
            opcion = mostrarMenu();
            switch (opcion) {
                case 1:
                    agregarProducto();
                    break;
                case 2:
                    buscarProdNombre();
                    break;
                case 3:
                	actuCantProd();
                    break;
                case 4:
                    eliminarProd();
                    break;
                case 5:
                    mostrarInventario();
                    break;
                    
                case 0:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                    break;
                    
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida, por favor ingrese nuevamente.");
                    break;
            }
        } while (opcion != 0);
    }
	
	private int mostrarMenu() {
        String menu = "===== Menú =====\n"
                + "Ingrese una opción: "
                + "1. Agregar productos\n"
                + "2. Buscar producto por nombre\n"
                + "3. Actualizar cantidad de producto\n"
                + "4. Eliminar producto\n"
                + "5. Mostrar inventario\n"
                + "0. Salir\n";
;
        String opcionStr = JOptionPane.showInputDialog(menu);
        return validarEntradaNumerica(opcionStr) ? Integer.parseInt(opcionStr) : -1;
    }

    private boolean validarEntradaNumerica(String entrada) {
        try {
            Integer.parseInt(entrada);
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada no válida, por favor ingrese un número.");
            return false;
        }
    }
    
    private void agregarProducto () {
    	String cantProd = JOptionPane.showInputDialog("Ingrese la cantidad de productos a registrar:");
        if (!validarEntradaNumerica(cantProd)) {
            return;
        }

        int cantProducts = Integer.parseInt(cantProd);
        for (int i = 0; i < cantProducts; i++) {
            String nombreProd = JOptionPane.showInputDialog("Ingrese el nombre del producto " + (i + 1) + ":");
            if (prodNombre.contains(nombreProd)) {
                JOptionPane.showMessageDialog(null, "El producto ya está registrado.");
                i--; // Para que se vuelva a pedir el nombre del profesor
            } else {
            	String cantidaProd = JOptionPane.showInputDialog("Ingrese la cantidad del producto " + nombreProd + ":");
                prodNombre.add(nombreProd);
                prodCant.add(cantidaProd); 
            }
            
        }

        JOptionPane.showMessageDialog(null, "Productos registrados exitosamente.");
    }
   
    
    private void buscarProdNombre () {
    	if (prodNombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay productos registrados.");
            return;
        }

        String nombreProducto = JOptionPane.showInputDialog("Ingrese el nombre del producto a consultar:");

        int indiceProd = prodNombre.indexOf(nombreProducto);
        if (indiceProd == -1) {
            JOptionPane.showMessageDialog(null, "El producto no está registrado.");
        } else {
            var cantidad = prodCant.get(indiceProd);
            JOptionPane.showMessageDialog(null, "Producto: " + nombreProducto + ", Cantidad " + cantidad );
        }
    }
    
    private void actuCantProd () {
    	if (prodNombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay productos registrados.");
            return;
        }

        String nombreProducto = JOptionPane.showInputDialog("Ingrese el nombre del producto del que desea actualizar la cantidad:");

        int indiceProd = prodNombre.indexOf(nombreProducto);
        if (indiceProd == -1) {
            JOptionPane.showMessageDialog(null, "El producto no está registrado.");
        } else {
        	String nuevaCant = JOptionPane.showInputDialog("Ingrese la nueva cantidad:");
        	prodCant.add(indiceProd, nuevaCant); 
            
        }
        JOptionPane.showMessageDialog(null, "Cantidad de producto actualizada exitosamente.");
    }

    private void eliminarProd () {
    	
    	if (prodNombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay productos registrados.");
            return;
        }

        String nombreProducto = JOptionPane.showInputDialog("Ingrese el nombre del producto del que desea eliminar:");

        int indiceProd = prodNombre.indexOf(nombreProducto);
        if (indiceProd == -1) {
            JOptionPane.showMessageDialog(null, "El producto no está registrado.");
        } else {
        	prodNombre.remove(indiceProd);
        	prodCant.remove(indiceProd);
        	JOptionPane.showMessageDialog(null, "producto eliminado exitosamente.");
        }
    }

    private void mostrarInventario () {
    	if (prodNombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay productos registrados.");
            return;
        }

        String resultado = "===== Lista de Productos =====\n";
        for (int i = 0; i < prodNombre.size(); i++) {
            resultado += "Producto: " + prodNombre.get(i) + "\n";
            resultado += "Cantidad:" + prodCant.get(i) + "\n";
            resultado += "\n";
        }
        JOptionPane.showMessageDialog(null, resultado);
    }

	public static void main(String[] args) {
		Ejercicio programa = new Ejercicio();
        programa.iniciar();
	}

}
