<p>*****************************************************************************</p>
<ul>
<br>
Realizado por: Henry Pilco, Paul Pulgar y José Romero.<br/>
Escuela Politecnica Nacional
Contact:
Henry Pilco, hennry.pilco@epn.edu.ec
Paul Pulgar, paul.pulgar@epn.edu.ec
José Romero, jose.romero03@epn.edu.ec
<br />
<p>*****************************************************************************</p>
</ul>
Archivo Readme
<p>Esta carpeta contiene opiniones de clientes de 5 productos.</p>
1. digital camera: Canon G3 2. digital camera: Nikon coolpix 4300 3. celluar phone:  Nokia 6610 4. mp3 player:     Creative Labs Nomad Jukebox Zen Xtra 40GB 5. dvd player:     Apex <span class="caps">AD2600</span> Progressive-scan <span class="caps">DVD</span> player
<p>Todas las opiniones fueron tomadas de Amazon.com. Las mismas que fueron usadas<br />
como un conjunto de entrenamiento para crear nuestro clasificador de sentimientos.</p>
<p>Símbolos usados en las opiniones: </p>
[t]: Título de la opinión: Cada tag [t] empieza una opinión.
<p>Proceso seguido.<br />
1. El punto de partida fue obtener opiniones de productos que nos puedan servir para crear nuestro set de entrenamiento.<br />
   Después de tener los archivos con opiniones, procedimos a limpiar la información, obteniento los títulos de las opiniones que fueron<br />
   los que nos sirvieron como insumo para crear el conjunto de entrenamiento. Por ejemplo:<br />
	1 incredibe price / performance . <br />
	2 doesnt play new disney movies . <br />
	3 poor quality &#8211; problem with dual-layer dvd &#8216;s . <br />
	4 has destroyed several of my dvds and cds . <br />
	5 their customer service sucks . <br />
2. Una vez que tuvimos las opiniones a evaluar, procedimos a clasificarlas segun nuestro criterio en: pos (positiva), neu (neutral), neg (negativa).<br />
	1 incredibe price / performance . pos<br />
	2 Works fine . pos<br />
	3 poor quality &#8211; problem with dual-layer dvd &#8216;s . neg<br />
	4 Nice product, bad sound . neu<br />
	5 their customer service sucks . neg<br />
3. A continuación procedimos a obtener los atributos que nos permitan clasificar las opiniones. Los atributos que para nuestro criterio fueron:<br />
	1. adjetivosP {Excellent, Good, Best, Glad, Cool, Great, Perfect, Pleased, Happy, Fantastic, Incredible, Better, Nice, Null}<br />
	   Este atributo nos permite determinar si existe alguno de los adjetivos positivos descritos, se encuentra en la opinión.<br />
	2. adjetivosN {Bad, Ugly, Sad, Sucks, Awful, Creepy, Defective, Erratic, Ambiguos, Lonely, Terrible, Worst, Frustrating, Null}<br />
	   Este atributo nos permite determinar si existe alguno de los adjetivos negativos descritos, se encuentra en la opinión.<br />
	3. emocionesP {Joy, Interest, Serenity, Hope, Gratitude, Kindness, Surprise, Confidence, Satisfaction, Ok, Noproblem, Null} <br />
	   Este atributo nos permite determinar si existe alguno de las emociones positivas descritas, se encuentra en la opinión.<br />
	4. emocionesN {Abusive, Agressive, Angry, Annoyed, Arrogant, Bored, Confused, Frustrated, Unhappy, Not, Poor, Problem, Destroyed, Crap, Null}<br />
	   Este atributo nos permite determinar si existe alguna de las emociones negativas descritas, se encuentra en la opinión.<br />
	5. sentimiento {pos, neg, neu}<br />
	   Este atributo determina la clasificación de la opinión.<br />
4. Después de determinar los atributos y la clase, procedimos a generar el conjunto de datos de entrenamiento. sentimientos_train.arff<br />
5. A continuación utilizamos la herramienta Weka para ejecutar nuestro modelo y validar su precisión.<br />
	Al utilizar el algoritmo de clasificación NaiveBayes y validación cruzada con un conjunto de 20 instancias se obtuvo los siguientes resultados.</p>
<p>Correctly Classified Instances          13               65      %<br />
Incorrectly Classified Instances         7               35      %<br />
Kappa statistic                          0     <br />
Mean absolute error                      0.1861<br />
Root mean squared error                  0.3342<br />
Relative absolute error                 53.2806 %<br />
Root relative squared error             80.5989 %<br />
Total Number of Instances               20     </p>
<p>= Detailed Accuracy By Class =</p>
<p>TP Rate   FP Rate   Precision   Recall  F-Measure   Class<br />
  0         0          0         0         0        pos<br />
  1         1          0.65      1         0.788    neg<br />
  0         0          0         0         0        neu<br />
	Duplicamos las instancias y validamos los resultados.</p>
