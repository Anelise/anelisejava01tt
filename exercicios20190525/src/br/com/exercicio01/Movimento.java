package br.com.exercicio01;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Movimento {
    private LocalDate dataMovimento;
    private TipoMovimento tipo;
    private double valorMovimento;


    public Movimento( LocalDate data, TipoMovimento tipo, double valorMovimento, String descricao) {
        this.dataMovimento = data;
        this.tipo = tipo;
        this.valorMovimento = valorMovimento;

    }

    public Movimento( TipoMovimento tipo, double valorMovimento, String descricao) {
        this.dataMovimento = LocalDate.now();
        this.tipo = tipo;
        this.valorMovimento = valorMovimento;

    }

    public LocalDate getDataMovimento() {
        return dataMovimento;
    }

    public void setDataMovimento(LocalDate dataMovimento) {
        this.dataMovimento = dataMovimento;
    }

    public TipoMovimento getTipo() {
        return tipo;
    }

    public void setTipo(TipoMovimento tipo) {
        this.tipo = tipo;
    }

    public double getValorMovimento() {
        return valorMovimento;
    }

    public void setValorMovimento(double valorMovimento) {
        this.valorMovimento = valorMovimento;
    }




    public enum TipoMovimento{
        SAQUE, DEPOSITO
    }

    @Override
    public String toString() {
        String data = this.dataMovimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return "["+data+"] "+tipo.name()+" - "+valorMovimento;
    }
}
