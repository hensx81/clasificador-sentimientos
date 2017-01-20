*****************************************************************************
* Realizado por: Henry Pilco, Paul Pulgar y Jos� Romero.
*			Escuela Politecnica Nacional
*
* Contact: Henry Pilco, hennry.pilco@epn.edu.ec
*          Paul Pulgar, paul.pulgar@epn.edu.ec
*	   Jos� Romero, jose.romero03@epn.edu.ec
*****************************************************************************

                            Archivo Readme

Esta carpeta contiene opiniones de clientes de 5 productos.

	1. digital camera: Canon G3
	2. digital camera: Nikon coolpix 4300
	3. celluar phone:  Nokia 6610
	4. mp3 player:     Creative Labs Nomad Jukebox Zen Xtra 40GB
	5. dvd player:     Apex AD2600 Progressive-scan DVD player

Todas las opiniones fueron tomadas de Amazon.com. Las mismas que fueron usadas
como un conjunto de entrenamiento para crear nuestro clasificador de sentimientos.

S�mbolos usados en las opiniones:

  [t]: T�tulo de la opini�n: Cada tag [t] empieza una opini�n.

Proceso seguido.
1. El punto de partida fue obtener opiniones de productos que nos puedan servir para crear nuestro set de entrenamiento.
   Despu�s de tener los archivos con opiniones, procedimos a limpiar la informaci�n, obteniento los t�tulos de las opiniones que fueron
   los que nos sirvieron como insumo para crear el conjunto de entrenamiento. Por ejemplo:
	1 incredibe price / performance .
	2 doesnt play new disney movies .
	3 poor quality - problem with dual-layer dvd 's .
	4 has destroyed several of my dvds and cds .
	5 their customer service sucks .
2. Una vez que tuvimos las opiniones a evaluar, procedimos a clasificarlas segun nuestro criterio en: pos (positiva), neu (neutral), neg (negativa).
	1 incredibe price / performance . pos
	2 Works fine . pos
	3 poor quality - problem with dual-layer dvd 's . neg
	4 Nice product, bad sound . neu
	5 their customer service sucks . neg
3. A continuaci�n procedimos a obtener los atributos que nos permitan clasificar las opiniones. Los atributos que para nuestro criterio fueron:
	1. adjetivosP {Excellent, Good, Best, Glad, Cool, Great, Perfect, Pleased, Happy, Fantastic, Incredible, Better, Nice, Null}
	   Este atributo nos permite determinar si existe alguno de los adjetivos positivos descritos, se encuentra en la opini�n.
	2. adjetivosN {Bad, Ugly, Sad, Sucks, Awful, Creepy, Defective, Erratic, Ambiguos, Lonely, Terrible, Worst, Frustrating, Null}
	   Este atributo nos permite determinar si existe alguno de los adjetivos negativos descritos, se encuentra en la opini�n.
	3. emocionesP {Joy, Interest, Serenity, Hope, Gratitude, Kindness, Surprise, Confidence, Satisfaction, Ok, Noproblem, Null}
	   Este atributo nos permite determinar si existe alguno de las emociones positivas descritas, se encuentra en la opini�n.
	4. emocionesN {Abusive, Agressive, Angry, Annoyed, Arrogant, Bored, Confused, Frustrated, Unhappy, Not, Poor, Problem, Destroyed, Crap, Null}
	   Este atributo nos permite determinar si existe alguna de las emociones negativas descritas, se encuentra en la opini�n.
	5. sentimiento {pos, neg, neu}
	   Este atributo determina la clasificaci�n de la opini�n.
4. Despu�s de determinar los atributos y la clase, procedimos a generar el conjunto de datos de entrenamiento. sentimientos_train.arff
5. A continuaci�n utilizamos la herramienta Weka para ejecutar nuestro modelo y validar su precisi�n.
	Al utilizar el algoritmo de clasificaci�n NaiveBayes y validaci�n cruzada con un conjunto de 20 instancias se obtuvo los siguientes resultados.

Correctly Classified Instances          13               65      %
Incorrectly Classified Instances         7               35      %
Kappa statistic                          0
Mean absolute error                      0.1861
Root mean squared error                  0.3342
Relative absolute error                 53.2806 %
Root relative squared error             80.5989 %
Total Number of Instances               20

=== Detailed Accuracy By Class ===

TP Rate   FP Rate   Precision   Recall  F-Measure   Class
  0         0          0         0         0        pos
  1         1          0.65      1         0.788    neg
  0         0          0         0         0        neu
	Duplicamos las instancias y validamos los resultados.

