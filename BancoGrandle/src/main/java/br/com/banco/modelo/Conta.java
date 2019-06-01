package br.com.banco.modelo;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;

public class Conta {
    private long numeroConta;
    private int codigoAgencia;
    private double saldo;
    private LocalDate dataabertura;

    private ArrayList<Movimento> movimentos;

    public Conta(long nConta, int agencia){
        this.setNumeroConta(nConta);
        this.setCodigoAgencia(agencia);
        this.setDataabertura(LocalDate.now().withMonth(1).withDayOfMonth(1).withYear(2000));

        this.movimentos = new ArrayList<>();


    } //System.out.println("Data inicio da conta"+ this.getDataabertura().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

    public ArrayList<Movimento> getMovimentos() {
        return movimentos;
    }

    public void setMovimentos(ArrayList<Movimento> movimentos) {
        this.movimentos = movimentos;
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

    public void retiraValorDoSaldo(double valor){
        if(valor < getSaldo()){
            setSaldo(getSaldo()-valor);
            movimentos.add(new Movimento(Movimento.TipoMovimento.SAQUE,valor, "Movimentação SAQUE"));
        }
    }

    public void depositaValorDoSaldo(double valor){
        this.setSaldo(this.getSaldo()+valor);
        movimentos.add(new Movimento(Movimento.TipoMovimento.DEPOSITO,valor, "Movimentação DEPóSITO"));
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

    public String geraExtrato(){
        String extrato = "";

        for(Movimento m : movimentos){
            extrato += "\n"+m.toString();
        }

        return extrato;
    }
    @Override
    public String toString() {
        String data = getDataabertura().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return " AG: "+getCodigoAgencia()+ "| CC:"+getNumeroConta()+ "| Saldo: "+getSaldo() + "|"+data;
    }

    public String recuperaDadosParaImpressao(){
        return this.toString();
    }


    public enum TipoConta {
        CORRENTE, POUPANCA
    }


}
