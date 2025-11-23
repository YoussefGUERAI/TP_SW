import java.util.*;

interface Company{
    double calculateTotalPackage();
}
class Independent implements Company{
    private int numofVehicles;
    private double unitcostPervehicle;
    public Independent(int numofVehicles, double unitcostPervehicle) {
        this.numofVehicles = numofVehicles;
        this.unitcostPervehicle = unitcostPervehicle;
    }
    public double calculateTotalPackage() {
        double total = numofVehicles * unitcostPervehicle;
        System.out.println("Total Package Cost: " + total);
        return total;
    }
}

class Parent implements Company{
    private List<Company> children = new ArrayList<>();
    public void addCompany(Company company) {
        children.add(company);
    }
    public void removeCompany(Company company) {
        children.remove(company);
    }
    public double calculateTotalPackage() {
        System.out.println("Calculating package for Parent Company");
        double total = 0;
        for (Company company : children) {
            total += company.calculateTotalPackage();
        }
        System.out.println("Total Package Cost for Parent Company: " + total);
        return total;

    }
}

public class SaleSystem  {
    public static void main(String[] args) {
        Parent parentCompany = new Parent();

        Independent indie1 = new Independent(10, 5000);
        Independent indie2 = new Independent(20, 4500);

        parentCompany.addCompany(indie1);
        parentCompany.addCompany(indie2);

        parentCompany.calculateTotalPackage();
    }
}

