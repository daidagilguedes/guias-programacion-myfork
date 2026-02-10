<!--
Posible prompt:
<prompt>
Tengo un cuestionario con preguntas sobre "Encapsulación". Debes tener en cuenta que los conocimientos previos que tengo (y por tanto tus respuestas deben ser adaptadas), son:
- C/C++ sin orientación a objetos.
- Temas de Java previos: Clases y Objetos.

Cada respuesta debe tener entre 2 - 4 párrafos de longitud (sin contar los trozos de código).

Por favor, escribe en impersonal las respuestas.

</prompt>
----
-->
# TEMA 2. Encapsulación

## 1. En Programación Orientada a Objetos (POO), ¿Qué buscan la **encapsulación** y **la ocultación** de información? Enumera brevemente algunas ventajas de la ocultación de información.

La encapsulación busca agrupar en una misma entidad (la clase) tanto los datos como los comportamientos que operan sobre ellos. El objetivo principal es tratar al objeto como una unidad coherente, donde el estado interno se gestiona de forma autónoma, facilitando la organización del código y la reducción de dependencias externas.
La ocultación de información, por su parte, busca proteger el estado interno de un objeto prohibiendo el acceso directo a sus detalles de implementación. Se pretende que los componentes externos no conozcan cómo están almacenados los datos, sino que interactúen únicamente a través de mecanismos autorizados y controlados.
Entre las ventajas de la ocultación se pueden enumerar:
Facilidad de mantenimiento: Se puede modificar la estructura interna de una clase sin afectar a las otras partes del programa que la utilizan.
Reducción de errores: Al impedir el acceso directo a los datos, se evita que agentes externos asignen valores inconsistentes o inválidos.
Flexibilidad: Permite que el programador cambie la lógica interna (por ejemplo, optimizar un algoritmo) de forma transparente para el usuario de la clase.

## 2. ¿Qué se entiende por la **interfaz pública** de un objeto o clase en POO? Describe brevemente cómo se relaciona con la ocultación de información.

La interfaz pública se define como el conjunto de métodos y propiedades que una clase expone al exterior. Es, en esencia, la lista de servicios o mensajes que un objeto puede recibir y responder, constituyendo el único punto de contacto legal para el resto de los objetos del sistema.
Esta interfaz se relaciona directamente con la ocultación de información al actuar como una "capa protectora". Mientras que la ocultación mantiene los detalles complejos y sensibles en el ámbito privado, la interfaz pública ofrece una abstracción simplificada que permite usar el objeto sin necesidad de entender su funcionamiento interno.

## 3. Brevemente: ¿Por qué hay que ser conscientes y diseñar con cuidado la **interfaz pública** de una clase? ¿Es fácil cambiarla?

El diseño de la interfaz pública es crítico porque representa el contrato que la clase firma con el resto del mundo. Una vez que otros desarrolladores comienzan a utilizar los métodos públicos de una clase, cualquier modificación en ellos (como cambiar un nombre o un parámetro) provocará fallos en todo el software que dependa de dicha clase.
Por lo tanto, cambiar una interfaz pública no es una tarea sencilla ni recomendable. Requiere una coordinación extensa y puede implicar la refactorización de grandes volúmenes de código. Un diseño cuidadoso desde el inicio asegura que la clase sea estable y que su evolución no rompa la funcionalidad existente.

## 4. ¿Qué son las **invariantes de clase** y por qué la ocultación de información nos ayuda?

Las invariantes de clase son reglas lógicas o condiciones que deben cumplirse en todo momento para que un objeto se considere en un estado válido. Son restricciones que definen la integridad de los datos, como asegurar que el saldo de una cuenta bancaria nunca sea inferior a su límite de crédito.
La ocultación de información es la herramienta que permite proteger estas invariantes. Al marcar los atributos como privados, se obliga a que cualquier cambio pase por métodos públicos (como los setters), donde se puede programar lógica de validación que rechace cualquier intento de poner al objeto en un estado inconsistente.

## 5. Pon un ejemplo de una clase `Punto` en `Java`, con dos coordenadas, `x` e `y`, de tipo `double`, con un método `calcularDistanciaAOrigen`, y que haga uso de la ocultación de información. ¿Cuál es la interfaz pública de la clase `Punto`? ¿Qué significa `public` y `private`?

A continuación, se presenta el código de la clase solicitada aplicando los principios de ocultación:

  public class Punto {
      // Atributos privados: Ocultación de información
      private double x;
      private double y;

      // Constructor público
      public Punto(double x, double y) {
          this.x = x;
          this.y = y;
      }

      // Método público para calcular la distancia
      public double calcularDistanciaAOrigen() {
          return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
      }
  }

