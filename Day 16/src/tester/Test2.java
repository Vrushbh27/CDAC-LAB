
// 3. Write a static method in a non generic Utils class 
//  - to display taste of all fruits from the fruit basket , represented by a List
// Test Case - ArrayList<Apple>  , LinkedList<Orange> , Vector<Mango>
// Refer - <fruits> package in day16.1 project.

package tester;

import fruits.Mango; 
import fruits.Orange;
import fruits.Apple;// imports Apple, Mango, Orange, Fruit, etc.

import static utils.GenericUtils.displayTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Test2 {
    public static void main(String[] args) {
        List<Apple> list = new ArrayList<>();

        list.add(new Apple("GoldenDel"));
        list.add(new Apple("RedDel"));
        list.add(new Apple("Jonathan"));
        list.add(new Apple("Courtland"));

        System.out.println("Test of Mangoes is : ");
        displayTest(list); // calls taste() on each Apple
        System.out.println();

        LinkedList<Orange> oranges = new LinkedList<>();

        oranges.add("Nagpur Orange");
        oranges.add("Valencia");
        oranges.add("Blood Orange");
        oranges.add("Kinnow");

        System.out.println("Test of Oranges is ");
        displayTest(oranges);
        System.out.println();

        Vector<Mango> mangoes = new Vector<>();

        mangoes.add(new Mango("Kesar"));
        mangoes.add(new Mango("Alphonso"));

        System.out.println("Test of Mangoes is ");
        displayTest(mangoes);
        System.out.println();

    }
}
