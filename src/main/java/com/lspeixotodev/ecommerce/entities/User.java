package com.lspeixotodev.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Serializable: Quando queremos uma versão em bites do
 * nosso objeto para trafegar em rede/gravar em arquivo
 */

@Entity
@Table(name = "tb_user")
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String phone;

    private String password;

    /**
     * Em properties, o spring.jpa.open-in-view = true, vai
     * permitir que o Jackson ao serializar o json, verifique
     * as relações, ao buscar um usuário, ele vai interpretar o
     * relacionamento e retornar os pedidos tambem (orders), a menos
     * que usemos o @JsonIgnore no atributo orders
     */

    /**
     * A relação entre pedidos e clientes é de 'mão dupla',
     * ao rodar nosso servidor e buscar os pedidos, esses pedidos,
     * vão ter usuários, que vão ter pedidos, etc...
     * A biblioteca de serialização Jackson, vai gerar um loop
     * infinito de chamada, que resolvemos com o @JsonIgnore
     */

    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private List<Order> orders = new ArrayList<>();

    public User() {
    }

    public User(Long id, String name, String email, String phone, String password) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return getId().equals(user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }


}
