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
import java.util.List;

import org.zerock.t1.dao.TodoDAO;
import org.zerock.t1.dto.TodoDTO;
import org.zerock.t1.service.TodoService;

@Log4j2
@WebServlet(name = "listController", urlPatterns = "/todo/list")
public class ListController extends HttpServlet {
    private TodoService todoService = TodoService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        log.info("todo list....................");

        try{
            List<TodoDTO> dtoList = todoService.listAll();
            req.setAttribute("dtoList", dtoList);
            req.getRequestDispatcher("/WEB-INF/todo/list.jsp").forward(req,resp);
        } catch (Exception e){
            log.error(e.getMessage());
            throw new ServletException("list error");
        }
    }
}
