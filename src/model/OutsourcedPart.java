
package model;


public class OutsourcedPart extends Part {
    
    private String companyName;
    
    public OutsourcedPart(int partID, String name, int stock, int min, int max, double price, String companyName){
        
        
        super(partID, name, stock, min, max, price);
        this.setCompanyName(companyName);
        
         
    }
        
        
        public void setCompanyName(String companyName){
            this.companyName = companyName;
            
        
        }
        
        
        public String getCompanyName(){
            return this.companyName;
    
        }
        
        
        
    
    
    }
    
    
    
    
    
    
    
   
