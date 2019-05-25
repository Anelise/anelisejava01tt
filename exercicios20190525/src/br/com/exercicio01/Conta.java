package br.com.exercicio01;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class Conta {
    private String nomeTitular;
    private long numeroConta;
    private int codigoAgencia;
    private double saldo;
    private LocalDate dataabertura;

    public Conta(String nTitular, long nConta, int agencia, double saldo ){
        this.setNomeTitular(nTitular);
        this.setNumeroConta(nConta);
        this.setCodigoAgencia(agencia);
        this.setSaldo(saldo);
        this.setDataabertura(LocalDate.now().withMonth(1).withDayOfMonth(1).withYear(2000));
        System.out.println("Data inicio da conta"+ this.getDataabertura().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public int getCodigoAgencia() {
        return codigoAgencia;
    }

    public void setCodigoAgencia(int codigoAgencia) {
        this.codigoAgencia = codigoAgencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public LocalDate getDataabertura() {
        return dataabertura;
    }

    public void setDataabertura(LocalDate dataabertura) {
        this.dataabertura = dataabertura;
    }

    public long getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(long numeroConta) {
        this.numeroConta = numeroConta;
    }

    public void retiraValorDoSaldo(int valor){
        if(valor < getSaldo()){
            setSaldo(getSaldo()-valor);
        }
    }

    public void depositaValorDoSaldo(int valor){
        this.setSaldo(this.getSaldo()+valor);
    }

    public double calculaRendimentoMes(){
        LocalDate primeirodiames = LocalDate.now().withMonth(LocalDate.now().getMonth().getValue()).with(TemporalAdjusters.firstDayOfMonth());

        //Verifica se tinha conta desde o inicio do mês
        if(this.dataabertura.isAfter(primeirodiames)){
            return 0;
        }
        //Por todo o mês teve rendimento
        System.out.println("Data PRIM MES"+ primeirodiames.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        return this.getSaldo() * (Indices.calculaJurosMensalPoupanca()/100);
    }

    @Override
    public String toString() {
        String data = getDataabertura().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return getNomeTitular() + "| AG: "+getCodigoAgencia()+ "| CC:"+getNumeroConta()+ "| Saldo: "+getSaldo() + "|"+data;
    }

    public String recuperaDadosParaImpressao(){
        return this.toString();
    }


}
