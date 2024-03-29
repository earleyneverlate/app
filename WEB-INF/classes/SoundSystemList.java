import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SoundSystemList")

public class SoundSystemList extends HttpServlet {

	/* Tv Page Displays all the tvs and their Information in Best Deal */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String name = null;
		String CategoryName = request.getParameter("maker");
        

		/* Checks the Tv types*/

		HashMap<String, SoundSystem> hm = new HashMap<String, SoundSystem>();
		if(CategoryName==null){
			hm.putAll(SaxParser4BestDealXMLdataStore1.sounds);
			name = "";
		}
		else
		{
		   if(CategoryName.equals("behringer"))
		   {
			 for(Map.Entry<String,SoundSystem> entry : SaxParser4BestDealXMLdataStore1.sounds.entrySet())
			 {
				if(entry.getValue().getRetailer().equals("Behringer"))
				 {
					 hm.put(entry.getValue().getId(),entry.getValue());
				 }
			 }
				name = "Behringer";
		   }
		   else if(CategoryName.equals("rockville"))
		    {
			for(Map.Entry<String,SoundSystem> entry : SaxParser4BestDealXMLdataStore1.sounds.entrySet())
				{
				 if(entry.getValue().getRetailer().equals("Rockville"))
				 {
					 hm.put(entry.getValue().getId(),entry.getValue());
				 }
				}
				 name = "Rockville";
			}
			else if(CategoryName.equals("powerwerks"))
			{
				for(Map.Entry<String,SoundSystem> entry : SaxParser4BestDealXMLdataStore1.sounds.entrySet())
				{
				 if(entry.getValue().getRetailer().equals("Powerwerks"))
				 {
					 hm.put(entry.getValue().getId(),entry.getValue());
				 }
				}
			   	 name = "Powerwerks";
			}
			else if(CategoryName.equals("dell"))
			{
				for(Map.Entry<String,SoundSystem> entry : SaxParser4BestDealXMLdataStore1.sounds.entrySet())
				{
				 if(entry.getValue().getRetailer().equals("Dell"))
				 {
					 hm.put(entry.getValue().getId(),entry.getValue());
				 }
				}
			   	 name = "Dell";
			}
			else if(CategoryName.equals("mackie"))
			{
				for(Map.Entry<String,SoundSystem> entry : SaxParser4BestDealXMLdataStore1.sounds.entrySet())
				{
				 if(entry.getValue().getRetailer().equals("Mackie"))
				 {
					 hm.put(entry.getValue().getId(),entry.getValue());
				 }
				}
			   	 name = "Mackie";
			}
		}

		
		/* Header, Left Navigation Bar are Printed.

		All the Console and Console information are dispalyed in the Content Section

		and then Footer is Printed*/

		Utilities utility = new Utilities(request,pw);
		utility.printHtml("Header.html");
		utility.printHtml("LeftNavigationBar.html");
		pw.print("<div id='content'><div class='post'><h2 class='title meta'>");
		pw.print("<a style='font-size: 24px;'>"+name+" Sound System</a>");
		pw.print("</h2><div class='entry'><table id='bestseller'>");
		int i = 1; int size= hm.size();
		for(Map.Entry<String, SoundSystem> entry : hm.entrySet())
		{
			SoundSystem sounds = entry.getValue();
			if(i%3==1) pw.print("<tr>");
			pw.print("<td><div id='shop_item'>");
			pw.print("<h3>"+sounds.getName()+"</h3>");
			pw.print("<strong>$"+sounds.getPrice()+"</strong><ul>");
			pw.print("<li id='item'><img src='images/sound_systems_images/"+sounds.getImage()+"' alt='' /></li>");
			
			pw.print("<li><form method='post' action='Cart'>" +
					"<input type='hidden' name='name' value='"+entry.getKey()+"'>"+
					"<input type='hidden' name='type' value='consoles'>"+
					"<input type='hidden' name='maker' value='"+CategoryName+"'>"+
					"<input type='hidden' name='access' value=''>"+
					"<input type='submit' class='btnbuy' value='Buy Now'></form></li>");
			pw.print("<li><form method='post' action='WriteReview'>"+"<input type='hidden' name='name' value='"+entry.getKey()+"'>"+
					"<input type='hidden' name='type' value='consoles'>"+
					"<input type='hidden' name='maker' value='"+CategoryName+"'>"+
					"<input type='hidden' name='access' value=''>"+
				    "<input type='submit' value='WriteReview' class='btnreview'></form></li>");
			pw.print("<li><form method='post' action='ViewReview'>"+"<input type='hidden' name='name' value='"+entry.getKey()+"'>"+
					"<input type='hidden' name='type' value='consoles'>"+
					"<input type='hidden' name='maker' value='"+CategoryName+"'>"+
					"<input type='hidden' name='access' value=''>"+
				    "<input type='submit' value='ViewReview' class='btnreview'></form></li>");
			pw.print("</ul></div></td>");
			if(i%3==0 || i == size) pw.print("</tr>");
			i++;
		}	
		pw.print("</table></div></div></div>");
   
		utility.printHtml("Footer.html");
		
	}
}