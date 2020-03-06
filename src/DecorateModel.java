// 装饰模式
public class DecorateModel {
    public static void main(String[] args) {
        Person xc = new Person("小菜");
        System.out.println("第一种装扮：");

        TShirts ts = new TShirts();
        BigTrouser bt = new BigTrouser();

        ts.decorate(xc);
        bt.decorate(ts);
        bt.show();
    }

}

class Person{
    public Person(){}
    private String name;
    public Person(String name)
    {
        this.name = name;
    }
    public void show(){
        System.out.println("装扮的" + name);
    }
}

class Finery extends Person{
    protected Person component;
    public void decorate(Person component){
        this.component = component;
    }

    public void show(){
        if (component != null){
            component.show();
        }
    }
}

class TShirts extends Finery{
    public void show(){
        System.out.println("大T恤");
        super.show();
    }
}

class BigTrouser extends Finery{
    public void show(){
        System.out.println("垮裤");
        super.show();
    }
}