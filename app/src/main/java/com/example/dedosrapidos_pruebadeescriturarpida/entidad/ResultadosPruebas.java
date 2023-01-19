package com.example.dedosrapidos_pruebadeescriturarpida.entidad;

public class ResultadosPruebas
{
    public int id;
    public String correctos;
    public String incorrectos;
    public String precision;
    public String wpmcpm;

    public ResultadosPruebas()
    {

    }
    public ResultadosPruebas(int id, String correctos, String incorrectos, String precision, String wpmcpm) {
        this.id = id;
        this.correctos = correctos;
        this.incorrectos = incorrectos;
        this.precision = precision;
        this.wpmcpm = wpmcpm;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorrectos() {
        return correctos;
    }

    public void setCorrectos(String correctos) {
        this.correctos = correctos;
    }

    public String getIncorrectos() {
        return incorrectos;
    }

    public void setIncorrectos(String incorrectos) {
        this.incorrectos = incorrectos;
    }

    public String getPrecision() {
        return precision;
    }

    public void setPrecision(String precision) {
        this.precision = precision;
    }

    public String getWpmcpm() {
        return wpmcpm;
    }

    public void setWpmcpm(String wpmcpm) {
        this.wpmcpm = wpmcpm;
    }


}
