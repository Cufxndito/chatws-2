package org.example.chatws.entity;

public class ChatMessage {
    private String usuario;
    private String contenido;
    private String tipo;

    public ChatMessage() {
    }

    public ChatMessage(String usuario, String contenido, String tipo) {
        this.usuario = usuario;
        this.contenido = contenido;
        this.tipo = tipo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