Correctly Classified Instances          36               90      %
Incorrectly Classified Instances         4               10      %
Kappa statistic                          0.7714
Mean absolute error                      0.121
Root mean squared error                  0.2439
Relative absolute error                 36.1277 %
Root relative squared error             60.1201 %
Total Number of Instances               40

=== Detailed Accuracy By Class ===

TP Rate   FP Rate   Precision   Recall  F-Measure   Class
  0.833     0          1         0.833     0.909    pos
  1         0.286      0.867     1         0.929    neg
  0         0          0         0         0        neu

Al utilizar el algoritmo de clasificaci�n de arboles J48 se ve los resultados.

Correctly Classified Instances          34               85      %
Incorrectly Classified Instances         6               15      %
Kappa statistic                          0.6429
Mean absolute error                      0.1229
Root mean squared error                  0.2795
Relative absolute error                 36.6956 %
Root relative squared error             68.911  %
Total Number of Instances               40

=== Detailed Accuracy By Class ===

TP Rate   FP Rate   Precision   Recall  F-Measure   Class
  0.667     0          1         0.667     0.8      pos
  1         0.429      0.813     1         0.897    neg
  0         0          0         0         0        neu

Si ejecutamos el proceso anterios pero como dato Folds = 40 se obtiene:
NaiveBayes


Correctly Classified Instances          36               90      %
Incorrectly Classified Instances         4               10      %
Kappa statistic                          0.7714
Mean absolute error                      0.12
Root mean squared error                  0.2395
Relative absolute error                 35.3379 %
Root relative squared error             58.1304 %
Total Number of Instances               40

=== Detailed Accuracy By Class ===

TP Rate   FP Rate   Precision   Recall  F-Measure   Class
  0.833     0          1         0.833     0.909    pos
  1         0.286      0.867     1         0.929    neg
  0         0          0         0         0        neu

J48


Correctly Classified Instances          36               90      %
Incorrectly Classified Instances         4               10      %
Kappa statistic                          0.7714
Mean absolute error                      0.0964
Root mean squared error                  0.2496
Relative absolute error                 28.374  %
Root relative squared error             60.5789 %
Total Number of Instances               40

=== Detailed Accuracy By Class ===

TP Rate   FP Rate   Precision   Recall  F-Measure   Class
  0.833     0          1         0.833     0.909    pos
  1         0.286      0.867     1         0.929    neg
  0         0          0         0         0        neu

Preguntas.

1. �Cu�ndo se alcanza la mejor precisi�n?
	La precisi�n va mejorando a medida que el n�mero de instancias del set de entrenamiento se acerca al n�mero de atributos multiplicado por 10.
2. �Es importante el n�mero de atributos (features) en el clasificador?
	Seg�n nuestras pruebas el clasificador mejor� mucho pasando de 2, 3 a 4 atributos para clasificar, y fue disminuyendo a medida que aumentamos m�s atributos.
3. �Es importante el n�mero de instancias?. �En qu� casos?
	El n�mero de instancias es importante ya que si son muy pocas, la precisi�n va a ser baja, si son muchas va a existir sobrecarga.
4. �Es importante considerar diferentes pesos para cada atributo? �por qu�?
  Es muy importante porque evita que la distribuci�n de probabilidad sea sesgada.
5. �Est� su modelo sobreajustado �overfitted�?
   Luego de duplicar el n�mero de instancias se observ� overfitted en nuestro modelo, esto por que el clasificador Naive Bayes es sensible a las caracter�sticas
   redundantes
6. �Los atributos cont�nuos son mejores o peores en el clasificador Naive Bayes?
	Son mejores.
7. Comparar los diferentes algoritmos con su conjunto de datos y determinar cu�l de ellos es el mejor.
	Despu�s de utilizar diferentes algoritmos determinamos que con el algoritmo VFI se encontr� una mejor precisi�n.

Correctly Classified Instances          40              100      %
Incorrectly Classified Instances         0                0      %
Kappa statistic                          1
Mean absolute error                      0.0198
Root mean squared error                  0.0937
Relative absolute error                  5.8143 %
Root relative squared error             22.7359 %
Total Number of Instances               40

=== Detailed Accuracy By Class ===

TP Rate   FP Rate   Precision   Recall  F-Measure   Class
  1         0          1         1         1        pos
  1         0          1         1         1        neg
  1         0          1         1         1        neu

8. �Es mejor utilizar validaci�n cruzada (cross-validation) o un test dataset para realizar la evaluaci�n
del clasificardor? �Por qu�?