La interfaz pública de esta clase está compuesta por el constructor Punto(double x, double y) y el método calcularDistanciaAOrigen(). Respecto a los modificadores:
Public: Significa que el miembro es accesible desde cualquier otra clase o parte del programa.
Private: Indica que el acceso está restringido únicamente al código que se encuentra dentro de la propia clase.

## 6. En Java, ¿A quiénes se pueden aplicar los modificadores `public` o `private`?

En Java, estos modificadores de acceso se aplican principalmente a los miembros de una clase, lo que incluye tanto a las variables de instancia (atributos) como a los métodos. También es común aplicarlos a los constructores para controlar cómo se crean los objetos.
Adicionalmente, se pueden aplicar a las clases mismas (aunque con restricciones para las clases de nivel superior) y a las clases internas o anidadas. Su uso correcto permite definir niveles de visibilidad que estructuran la jerarquía y seguridad del código.

## 7. En POO, la visibilidad puede ser pública o privada, pero ¿existen más tipos de visibilidad? ¿Qué ocurre en Java? ¿Y en otros lenguajes?

Efectivamente, existen niveles intermedios de visibilidad. En Java, además de public y private, se cuenta con protected, que permite el acceso a subclases y clases del mismo paquete, y la visibilidad por defecto (package-private), que restringe el acceso únicamente a las clases dentro del mismo paquete.
En otros lenguajes, la gestión varía notablemente. En C++, por ejemplo, el funcionamiento es muy similar al de Java mediante etiquetas de bloque. En cambio, en lenguajes como Python, no existen modificadores de acceso estrictos forzados por el compilador; la visibilidad se gestiona mediante convenciones de nombres (como el uso de guiones bajos).

## 8. Responde: Los miembros de instancia privados de un objeto están ocultos para (a) otras clases o (b) otras instancias, aunque sean de la misma clase. Pon un ejemplo añadiendo un método `calcularDistanciaAPunto(Punto otro)` y explica la respuesta.

  public double calcularDistanciaAPunto(Punto otro) {
      // Es posible acceder a otro.x y otro.y porque estamos dentro de la clase Punto
      double diferenciaX = this.x - otro.x;
      double diferenciaY = this.y - otro.y;
      return Math.sqrt(diferenciaX * diferenciaX + diferenciaY * diferenciaY);
  }

Este código compila y funciona porque, aunque x e y sean privados, el código está escrito dentro de la clase Punto, lo que le otorga permiso para acceder a los miembros privados de cualquier objeto de tipo Punto.

## 9. ¿Qué son los métodos "getter" y "setter" en los lenguajes orientados a objetos?

Los métodos "getter" y "setter" son funciones públicas diseñadas para actuar como intermediarios entre el mundo exterior y los atributos privados de una clase. El "getter" se utiliza para recuperar el valor de un atributo, mientras que el "setter" permite modificarlo.
Su importancia radica en que permiten aplicar el principio de encapsulación de manera efectiva. En lugar de permitir que un dato se cambie libremente, el "setter" puede incluir lógica para validar que el nuevo valor sea correcto, protegiendo así la integridad del objeto.

## 10. Cuando nos referimos a que la ocultación de información mejora la "seguridad" del programa, ¿nos referimos a que no pueda ser "hackeado"?

No, en este contexto el término "seguridad" no se refiere a la ciberseguridad o protección contra ataques externos malintencionados. Se refiere a la robustez y fiabilidad del diseño del software.
Mejorar la seguridad significa reducir la probabilidad de que se produzcan errores lógicos durante la ejecución. Al ocultar la información, se asegura que los datos internos no sean manipulados de forma inesperada por otras partes del código, garantizando que el programa se comporte siempre de manera predecible.

## 11. ¿Qué diferencia hay entre **miembro de instancia** y **miembro de clase**? ¿Los miembros de clase también se pueden ocultar?

Un miembro de instancia (atributo o método) pertenece a cada objeto individualmente; cada vez que se crea una instancia, esta tiene su propia copia de dicho miembro. Por el contrario, un miembro de clase pertenece a la clase en su conjunto y es compartido por todas las instancias. Solo existe una única copia de los miembros de clase en memoria, independientemente de cuántos objetos se creen. Los miembros de clase también se pueden (y se deben) ocultar utilizando el modificador “private”. Al igual que con los miembros de instancia, esto asegura que el estado global compartido por la clase no sea manipulado de forma arbitraria desde el exterior, manteniendo el control sobre la lógica común del programa. 

## 12. Brevemente: ¿Tiene sentido que los constructores sean privados?

Sí, tiene mucho sentido en diversos escenarios de diseño de software. Un constructor privado impide que se puedan crear instancias de la clase desde fuera de ella misma mediante el operador “new”. Esta técnica es fundamental para implementar patrones de diseño como el Singleton (asegurar que solo exista una instancia de una clase) o para clases de utilidad que solo contienen métodos estáticos y constantes, donde no tendría sentido crear objetos. 

