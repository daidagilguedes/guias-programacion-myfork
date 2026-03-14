<!--
Posible prompt:
<prompt>
Tengo un cuestionario con preguntas sobre "Composición". Debes tener en cuenta que los conocimientos previos que tengo (y por tanto tus respuestas deben ser adaptadas), son:
- C/C++ sin orientación a objetos.
- Temas de Java previos: Clases y Objetos, Encapsulación y Excepciones.

Cada respuesta debe tener entre 2 - 4 párrafos de longitud (sin contar los trozos de código).

Por favor, escribe en impersonal las respuestas.

</prompt>
----
-->
# Tema 4.1. Composición


## 1. En C, podemos crear estructuras mayores **componiendo** unas con otras, que suelen describirse como "A tiene-un/tiene-varios B". Pon un ejemplo, empleando `struct`, de una línea de puntos, donde puntos tienen dos coordenadas (`x` e `y`), y la línea esta hecha de dos puntos. Incluye una función para calcular la distancia entre puntos y otra para hallar la longitud de una línea.

En el lenguaje C, la composición se manifiesta cuando una estructura incluye como miembros a otras estructuras previamente definidas. Esta relación "tiene-un" permite construir tipos de datos complejos a partir de bloques más simples, facilitando la organización lógica de la memoria y el acceso a los datos mediante el operador de punto.
A continuación se muestra el ejemplo solicitado:

  do
  #include <stdio.h>
  #include <math.h>

  typedef struct {
      double x, y;
  } Punto;

  typedef struct {
      Punto p1;
      Punto p2;
  } Linea;

  double distancia(Punto a, Punto b) {
      return sqrt(pow(b.x - a.x, 2) + pow(b.y - a.y, 2));
  }

  double longitud(Linea l) {
      return distancia(l.p1, l.p2);
  }
  
La función distanciaopera puramente sobre la entidad Punto, mientras que longitudaprovecha la composición para delegar el cálculo en la función anterior, pasando como argumentos los miembros internos de la Linea.

## 2. Ahora transforma ese ejemplo a orientación a objetos con Java, para tener un primer ejemplo de **composición** en orientación a objetos. Crea una clase `Punto`, y una clase `Linea`. La clase `Punto` debe tener un método para calcular distancia a otro `Punto` y `Linea` debe tener un método para calcular su longitud. Gracias a la ocultación de información, supera a C, garantizando que los puntos sean inmutables, al igual que la línea, que una vez creada, no queremos que se modifique de qué a qué puntos va dicha línea.  

En Java, la composición se logra declarando atributos de una clase que son instancias de otra clase. Para garantizar la inmutabilidad y superar las deficiencias de C, se declaran los atributos como private(encapsulación) y final(impidiendo su reasignación tras el constructor), sin ofrecer métodos "setter" que modifican el estado.

Java
  public class Punto {
      private final double x;
      private final double y;

      public Punto(double x, double y) {
          this.x = x;
          this.y = y;
      }

      public double distancia(Punto otro) {
          return Math.sqrt(Math.pow(otro.x - this.x, 2) + Math.pow(otro.y - this.y, 2));
      }
  }

  public class Linea {
      private final Punto p1;
      private final Punto p2;

      public Linea(Punto p1, Punto p2) {
          this.p1 = p1;
          this.p2 = p2;
      }

      public double getLongitud() {
          return p1.distancia(p2);
      }
  }
Este diseño asegura que una Lineasiempre esté compuesta por dos objetos Puntoválidos desde su nacimiento y que estos no cambien durante la vida del objeto, protegiendo la integridad de los datos.

## 3. ¿Qué significa la **multiplicidad** en la composición? En el ejemplo anterior, ¿cuál es la multiplicidad entre `Linea` y `Punto`? Indícalo expresando la multiplicidad en ambas direcciones, de `Linea` a `Punto` y de `Punto` a `Linea`.

La multiplicidad define el número de instancias de una clase que pueden o deben estar asociadas con una instancia de otra clase. Se expresa habitualmente mediante rangos (como 1, 0..*, 1..n) y ayuda a definir las reglas de negocio de la estructura de datos.
En el ejemplo anterior, la multiplicidad se analiza así:
De Linea a Punto: La multiplicidad es 2 (exactamente dos), ya que una línea no existe sin sus dos extremos.
De Punto a Linea: La multiplicidad es 0.. * (de cero a muchos), dado que un punto en el espacio puede ser el extremo de ninguna, de una o de infinitas líneas.

