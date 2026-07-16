# Gandonia
Nombre del juego: Gandonia.
Integrante del proyecto: Mateo Falcón.

# Trama
Gandonia sitúa al jugador en la piel de Dalkion, un joven rey de 17 años que debe asumir de forma imprevista el trono tras la repentina muerte de su padre, Balixos II "el Grande", considerado el mejor gobernante de la dinastía Gandas. Sin la preparación adecuada y con el peso de un legado gigante sobre sus hombros, el joven monarca se encuentra casi completamente solo ante una tarea titánica: mantener la paz y defender las fronteras de su reino.
Para lograrlo, Dalkion tendrá que lidiar con una nobleza desconfiada y oportunista en la que cualquiera puede pasar de aliado a enemigo en un abrir y cerrar de ojos. Al mismo tiempo, deberá conseguir alianzas con los reyes y duques vecinos para garantizar la seguridad del reino ante los inminentes ataques de las tribus bárbaras del norte. En este camino lleno de intrigas políticas, el joven rey solo podrá apoyarse sobre sus tres personas de máxima confianza: su maestro de esgrima, Lord Farlas; su leal cocinero real, Jan; y su amigo y consejero más cercano, Edon.

# Jugabilidad
La jugabilidad de Gandonia propone una experiencia de simulación y estrategia política en dos dimensiones que se desarrolla a lo largo de un ciclo cerrado de siete días. Toda la aventura se controla de forma directa con el mouse, alternando la dinámica de la partida entre dos escenarios principales. En primer lugar, la fase del Salón del Trono pone al jugador frente a las distintas audiencias del día, donde súbditos, nobles y consejeros presentan sus peticiones. Cada decisión tomada a través del sistema de botones interactivos altera de forma inmediata las reservas de oro, comida y soldados del reino, así como el porcentaje de legitimidad del monarca. El jugador debe mantener un equilibrio constante con estas variables, ya que si la legitimidad cae por debajo del veinticinco por ciento, el pueblo se rebela y se produce una derrota instantánea.
Una vez resueltas las peticiones de la jornada, el rey se traslada al Cuarto Real, un espacio donde se darán varias opciones al jugador. Desde este lugar, el jugador puede elegir dormir para pasar al día siguiente o interactuar con el menú de guardado y carga de partidas. El flujo de juego continúa con este ritmo diario hasta alcanzar el séptimo día, momento en el que se define el destino de Gandonia en una tensa audiencia diplomática con un monarca extranjero. Conseguir la alianza clave para salvar al reino o caer ante la invasión de los bárbaros del norte será la consecuencia directa de cómo se hayan administrado los recursos y las relaciones políticas durante toda la semana.

# Tecnologías utilizadas
Para el desarrollo de este proyecto se usarán las siguientes tecnologías: el lenguaje Java en su versión 8 update 471, el framework LibGDX en su versión 1.14.2, la herramienta de configuración GDX Liftoff en su versión 1.14.2 y a futuro se implementará una base de datos relacional con SQLite en su versión 3.53.3. 
La plataforma objetivo es escritorio, mediante la librería lwjgl3.



# Requisitos Previos
Para compilar y ejecutar este proyecto, asegúrese de tener instalado lo siguiente en su sistema:

JDK (Java Development Kit): Debe tener instalado el JDK 8 o una versión superior compatible.
GIT: Para poder clonar el repositorio.

# Cómo compilar y ejecutar el juego
Pasos a seguir:
## 1. Clonar el repositorio 
```
git clone (https://github.com/Mateo-Falcon/Gandonia-proyecto-final)
cd Gandonia-proyecto-final
```
## 2. Compilar el proyecto con el wrapper de Gradle incluido en LibGDX
Windows
```
gradlew.bat build
```

Linux/MacOS
```
./gradlew build
```

## 3. Ejecutar el juego
Windows
```
gradlew.bat lwjgl3:run
```
Linux/MacOS
```
./gradlew lwjgl3:run
```

# Enlace a la Wiki
Para ver la propuesta completa haz clic [AQUÍ](https://github.com/Mateo-Falcon/Gandonia-proyecto-final/wiki)
