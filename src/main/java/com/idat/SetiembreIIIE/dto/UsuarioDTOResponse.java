package com.idat.SetiembreIIIE.dto;

public class UsuarioDTOResponse {
    
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UsuarioDTOResponse() {
        super();
    }

    public UsuarioDTOResponse(String token) {
        super();
        this.token = token;
    }
    
    

}
