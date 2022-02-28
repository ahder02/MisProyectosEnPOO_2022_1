package com.banco.dominio;

public class CuentaBancaria {
    // Atributos: No estoy actuando sobre propietario, numero de cuenta y tipo de cuenta

    public String propietario;
    public String numeroCuenta;
    public String tipoCuenta;
    public int saldoActual;
    public int claveActual;

    // Metodos

    public boolean verificarClave(int claveIngresada) { // metodo para verificacion de los demas metodos
                                                        // antes de operar sobre los demas atributos
        boolean estadoVerificacion;

        if (claveIngresada == claveActual) {
            estadoVerificacion = true;
        } else {
            estadoVerificacion = false;
        }
        return estadoVerificacion;
    }

    public void consignar(int nuevoSaldo) {
        saldoActual+=nuevoSaldo;
    }

    public String transferir(int saldoTransferir, int numeroCuentaTransferir) {
        String estadoTransferencia;

        if (saldoActual >= saldoTransferir){
            saldoActual-=saldoTransferir;
            numeroCuentaTransferir+=saldoTransferir; // Aclarar el envio porque se adiciona al otro numero de cuenta
                                                    // y comparo con retirar
            estadoTransferencia = "Su transferencia ha sido exitosa";
        } else {
            estadoTransferencia = "Su saldo es insuficiente";
        }
        return estadoTransferencia;
    }

    public void retirar(int saldoRetirar) {
        String estadoRetiro;

        if (saldoActual >= saldoRetirar){
            saldoActual-=saldoRetirar;
            estadoRetiro = "Retire su dinero";
        } else {
            estadoRetiro = "Su saldo es insuficiente";
        }
    }

    public String consultarSaldo() { // como retornar propietario, numero de cuenta, tipo y saldo????
        return "Su saldo es " + saldoActual;
    }

    public String cambiarClave(int claveIngresada, int nuevaClave) {
        String estadoClave;

        if (verificarClave(claveIngresada)) {
            claveActual = nuevaClave;
            estadoClave = "Su clave ha sido cambiada satisfactoriamente";
        } else {
            estadoClave = "La clave ingresada es incorrecta";
        }
        return estadoClave;
    }
}
