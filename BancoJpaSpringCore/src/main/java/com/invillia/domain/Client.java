package com.invillia.domain;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.StringJoiner;

@Component
@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_client;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "cpf", nullable = false, length = 11)
    private String cpf;

    public Client(){
    }

    public Client(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return new StringJoiner("\n", "\nDados do cliente\n", "")
                //.add("id_client=" + id_client)
                .add("Nome: '" + name + "'")
                .add("CPF: '" + cpf + "'")
                .toString();
    }

    public long getId_client() {
        return id_client;
    }

    public void setId_client(long id_client) {
        this.id_client = id_client;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
