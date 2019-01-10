package instigate.myArray;

public class StugumMyArray {
    public static void main(String[] args) {
        MyArray<Integer> str = new MyArray<>();
        str.add(10);
        str.add(20);
        str.add(30);
        str.add(40);
        str.add(50);

        System.out.println("======[show]=====");
        str.show();

        System.out.println("======[add]=====");
        str.show();

        str.pop();
        System.out.println("======[pop]=====");
        str.show();

        str.shift(100);

        System.out.println("======[shift]=====");
        str.show();

        str.unshift();

        System.out.println("======[unshift]=====");
        str.show();

        str.set(150,2);

        System.out.println("======[set]=====");
        str.show();

        str.replace(200, 2);

        System.out.println("======[replace]=====");
        str.show();

        str.remove(2);

        System.out.println("======[remove]=====");
        str.show();

        System.out.println("======[find]=====");
        System.out.println(str.find(100));

        System.out.println("======[contains]=====");
        System.out.println(str.contains(60));

        System.out.println("======[isEmpty]=====");
        System.out.println(str.isEmty());

        System.out.println("======[Size]=====");
        System.out.println(str.size());

        str.reverse();
        System.out.println("======[reverse]=====");
        str.show();

        str.sort();
        System.out.println("======[sort]=====");
        str.show();

        System.out.println("======[max]=====");
        System.out.println(str.max());

        System.out.println("======[min]=====");
        System.out.println(str.min());


    }
}