## 4. ¿Qué significa composición **fuerte** y composición **débil**? ¿Qué consecuencia implica en relación al ciclo de vida de los objetos? Indica a cuál solemos referirnos como **"asociación o agregación"** y a cuál como **"composición"** propiamente.

La diferencia radica en el grado de acoplamiento y la gestión del ciclo de vida. En la composición fuerte (referida simplemente como Composición ), el contenido del objeto es parte esencial del contenedor y no tiene sentido fuera de él; si el contenedor se destruye, sus partes mueren con él.
En la composición débil (conocida como Agregación o Asociación ), los objetos tienen ciclos de vida independientes. El contenedor tiene una referencia al contenido del objeto, pero este puede existir antes de la creación del contenedor y sobrevivir a su destrucción, pudiendo incluso ser compartido por otros contenedores.

## 5. Cuando una clase usa a otra al recibirla o devolverla como parámetro en algún método, al hacer `new` dentro de un método, o al usarlas como variables locales, ¿hablamos de composición o de **"dependencia"**?

Cuando una clase utiliza a otra únicamente como parámetro de un método, como variable local o instanciándola momentáneamente con newdentro de un bloque, se habla de dependencia (o relación de uso).
A diferencia de la composición, la dependencia no implica que un objeto sea "dueño" o "tenga" al otro como parte de su estado permanente. Es una relación transitoria donde un cambio en la interfaz de la clase usada puede obligar a cambiar la clase dependiente, pero no hay un vínculo estructural persistente.

## 6. En el ejemplo anterior de línea y punto, programa la relación entre `Linea` y `Punto` de dos formas. Una **como composición fuerte**, donde el ciclo de vida de los puntos está ligado al de Linea y otra **como composición débil**, donde no.

En la composición fuerte , la clase Lineacrea sus propios puntos (copias defensivas o nuevas instancias), asegurando que nadie más tenga acceso a ellos. En la composición débil , la clase recibe las referencias y simplemente las almacena.

Java
  // Composición Fuerte: Linea es dueña total de sus puntos
  public class LineaFuerte {
      private final Punto p1, p2;
      public LineaFuerte(double x1, double y1, double x2, double y2) {
          this.p1 = new Punto(x1, y1); // La línea crea los puntos
          this.p2 = new Punto(x2, y2);
      }
  }

  // Composición Débil (Agregación): Linea apunta a puntos externos
  public class LineaDebil {
      private Punto p1, p2;
      public LineaDebil(Punto p1, Punto p2) {
          this.p1 = p1; // Solo guarda la referencia externa
          this.p2 = p2;
      }
  }

## 7. En Java, en la composición fuerte, ¿cuando el contenedor destruye los objetos? No se observa que `Linea` destruya los `Punto` explícitamente, ¿Por qué?

A diferencia de C o C++, en Java no existe una instrucción específica como freeo deletepara destruir objetos. La destrucción es gestionada de forma automática por el Recolector de Basura.
En una composición fuerte, cuando el objeto Lineadeja de ser alcanzable (por ejemplo, su variable venta de ámbito o se pone a null), las referencias internas a los objetos Puntotambién se pierden. Al quedar estos puntos sin ninguna referencia que los apunte, el Garbage Collector los identifica como memoria liberable y los elimina automáticamente.

## 8. Pon un ejemplo de composicion débil entre un departamento que tiene varios profesores. Implementa dos composiciones a la vez: entre el departamento y todos sus profesores y entre el departamento y su director, que es un profesor del departamento. Siempre debe haber un director en el departamento desde el inicio. Lanza excepciones si se viola la invariante. Emplea arrays primitivos de Java, estilo `Profesor[]`, con máximo 50, pero no rompas la encapsulación, no desveles que estás empleando un array, permite añadir un `Profesor` al final de la lista, y eliminar un profesor dada su posición. Da acceso a los profesores con un método para saber cuántos hay y otro para obtener un profesor por posición. El director se puede cambiar por otro profesor del departamento. Sin embargo, ten en cuenta esta invariante de clase: el director debe formar siempre parte de la lista de profesores, es decir, ten cuidado al cambiar el director o al eliminar un profesor.

Este ejemplo gestiona una lista de profesores y un director, manteniendo la invariante de que el director siempre debe estar en la lista.

