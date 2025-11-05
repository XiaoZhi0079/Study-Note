package ProxyDemo;

public class Star implements StarService {

    String name;

    public Star(String name) {
        this.name = name;
    }

    @Override
    public String dance() {
        System.out.println(this.name+"开始了舞蹈表演");
        return "舞蹈表演完毕，谢谢大家";
    }

    @Override
    public String sing(String name) {
        System.out.println(this.name+"唱了一首"+name);
        return "歌唱表演完毕，谢谢大家";
    }
}
