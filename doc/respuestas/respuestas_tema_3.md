<!--
Posible prompt:
<prompt>
Tengo un cuestionario con preguntas sobre "Excepciones". Debes tener en cuenta que los conocimientos previos que tengo (y por tanto tus respuestas deben ser adaptadas), son:
- C/C++ sin orientación a objetos.
- Temas de Java previos: Clases y Objetos, Encapsulación.

Cada respuesta debe tener entre 2 - 4 párrafos de longitud (sin contar los trozos de código).

Por favor, escribe en impersonal las respuestas.

</prompt>
----
-->
# TEMA 3. Excepciones

## 1. Empecemos un tema sobre control de errores en lenguajes de programación, con algo básico. En C, donde no existen las excepciones, pongamos un ejemplo de una raíz que toma número flotante positivo. Queremos controlar el error si la función recibe un número negativo. El usuario debe ser informado pero desde fuera de la función `raiz` ¿Cómo indicamos ese error?. Enumera dos opciones diferentes de diseñar, poniendo un ejemplo de código de cada una.

En C, al no haber excepciones, el error debe devolverse como parte del flujo normal.
Opción A: Valor de retorno especial. La función devuelve un valor que no sea una raíz válida (como -1.0 o NaN).
Opción B: Paso por referencia (Punteros). La función devuelve un booleano para el éxito y usa un puntero para el resultado.
(Correcciones de clase)
Opción A
    float raiz (float num) {
      if (num < 0= {
        return -1.0;
      }
      return sqrt (num);
    }
    main ( ) {
      float num = leerDeTeclado ( );
      float resultado = raiz (num);
      if (resultado == -1.0) {
        println ("Error");
      } else {
        println ("La raiz es: %d", resultado);
      }
    }

Opción B
    float raiz (float num, int error) {
      if (num < 0) {
        *error = 1;
        return 0;
      } else 
        *error = 0;
        return sqrt (num);
    }
    main ( ) {
      int error = 0
      float num = leerDeTeclado ( )
      float resultado = raiz (num, & error);
      if (error != 0) {
        println ("Error ...");
      } else {
        println ("%d", resultado);
      }
    }

## 2. Brevemente ¿Qué es una **"excepción"**? ¿Con qué objetivo las usa un programador cuando implementa funciones o cuando las llama?

Es un evento anormal que ocurre durante la ejecución de un programa y que interrumpe el flujo normal de las instrucciones.
Objetivo: Separar el código de la "lógica de negocio" del código de "control de errores", permitiendo que el programa no se detenga bruscamente y pueda recuperarse.
(Correciones de clase)
Exepción, surge en situaciones atípicas, cuando implementamos nos permite indicar más claramente el error y cuando llamamos me facilita separar la lógica normal de la de reacción o manejo de la situación arranca.

## 3. Reescribe el mismo ejemplo de raiz, pero en Java, metiendo ese método en una clase `Calculadora` y llama a dicho método desde el método `main`, mostrando cómo se puede controlar desde fuera.

En este caso, la función raizdelega la responsabilidad del error al llamador.Si el número es negativo, "lanza" una excepción que el maindebe "capturar".
(Correcciones de clase)
    class Calculadora
      public static double raiz (double raiz) {
        if (num < 0.0) {
          throw new IllegalArgumentExepcion ("num negativo");
        } else {
          return Math.sqrt (num);
        }
      }
    class App {
      main ( ) {
        double num = leerTeclado ( );

        try {
        double resultado = Calculadora.raiz (num);
        System.out.println (resultado);
        } catch (IllegalArgumentExepcion e) {
          System.out.println ("El número es negativo, no te preocupes, nadie es perfecto");
        }
    }
    }    

## 4. ¿Qué es **"lanzar"** una excepción? ¿Qué es **"controlar"** o **"capturar"** una excepción? ¿Qué es que se **"propague"** una excepción? ¿Qué le va ocurriendo a las funciones en la pila de llamadas por donde se va propagando la excepción? ¿Las funciones que no la controlan se reanudan después de alguna forma? Explica con el mismo ejemplo anterior en Java de la raíz cuadrada.

Lanzar ( throw): Es el acto de crear un objeto excepción y entregarlo al sistema de ejecución.
Controlar/Capturar ( catch): Es interceptar la excepción para ejecutar un código de respuesta.
Propagar: Si un método no captura la excepción, esta "salta" al método que lo llamó.
En la pila de llamadas: Las funciones por donde pasa la excepción finalizan abruptamente (se sacan de la pila) y no se reanudarán a menos que haya un bloque catch.
(Correcciones de clase)
El error se propaga por la función 

## 5. ¿Qué ventajas tiene frente a C, la **"propagación natural"** de las excepciones a través de la pila (*stack*) de llamadas?

A diferencia de C, donde cada función intermedia debe comprobarse manualmente si la función anterior falló (mediante if), en Java la excepción viaja sola por la pila hasta encontrar un controlador. Esto limpia el código de comprobaciones constantes.

## 6. En orientación a objetos, ¿las excepciones suelen ser objetos? ¿Qué ventajas tiene esto en términos de encapsulación? ¿Podemos entonces crear excepciones personalizadas?

Sí, en Java las excepciones son objetos (hijas de Throwable).
Encapsulación: Permite agrupar información del error (tipo, mensaje, estado del programa) en una sola unidad.
Personalización: Sí, podemos crear nuestras propias clases (ej. EmptyException) heredando de ExceptionoRuntimeException.
(Correcciones de clase)


## 7. En relación con las ventajas de la encapsulación, comparando el ejemplo en C con Java. ¿Qué **información esencial** lleva cualquier **objeto excepción** que es muy útil tener cuando se llega a un manejador?

A diferencia de un simple código de error en C, un objeto excepción en Java suele llevarse a cabo:
Un mensaje descriptivo (String).
El Stack Trace: Una traza de todos los métodos que estaban activos en la pila en el momento del error.
(Correciones de clase)
Un mensaje (getMessage ( ))
La traza de la pila (getStackTrace, printStackTrace)
Opcionalmente, la causa, es otra excepción que es la verdadera causa

## 8. En Java, sobre el bloque **"try-catch"**, ¿se pueden tener más de un bloque `catch`? ¿cuántos bloques `catch` se ejecutan?

¿Se puede? Sí, un solo trypuede tener múltiples catchpara distintos tipos de error.
¿Cuántos se ejecutarán?  Solo uno (el primero que coincide con el tipo de excepción lanzada).

## 9. Si las excepciones producen rupturas en el código llamador, ¿cómo podemos garantizar que se ejecuta siempre finalmente un código necesario para cierre de ficheros, liberacion de recursos, antes de que continúe propagándose la excepción? Pon un ejemplo en Java con `finally`, tanto con `catch` como sin él.

El bloque finallyse ejecuta siempre, haya o no excepción.

## 10. En Java, el bloque `finally` puede ir sin `catch`? ¿Se ejecuta siempre tanto si ocurre como si no ocurre una excepción? ¿Y si hay un `return` en medio del `try`?

¿Puede ir sin atrapar? Sí, un bloque try-finallyes legal.
¿Se ejecuta siempre? Sí.
¿Y con un return?  Sí , incluso si hay un returnen el try, el código del finallyse ejecuta justo antes de que el método devuelva el control.

## 11. En Java, qué son las excepciones **"controladas"** y las **"no controladas"**? ¿Qué papel juega `RuntimeException`? Pon un ejemplo de excepciones típicas controladas y no controladas que incluso nosotros mismos podríamos usar. Haz dos listas con 3 o 4 ejemplos de situación donde se suele preferir una excepción controlada y donde se suele preferir una excepción no controlada.

Controladas ( Checked): El compilador te obliga a capturarlas o declararlas (ej. IOException).
No Controladas ( Unchecked): Heredan deRuntimeException.El compilador no obliga a gestionarlas (ej. NullPointerException, EmptyException).

## 12. ¿Qué es y para qué se usa `throws`? ¿Por qué es alternativa a capturar una excepción controlada?

throwsse usa en la firma del método para avisar que ese método puede lanzar una excepción y que no la va a capturar él mismo. Es la forma de delegar la responsabilidad al llamador.

## 13. Pon un ejemplo en Java de firma de método que incluya `throws`, de una función que abre un fichero pero que declara que no le interesa menejar la excepción de si el fichero no existe, sino que se propague hacia arriba. Eso sí, acuérdate del `finally`.

Aquí el método declara que no va a gestionar el error de "archivo no encontrado" ( throws), pero usa finallypara asegurar que el Scannerse cierre, pase lo que pase.

## 14. ¿Podemos poner en `throws` excepciones no controladas, como `RuntimeException`? ¿Debería el método llamador entonces poner `try-catch` en ese caso? ¿Qué sentido tendría?

¿Podemos? Sí, pero es opcional.
¿Debe el llamador poner try-catch? No es obligatorio.
¿Sentido? Sirve como documentación para que otros programadores sepan que ese error es posible.

## 15. ¿Cuándo se recomienda usar excepciones controladas, como `IOException`, y cuándo no controladas como `IllegalArgumentException`? ¿Existen en todos los lenguajes ambas opciones? En los que sólo existe una opción, ¿cuál es la más habitual?

Controladas: Cuando el error es una alternativa razonable del flujo (ej. datos inválidos de red).
No controlados: Para fallos que indican un "bug" o mal uso de la API (ej. NullPointerException).
En lenguajes como Python o C#, todas no son controladas . Java es de los pocos que mantiene la distinción.

## 16. ¿Tiene sentido lanzar excepciones dentro del `catch`? ¿Se puede relanzar la misma excepción capturada? ¿Cuándo tendría sentido hacer esto último? Pon ejemplos de ambos casos.

¿Tiene sentido? Sí, para "traducir" una excepción técnica a una de negocio.
Relanzar: Se puede hacer un throw e;para que el error siga subiendo después de haber hecho un registro o cierre parcial.
Excepciones encadenadas (Causa) Consiste en meter una excepción dentro de otra para no perder el contexto original.
En la pantalla, Java muestra la causa mediante la frase "Caused by: ..." en el seguimiento de la pila.
Este código muestra cómo "envolver" una excepción técnica en una más genérica o simplemente registrarla y dejar que siga su camino.
