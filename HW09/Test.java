public class Test {
    public static void main(String[] args) {
        Spell a1 = new Spell("1",1);
        Spell a2 = new Spell("1",1);
        Spell a3 = a1;
        System.out.println(a1 == a2);
        System.out.println(a1.equals(a2));
        System.out.println(a1.equals(a3));
        Spell[] book1 = {new Spell("数学", 10), new Spell("物理", 20)};
        Spell[] book2 = {new Spell("语文", 15), new Spell("英语", 5)};
        Wizard a = new Wizard("爸爸", "White", 100,20, book1);
        Wizard b = new Wizard("狗粮", "White", 90,10, book2);
        System.out.println(a);
        a.interact(b);

        Wizard c = new Wizard("爸爸", "White", 100,20, book1);
        Wizard d = new Wizard("a","w",20);
        Wizard e = new Wizard("a","w",20);
        Wizard f = e;
        System.out.println(a.equals(b));
        System.out.println(d.equals(e));
        System.out.println(f.equals(e));
        Gryffindor A = new Gryffindor("Harry Potter");
        Slytherin B = new Slytherin("Draco Malfoy");
        A.interact(B);
    }
}
