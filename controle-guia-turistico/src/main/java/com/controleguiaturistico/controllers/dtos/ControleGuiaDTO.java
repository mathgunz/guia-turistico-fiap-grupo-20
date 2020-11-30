package com.controleguiaturistico.controllers.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class ControleGuiaDTO implements Serializable {

    private ClienteDTO cliente;
    private GuiaDTO guia;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date checkin;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date checkout;

    public ControleGuiaDTO() {
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public GuiaDTO getGuia() {
        return guia;
    }

    public void setGuia(GuiaDTO guia) {
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
}
