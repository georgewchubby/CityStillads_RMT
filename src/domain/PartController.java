package domain;

import dataSource.*;
/**
 *
 * @author joachim
 */
public class PartController {
    private Part currentPart;
    private PartFacade pf;
    
    public PartController() {
        currentPart = null;
        pf = PartFacade.getInstance();
    }
    
    public Part getPart(int pno) {
        currentPart = pf.getPart(pno);
        return currentPart;
    }
    
    public 
}
