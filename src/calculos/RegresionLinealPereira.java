package calculos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import weka.classifiers.Evaluation;
import weka.classifiers.functions.LinearRegression;
import weka.core.Instance;
import weka.core.Instances;

public class RegresionLinealPereira {

     public static void main(String[] args) {
    
        try {
            String ruta="clima.arff"; 
            Instances dataset=new Instances(new BufferedReader(new FileReader(ruta)));
            dataset.setClassIndex(1);
            
            LinearRegression lr=new LinearRegression();
            lr.buildClassifier(dataset);
            System.out.println(""+lr);
            System.out.println(""+Arrays.toString(lr.coefficients()));
            
            Evaluation ev=new Evaluation(dataset);
            ev.crossValidateModel(lr, dataset, 10, new Random(5), (Object[]) new String[]{});
            System.out.println(""+ev.toSummaryString());
            
            //Predicción
            Instance ins=new Instance(2);
            ins.setDataset(dataset);
            ins.setValue(0, 200);
            System.out.println("Predicción será "+lr.classifyInstance(ins));           
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RegresionLinealPereira.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RegresionLinealPereira.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(RegresionLinealPereira.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    
    }
    
}
