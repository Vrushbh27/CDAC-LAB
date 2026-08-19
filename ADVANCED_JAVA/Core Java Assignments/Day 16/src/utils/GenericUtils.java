package utils;
// 3. Write a static method in a non generic Utils class 
//  - to display taste of all fruits from the fruit basket , represented by a List
// Test Case - ArrayList<Apple>  , LinkedList<Orange> , Vector<Mango>
// Refer - <fruits> package in day16.1 project.

// 3. Write a static method in a non generic Utils class 
//  - to get sum of all numbers(integer | double | float | byte ..), stored in the Set .
// Test cases - HashSet<Integer> , LinkedHashSet<Double> , TreeSet<Long>
// OR
// 3. Write a static method in a non generic Utils class 
//  - to get sum of salaries of employees stored in the Set .
// Test cases - ArrayList<Manager> , LinkedList<Woker> 
// Refer - com.app.core package for Emp & its sub types.

// 4. Write a static method in a non generic Utils class , which can add ONLY Mangoes(i.e Mango , Alphonso,Kesar ...)  to a fruit basket: List


import com.app.core.Emp;
import fruits.Alphonso;
import fruits.Fruit;
import fruits.Kesar;
import fruits.Mango;
import java.util.Collection;
import java.util.List;

public class GenericUtils {
	/*
	 * Write a static method in a non generic Utils class
	 * - to display elements of any Set | List
	 */
	public static void displayElements(Collection<?> anyCollection) {
		for (Object o : anyCollection)
			System.out.println(o);
	}

	// Write a static method in a non generic Utils class
	// - to display taste of all fruits from the fruit basket , represented by a
	// List
	// Test Case - ArrayList<Apple> , LinkedList<Orange> , Vector<Mango>
	// Refer - <fruits> package in day16.1 project.


	public static void displayTest(Collection<? extends Fruit> anyCollection)
	{
		 for(Fruit o : anyCollection)
			 o.taste();
	}


	// Sum of numbers in a collection (Set, List, etc.)
    public static double sumNumbers(Collection<? extends Number> numbers) {
        double sum = 0;
        for (Number n : numbers) {
            sum += n.doubleValue(); // converts Integer, Float, Long, etc. to double
        }
        return sum;
    }

	 public static double sumSalaries(Collection<? extends Emp> employees) {
        double sum = 0;
        for (Emp e : employees) {
            sum += e.computeSalary();
        }
        return sum;
    }

	 public static void addMangoes(List<Mango> fruitBasket) {
        fruitBasket.add(new Alphonso());
        fruitBasket.add(new Kesar());
        //fruitBasket.add(new Totapuri());
        // Add more mango varieties here as subclasses
    }
}

