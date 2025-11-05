public class Dog {

    private String name;
    private int age;
    private String hobby;
    public Integer weight;

    private Dog(){

    }
    private Dog(String name) {
        this.name = name;
    }
    public Dog(String name, int age, String hobby) {
     this.name = name;
     this.age = age;
     this.hobby = hobby;
    }

    void eat(){
        System.out.println("狗狗吃骨头");
    }
    String eat(int n){
        System.out.println(name+"吃了"+n+"根骨头");
        return name+"吃骨头后很开心";
    }

    @Override
    public String toString() {
        return "姓名："+name+"    "+"体重："+weight;
    }
}
