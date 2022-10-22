import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        //Напишите приложение «Телефонный справочник», используя HashMap:
        //В качестве ключа коллекция принимает значение «Имя и Фамилия»,
        //а в качестве значения коллекции — номер телефона.
        //Добавьте 20 произвольных значений в мапу, выведите все значения в консоль.

        Map<String, String> phoneMap = new HashMap<>();
        phoneMap.put("Иванов Иван", "+79101234501");
        phoneMap.put("Петров Петр", "+79803456702");
        phoneMap.put("Козлов Сидор", "+79051111103");
        phoneMap.put("Кошкин Василий", "+79041111104");
        phoneMap.put("Мышкина Анжела", "+79081111105");
        phoneMap.put("Шариков Полиграф", "+79031111106");
        phoneMap.put("Синичкина Светлана", "+79031111108");
        phoneMap.put("Воробьева Елена", "+79031111109");
        phoneMap.put("Гусев Александр", "+79131111110");
        phoneMap.put("Соколова Виктория", "+79031111111");
        phoneMap.put("Орлов Виктор", "+79071111112");
        phoneMap.put("Чижик Семен", "+79031111113");
        phoneMap.put("Королева Анна", "+79021111114");
        phoneMap.put("Тараканов Сергей", "+79031111115");
        phoneMap.put("Васильев Сергей", "+79031111116");
        phoneMap.put("Васильев Иван", "+79031511117");
        phoneMap.put("Васильев Василий", "+79031113118");
        phoneMap.put("Грозный Иван", "+79031171119");
        phoneMap.put("Князев Петр", "+79031121120");

        PhoneBook phoneBook = new PhoneBook(phoneMap);
        System.out.println("Телефонный справочник");
        System.out.println(phoneBook);

        //Возвращаемся к заданию со списком продуктов и рецептов. Вам необходимо доработать класс рецептов так,
        //чтобы для каждого продукта мы могли записать необходимое количество (например, бананы — 2 штуки).
        //Замените HashSet на HashMap, где в качестве ключа — продукт, а в качестве значения — необходимое количество.
        //Если количество продукта не было передано, сохраните 1.
        //Доработайте подсчет суммарной стоимости рецепта — умножьте стоимость каждого продукта на его количество.

        Product banan = new Product("Бананы", 100f, 1f);
        Product apple = new Product("Яблоки", 70f, 2f);
        Product raspberry = new Product("Малина", 120f, 0.2f);
        Product apple2 = new Product("Яблоки", 70f, 2f);//дубль apple по хэшу

        Map<Product, Integer> productMap1 = new HashMap<>();
        productMap1.put(banan, 2);
        productMap1.put(apple, 3);
        productMap1.put(raspberry,0);//в рецепте будет заменено на 1
        productMap1.put(apple2,4);

        Product bread = new Product("Хлеб", 30f, 0.4f);
        Product butter = new Product("Масло сливочное", 180f, 0.2f);
        Product potato = new Product("Картофель", 100f, 2f);

        Map<Product,Integer> productMap2 = new HashMap<>();
        productMap2.put(bread, 4);
        productMap2.put(butter, 5);
        productMap2.put(potato, 2);

        Set<Recipe> recipeSet = new HashSet<>();
        addRecipe(recipeSet,  new Recipe("Рецепт1", productMap1));
        addRecipe(recipeSet, new Recipe("Рецепт2", productMap1 ));
        addRecipe(recipeSet, new Recipe("Рецепт3", productMap2 ));
        //addRecipe(recipeSet, new Recipe("Рецепт1", productMap2 ));//будет исключение

        System.out.println("Коллекция рецептов "+Arrays.toString(recipeSet.toArray()));
        System.out.println();


        //Создайте коллекцию Map<String, Integer>. Заполните ее произвольными значениями.
        //Напишите метод, который принимает строку (ключ) и целое число (значение) и пытается добавить ее в коллекцию по логике:
        //Если такого ключа нет, то просто добавляет данные в коллекцию.
        //Если такой ключ уже есть и значения совпадают, то необходимо бросить исключение.
        //Если такой ключ уже есть, но значения разные, то обновите целое число в коллекции.

        Map<String, Integer> map1 = new HashMap<>();
        map1.put("Ключ1",1);
        map1.put("Ключ2",2);
        map1.put("Ключ3",3);
        map1.put("Ключ4",4);
        map1.put("Ключ5",5);

        putToMap(map1, "Ключ6", 6);//выполнит добавление данных в карту
        putToMap(map1, "Ключ2", 22);//заменит 2 на 22
        //putToMap(map1, "Ключ3", 3);//бросит исключение

        printMap(map1);
        System.out.println();

        //Создайте Map<String, List<Integer>>. Заполните ее 5 элементами, где ключ — произвольное значение,
        //а значение — список, состоящий из 3 случайных чисел в диапазоне от 0 до 1000.
        //Преобразуйте созданную коллекцию в новую — Map<String, Integer>, где ключи взяты из первой коллекции,
        //а число — сумма чисел списка. Выведите результат в консоль.

        Random random = new Random();
        List<Integer> list1=getRandomList(random, 3);
        List<Integer> list2=getRandomList(random, 3);
        List<Integer> list3=getRandomList(random, 3);
        List<Integer> list4=getRandomList(random, 3);
        List<Integer> list5=getRandomList(random, 3);

        Map <String, List<Integer>> map2 = new HashMap<>();
        map2.put("Ключ1", list1);
        map2.put("Ключ2", list2);
        map2.put("Ключ3", list3);
        map2.put("Ключ4", list4);
        map2.put("Ключ5", list5);

        System.out.println("Карта до суммирования");
        printMapList(map2);

        System.out.println();

        Map<String, Integer> mapSum = getMapSum(map2);
        System.out.println("Карта после суммирования");
        printMap(mapSum);

        //Создайте Map<Integer, String>, заполните ее 10 произвольными значениями.
        //Выведите в консоль всё содержимое коллекции в порядке добавления (в формате "ключ:значение").
        Map<Integer,String> treeMap = new LinkedHashMap<>();
        treeMap.put(1, "Значение 1");
        treeMap.put(2, "Значение 2");
        treeMap.put(3, "Значение 3");
        treeMap.put(4, "Значение 4");
        treeMap.put(5, "Значение 5");
        treeMap.put(6, "Значение 6");
        treeMap.put(7, "Значение 7");
        treeMap.put(8, "Значение 8");
        treeMap.put(9, "Значение 9");
        treeMap.put(10, "Значение 10");

        System.out.println();
        printMap(treeMap);

    }


    private static Map<String,Integer> getMapSum(Map<String, List<Integer>> map){
        Map<String,Integer> newMap = new HashMap<>();

        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<Integer>list = entry.getValue();
            int sum=0;
            for(int i=0;i<list.size();i++){
                sum = sum + list.get(i);
            }
            newMap.put(key,sum);
        }
        return newMap;
    }

    private static List<Integer> getRandomList(Random random, int size){
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<size;i++){
            list.add(random.nextInt(1000));
        }
        return list;
    }

    private static void printMapList(Map<String, List<Integer>> map){
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            System.out.println("Ключ = "+entry.getKey()+", значение = "+Arrays.toString(entry.getValue().toArray()));
        }
    }

    private static void putToMap(Map<String,Integer> map, String key, int value) throws Exception {
        if(map.get(key)!=null && map.get(key)==value){//значения совпадают
            throw new Exception("В карте уже есть пара: <"+key+","+value+">");
        }else {
            map.put(key, value);
        }
    }

    private static void printMap(Map<?,?> map){
        for (Map.Entry<?,?> entry : map.entrySet()) {
            System.out.println("Ключ = "+entry.getKey()+", значение = "+entry.getValue());
        }
    }

    private static void addRecipe(Set<Recipe> recipeSet, Recipe recipe) throws Exception {
        if(! recipeSet.add(recipe)){
            throw new Exception("Рецепт "+recipe.getNameRecipe()+" уже добавлен");
        }
    }

}