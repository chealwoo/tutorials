package cwl.singleton;

public interface Dog {
    interface F<X,Y> {
        Y f(X x);
    }

    static final class State {
        protected static boolean dead;
        protected static String name = "leo";
        protected static Integer age = 0;
    }

    F<Void,String> getName = new F<Void,String>() {
        public String f(Void _) {
            return State.name;
        }
    };

    F<Void,Void> die = new F<Void,Void>() {
        public Void f(Void _) {
            System.out.println("X_X");
            State.dead = true;
            return null;
        }
    };

    F<Void,Void> woof = new F<Void,Void>() {
        public Void f(Void _) {
            if (State.dead)
                throw new IllegalStateException("cannot woof when dead");
            System.out.println("woof");
            return null;
        }
    };

    F<Integer,Void> sleep = new F<Integer,Void>() {
        public Void f(Integer years) {
            if (State.dead)
                throw new IllegalStateException("cannot sleep when dead");
            State.age += years;
            return null;
        }
    };

    F<Void,Integer> getAge = new F<Void,Integer>() {
        public Integer f(Void _) {
            return State.age;
        }
    };

    public static void main(String[] args) {
        System.out.println(
                "The dog's name is " + Dog.getName.f(null) +
                        " and is " + Dog.getAge.f(null) + " years old"
        );
        Dog.sleep.f(2);
        System.out.println(
                "The dog's name is " + Dog.getName.f(null) +
                        " and is " + Dog.getAge.f(null) + " years old"
        );
        Dog.woof.f(null);
        Dog.die.f(null);
        Dog.woof.f(null);
    }
}