Java
  public class Departamento {
      private Profesor[] profesores = new Profesor[50];
      private int numProfesores = 0;
      private Profesor director;

      public Departamento(Profesor director Inicial) {
          if (directorInicial == null) throw new IllegalArgumentException("Requiere director");
          this.director = directorInicial;
          addProfesor(directorInicial);
      }

      public void addProfesor(Profesor p) {
          if (numProfesores >= 50) throw new RuntimeException("Lleno");
          profesores[numProfesores++] = p;
      }

      public void eliminarProfesor(int pos) {
          if (pos < 0 || pos >= numProfesores) throw new IndexOutOfBoundsException();
          if (profesores[pos] == director) throw new IllegalStateException("No se puede eliminar al director");
        
          for (int i = pos; i < numProfesores - 1; i++) {
              profesores[i] = profesores[i+1];
          }
          profesores[--numProfesores] = null;
      }

      public void setDirector(Profesor nuevoDirector) {
          for (int i = 0; i < numProfesores; i++) {
              if (profesores[i] == nuevoDirector) {
                  this.director = nuevoDirector;
                  return;
              }
          }
          throw new IllegalArgumentException("El director debe ser del departamento");
      }

      public int getNumProfesores() { return numProfesores; }
      public Profesor getProfesor(int pos) { return profesores[pos]; }
  }

## 9. En Java, existen también `List`, cambia y muestra cómo sería el código anterior empleando `List` en vez de arrays primitivos. ¿Qué parte del código original te has ahorrado? Además, fíjate en el método `getProfesor(int pos)`: si en su lugar existiera un método que devolviera todos los profesores a la vez, ¿qué problema tendría devolver directamente la lista interna? ¿Cómo lo resolverías?

Al emplear ArrayList<Profesor>, se ahorra toda la lógica de gestión manual del array: el desplazamiento de elementos al borrar, el control del tamaño máximo (es dinámico) y el contador numProfesores.
Si se devolviera la lista interna mediante un return profesores;, se rompería la encapsulación , ya que cualquier clase externa podría agregar o borrar profesores (incluso al director) sin pasar por las reglas de validación del Departamento. Para resolverlo, se debe devolver una copia de la lista o, preferiblemente, una vista no modificable usando Collections.unmodifiableList(profesores).

## 10. Al igual que ocurre con las excepciones en Java, que pueden encerrar causas (que son excepciones), de forma recursiva, suponen un tipo especial de composiciones, denominadas composiciones recursivas. Pon un ejemplo en Java de una `Persona`, que sea inmutable, y que tiene una madre, que es otra `Persona`. Haz un main con un ejemplo de uso con una familia de personas, desde el nieto hasta la abuela. Enumera algún otro ejemplo clásico de composiciones recursivas.

Una composición es recursiva cuando una clase contiene un atributo de su propio tipo. Esto permite modelar estructuras jerárquicas o en cadena de profundidad arbitraria.

Java
  public class Persona {
      private final String nombre;
      private final Persona madre; // Composición recursiva

      public Persona(String nombre, Persona madre) {
          this.nombre = nombre;
          this.madre = madre;
      }

      public static void main(String[] args) {
          Persona abuela = new Persona("Ana", null);
          Persona madre = new Persona("Elena", abuela);
          Persona nieto = new Persona("Luis", madre);
      }
  }
  
Otros ejemplos clásicos incluyen los nodos de una lista enlazada (un nodo apunta a otro nodo) o los directorios de un sistema de archivos (un directorio puede contener otros directorios).

## 11. ¿Qué son las relaciones de composición "bidireccionales"? ¿Qué habría que hacer para implementar este tipo de relación en el ejemplo de `Profesor` y `Departamento`?

Las relaciones bidireccionales permiten que ambos objetos involucrados tengan una referencia al otro. En el caso de Profesory Departamento, esto significaría que el departamento conoce a sus profesores, pero cada profesor también sabe a qué departamento pertenece.
Para implementarlo, la clase Profesordebería tener un atributo private Departamento departamento. El mayor reto es mantener la consistencia : al agregar un profesor a un departamento, se debe actualizar simultáneamente el atributo departamento del profesor. Esto suele hacerse mediante métodos "ayudantes" que aseguran que ambas referencias se actualizarán en una sola operación atómica desde la lógica del programa.
