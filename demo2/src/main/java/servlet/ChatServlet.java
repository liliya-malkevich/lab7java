package servlet;

import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import entity.Chatmessage;
import entity.ChatUser;
@WebServlet(name = "ChatServlet", value = "/chatServelt")
public class ChatServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // Карта текущих пользователей
    protected HashMap<String, ChatUser> activeUsers;
    // Список сообщений чата
    protected ArrayList<Chatmessage> messages;

    @SuppressWarnings("unchecked")
    public void init() throws ServletException {
        // Вызвать унаследованную от HttpServlet версию init()
        super.init();
        // Извлечь из контекста карту пользователей и список сообщений
        activeUsers = (HashMap<String, ChatUser>) getServletContext().getAttribute("activeUsers");
        messages = (ArrayList<Chatmessage>) getServletContext().getAttribute("messages");
        // Если карта пользователей не определена ...

        if (activeUsers==null) {
            // Создать новую карту
            activeUsers = new HashMap<String, ChatUser>();
            // Поместить ее в контекст сервлета,
// чтобы другие сервлеты могли до него добраться
            getServletContext().setAttribute("activeUsers", activeUsers);
        }
        // Если список сообщений не определен ...
        if (messages==null) {
            // Создать новый список
            messages = new ArrayList<Chatmessage>(100);
            // Поместить его в контекст сервлета,
// чтобы другие сервлеты могли до него добрать
            getServletContext().setAttribute("messages", messages);
        }
    }
}

