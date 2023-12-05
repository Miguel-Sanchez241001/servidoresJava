package com.service.app.microservices;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
@Path("/tiemppo")
public class TimeMicroService  {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String obtenerMensaje() {
        return "¡Hola, mundo!";
    }
    
}
