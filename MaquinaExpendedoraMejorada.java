public class MaquinaExpendedoraMejorada {
    
    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    // Billetes vendidos
    private int billetesVendidos;
    // Tipo de m?quina
    private boolean tipoMaquina;
    // N?mero m?ximo de billetes
    private int numeroMaximoBilletes;
    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int maximoBilletes, boolean tipoDeLaMaquina, int precioDelBillete, String origen, String destino) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
        billetesVendidos = 0;
        tipoMaquina = tipoDeLaMaquina;
        numeroMaximoBilletes = maximoBilletes;
    }

    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }
    
    /**
     * Vac?a dinero m?quina
     */
    public int vaciarDineroDeLaMaquina() {
        int dineroMaquina;
        dineroMaquina = totalDineroAcumulado + balanceClienteActual;
        if (balanceClienteActual == 0) {
            totalDineroAcumulado = 0;
            balanceClienteActual = 0;    
        }
        else {
            System.out.println("No se puede vaciar el dep?sito de la m?quina, el cliente actual ya ha introducido dinero");
            dineroMaquina = -1;
        }
        return dineroMaquina;
    }
    
    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        if (billetesVendidos >= numeroMaximoBilletes) {
            System.out.println("N?mero m?ximo de billetes alcanzado.");
        }
        else {
            if (cantidadIntroducida > 0) {
            balanceClienteActual = balanceClienteActual + cantidadIntroducida;
            }
            else {
            System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
            }        
        }
    }
    
    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {
        int cantidadDeDineroQueFalta = precioBillete - balanceClienteActual;
        if (billetesVendidos >= numeroMaximoBilletes) {
            System.out.println("N?mero m?ximo de billetes alcanzado.");
        }
        else {
            if (cantidadDeDineroQueFalta <= 0) {        
                // Simula la impresion de un billete
                System.out.println("##################");
                System.out.println("# Billete de tren:");
                System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                System.out.println("# " + precioBillete + " euros.");
                System.out.println("##################");
                System.out.println();         
 
                // Actualiza el total de dinero acumulado en la maquina
                totalDineroAcumulado = totalDineroAcumulado + precioBillete;
                // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
                balanceClienteActual = balanceClienteActual - precioBillete;
                // Billete vendido + 1
                billetesVendidos = billetesVendidos + 1;
                if (tipoMaquina == false) {
                     if (billetesVendidos % 3 == 0) {
                     System.out.println("# Descuento de " + (0.10 * precioBillete) + " ? para compras en el comercio que tu elijas. ");
                    }
                }
            }
            else {
                System.out.println("Necesitas introducir " + (cantidadDeDineroQueFalta) + " euros mas!");
            } 
        }
    }
    
            /**
     * Contabiliza billetes vendidos
     */
    public int getNumeroBilletesVendidos() {
        return billetesVendidos;
    }
    
    /**
     * Imprime numero de billetes vendidos
     */
    public void imprimeNumeroBilletesVendidos() {
        System.out.println(billetesVendidos);
    }
    
    /**
     * Cancela la operacion de compra del cliente actual y le
     * devuelve al cliente el dinero que ha introducido hasta el momento
     */
    public int cancelarOperacionYDevolverDinero() {
        int cantidadDeDineroADevolver;
        cantidadDeDineroADevolver = balanceClienteActual;
        balanceClienteActual = 0;
        return cantidadDeDineroADevolver;
    } 
}
