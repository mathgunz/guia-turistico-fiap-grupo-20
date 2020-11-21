package com.controleguiaturistico.repositories.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "contratacaoGuiaTuristico")
@Table(name = "contratacao_guia_turistico", schema = "contratacao_guia_fiap")
public class ContratacaoGuiaTuristicoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private ClienteEntity cliente;
    @Embedded
    private GuiaEntity guia;
    private Date checkin;
    private Date checkout;
    private String status;
    private Date criacao;

    @OneToMany(mappedBy = "contratacao")
    private List<RoteiroEntity> roteiros;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public GuiaEntity getGuia() {
        return guia;
    }

    public void setGuia(GuiaEntity guia) {
        this.guia = guia;
    }

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCriacao() {
        return criacao;
    }

    public void setCriacao(Date criacao) {
        this.criacao = criacao;
    }

    public List<RoteiroEntity> getRoteiros() {
        return roteiros;
    }

    public void setRoteiros(List<RoteiroEntity> roteiros) {
        this.roteiros = roteiros;
    }
}
