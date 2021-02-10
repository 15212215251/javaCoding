package demos;/**
 * ClassName:    Java_Stream
 * Package:    demos
 * Description:
 * Datetime:    2021/2/1   9:00 下午
 * Author:   tanglintao
 */

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author: tanglintao
 * @ClassName: Java_Stream
 * @Date: 2021/02/01 21:00
 */
public class Java_Stream {



    public static void main(String[] args) {
        //1. 创建Stream - bystream
        List<String> list = Arrays.asList("a", "b", "c");
        Stream<String> stream = list.stream();
        System.out.println("使用 stream方法创建的Stream遍历");
        // 用这种方法遍历输出。
        stream.forEach(System.out::println);
        // 输出结果a b c
        // 2.使用Arrays.stream(T[])创建
        int[] array = {1, 3, 4, 5, 6, 8};
        IntStream intStream = Arrays.stream(array);
        System.out.println(intStream);

        // 3. 使用Stream的静态方法of 、 interate()、generate()
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> stream2 = Stream.iterate(0, (x) -> x + 3).limit(5);

        // 创建一个Steam 过滤部分数据。
        System.out.println("-----start-------");
        Stream<Integer> s = Stream.of(4, 45, 6, 75, 8, 8, 5, 3, 56, 43, 564);
//        s.filter(x -> x%5==0).forEach(System.out::println);

        // 匹配第一个符合条件的值
        System.out.println("第一个匹配成功的值");
        Optional<Integer> optional = s.filter(x -> x % 5 == 0).findAny();
        System.out.println(optional.get());
        System.out.println(optional.getClass());
    }


}
