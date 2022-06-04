# Mutantes

Ayudar a magneta a identifica mutantes con el adn para poder luchar contra los X-Men.

## Comenzando 🚀

_Estas instrucciones te permitirán obtener una copia del proyecto en funcionamiento en tu máquina local para propósitos de desarrollo y pruebas._

Mira **Deployment** para conocer como desplegar el proyecto.


### Pre-requisitos 📋

para ejecutar el proyecto se requiere tener instalado java version 11
```
https://www.oracle.com/co/java/technologies/javase/jdk11-archive-downloads.html
```
Descargar e instalar, configurar la variable de entorno JAVA_HOME, aqui la gia para esto
```
https://www.pchardwarepro.com/como-configurar-java_home-en-windows-10/

Descargar apache maven. se uso version 4.0.0, es recomendable usar esta misma version.
```
https://maven.apache.org/download.cgi
```
Despues de esto, se debe configurar la variable MAVEN_HOME de forma similar a como se configuro la variable JAVA_HOME


### Instalación 🔧

Descargar e instalar Pre-requisitos

1 PASO: Colonar el proyecto o descargarlo en formato ZIP y descomprimirlo.

git clone https://github.com/nataly1191/Prueba_Mutantes.git

descargar y descomrpimir el proyecto y abrirlo en el editor de preferencia (Visual Studio, NetBeans, etc)


## Ejecutando las pruebas ⚙️

las pruebas unitarias se encuentran en la carpeta test, donde se podra ejecutar para validar exito, en una de las pruebas en teoria tiene el comportamiento deseado pero la respuesta que da la prueba no es, investigue y no encontre el error.

## Despliegue 📦

El proyecto se despliega en HEROKU ya que es una herramienta facil de maejar y se conecta muy bien con GITHUB para despliegues automaticos. Ademas es gratiuto y es bueno para pequeños proyectos.

## EndPoints en CLOUD

POST/mutant
https://mutantesprueba.herokuapp.com/mutant

Ejemplo del JSON:
{
  "adn": [
    "ATGCGA",
    "CAGTGC",
    "TTATGT",
    "AGAAGG",
    "CCCCTA",
    "TCACTG"
  ]
}

GET/stats
https://mutantesprueba.herokuapp.com/stats

En caso de no contr con la herramienta Postman se puede usar Insomnia para realizar pruebas de los endpoint.

## Construido con 🛠️

_Menciona las herramientas que utilizaste para crear tu proyecto_

* [Java]lenguaje de programación
* [Maven]Manejador de dependencias
* [H2]Base de datos dentro del proyecto

## Autores ✒️


* **Nataly Gómez Salazar** -  [nataly1191](https://github.com/nataly1191)
