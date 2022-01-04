public class Company {
    private String employerName;
    private String employeeName;
    private String noOfHours;

    @Override
    public String toString() {
        return "Company{" +
                "employerName='" + employerName + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", noOfHours='" + noOfHours + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }

    private String salary;

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setNoOfHours(String noOfHours) {
        this.noOfHours = noOfHours;
    }
    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getEmployerName() {
        return employerName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getNoOfHours() {
        return noOfHours;
    }

    public String getSalary() {
        return salary;
    }

    public Company(String employerName, String employeeName, String noOfHours, String salary) {
        this.employerName = employerName;
        this.employeeName = employeeName;
        this.noOfHours = noOfHours;
        this.salary = salary;
    }

    /**public static void main(String args[])
    {
    Company company=new Company();
    company.setSalary("47600");
    company.setEmployerName("KMCCORP");
    company.setEmployeeName("Chaitanya");
    company.setNoOfHours("160");

    System.out.println(company.getEmployerName()+company.getEmployeeName()+company.getNoOfHours()+company.getSalary());
    }**/
}
