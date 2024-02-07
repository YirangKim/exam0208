package org.zerock.t1.control;

import org.zerock.t1.dto.TodoDTO;
import org.zerock.t1.service.TodoService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "todoRegisterController", urlPatterns = "/todo/register")
public class TodoRegisterController extends HttpServlet {

    private TodoService todoService = TodoService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        System.out.println("입력화면을 볼 수 있도록 구성");

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/todo/register.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
        ServletException, IOException {
        System.out.println("입력을 처리하고 목록 페이지로 이동");

        req.setCharacterEncoding("UTF-8");

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

        try {
            todoService.register(todoDTO);
            System.out.println(todoDTO);
            req.setAttribute("list", todoDTO);


        } catch (Exception e) {
            e.printStackTrace();
        }

        //리다이렉트
        resp.sendRedirect("/todo/list");
    }
}
