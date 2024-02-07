package org.zerock.t1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO {
        private Long tno;
        private String name;
        private String id;
        private String password;
        private int age;
        private String gender;
        private String hobbies;
        private String travel;
        private String content;

    }

