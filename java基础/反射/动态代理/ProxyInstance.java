package ProxyDemo;

public class ProxyInstance {
    public static void main(String[] args) {

        Star star = new Star("里美尤利娅");
        StarService sp=ProxyUtils.starproxy(star);
        System.out.println(sp.dance());
        System.out.println(sp.sing("I love u"));
    }
}
