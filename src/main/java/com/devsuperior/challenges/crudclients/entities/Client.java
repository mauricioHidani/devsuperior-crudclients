package com.devsuperior.challenges.crudclients.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "tb_clients")
public class Client implements Serializable {

    @Serial private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 128)
    private String name;

    @Column(length = 11, unique = true, nullable = false)
    private String cpf;

    @Column
    private Double income;

    @Column
    private LocalDate birthDate;

    @Column
    private Integer children;

    //region Constructors
    protected Client() {
    }

    public Client(Long id, String name, String cpf, Double income, LocalDate birthDate, Integer children) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
    }
    //endregion

    //region Access Methods
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public Double getIncome() {
        return income;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Integer getChildren() {
        return children;
    }
    //endregion

    //region Builder
    public static ClientBuilder builder() {
        return new ClientBuilder();
    }

    public static class ClientBuilder {
        private Long id;
        private String name;
        private String cpf;
        private Double income;
        private LocalDate birthDate;
        private Integer children;

        public ClientBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public ClientBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ClientBuilder cpf(String cpf) {
            this.cpf = cpf;
            return this;
        }

        public ClientBuilder income(Double income) {
            this.income = income;
            return this;
        }

        public ClientBuilder birthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public ClientBuilder children(Integer children) {
            this.children = children;
            return this;
        }

        public Client build() {
            return new Client(
                    id,
                    name,
                    cpf,
                    income,
                    birthDate,
                    children
            );
        }
    }
    //endregion
}
