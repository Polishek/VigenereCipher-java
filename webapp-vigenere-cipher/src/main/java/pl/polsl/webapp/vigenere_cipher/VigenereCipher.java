package pl.polsl.webapp.vigenere_cipher;

import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.polsl.webapp.model.VigenereModel;
import entities.ClearMessageAndKey;
import entities.CodedMessage;
import java.util.Set;

/**
 *
 * @author bartu
 */
@WebServlet(name = "Controller", urlPatterns = {"/beginEncryption"})
public class VigenereCipher extends HttpServlet {
    
    private VigenereModel theModel = new VigenereModel();
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            
        out.println("<!DOCTYPE html>");
        String textToCode = request.getParameter("textToCode");
        String keyLetter = request.getParameter("keyLetter");
        
        theModel.setTextToCode(textToCode);
        theModel.setSecretLetter(keyLetter);
        theModel.encodeMessage();
         
        ClearMessageAndKey clearMessageAndKey = new ClearMessageAndKey();
        clearMessageAndKey.setClearMessage(theModel.getTextToCode()); //set textToCode in ClearMessageAndKey
        clearMessageAndKey.setKey(theModel.getSecretLetter()); //set keyLetter in ClearMessageAndKey

        CodedMessage codedMessage = new CodedMessage();
        codedMessage.setCodedMessage(theModel.getEncodedMessage());
       
        clearMessageAndKey.setCodedMessage(codedMessage); //persist clearMessageAndKey
        codedMessage.setClearMessageAndKey(clearMessageAndKey);
        this.persistObject(clearMessageAndKey);
        this.persistObject(codedMessage); //persist codedMessage       
       
        
        out.println("<html>");
        out.println("<body>");
        out.println("Wiadomość zaszyfrowana: " + theModel.getEncodedMessage());
        out.println("</body>");
        out.println("</html>");
    }
    
    public void persistObject(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pl.polsl.webapp.vigenere_cipher_JPA_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
            System.out.println("Object persisted");
        } catch (PersistenceException e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
