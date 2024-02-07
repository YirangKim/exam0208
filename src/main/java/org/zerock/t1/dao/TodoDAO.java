package org.zerock.t1.dao;

import lombok.Cleanup;
import org.zerock.t1.domain.TodoVO;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
}
