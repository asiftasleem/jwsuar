<%@ page import="predictions.Predictions" %>

<jsp:useBean id    = "preds" 
	     type  = "predictions.Predictions" 
	     class = "predictions.Predictions"> 
  <% 
     String verb = request.getMethod();

     if (!verb.equalsIgnoreCase("GET")) {
       response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "GET requests only are allowed.");
     }
     // If it's a GET request, return the predictions.
     else {
       out.println(preds.getPredictions());
     }
  %>
</jsp:useBean>  
