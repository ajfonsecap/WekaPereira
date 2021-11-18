package calculos;

import java.util.Arrays;
import java.util.Random;
import weka.classifiers.functions.LinearRegression;
import weka.core.Attribute;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;


public class RegresionLinealPereiraXY {

   
    public static void main(String[] args) throws Exception {
        
        FastVector fv=new FastVector(2);
        fv.addElement(new Attribute("X"));
        fv.addElement(new Attribute("Y"));
        Instances dataset = new Instances("dataset", fv,12);
        dataset.setClassIndex(1);
        
        double x[]={20.1,19.8,19.6,19.3,19.2,18.9,18.7,18.4,18.2,18.0,18.4,19.5,20.8,22.1,23.4,24.4,25.2,25.6,25.6,25.3,24.4,22.9,21.7,20.7,20.1,19.7,19.3,19.1,18.9,18.7,18.6,18.4,18.2,18.0,18.3,19.1,20.5,21.1,21.8,22.6,22.7,22.4,22.3,21.9,21.3,20.4,19.6,19.1,18.9,18.6,18.4,18.2,18.0,18.0,17.9,17.8,17.7,17.6,18.5,19.4,20.3,21.3,22.3,23.3,24.1,24.7,24.5,24.3,23.5,22.0,20.8,15.2,14.9,14.8,14.8,14.7,14.7,15.1,15.0,15.0,14.9,14.8,15.5};
        double y[]={97.7,97.7,98.1,98.3,98.4,98.7,98.5,98.1,98.1,98.0,96.8,94.1,89.3,75.7,60.1,57.2,57.0,63.7,87.0,90.9,96.4,97.5,98.2,97.8,97.7,98.2,98.7,98.9,99.2,99.2,98.8,98.5,98.1,98.1,96.7,92.4,79.8,66.4,58.7,54.4,53.3,55.8,70.8,93.0,96.5,97.6,98.2,98.4,98.7,98.6,98.7,98.8,98.8,98.7,98.6,98.3,98.3,98.3,97.0,93.1,82.3,66.2,59.7,55.5,53.7,56.3,81.6,94.3,96.3,97.1,97.6,98.3,98.0,97.9,97.9,97.9,98.1,97.9,97.6,97.4,97.3,96.9,95.8}; 
        
        Instance temp; 
        for (int i = 0; i < x.length; i++) {
            
            temp=new Instance(2);
            temp.setValue(0, x[i]);
            temp.setValue(1, y[i]);
            dataset.add(temp);
        }
        
        LinearRegression lr=new LinearRegression();
        lr.buildClassifier(dataset);
        System.out.println(""+lr);
        System.out.println(""+Arrays.toString(lr.coefficients()));
        
         //Predicción
         Instance ins=new Instance(2);
         ins.setDataset(dataset);
         ins.setValue(0, 100);
         System.out.println("Predicción será "+lr.classifyInstance(ins)); 
        
        
    }
    
}