## 13. ¿Cómo se indican los **miembros de clase** en Java? Pon un ejemplo, en la clase `Punto` definida anteriormente, para que incluya miembros de clase que permitan saber cuáles son los valores `x` e `y` máximos que se han establecido en todos los puntos que se hayan creado hasta el momento.

En Java, los miembros de clase se indican utilizando la palabra clave "static". Para llevar el registro de los valores máximos de todos los puntos creados, el código se ampliaría de la siguiente manera:

  public class Punto {
      private double x;
      private double y;

      // Miembros de clase (estáticos) para rastrear máximos
      private static double maxX = Double.NEGATIVE_INFINITY;
      private static double maxY = Double.NEGATIVE_INFINITY;

      public Punto(double x, double y) {
          this.x = x;
          this.y = y;
          // Actualizamos los valores de clase cada vez que se crea un punto
          if (x > maxX) maxX = x;
          if (y > maxY) maxY = y;
      }

      public static double getMaxX() { return maxX; }
      public static double getMaxY() { return maxY; }
  }

## 14. Como sería un método factoría dentro de la clase `Punto` para construir un `Punto` a partir de dos coordenadas, pero que las redondee al entero más cercano. Escribe sólo el código del método, no toda la clase ¿Has usado `static`? 

Un método factoría es un método estático que devuelve una instancia de la clase. El código para este requerimiento sería:

  public static Punto crearPuntoRedondeado(double x, double y) {
      double xRedondeado = Math.round(x);
      double yRedondeado = Math.round(y);
      return new Punto(xRedondeado, yRedondeado);
  }

Sí, se ha usado static. Es obligatorio usarlo porque el método debe poder ejecutarse directamente desde la clase Punto para crear un objeto, sin que necesitemos tener ya un objeto creado previamente para llamarlo.

## 15. Cambia la implementación de `Punto`. En vez de dos `double`, emplea un array interno de dos posiciones, intentando no modificar la interfaz pública de la clase.

Si cambiamos la estructura interna de los datos, pero mantenemos los métodos públicos iguales, la interfaz no se ve afectada:

  public class Punto {
      // Nueva implementación interna: matriz de dos posiciones
      private double[] coordenadas = new double[2];

      public Punto(double x, double y) {
          this.coordenadas[0] = x;
          this.coordenadas[1] = y;
      }

      public double getX() { return coordenadas[0]; }
      public double getY() { return coordenadas[1]; }

      public double calcularDistanciaAOrigen() {
          return Math.sqrt(Math.pow(coordenadas[0], 2) + Math.pow(coordenadas[1], 2));
      }
  }

Este es el poder de la encapsulación: hemos cambiado totalmente cómo se guardan los datos, pero cualquier programa que usara getX() o calcularDistanciaAOrigen() seguirá funcionando sin enterarse del cambio.

## 16. Si un atributo va a tener un método "getter" y "setter" públicos, ¿no es mejor declararlo público? ¿Cuál es la convención más habitual sobre los atributos, que sean públicos o privados? ¿Tiene esto algo que ver con las "invariantes de clase"?

No es mejor declararlo público. Aunque existan getter y setter, mantener el atributo privado permite que la clase mantenga el control total sobre la variable. Por ejemplo, en el futuro se podría añadir una validación en el setter o registrar cada vez que alguien lee el dato, algo imposible si el atributo fuera público.
La convención más habitual y recomendada en POO es que los atributos sean siempre privados. Esto garantiza que las invariantes de clase no se rompan, ya que cualquier modificación debe pasar obligatoriamente por el filtro de los métodos de la clase.

## 17. ¿Qué significa que una clase sea **inmutable**? ¿qué es un método modificador? ¿Un método modificador es siempre un "setter"? ¿Tiene ventajas que una clase sea inmutable?

Una clase es inmutable cuando su estado (sus datos internos) no puede ser modificado después de que el objeto ha sido creado. Un ejemplo clásico en Java es la clase String.
Un método modificador es aquel que cambia el estado de un objeto (como un setter). No todos los modificadores son setters (por ejemplo, un método vaciarDeposito()). Las ventajas de la inmutabilidad incluyen la facilidad para compartir objetos entre distintas partes del programa sin miedo a cambios inesperados y una mayor seguridad en entornos con múltiples hilos de ejecución.

## 18. ¿Es recomendable incluir métodos "setter" siempre y como convención?

No es recomendable incluirlos por defecto. Solo se deben crear setters si realmente es necesario que el estado del objeto cambie durante su ciclo de vida. Siguiendo principios de diseño sólido, es preferible favorecer la inmutabilidad siempre que sea posible para evitar efectos secundarios y comportamientos impredecibles en el sistema.

