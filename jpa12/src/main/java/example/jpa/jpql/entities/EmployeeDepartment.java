package example.jpa.jpql.entities;

/**
 * Employee-department pair for JPA projection purposes.
 */
public class EmployeeDepartment {
    private String employeeName;
    private String departmentName;

    public EmployeeDepartment(String employeeName, String departmentName) {
        this.employeeName = employeeName;
        this.departmentName = departmentName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "EmployeeDepartment{" + "employeeName=" + employeeName + ", departmentName=" + departmentName + '}';
    }

}