<p>Correctly Classified Instances          36               90      %<br />
Incorrectly Classified Instances         4               10      %<br />
Kappa statistic                          0.7714<br />
Mean absolute error                      0.121 <br />
Root mean squared error                  0.2439<br />
Relative absolute error                 36.1277 %<br />
Root relative squared error             60.1201 %<br />
Total Number of Instances               40     </p>
<p>= Detailed Accuracy By Class =</p>
<p>TP Rate   FP Rate   Precision   Recall  F-Measure   Class<br />
  0.833     0          1         0.833     0.909    pos<br />
  1         0.286      0.867     1         0.929    neg<br />
  0         0          0         0         0        neu</p>
<p>Al utilizar el algoritmo de clasificación de arboles <span class="caps">J48</span> se ve los resultados.</p>
<p>Correctly Classified Instances          34               85      %<br />
Incorrectly Classified Instances         6               15      %<br />
Kappa statistic                          0.6429<br />
Mean absolute error                      0.1229<br />
Root mean squared error                  0.2795<br />
Relative absolute error                 36.6956 %<br />
Root relative squared error             68.911  %<br />
Total Number of Instances               40     </p>
<p>= Detailed Accuracy By Class =</p>
<p>TP Rate   FP Rate   Precision   Recall  F-Measure   Class<br />
  0.667     0          1         0.667     0.8      pos<br />
  1         0.429      0.813     1         0.897    neg<br />
  0         0          0         0         0        neu</p>
<p>Si ejecutamos el proceso anterios pero como dato Folds = 40 se obtiene:<br />
NaiveBayes</p>
<p>Correctly Classified Instances          36               90      %<br />
Incorrectly Classified Instances         4               10      %<br />
Kappa statistic                          0.7714<br />
Mean absolute error                      0.12  <br />
Root mean squared error                  0.2395<br />
Relative absolute error                 35.3379 %<br />
Root relative squared error             58.1304 %<br />
Total Number of Instances               40     </p>
<p>= Detailed Accuracy By Class =</p>
<p>TP Rate   FP Rate   Precision   Recall  F-Measure   Class<br />
  0.833     0          1         0.833     0.909    pos<br />
  1         0.286      0.867     1         0.929    neg<br />
  0         0          0         0         0        neu</p>
<p><span class="caps">J48</span></p>
<p>Correctly Classified Instances          36               90      %<br />
Incorrectly Classified Instances         4               10      %<br />
Kappa statistic                          0.7714<br />
Mean absolute error                      0.0964<br />
Root mean squared error                  0.2496<br />
Relative absolute error                 28.374  %<br />
Root relative squared error             60.5789 %<br />
Total Number of Instances               40     </p>
<p>= Detailed Accuracy By Class =</p>
<p>TP Rate   FP Rate   Precision   Recall  F-Measure   Class<br />
  0.833     0          1         0.833     0.909    pos<br />
  1         0.286      0.867     1         0.929    neg<br />
  0         0          0         0         0        neu</p>
<p>Preguntas.</p>
<p>1. ¿Cuándo se alcanza la mejor precisión?<br />
	La precisión va mejorando a medida que el número de instancias del set de entrenamiento se acerca al número de atributos multiplicado por 10.<br />
2. ¿Es importante el número de atributos (features) en el clasificador?<br />
	Según nuestras pruebas el clasificador mejoró mucho pasando de 2, 3 a 4 atributos para clasificar, y fue disminuyendo a medida que aumentamos más atributos.<br />
3. ¿Es importante el número de instancias?. ¿En qué casos?<br />
	El número de instancias es importante ya que si son muy pocas, la precisión va a ser baja, si son muchas va a existir sobrecarga. <br />
4. ¿Es importante considerar diferentes pesos para cada atributo? ¿por qué?</p>
<p>5. ¿Está su modelo sobreajustado overfitted?</p>
<p>6. ¿Los atributos contínuos son mejores o peores en el clasificador Naive Bayes?<br />
	Son mejores.<br />
7. Comparar los diferentes algoritmos con su conjunto de datos y determinar cuál de ellos es el mejor.<br />
	Después de utilizar diferentes algoritmos determinamos que con el algoritmo <span class="caps">VFI</span> se encontró una mejor precisión.</p>
<p>Correctly Classified Instances          40              100      %<br />
Incorrectly Classified Instances         0                0      %<br />
Kappa statistic                          1     <br />
Mean absolute error                      0.0198<br />
Root mean squared error                  0.0937<br />
Relative absolute error                  5.8143 %<br />
Root relative squared error             22.7359 %<br />
Total Number of Instances               40     </p>
<p>= Detailed Accuracy By Class =</p>
<p>TP Rate   FP Rate   Precision   Recall  F-Measure   Class<br />
  1         0          1         1         1        pos<br />
  1         0          1         1         1        neg<br />
  1         0          1         1         1        neu</p>
<p>8. ¿Es mejor utilizar validación cruzada (cross-validation) o un test dataset para realizar la evaluación<br />
del clasificardor? ¿Por qué?</p>
