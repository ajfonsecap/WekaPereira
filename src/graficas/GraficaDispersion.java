package graficas; 

import java.util.Arrays;
import java.util.Vector;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.editor.ChartEditorFactory;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYIntervalSeriesCollection;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class GraficaDispersion {
    
    private double x[],y[]; 
    private int asig[]; 
    
    public GraficaDispersion(double x[], double y[], int asig[]){
       this.x=x;
       this.y=y;
       this.asig=asig;
    }
    public ChartPanel generarGrafica(){
        
        XYDataset dataset=crearDataset();
        JFreeChart chart=ChartFactory.createScatterPlot("Clima Pereira","Temperatura", "Humedad", dataset);
        ChartPanel cp=new ChartPanel(chart);
        return cp; 
    }
    public XYDataset crearDataset(){
        
        //double x[]={1,2,3,4,5,6,7,8,9,10};
        //double y[]={10,12,11,10.5,12.5,14.5,13.6,8.9,15,20};
        //double asig[]={0,1,0,1,0,1,0,1,0,1};
        
        XYSeriesCollection dataset=new XYSeriesCollection();
        XYSeries c1=new XYSeries("C1");
        XYSeries c2=new XYSeries("C2");
               
        for (int i = 0; i < x.length; i++) {
            
            if(asig[i]==0){
                c1.add(x[i],y[i]);
            }
            else{
                c2.add(x[i],y[i]);
            }
        }
        dataset.addSeries(c1);
        dataset.addSeries(c2);
        
        return dataset; 
    }
    
}
