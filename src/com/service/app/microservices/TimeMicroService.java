package com.service.app.microservices;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

@Path("/tiempo")
public class TimeMicroService  {



    
    public String getTiempo(){
   Gson gson = new Gson();

        // Obtiene la fecha actual
        LocalDate fechaActual = LocalDate.now();

        // Obtiene el día de la semana
        DayOfWeek diaSemana = fechaActual.getDayOfWeek();

        // Crea un objeto JSON con los valores del sistema
        JsonObject json = new JsonObject();
        json.addProperty("fecha", fechaActual.toString());
        json.addProperty("hora", new SimpleDateFormat("HH:mm:ss").format(new Date()));
        json.addProperty("segundos", (int) (System.currentTimeMillis() / 1000));
        json.addProperty("dia", diaSemana.name());

        // Serializa el objeto JSON a una cadena
        String jsonString = gson.toJson(json);



        return jsonString;
    }
    
}
