package com.hotelfinder.presentation;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.*;

public class MakeResultsTag extends SimpleTagSupport {
   StringBuilder sb = new StringBuilder();
   
   
   public void doTag() throws JspException, IOException {
	   sb.append("ffffff");
      getJspContext().getOut().println(sb.toString());
   }
}