import weka.core.Instances;

import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.trees.J48;
import weka.classifiers.functions.SMO;
import weka.classifiers.lazy.IBk;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Aplicacion2 {
    public static void main(String[] args) {
		clasificador(); 
    }
	public static void clasificador(){
		
		BufferedReader reader1;
		BufferedReader reader2;
		try {
			reader1 = new BufferedReader(
					//new FileReader("/home/paul/Temp/ProyectoFinal/sentimientos_train.arff"));
					new FileReader("/home/paul/Temp/ProyectoFinal/sen_train.arff"));
			//reader1 = new BufferedReader(
			//		new FileReader("/home/paul/BI/Clasificador/JavaProg/weather.nominal.arff"));
		 
			reader2 = new BufferedReader(
				//new FileReader("/home/paul/Temp/ProyectoFinal/sentimientos_test.arff"));
				new FileReader("/home/paul/Temp/ProyectoFinal/sen_test.arff"));

		 Instances train = new Instances(reader1);
		 train.setClassIndex(train.numAttributes() - 1); 
		 System.out.println("Indice de la clase: " + train.classIndex() + ".   # atributos entrenamiento: "+ train.numAttributes() );
		 
		 
		 Instances test = new Instances(reader2);
		 test.setClassIndex(train.numAttributes() - 1);
		 System.out.println("Indice de la clase: " + test.classIndex() + ".   # atributos de prueba: "+ test.numAttributes() );
		 
		 NaiveBayes model=new NaiveBayes();
		 model.buildClassifier(train);
		 
		 /*
		 Instances labeled = new Instances(test);
		 for (int i = 0; i < test.numInstances(); i++){
			 double clsLabel = model.classifyInstance(test.instance(i));
			 labeled.instance(i).setClassValue(clsLabel);
		 }*/
		 
		 Evaluation eval_train = new Evaluation(test);
		 eval_train.evaluateModel(model,test);
		 
		 //reader1.close();
		 //reader2.close();
		 
		 System.out.println(eval_train.toSummaryString("\nResultados NaiveBayes\n=============\n", false));


		 SMO evaluaSMO = new SMO();
		 evaluaSMO.buildClassifier(train);
		 Evaluation eval_trainSMO = new Evaluation(test);
		 eval_trainSMO.evaluateModel(evaluaSMO,test);
		 System.out.println(eval_trainSMO.toSummaryString("\nResultados SMO\n============\n", false));

		 IBk evaluaIBk = new IBk();
		 evaluaIBk.buildClassifier(train);
		 Evaluation eval_trainIBk = new Evaluation(test);
		 eval_trainIBk.evaluateModel(evaluaIBk,test);
		 System.out.println(eval_trainIBk.toSummaryString("\nResultados IBk\n======\n", false));
		 

		 J48 evalua2 = new J48();
		 evalua2.buildClassifier(train);

		 

		 /*
		 Instances testInstance = new Instances(test);
		 for (int i = 0; i < test.numInstances(); i++){
			 double clsLabel = evalua2.classifyInstance(test.instance(i));
			 testInstance.instance(i).setClassValue(clsLabel);
		 }
		 */
		 
		 Evaluation eval_train2 = new Evaluation(test);
		 eval_train2.evaluateModel(evalua2,test);
		 
		 reader1.close();
		 reader2.close();
		 
		 System.out.println(eval_train2.toSummaryString("\nResultados J48\n======\n", false));

		 /*
		 String[] options = new String[4];
		 options[0] = "-t"; //name of training file
		 options[1] = "/Users/elikary/Desktop/mineria/weka-data/weather.nominal.arff";
		 options[2] = "-T";
		 options[3] = "/Users/elikary/Desktop/mineria/weka-data/weather.nominal_test_inc.arff";		 
		 System.out.println(Evaluation.evaluateModel(model, options));
		 
		 
		 /// print classification results to file
		 
		 BufferedWriter writer = new BufferedWriter(
				 new FileWriter("/Users/elikary/Desktop/mineria/weka-data/weather.nominal_labeled.arff"));
		 writer.write(labeled.toString());
		 
		 writer.close();
		 */
		}
		 catch (Exception e) {
				e.printStackTrace();
		}
    }
}