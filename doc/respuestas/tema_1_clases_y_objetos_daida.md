<!--
Posible prompt:
<prompt>
Tengo un cuestionario con preguntas sobre "Clases y Objetos". Debes tener en cuenta que los conocimientos previos que tengo (y por tanto tus respuestas deben ser adaptadas), son:
- C/C++ sin orientación a objetos.
- Temas de Java previos: ninguno.

Cada respuesta debe tener entre 2 - 4 párrafos de longitud (sin contar los trozos de código).

Por favor, escribe en impersonal las respuestas.

</prompt>
----
-->

# TEMA 1. Clases y objetos

## 1. ¿Cuáles son las cuatro características básicas de la programación orientada a objetos? Describe brevemente cada una

### Respuesta
La encapsulación consiste en agrupar datos y comportamientos relacionados dentro de una misma entidad, ocultando los detalles internos y exponiendo solo lo necesario. Esto permite reducir el acoplamiento y facilita el mantenimiento del código.

La abstracción permite modelar entidades del mundo real o conceptos complejos de forma simplificada, centrándose en los aspectos relevantes y omitiendo los innecesarios. Gracias a ella se trabaja con modelos conceptuales más claros.

La herencia posibilita crear nuevas clases a partir de otras ya existentes, reutilizando código y estableciendo relaciones jerárquicas. Esto evita duplicaciones y favorece la extensibilidad.

El polimorfismo permite que un mismo método tenga comportamientos distintos según el objeto que lo implemente. Esto se traduce en mayor flexibilidad y en código más genérico.

## 2. Cita cuatro lenguajes populares que permitan la programación orientada a objetos

### Respuesta
Java es uno de los lenguajes orientados a objetos más utilizados, especialmente en aplicaciones empresariales y educativas. Su modelo de clases es estricto y todo el código se organiza alrededor de ellas.

C++ permite la programación orientada a objetos junto con programación procedural. Introduce conceptos como clases, herencia y polimorfismo manteniendo compatibilidad con C.

Python soporta la orientación a objetos de forma flexible y dinámica, permitiendo definir clases y objetos de manera sencilla. Es muy usado en educación, ciencia de datos y desarrollo web.

C# es un lenguaje moderno orientado a objetos desarrollado por Microsoft, ampliamente utilizado en aplicaciones de escritorio, web y videojuegos.

## 3. Los paradigmas anteriores a la POO, ¿Qué es la **programación estructurada**? y, todavía mejor, ¿Qué es la **programación modular**?

### Respuesta
La programación estructurada se basa en dividir el programa en estructuras de control bien definidas como secuencias, selecciones y bucles. Evita el uso de saltos incontrolados y mejora la legibilidad del código.

La programación modular va un paso más allá y propone dividir el programa en módulos o funciones independientes. Cada módulo se encarga de una tarea concreta, facilitando el mantenimiento y la reutilización.

Ambos paradigmas buscan organizar mejor el código, aunque no modelan entidades con estado y comportamiento conjunto como hace la programación orientada a objetos.

## 4. ¿Qué tres elementos definen a un objeto en programación orientada a objetos?

### Respuesta
Un objeto se define por su identidad, que lo distingue de otros objetos incluso si tienen los mismos valores. Esta identidad es única durante su existencia.

También se define por su estado, representado por los valores de sus atributos en un momento determinado. El estado puede cambiar a lo largo del tiempo.

Finalmente, el objeto posee un comportamiento, que está formado por los métodos que puede ejecutar y que permiten interactuar con él.

## 5. ¿Qué es una clase? ¿Es lo mismo que un objeto? ¿Qué es una instancia? ¿Todos los lenguajes orientados a objetos manejan el concepto de clase?

### Respuesta
Una clase es una plantilla o molde que define los atributos y métodos que tendrán los objetos. Describe cómo serán y cómo se comportarán, pero no representa un elemento concreto.

Un objeto es una entidad concreta creada a partir de una clase. No es lo mismo que la clase, ya que contiene valores reales y existe en memoria.

Una instancia es precisamente ese objeto creado a partir de una clase. No todos los lenguajes orientados a objetos utilizan clases de forma estricta, aunque sí el concepto de objeto.

## 6. ¿Dónde se almacenan en memoria los objetos? ¿Es igual en todos los lenguajes? ¿Qué es la **recolección de basura**? 

### Respuesta
En Java, los objetos se almacenan dinámicamente en el heap, una zona de memoria gestionada por la máquina virtual. Las variables suelen almacenar referencias a dichos objetos.

No todos los lenguajes gestionan la memoria de la misma forma. En algunos, como C++, el programador es responsable de liberar la memoria.

La recolección de basura es un mecanismo automático que libera la memoria ocupada por objetos que ya no se utilizan, evitando fugas de memoria.

## 7. ¿Qué es un método? ¿Qué es la **sobrecarga de métodos**? 

### Respuesta
Un método es una función asociada a una clase u objeto que define un comportamiento. Puede acceder y modificar el estado del objeto.

La sobrecarga de métodos consiste en definir varios métodos con el mismo nombre pero diferentes parámetros. El compilador decide cuál usar según los argumentos.

Esto permite ofrecer comportamientos similares adaptados a distintas situaciones sin cambiar el nombre del método.

## 8. Ejemplo mínimo de clase en Java, que se llame Punto, con dos atributos, x e y, con un método que se llame `calculaDistanciaAOrigen`, que calcule la distancia a la posición 0,0. Por sencillez, los atributos deben tener visibilidad por defecto. Crea además un ejemplo de uso con una instancia y uso del método

