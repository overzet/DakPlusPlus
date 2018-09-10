package dakplusplus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dakplusplus")
public class DakPlusPlus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name="contract_id")
    private Integer contractId;

    public DakPlusPlus() {
    }

    public DakPlusPlus(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.contractId = age;
    }

    public DakPlusPlus(String name, int age) {
        this.name = name;
        this.contractId = age;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    @Override
    public String toString() {
        return "Employee: " + this.id + ", " + this.name + ", " + this.contractId;
    }

}
