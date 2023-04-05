package rohith.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@Column(name = "emp_id")
	private int emp_id;

	@Column(name = "name")
	private String name;

	@ManyToOne
	@JoinColumn(name = "Dep_id")
	@JsonIgnore
	private Department department;

	@ManyToOne
	@JoinColumn(name = "job_id")
	@JsonIgnore
	Job job;

	@Column(name = "salary")
	private double salary;

	@Column(name = "date_of_joining")
	private LocalDate dateofjoining;

	@Column(name = "EmployeeScore")
	private double employeescore;

	@Column(name = "Bonus")
	private double bonus;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public LocalDate getDateofjoining() {
		return dateofjoining;
	}

	public void setDateofjoining(LocalDate dateofjoining) {
		this.dateofjoining = dateofjoining;
	}

	public double getEmployeescore() {
		return employeescore;
	}

	public void setEmployeescore(double employeescore) {
		this.employeescore = employeescore;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	@JsonIgnore
	@OneToMany(mappedBy = "employee", fetch = FetchType.EAGER)
	private List<JobHistory> jobhistories;

	public List<JobHistory> getJobhistories() {
		return jobhistories;
	}

	public void setJobhistories(List<JobHistory> jobhistories) {
		this.jobhistories = jobhistories;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bonus, dateofjoining, department, emp_id, employeescore, job, jobhistories, name, salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Employee))
			return false;
		Employee other = (Employee) obj;
		return Double.doubleToLongBits(bonus) == Double.doubleToLongBits(other.bonus)
				&& Objects.equals(dateofjoining, other.dateofjoining) && Objects.equals(department, other.department)
				&& emp_id == other.emp_id
				&& Double.doubleToLongBits(employeescore) == Double.doubleToLongBits(other.employeescore)
				&& Objects.equals(job, other.job) && Objects.equals(jobhistories, other.jobhistories)
				&& Objects.equals(name, other.name) && Objects.equals(salary, other.salary);
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", name=" + name + ", department=" + department + ", job=" + job
				+ ", salary=" + salary + ", dateofjoining=" + dateofjoining + ", employeescore=" + employeescore
				+ ", bonus=" + bonus + ", jobhistories=" + jobhistories + "]";
	}

}