### Respuesta
class Punto {
     double x;
     double y;


    double calculaDistanciaAOrigen() {
        return Math.sqrt(x * x + y * y);
    }
}


class PruebaPunto {
    public static void main(String[] args) {
        Punto p = new Punto();
        p.x = 3;
        p.y = 4;
        System.out.println(p.calculaDistanciaAOrigen());
    }
}
Este ejemplo muestra una clase simple con atributos y un método, así como la creación y uso de una instancia.

## 9. ¿Cuál es el punto de entrada en un programa en Java? ¿Qué es `static` y para qué vale? ¿Sólo se emplea para ese método `main`? ¿Para qué se combina con `final`?

### Respuesta
El punto de entrada de un programa en Java es el método public static void main(String[] args). Es el primer método que se ejecuta.

La palabra clave static indica que el método pertenece a la clase y no a una instancia concreta. No se usa únicamente en main.

Combinado con final, se impide que el método o atributo sea modificado o redefinido.

## 10. Intenta ejecutar un poco de Java de forma básica, con los comandos `javac` y `java`. ¿Cómo podemos compilar el programa y ejecutarlo desde linea de comandos? ¿Java es compilado? ¿Qué es la **máquina virtual**? ¿Qué es el *byte-code* y los ficheros `.class`?

### Respuesta
Un programa Java se compila con javac Archivo.java, generando un fichero .class. Para ejecutarlo se usa java NombreClase.

Java es un lenguaje compilado a byte-code, que no es código máquina sino intermedio. Este byte-code es interpretado por la máquina virtual de Java.

Esto permite que el mismo programa se ejecute en distintos sistemas sin recompilar.

## 11. En el código anterior de la clase `Punto` ¿Qué es `new`? ¿Qué es un **constructor**? Pon un ejemplo de constructor en una clase `Empleado` que tenga DNI, nombre y apellidos

### Respuesta
La palabra clave new se utiliza para crear un nuevo objeto en memoria a partir de una clase. Devuelve una referencia al objeto creado.

Un constructor es un método especial que se ejecuta al crear un objeto y sirve para inicializar sus atributos.

class Empleado {
    String dni;
    String nombre;
    String apellidos;


    Empleado(String dni, String nombre, String apellidos) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }
}

## 12. ¿Qué es la referencia `this`? ¿Se llama igual en todos los lenguajes? Pon un ejemplo del uso de `this` en la clase `Punto`

### Respuesta
La referencia this apunta al objeto actual que está ejecutando el método. Permite diferenciar entre atributos y parámetros con el mismo nombre.

No todos los lenguajes usan el mismo nombre, aunque el concepto es similar. En Java se utiliza this.

double calculaDistanciaAOrigen() {
    return Math.sqrt(this.x * this.x + this.y * this.y);
}

## 13. Añade ahora otro nuevo método que se llame `distanciaA`, que reciba un `Punto` como parámetro y calcule la distancia entre `this` y el punto proporcionado

### Respuesta
double distanciaA(Punto otro) {
    double dx = this.x - otro.x;
    double dy = this.y - otro.y;
    return Math.sqrt(dx * dx + dy * dy);
}

Este método calcula la distancia entre dos puntos utilizando sus coordenadas.

## 14. El paso del `Punto` como parámetro a un método, es **por copia** o **por referencia**, es decir, si se cambia el valor de algún atributo del punto pasado como parámetro, dichos cambios afectan al objeto fuera del método? ¿Qué ocurre si en vez de un `Punto`, se recibiese un entero (`int`) y dicho entero se modificase dentro de la función? 

### Respuesta
En Java, los objetos se pasan por copia de la referencia, no por referencia directa. Esto significa que ambos apuntan al mismo objeto.

Si se modifica el estado del objeto dentro del método, el cambio es visible fuera. Sin embargo, si se reasigna la referencia, no afecta al exterior.

En el caso de tipos primitivos como int, se pasa una copia del valor, por lo que los cambios no se reflejan fuera del método.

## 15. ¿Qué es el método `toString()` en Java? ¿Existe en otros lenguajes? Pon un ejemplo de `toString()` en la clase `Punto` en Java

### Respuesta
El método toString() devuelve una representación en texto del objeto. Existe en Java y en otros lenguajes con conceptos similares.

Se utiliza, por ejemplo, al imprimir un objeto por consola.

@Override
public String toString() {
    return "(" + x + ", " + y + ")";
}

## 16. Reflexiona: ¿una clase es como un `struct` en C? ¿Qué le falta al `struct` para ser como una clase y las variables de ese tipo ser instancias?

### Respuesta
Una clase se parece a un struct en C en cuanto a que ambos agrupan datos relacionados. Sin embargo, el struct no incluye comportamiento.

A un struct le faltan métodos, encapsulación y control de acceso. Tampoco existe el concepto de instancia con comportamiento asociado.

Por ello, una clase ofrece un modelo mucho más completo.

## 17. Quitemos un poco de magia a todo esto: ¿Como se podría “emular”, con `struct` en C, la clase `Punto`, con su función para calcular la distancia al origen? ¿Qué ha pasado con `this`?

### Respuesta
En C se podría definir un struct con las coordenadas y una función externa que reciba el struct como parámetro.

typedef struct {
    double x;
    double y;
} Punto;

double distanciaAOrigen(Punto p) {
    return sqrt(p.x * p.x + p.y * p.y);
}

En este caso, this se sustituye por el parámetro explícito que representa al punto sobre el que se opera.