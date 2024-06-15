package user.reg;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import user.UserBean;

@SuppressWarnings("serial")
@WebServlet("/reg")
public class RegisterServlet extends HttpServlet
{
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		UserBean ub=new UserBean();
		ub.setMailId(req.getParameter("mid"));
		ub.setfName(req.getParameter("fname"));
		ub.setmName(req.getParameter("mname"));
	    ub.setlName(req.getParameter("lname"));
	    ub.setFullName(req.getParameter("fullname"));
	    ub.setFatherName(req.getParameter("fathername"));
	    ub.setuName(req.getParameter("uname"));
	    String pword=req.getParameter("pword");
	    String rpword=req.getParameter("rpword");
	    
	    if(pword.equals(rpword))
	    {
	    	ub.setpWord(pword);
	    }
	    String phoneNumber=req.getParameter("phno");
	    if(phoneNumber != null && !phoneNumber.isEmpty())
	    {
	    	String numericPhoneNumber = phoneNumber.replaceAll("[^0-9]", "");
	    	 // Check if the numericPhoneNumber string is not empty
            if (!numericPhoneNumber.isEmpty()) {
                // Convert the string to a long
                long phoneNumberLong = Long.parseLong(numericPhoneNumber);
                ub.setPhNo(phoneNumberLong);
                // Now you can use the phoneNumberLong variable as needed in your Java code
                
                // Example response
                res.getWriter().println("Phone number as long: " + phoneNumberLong);
            } else {
                // Handle case when the phone number contains no numeric characters
                res.getWriter().println("Invalid phone number format");
            }
        } else {
            // Handle case when the phone number input field is empty
            res.getWriter().println("Phone number input field is empty");
        }
	    String aphoneNumber=req.getParameter("rphno");
	    if(aphoneNumber != null && !aphoneNumber.isEmpty())
	    {
	    	String numericPhoneNumber = aphoneNumber.replaceAll("[^0-9]", "");
	    	 // Check if the numericPhoneNumber string is not empty
            if (!numericPhoneNumber.isEmpty()) {
                // Convert the string to a long
                long phoneNumberLong = Long.parseLong(numericPhoneNumber);
                ub.setaPhNo(phoneNumberLong);
                // Now you can use the phoneNumberLong variable as needed in your Java code
                
                // Example response
                res.getWriter().println("Phone number as long: " + phoneNumberLong);
            } else {
                // Handle case when the phone number contains no numeric characters
                res.getWriter().println("Invalid phone number format");
            }
        } else {
            // Handle case when the phone number input field is empty
            res.getWriter().println("Phone number input field is empty");
        }
	    ub.setAddress(req.getParameter("address"));
	    int k=new RegisterDAO().insert(ub);
	    if(k>0)
	    {
	    	req.setAttribute("msg", "Registration Successfull");
	    	req.getRequestDispatcher("Register.jsp").forward(req, res);
	    }
	}
}
