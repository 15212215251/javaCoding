package demos;/**
 * ClassName:    Emp
 * Package:    demos
 * Description:
 * Datetime:    2021/2/1   9:27 下午
 * Author:   tanglintao
 */

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author: tanglintao
 * @ClassName: Emp
 * @Date: 2021/02/01 21:27
 */
@Data
public class Emp {

    public static void main(String[] args) {
        System.out.println("start ...");
        List<String> lt = Arrays.asList("abc", "bacd", "", "", "ddd");
        long count = lt.stream().filter(x -> !x.isEmpty()).count();
        System.out.println(count);

        // limit
        System.out.println("start 2 ...");
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);

    }
}
