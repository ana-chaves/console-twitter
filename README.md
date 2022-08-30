## Necesidad:
Crear una aplicación semejante a Twitter, por línea de comandos.
Para esto, cada usuario, puede escribir sus propios post y seguir a otros usuarios.
Las opciones que vamos a tener son las de:
* Leer los mensajes propios : 
  * Ejemplo: NombreUsuario
* Escribir un mensaje:
  * Ejemplo: NombreUsuario -> hola que tal
* Seguir a un usuario:
  * Ejemplo: NombreUsuario follows NombreUsuario2
* Ver los mensajes de los usuarios que sigues:
  * Ejemplo: NombreUsuario wall
  
## Ejecución:

Para ejecutar hay que tener instalado Docker. https://docs.docker.com/desktop/mac/install/.

Una vez instalado, dar permisos al rundocker.sh con chmod +x rundocker.sh .
En la raíz del proyecto, ejecutar: ./runDocker.sh

## Realización de la prueba:
Para esta prueba, se ha utilizado como lenguaje de programación Java11, junto con Maven para la gestión de las dependencias necesarias.
Para los test, se ha añadido JUnit para su ejecución.

Para el almacenamiento de los datos que se van introduciendo, se ha creado un repository para cada objeto requerido. 
Se decide guardar todo en memoria, en un mapa para un acceso sencillo y rápido, aunque se podrían haber usado otras alternativas, como base de datos.

## Test de la aplicación:

Una vez arrancado, un camino de prueba sería:

Welcome!
Ana

Ana -> hola que tal!

Julia -> que ganas de finde

Julia -> o de más vacaciones!

Ana follows Julia

Ana wall

Ana - hola que tal!

Julia - que ganas de finde

Julia - o de más vacaciones!

Julia

que ganas de finde (1 minutes ago)

o de más vacaciones! (1 minutes ago)


Para salir de la ejecución, podemos escribir "exit"
