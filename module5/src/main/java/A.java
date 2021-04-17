import com.google.gson.Gson;

public class A {

    public static void main(String[] args) {
        User u1 = new User();
        u1.setName("Ivan");
        u1.setAge(15);

        Gson gson = new Gson();

        String json = gson.toJson(u1);
        System.out.println(json);

        User u2 = gson.fromJson(json, User.class);

        System.out.println(u2);
    }
}
