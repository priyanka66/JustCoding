package companies;

public final class  FinalClassExample {


    private final String name;
    private final int age;
    public FinalClassExample(String name, int age){
        this.name = name;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static void main(String[] args) {
        FinalClassExample f = new FinalClassExample("Priyanka", 25);
        System.out.println(f.getName());
        System.out.println(f.getAge());


    }


}

