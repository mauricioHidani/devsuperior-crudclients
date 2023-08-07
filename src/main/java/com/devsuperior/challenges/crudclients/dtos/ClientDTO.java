package com.devsuperior.challenges.crudclients.dtos;

import com.devsuperior.challenges.crudclients.entities.Client;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

public class ClientDTO implements Serializable {

    @Serial private static final long serialVersionUID = 1L;

    private Long id;

    @Size(  min = 3,
            max = 120,
            message = "O campo deve ter no minimo 3 e no máximo 120 caracteres")
    @NotBlank(message = "Campo requerido")
    private String name;

    @Size(  min = 11,
            max = 11,
            message = "Campo dever possuir 11 caracteres")
    @NotBlank(message = "Campo requerido")
    private String cpf;

    private Double income;

    @PastOrPresent(message = "A data informada indica uma data que ainda não ocorreou")
    private LocalDate birthDate;

    private Integer children;

    //region Constructors
    public ClientDTO() {
    }

    public ClientDTO(Long id, String name, String cpf, Double income, LocalDate birthDate, Integer children) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
    }

    public ClientDTO(Client entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.cpf = entity.getCpf();
        this.income = entity.getIncome();
        this.birthDate = entity.getBirthDate();
        this.children = entity.getChildren();
    }
    //endregion

    public Client toEntity() {
        return Client
            .builder()
                .id(id)
                .name(name)
                .cpf(cpf)
                .income(income)
                .birthDate(birthDate)
                .children(children)
            .build();
    }

    public Client copy(Client entity) {
        return Client
            .builder()
                .id(entity.getId())
                .name(getName())
                .cpf(getCpf())
                .income(getIncome())
                .birthDate(getBirthDate())
                .children(getChildren())
            .build();
    }

    //region Acess Methods
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
}
