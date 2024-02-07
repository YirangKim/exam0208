package org.zerock.t1.dao;

import lombok.Cleanup;
import org.zerock.t1.domain.TodoVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TodoDAO {
    public void insert(TodoVO vo) throws Exception {

        String sql = "insert into tbl_test (name, id, password, age, gender, hobbies, travel, content) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, vo.getName());
            preparedStatement.setString(2, vo.getId());
            preparedStatement.setString(3, vo.getPassword());
            preparedStatement.setInt(4, vo.getAge());
            preparedStatement.setString(5, vo.getGender());
            preparedStatement.setString(6, vo.getHobbies());
            preparedStatement.setString(7, vo.getTravel());
            preparedStatement.setString(8, vo.getContent());

        System.out.println(vo.getName());

            preparedStatement.executeUpdate();
    }

    public List<TodoVO> selectAll()throws Exception  {

        String sql = "select * from tbl_test";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();


        List<TodoVO> list = new ArrayList<>();

        while(resultSet.next()) {
            TodoVO vo = TodoVO.builder()
                    .tno(resultSet.getLong("tno"))
                    .name(resultSet.getString("name"))
                    .id(resultSet.getString("id"))
                    .password(resultSet.getString("password"))
                    .age(resultSet.getInt("age"))
                    .gender(resultSet.getString("gender"))
                    .hobbies(resultSet.getString("hobbies"))
                    .travel(resultSet.getString("travel"))
                    .content(resultSet.getString("content"))
                    .build();

            list.add(vo);
        }

        return list;
    }
}
