package ctrl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import alienbot.AlienBot;

/**
 * Servlet implementation class Answers
 */
@WebServlet("/Answers")
public class Answers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AlienBot alienBot = new AlienBot();
	String data = "";
	String chat = "";

	/**
	 * Default constructor.
	 */
	public Answers() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uText = request.getParameter("uText").trim();
		String answer = "";

		// processing
		switch (uText) {
		case "showdatas":
			data += chat;
			chat = data;
			break;
		case "cleardatas":
			data = "";
			break;
		case "clear":
			data += chat;
			chat = "";
			break;
		default:
			if (uText != null || uText != "") {
				answer = alienBot.analizeEnterTxt(uText);
			}

			// ">>>" meaning that the jsp page split the <chat> in to array
			chat = chat + ">>>" + uText;
			chat = chat + ">>>" + answer;
			break;
		}

		// set attributes
		request.setAttribute("chat", chat.replaceAll("'", "&#39;"));
		System.out.println("chat: " + chat);

		request.getRequestDispatcher("/index.jsp").forward(request, response);
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
