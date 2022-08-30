/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tlds;

import java.text.SimpleDateFormat;
import static java.time.Instant.now;
import java.util.Date;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author User
 */
public class CurrentDateTag extends TagSupport{
    public int doStartTag() throws JspException {  
        Date curentDate =new Date();
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        String curentDatef= DateFor.format(curentDate);
    JspWriter out=pageContext.getOut();//returns the instance of JspWriter  
    try{  
     out.print(curentDatef);//printing date and time using JspWriter  
    }catch(Exception e){System.out.println(e);}  
    return SKIP_BODY;//will not evaluate the body content of the tag  
}  
    
    
    
}
