/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chainpattern;

/**
 *
 * @author asus
 */
public class ChainPattern {

    /**
     * @param args the command line arguments
     */
    private static AbstractConsole getChainOfLoggers(){

        AbstractConsole info = new InfoLogger(AbstractConsole.INFO);
        AbstractConsole warning = new WarningLogger(AbstractConsole.WARNING);      
        AbstractConsole error = new ErrorLogger(AbstractConsole.ERROR);
        info.setNextLogger(warning);  
        warning.setNextLogger(error);
        
        //info will be called first, after that, warning and error will be called
        return info;	
    }

    public static void main(String[] args) {
        AbstractConsole ac= getChainOfLoggers();

        ac.printMessage(AbstractConsole.INFO);   
    }  
}

abstract class AbstractConsole {
    public static int INFO = 1;
    public static int WARNING = 2;  
    public static int ERROR = 3;  

    protected int level;

    protected AbstractConsole nextLogger;

    public void setNextLogger(AbstractConsole nextLogger){
        this.nextLogger = nextLogger;
    }

    public void printMessage(int level){  
        System.out.println("level: "+this.level);
        write();

        if(nextLogger !=null){ //will call if next logger is available
            nextLogger.printMessage(level);
        }
    }

    abstract protected void write();
	
}

class InfoLogger extends AbstractConsole {

   //Constructor
   public InfoLogger(int level){
      this.level = level;
   }

   @Override
   protected void write() {		
      System.out.println("Info: ");
   }
}

class WarningLogger extends AbstractConsole {

   public WarningLogger(int level){
      this.level = level;
   }

   @Override
   protected void write() {		
      System.out.println("Warning: ");
   }
}

class ErrorLogger extends AbstractConsole {

   public ErrorLogger(int level){
      this.level = level;
   }

   @Override
   protected void write() {		
      System.out.println("Error: ");
   }
}