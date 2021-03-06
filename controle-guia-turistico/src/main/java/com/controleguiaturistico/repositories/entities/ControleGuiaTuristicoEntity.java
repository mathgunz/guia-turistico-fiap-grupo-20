package com.controleguiaturistico.repositories.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity(name = "controleGuiaTuristico")
@Table(name = "controle_guia_turistico", schema = "controle_guia_fiap")
public class ControleGuiaTuristicoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private ClienteEntity cliente;
    @Embedded
    private GuiaEntity guia;
    @Temporal(TemporalType.DATE)
    private Date checkin;
    @Temporal(TemporalType.DATE)
    private Date checkout;
    @Enumerated(EnumType.STRING)
    private ControleGuiaStatus status;
    @Temporal(TemporalType.DATE)
    private Date criacao;

    @OneToMany(mappedBy = "controle")
    private List<RoteiroEntity> roteiros;

    public ControleGuiaTuristicoEntity() {
    }

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

    public ControleGuiaStatus getStatus() {
        return status;
    }

    public void setStatus(ControleGuiaStatus status) {
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
