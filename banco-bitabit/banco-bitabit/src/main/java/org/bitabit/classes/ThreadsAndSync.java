package org.bitabit.classes;

import java.io.IOException;

public class ThreadsAndSync implements Runnable {
    int limite;
    final Cuenta cuenta;

    public ThreadsAndSync(int limite, Cuenta cuenta) {
        this.limite = limite;
        this.cuenta = cuenta;
    }

    @Override
    public void run() {
        System.out.println("start new thread límite: " + this.limite);
        for(int i=0;i<limite;i++) {

            int saldo = cuenta.getSaldo();
            int saldoAsumar = saldo + 1;
            System.out.println("saldo: " + saldo + " - Saldo a sumar: " + saldoAsumar );

            new Deposito(saldoAsumar,cuenta);

            System.out.println(i + " - " + this.limite + " - Saldo cuenta: " + cuenta.getSaldo());
        }
    }

}
