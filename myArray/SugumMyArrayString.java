package instigate.myArray;

public class
SugumMyArrayString {
    public static void main(String[] args) {
        MyArray<String> str = new MyArray<>();
        str.add("a");
        str.add("aa");
        str.add("ab");
        str.add("aba");
        str.add("zaaa");

        System.out.println("======[show]=====");
        str.show();

        System.out.println("======[add]=====");
        str.show();

        str.pop();
        System.out.println("======[pop]=====");
        str.show();

        str.shift("zz");

        System.out.println("======[shift]=====");
        str.show();

        str.unshift();

        System.out.println("======[unshift]=====");
        str.show();

        str.set("qq",2);

        System.out.println("======[set]=====");
        str.show();

        str.replace("pqp", 2);

        System.out.println("======[replace]=====");
        str.show();

        str.remove(2);

        System.out.println("======[remove]=====");
        str.show();

        System.out.println("======[find]=====");
        System.out.println(str.find("aa"));

        System.out.println("======[contains]=====");
        System.out.println(str.contains("aba"));

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
