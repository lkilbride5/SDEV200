import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoanServlet")
public class LoanServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            double loanAmount = Double.parseDouble(request.getParameter("loanAmount"));
            double interestRate = Double.parseDouble(request.getParameter("interestRate"));
            int loanYears = Integer.parseInt(request.getParameter("loanYears"));

            Loan loan = new Loan(loanAmount, interestRate, loanYears);
            double monthlyPayment = loan.calculateMonthlyPayment();
            double totalPayment = loan.calculateTotalPayment();

            out.println("<html><head><title>Loan Payment Result</title></head><body>");
            out.println("<h1>Loan Payment Result</h1>");
            out.println("<p>Loan Amount: $" + loanAmount + "</p>");
            out.println("<p>Annual Interest Rate: " + interestRate + "%</p>");
            out.println("<p>Number of Years: " + loanYears + "</p>");
            out.println("<p>Monthly Payment: $" + monthlyPayment + "</p>");
            out.println("<p>Total Payment: $" + totalPayment + "</p>");
            out.println("</body></html>");
        } catch (NumberFormatException e) {
            out.println("Invalid input. Please enter valid numeric values.");
        } finally {
            out.close();
        }
    }
}
