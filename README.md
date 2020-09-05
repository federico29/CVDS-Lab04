## Escuela Colombiana de Ingeniería

### CVDS-Lab04


### Nombres:
- Federico Barrios Meneses
- Ricardo Amaya Rivera

### Desarrollo Dirigido por Pruebas + DIP + DI + Contenedores Livianos
### Parte I

1. Clone el proyecto (no lo descargue!).
   
2. A partir del código existente, implemente sólo los cascarones del
   modelo antes indicado.

3. Haga la especificación de los métodos calculateScore (de las tres variantes de GameScore), a partir de las especificaciones generales dadas anteriormente. Recuerde tener en cuenta: @pre, @pos, @param, @throws.
	- OriginalScore:
	```java
		/**
	     * Calculo del puntaje: puntaje entre [0,100] inicia en 100, letras correctas no bonifican e incorrectas quitan 10 puntos
	     * @param numero de letras correctas
	     * @param numero de letras incorrectas
	     * @return puntaje calculado en base a los parámetros
	     */
		public int calculateScore(int correctCount, int incorrectCount)
	```
	- BonusScore:
	```java
		/**
	     * Calculo del puntaje: puntaje entre [0,..) inicia en 0, letras correctas suman 10 puntos e incorrectas quitan 5 puntos
	     * @param numero de letras correctas
	     * @param numero de letras incorrectas
	     * @return puntaje calculado en base a los parámetros
	     */
		public int calculateScore(int correctCount, int incorrectCount)
	```
	- PowerBonusScore:
	```java
		/**
	     * Calculo del puntaje: puntaje entre [0,500] inicia en 0, letras correctas suman 5^i puntos e incorrectas quitan 8 puntos
	     * @param numero de letras correctas
	     * @param numero de letras incorrectas
	     * @return puntaje calculado en base a los parámetros
	     */
		@Override
		public int calculateScore(int correctCount, int incorrectCount)
	```
4. Haga commit de lo realizado hasta ahora. Desde la terminal:

	```bash		
	git add .			
	git commit -m "especificación métodos"
	```

5. Actualice el archivo `pom.xml` e incluya las dependencias para la ultima versión de JUnit y la versión del compilador de Java a la versión 8 .
	- Dependencia JUnit:
   ```xml
	   <dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.13</version>
			<scope>test</scope>
		</dependency>
   ```
   - Compilador de java:
   ```xml
	   <properties>
	       <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
	       <maven.compiler.source>1.8</maven.compiler.source>
	       <maven.compiler.target>1.8</maven.compiler.target>
	   </properties>
   ```
   

6. Teniendo en cuenta dichas especificaciones, en la clase donde se implementarán las pruebas (GameScoreTest), en los comentarios iniciales, especifique las clases de equivalencia para las tres variantes de GameScore, e identifique condiciones de frontera. 
	- OriginalScore:
	
	| Número| Clase de equivalencia | Resultado|
	| :---       |     ---     |   ---   |
	| 1|  ```0<=score && score<=100```|Correcto|
	| 2| ```(score%10)!=0 && score<0 && 100<score```|Incorrecto|
	| 3| ```score==-10, score==0, score==10```|Frontera Inferior|
	| 4| ```score==90, score==100, score>100```|Frontera Superior|

	- BonusScore:

	| Número| Clase de equivalencia | Resultado|
	| :---       |     ---     |   ---   |
	| 1|  ```0<=score```|Correcto|
	| 2| ```(score%5)!=0 && score<0```|Incorrecto|
	| 3| ```score==-5, score==0, score==5```|Frontera Inferior|

	- PowerBonusScore:
	
	| Número| Clase de equivalencia | Resultado|
	| :---       |     ---     |   ---   |
	| 1|  ```0<=score<=500```|Correcto|
	| 2| ```score==-8, score==0, score==5```|Frontera Inferior|
	| 3| ```score==155, score==500, score==780```|Frontera Superior|
8. Para cada clase de equivalencia y condición de frontera, implemente
   una prueba utilizando JUnit.
   Dirigirse a: ```src\test\java\hangman.GameScoreTest.java```

9. Haga commit de lo realizado hasta ahora. Desde la terminal:

	```bash		
	git add .			
	git commit -m "implementación pruebas"
	```
10. Realice la implementación de los 'cascarones' realizados anteriormente.
   Asegúrese que todas las pruebas unitarias creadas en los puntos anteriores
   se ejecutan satisfactoriamente.
   ![Pruebas](img/pruebas.png)

11. Al finalizar haga un nuevo commit:

	```bash		
	git add .			
	git commit -m "implementación del modelo"
	```

12¿1. Para sincronizar el avance en el respositorio y NO PERDER el trabajo, use
    el comando de GIT para enviar los cambios:

```bash	
	git push <URL Repositorio>	
```


### Parte II

Actualmente se utiliza el patrón FactoryMethod
que desacopla la creación de los objetos para diseñar un juego
de ahorcado (revisar createGUIUsingFactoryMethod en SwingProject, el
constructor de la clase GUI y HangmanFactoryMethod).

En este taller se va a utilizar un contenedor liviano ([GoogleGuice](https://github.com/google/guice)) el cual soporta la inyección de las dependencias.

1. Utilizando el HangmanFactoryMethod (MétodoFabrica) incluya el
   OriginalScore a la configuración.

Incorpore el Contenedor Liviano Guice dentro del proyecto:

* Revise las dependencias necesarias en el pom.xml.
* Modifique la inyección de dependencias utilizando guice en lugar del
  método fábrica..
* Configure la aplicación de manera que desde el programa SwingProject
  NO SE CONSTRUYA el Score directamente, sino a través de Guice, asi
  mismo como las otras dependencias que se están inyectando mediante
  la fabrica.
* Mediante la configuración de la Inyección de
  Dependencias se pueda cambiar el comportamiento del mismo, por
  ejemplo:
	* Utilizar el esquema OriginalScore.
	* Utilizar el esquema BonusScore.
	* Utilizar el idioma francés.
    * Utilizar el diccionario francés.
	* etc...