## 19. ¿La clase `String` en Java es mutable o inmutable? ¿Qué ocurre al concatenar dos cadenas? ¿Qué debemos hacer si vamos a hacer una operación que implique concatenar muchas veces para construir paso a paso una cadena muy larga?

La clase String en Java es inmutable. Cuando se concatenan dos cadenas (por ejemplo, usando +), no se modifica ninguna de las originales, sino que se crea un objeto String completamente nuevo en memoria que contiene el resultado.
Si se van a realizar muchas concatenaciones seguidas (como construir una cadena muy larga en un bucle), esto es ineficiente. En esos casos, se debe utilizar la clase StringBuilder, que es mutable y permite modificar el contenido de forma mucho más rápida y eficiente.

## 20. En POO ¿Cómo se comparan objetos de una misma clase? ¿Por su contenido o por su identidad? ¿Qué es el método equals en Java? ¿Qué hace por defecto? ¿Cómo se deben comparar dos cadenas en Java? 

En POO, la comparación se puede hacer por identidad (si son exactamente el mismo objeto en memoria) o por contenido (si sus datos son iguales). En Java, el operador == compara la identidad.
El método equals() se utiliza para comparar el contenido. Por defecto, en la clase Object, equals() hace lo mismo que ==, por lo que cada clase debe "sobreescribirlo" para definir qué significa que dos objetos sean iguales. Para comparar dos cadenas en Java, siempre se debe usar cadena1.equals(cadena2).

## 21. ¿Qué son las clases "wrapper" en un lenguaje de programación orientado a objetos? ¿Cómo se hace? ¿Es un proceso automático? ¿Qué ventajas tienen? ¿Todos los lenguajes orientados a objetos tienen tipos primitivos y necesitan wrappers? 

Las clases "wrapper" (envoltorios) son clases que representan tipos de datos primitivos como si fueran objetos (ej: Integer para int, Double para double). En Java, este proceso es automático mediante el autoboxing y unboxing.
Su principal ventaja es que permiten usar tipos primitivos en estructuras que solo aceptan objetos, como las colecciones (ArrayList, HashMap). No todos los lenguajes los necesitan; en lenguajes como Ruby o Smalltalk, todo es ya un objeto de forma nativa.

## 22. ¿En POO qué es un **tipo de dato enumerado**? ¿En Java, un tipo de dato enumerado es una clase? ¿Qué ventajas tienen en términos de encapsulación los enumerados en Java?

Un tipo de dato incluido es aquel que viene integrado directamente en el lenguaje (tipos primitivos). En Java, un tipo incluido (primitivo) no es una clase, aunque tenga una clase wrapper asociada.
Los enumerados (enum) en Java tienen grandes ventajas para la encapsulación: limitan los valores posibles a un conjunto predefinido, lo que evita errores de lógica, y permiten añadir atributos y métodos propios, comportándose como clases robustas y seguras.

## 23. Crea un tipo enumerado en Java que se llame `Mes`, con doce posibles instancias y que además proporcione métodos para obtener cuántos días tiene ese mes, el ordinal de ese mes en el año (1-12), empleando atributos privados y constructores del tipo enumerado.

  public enum Mes {
      ENERO(31, 1), FEBRERO(28, 2), MARZO(31, 3), ABRIL(30, 4),
      MAYO(31, 5), JUNIO(30, 6), JULIO(31, 7), AGOSTO(31, 8),
      SEPTIEMBRE(30, 9), OCTUBRE(31, 10), NOVIEMBRE(30, 11), DICIEMBRE(31, 12);

      private final int dias;
      private final int ordinal;

      private Mes(int dias, int ordinal) {
          this.dias = dias;
          this.ordinal = ordinal;
      }

      public int getDias() { return dias; }
      public int getOrdinal() { return ordinal; }
  }

## 24. Añade a la clase `Mes` del ejercicio anterior cuatro métodos para devolver si ese mes tiene algunos días de invierno, primavera, verano u otoño, indicando con un booleano el hemisferio (norte o sur, parámetro `enHemisferioNorte`). Es decir: `esDePrimavera(boolean esHemisferioNorte)`, `esDeVerano(boolean esHemisferioNorte)`, `esDeOtoño(boolean esHemisferioNorte)`, `esDeInvierno(boolean esHemisferioNorte)`

  public boolean esDeVerano(boolean enHemisferioNorte) {
      if (enHemisferioNorte) {
          return (this == JUNIO || this == JULIO || this == AGOSTO);
      } else {
          return (this == DICIEMBRE || this == ENERO || this == FEBRERO);
      }
  }

  public boolean esDeInvierno(boolean enHemisferioNorte) {
      if (enHemisferioNorte) {
          return (this == DICIEMBRE || this == ENERO || this == FEBRERO);
      } else {
          return (this == JUNIO || this == JULIO || this == AGOSTO);
      }
  }
  // La lógica para Primavera y Otoño seguiría este mismo patrón de inversión.
