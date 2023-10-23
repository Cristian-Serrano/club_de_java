package org.iesvdm.virtualthreads;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.concurrent.Executors;


//
//Paralelo/Parallel: T=Talk,W=Walk
//
// En un mismo instante hablo y camino
//      |
//      V
//T T T T T T T T
//W W W W W W W W
//
//
//
//Concurrente/Concurrent: T=Talk, D=Drink
//En un instante sólo puedo hablar o beber.
//      |
//      V
//T T T   T T   T
//      D     D
//
//
// Asincrono/Asyncronous
// rutinas no bloqueantes
//
// ¿Qué ocurre con el hilo cuando solicita una operación bloqueante remota o Entrada/Salida?
// No se bloquea, porporcionas:
// ** un callback pero conceptualmente es complejo.
// ** mejor proporcionas un promise con 3 estados: pending, resolved, rejected.
//

//Hitoria de los Hilos de Java
// Java 1 -> Threads
//
// Java 5 -> Executors -> Pool de Hilos/Threads
//
// Java 7 -> Fork/Join -> Para evitar deadlocks que se inducen en un Pool
//
// Java 8 -> parallel streams y CompletableFuture
//
// Java 21 -> Virtual Threads

public class VirtualThreadsTest {

    @Test
    void unmillondeVirtualThreads() {
        try (var executor = Executors
                .newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 1_000_000; i++) {
                //number ES UNA CLOSURE
                var number = i;
                executor.submit(() -> {
                    Thread.sleep(Duration.ofSeconds(1));
                    System.out.println(number);
                    return number;
                });
            }
        } // executor.close() is called implicitly, and waits
    }

}
