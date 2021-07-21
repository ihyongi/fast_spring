import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import dto.Car;
import dto.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class main {

    public static void main(String[] args) throws JsonProcessingException {
        System.out.println("main");

        ObjectMapper objectMapper=new ObjectMapper();

        User user=new User();
        user.setName("이횽이");
        user.setAge(29);

        Car car1=new Car();
        car1.setName("K5");
        car1.setCarNumber("11가 1111");
        car1.setType("sedan");

        Car car2=new Car();
        car2.setName("Q5");
        car2.setCarNumber("22가 2222");
        car2.setType("SUV");

//        List<Car> list=new ArrayList<>();
//        list.add(car1);
//        list.add(car2);
        List<Car> list= Arrays.asList(car1,car2);
        user.setCars(list);

        //System.out.println("user = " + user);
        //string으로 바꾸자
        String json=objectMapper.writeValueAsString(user);
        System.out.println("json = " + json);

        //순수한 노드에 접근하는 방법(파싱)
        JsonNode jsonNode=objectMapper.readTree(json);
        String _name=jsonNode.get("name").asText(); //텍스트로 변경해라(object로 받기때문에 형변환)
        int _age=jsonNode.get("age").asInt();
        System.out.println("name = " + _name);
        System.out.println("age = " + _age);

        //배열은 어떻게 가져오냐?..전체적인 노드 파싱
        JsonNode cars=jsonNode.get("cars");
        ArrayNode arrayNode=(ArrayNode)cars;

        List<Car> _cars=objectMapper.convertValue(arrayNode, new TypeReference<List<Car>>() {});
        System.out.println("cars = " + _cars);

        //특정제이슨의 값을 바꾸려면?
        ObjectNode objectNode=(ObjectNode) jsonNode;
        objectNode.put("name","ihyongi");
        objectNode.put("age","20");

        System.out.println("objectNode.toPrettyString() = " + objectNode.toPrettyString()); //json예쁘게 출력


    }
}
