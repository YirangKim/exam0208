package org.zerock.t1.control;

import lombok.extern.log4j.Log4j2;
import org.zerock.t1.domain.TodoVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.zerock.t1.dao.TodoDAO;
import org.zerock.t1.dto.TodoDTO;
import org.zerock.t1.service.TodoService;

@Log4j2
@WebServlet(name = "listController", urlPatterns = "/todo/list")
public class ListController extends HttpServlet {
    private TodoService todoService = TodoService.INSTANCE;

    @Override
    protected void doGET(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
//        String name = req.getParameter("name");
//        String id = req.getParameter("id");
//        String password = req.getParameter("password");
//        String age = req.getParameter("age");
//        String gender = req.getParameter("gender");
//        String hobbies = req.getParameter("hobbies");
//        String travel = req.getParameter("travel");
//        String content = req.getParameter("content");

        TodoDTO todoDTO = TodoDTO.builder()
                .name(req.getParameter("name"))
                .id(req.getParameter("id"))
                .password(req.getParameter("password"))
                .age(Integer.parseInt(req.getParameter("age")))
                .gender(req.getParameter("gender"))
                .hobbies(req.getParameter("hobbies"))
                .travel(req.getParameter("travel"))
                .content(req.getParameter("content"))
                .build();

        System.out.println("todoDTO" + todoDTO);

        req.setAttribute("dto", todoDTO);
        try {
            todoService.register(todoDTO);
            System.out.println(todoDTO);
            req.setAttribute("list", todoDTO);


        } catch (Exception e) {
            e.printStackTrace();
        }

        req.getRequestDispatcher("/WEB-INF/todo/list.jsp").forward(req, resp);
    }
}
