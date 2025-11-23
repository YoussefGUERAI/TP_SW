import java.util.*;

interface Startegy {
    void computeRoute();
    
}

public class User {


    public User() {}
    String chooseMethod(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the method: Walk , Car , Bike : ");
        String method = sc.nextLine();
        sc.close();
        return method;
        
    }
    
}

class Walk implements Startegy {
    public void computeRoute() {
        System.out.println("Computing walking route...");
    }
}
class Car implements Startegy {
    public void computeRoute() {
        System.out.println("Computing driving route...");
    }
}
class Bike implements Startegy {
    public void computeRoute() {
        System.out.println("Computing biking route...");
    }
}

class Navigator {
    private Startegy strategy;
    public void setStrategy(Startegy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy() {
        strategy.computeRoute();
    }
    
}


class Main {    
    public static void main(String[] args) {
        User user = new User();
        Navigator navigator = new Navigator();
        String method = user.chooseMethod();

        switch (method.toLowerCase()) {
            case "walk":
                navigator.setStrategy(new Walk());
                break;
            case "car":
                navigator.setStrategy(new Car());
                break;
            case "bike":
                navigator.setStrategy(new Bike());
                break;
            default:
                System.out.println("Invalid method selected.");
                return;
        }
        navigator.executeStrategy();
    }
}