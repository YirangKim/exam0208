import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.t1.dto.TodoDTO;
import org.zerock.t1.service.TodoService;

public class TodoServiceTests {

    private TodoService todoService;

    @BeforeEach
    public void ready(){
        todoService = TodoService.INSTANCE;
    }

    @Test
    public void testRegister()throws Exception{
        TodoDTO todoDTO = TodoDTO.builder()
                .name("김이랑")
                .id("kir")
                .password("1111")
                .age(1111)
                .gender("여")
                .hobbies("축구")
                .travel("여행")
                .content("ddddddd")
                .build();

        todoService.register(todoDTO);
    }
}
