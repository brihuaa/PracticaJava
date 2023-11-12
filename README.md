<h1>Introducción</h1>

El juego que estamos desarrollando hasta ahora es un  arcade que combina la elección de razas con enfrentamientos contra enemigos aleatorios. Hasta el momento, hemos establecido la base del juego, permitiendo a los jugadores seleccionar entre seis razas únicas, cada una con sus propias características distintivas. Además, hemos implementado la capacidad del jugador para enfrentarse a enemigos cuyo nivel y estadísticas se generan aleatoriamente.

<h1>Desarrollo Actual</h1>

![PracticaProgramacion](https://github.com/AdrianComputerScience/PracticaJava/assets/123450151/51cabb9f-cd51-42ca-8b9f-54b369219ae4)


<h2>Clases Principales</h2>

Hemos creado las clases fundamentales del juego: Personaje y Raza. La clase Personaje maneja aspectos como vida, mana y estamina, y permite a los jugadores atacar y recibir ataques. Por otro lado, la clase Raza define las características específicas de cada raza, incluyendo bonificaciones para la vida, mana y estamina.

<h2>Selección de Raza</h2>

Implementamos la funcionalidad que permite a los jugadores elegir su raza al inicio del juego. Las razas incluyen Humanos, Elfos, Enanos, Orcos, Hadas y Gnomos, cada una con ventajas y desventajas únicas. Esto agrega un componente estratégico al juego, ya que los jugadores deben considerar cómo las características de su raza afectarán su estilo de juego.

<h2>Combate Básico</h2>

Establecimos una mecánica básica de combate donde el jugador puede atacar a enemigos generados aleatoriamente. La lógica de ataque se basa en el nivel del jugador y utiliza valores aleatorios para el daño infligido.

<h2>Desarrollo de Personaje</h2>
  
Cada raza influye directamente en las estadísticas del jugador, creando una experiencia de juego personalizada. Las decisiones del jugador al elegir su raza afectan su capacidad para enfrentarse a enemigos y superar desafíos.

<h2>Tabla de tipos de personajes y enemigos, con sus caracteristicas</h2>


Tipo                           | Salud                  | Mana             | Estamina         | Nivel    
-----------------------------   |------------------------|------------------|------------------|----------
Humanos                        | 100 + nivel * 10       | 50 + nivel * 5   | 50 + nivel * 5   | Dinámico 
Elfos                          | 100 + nivel * 7        | 80 + nivel * 10  | 60 + nivel * 5   | Dinámico 
Enanos                         | 120 + nivel * 12       | 30 + nivel * 3   | 70 + nivel * 7   | Dinámico 
Orcos                          | 90 + nivel * 8         | 40 + nivel * 4   | 80 + nivel * 8   | Dinámico 
Hadas                          | 80 + nivel * 6         | 120 + nivel * 15 | 50 + nivel * 5   | Dinámico 
Gnomos                         | 110 + nivel * 9        | 70 + nivel * 7   | 90 + nivel * 9   | Dinámico 

Tipo                           | Salud                  | Mana             | Estamina         | Nivel    
-------------------------------|------------------------|------------------|------------------|----------
Enemigos de nivel 1 al 10
Monstruos de las Sombras       | 50 + nivel * 5         | 20 + nivel * 2   | 30 + nivel * 3   | Dinámico 
Demonios Menores               | 60 + nivel * 6         | 25 + nivel * 2   | 25 + nivel * 2   | Dinámico 
Metamorfo Inestable            | 40 + nivel * 4         | 30 + nivel * 3   | 35 + nivel * 3   | Dinámico 
Enemigos de nivel 10 al 20
Criaturas Nocturnas Avanzadas  | 120 + nivel * 10       | 40 + nivel * 4   | 50 + nivel * 5   | Dinámico 
Demonios de las Llamas         | 150 + nivel * 10       | 50 + nivel * 5   | 40 + nivel * 4   | Dinámico 
Metamorfos Cambiantes          | 100 + nivel * 8        | 60 + nivel * 6   | 55 + nivel * 5   | Dinámico 
Enemigos de nivel 20 al 30
Bestias de la Oscuridad        | 200 + nivel * 10       | 70 + nivel * 7   | 60 + nivel * 6   | Dinámico 
Señores Demoníacos             | 250 + nivel * 10       | 80 + nivel * 8   | 70 + nivel * 7   | Dinámico 
Metamorfos Maestros            | 180 + nivel * 9        | 90 + nivel * 9   | 80 + nivel * 8   | Dinámico 
Enemigos de nivel 30 al 40
Pesadillas Vivientes           | 300 + nivel * 10       | 100 + nivel * 10 | 90 + nivel * 9   | Dinámico 
Archidemonios                  | 350 + nivel * 10       | 120 + nivel * 12 | 100 + nivel * 10 | Dinámico 
Metamorfos Épicos              | 280 + nivel * 10       | 130 + nivel * 13 | 110 + nivel * 11 | Dinámico 


<h1>Futuro Desarrollo</h1>
<h2>Mejoras en el Combate</h2>
  
Podemos expandir la mecánica de combate introduciendo habilidades especiales para cada raza. Esto agregaría capas adicionales de estrategia y variedad al juego. También podríamos incorporar un sistema de niveles más avanzado con habilidades desbloqueables a medida que los jugadores avanzan.

<h2>Sistema de Recompensas</h2>

Implementar un sistema de recompensas más robusto sería beneficioso. Esto incluiría la introducción de ítems específicos de la raza, como armas o armaduras, que los jugadores pueden adquirir al derrotar enemigos. Además, podríamos incluir misiones secundarias o eventos especiales que otorguen recompensas significativas.

<h2>Historia y Mundo del Juego</h2>
Podemos expandir el juego incorporando una narrativa más profunda y un mundo más desarrollado. Introducir una trama principal, personajes no jugadores (PNJ) y ubicaciones únicas podría sumergir a los jugadores en una experiencia más envolvente.

<h2>Interactividad del Jugador</h2>
Agregar opciones de diálogo, toma de decisiones y eventos basados en elecciones podría permitir que los jugadores influyan en el desarrollo de la historia y en sus propios destinos. Esto fomentaría la rejugabilidad y la conexión emocional con el juego.


<h1>Conclusión</h1>
Hasta ahora, hemos establecido los cimientos de un juego arcade. Sin embargo, hay un vasto potencial para expandir y mejorar la experiencia del jugador. Al centrarnos en mejorar la mecánica de combate, introducir recompensas atractivas, desarrollar la narrativa y aumentar la interactividad del jugador, podemos llevar nuestro juego a nuevas alturas.

El desarrollo futuro debe ser guiado por una combinación de la visión del juego y el feedback de los jugadores/compañeros. Con una planificación cuidadosa y la implementación de nuevas características.
